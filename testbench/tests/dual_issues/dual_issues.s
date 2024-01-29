// SPDX-License-Identifier: Apache-2.0
// Copyright 2019 Western Digital Corporation or its affiliates.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

// Assembly code for Hello World
// Not using only ALU ops for creating the string


#include "defines.h"

#define STDOUT 0xd0580000
#define CONST1 0x40
#define CONST2 0X80

#define RES1 (CONST1*CONST1)
#define RES2 (CONST1*CONST2)

// Code to execute
.section .text
.global _start
_start:

    // Clear minstret
    csrw minstret, zero
    csrw minstreth, zero

    // Set up MTVEC - not expecting to use it though
    li x1, RV_ICCM_SADR
    csrw mtvec, x1


    // Enable Caches in MRAC
    li x1, 0x5f555555
    csrw 0x7c0, x1

    // Load string from hw_data
    // and write to stdout address

    li x3, STDOUT
    la x4, hw_data
    li x9, RES1
    li x10, RES2
TC_ds:
    li x6, CONST1
    mv x7,x6
    li x8, CONST2
    mul x7,x7,x6
    mul x8,x8,x6
    mul x12,x8,x6
    mul x13,x7,x6
    li x1,0
    bne x7,x9,_failed
    addi x1,x1,1
    bne x8,x10,_failed
loop:
   lb x5, 0(x4)
   sb x5, 0(x3)
   addi x4, x4, 1
   bnez x5, loop

// Write 0xff to STDOUT for TB to terminate test.
_finish:
    li x3, STDOUT
    addi x5, x0, 0xff
    sb x5, 0(x3)
    beq x0, x0, _finish
_failed:
    la x4,err
_print:
   mv x5,x1
   addi x5,x5,48
   sb x5,0(x3)
   j loop
.rept 100
    nop
.endr

.global hw_data
.global err
.data
err:
.ascii " test failded\n"
.byte 0
hw_data:
.ascii "-------------------------\n"
.ascii "DualIssues testcases passed\n"
.ascii "-------------------------\n"
.byte 0
