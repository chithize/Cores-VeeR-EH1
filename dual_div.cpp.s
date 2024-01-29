# 0 "/data2/open-riscv/acemicro/acemicro_m1/m1-v0/testbench/tests/dual_div/dual_div.s"
# 0 "<built-in>"
# 0 "<command-line>"
# 1 "/data2/open-riscv/acemicro/acemicro_m1/m1-v0/testbench/tests/dual_div/dual_div.s"
# 21 "/data2/open-riscv/acemicro/acemicro_m1/m1-v0/testbench/tests/dual_div/dual_div.s"
# 1 "snapshots/default/defines.h" 1
# 22 "/data2/open-riscv/acemicro/acemicro_m1/m1-v0/testbench/tests/dual_div/dual_div.s" 2
# 31 "/data2/open-riscv/acemicro/acemicro_m1/m1-v0/testbench/tests/dual_div/dual_div.s"
.section .text
.global _start
_start:


    csrw minstret, zero
    csrw minstreth, zero


    li x1, 0xee000000
    csrw mtvec, x1



    li x1, 0x5f555555
    csrw 0x7c0, x1




    li x3, 0xd0580000
    la x4, hw_data
    li x9, (0x4488*0x4488)
    li x10, (0x4488*0x11)
TC_ds:
    li x6, 0x4488
    mv x7,x6
    li x8, 0x11
    mul x7,x7,x6
    mul x9,x8,x6
    div x12,x7,x6
    div x13,x9,x6
    li x1,0
    bne x12,x6,_failed
    addi x1,x1,1
    bne x13,x8,_failed
loop:
   lb x5, 0(x4)
   sb x5, 0(x3)
   addi x4, x4, 1
   bnez x5, loop


_finish:
    li x3, 0xd0580000
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
.ascii "Dual Div Testcases passed\n"
.ascii "-------------------------\n"
.byte 0
