/*
module XACC_Regfile_vec_core (rd0_addr_C9, 
rd1_addr_C9, 
rd2_addr_C9, 
rd3_addr_C9, 
rd4_addr_C9, 
rd5_addr_C9, 
rd6_addr_C9, 
wr0_addr_C13, 
wr0_we_C13, 
wr0_data_C13, 
wr1_addr_C13, 
wr1_we_C13, 
wr1_data_C13, 
wr2_addr_C15, 
wr2_we_C15, 
wr2_data_C15, 
wr3_addr_C14, 
wr3_we_C14, 
wr3_data_C14, 
localReset, 
clk, 
clkEN, 
rd0_data_C9, 
rd1_data_C9, 
rd2_data_C9, 
rd3_data_C9, 
rd4_data_C9, 
rd5_data_C9, 
rd6_data_C9);
input [4:0] rd0_addr_C9;
input [4:0] rd1_addr_C9;
input [4:0] rd2_addr_C9;
input [4:0] rd3_addr_C9;
input [4:0] rd4_addr_C9;
input [4:0] rd5_addr_C9;
input [4:0] rd6_addr_C9;
input [4:0] wr0_addr_C13;
input [15:0] wr0_we_C13;
input [127:0] wr0_data_C13;
input [4:0] wr1_addr_C13;
input [15:0] wr1_we_C13;
input [127:0] wr1_data_C13;
input [4:0] wr2_addr_C15;
input [15:0] wr2_we_C15;
input [127:0] wr2_data_C15;
input [4:0] wr3_addr_C14;
input [15:0] wr3_we_C14;
input [127:0] wr3_data_C14;
input  localReset;
input  clk;
input  clkEN;
output [127:0] rd0_data_C9;
output [127:0] rd1_data_C9;
output [127:0] rd2_data_C9;
output [127:0] rd3_data_C9;
output [127:0] rd4_data_C9;
output [127:0] rd5_data_C9;
output [127:0] rd6_data_C9;

    wire [15:0] wr0_word_we0_C13 = wr0_we_C13 & {16{(wr0_addr_C13 == 5'd0)}};
    wire [15:0] wr1_word_we0_C13 = wr1_we_C13 & {16{(wr1_addr_C13 == 5'd0)}};
    wire [15:0] wr2_word_we0_C15 = wr2_we_C15 & {16{(wr2_addr_C15 == 5'd0)}};
    wire [15:0] wr3_word_we0_C14 = wr3_we_C14 & {16{(wr3_addr_C14 == 5'd0)}};
    wire [15:0] word0_we = 16'b0 | wr0_word_we0_C13 | wr1_word_we0_C13 | wr2_word_we0_C15 | wr3_word_we0_C14;
    wire gclk0_0;
assign gclk0_0 = word0_we[0];
    wire gclk0_1;
assign gclk0_1 = word0_we[1];
    wire gclk0_2;
assign gclk0_2 = word0_we[2];
    wire gclk0_3;
assign gclk0_3 = word0_we[3];
    wire gclk0_4;
assign gclk0_4 = word0_we[4];
    wire gclk0_5;
assign gclk0_5 = word0_we[5];
    wire gclk0_6;
assign gclk0_6 = word0_we[6];
    wire gclk0_7;
assign gclk0_7 = word0_we[7];
    wire gclk0_8;
assign gclk0_8 = word0_we[8];
    wire gclk0_9;
assign gclk0_9 = word0_we[9];
    wire gclk0_10;
assign gclk0_10 = word0_we[10];
    wire gclk0_11;
assign gclk0_11 = word0_we[11];
    wire gclk0_12;
assign gclk0_12 = word0_we[12];
    wire gclk0_13;
assign gclk0_13 = word0_we[13];
    wire gclk0_14;
assign gclk0_14 = word0_we[14];
    wire gclk0_15;
assign gclk0_15 = word0_we[15];
    wire [127:0] wmux0;
    reg [7:0] xtmux_1059;
    always @(*) begin
        xtmux_1059 = 8'b0;
        case({wr0_word_we0_C13[0],
            wr1_word_we0_C13[0],
            wr2_word_we0_C15[0],
            wr3_word_we0_C14[0]}) 
/* synopsys full_case */
            4'b1000: xtmux_1059 = wr0_data_C13[7:0];
            4'b0100: xtmux_1059 = wr1_data_C13[7:0];
            4'b0010: xtmux_1059 = wr2_data_C15[7:0];
            4'b0001: xtmux_1059 = wr3_data_C14[7:0];
        endcase
    end
    assign wmux0[7:0] = xtmux_1059;

    reg [7:0] xtmux_1060;
    always @(*) begin
        xtmux_1060 = 8'b0;
        case({wr0_word_we0_C13[1],
            wr1_word_we0_C13[1],
            wr2_word_we0_C15[1],
            wr3_word_we0_C14[1]}) 
/* synopsys full_case */
            4'b1000: xtmux_1060 = wr0_data_C13[15:8];
            4'b0100: xtmux_1060 = wr1_data_C13[15:8];
            4'b0010: xtmux_1060 = wr2_data_C15[15:8];
            4'b0001: xtmux_1060 = wr3_data_C14[15:8];
        endcase
    end
    assign wmux0[15:8] = xtmux_1060;

    reg [7:0] xtmux_1061;
    always @(*) begin
        xtmux_1061 = 8'b0;
        case({wr0_word_we0_C13[2],
            wr1_word_we0_C13[2],
            wr2_word_we0_C15[2],
            wr3_word_we0_C14[2]}) 
/* synopsys full_case */
            4'b1000: xtmux_1061 = wr0_data_C13[23:16];
            4'b0100: xtmux_1061 = wr1_data_C13[23:16];
            4'b0010: xtmux_1061 = wr2_data_C15[23:16];
            4'b0001: xtmux_1061 = wr3_data_C14[23:16];
        endcase
    end
    assign wmux0[23:16] = xtmux_1061;

    reg [7:0] xtmux_1062;
    always @(*) begin
        xtmux_1062 = 8'b0;
        case({wr0_word_we0_C13[3],
            wr1_word_we0_C13[3],
            wr2_word_we0_C15[3],
            wr3_word_we0_C14[3]}) 
/* synopsys full_case */
            4'b1000: xtmux_1062 = wr0_data_C13[31:24];
            4'b0100: xtmux_1062 = wr1_data_C13[31:24];
            4'b0010: xtmux_1062 = wr2_data_C15[31:24];
            4'b0001: xtmux_1062 = wr3_data_C14[31:24];
        endcase
    end
    assign wmux0[31:24] = xtmux_1062;

    reg [7:0] xtmux_1063;
    always @(*) begin
        xtmux_1063 = 8'b0;
        case({wr0_word_we0_C13[4],
            wr1_word_we0_C13[4],
            wr2_word_we0_C15[4],
            wr3_word_we0_C14[4]}) 
/* synopsys full_case */
            4'b1000: xtmux_1063 = wr0_data_C13[39:32];
            4'b0100: xtmux_1063 = wr1_data_C13[39:32];
            4'b0010: xtmux_1063 = wr2_data_C15[39:32];
            4'b0001: xtmux_1063 = wr3_data_C14[39:32];
        endcase
    end
    assign wmux0[39:32] = xtmux_1063;

    reg [7:0] xtmux_1064;
    always @(*) begin
        xtmux_1064 = 8'b0;
        case({wr0_word_we0_C13[5],
            wr1_word_we0_C13[5],
            wr2_word_we0_C15[5],
            wr3_word_we0_C14[5]}) 
/* synopsys full_case */
            4'b1000: xtmux_1064 = wr0_data_C13[47:40];
            4'b0100: xtmux_1064 = wr1_data_C13[47:40];
            4'b0010: xtmux_1064 = wr2_data_C15[47:40];
            4'b0001: xtmux_1064 = wr3_data_C14[47:40];
        endcase
    end
    assign wmux0[47:40] = xtmux_1064;

    reg [7:0] xtmux_1065;
    always @(*) begin
        xtmux_1065 = 8'b0;
        case({wr0_word_we0_C13[6],
            wr1_word_we0_C13[6],
            wr2_word_we0_C15[6],
            wr3_word_we0_C14[6]}) 
/* synopsys full_case */
            4'b1000: xtmux_1065 = wr0_data_C13[55:48];
            4'b0100: xtmux_1065 = wr1_data_C13[55:48];
            4'b0010: xtmux_1065 = wr2_data_C15[55:48];
            4'b0001: xtmux_1065 = wr3_data_C14[55:48];
        endcase
    end
    assign wmux0[55:48] = xtmux_1065;

    reg [7:0] xtmux_1066;
    always @(*) begin
        xtmux_1066 = 8'b0;
        case({wr0_word_we0_C13[7],
            wr1_word_we0_C13[7],
            wr2_word_we0_C15[7],
            wr3_word_we0_C14[7]}) 
/* synopsys full_case */
            4'b1000: xtmux_1066 = wr0_data_C13[63:56];
            4'b0100: xtmux_1066 = wr1_data_C13[63:56];
            4'b0010: xtmux_1066 = wr2_data_C15[63:56];
            4'b0001: xtmux_1066 = wr3_data_C14[63:56];
        endcase
    end
    assign wmux0[63:56] = xtmux_1066;

    reg [7:0] xtmux_1067;
    always @(*) begin
        xtmux_1067 = 8'b0;
        case({wr0_word_we0_C13[8],
            wr1_word_we0_C13[8],
            wr2_word_we0_C15[8],
            wr3_word_we0_C14[8]}) 
/* synopsys full_case */
            4'b1000: xtmux_1067 = wr0_data_C13[71:64];
            4'b0100: xtmux_1067 = wr1_data_C13[71:64];
            4'b0010: xtmux_1067 = wr2_data_C15[71:64];
            4'b0001: xtmux_1067 = wr3_data_C14[71:64];
        endcase
    end
    assign wmux0[71:64] = xtmux_1067;

    reg [7:0] xtmux_1068;
    always @(*) begin
        xtmux_1068 = 8'b0;
        case({wr0_word_we0_C13[9],
            wr1_word_we0_C13[9],
            wr2_word_we0_C15[9],
            wr3_word_we0_C14[9]}) 
/* synopsys full_case */
            4'b1000: xtmux_1068 = wr0_data_C13[79:72];
            4'b0100: xtmux_1068 = wr1_data_C13[79:72];
            4'b0010: xtmux_1068 = wr2_data_C15[79:72];
            4'b0001: xtmux_1068 = wr3_data_C14[79:72];
        endcase
    end
    assign wmux0[79:72] = xtmux_1068;

    reg [7:0] xtmux_1069;
    always @(*) begin
        xtmux_1069 = 8'b0;
        case({wr0_word_we0_C13[10],
            wr1_word_we0_C13[10],
            wr2_word_we0_C15[10],
            wr3_word_we0_C14[10]}) 
/* synopsys full_case */
            4'b1000: xtmux_1069 = wr0_data_C13[87:80];
            4'b0100: xtmux_1069 = wr1_data_C13[87:80];
            4'b0010: xtmux_1069 = wr2_data_C15[87:80];
            4'b0001: xtmux_1069 = wr3_data_C14[87:80];
        endcase
    end
    assign wmux0[87:80] = xtmux_1069;

    reg [7:0] xtmux_1070;
    always @(*) begin
        xtmux_1070 = 8'b0;
        case({wr0_word_we0_C13[11],
            wr1_word_we0_C13[11],
            wr2_word_we0_C15[11],
            wr3_word_we0_C14[11]}) 
/* synopsys full_case */
            4'b1000: xtmux_1070 = wr0_data_C13[95:88];
            4'b0100: xtmux_1070 = wr1_data_C13[95:88];
            4'b0010: xtmux_1070 = wr2_data_C15[95:88];
            4'b0001: xtmux_1070 = wr3_data_C14[95:88];
        endcase
    end
    assign wmux0[95:88] = xtmux_1070;

    reg [7:0] xtmux_1071;
    always @(*) begin
        xtmux_1071 = 8'b0;
        case({wr0_word_we0_C13[12],
            wr1_word_we0_C13[12],
            wr2_word_we0_C15[12],
            wr3_word_we0_C14[12]}) 
/* synopsys full_case */
            4'b1000: xtmux_1071 = wr0_data_C13[103:96];
            4'b0100: xtmux_1071 = wr1_data_C13[103:96];
            4'b0010: xtmux_1071 = wr2_data_C15[103:96];
            4'b0001: xtmux_1071 = wr3_data_C14[103:96];
        endcase
    end
    assign wmux0[103:96] = xtmux_1071;

    reg [7:0] xtmux_1072;
    always @(*) begin
        xtmux_1072 = 8'b0;
        case({wr0_word_we0_C13[13],
            wr1_word_we0_C13[13],
            wr2_word_we0_C15[13],
            wr3_word_we0_C14[13]}) 
/* synopsys full_case */
            4'b1000: xtmux_1072 = wr0_data_C13[111:104];
            4'b0100: xtmux_1072 = wr1_data_C13[111:104];
            4'b0010: xtmux_1072 = wr2_data_C15[111:104];
            4'b0001: xtmux_1072 = wr3_data_C14[111:104];
        endcase
    end
    assign wmux0[111:104] = xtmux_1072;

    reg [7:0] xtmux_1073;
    always @(*) begin
        xtmux_1073 = 8'b0;
        case({wr0_word_we0_C13[14],
            wr1_word_we0_C13[14],
            wr2_word_we0_C15[14],
            wr3_word_we0_C14[14]}) 
/* synopsys full_case */
            4'b1000: xtmux_1073 = wr0_data_C13[119:112];
            4'b0100: xtmux_1073 = wr1_data_C13[119:112];
            4'b0010: xtmux_1073 = wr2_data_C15[119:112];
            4'b0001: xtmux_1073 = wr3_data_C14[119:112];
        endcase
    end
    assign wmux0[119:112] = xtmux_1073;

    reg [7:0] xtmux_1074;
    always @(*) begin
        xtmux_1074 = 8'b0;
        case({wr0_word_we0_C13[15],
            wr1_word_we0_C13[15],
            wr2_word_we0_C15[15],
            wr3_word_we0_C14[15]}) 
/* synopsys full_case */
            4'b1000: xtmux_1074 = wr0_data_C13[127:120];
            4'b0100: xtmux_1074 = wr1_data_C13[127:120];
            4'b0010: xtmux_1074 = wr2_data_C15[127:120];
            4'b0001: xtmux_1074 = wr3_data_C14[127:120];
        endcase
    end
    assign wmux0[127:120] = xtmux_1074;

    wire [127:0] word0;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word0_p0;
    assign word0[7:0] = XACC_reg_word0_p0;
    always @(posedge clk or posedge localReset)
        XACC_reg_word0_p0 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk0_0) ? wmux0[7:0] : XACC_reg_word0_p0;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word0_p1;
    assign word0[15:8] = XACC_reg_word0_p1;
    always @(posedge clk or posedge localReset)
        XACC_reg_word0_p1 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk0_1) ? wmux0[15:8] : XACC_reg_word0_p1;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word0_p2;
    assign word0[23:16] = XACC_reg_word0_p2;
    always @(posedge clk or posedge localReset)
        XACC_reg_word0_p2 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk0_2) ? wmux0[23:16] : XACC_reg_word0_p2;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word0_p3;
    assign word0[31:24] = XACC_reg_word0_p3;
    always @(posedge clk or posedge localReset)
        XACC_reg_word0_p3 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk0_3) ? wmux0[31:24] : XACC_reg_word0_p3;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word0_p4;
    assign word0[39:32] = XACC_reg_word0_p4;
    always @(posedge clk or posedge localReset)
        XACC_reg_word0_p4 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk0_4) ? wmux0[39:32] : XACC_reg_word0_p4;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word0_p5;
    assign word0[47:40] = XACC_reg_word0_p5;
    always @(posedge clk or posedge localReset)
        XACC_reg_word0_p5 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk0_5) ? wmux0[47:40] : XACC_reg_word0_p5;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word0_p6;
    assign word0[55:48] = XACC_reg_word0_p6;
    always @(posedge clk or posedge localReset)
        XACC_reg_word0_p6 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk0_6) ? wmux0[55:48] : XACC_reg_word0_p6;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word0_p7;
    assign word0[63:56] = XACC_reg_word0_p7;
    always @(posedge clk or posedge localReset)
        XACC_reg_word0_p7 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk0_7) ? wmux0[63:56] : XACC_reg_word0_p7;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word0_p8;
    assign word0[71:64] = XACC_reg_word0_p8;
    always @(posedge clk or posedge localReset)
        XACC_reg_word0_p8 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk0_8) ? wmux0[71:64] : XACC_reg_word0_p8;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word0_p9;
    assign word0[79:72] = XACC_reg_word0_p9;
    always @(posedge clk or posedge localReset)
        XACC_reg_word0_p9 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk0_9) ? wmux0[79:72] : XACC_reg_word0_p9;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word0_p10;
    assign word0[87:80] = XACC_reg_word0_p10;
    always @(posedge clk or posedge localReset)
        XACC_reg_word0_p10 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk0_10) ? wmux0[87:80] : XACC_reg_word0_p10;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word0_p11;
    assign word0[95:88] = XACC_reg_word0_p11;
    always @(posedge clk or posedge localReset)
        XACC_reg_word0_p11 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk0_11) ? wmux0[95:88] : XACC_reg_word0_p11;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word0_p12;
    assign word0[103:96] = XACC_reg_word0_p12;
    always @(posedge clk or posedge localReset)
        XACC_reg_word0_p12 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk0_12) ? wmux0[103:96] : XACC_reg_word0_p12;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word0_p13;
    assign word0[111:104] = XACC_reg_word0_p13;
    always @(posedge clk or posedge localReset)
        XACC_reg_word0_p13 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk0_13) ? wmux0[111:104] : XACC_reg_word0_p13;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word0_p14;
    assign word0[119:112] = XACC_reg_word0_p14;
    always @(posedge clk or posedge localReset)
        XACC_reg_word0_p14 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk0_14) ? wmux0[119:112] : XACC_reg_word0_p14;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word0_p15;
    assign word0[127:120] = XACC_reg_word0_p15;
    always @(posedge clk or posedge localReset)
        XACC_reg_word0_p15 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk0_15) ? wmux0[127:120] : XACC_reg_word0_p15;

    wire [15:0] wr0_word_we1_C13 = wr0_we_C13 & {16{(wr0_addr_C13 == 5'd1)}};
    wire [15:0] wr1_word_we1_C13 = wr1_we_C13 & {16{(wr1_addr_C13 == 5'd1)}};
    wire [15:0] wr2_word_we1_C15 = wr2_we_C15 & {16{(wr2_addr_C15 == 5'd1)}};
    wire [15:0] wr3_word_we1_C14 = wr3_we_C14 & {16{(wr3_addr_C14 == 5'd1)}};
    wire [15:0] word1_we = 16'b0 | wr0_word_we1_C13 | wr1_word_we1_C13 | wr2_word_we1_C15 | wr3_word_we1_C14;
    wire gclk1_0;
assign gclk1_0 = word1_we[0];
    wire gclk1_1;
assign gclk1_1 = word1_we[1];
    wire gclk1_2;
assign gclk1_2 = word1_we[2];
    wire gclk1_3;
assign gclk1_3 = word1_we[3];
    wire gclk1_4;
assign gclk1_4 = word1_we[4];
    wire gclk1_5;
assign gclk1_5 = word1_we[5];
    wire gclk1_6;
assign gclk1_6 = word1_we[6];
    wire gclk1_7;
assign gclk1_7 = word1_we[7];
    wire gclk1_8;
assign gclk1_8 = word1_we[8];
    wire gclk1_9;
assign gclk1_9 = word1_we[9];
    wire gclk1_10;
assign gclk1_10 = word1_we[10];
    wire gclk1_11;
assign gclk1_11 = word1_we[11];
    wire gclk1_12;
assign gclk1_12 = word1_we[12];
    wire gclk1_13;
assign gclk1_13 = word1_we[13];
    wire gclk1_14;
assign gclk1_14 = word1_we[14];
    wire gclk1_15;
assign gclk1_15 = word1_we[15];
    wire [127:0] wmux1;
    reg [7:0] xtmux_1075;
    always @(*) begin
        xtmux_1075 = 8'b0;
        case({wr0_word_we1_C13[0],
            wr1_word_we1_C13[0],
            wr2_word_we1_C15[0],
            wr3_word_we1_C14[0]}) 
/* synopsys full_case */
            4'b1000: xtmux_1075 = wr0_data_C13[7:0];
            4'b0100: xtmux_1075 = wr1_data_C13[7:0];
            4'b0010: xtmux_1075 = wr2_data_C15[7:0];
            4'b0001: xtmux_1075 = wr3_data_C14[7:0];
        endcase
    end
    assign wmux1[7:0] = xtmux_1075;

    reg [7:0] xtmux_1076;
    always @(*) begin
        xtmux_1076 = 8'b0;
        case({wr0_word_we1_C13[1],
            wr1_word_we1_C13[1],
            wr2_word_we1_C15[1],
            wr3_word_we1_C14[1]}) 
/* synopsys full_case */
            4'b1000: xtmux_1076 = wr0_data_C13[15:8];
            4'b0100: xtmux_1076 = wr1_data_C13[15:8];
            4'b0010: xtmux_1076 = wr2_data_C15[15:8];
            4'b0001: xtmux_1076 = wr3_data_C14[15:8];
        endcase
    end
    assign wmux1[15:8] = xtmux_1076;

    reg [7:0] xtmux_1077;
    always @(*) begin
        xtmux_1077 = 8'b0;
        case({wr0_word_we1_C13[2],
            wr1_word_we1_C13[2],
            wr2_word_we1_C15[2],
            wr3_word_we1_C14[2]}) 
/* synopsys full_case */
            4'b1000: xtmux_1077 = wr0_data_C13[23:16];
            4'b0100: xtmux_1077 = wr1_data_C13[23:16];
            4'b0010: xtmux_1077 = wr2_data_C15[23:16];
            4'b0001: xtmux_1077 = wr3_data_C14[23:16];
        endcase
    end
    assign wmux1[23:16] = xtmux_1077;

    reg [7:0] xtmux_1078;
    always @(*) begin
        xtmux_1078 = 8'b0;
        case({wr0_word_we1_C13[3],
            wr1_word_we1_C13[3],
            wr2_word_we1_C15[3],
            wr3_word_we1_C14[3]}) 
/* synopsys full_case */
            4'b1000: xtmux_1078 = wr0_data_C13[31:24];
            4'b0100: xtmux_1078 = wr1_data_C13[31:24];
            4'b0010: xtmux_1078 = wr2_data_C15[31:24];
            4'b0001: xtmux_1078 = wr3_data_C14[31:24];
        endcase
    end
    assign wmux1[31:24] = xtmux_1078;

    reg [7:0] xtmux_1079;
    always @(*) begin
        xtmux_1079 = 8'b0;
        case({wr0_word_we1_C13[4],
            wr1_word_we1_C13[4],
            wr2_word_we1_C15[4],
            wr3_word_we1_C14[4]}) 
/* synopsys full_case */
            4'b1000: xtmux_1079 = wr0_data_C13[39:32];
            4'b0100: xtmux_1079 = wr1_data_C13[39:32];
            4'b0010: xtmux_1079 = wr2_data_C15[39:32];
            4'b0001: xtmux_1079 = wr3_data_C14[39:32];
        endcase
    end
    assign wmux1[39:32] = xtmux_1079;

    reg [7:0] xtmux_1080;
    always @(*) begin
        xtmux_1080 = 8'b0;
        case({wr0_word_we1_C13[5],
            wr1_word_we1_C13[5],
            wr2_word_we1_C15[5],
            wr3_word_we1_C14[5]}) 
/* synopsys full_case */
            4'b1000: xtmux_1080 = wr0_data_C13[47:40];
            4'b0100: xtmux_1080 = wr1_data_C13[47:40];
            4'b0010: xtmux_1080 = wr2_data_C15[47:40];
            4'b0001: xtmux_1080 = wr3_data_C14[47:40];
        endcase
    end
    assign wmux1[47:40] = xtmux_1080;

    reg [7:0] xtmux_1081;
    always @(*) begin
        xtmux_1081 = 8'b0;
        case({wr0_word_we1_C13[6],
            wr1_word_we1_C13[6],
            wr2_word_we1_C15[6],
            wr3_word_we1_C14[6]}) 
/* synopsys full_case */
            4'b1000: xtmux_1081 = wr0_data_C13[55:48];
            4'b0100: xtmux_1081 = wr1_data_C13[55:48];
            4'b0010: xtmux_1081 = wr2_data_C15[55:48];
            4'b0001: xtmux_1081 = wr3_data_C14[55:48];
        endcase
    end
    assign wmux1[55:48] = xtmux_1081;

    reg [7:0] xtmux_1082;
    always @(*) begin
        xtmux_1082 = 8'b0;
        case({wr0_word_we1_C13[7],
            wr1_word_we1_C13[7],
            wr2_word_we1_C15[7],
            wr3_word_we1_C14[7]}) 
/* synopsys full_case */
            4'b1000: xtmux_1082 = wr0_data_C13[63:56];
            4'b0100: xtmux_1082 = wr1_data_C13[63:56];
            4'b0010: xtmux_1082 = wr2_data_C15[63:56];
            4'b0001: xtmux_1082 = wr3_data_C14[63:56];
        endcase
    end
    assign wmux1[63:56] = xtmux_1082;

    reg [7:0] xtmux_1083;
    always @(*) begin
        xtmux_1083 = 8'b0;
        case({wr0_word_we1_C13[8],
            wr1_word_we1_C13[8],
            wr2_word_we1_C15[8],
            wr3_word_we1_C14[8]}) 
/* synopsys full_case */
            4'b1000: xtmux_1083 = wr0_data_C13[71:64];
            4'b0100: xtmux_1083 = wr1_data_C13[71:64];
            4'b0010: xtmux_1083 = wr2_data_C15[71:64];
            4'b0001: xtmux_1083 = wr3_data_C14[71:64];
        endcase
    end
    assign wmux1[71:64] = xtmux_1083;

    reg [7:0] xtmux_1084;
    always @(*) begin
        xtmux_1084 = 8'b0;
        case({wr0_word_we1_C13[9],
            wr1_word_we1_C13[9],
            wr2_word_we1_C15[9],
            wr3_word_we1_C14[9]}) 
/* synopsys full_case */
            4'b1000: xtmux_1084 = wr0_data_C13[79:72];
            4'b0100: xtmux_1084 = wr1_data_C13[79:72];
            4'b0010: xtmux_1084 = wr2_data_C15[79:72];
            4'b0001: xtmux_1084 = wr3_data_C14[79:72];
        endcase
    end
    assign wmux1[79:72] = xtmux_1084;

    reg [7:0] xtmux_1085;
    always @(*) begin
        xtmux_1085 = 8'b0;
        case({wr0_word_we1_C13[10],
            wr1_word_we1_C13[10],
            wr2_word_we1_C15[10],
            wr3_word_we1_C14[10]}) 
/* synopsys full_case */
            4'b1000: xtmux_1085 = wr0_data_C13[87:80];
            4'b0100: xtmux_1085 = wr1_data_C13[87:80];
            4'b0010: xtmux_1085 = wr2_data_C15[87:80];
            4'b0001: xtmux_1085 = wr3_data_C14[87:80];
        endcase
    end
    assign wmux1[87:80] = xtmux_1085;

    reg [7:0] xtmux_1086;
    always @(*) begin
        xtmux_1086 = 8'b0;
        case({wr0_word_we1_C13[11],
            wr1_word_we1_C13[11],
            wr2_word_we1_C15[11],
            wr3_word_we1_C14[11]}) 
/* synopsys full_case */
            4'b1000: xtmux_1086 = wr0_data_C13[95:88];
            4'b0100: xtmux_1086 = wr1_data_C13[95:88];
            4'b0010: xtmux_1086 = wr2_data_C15[95:88];
            4'b0001: xtmux_1086 = wr3_data_C14[95:88];
        endcase
    end
    assign wmux1[95:88] = xtmux_1086;

    reg [7:0] xtmux_1087;
    always @(*) begin
        xtmux_1087 = 8'b0;
        case({wr0_word_we1_C13[12],
            wr1_word_we1_C13[12],
            wr2_word_we1_C15[12],
            wr3_word_we1_C14[12]}) 
/* synopsys full_case */
            4'b1000: xtmux_1087 = wr0_data_C13[103:96];
            4'b0100: xtmux_1087 = wr1_data_C13[103:96];
            4'b0010: xtmux_1087 = wr2_data_C15[103:96];
            4'b0001: xtmux_1087 = wr3_data_C14[103:96];
        endcase
    end
    assign wmux1[103:96] = xtmux_1087;

    reg [7:0] xtmux_1088;
    always @(*) begin
        xtmux_1088 = 8'b0;
        case({wr0_word_we1_C13[13],
            wr1_word_we1_C13[13],
            wr2_word_we1_C15[13],
            wr3_word_we1_C14[13]}) 
/* synopsys full_case */
            4'b1000: xtmux_1088 = wr0_data_C13[111:104];
            4'b0100: xtmux_1088 = wr1_data_C13[111:104];
            4'b0010: xtmux_1088 = wr2_data_C15[111:104];
            4'b0001: xtmux_1088 = wr3_data_C14[111:104];
        endcase
    end
    assign wmux1[111:104] = xtmux_1088;

    reg [7:0] xtmux_1089;
    always @(*) begin
        xtmux_1089 = 8'b0;
        case({wr0_word_we1_C13[14],
            wr1_word_we1_C13[14],
            wr2_word_we1_C15[14],
            wr3_word_we1_C14[14]}) 
/* synopsys full_case */
            4'b1000: xtmux_1089 = wr0_data_C13[119:112];
            4'b0100: xtmux_1089 = wr1_data_C13[119:112];
            4'b0010: xtmux_1089 = wr2_data_C15[119:112];
            4'b0001: xtmux_1089 = wr3_data_C14[119:112];
        endcase
    end
    assign wmux1[119:112] = xtmux_1089;

    reg [7:0] xtmux_1090;
    always @(*) begin
        xtmux_1090 = 8'b0;
        case({wr0_word_we1_C13[15],
            wr1_word_we1_C13[15],
            wr2_word_we1_C15[15],
            wr3_word_we1_C14[15]}) 
/* synopsys full_case */
            4'b1000: xtmux_1090 = wr0_data_C13[127:120];
            4'b0100: xtmux_1090 = wr1_data_C13[127:120];
            4'b0010: xtmux_1090 = wr2_data_C15[127:120];
            4'b0001: xtmux_1090 = wr3_data_C14[127:120];
        endcase
    end
    assign wmux1[127:120] = xtmux_1090;

    wire [127:0] word1;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word1_p0;
    assign word1[7:0] = XACC_reg_word1_p0;
    always @(posedge clk or posedge localReset)
        XACC_reg_word1_p0 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk1_0) ? wmux1[7:0] : XACC_reg_word1_p0;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word1_p1;
    assign word1[15:8] = XACC_reg_word1_p1;
    always @(posedge clk or posedge localReset)
        XACC_reg_word1_p1 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk1_1) ? wmux1[15:8] : XACC_reg_word1_p1;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word1_p2;
    assign word1[23:16] = XACC_reg_word1_p2;
    always @(posedge clk or posedge localReset)
        XACC_reg_word1_p2 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk1_2) ? wmux1[23:16] : XACC_reg_word1_p2;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word1_p3;
    assign word1[31:24] = XACC_reg_word1_p3;
    always @(posedge clk or posedge localReset)
        XACC_reg_word1_p3 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk1_3) ? wmux1[31:24] : XACC_reg_word1_p3;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word1_p4;
    assign word1[39:32] = XACC_reg_word1_p4;
    always @(posedge clk or posedge localReset)
        XACC_reg_word1_p4 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk1_4) ? wmux1[39:32] : XACC_reg_word1_p4;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word1_p5;
    assign word1[47:40] = XACC_reg_word1_p5;
    always @(posedge clk or posedge localReset)
        XACC_reg_word1_p5 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk1_5) ? wmux1[47:40] : XACC_reg_word1_p5;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word1_p6;
    assign word1[55:48] = XACC_reg_word1_p6;
    always @(posedge clk or posedge localReset)
        XACC_reg_word1_p6 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk1_6) ? wmux1[55:48] : XACC_reg_word1_p6;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word1_p7;
    assign word1[63:56] = XACC_reg_word1_p7;
    always @(posedge clk or posedge localReset)
        XACC_reg_word1_p7 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk1_7) ? wmux1[63:56] : XACC_reg_word1_p7;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word1_p8;
    assign word1[71:64] = XACC_reg_word1_p8;
    always @(posedge clk or posedge localReset)
        XACC_reg_word1_p8 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk1_8) ? wmux1[71:64] : XACC_reg_word1_p8;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word1_p9;
    assign word1[79:72] = XACC_reg_word1_p9;
    always @(posedge clk or posedge localReset)
        XACC_reg_word1_p9 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk1_9) ? wmux1[79:72] : XACC_reg_word1_p9;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word1_p10;
    assign word1[87:80] = XACC_reg_word1_p10;
    always @(posedge clk or posedge localReset)
        XACC_reg_word1_p10 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk1_10) ? wmux1[87:80] : XACC_reg_word1_p10;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word1_p11;
    assign word1[95:88] = XACC_reg_word1_p11;
    always @(posedge clk or posedge localReset)
        XACC_reg_word1_p11 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk1_11) ? wmux1[95:88] : XACC_reg_word1_p11;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word1_p12;
    assign word1[103:96] = XACC_reg_word1_p12;
    always @(posedge clk or posedge localReset)
        XACC_reg_word1_p12 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk1_12) ? wmux1[103:96] : XACC_reg_word1_p12;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word1_p13;
    assign word1[111:104] = XACC_reg_word1_p13;
    always @(posedge clk or posedge localReset)
        XACC_reg_word1_p13 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk1_13) ? wmux1[111:104] : XACC_reg_word1_p13;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word1_p14;
    assign word1[119:112] = XACC_reg_word1_p14;
    always @(posedge clk or posedge localReset)
        XACC_reg_word1_p14 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk1_14) ? wmux1[119:112] : XACC_reg_word1_p14;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word1_p15;
    assign word1[127:120] = XACC_reg_word1_p15;
    always @(posedge clk or posedge localReset)
        XACC_reg_word1_p15 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk1_15) ? wmux1[127:120] : XACC_reg_word1_p15;

    wire [15:0] wr0_word_we2_C13 = wr0_we_C13 & {16{(wr0_addr_C13 == 5'd2)}};
    wire [15:0] wr1_word_we2_C13 = wr1_we_C13 & {16{(wr1_addr_C13 == 5'd2)}};
    wire [15:0] wr2_word_we2_C15 = wr2_we_C15 & {16{(wr2_addr_C15 == 5'd2)}};
    wire [15:0] wr3_word_we2_C14 = wr3_we_C14 & {16{(wr3_addr_C14 == 5'd2)}};
    wire [15:0] word2_we = 16'b0 | wr0_word_we2_C13 | wr1_word_we2_C13 | wr2_word_we2_C15 | wr3_word_we2_C14;
    wire gclk2_0;
assign gclk2_0 = word2_we[0];
    wire gclk2_1;
assign gclk2_1 = word2_we[1];
    wire gclk2_2;
assign gclk2_2 = word2_we[2];
    wire gclk2_3;
assign gclk2_3 = word2_we[3];
    wire gclk2_4;
assign gclk2_4 = word2_we[4];
    wire gclk2_5;
assign gclk2_5 = word2_we[5];
    wire gclk2_6;
assign gclk2_6 = word2_we[6];
    wire gclk2_7;
assign gclk2_7 = word2_we[7];
    wire gclk2_8;
assign gclk2_8 = word2_we[8];
    wire gclk2_9;
assign gclk2_9 = word2_we[9];
    wire gclk2_10;
assign gclk2_10 = word2_we[10];
    wire gclk2_11;
assign gclk2_11 = word2_we[11];
    wire gclk2_12;
assign gclk2_12 = word2_we[12];
    wire gclk2_13;
assign gclk2_13 = word2_we[13];
    wire gclk2_14;
assign gclk2_14 = word2_we[14];
    wire gclk2_15;
assign gclk2_15 = word2_we[15];
    wire [127:0] wmux2;
    reg [7:0] xtmux_1091;
    always @(*) begin
        xtmux_1091 = 8'b0;
        case({wr0_word_we2_C13[0],
            wr1_word_we2_C13[0],
            wr2_word_we2_C15[0],
            wr3_word_we2_C14[0]}) 
/* synopsys full_case */
            4'b1000: xtmux_1091 = wr0_data_C13[7:0];
            4'b0100: xtmux_1091 = wr1_data_C13[7:0];
            4'b0010: xtmux_1091 = wr2_data_C15[7:0];
            4'b0001: xtmux_1091 = wr3_data_C14[7:0];
        endcase
    end
    assign wmux2[7:0] = xtmux_1091;

    reg [7:0] xtmux_1092;
    always @(*) begin
        xtmux_1092 = 8'b0;
        case({wr0_word_we2_C13[1],
            wr1_word_we2_C13[1],
            wr2_word_we2_C15[1],
            wr3_word_we2_C14[1]}) 
/* synopsys full_case */
            4'b1000: xtmux_1092 = wr0_data_C13[15:8];
            4'b0100: xtmux_1092 = wr1_data_C13[15:8];
            4'b0010: xtmux_1092 = wr2_data_C15[15:8];
            4'b0001: xtmux_1092 = wr3_data_C14[15:8];
        endcase
    end
    assign wmux2[15:8] = xtmux_1092;

    reg [7:0] xtmux_1093;
    always @(*) begin
        xtmux_1093 = 8'b0;
        case({wr0_word_we2_C13[2],
            wr1_word_we2_C13[2],
            wr2_word_we2_C15[2],
            wr3_word_we2_C14[2]}) 
/* synopsys full_case */
            4'b1000: xtmux_1093 = wr0_data_C13[23:16];
            4'b0100: xtmux_1093 = wr1_data_C13[23:16];
            4'b0010: xtmux_1093 = wr2_data_C15[23:16];
            4'b0001: xtmux_1093 = wr3_data_C14[23:16];
        endcase
    end
    assign wmux2[23:16] = xtmux_1093;

    reg [7:0] xtmux_1094;
    always @(*) begin
        xtmux_1094 = 8'b0;
        case({wr0_word_we2_C13[3],
            wr1_word_we2_C13[3],
            wr2_word_we2_C15[3],
            wr3_word_we2_C14[3]}) 
/* synopsys full_case */
            4'b1000: xtmux_1094 = wr0_data_C13[31:24];
            4'b0100: xtmux_1094 = wr1_data_C13[31:24];
            4'b0010: xtmux_1094 = wr2_data_C15[31:24];
            4'b0001: xtmux_1094 = wr3_data_C14[31:24];
        endcase
    end
    assign wmux2[31:24] = xtmux_1094;

    reg [7:0] xtmux_1095;
    always @(*) begin
        xtmux_1095 = 8'b0;
        case({wr0_word_we2_C13[4],
            wr1_word_we2_C13[4],
            wr2_word_we2_C15[4],
            wr3_word_we2_C14[4]}) 
/* synopsys full_case */
            4'b1000: xtmux_1095 = wr0_data_C13[39:32];
            4'b0100: xtmux_1095 = wr1_data_C13[39:32];
            4'b0010: xtmux_1095 = wr2_data_C15[39:32];
            4'b0001: xtmux_1095 = wr3_data_C14[39:32];
        endcase
    end
    assign wmux2[39:32] = xtmux_1095;

    reg [7:0] xtmux_1096;
    always @(*) begin
        xtmux_1096 = 8'b0;
        case({wr0_word_we2_C13[5],
            wr1_word_we2_C13[5],
            wr2_word_we2_C15[5],
            wr3_word_we2_C14[5]}) 
/* synopsys full_case */
            4'b1000: xtmux_1096 = wr0_data_C13[47:40];
            4'b0100: xtmux_1096 = wr1_data_C13[47:40];
            4'b0010: xtmux_1096 = wr2_data_C15[47:40];
            4'b0001: xtmux_1096 = wr3_data_C14[47:40];
        endcase
    end
    assign wmux2[47:40] = xtmux_1096;

    reg [7:0] xtmux_1097;
    always @(*) begin
        xtmux_1097 = 8'b0;
        case({wr0_word_we2_C13[6],
            wr1_word_we2_C13[6],
            wr2_word_we2_C15[6],
            wr3_word_we2_C14[6]}) 
/* synopsys full_case */
            4'b1000: xtmux_1097 = wr0_data_C13[55:48];
            4'b0100: xtmux_1097 = wr1_data_C13[55:48];
            4'b0010: xtmux_1097 = wr2_data_C15[55:48];
            4'b0001: xtmux_1097 = wr3_data_C14[55:48];
        endcase
    end
    assign wmux2[55:48] = xtmux_1097;

    reg [7:0] xtmux_1098;
    always @(*) begin
        xtmux_1098 = 8'b0;
        case({wr0_word_we2_C13[7],
            wr1_word_we2_C13[7],
            wr2_word_we2_C15[7],
            wr3_word_we2_C14[7]}) 
/* synopsys full_case */
            4'b1000: xtmux_1098 = wr0_data_C13[63:56];
            4'b0100: xtmux_1098 = wr1_data_C13[63:56];
            4'b0010: xtmux_1098 = wr2_data_C15[63:56];
            4'b0001: xtmux_1098 = wr3_data_C14[63:56];
        endcase
    end
    assign wmux2[63:56] = xtmux_1098;

    reg [7:0] xtmux_1099;
    always @(*) begin
        xtmux_1099 = 8'b0;
        case({wr0_word_we2_C13[8],
            wr1_word_we2_C13[8],
            wr2_word_we2_C15[8],
            wr3_word_we2_C14[8]}) 
/* synopsys full_case */
            4'b1000: xtmux_1099 = wr0_data_C13[71:64];
            4'b0100: xtmux_1099 = wr1_data_C13[71:64];
            4'b0010: xtmux_1099 = wr2_data_C15[71:64];
            4'b0001: xtmux_1099 = wr3_data_C14[71:64];
        endcase
    end
    assign wmux2[71:64] = xtmux_1099;

    reg [7:0] xtmux_1100;
    always @(*) begin
        xtmux_1100 = 8'b0;
        case({wr0_word_we2_C13[9],
            wr1_word_we2_C13[9],
            wr2_word_we2_C15[9],
            wr3_word_we2_C14[9]}) 
/* synopsys full_case */
            4'b1000: xtmux_1100 = wr0_data_C13[79:72];
            4'b0100: xtmux_1100 = wr1_data_C13[79:72];
            4'b0010: xtmux_1100 = wr2_data_C15[79:72];
            4'b0001: xtmux_1100 = wr3_data_C14[79:72];
        endcase
    end
    assign wmux2[79:72] = xtmux_1100;

    reg [7:0] xtmux_1101;
    always @(*) begin
        xtmux_1101 = 8'b0;
        case({wr0_word_we2_C13[10],
            wr1_word_we2_C13[10],
            wr2_word_we2_C15[10],
            wr3_word_we2_C14[10]}) 
/* synopsys full_case */
            4'b1000: xtmux_1101 = wr0_data_C13[87:80];
            4'b0100: xtmux_1101 = wr1_data_C13[87:80];
            4'b0010: xtmux_1101 = wr2_data_C15[87:80];
            4'b0001: xtmux_1101 = wr3_data_C14[87:80];
        endcase
    end
    assign wmux2[87:80] = xtmux_1101;

    reg [7:0] xtmux_1102;
    always @(*) begin
        xtmux_1102 = 8'b0;
        case({wr0_word_we2_C13[11],
            wr1_word_we2_C13[11],
            wr2_word_we2_C15[11],
            wr3_word_we2_C14[11]}) 
/* synopsys full_case */
            4'b1000: xtmux_1102 = wr0_data_C13[95:88];
            4'b0100: xtmux_1102 = wr1_data_C13[95:88];
            4'b0010: xtmux_1102 = wr2_data_C15[95:88];
            4'b0001: xtmux_1102 = wr3_data_C14[95:88];
        endcase
    end
    assign wmux2[95:88] = xtmux_1102;

    reg [7:0] xtmux_1103;
    always @(*) begin
        xtmux_1103 = 8'b0;
        case({wr0_word_we2_C13[12],
            wr1_word_we2_C13[12],
            wr2_word_we2_C15[12],
            wr3_word_we2_C14[12]}) 
/* synopsys full_case */
            4'b1000: xtmux_1103 = wr0_data_C13[103:96];
            4'b0100: xtmux_1103 = wr1_data_C13[103:96];
            4'b0010: xtmux_1103 = wr2_data_C15[103:96];
            4'b0001: xtmux_1103 = wr3_data_C14[103:96];
        endcase
    end
    assign wmux2[103:96] = xtmux_1103;

    reg [7:0] xtmux_1104;
    always @(*) begin
        xtmux_1104 = 8'b0;
        case({wr0_word_we2_C13[13],
            wr1_word_we2_C13[13],
            wr2_word_we2_C15[13],
            wr3_word_we2_C14[13]}) 
/* synopsys full_case */
            4'b1000: xtmux_1104 = wr0_data_C13[111:104];
            4'b0100: xtmux_1104 = wr1_data_C13[111:104];
            4'b0010: xtmux_1104 = wr2_data_C15[111:104];
            4'b0001: xtmux_1104 = wr3_data_C14[111:104];
        endcase
    end
    assign wmux2[111:104] = xtmux_1104;

    reg [7:0] xtmux_1105;
    always @(*) begin
        xtmux_1105 = 8'b0;
        case({wr0_word_we2_C13[14],
            wr1_word_we2_C13[14],
            wr2_word_we2_C15[14],
            wr3_word_we2_C14[14]}) 
/* synopsys full_case */
            4'b1000: xtmux_1105 = wr0_data_C13[119:112];
            4'b0100: xtmux_1105 = wr1_data_C13[119:112];
            4'b0010: xtmux_1105 = wr2_data_C15[119:112];
            4'b0001: xtmux_1105 = wr3_data_C14[119:112];
        endcase
    end
    assign wmux2[119:112] = xtmux_1105;

    reg [7:0] xtmux_1106;
    always @(*) begin
        xtmux_1106 = 8'b0;
        case({wr0_word_we2_C13[15],
            wr1_word_we2_C13[15],
            wr2_word_we2_C15[15],
            wr3_word_we2_C14[15]}) 
/* synopsys full_case */
            4'b1000: xtmux_1106 = wr0_data_C13[127:120];
            4'b0100: xtmux_1106 = wr1_data_C13[127:120];
            4'b0010: xtmux_1106 = wr2_data_C15[127:120];
            4'b0001: xtmux_1106 = wr3_data_C14[127:120];
        endcase
    end
    assign wmux2[127:120] = xtmux_1106;

    wire [127:0] word2;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word2_p0;
    assign word2[7:0] = XACC_reg_word2_p0;
    always @(posedge clk or posedge localReset)
        XACC_reg_word2_p0 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk2_0) ? wmux2[7:0] : XACC_reg_word2_p0;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word2_p1;
    assign word2[15:8] = XACC_reg_word2_p1;
    always @(posedge clk or posedge localReset)
        XACC_reg_word2_p1 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk2_1) ? wmux2[15:8] : XACC_reg_word2_p1;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word2_p2;
    assign word2[23:16] = XACC_reg_word2_p2;
    always @(posedge clk or posedge localReset)
        XACC_reg_word2_p2 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk2_2) ? wmux2[23:16] : XACC_reg_word2_p2;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word2_p3;
    assign word2[31:24] = XACC_reg_word2_p3;
    always @(posedge clk or posedge localReset)
        XACC_reg_word2_p3 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk2_3) ? wmux2[31:24] : XACC_reg_word2_p3;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word2_p4;
    assign word2[39:32] = XACC_reg_word2_p4;
    always @(posedge clk or posedge localReset)
        XACC_reg_word2_p4 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk2_4) ? wmux2[39:32] : XACC_reg_word2_p4;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word2_p5;
    assign word2[47:40] = XACC_reg_word2_p5;
    always @(posedge clk or posedge localReset)
        XACC_reg_word2_p5 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk2_5) ? wmux2[47:40] : XACC_reg_word2_p5;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word2_p6;
    assign word2[55:48] = XACC_reg_word2_p6;
    always @(posedge clk or posedge localReset)
        XACC_reg_word2_p6 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk2_6) ? wmux2[55:48] : XACC_reg_word2_p6;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word2_p7;
    assign word2[63:56] = XACC_reg_word2_p7;
    always @(posedge clk or posedge localReset)
        XACC_reg_word2_p7 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk2_7) ? wmux2[63:56] : XACC_reg_word2_p7;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word2_p8;
    assign word2[71:64] = XACC_reg_word2_p8;
    always @(posedge clk or posedge localReset)
        XACC_reg_word2_p8 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk2_8) ? wmux2[71:64] : XACC_reg_word2_p8;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word2_p9;
    assign word2[79:72] = XACC_reg_word2_p9;
    always @(posedge clk or posedge localReset)
        XACC_reg_word2_p9 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk2_9) ? wmux2[79:72] : XACC_reg_word2_p9;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word2_p10;
    assign word2[87:80] = XACC_reg_word2_p10;
    always @(posedge clk or posedge localReset)
        XACC_reg_word2_p10 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk2_10) ? wmux2[87:80] : XACC_reg_word2_p10;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word2_p11;
    assign word2[95:88] = XACC_reg_word2_p11;
    always @(posedge clk or posedge localReset)
        XACC_reg_word2_p11 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk2_11) ? wmux2[95:88] : XACC_reg_word2_p11;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word2_p12;
    assign word2[103:96] = XACC_reg_word2_p12;
    always @(posedge clk or posedge localReset)
        XACC_reg_word2_p12 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk2_12) ? wmux2[103:96] : XACC_reg_word2_p12;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word2_p13;
    assign word2[111:104] = XACC_reg_word2_p13;
    always @(posedge clk or posedge localReset)
        XACC_reg_word2_p13 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk2_13) ? wmux2[111:104] : XACC_reg_word2_p13;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word2_p14;
    assign word2[119:112] = XACC_reg_word2_p14;
    always @(posedge clk or posedge localReset)
        XACC_reg_word2_p14 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk2_14) ? wmux2[119:112] : XACC_reg_word2_p14;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word2_p15;
    assign word2[127:120] = XACC_reg_word2_p15;
    always @(posedge clk or posedge localReset)
        XACC_reg_word2_p15 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk2_15) ? wmux2[127:120] : XACC_reg_word2_p15;

    wire [15:0] wr0_word_we3_C13 = wr0_we_C13 & {16{(wr0_addr_C13 == 5'd3)}};
    wire [15:0] wr1_word_we3_C13 = wr1_we_C13 & {16{(wr1_addr_C13 == 5'd3)}};
    wire [15:0] wr2_word_we3_C15 = wr2_we_C15 & {16{(wr2_addr_C15 == 5'd3)}};
    wire [15:0] wr3_word_we3_C14 = wr3_we_C14 & {16{(wr3_addr_C14 == 5'd3)}};
    wire [15:0] word3_we = 16'b0 | wr0_word_we3_C13 | wr1_word_we3_C13 | wr2_word_we3_C15 | wr3_word_we3_C14;
    wire gclk3_0;
assign gclk3_0 = word3_we[0];
    wire gclk3_1;
assign gclk3_1 = word3_we[1];
    wire gclk3_2;
assign gclk3_2 = word3_we[2];
    wire gclk3_3;
assign gclk3_3 = word3_we[3];
    wire gclk3_4;
assign gclk3_4 = word3_we[4];
    wire gclk3_5;
assign gclk3_5 = word3_we[5];
    wire gclk3_6;
assign gclk3_6 = word3_we[6];
    wire gclk3_7;
assign gclk3_7 = word3_we[7];
    wire gclk3_8;
assign gclk3_8 = word3_we[8];
    wire gclk3_9;
assign gclk3_9 = word3_we[9];
    wire gclk3_10;
assign gclk3_10 = word3_we[10];
    wire gclk3_11;
assign gclk3_11 = word3_we[11];
    wire gclk3_12;
assign gclk3_12 = word3_we[12];
    wire gclk3_13;
assign gclk3_13 = word3_we[13];
    wire gclk3_14;
assign gclk3_14 = word3_we[14];
    wire gclk3_15;
assign gclk3_15 = word3_we[15];
    wire [127:0] wmux3;
    reg [7:0] xtmux_1107;
    always @(*) begin
        xtmux_1107 = 8'b0;
        case({wr0_word_we3_C13[0],
            wr1_word_we3_C13[0],
            wr2_word_we3_C15[0],
            wr3_word_we3_C14[0]}) 
/* synopsys full_case */
            4'b1000: xtmux_1107 = wr0_data_C13[7:0];
            4'b0100: xtmux_1107 = wr1_data_C13[7:0];
            4'b0010: xtmux_1107 = wr2_data_C15[7:0];
            4'b0001: xtmux_1107 = wr3_data_C14[7:0];
        endcase
    end
    assign wmux3[7:0] = xtmux_1107;

    reg [7:0] xtmux_1108;
    always @(*) begin
        xtmux_1108 = 8'b0;
        case({wr0_word_we3_C13[1],
            wr1_word_we3_C13[1],
            wr2_word_we3_C15[1],
            wr3_word_we3_C14[1]}) 
/* synopsys full_case */
            4'b1000: xtmux_1108 = wr0_data_C13[15:8];
            4'b0100: xtmux_1108 = wr1_data_C13[15:8];
            4'b0010: xtmux_1108 = wr2_data_C15[15:8];
            4'b0001: xtmux_1108 = wr3_data_C14[15:8];
        endcase
    end
    assign wmux3[15:8] = xtmux_1108;

    reg [7:0] xtmux_1109;
    always @(*) begin
        xtmux_1109 = 8'b0;
        case({wr0_word_we3_C13[2],
            wr1_word_we3_C13[2],
            wr2_word_we3_C15[2],
            wr3_word_we3_C14[2]}) 
/* synopsys full_case */
            4'b1000: xtmux_1109 = wr0_data_C13[23:16];
            4'b0100: xtmux_1109 = wr1_data_C13[23:16];
            4'b0010: xtmux_1109 = wr2_data_C15[23:16];
            4'b0001: xtmux_1109 = wr3_data_C14[23:16];
        endcase
    end
    assign wmux3[23:16] = xtmux_1109;

    reg [7:0] xtmux_1110;
    always @(*) begin
        xtmux_1110 = 8'b0;
        case({wr0_word_we3_C13[3],
            wr1_word_we3_C13[3],
            wr2_word_we3_C15[3],
            wr3_word_we3_C14[3]}) 
/* synopsys full_case */
            4'b1000: xtmux_1110 = wr0_data_C13[31:24];
            4'b0100: xtmux_1110 = wr1_data_C13[31:24];
            4'b0010: xtmux_1110 = wr2_data_C15[31:24];
            4'b0001: xtmux_1110 = wr3_data_C14[31:24];
        endcase
    end
    assign wmux3[31:24] = xtmux_1110;

    reg [7:0] xtmux_1111;
    always @(*) begin
        xtmux_1111 = 8'b0;
        case({wr0_word_we3_C13[4],
            wr1_word_we3_C13[4],
            wr2_word_we3_C15[4],
            wr3_word_we3_C14[4]}) 
/* synopsys full_case */
            4'b1000: xtmux_1111 = wr0_data_C13[39:32];
            4'b0100: xtmux_1111 = wr1_data_C13[39:32];
            4'b0010: xtmux_1111 = wr2_data_C15[39:32];
            4'b0001: xtmux_1111 = wr3_data_C14[39:32];
        endcase
    end
    assign wmux3[39:32] = xtmux_1111;

    reg [7:0] xtmux_1112;
    always @(*) begin
        xtmux_1112 = 8'b0;
        case({wr0_word_we3_C13[5],
            wr1_word_we3_C13[5],
            wr2_word_we3_C15[5],
            wr3_word_we3_C14[5]}) 
/* synopsys full_case */
            4'b1000: xtmux_1112 = wr0_data_C13[47:40];
            4'b0100: xtmux_1112 = wr1_data_C13[47:40];
            4'b0010: xtmux_1112 = wr2_data_C15[47:40];
            4'b0001: xtmux_1112 = wr3_data_C14[47:40];
        endcase
    end
    assign wmux3[47:40] = xtmux_1112;

    reg [7:0] xtmux_1113;
    always @(*) begin
        xtmux_1113 = 8'b0;
        case({wr0_word_we3_C13[6],
            wr1_word_we3_C13[6],
            wr2_word_we3_C15[6],
            wr3_word_we3_C14[6]}) 
/* synopsys full_case */
            4'b1000: xtmux_1113 = wr0_data_C13[55:48];
            4'b0100: xtmux_1113 = wr1_data_C13[55:48];
            4'b0010: xtmux_1113 = wr2_data_C15[55:48];
            4'b0001: xtmux_1113 = wr3_data_C14[55:48];
        endcase
    end
    assign wmux3[55:48] = xtmux_1113;

    reg [7:0] xtmux_1114;
    always @(*) begin
        xtmux_1114 = 8'b0;
        case({wr0_word_we3_C13[7],
            wr1_word_we3_C13[7],
            wr2_word_we3_C15[7],
            wr3_word_we3_C14[7]}) 
/* synopsys full_case */
            4'b1000: xtmux_1114 = wr0_data_C13[63:56];
            4'b0100: xtmux_1114 = wr1_data_C13[63:56];
            4'b0010: xtmux_1114 = wr2_data_C15[63:56];
            4'b0001: xtmux_1114 = wr3_data_C14[63:56];
        endcase
    end
    assign wmux3[63:56] = xtmux_1114;

    reg [7:0] xtmux_1115;
    always @(*) begin
        xtmux_1115 = 8'b0;
        case({wr0_word_we3_C13[8],
            wr1_word_we3_C13[8],
            wr2_word_we3_C15[8],
            wr3_word_we3_C14[8]}) 
/* synopsys full_case */
            4'b1000: xtmux_1115 = wr0_data_C13[71:64];
            4'b0100: xtmux_1115 = wr1_data_C13[71:64];
            4'b0010: xtmux_1115 = wr2_data_C15[71:64];
            4'b0001: xtmux_1115 = wr3_data_C14[71:64];
        endcase
    end
    assign wmux3[71:64] = xtmux_1115;

    reg [7:0] xtmux_1116;
    always @(*) begin
        xtmux_1116 = 8'b0;
        case({wr0_word_we3_C13[9],
            wr1_word_we3_C13[9],
            wr2_word_we3_C15[9],
            wr3_word_we3_C14[9]}) 
/* synopsys full_case */
            4'b1000: xtmux_1116 = wr0_data_C13[79:72];
            4'b0100: xtmux_1116 = wr1_data_C13[79:72];
            4'b0010: xtmux_1116 = wr2_data_C15[79:72];
            4'b0001: xtmux_1116 = wr3_data_C14[79:72];
        endcase
    end
    assign wmux3[79:72] = xtmux_1116;

    reg [7:0] xtmux_1117;
    always @(*) begin
        xtmux_1117 = 8'b0;
        case({wr0_word_we3_C13[10],
            wr1_word_we3_C13[10],
            wr2_word_we3_C15[10],
            wr3_word_we3_C14[10]}) 
/* synopsys full_case */
            4'b1000: xtmux_1117 = wr0_data_C13[87:80];
            4'b0100: xtmux_1117 = wr1_data_C13[87:80];
            4'b0010: xtmux_1117 = wr2_data_C15[87:80];
            4'b0001: xtmux_1117 = wr3_data_C14[87:80];
        endcase
    end
    assign wmux3[87:80] = xtmux_1117;

    reg [7:0] xtmux_1118;
    always @(*) begin
        xtmux_1118 = 8'b0;
        case({wr0_word_we3_C13[11],
            wr1_word_we3_C13[11],
            wr2_word_we3_C15[11],
            wr3_word_we3_C14[11]}) 
/* synopsys full_case */
            4'b1000: xtmux_1118 = wr0_data_C13[95:88];
            4'b0100: xtmux_1118 = wr1_data_C13[95:88];
            4'b0010: xtmux_1118 = wr2_data_C15[95:88];
            4'b0001: xtmux_1118 = wr3_data_C14[95:88];
        endcase
    end
    assign wmux3[95:88] = xtmux_1118;

    reg [7:0] xtmux_1119;
    always @(*) begin
        xtmux_1119 = 8'b0;
        case({wr0_word_we3_C13[12],
            wr1_word_we3_C13[12],
            wr2_word_we3_C15[12],
            wr3_word_we3_C14[12]}) 
/* synopsys full_case */
            4'b1000: xtmux_1119 = wr0_data_C13[103:96];
            4'b0100: xtmux_1119 = wr1_data_C13[103:96];
            4'b0010: xtmux_1119 = wr2_data_C15[103:96];
            4'b0001: xtmux_1119 = wr3_data_C14[103:96];
        endcase
    end
    assign wmux3[103:96] = xtmux_1119;

    reg [7:0] xtmux_1120;
    always @(*) begin
        xtmux_1120 = 8'b0;
        case({wr0_word_we3_C13[13],
            wr1_word_we3_C13[13],
            wr2_word_we3_C15[13],
            wr3_word_we3_C14[13]}) 
/* synopsys full_case */
            4'b1000: xtmux_1120 = wr0_data_C13[111:104];
            4'b0100: xtmux_1120 = wr1_data_C13[111:104];
            4'b0010: xtmux_1120 = wr2_data_C15[111:104];
            4'b0001: xtmux_1120 = wr3_data_C14[111:104];
        endcase
    end
    assign wmux3[111:104] = xtmux_1120;

    reg [7:0] xtmux_1121;
    always @(*) begin
        xtmux_1121 = 8'b0;
        case({wr0_word_we3_C13[14],
            wr1_word_we3_C13[14],
            wr2_word_we3_C15[14],
            wr3_word_we3_C14[14]}) 
/* synopsys full_case */
            4'b1000: xtmux_1121 = wr0_data_C13[119:112];
            4'b0100: xtmux_1121 = wr1_data_C13[119:112];
            4'b0010: xtmux_1121 = wr2_data_C15[119:112];
            4'b0001: xtmux_1121 = wr3_data_C14[119:112];
        endcase
    end
    assign wmux3[119:112] = xtmux_1121;

    reg [7:0] xtmux_1122;
    always @(*) begin
        xtmux_1122 = 8'b0;
        case({wr0_word_we3_C13[15],
            wr1_word_we3_C13[15],
            wr2_word_we3_C15[15],
            wr3_word_we3_C14[15]}) 
/* synopsys full_case */
            4'b1000: xtmux_1122 = wr0_data_C13[127:120];
            4'b0100: xtmux_1122 = wr1_data_C13[127:120];
            4'b0010: xtmux_1122 = wr2_data_C15[127:120];
            4'b0001: xtmux_1122 = wr3_data_C14[127:120];
        endcase
    end
    assign wmux3[127:120] = xtmux_1122;

    wire [127:0] word3;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word3_p0;
    assign word3[7:0] = XACC_reg_word3_p0;
    always @(posedge clk or posedge localReset)
        XACC_reg_word3_p0 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk3_0) ? wmux3[7:0] : XACC_reg_word3_p0;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word3_p1;
    assign word3[15:8] = XACC_reg_word3_p1;
    always @(posedge clk or posedge localReset)
        XACC_reg_word3_p1 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk3_1) ? wmux3[15:8] : XACC_reg_word3_p1;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word3_p2;
    assign word3[23:16] = XACC_reg_word3_p2;
    always @(posedge clk or posedge localReset)
        XACC_reg_word3_p2 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk3_2) ? wmux3[23:16] : XACC_reg_word3_p2;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word3_p3;
    assign word3[31:24] = XACC_reg_word3_p3;
    always @(posedge clk or posedge localReset)
        XACC_reg_word3_p3 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk3_3) ? wmux3[31:24] : XACC_reg_word3_p3;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word3_p4;
    assign word3[39:32] = XACC_reg_word3_p4;
    always @(posedge clk or posedge localReset)
        XACC_reg_word3_p4 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk3_4) ? wmux3[39:32] : XACC_reg_word3_p4;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word3_p5;
    assign word3[47:40] = XACC_reg_word3_p5;
    always @(posedge clk or posedge localReset)
        XACC_reg_word3_p5 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk3_5) ? wmux3[47:40] : XACC_reg_word3_p5;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word3_p6;
    assign word3[55:48] = XACC_reg_word3_p6;
    always @(posedge clk or posedge localReset)
        XACC_reg_word3_p6 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk3_6) ? wmux3[55:48] : XACC_reg_word3_p6;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word3_p7;
    assign word3[63:56] = XACC_reg_word3_p7;
    always @(posedge clk or posedge localReset)
        XACC_reg_word3_p7 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk3_7) ? wmux3[63:56] : XACC_reg_word3_p7;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word3_p8;
    assign word3[71:64] = XACC_reg_word3_p8;
    always @(posedge clk or posedge localReset)
        XACC_reg_word3_p8 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk3_8) ? wmux3[71:64] : XACC_reg_word3_p8;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word3_p9;
    assign word3[79:72] = XACC_reg_word3_p9;
    always @(posedge clk or posedge localReset)
        XACC_reg_word3_p9 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk3_9) ? wmux3[79:72] : XACC_reg_word3_p9;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word3_p10;
    assign word3[87:80] = XACC_reg_word3_p10;
    always @(posedge clk or posedge localReset)
        XACC_reg_word3_p10 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk3_10) ? wmux3[87:80] : XACC_reg_word3_p10;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word3_p11;
    assign word3[95:88] = XACC_reg_word3_p11;
    always @(posedge clk or posedge localReset)
        XACC_reg_word3_p11 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk3_11) ? wmux3[95:88] : XACC_reg_word3_p11;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word3_p12;
    assign word3[103:96] = XACC_reg_word3_p12;
    always @(posedge clk or posedge localReset)
        XACC_reg_word3_p12 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk3_12) ? wmux3[103:96] : XACC_reg_word3_p12;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word3_p13;
    assign word3[111:104] = XACC_reg_word3_p13;
    always @(posedge clk or posedge localReset)
        XACC_reg_word3_p13 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk3_13) ? wmux3[111:104] : XACC_reg_word3_p13;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word3_p14;
    assign word3[119:112] = XACC_reg_word3_p14;
    always @(posedge clk or posedge localReset)
        XACC_reg_word3_p14 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk3_14) ? wmux3[119:112] : XACC_reg_word3_p14;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word3_p15;
    assign word3[127:120] = XACC_reg_word3_p15;
    always @(posedge clk or posedge localReset)
        XACC_reg_word3_p15 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk3_15) ? wmux3[127:120] : XACC_reg_word3_p15;

    wire [15:0] wr0_word_we4_C13 = wr0_we_C13 & {16{(wr0_addr_C13 == 5'd4)}};
    wire [15:0] wr1_word_we4_C13 = wr1_we_C13 & {16{(wr1_addr_C13 == 5'd4)}};
    wire [15:0] wr2_word_we4_C15 = wr2_we_C15 & {16{(wr2_addr_C15 == 5'd4)}};
    wire [15:0] wr3_word_we4_C14 = wr3_we_C14 & {16{(wr3_addr_C14 == 5'd4)}};
    wire [15:0] word4_we = 16'b0 | wr0_word_we4_C13 | wr1_word_we4_C13 | wr2_word_we4_C15 | wr3_word_we4_C14;
    wire gclk4_0;
assign gclk4_0 = word4_we[0];
    wire gclk4_1;
assign gclk4_1 = word4_we[1];
    wire gclk4_2;
assign gclk4_2 = word4_we[2];
    wire gclk4_3;
assign gclk4_3 = word4_we[3];
    wire gclk4_4;
assign gclk4_4 = word4_we[4];
    wire gclk4_5;
assign gclk4_5 = word4_we[5];
    wire gclk4_6;
assign gclk4_6 = word4_we[6];
    wire gclk4_7;
assign gclk4_7 = word4_we[7];
    wire gclk4_8;
assign gclk4_8 = word4_we[8];
    wire gclk4_9;
assign gclk4_9 = word4_we[9];
    wire gclk4_10;
assign gclk4_10 = word4_we[10];
    wire gclk4_11;
assign gclk4_11 = word4_we[11];
    wire gclk4_12;
assign gclk4_12 = word4_we[12];
    wire gclk4_13;
assign gclk4_13 = word4_we[13];
    wire gclk4_14;
assign gclk4_14 = word4_we[14];
    wire gclk4_15;
assign gclk4_15 = word4_we[15];
    wire [127:0] wmux4;
    reg [7:0] xtmux_1123;
    always @(*) begin
        xtmux_1123 = 8'b0;
        case({wr0_word_we4_C13[0],
            wr1_word_we4_C13[0],
            wr2_word_we4_C15[0],
            wr3_word_we4_C14[0]}) 
/* synopsys full_case */
            4'b1000: xtmux_1123 = wr0_data_C13[7:0];
            4'b0100: xtmux_1123 = wr1_data_C13[7:0];
            4'b0010: xtmux_1123 = wr2_data_C15[7:0];
            4'b0001: xtmux_1123 = wr3_data_C14[7:0];
        endcase
    end
    assign wmux4[7:0] = xtmux_1123;

    reg [7:0] xtmux_1124;
    always @(*) begin
        xtmux_1124 = 8'b0;
        case({wr0_word_we4_C13[1],
            wr1_word_we4_C13[1],
            wr2_word_we4_C15[1],
            wr3_word_we4_C14[1]}) 
/* synopsys full_case */
            4'b1000: xtmux_1124 = wr0_data_C13[15:8];
            4'b0100: xtmux_1124 = wr1_data_C13[15:8];
            4'b0010: xtmux_1124 = wr2_data_C15[15:8];
            4'b0001: xtmux_1124 = wr3_data_C14[15:8];
        endcase
    end
    assign wmux4[15:8] = xtmux_1124;

    reg [7:0] xtmux_1125;
    always @(*) begin
        xtmux_1125 = 8'b0;
        case({wr0_word_we4_C13[2],
            wr1_word_we4_C13[2],
            wr2_word_we4_C15[2],
            wr3_word_we4_C14[2]}) 
/* synopsys full_case */
            4'b1000: xtmux_1125 = wr0_data_C13[23:16];
            4'b0100: xtmux_1125 = wr1_data_C13[23:16];
            4'b0010: xtmux_1125 = wr2_data_C15[23:16];
            4'b0001: xtmux_1125 = wr3_data_C14[23:16];
        endcase
    end
    assign wmux4[23:16] = xtmux_1125;

    reg [7:0] xtmux_1126;
    always @(*) begin
        xtmux_1126 = 8'b0;
        case({wr0_word_we4_C13[3],
            wr1_word_we4_C13[3],
            wr2_word_we4_C15[3],
            wr3_word_we4_C14[3]}) 
/* synopsys full_case */
            4'b1000: xtmux_1126 = wr0_data_C13[31:24];
            4'b0100: xtmux_1126 = wr1_data_C13[31:24];
            4'b0010: xtmux_1126 = wr2_data_C15[31:24];
            4'b0001: xtmux_1126 = wr3_data_C14[31:24];
        endcase
    end
    assign wmux4[31:24] = xtmux_1126;

    reg [7:0] xtmux_1127;
    always @(*) begin
        xtmux_1127 = 8'b0;
        case({wr0_word_we4_C13[4],
            wr1_word_we4_C13[4],
            wr2_word_we4_C15[4],
            wr3_word_we4_C14[4]}) 
/* synopsys full_case */
            4'b1000: xtmux_1127 = wr0_data_C13[39:32];
            4'b0100: xtmux_1127 = wr1_data_C13[39:32];
            4'b0010: xtmux_1127 = wr2_data_C15[39:32];
            4'b0001: xtmux_1127 = wr3_data_C14[39:32];
        endcase
    end
    assign wmux4[39:32] = xtmux_1127;

    reg [7:0] xtmux_1128;
    always @(*) begin
        xtmux_1128 = 8'b0;
        case({wr0_word_we4_C13[5],
            wr1_word_we4_C13[5],
            wr2_word_we4_C15[5],
            wr3_word_we4_C14[5]}) 
/* synopsys full_case */
            4'b1000: xtmux_1128 = wr0_data_C13[47:40];
            4'b0100: xtmux_1128 = wr1_data_C13[47:40];
            4'b0010: xtmux_1128 = wr2_data_C15[47:40];
            4'b0001: xtmux_1128 = wr3_data_C14[47:40];
        endcase
    end
    assign wmux4[47:40] = xtmux_1128;

    reg [7:0] xtmux_1129;
    always @(*) begin
        xtmux_1129 = 8'b0;
        case({wr0_word_we4_C13[6],
            wr1_word_we4_C13[6],
            wr2_word_we4_C15[6],
            wr3_word_we4_C14[6]}) 
/* synopsys full_case */
            4'b1000: xtmux_1129 = wr0_data_C13[55:48];
            4'b0100: xtmux_1129 = wr1_data_C13[55:48];
            4'b0010: xtmux_1129 = wr2_data_C15[55:48];
            4'b0001: xtmux_1129 = wr3_data_C14[55:48];
        endcase
    end
    assign wmux4[55:48] = xtmux_1129;

    reg [7:0] xtmux_1130;
    always @(*) begin
        xtmux_1130 = 8'b0;
        case({wr0_word_we4_C13[7],
            wr1_word_we4_C13[7],
            wr2_word_we4_C15[7],
            wr3_word_we4_C14[7]}) 
/* synopsys full_case */
            4'b1000: xtmux_1130 = wr0_data_C13[63:56];
            4'b0100: xtmux_1130 = wr1_data_C13[63:56];
            4'b0010: xtmux_1130 = wr2_data_C15[63:56];
            4'b0001: xtmux_1130 = wr3_data_C14[63:56];
        endcase
    end
    assign wmux4[63:56] = xtmux_1130;

    reg [7:0] xtmux_1131;
    always @(*) begin
        xtmux_1131 = 8'b0;
        case({wr0_word_we4_C13[8],
            wr1_word_we4_C13[8],
            wr2_word_we4_C15[8],
            wr3_word_we4_C14[8]}) 
/* synopsys full_case */
            4'b1000: xtmux_1131 = wr0_data_C13[71:64];
            4'b0100: xtmux_1131 = wr1_data_C13[71:64];
            4'b0010: xtmux_1131 = wr2_data_C15[71:64];
            4'b0001: xtmux_1131 = wr3_data_C14[71:64];
        endcase
    end
    assign wmux4[71:64] = xtmux_1131;

    reg [7:0] xtmux_1132;
    always @(*) begin
        xtmux_1132 = 8'b0;
        case({wr0_word_we4_C13[9],
            wr1_word_we4_C13[9],
            wr2_word_we4_C15[9],
            wr3_word_we4_C14[9]}) 
/* synopsys full_case */
            4'b1000: xtmux_1132 = wr0_data_C13[79:72];
            4'b0100: xtmux_1132 = wr1_data_C13[79:72];
            4'b0010: xtmux_1132 = wr2_data_C15[79:72];
            4'b0001: xtmux_1132 = wr3_data_C14[79:72];
        endcase
    end
    assign wmux4[79:72] = xtmux_1132;

    reg [7:0] xtmux_1133;
    always @(*) begin
        xtmux_1133 = 8'b0;
        case({wr0_word_we4_C13[10],
            wr1_word_we4_C13[10],
            wr2_word_we4_C15[10],
            wr3_word_we4_C14[10]}) 
/* synopsys full_case */
            4'b1000: xtmux_1133 = wr0_data_C13[87:80];
            4'b0100: xtmux_1133 = wr1_data_C13[87:80];
            4'b0010: xtmux_1133 = wr2_data_C15[87:80];
            4'b0001: xtmux_1133 = wr3_data_C14[87:80];
        endcase
    end
    assign wmux4[87:80] = xtmux_1133;

    reg [7:0] xtmux_1134;
    always @(*) begin
        xtmux_1134 = 8'b0;
        case({wr0_word_we4_C13[11],
            wr1_word_we4_C13[11],
            wr2_word_we4_C15[11],
            wr3_word_we4_C14[11]}) 
/* synopsys full_case */
            4'b1000: xtmux_1134 = wr0_data_C13[95:88];
            4'b0100: xtmux_1134 = wr1_data_C13[95:88];
            4'b0010: xtmux_1134 = wr2_data_C15[95:88];
            4'b0001: xtmux_1134 = wr3_data_C14[95:88];
        endcase
    end
    assign wmux4[95:88] = xtmux_1134;

    reg [7:0] xtmux_1135;
    always @(*) begin
        xtmux_1135 = 8'b0;
        case({wr0_word_we4_C13[12],
            wr1_word_we4_C13[12],
            wr2_word_we4_C15[12],
            wr3_word_we4_C14[12]}) 
/* synopsys full_case */
            4'b1000: xtmux_1135 = wr0_data_C13[103:96];
            4'b0100: xtmux_1135 = wr1_data_C13[103:96];
            4'b0010: xtmux_1135 = wr2_data_C15[103:96];
            4'b0001: xtmux_1135 = wr3_data_C14[103:96];
        endcase
    end
    assign wmux4[103:96] = xtmux_1135;

    reg [7:0] xtmux_1136;
    always @(*) begin
        xtmux_1136 = 8'b0;
        case({wr0_word_we4_C13[13],
            wr1_word_we4_C13[13],
            wr2_word_we4_C15[13],
            wr3_word_we4_C14[13]}) 
/* synopsys full_case */
            4'b1000: xtmux_1136 = wr0_data_C13[111:104];
            4'b0100: xtmux_1136 = wr1_data_C13[111:104];
            4'b0010: xtmux_1136 = wr2_data_C15[111:104];
            4'b0001: xtmux_1136 = wr3_data_C14[111:104];
        endcase
    end
    assign wmux4[111:104] = xtmux_1136;

    reg [7:0] xtmux_1137;
    always @(*) begin
        xtmux_1137 = 8'b0;
        case({wr0_word_we4_C13[14],
            wr1_word_we4_C13[14],
            wr2_word_we4_C15[14],
            wr3_word_we4_C14[14]}) 
/* synopsys full_case */
            4'b1000: xtmux_1137 = wr0_data_C13[119:112];
            4'b0100: xtmux_1137 = wr1_data_C13[119:112];
            4'b0010: xtmux_1137 = wr2_data_C15[119:112];
            4'b0001: xtmux_1137 = wr3_data_C14[119:112];
        endcase
    end
    assign wmux4[119:112] = xtmux_1137;

    reg [7:0] xtmux_1138;
    always @(*) begin
        xtmux_1138 = 8'b0;
        case({wr0_word_we4_C13[15],
            wr1_word_we4_C13[15],
            wr2_word_we4_C15[15],
            wr3_word_we4_C14[15]}) 
/* synopsys full_case */
            4'b1000: xtmux_1138 = wr0_data_C13[127:120];
            4'b0100: xtmux_1138 = wr1_data_C13[127:120];
            4'b0010: xtmux_1138 = wr2_data_C15[127:120];
            4'b0001: xtmux_1138 = wr3_data_C14[127:120];
        endcase
    end
    assign wmux4[127:120] = xtmux_1138;

    wire [127:0] word4;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word4_p0;
    assign word4[7:0] = XACC_reg_word4_p0;
    always @(posedge clk or posedge localReset)
        XACC_reg_word4_p0 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk4_0) ? wmux4[7:0] : XACC_reg_word4_p0;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word4_p1;
    assign word4[15:8] = XACC_reg_word4_p1;
    always @(posedge clk or posedge localReset)
        XACC_reg_word4_p1 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk4_1) ? wmux4[15:8] : XACC_reg_word4_p1;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word4_p2;
    assign word4[23:16] = XACC_reg_word4_p2;
    always @(posedge clk or posedge localReset)
        XACC_reg_word4_p2 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk4_2) ? wmux4[23:16] : XACC_reg_word4_p2;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word4_p3;
    assign word4[31:24] = XACC_reg_word4_p3;
    always @(posedge clk or posedge localReset)
        XACC_reg_word4_p3 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk4_3) ? wmux4[31:24] : XACC_reg_word4_p3;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word4_p4;
    assign word4[39:32] = XACC_reg_word4_p4;
    always @(posedge clk or posedge localReset)
        XACC_reg_word4_p4 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk4_4) ? wmux4[39:32] : XACC_reg_word4_p4;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word4_p5;
    assign word4[47:40] = XACC_reg_word4_p5;
    always @(posedge clk or posedge localReset)
        XACC_reg_word4_p5 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk4_5) ? wmux4[47:40] : XACC_reg_word4_p5;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word4_p6;
    assign word4[55:48] = XACC_reg_word4_p6;
    always @(posedge clk or posedge localReset)
        XACC_reg_word4_p6 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk4_6) ? wmux4[55:48] : XACC_reg_word4_p6;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word4_p7;
    assign word4[63:56] = XACC_reg_word4_p7;
    always @(posedge clk or posedge localReset)
        XACC_reg_word4_p7 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk4_7) ? wmux4[63:56] : XACC_reg_word4_p7;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word4_p8;
    assign word4[71:64] = XACC_reg_word4_p8;
    always @(posedge clk or posedge localReset)
        XACC_reg_word4_p8 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk4_8) ? wmux4[71:64] : XACC_reg_word4_p8;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word4_p9;
    assign word4[79:72] = XACC_reg_word4_p9;
    always @(posedge clk or posedge localReset)
        XACC_reg_word4_p9 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk4_9) ? wmux4[79:72] : XACC_reg_word4_p9;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word4_p10;
    assign word4[87:80] = XACC_reg_word4_p10;
    always @(posedge clk or posedge localReset)
        XACC_reg_word4_p10 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk4_10) ? wmux4[87:80] : XACC_reg_word4_p10;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word4_p11;
    assign word4[95:88] = XACC_reg_word4_p11;
    always @(posedge clk or posedge localReset)
        XACC_reg_word4_p11 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk4_11) ? wmux4[95:88] : XACC_reg_word4_p11;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word4_p12;
    assign word4[103:96] = XACC_reg_word4_p12;
    always @(posedge clk or posedge localReset)
        XACC_reg_word4_p12 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk4_12) ? wmux4[103:96] : XACC_reg_word4_p12;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word4_p13;
    assign word4[111:104] = XACC_reg_word4_p13;
    always @(posedge clk or posedge localReset)
        XACC_reg_word4_p13 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk4_13) ? wmux4[111:104] : XACC_reg_word4_p13;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word4_p14;
    assign word4[119:112] = XACC_reg_word4_p14;
    always @(posedge clk or posedge localReset)
        XACC_reg_word4_p14 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk4_14) ? wmux4[119:112] : XACC_reg_word4_p14;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word4_p15;
    assign word4[127:120] = XACC_reg_word4_p15;
    always @(posedge clk or posedge localReset)
        XACC_reg_word4_p15 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk4_15) ? wmux4[127:120] : XACC_reg_word4_p15;

    wire [15:0] wr0_word_we5_C13 = wr0_we_C13 & {16{(wr0_addr_C13 == 5'd5)}};
    wire [15:0] wr1_word_we5_C13 = wr1_we_C13 & {16{(wr1_addr_C13 == 5'd5)}};
    wire [15:0] wr2_word_we5_C15 = wr2_we_C15 & {16{(wr2_addr_C15 == 5'd5)}};
    wire [15:0] wr3_word_we5_C14 = wr3_we_C14 & {16{(wr3_addr_C14 == 5'd5)}};
    wire [15:0] word5_we = 16'b0 | wr0_word_we5_C13 | wr1_word_we5_C13 | wr2_word_we5_C15 | wr3_word_we5_C14;
    wire gclk5_0;
assign gclk5_0 = word5_we[0];
    wire gclk5_1;
assign gclk5_1 = word5_we[1];
    wire gclk5_2;
assign gclk5_2 = word5_we[2];
    wire gclk5_3;
assign gclk5_3 = word5_we[3];
    wire gclk5_4;
assign gclk5_4 = word5_we[4];
    wire gclk5_5;
assign gclk5_5 = word5_we[5];
    wire gclk5_6;
assign gclk5_6 = word5_we[6];
    wire gclk5_7;
assign gclk5_7 = word5_we[7];
    wire gclk5_8;
assign gclk5_8 = word5_we[8];
    wire gclk5_9;
assign gclk5_9 = word5_we[9];
    wire gclk5_10;
assign gclk5_10 = word5_we[10];
    wire gclk5_11;
assign gclk5_11 = word5_we[11];
    wire gclk5_12;
assign gclk5_12 = word5_we[12];
    wire gclk5_13;
assign gclk5_13 = word5_we[13];
    wire gclk5_14;
assign gclk5_14 = word5_we[14];
    wire gclk5_15;
assign gclk5_15 = word5_we[15];
    wire [127:0] wmux5;
    reg [7:0] xtmux_1139;
    always @(*) begin
        xtmux_1139 = 8'b0;
        case({wr0_word_we5_C13[0],
            wr1_word_we5_C13[0],
            wr2_word_we5_C15[0],
            wr3_word_we5_C14[0]}) 
/* synopsys full_case */
            4'b1000: xtmux_1139 = wr0_data_C13[7:0];
            4'b0100: xtmux_1139 = wr1_data_C13[7:0];
            4'b0010: xtmux_1139 = wr2_data_C15[7:0];
            4'b0001: xtmux_1139 = wr3_data_C14[7:0];
        endcase
    end
    assign wmux5[7:0] = xtmux_1139;

    reg [7:0] xtmux_1140;
    always @(*) begin
        xtmux_1140 = 8'b0;
        case({wr0_word_we5_C13[1],
            wr1_word_we5_C13[1],
            wr2_word_we5_C15[1],
            wr3_word_we5_C14[1]}) 
/* synopsys full_case */
            4'b1000: xtmux_1140 = wr0_data_C13[15:8];
            4'b0100: xtmux_1140 = wr1_data_C13[15:8];
            4'b0010: xtmux_1140 = wr2_data_C15[15:8];
            4'b0001: xtmux_1140 = wr3_data_C14[15:8];
        endcase
    end
    assign wmux5[15:8] = xtmux_1140;

    reg [7:0] xtmux_1141;
    always @(*) begin
        xtmux_1141 = 8'b0;
        case({wr0_word_we5_C13[2],
            wr1_word_we5_C13[2],
            wr2_word_we5_C15[2],
            wr3_word_we5_C14[2]}) 
/* synopsys full_case */
            4'b1000: xtmux_1141 = wr0_data_C13[23:16];
            4'b0100: xtmux_1141 = wr1_data_C13[23:16];
            4'b0010: xtmux_1141 = wr2_data_C15[23:16];
            4'b0001: xtmux_1141 = wr3_data_C14[23:16];
        endcase
    end
    assign wmux5[23:16] = xtmux_1141;

    reg [7:0] xtmux_1142;
    always @(*) begin
        xtmux_1142 = 8'b0;
        case({wr0_word_we5_C13[3],
            wr1_word_we5_C13[3],
            wr2_word_we5_C15[3],
            wr3_word_we5_C14[3]}) 
/* synopsys full_case */
            4'b1000: xtmux_1142 = wr0_data_C13[31:24];
            4'b0100: xtmux_1142 = wr1_data_C13[31:24];
            4'b0010: xtmux_1142 = wr2_data_C15[31:24];
            4'b0001: xtmux_1142 = wr3_data_C14[31:24];
        endcase
    end
    assign wmux5[31:24] = xtmux_1142;

    reg [7:0] xtmux_1143;
    always @(*) begin
        xtmux_1143 = 8'b0;
        case({wr0_word_we5_C13[4],
            wr1_word_we5_C13[4],
            wr2_word_we5_C15[4],
            wr3_word_we5_C14[4]}) 
/* synopsys full_case */
            4'b1000: xtmux_1143 = wr0_data_C13[39:32];
            4'b0100: xtmux_1143 = wr1_data_C13[39:32];
            4'b0010: xtmux_1143 = wr2_data_C15[39:32];
            4'b0001: xtmux_1143 = wr3_data_C14[39:32];
        endcase
    end
    assign wmux5[39:32] = xtmux_1143;

    reg [7:0] xtmux_1144;
    always @(*) begin
        xtmux_1144 = 8'b0;
        case({wr0_word_we5_C13[5],
            wr1_word_we5_C13[5],
            wr2_word_we5_C15[5],
            wr3_word_we5_C14[5]}) 
/* synopsys full_case */
            4'b1000: xtmux_1144 = wr0_data_C13[47:40];
            4'b0100: xtmux_1144 = wr1_data_C13[47:40];
            4'b0010: xtmux_1144 = wr2_data_C15[47:40];
            4'b0001: xtmux_1144 = wr3_data_C14[47:40];
        endcase
    end
    assign wmux5[47:40] = xtmux_1144;

    reg [7:0] xtmux_1145;
    always @(*) begin
        xtmux_1145 = 8'b0;
        case({wr0_word_we5_C13[6],
            wr1_word_we5_C13[6],
            wr2_word_we5_C15[6],
            wr3_word_we5_C14[6]}) 
/* synopsys full_case */
            4'b1000: xtmux_1145 = wr0_data_C13[55:48];
            4'b0100: xtmux_1145 = wr1_data_C13[55:48];
            4'b0010: xtmux_1145 = wr2_data_C15[55:48];
            4'b0001: xtmux_1145 = wr3_data_C14[55:48];
        endcase
    end
    assign wmux5[55:48] = xtmux_1145;

    reg [7:0] xtmux_1146;
    always @(*) begin
        xtmux_1146 = 8'b0;
        case({wr0_word_we5_C13[7],
            wr1_word_we5_C13[7],
            wr2_word_we5_C15[7],
            wr3_word_we5_C14[7]}) 
/* synopsys full_case */
            4'b1000: xtmux_1146 = wr0_data_C13[63:56];
            4'b0100: xtmux_1146 = wr1_data_C13[63:56];
            4'b0010: xtmux_1146 = wr2_data_C15[63:56];
            4'b0001: xtmux_1146 = wr3_data_C14[63:56];
        endcase
    end
    assign wmux5[63:56] = xtmux_1146;

    reg [7:0] xtmux_1147;
    always @(*) begin
        xtmux_1147 = 8'b0;
        case({wr0_word_we5_C13[8],
            wr1_word_we5_C13[8],
            wr2_word_we5_C15[8],
            wr3_word_we5_C14[8]}) 
/* synopsys full_case */
            4'b1000: xtmux_1147 = wr0_data_C13[71:64];
            4'b0100: xtmux_1147 = wr1_data_C13[71:64];
            4'b0010: xtmux_1147 = wr2_data_C15[71:64];
            4'b0001: xtmux_1147 = wr3_data_C14[71:64];
        endcase
    end
    assign wmux5[71:64] = xtmux_1147;

    reg [7:0] xtmux_1148;
    always @(*) begin
        xtmux_1148 = 8'b0;
        case({wr0_word_we5_C13[9],
            wr1_word_we5_C13[9],
            wr2_word_we5_C15[9],
            wr3_word_we5_C14[9]}) 
/* synopsys full_case */
            4'b1000: xtmux_1148 = wr0_data_C13[79:72];
            4'b0100: xtmux_1148 = wr1_data_C13[79:72];
            4'b0010: xtmux_1148 = wr2_data_C15[79:72];
            4'b0001: xtmux_1148 = wr3_data_C14[79:72];
        endcase
    end
    assign wmux5[79:72] = xtmux_1148;

    reg [7:0] xtmux_1149;
    always @(*) begin
        xtmux_1149 = 8'b0;
        case({wr0_word_we5_C13[10],
            wr1_word_we5_C13[10],
            wr2_word_we5_C15[10],
            wr3_word_we5_C14[10]}) 
/* synopsys full_case */
            4'b1000: xtmux_1149 = wr0_data_C13[87:80];
            4'b0100: xtmux_1149 = wr1_data_C13[87:80];
            4'b0010: xtmux_1149 = wr2_data_C15[87:80];
            4'b0001: xtmux_1149 = wr3_data_C14[87:80];
        endcase
    end
    assign wmux5[87:80] = xtmux_1149;

    reg [7:0] xtmux_1150;
    always @(*) begin
        xtmux_1150 = 8'b0;
        case({wr0_word_we5_C13[11],
            wr1_word_we5_C13[11],
            wr2_word_we5_C15[11],
            wr3_word_we5_C14[11]}) 
/* synopsys full_case */
            4'b1000: xtmux_1150 = wr0_data_C13[95:88];
            4'b0100: xtmux_1150 = wr1_data_C13[95:88];
            4'b0010: xtmux_1150 = wr2_data_C15[95:88];
            4'b0001: xtmux_1150 = wr3_data_C14[95:88];
        endcase
    end
    assign wmux5[95:88] = xtmux_1150;

    reg [7:0] xtmux_1151;
    always @(*) begin
        xtmux_1151 = 8'b0;
        case({wr0_word_we5_C13[12],
            wr1_word_we5_C13[12],
            wr2_word_we5_C15[12],
            wr3_word_we5_C14[12]}) 
/* synopsys full_case */
            4'b1000: xtmux_1151 = wr0_data_C13[103:96];
            4'b0100: xtmux_1151 = wr1_data_C13[103:96];
            4'b0010: xtmux_1151 = wr2_data_C15[103:96];
            4'b0001: xtmux_1151 = wr3_data_C14[103:96];
        endcase
    end
    assign wmux5[103:96] = xtmux_1151;

    reg [7:0] xtmux_1152;
    always @(*) begin
        xtmux_1152 = 8'b0;
        case({wr0_word_we5_C13[13],
            wr1_word_we5_C13[13],
            wr2_word_we5_C15[13],
            wr3_word_we5_C14[13]}) 
/* synopsys full_case */
            4'b1000: xtmux_1152 = wr0_data_C13[111:104];
            4'b0100: xtmux_1152 = wr1_data_C13[111:104];
            4'b0010: xtmux_1152 = wr2_data_C15[111:104];
            4'b0001: xtmux_1152 = wr3_data_C14[111:104];
        endcase
    end
    assign wmux5[111:104] = xtmux_1152;

    reg [7:0] xtmux_1153;
    always @(*) begin
        xtmux_1153 = 8'b0;
        case({wr0_word_we5_C13[14],
            wr1_word_we5_C13[14],
            wr2_word_we5_C15[14],
            wr3_word_we5_C14[14]}) 
/* synopsys full_case */
            4'b1000: xtmux_1153 = wr0_data_C13[119:112];
            4'b0100: xtmux_1153 = wr1_data_C13[119:112];
            4'b0010: xtmux_1153 = wr2_data_C15[119:112];
            4'b0001: xtmux_1153 = wr3_data_C14[119:112];
        endcase
    end
    assign wmux5[119:112] = xtmux_1153;

    reg [7:0] xtmux_1154;
    always @(*) begin
        xtmux_1154 = 8'b0;
        case({wr0_word_we5_C13[15],
            wr1_word_we5_C13[15],
            wr2_word_we5_C15[15],
            wr3_word_we5_C14[15]}) 
/* synopsys full_case */
            4'b1000: xtmux_1154 = wr0_data_C13[127:120];
            4'b0100: xtmux_1154 = wr1_data_C13[127:120];
            4'b0010: xtmux_1154 = wr2_data_C15[127:120];
            4'b0001: xtmux_1154 = wr3_data_C14[127:120];
        endcase
    end
    assign wmux5[127:120] = xtmux_1154;

    wire [127:0] word5;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word5_p0;
    assign word5[7:0] = XACC_reg_word5_p0;
    always @(posedge clk or posedge localReset)
        XACC_reg_word5_p0 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk5_0) ? wmux5[7:0] : XACC_reg_word5_p0;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word5_p1;
    assign word5[15:8] = XACC_reg_word5_p1;
    always @(posedge clk or posedge localReset)
        XACC_reg_word5_p1 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk5_1) ? wmux5[15:8] : XACC_reg_word5_p1;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word5_p2;
    assign word5[23:16] = XACC_reg_word5_p2;
    always @(posedge clk or posedge localReset)
        XACC_reg_word5_p2 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk5_2) ? wmux5[23:16] : XACC_reg_word5_p2;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word5_p3;
    assign word5[31:24] = XACC_reg_word5_p3;
    always @(posedge clk or posedge localReset)
        XACC_reg_word5_p3 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk5_3) ? wmux5[31:24] : XACC_reg_word5_p3;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word5_p4;
    assign word5[39:32] = XACC_reg_word5_p4;
    always @(posedge clk or posedge localReset)
        XACC_reg_word5_p4 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk5_4) ? wmux5[39:32] : XACC_reg_word5_p4;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word5_p5;
    assign word5[47:40] = XACC_reg_word5_p5;
    always @(posedge clk or posedge localReset)
        XACC_reg_word5_p5 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk5_5) ? wmux5[47:40] : XACC_reg_word5_p5;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word5_p6;
    assign word5[55:48] = XACC_reg_word5_p6;
    always @(posedge clk or posedge localReset)
        XACC_reg_word5_p6 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk5_6) ? wmux5[55:48] : XACC_reg_word5_p6;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word5_p7;
    assign word5[63:56] = XACC_reg_word5_p7;
    always @(posedge clk or posedge localReset)
        XACC_reg_word5_p7 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk5_7) ? wmux5[63:56] : XACC_reg_word5_p7;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word5_p8;
    assign word5[71:64] = XACC_reg_word5_p8;
    always @(posedge clk or posedge localReset)
        XACC_reg_word5_p8 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk5_8) ? wmux5[71:64] : XACC_reg_word5_p8;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word5_p9;
    assign word5[79:72] = XACC_reg_word5_p9;
    always @(posedge clk or posedge localReset)
        XACC_reg_word5_p9 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk5_9) ? wmux5[79:72] : XACC_reg_word5_p9;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word5_p10;
    assign word5[87:80] = XACC_reg_word5_p10;
    always @(posedge clk or posedge localReset)
        XACC_reg_word5_p10 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk5_10) ? wmux5[87:80] : XACC_reg_word5_p10;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word5_p11;
    assign word5[95:88] = XACC_reg_word5_p11;
    always @(posedge clk or posedge localReset)
        XACC_reg_word5_p11 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk5_11) ? wmux5[95:88] : XACC_reg_word5_p11;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word5_p12;
    assign word5[103:96] = XACC_reg_word5_p12;
    always @(posedge clk or posedge localReset)
        XACC_reg_word5_p12 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk5_12) ? wmux5[103:96] : XACC_reg_word5_p12;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word5_p13;
    assign word5[111:104] = XACC_reg_word5_p13;
    always @(posedge clk or posedge localReset)
        XACC_reg_word5_p13 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk5_13) ? wmux5[111:104] : XACC_reg_word5_p13;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word5_p14;
    assign word5[119:112] = XACC_reg_word5_p14;
    always @(posedge clk or posedge localReset)
        XACC_reg_word5_p14 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk5_14) ? wmux5[119:112] : XACC_reg_word5_p14;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word5_p15;
    assign word5[127:120] = XACC_reg_word5_p15;
    always @(posedge clk or posedge localReset)
        XACC_reg_word5_p15 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk5_15) ? wmux5[127:120] : XACC_reg_word5_p15;

    wire [15:0] wr0_word_we6_C13 = wr0_we_C13 & {16{(wr0_addr_C13 == 5'd6)}};
    wire [15:0] wr1_word_we6_C13 = wr1_we_C13 & {16{(wr1_addr_C13 == 5'd6)}};
    wire [15:0] wr2_word_we6_C15 = wr2_we_C15 & {16{(wr2_addr_C15 == 5'd6)}};
    wire [15:0] wr3_word_we6_C14 = wr3_we_C14 & {16{(wr3_addr_C14 == 5'd6)}};
    wire [15:0] word6_we = 16'b0 | wr0_word_we6_C13 | wr1_word_we6_C13 | wr2_word_we6_C15 | wr3_word_we6_C14;
    wire gclk6_0;
assign gclk6_0 = word6_we[0];
    wire gclk6_1;
assign gclk6_1 = word6_we[1];
    wire gclk6_2;
assign gclk6_2 = word6_we[2];
    wire gclk6_3;
assign gclk6_3 = word6_we[3];
    wire gclk6_4;
assign gclk6_4 = word6_we[4];
    wire gclk6_5;
assign gclk6_5 = word6_we[5];
    wire gclk6_6;
assign gclk6_6 = word6_we[6];
    wire gclk6_7;
assign gclk6_7 = word6_we[7];
    wire gclk6_8;
assign gclk6_8 = word6_we[8];
    wire gclk6_9;
assign gclk6_9 = word6_we[9];
    wire gclk6_10;
assign gclk6_10 = word6_we[10];
    wire gclk6_11;
assign gclk6_11 = word6_we[11];
    wire gclk6_12;
assign gclk6_12 = word6_we[12];
    wire gclk6_13;
assign gclk6_13 = word6_we[13];
    wire gclk6_14;
assign gclk6_14 = word6_we[14];
    wire gclk6_15;
assign gclk6_15 = word6_we[15];
    wire [127:0] wmux6;
    reg [7:0] xtmux_1155;
    always @(*) begin
        xtmux_1155 = 8'b0;
        case({wr0_word_we6_C13[0],
            wr1_word_we6_C13[0],
            wr2_word_we6_C15[0],
            wr3_word_we6_C14[0]}) 
/* synopsys full_case */
            4'b1000: xtmux_1155 = wr0_data_C13[7:0];
            4'b0100: xtmux_1155 = wr1_data_C13[7:0];
            4'b0010: xtmux_1155 = wr2_data_C15[7:0];
            4'b0001: xtmux_1155 = wr3_data_C14[7:0];
        endcase
    end
    assign wmux6[7:0] = xtmux_1155;

    reg [7:0] xtmux_1156;
    always @(*) begin
        xtmux_1156 = 8'b0;
        case({wr0_word_we6_C13[1],
            wr1_word_we6_C13[1],
            wr2_word_we6_C15[1],
            wr3_word_we6_C14[1]}) 
/* synopsys full_case */
            4'b1000: xtmux_1156 = wr0_data_C13[15:8];
            4'b0100: xtmux_1156 = wr1_data_C13[15:8];
            4'b0010: xtmux_1156 = wr2_data_C15[15:8];
            4'b0001: xtmux_1156 = wr3_data_C14[15:8];
        endcase
    end
    assign wmux6[15:8] = xtmux_1156;

    reg [7:0] xtmux_1157;
    always @(*) begin
        xtmux_1157 = 8'b0;
        case({wr0_word_we6_C13[2],
            wr1_word_we6_C13[2],
            wr2_word_we6_C15[2],
            wr3_word_we6_C14[2]}) 
/* synopsys full_case */
            4'b1000: xtmux_1157 = wr0_data_C13[23:16];
            4'b0100: xtmux_1157 = wr1_data_C13[23:16];
            4'b0010: xtmux_1157 = wr2_data_C15[23:16];
            4'b0001: xtmux_1157 = wr3_data_C14[23:16];
        endcase
    end
    assign wmux6[23:16] = xtmux_1157;

    reg [7:0] xtmux_1158;
    always @(*) begin
        xtmux_1158 = 8'b0;
        case({wr0_word_we6_C13[3],
            wr1_word_we6_C13[3],
            wr2_word_we6_C15[3],
            wr3_word_we6_C14[3]}) 
/* synopsys full_case */
            4'b1000: xtmux_1158 = wr0_data_C13[31:24];
            4'b0100: xtmux_1158 = wr1_data_C13[31:24];
            4'b0010: xtmux_1158 = wr2_data_C15[31:24];
            4'b0001: xtmux_1158 = wr3_data_C14[31:24];
        endcase
    end
    assign wmux6[31:24] = xtmux_1158;

    reg [7:0] xtmux_1159;
    always @(*) begin
        xtmux_1159 = 8'b0;
        case({wr0_word_we6_C13[4],
            wr1_word_we6_C13[4],
            wr2_word_we6_C15[4],
            wr3_word_we6_C14[4]}) 
/* synopsys full_case */
            4'b1000: xtmux_1159 = wr0_data_C13[39:32];
            4'b0100: xtmux_1159 = wr1_data_C13[39:32];
            4'b0010: xtmux_1159 = wr2_data_C15[39:32];
            4'b0001: xtmux_1159 = wr3_data_C14[39:32];
        endcase
    end
    assign wmux6[39:32] = xtmux_1159;

    reg [7:0] xtmux_1160;
    always @(*) begin
        xtmux_1160 = 8'b0;
        case({wr0_word_we6_C13[5],
            wr1_word_we6_C13[5],
            wr2_word_we6_C15[5],
            wr3_word_we6_C14[5]}) 
/* synopsys full_case */
            4'b1000: xtmux_1160 = wr0_data_C13[47:40];
            4'b0100: xtmux_1160 = wr1_data_C13[47:40];
            4'b0010: xtmux_1160 = wr2_data_C15[47:40];
            4'b0001: xtmux_1160 = wr3_data_C14[47:40];
        endcase
    end
    assign wmux6[47:40] = xtmux_1160;

    reg [7:0] xtmux_1161;
    always @(*) begin
        xtmux_1161 = 8'b0;
        case({wr0_word_we6_C13[6],
            wr1_word_we6_C13[6],
            wr2_word_we6_C15[6],
            wr3_word_we6_C14[6]}) 
/* synopsys full_case */
            4'b1000: xtmux_1161 = wr0_data_C13[55:48];
            4'b0100: xtmux_1161 = wr1_data_C13[55:48];
            4'b0010: xtmux_1161 = wr2_data_C15[55:48];
            4'b0001: xtmux_1161 = wr3_data_C14[55:48];
        endcase
    end
    assign wmux6[55:48] = xtmux_1161;

    reg [7:0] xtmux_1162;
    always @(*) begin
        xtmux_1162 = 8'b0;
        case({wr0_word_we6_C13[7],
            wr1_word_we6_C13[7],
            wr2_word_we6_C15[7],
            wr3_word_we6_C14[7]}) 
/* synopsys full_case */
            4'b1000: xtmux_1162 = wr0_data_C13[63:56];
            4'b0100: xtmux_1162 = wr1_data_C13[63:56];
            4'b0010: xtmux_1162 = wr2_data_C15[63:56];
            4'b0001: xtmux_1162 = wr3_data_C14[63:56];
        endcase
    end
    assign wmux6[63:56] = xtmux_1162;

    reg [7:0] xtmux_1163;
    always @(*) begin
        xtmux_1163 = 8'b0;
        case({wr0_word_we6_C13[8],
            wr1_word_we6_C13[8],
            wr2_word_we6_C15[8],
            wr3_word_we6_C14[8]}) 
/* synopsys full_case */
            4'b1000: xtmux_1163 = wr0_data_C13[71:64];
            4'b0100: xtmux_1163 = wr1_data_C13[71:64];
            4'b0010: xtmux_1163 = wr2_data_C15[71:64];
            4'b0001: xtmux_1163 = wr3_data_C14[71:64];
        endcase
    end
    assign wmux6[71:64] = xtmux_1163;

    reg [7:0] xtmux_1164;
    always @(*) begin
        xtmux_1164 = 8'b0;
        case({wr0_word_we6_C13[9],
            wr1_word_we6_C13[9],
            wr2_word_we6_C15[9],
            wr3_word_we6_C14[9]}) 
/* synopsys full_case */
            4'b1000: xtmux_1164 = wr0_data_C13[79:72];
            4'b0100: xtmux_1164 = wr1_data_C13[79:72];
            4'b0010: xtmux_1164 = wr2_data_C15[79:72];
            4'b0001: xtmux_1164 = wr3_data_C14[79:72];
        endcase
    end
    assign wmux6[79:72] = xtmux_1164;

    reg [7:0] xtmux_1165;
    always @(*) begin
        xtmux_1165 = 8'b0;
        case({wr0_word_we6_C13[10],
            wr1_word_we6_C13[10],
            wr2_word_we6_C15[10],
            wr3_word_we6_C14[10]}) 
/* synopsys full_case */
            4'b1000: xtmux_1165 = wr0_data_C13[87:80];
            4'b0100: xtmux_1165 = wr1_data_C13[87:80];
            4'b0010: xtmux_1165 = wr2_data_C15[87:80];
            4'b0001: xtmux_1165 = wr3_data_C14[87:80];
        endcase
    end
    assign wmux6[87:80] = xtmux_1165;

    reg [7:0] xtmux_1166;
    always @(*) begin
        xtmux_1166 = 8'b0;
        case({wr0_word_we6_C13[11],
            wr1_word_we6_C13[11],
            wr2_word_we6_C15[11],
            wr3_word_we6_C14[11]}) 
/* synopsys full_case */
            4'b1000: xtmux_1166 = wr0_data_C13[95:88];
            4'b0100: xtmux_1166 = wr1_data_C13[95:88];
            4'b0010: xtmux_1166 = wr2_data_C15[95:88];
            4'b0001: xtmux_1166 = wr3_data_C14[95:88];
        endcase
    end
    assign wmux6[95:88] = xtmux_1166;

    reg [7:0] xtmux_1167;
    always @(*) begin
        xtmux_1167 = 8'b0;
        case({wr0_word_we6_C13[12],
            wr1_word_we6_C13[12],
            wr2_word_we6_C15[12],
            wr3_word_we6_C14[12]}) 
/* synopsys full_case */
            4'b1000: xtmux_1167 = wr0_data_C13[103:96];
            4'b0100: xtmux_1167 = wr1_data_C13[103:96];
            4'b0010: xtmux_1167 = wr2_data_C15[103:96];
            4'b0001: xtmux_1167 = wr3_data_C14[103:96];
        endcase
    end
    assign wmux6[103:96] = xtmux_1167;

    reg [7:0] xtmux_1168;
    always @(*) begin
        xtmux_1168 = 8'b0;
        case({wr0_word_we6_C13[13],
            wr1_word_we6_C13[13],
            wr2_word_we6_C15[13],
            wr3_word_we6_C14[13]}) 
/* synopsys full_case */
            4'b1000: xtmux_1168 = wr0_data_C13[111:104];
            4'b0100: xtmux_1168 = wr1_data_C13[111:104];
            4'b0010: xtmux_1168 = wr2_data_C15[111:104];
            4'b0001: xtmux_1168 = wr3_data_C14[111:104];
        endcase
    end
    assign wmux6[111:104] = xtmux_1168;

    reg [7:0] xtmux_1169;
    always @(*) begin
        xtmux_1169 = 8'b0;
        case({wr0_word_we6_C13[14],
            wr1_word_we6_C13[14],
            wr2_word_we6_C15[14],
            wr3_word_we6_C14[14]}) 
/* synopsys full_case */
            4'b1000: xtmux_1169 = wr0_data_C13[119:112];
            4'b0100: xtmux_1169 = wr1_data_C13[119:112];
            4'b0010: xtmux_1169 = wr2_data_C15[119:112];
            4'b0001: xtmux_1169 = wr3_data_C14[119:112];
        endcase
    end
    assign wmux6[119:112] = xtmux_1169;

    reg [7:0] xtmux_1170;
    always @(*) begin
        xtmux_1170 = 8'b0;
        case({wr0_word_we6_C13[15],
            wr1_word_we6_C13[15],
            wr2_word_we6_C15[15],
            wr3_word_we6_C14[15]}) 
/* synopsys full_case */
            4'b1000: xtmux_1170 = wr0_data_C13[127:120];
            4'b0100: xtmux_1170 = wr1_data_C13[127:120];
            4'b0010: xtmux_1170 = wr2_data_C15[127:120];
            4'b0001: xtmux_1170 = wr3_data_C14[127:120];
        endcase
    end
    assign wmux6[127:120] = xtmux_1170;

    wire [127:0] word6;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word6_p0;
    assign word6[7:0] = XACC_reg_word6_p0;
    always @(posedge clk or posedge localReset)
        XACC_reg_word6_p0 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk6_0) ? wmux6[7:0] : XACC_reg_word6_p0;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word6_p1;
    assign word6[15:8] = XACC_reg_word6_p1;
    always @(posedge clk or posedge localReset)
        XACC_reg_word6_p1 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk6_1) ? wmux6[15:8] : XACC_reg_word6_p1;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word6_p2;
    assign word6[23:16] = XACC_reg_word6_p2;
    always @(posedge clk or posedge localReset)
        XACC_reg_word6_p2 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk6_2) ? wmux6[23:16] : XACC_reg_word6_p2;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word6_p3;
    assign word6[31:24] = XACC_reg_word6_p3;
    always @(posedge clk or posedge localReset)
        XACC_reg_word6_p3 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk6_3) ? wmux6[31:24] : XACC_reg_word6_p3;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word6_p4;
    assign word6[39:32] = XACC_reg_word6_p4;
    always @(posedge clk or posedge localReset)
        XACC_reg_word6_p4 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk6_4) ? wmux6[39:32] : XACC_reg_word6_p4;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word6_p5;
    assign word6[47:40] = XACC_reg_word6_p5;
    always @(posedge clk or posedge localReset)
        XACC_reg_word6_p5 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk6_5) ? wmux6[47:40] : XACC_reg_word6_p5;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word6_p6;
    assign word6[55:48] = XACC_reg_word6_p6;
    always @(posedge clk or posedge localReset)
        XACC_reg_word6_p6 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk6_6) ? wmux6[55:48] : XACC_reg_word6_p6;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word6_p7;
    assign word6[63:56] = XACC_reg_word6_p7;
    always @(posedge clk or posedge localReset)
        XACC_reg_word6_p7 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk6_7) ? wmux6[63:56] : XACC_reg_word6_p7;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word6_p8;
    assign word6[71:64] = XACC_reg_word6_p8;
    always @(posedge clk or posedge localReset)
        XACC_reg_word6_p8 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk6_8) ? wmux6[71:64] : XACC_reg_word6_p8;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word6_p9;
    assign word6[79:72] = XACC_reg_word6_p9;
    always @(posedge clk or posedge localReset)
        XACC_reg_word6_p9 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk6_9) ? wmux6[79:72] : XACC_reg_word6_p9;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word6_p10;
    assign word6[87:80] = XACC_reg_word6_p10;
    always @(posedge clk or posedge localReset)
        XACC_reg_word6_p10 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk6_10) ? wmux6[87:80] : XACC_reg_word6_p10;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word6_p11;
    assign word6[95:88] = XACC_reg_word6_p11;
    always @(posedge clk or posedge localReset)
        XACC_reg_word6_p11 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk6_11) ? wmux6[95:88] : XACC_reg_word6_p11;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word6_p12;
    assign word6[103:96] = XACC_reg_word6_p12;
    always @(posedge clk or posedge localReset)
        XACC_reg_word6_p12 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk6_12) ? wmux6[103:96] : XACC_reg_word6_p12;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word6_p13;
    assign word6[111:104] = XACC_reg_word6_p13;
    always @(posedge clk or posedge localReset)
        XACC_reg_word6_p13 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk6_13) ? wmux6[111:104] : XACC_reg_word6_p13;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word6_p14;
    assign word6[119:112] = XACC_reg_word6_p14;
    always @(posedge clk or posedge localReset)
        XACC_reg_word6_p14 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk6_14) ? wmux6[119:112] : XACC_reg_word6_p14;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word6_p15;
    assign word6[127:120] = XACC_reg_word6_p15;
    always @(posedge clk or posedge localReset)
        XACC_reg_word6_p15 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk6_15) ? wmux6[127:120] : XACC_reg_word6_p15;

    wire [15:0] wr0_word_we7_C13 = wr0_we_C13 & {16{(wr0_addr_C13 == 5'd7)}};
    wire [15:0] wr1_word_we7_C13 = wr1_we_C13 & {16{(wr1_addr_C13 == 5'd7)}};
    wire [15:0] wr2_word_we7_C15 = wr2_we_C15 & {16{(wr2_addr_C15 == 5'd7)}};
    wire [15:0] wr3_word_we7_C14 = wr3_we_C14 & {16{(wr3_addr_C14 == 5'd7)}};
    wire [15:0] word7_we = 16'b0 | wr0_word_we7_C13 | wr1_word_we7_C13 | wr2_word_we7_C15 | wr3_word_we7_C14;
    wire gclk7_0;
assign gclk7_0 = word7_we[0];
    wire gclk7_1;
assign gclk7_1 = word7_we[1];
    wire gclk7_2;
assign gclk7_2 = word7_we[2];
    wire gclk7_3;
assign gclk7_3 = word7_we[3];
    wire gclk7_4;
assign gclk7_4 = word7_we[4];
    wire gclk7_5;
assign gclk7_5 = word7_we[5];
    wire gclk7_6;
assign gclk7_6 = word7_we[6];
    wire gclk7_7;
assign gclk7_7 = word7_we[7];
    wire gclk7_8;
assign gclk7_8 = word7_we[8];
    wire gclk7_9;
assign gclk7_9 = word7_we[9];
    wire gclk7_10;
assign gclk7_10 = word7_we[10];
    wire gclk7_11;
assign gclk7_11 = word7_we[11];
    wire gclk7_12;
assign gclk7_12 = word7_we[12];
    wire gclk7_13;
assign gclk7_13 = word7_we[13];
    wire gclk7_14;
assign gclk7_14 = word7_we[14];
    wire gclk7_15;
assign gclk7_15 = word7_we[15];
    wire [127:0] wmux7;
    reg [7:0] xtmux_1171;
    always @(*) begin
        xtmux_1171 = 8'b0;
        case({wr0_word_we7_C13[0],
            wr1_word_we7_C13[0],
            wr2_word_we7_C15[0],
            wr3_word_we7_C14[0]}) 
/* synopsys full_case */
            4'b1000: xtmux_1171 = wr0_data_C13[7:0];
            4'b0100: xtmux_1171 = wr1_data_C13[7:0];
            4'b0010: xtmux_1171 = wr2_data_C15[7:0];
            4'b0001: xtmux_1171 = wr3_data_C14[7:0];
        endcase
    end
    assign wmux7[7:0] = xtmux_1171;

    reg [7:0] xtmux_1172;
    always @(*) begin
        xtmux_1172 = 8'b0;
        case({wr0_word_we7_C13[1],
            wr1_word_we7_C13[1],
            wr2_word_we7_C15[1],
            wr3_word_we7_C14[1]}) 
/* synopsys full_case */
            4'b1000: xtmux_1172 = wr0_data_C13[15:8];
            4'b0100: xtmux_1172 = wr1_data_C13[15:8];
            4'b0010: xtmux_1172 = wr2_data_C15[15:8];
            4'b0001: xtmux_1172 = wr3_data_C14[15:8];
        endcase
    end
    assign wmux7[15:8] = xtmux_1172;

    reg [7:0] xtmux_1173;
    always @(*) begin
        xtmux_1173 = 8'b0;
        case({wr0_word_we7_C13[2],
            wr1_word_we7_C13[2],
            wr2_word_we7_C15[2],
            wr3_word_we7_C14[2]}) 
/* synopsys full_case */
            4'b1000: xtmux_1173 = wr0_data_C13[23:16];
            4'b0100: xtmux_1173 = wr1_data_C13[23:16];
            4'b0010: xtmux_1173 = wr2_data_C15[23:16];
            4'b0001: xtmux_1173 = wr3_data_C14[23:16];
        endcase
    end
    assign wmux7[23:16] = xtmux_1173;

    reg [7:0] xtmux_1174;
    always @(*) begin
        xtmux_1174 = 8'b0;
        case({wr0_word_we7_C13[3],
            wr1_word_we7_C13[3],
            wr2_word_we7_C15[3],
            wr3_word_we7_C14[3]}) 
/* synopsys full_case */
            4'b1000: xtmux_1174 = wr0_data_C13[31:24];
            4'b0100: xtmux_1174 = wr1_data_C13[31:24];
            4'b0010: xtmux_1174 = wr2_data_C15[31:24];
            4'b0001: xtmux_1174 = wr3_data_C14[31:24];
        endcase
    end
    assign wmux7[31:24] = xtmux_1174;

    reg [7:0] xtmux_1175;
    always @(*) begin
        xtmux_1175 = 8'b0;
        case({wr0_word_we7_C13[4],
            wr1_word_we7_C13[4],
            wr2_word_we7_C15[4],
            wr3_word_we7_C14[4]}) 
/* synopsys full_case */
            4'b1000: xtmux_1175 = wr0_data_C13[39:32];
            4'b0100: xtmux_1175 = wr1_data_C13[39:32];
            4'b0010: xtmux_1175 = wr2_data_C15[39:32];
            4'b0001: xtmux_1175 = wr3_data_C14[39:32];
        endcase
    end
    assign wmux7[39:32] = xtmux_1175;

    reg [7:0] xtmux_1176;
    always @(*) begin
        xtmux_1176 = 8'b0;
        case({wr0_word_we7_C13[5],
            wr1_word_we7_C13[5],
            wr2_word_we7_C15[5],
            wr3_word_we7_C14[5]}) 
/* synopsys full_case */
            4'b1000: xtmux_1176 = wr0_data_C13[47:40];
            4'b0100: xtmux_1176 = wr1_data_C13[47:40];
            4'b0010: xtmux_1176 = wr2_data_C15[47:40];
            4'b0001: xtmux_1176 = wr3_data_C14[47:40];
        endcase
    end
    assign wmux7[47:40] = xtmux_1176;

    reg [7:0] xtmux_1177;
    always @(*) begin
        xtmux_1177 = 8'b0;
        case({wr0_word_we7_C13[6],
            wr1_word_we7_C13[6],
            wr2_word_we7_C15[6],
            wr3_word_we7_C14[6]}) 
/* synopsys full_case */
            4'b1000: xtmux_1177 = wr0_data_C13[55:48];
            4'b0100: xtmux_1177 = wr1_data_C13[55:48];
            4'b0010: xtmux_1177 = wr2_data_C15[55:48];
            4'b0001: xtmux_1177 = wr3_data_C14[55:48];
        endcase
    end
    assign wmux7[55:48] = xtmux_1177;

    reg [7:0] xtmux_1178;
    always @(*) begin
        xtmux_1178 = 8'b0;
        case({wr0_word_we7_C13[7],
            wr1_word_we7_C13[7],
            wr2_word_we7_C15[7],
            wr3_word_we7_C14[7]}) 
/* synopsys full_case */
            4'b1000: xtmux_1178 = wr0_data_C13[63:56];
            4'b0100: xtmux_1178 = wr1_data_C13[63:56];
            4'b0010: xtmux_1178 = wr2_data_C15[63:56];
            4'b0001: xtmux_1178 = wr3_data_C14[63:56];
        endcase
    end
    assign wmux7[63:56] = xtmux_1178;

    reg [7:0] xtmux_1179;
    always @(*) begin
        xtmux_1179 = 8'b0;
        case({wr0_word_we7_C13[8],
            wr1_word_we7_C13[8],
            wr2_word_we7_C15[8],
            wr3_word_we7_C14[8]}) 
/* synopsys full_case */
            4'b1000: xtmux_1179 = wr0_data_C13[71:64];
            4'b0100: xtmux_1179 = wr1_data_C13[71:64];
            4'b0010: xtmux_1179 = wr2_data_C15[71:64];
            4'b0001: xtmux_1179 = wr3_data_C14[71:64];
        endcase
    end
    assign wmux7[71:64] = xtmux_1179;

    reg [7:0] xtmux_1180;
    always @(*) begin
        xtmux_1180 = 8'b0;
        case({wr0_word_we7_C13[9],
            wr1_word_we7_C13[9],
            wr2_word_we7_C15[9],
            wr3_word_we7_C14[9]}) 
/* synopsys full_case */
            4'b1000: xtmux_1180 = wr0_data_C13[79:72];
            4'b0100: xtmux_1180 = wr1_data_C13[79:72];
            4'b0010: xtmux_1180 = wr2_data_C15[79:72];
            4'b0001: xtmux_1180 = wr3_data_C14[79:72];
        endcase
    end
    assign wmux7[79:72] = xtmux_1180;

    reg [7:0] xtmux_1181;
    always @(*) begin
        xtmux_1181 = 8'b0;
        case({wr0_word_we7_C13[10],
            wr1_word_we7_C13[10],
            wr2_word_we7_C15[10],
            wr3_word_we7_C14[10]}) 
/* synopsys full_case */
            4'b1000: xtmux_1181 = wr0_data_C13[87:80];
            4'b0100: xtmux_1181 = wr1_data_C13[87:80];
            4'b0010: xtmux_1181 = wr2_data_C15[87:80];
            4'b0001: xtmux_1181 = wr3_data_C14[87:80];
        endcase
    end
    assign wmux7[87:80] = xtmux_1181;

    reg [7:0] xtmux_1182;
    always @(*) begin
        xtmux_1182 = 8'b0;
        case({wr0_word_we7_C13[11],
            wr1_word_we7_C13[11],
            wr2_word_we7_C15[11],
            wr3_word_we7_C14[11]}) 
/* synopsys full_case */
            4'b1000: xtmux_1182 = wr0_data_C13[95:88];
            4'b0100: xtmux_1182 = wr1_data_C13[95:88];
            4'b0010: xtmux_1182 = wr2_data_C15[95:88];
            4'b0001: xtmux_1182 = wr3_data_C14[95:88];
        endcase
    end
    assign wmux7[95:88] = xtmux_1182;

    reg [7:0] xtmux_1183;
    always @(*) begin
        xtmux_1183 = 8'b0;
        case({wr0_word_we7_C13[12],
            wr1_word_we7_C13[12],
            wr2_word_we7_C15[12],
            wr3_word_we7_C14[12]}) 
/* synopsys full_case */
            4'b1000: xtmux_1183 = wr0_data_C13[103:96];
            4'b0100: xtmux_1183 = wr1_data_C13[103:96];
            4'b0010: xtmux_1183 = wr2_data_C15[103:96];
            4'b0001: xtmux_1183 = wr3_data_C14[103:96];
        endcase
    end
    assign wmux7[103:96] = xtmux_1183;

    reg [7:0] xtmux_1184;
    always @(*) begin
        xtmux_1184 = 8'b0;
        case({wr0_word_we7_C13[13],
            wr1_word_we7_C13[13],
            wr2_word_we7_C15[13],
            wr3_word_we7_C14[13]}) 
/* synopsys full_case */
            4'b1000: xtmux_1184 = wr0_data_C13[111:104];
            4'b0100: xtmux_1184 = wr1_data_C13[111:104];
            4'b0010: xtmux_1184 = wr2_data_C15[111:104];
            4'b0001: xtmux_1184 = wr3_data_C14[111:104];
        endcase
    end
    assign wmux7[111:104] = xtmux_1184;

    reg [7:0] xtmux_1185;
    always @(*) begin
        xtmux_1185 = 8'b0;
        case({wr0_word_we7_C13[14],
            wr1_word_we7_C13[14],
            wr2_word_we7_C15[14],
            wr3_word_we7_C14[14]}) 
/* synopsys full_case */
            4'b1000: xtmux_1185 = wr0_data_C13[119:112];
            4'b0100: xtmux_1185 = wr1_data_C13[119:112];
            4'b0010: xtmux_1185 = wr2_data_C15[119:112];
            4'b0001: xtmux_1185 = wr3_data_C14[119:112];
        endcase
    end
    assign wmux7[119:112] = xtmux_1185;

    reg [7:0] xtmux_1186;
    always @(*) begin
        xtmux_1186 = 8'b0;
        case({wr0_word_we7_C13[15],
            wr1_word_we7_C13[15],
            wr2_word_we7_C15[15],
            wr3_word_we7_C14[15]}) 
/* synopsys full_case */
            4'b1000: xtmux_1186 = wr0_data_C13[127:120];
            4'b0100: xtmux_1186 = wr1_data_C13[127:120];
            4'b0010: xtmux_1186 = wr2_data_C15[127:120];
            4'b0001: xtmux_1186 = wr3_data_C14[127:120];
        endcase
    end
    assign wmux7[127:120] = xtmux_1186;

    wire [127:0] word7;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word7_p0;
    assign word7[7:0] = XACC_reg_word7_p0;
    always @(posedge clk or posedge localReset)
        XACC_reg_word7_p0 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk7_0) ? wmux7[7:0] : XACC_reg_word7_p0;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word7_p1;
    assign word7[15:8] = XACC_reg_word7_p1;
    always @(posedge clk or posedge localReset)
        XACC_reg_word7_p1 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk7_1) ? wmux7[15:8] : XACC_reg_word7_p1;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word7_p2;
    assign word7[23:16] = XACC_reg_word7_p2;
    always @(posedge clk or posedge localReset)
        XACC_reg_word7_p2 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk7_2) ? wmux7[23:16] : XACC_reg_word7_p2;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word7_p3;
    assign word7[31:24] = XACC_reg_word7_p3;
    always @(posedge clk or posedge localReset)
        XACC_reg_word7_p3 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk7_3) ? wmux7[31:24] : XACC_reg_word7_p3;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word7_p4;
    assign word7[39:32] = XACC_reg_word7_p4;
    always @(posedge clk or posedge localReset)
        XACC_reg_word7_p4 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk7_4) ? wmux7[39:32] : XACC_reg_word7_p4;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word7_p5;
    assign word7[47:40] = XACC_reg_word7_p5;
    always @(posedge clk or posedge localReset)
        XACC_reg_word7_p5 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk7_5) ? wmux7[47:40] : XACC_reg_word7_p5;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word7_p6;
    assign word7[55:48] = XACC_reg_word7_p6;
    always @(posedge clk or posedge localReset)
        XACC_reg_word7_p6 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk7_6) ? wmux7[55:48] : XACC_reg_word7_p6;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word7_p7;
    assign word7[63:56] = XACC_reg_word7_p7;
    always @(posedge clk or posedge localReset)
        XACC_reg_word7_p7 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk7_7) ? wmux7[63:56] : XACC_reg_word7_p7;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word7_p8;
    assign word7[71:64] = XACC_reg_word7_p8;
    always @(posedge clk or posedge localReset)
        XACC_reg_word7_p8 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk7_8) ? wmux7[71:64] : XACC_reg_word7_p8;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word7_p9;
    assign word7[79:72] = XACC_reg_word7_p9;
    always @(posedge clk or posedge localReset)
        XACC_reg_word7_p9 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk7_9) ? wmux7[79:72] : XACC_reg_word7_p9;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word7_p10;
    assign word7[87:80] = XACC_reg_word7_p10;
    always @(posedge clk or posedge localReset)
        XACC_reg_word7_p10 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk7_10) ? wmux7[87:80] : XACC_reg_word7_p10;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word7_p11;
    assign word7[95:88] = XACC_reg_word7_p11;
    always @(posedge clk or posedge localReset)
        XACC_reg_word7_p11 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk7_11) ? wmux7[95:88] : XACC_reg_word7_p11;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word7_p12;
    assign word7[103:96] = XACC_reg_word7_p12;
    always @(posedge clk or posedge localReset)
        XACC_reg_word7_p12 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk7_12) ? wmux7[103:96] : XACC_reg_word7_p12;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word7_p13;
    assign word7[111:104] = XACC_reg_word7_p13;
    always @(posedge clk or posedge localReset)
        XACC_reg_word7_p13 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk7_13) ? wmux7[111:104] : XACC_reg_word7_p13;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word7_p14;
    assign word7[119:112] = XACC_reg_word7_p14;
    always @(posedge clk or posedge localReset)
        XACC_reg_word7_p14 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk7_14) ? wmux7[119:112] : XACC_reg_word7_p14;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word7_p15;
    assign word7[127:120] = XACC_reg_word7_p15;
    always @(posedge clk or posedge localReset)
        XACC_reg_word7_p15 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk7_15) ? wmux7[127:120] : XACC_reg_word7_p15;

    wire [15:0] wr0_word_we8_C13 = wr0_we_C13 & {16{(wr0_addr_C13 == 5'd8)}};
    wire [15:0] wr1_word_we8_C13 = wr1_we_C13 & {16{(wr1_addr_C13 == 5'd8)}};
    wire [15:0] wr2_word_we8_C15 = wr2_we_C15 & {16{(wr2_addr_C15 == 5'd8)}};
    wire [15:0] wr3_word_we8_C14 = wr3_we_C14 & {16{(wr3_addr_C14 == 5'd8)}};
    wire [15:0] word8_we = 16'b0 | wr0_word_we8_C13 | wr1_word_we8_C13 | wr2_word_we8_C15 | wr3_word_we8_C14;
    wire gclk8_0;
assign gclk8_0 = word8_we[0];
    wire gclk8_1;
assign gclk8_1 = word8_we[1];
    wire gclk8_2;
assign gclk8_2 = word8_we[2];
    wire gclk8_3;
assign gclk8_3 = word8_we[3];
    wire gclk8_4;
assign gclk8_4 = word8_we[4];
    wire gclk8_5;
assign gclk8_5 = word8_we[5];
    wire gclk8_6;
assign gclk8_6 = word8_we[6];
    wire gclk8_7;
assign gclk8_7 = word8_we[7];
    wire gclk8_8;
assign gclk8_8 = word8_we[8];
    wire gclk8_9;
assign gclk8_9 = word8_we[9];
    wire gclk8_10;
assign gclk8_10 = word8_we[10];
    wire gclk8_11;
assign gclk8_11 = word8_we[11];
    wire gclk8_12;
assign gclk8_12 = word8_we[12];
    wire gclk8_13;
assign gclk8_13 = word8_we[13];
    wire gclk8_14;
assign gclk8_14 = word8_we[14];
    wire gclk8_15;
assign gclk8_15 = word8_we[15];
    wire [127:0] wmux8;
    reg [7:0] xtmux_1187;
    always @(*) begin
        xtmux_1187 = 8'b0;
        case({wr0_word_we8_C13[0],
            wr1_word_we8_C13[0],
            wr2_word_we8_C15[0],
            wr3_word_we8_C14[0]}) 
/* synopsys full_case */
            4'b1000: xtmux_1187 = wr0_data_C13[7:0];
            4'b0100: xtmux_1187 = wr1_data_C13[7:0];
            4'b0010: xtmux_1187 = wr2_data_C15[7:0];
            4'b0001: xtmux_1187 = wr3_data_C14[7:0];
        endcase
    end
    assign wmux8[7:0] = xtmux_1187;

    reg [7:0] xtmux_1188;
    always @(*) begin
        xtmux_1188 = 8'b0;
        case({wr0_word_we8_C13[1],
            wr1_word_we8_C13[1],
            wr2_word_we8_C15[1],
            wr3_word_we8_C14[1]}) 
/* synopsys full_case */
            4'b1000: xtmux_1188 = wr0_data_C13[15:8];
            4'b0100: xtmux_1188 = wr1_data_C13[15:8];
            4'b0010: xtmux_1188 = wr2_data_C15[15:8];
            4'b0001: xtmux_1188 = wr3_data_C14[15:8];
        endcase
    end
    assign wmux8[15:8] = xtmux_1188;

    reg [7:0] xtmux_1189;
    always @(*) begin
        xtmux_1189 = 8'b0;
        case({wr0_word_we8_C13[2],
            wr1_word_we8_C13[2],
            wr2_word_we8_C15[2],
            wr3_word_we8_C14[2]}) 
/* synopsys full_case */
            4'b1000: xtmux_1189 = wr0_data_C13[23:16];
            4'b0100: xtmux_1189 = wr1_data_C13[23:16];
            4'b0010: xtmux_1189 = wr2_data_C15[23:16];
            4'b0001: xtmux_1189 = wr3_data_C14[23:16];
        endcase
    end
    assign wmux8[23:16] = xtmux_1189;

    reg [7:0] xtmux_1190;
    always @(*) begin
        xtmux_1190 = 8'b0;
        case({wr0_word_we8_C13[3],
            wr1_word_we8_C13[3],
            wr2_word_we8_C15[3],
            wr3_word_we8_C14[3]}) 
/* synopsys full_case */
            4'b1000: xtmux_1190 = wr0_data_C13[31:24];
            4'b0100: xtmux_1190 = wr1_data_C13[31:24];
            4'b0010: xtmux_1190 = wr2_data_C15[31:24];
            4'b0001: xtmux_1190 = wr3_data_C14[31:24];
        endcase
    end
    assign wmux8[31:24] = xtmux_1190;

    reg [7:0] xtmux_1191;
    always @(*) begin
        xtmux_1191 = 8'b0;
        case({wr0_word_we8_C13[4],
            wr1_word_we8_C13[4],
            wr2_word_we8_C15[4],
            wr3_word_we8_C14[4]}) 
/* synopsys full_case */
            4'b1000: xtmux_1191 = wr0_data_C13[39:32];
            4'b0100: xtmux_1191 = wr1_data_C13[39:32];
            4'b0010: xtmux_1191 = wr2_data_C15[39:32];
            4'b0001: xtmux_1191 = wr3_data_C14[39:32];
        endcase
    end
    assign wmux8[39:32] = xtmux_1191;

    reg [7:0] xtmux_1192;
    always @(*) begin
        xtmux_1192 = 8'b0;
        case({wr0_word_we8_C13[5],
            wr1_word_we8_C13[5],
            wr2_word_we8_C15[5],
            wr3_word_we8_C14[5]}) 
/* synopsys full_case */
            4'b1000: xtmux_1192 = wr0_data_C13[47:40];
            4'b0100: xtmux_1192 = wr1_data_C13[47:40];
            4'b0010: xtmux_1192 = wr2_data_C15[47:40];
            4'b0001: xtmux_1192 = wr3_data_C14[47:40];
        endcase
    end
    assign wmux8[47:40] = xtmux_1192;

    reg [7:0] xtmux_1193;
    always @(*) begin
        xtmux_1193 = 8'b0;
        case({wr0_word_we8_C13[6],
            wr1_word_we8_C13[6],
            wr2_word_we8_C15[6],
            wr3_word_we8_C14[6]}) 
/* synopsys full_case */
            4'b1000: xtmux_1193 = wr0_data_C13[55:48];
            4'b0100: xtmux_1193 = wr1_data_C13[55:48];
            4'b0010: xtmux_1193 = wr2_data_C15[55:48];
            4'b0001: xtmux_1193 = wr3_data_C14[55:48];
        endcase
    end
    assign wmux8[55:48] = xtmux_1193;

    reg [7:0] xtmux_1194;
    always @(*) begin
        xtmux_1194 = 8'b0;
        case({wr0_word_we8_C13[7],
            wr1_word_we8_C13[7],
            wr2_word_we8_C15[7],
            wr3_word_we8_C14[7]}) 
/* synopsys full_case */
            4'b1000: xtmux_1194 = wr0_data_C13[63:56];
            4'b0100: xtmux_1194 = wr1_data_C13[63:56];
            4'b0010: xtmux_1194 = wr2_data_C15[63:56];
            4'b0001: xtmux_1194 = wr3_data_C14[63:56];
        endcase
    end
    assign wmux8[63:56] = xtmux_1194;

    reg [7:0] xtmux_1195;
    always @(*) begin
        xtmux_1195 = 8'b0;
        case({wr0_word_we8_C13[8],
            wr1_word_we8_C13[8],
            wr2_word_we8_C15[8],
            wr3_word_we8_C14[8]}) 
/* synopsys full_case */
            4'b1000: xtmux_1195 = wr0_data_C13[71:64];
            4'b0100: xtmux_1195 = wr1_data_C13[71:64];
            4'b0010: xtmux_1195 = wr2_data_C15[71:64];
            4'b0001: xtmux_1195 = wr3_data_C14[71:64];
        endcase
    end
    assign wmux8[71:64] = xtmux_1195;

    reg [7:0] xtmux_1196;
    always @(*) begin
        xtmux_1196 = 8'b0;
        case({wr0_word_we8_C13[9],
            wr1_word_we8_C13[9],
            wr2_word_we8_C15[9],
            wr3_word_we8_C14[9]}) 
/* synopsys full_case */
            4'b1000: xtmux_1196 = wr0_data_C13[79:72];
            4'b0100: xtmux_1196 = wr1_data_C13[79:72];
            4'b0010: xtmux_1196 = wr2_data_C15[79:72];
            4'b0001: xtmux_1196 = wr3_data_C14[79:72];
        endcase
    end
    assign wmux8[79:72] = xtmux_1196;

    reg [7:0] xtmux_1197;
    always @(*) begin
        xtmux_1197 = 8'b0;
        case({wr0_word_we8_C13[10],
            wr1_word_we8_C13[10],
            wr2_word_we8_C15[10],
            wr3_word_we8_C14[10]}) 
/* synopsys full_case */
            4'b1000: xtmux_1197 = wr0_data_C13[87:80];
            4'b0100: xtmux_1197 = wr1_data_C13[87:80];
            4'b0010: xtmux_1197 = wr2_data_C15[87:80];
            4'b0001: xtmux_1197 = wr3_data_C14[87:80];
        endcase
    end
    assign wmux8[87:80] = xtmux_1197;

    reg [7:0] xtmux_1198;
    always @(*) begin
        xtmux_1198 = 8'b0;
        case({wr0_word_we8_C13[11],
            wr1_word_we8_C13[11],
            wr2_word_we8_C15[11],
            wr3_word_we8_C14[11]}) 
/* synopsys full_case */
            4'b1000: xtmux_1198 = wr0_data_C13[95:88];
            4'b0100: xtmux_1198 = wr1_data_C13[95:88];
            4'b0010: xtmux_1198 = wr2_data_C15[95:88];
            4'b0001: xtmux_1198 = wr3_data_C14[95:88];
        endcase
    end
    assign wmux8[95:88] = xtmux_1198;

    reg [7:0] xtmux_1199;
    always @(*) begin
        xtmux_1199 = 8'b0;
        case({wr0_word_we8_C13[12],
            wr1_word_we8_C13[12],
            wr2_word_we8_C15[12],
            wr3_word_we8_C14[12]}) 
/* synopsys full_case */
            4'b1000: xtmux_1199 = wr0_data_C13[103:96];
            4'b0100: xtmux_1199 = wr1_data_C13[103:96];
            4'b0010: xtmux_1199 = wr2_data_C15[103:96];
            4'b0001: xtmux_1199 = wr3_data_C14[103:96];
        endcase
    end
    assign wmux8[103:96] = xtmux_1199;

    reg [7:0] xtmux_1200;
    always @(*) begin
        xtmux_1200 = 8'b0;
        case({wr0_word_we8_C13[13],
            wr1_word_we8_C13[13],
            wr2_word_we8_C15[13],
            wr3_word_we8_C14[13]}) 
/* synopsys full_case */
            4'b1000: xtmux_1200 = wr0_data_C13[111:104];
            4'b0100: xtmux_1200 = wr1_data_C13[111:104];
            4'b0010: xtmux_1200 = wr2_data_C15[111:104];
            4'b0001: xtmux_1200 = wr3_data_C14[111:104];
        endcase
    end
    assign wmux8[111:104] = xtmux_1200;

    reg [7:0] xtmux_1201;
    always @(*) begin
        xtmux_1201 = 8'b0;
        case({wr0_word_we8_C13[14],
            wr1_word_we8_C13[14],
            wr2_word_we8_C15[14],
            wr3_word_we8_C14[14]}) 
/* synopsys full_case */
            4'b1000: xtmux_1201 = wr0_data_C13[119:112];
            4'b0100: xtmux_1201 = wr1_data_C13[119:112];
            4'b0010: xtmux_1201 = wr2_data_C15[119:112];
            4'b0001: xtmux_1201 = wr3_data_C14[119:112];
        endcase
    end
    assign wmux8[119:112] = xtmux_1201;

    reg [7:0] xtmux_1202;
    always @(*) begin
        xtmux_1202 = 8'b0;
        case({wr0_word_we8_C13[15],
            wr1_word_we8_C13[15],
            wr2_word_we8_C15[15],
            wr3_word_we8_C14[15]}) 
/* synopsys full_case */
            4'b1000: xtmux_1202 = wr0_data_C13[127:120];
            4'b0100: xtmux_1202 = wr1_data_C13[127:120];
            4'b0010: xtmux_1202 = wr2_data_C15[127:120];
            4'b0001: xtmux_1202 = wr3_data_C14[127:120];
        endcase
    end
    assign wmux8[127:120] = xtmux_1202;

    wire [127:0] word8;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word8_p0;
    assign word8[7:0] = XACC_reg_word8_p0;
    always @(posedge clk or posedge localReset)
        XACC_reg_word8_p0 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk8_0) ? wmux8[7:0] : XACC_reg_word8_p0;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word8_p1;
    assign word8[15:8] = XACC_reg_word8_p1;
    always @(posedge clk or posedge localReset)
        XACC_reg_word8_p1 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk8_1) ? wmux8[15:8] : XACC_reg_word8_p1;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word8_p2;
    assign word8[23:16] = XACC_reg_word8_p2;
    always @(posedge clk or posedge localReset)
        XACC_reg_word8_p2 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk8_2) ? wmux8[23:16] : XACC_reg_word8_p2;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word8_p3;
    assign word8[31:24] = XACC_reg_word8_p3;
    always @(posedge clk or posedge localReset)
        XACC_reg_word8_p3 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk8_3) ? wmux8[31:24] : XACC_reg_word8_p3;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word8_p4;
    assign word8[39:32] = XACC_reg_word8_p4;
    always @(posedge clk or posedge localReset)
        XACC_reg_word8_p4 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk8_4) ? wmux8[39:32] : XACC_reg_word8_p4;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word8_p5;
    assign word8[47:40] = XACC_reg_word8_p5;
    always @(posedge clk or posedge localReset)
        XACC_reg_word8_p5 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk8_5) ? wmux8[47:40] : XACC_reg_word8_p5;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word8_p6;
    assign word8[55:48] = XACC_reg_word8_p6;
    always @(posedge clk or posedge localReset)
        XACC_reg_word8_p6 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk8_6) ? wmux8[55:48] : XACC_reg_word8_p6;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word8_p7;
    assign word8[63:56] = XACC_reg_word8_p7;
    always @(posedge clk or posedge localReset)
        XACC_reg_word8_p7 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk8_7) ? wmux8[63:56] : XACC_reg_word8_p7;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word8_p8;
    assign word8[71:64] = XACC_reg_word8_p8;
    always @(posedge clk or posedge localReset)
        XACC_reg_word8_p8 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk8_8) ? wmux8[71:64] : XACC_reg_word8_p8;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word8_p9;
    assign word8[79:72] = XACC_reg_word8_p9;
    always @(posedge clk or posedge localReset)
        XACC_reg_word8_p9 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk8_9) ? wmux8[79:72] : XACC_reg_word8_p9;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word8_p10;
    assign word8[87:80] = XACC_reg_word8_p10;
    always @(posedge clk or posedge localReset)
        XACC_reg_word8_p10 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk8_10) ? wmux8[87:80] : XACC_reg_word8_p10;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word8_p11;
    assign word8[95:88] = XACC_reg_word8_p11;
    always @(posedge clk or posedge localReset)
        XACC_reg_word8_p11 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk8_11) ? wmux8[95:88] : XACC_reg_word8_p11;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word8_p12;
    assign word8[103:96] = XACC_reg_word8_p12;
    always @(posedge clk or posedge localReset)
        XACC_reg_word8_p12 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk8_12) ? wmux8[103:96] : XACC_reg_word8_p12;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word8_p13;
    assign word8[111:104] = XACC_reg_word8_p13;
    always @(posedge clk or posedge localReset)
        XACC_reg_word8_p13 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk8_13) ? wmux8[111:104] : XACC_reg_word8_p13;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word8_p14;
    assign word8[119:112] = XACC_reg_word8_p14;
    always @(posedge clk or posedge localReset)
        XACC_reg_word8_p14 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk8_14) ? wmux8[119:112] : XACC_reg_word8_p14;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word8_p15;
    assign word8[127:120] = XACC_reg_word8_p15;
    always @(posedge clk or posedge localReset)
        XACC_reg_word8_p15 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk8_15) ? wmux8[127:120] : XACC_reg_word8_p15;

    wire [15:0] wr0_word_we9_C13 = wr0_we_C13 & {16{(wr0_addr_C13 == 5'd9)}};
    wire [15:0] wr1_word_we9_C13 = wr1_we_C13 & {16{(wr1_addr_C13 == 5'd9)}};
    wire [15:0] wr2_word_we9_C15 = wr2_we_C15 & {16{(wr2_addr_C15 == 5'd9)}};
    wire [15:0] wr3_word_we9_C14 = wr3_we_C14 & {16{(wr3_addr_C14 == 5'd9)}};
    wire [15:0] word9_we = 16'b0 | wr0_word_we9_C13 | wr1_word_we9_C13 | wr2_word_we9_C15 | wr3_word_we9_C14;
    wire gclk9_0;
assign gclk9_0 = word9_we[0];
    wire gclk9_1;
assign gclk9_1 = word9_we[1];
    wire gclk9_2;
assign gclk9_2 = word9_we[2];
    wire gclk9_3;
assign gclk9_3 = word9_we[3];
    wire gclk9_4;
assign gclk9_4 = word9_we[4];
    wire gclk9_5;
assign gclk9_5 = word9_we[5];
    wire gclk9_6;
assign gclk9_6 = word9_we[6];
    wire gclk9_7;
assign gclk9_7 = word9_we[7];
    wire gclk9_8;
assign gclk9_8 = word9_we[8];
    wire gclk9_9;
assign gclk9_9 = word9_we[9];
    wire gclk9_10;
assign gclk9_10 = word9_we[10];
    wire gclk9_11;
assign gclk9_11 = word9_we[11];
    wire gclk9_12;
assign gclk9_12 = word9_we[12];
    wire gclk9_13;
assign gclk9_13 = word9_we[13];
    wire gclk9_14;
assign gclk9_14 = word9_we[14];
    wire gclk9_15;
assign gclk9_15 = word9_we[15];
    wire [127:0] wmux9;
    reg [7:0] xtmux_1203;
    always @(*) begin
        xtmux_1203 = 8'b0;
        case({wr0_word_we9_C13[0],
            wr1_word_we9_C13[0],
            wr2_word_we9_C15[0],
            wr3_word_we9_C14[0]}) 
/* synopsys full_case */
            4'b1000: xtmux_1203 = wr0_data_C13[7:0];
            4'b0100: xtmux_1203 = wr1_data_C13[7:0];
            4'b0010: xtmux_1203 = wr2_data_C15[7:0];
            4'b0001: xtmux_1203 = wr3_data_C14[7:0];
        endcase
    end
    assign wmux9[7:0] = xtmux_1203;

    reg [7:0] xtmux_1204;
    always @(*) begin
        xtmux_1204 = 8'b0;
        case({wr0_word_we9_C13[1],
            wr1_word_we9_C13[1],
            wr2_word_we9_C15[1],
            wr3_word_we9_C14[1]}) 
/* synopsys full_case */
            4'b1000: xtmux_1204 = wr0_data_C13[15:8];
            4'b0100: xtmux_1204 = wr1_data_C13[15:8];
            4'b0010: xtmux_1204 = wr2_data_C15[15:8];
            4'b0001: xtmux_1204 = wr3_data_C14[15:8];
        endcase
    end
    assign wmux9[15:8] = xtmux_1204;

    reg [7:0] xtmux_1205;
    always @(*) begin
        xtmux_1205 = 8'b0;
        case({wr0_word_we9_C13[2],
            wr1_word_we9_C13[2],
            wr2_word_we9_C15[2],
            wr3_word_we9_C14[2]}) 
/* synopsys full_case */
            4'b1000: xtmux_1205 = wr0_data_C13[23:16];
            4'b0100: xtmux_1205 = wr1_data_C13[23:16];
            4'b0010: xtmux_1205 = wr2_data_C15[23:16];
            4'b0001: xtmux_1205 = wr3_data_C14[23:16];
        endcase
    end
    assign wmux9[23:16] = xtmux_1205;

    reg [7:0] xtmux_1206;
    always @(*) begin
        xtmux_1206 = 8'b0;
        case({wr0_word_we9_C13[3],
            wr1_word_we9_C13[3],
            wr2_word_we9_C15[3],
            wr3_word_we9_C14[3]}) 
/* synopsys full_case */
            4'b1000: xtmux_1206 = wr0_data_C13[31:24];
            4'b0100: xtmux_1206 = wr1_data_C13[31:24];
            4'b0010: xtmux_1206 = wr2_data_C15[31:24];
            4'b0001: xtmux_1206 = wr3_data_C14[31:24];
        endcase
    end
    assign wmux9[31:24] = xtmux_1206;

    reg [7:0] xtmux_1207;
    always @(*) begin
        xtmux_1207 = 8'b0;
        case({wr0_word_we9_C13[4],
            wr1_word_we9_C13[4],
            wr2_word_we9_C15[4],
            wr3_word_we9_C14[4]}) 
/* synopsys full_case */
            4'b1000: xtmux_1207 = wr0_data_C13[39:32];
            4'b0100: xtmux_1207 = wr1_data_C13[39:32];
            4'b0010: xtmux_1207 = wr2_data_C15[39:32];
            4'b0001: xtmux_1207 = wr3_data_C14[39:32];
        endcase
    end
    assign wmux9[39:32] = xtmux_1207;

    reg [7:0] xtmux_1208;
    always @(*) begin
        xtmux_1208 = 8'b0;
        case({wr0_word_we9_C13[5],
            wr1_word_we9_C13[5],
            wr2_word_we9_C15[5],
            wr3_word_we9_C14[5]}) 
/* synopsys full_case */
            4'b1000: xtmux_1208 = wr0_data_C13[47:40];
            4'b0100: xtmux_1208 = wr1_data_C13[47:40];
            4'b0010: xtmux_1208 = wr2_data_C15[47:40];
            4'b0001: xtmux_1208 = wr3_data_C14[47:40];
        endcase
    end
    assign wmux9[47:40] = xtmux_1208;

    reg [7:0] xtmux_1209;
    always @(*) begin
        xtmux_1209 = 8'b0;
        case({wr0_word_we9_C13[6],
            wr1_word_we9_C13[6],
            wr2_word_we9_C15[6],
            wr3_word_we9_C14[6]}) 
/* synopsys full_case */
            4'b1000: xtmux_1209 = wr0_data_C13[55:48];
            4'b0100: xtmux_1209 = wr1_data_C13[55:48];
            4'b0010: xtmux_1209 = wr2_data_C15[55:48];
            4'b0001: xtmux_1209 = wr3_data_C14[55:48];
        endcase
    end
    assign wmux9[55:48] = xtmux_1209;

    reg [7:0] xtmux_1210;
    always @(*) begin
        xtmux_1210 = 8'b0;
        case({wr0_word_we9_C13[7],
            wr1_word_we9_C13[7],
            wr2_word_we9_C15[7],
            wr3_word_we9_C14[7]}) 
/* synopsys full_case */
            4'b1000: xtmux_1210 = wr0_data_C13[63:56];
            4'b0100: xtmux_1210 = wr1_data_C13[63:56];
            4'b0010: xtmux_1210 = wr2_data_C15[63:56];
            4'b0001: xtmux_1210 = wr3_data_C14[63:56];
        endcase
    end
    assign wmux9[63:56] = xtmux_1210;

    reg [7:0] xtmux_1211;
    always @(*) begin
        xtmux_1211 = 8'b0;
        case({wr0_word_we9_C13[8],
            wr1_word_we9_C13[8],
            wr2_word_we9_C15[8],
            wr3_word_we9_C14[8]}) 
/* synopsys full_case */
            4'b1000: xtmux_1211 = wr0_data_C13[71:64];
            4'b0100: xtmux_1211 = wr1_data_C13[71:64];
            4'b0010: xtmux_1211 = wr2_data_C15[71:64];
            4'b0001: xtmux_1211 = wr3_data_C14[71:64];
        endcase
    end
    assign wmux9[71:64] = xtmux_1211;

    reg [7:0] xtmux_1212;
    always @(*) begin
        xtmux_1212 = 8'b0;
        case({wr0_word_we9_C13[9],
            wr1_word_we9_C13[9],
            wr2_word_we9_C15[9],
            wr3_word_we9_C14[9]}) 
/* synopsys full_case */
            4'b1000: xtmux_1212 = wr0_data_C13[79:72];
            4'b0100: xtmux_1212 = wr1_data_C13[79:72];
            4'b0010: xtmux_1212 = wr2_data_C15[79:72];
            4'b0001: xtmux_1212 = wr3_data_C14[79:72];
        endcase
    end
    assign wmux9[79:72] = xtmux_1212;

    reg [7:0] xtmux_1213;
    always @(*) begin
        xtmux_1213 = 8'b0;
        case({wr0_word_we9_C13[10],
            wr1_word_we9_C13[10],
            wr2_word_we9_C15[10],
            wr3_word_we9_C14[10]}) 
/* synopsys full_case */
            4'b1000: xtmux_1213 = wr0_data_C13[87:80];
            4'b0100: xtmux_1213 = wr1_data_C13[87:80];
            4'b0010: xtmux_1213 = wr2_data_C15[87:80];
            4'b0001: xtmux_1213 = wr3_data_C14[87:80];
        endcase
    end
    assign wmux9[87:80] = xtmux_1213;

    reg [7:0] xtmux_1214;
    always @(*) begin
        xtmux_1214 = 8'b0;
        case({wr0_word_we9_C13[11],
            wr1_word_we9_C13[11],
            wr2_word_we9_C15[11],
            wr3_word_we9_C14[11]}) 
/* synopsys full_case */
            4'b1000: xtmux_1214 = wr0_data_C13[95:88];
            4'b0100: xtmux_1214 = wr1_data_C13[95:88];
            4'b0010: xtmux_1214 = wr2_data_C15[95:88];
            4'b0001: xtmux_1214 = wr3_data_C14[95:88];
        endcase
    end
    assign wmux9[95:88] = xtmux_1214;

    reg [7:0] xtmux_1215;
    always @(*) begin
        xtmux_1215 = 8'b0;
        case({wr0_word_we9_C13[12],
            wr1_word_we9_C13[12],
            wr2_word_we9_C15[12],
            wr3_word_we9_C14[12]}) 
/* synopsys full_case */
            4'b1000: xtmux_1215 = wr0_data_C13[103:96];
            4'b0100: xtmux_1215 = wr1_data_C13[103:96];
            4'b0010: xtmux_1215 = wr2_data_C15[103:96];
            4'b0001: xtmux_1215 = wr3_data_C14[103:96];
        endcase
    end
    assign wmux9[103:96] = xtmux_1215;

    reg [7:0] xtmux_1216;
    always @(*) begin
        xtmux_1216 = 8'b0;
        case({wr0_word_we9_C13[13],
            wr1_word_we9_C13[13],
            wr2_word_we9_C15[13],
            wr3_word_we9_C14[13]}) 
/* synopsys full_case */
            4'b1000: xtmux_1216 = wr0_data_C13[111:104];
            4'b0100: xtmux_1216 = wr1_data_C13[111:104];
            4'b0010: xtmux_1216 = wr2_data_C15[111:104];
            4'b0001: xtmux_1216 = wr3_data_C14[111:104];
        endcase
    end
    assign wmux9[111:104] = xtmux_1216;

    reg [7:0] xtmux_1217;
    always @(*) begin
        xtmux_1217 = 8'b0;
        case({wr0_word_we9_C13[14],
            wr1_word_we9_C13[14],
            wr2_word_we9_C15[14],
            wr3_word_we9_C14[14]}) 
/* synopsys full_case */
            4'b1000: xtmux_1217 = wr0_data_C13[119:112];
            4'b0100: xtmux_1217 = wr1_data_C13[119:112];
            4'b0010: xtmux_1217 = wr2_data_C15[119:112];
            4'b0001: xtmux_1217 = wr3_data_C14[119:112];
        endcase
    end
    assign wmux9[119:112] = xtmux_1217;

    reg [7:0] xtmux_1218;
    always @(*) begin
        xtmux_1218 = 8'b0;
        case({wr0_word_we9_C13[15],
            wr1_word_we9_C13[15],
            wr2_word_we9_C15[15],
            wr3_word_we9_C14[15]}) 
/* synopsys full_case */
            4'b1000: xtmux_1218 = wr0_data_C13[127:120];
            4'b0100: xtmux_1218 = wr1_data_C13[127:120];
            4'b0010: xtmux_1218 = wr2_data_C15[127:120];
            4'b0001: xtmux_1218 = wr3_data_C14[127:120];
        endcase
    end
    assign wmux9[127:120] = xtmux_1218;

    wire [127:0] word9;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word9_p0;
    assign word9[7:0] = XACC_reg_word9_p0;
    always @(posedge clk or posedge localReset)
        XACC_reg_word9_p0 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk9_0) ? wmux9[7:0] : XACC_reg_word9_p0;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word9_p1;
    assign word9[15:8] = XACC_reg_word9_p1;
    always @(posedge clk or posedge localReset)
        XACC_reg_word9_p1 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk9_1) ? wmux9[15:8] : XACC_reg_word9_p1;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word9_p2;
    assign word9[23:16] = XACC_reg_word9_p2;
    always @(posedge clk or posedge localReset)
        XACC_reg_word9_p2 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk9_2) ? wmux9[23:16] : XACC_reg_word9_p2;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word9_p3;
    assign word9[31:24] = XACC_reg_word9_p3;
    always @(posedge clk or posedge localReset)
        XACC_reg_word9_p3 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk9_3) ? wmux9[31:24] : XACC_reg_word9_p3;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word9_p4;
    assign word9[39:32] = XACC_reg_word9_p4;
    always @(posedge clk or posedge localReset)
        XACC_reg_word9_p4 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk9_4) ? wmux9[39:32] : XACC_reg_word9_p4;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word9_p5;
    assign word9[47:40] = XACC_reg_word9_p5;
    always @(posedge clk or posedge localReset)
        XACC_reg_word9_p5 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk9_5) ? wmux9[47:40] : XACC_reg_word9_p5;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word9_p6;
    assign word9[55:48] = XACC_reg_word9_p6;
    always @(posedge clk or posedge localReset)
        XACC_reg_word9_p6 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk9_6) ? wmux9[55:48] : XACC_reg_word9_p6;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word9_p7;
    assign word9[63:56] = XACC_reg_word9_p7;
    always @(posedge clk or posedge localReset)
        XACC_reg_word9_p7 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk9_7) ? wmux9[63:56] : XACC_reg_word9_p7;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word9_p8;
    assign word9[71:64] = XACC_reg_word9_p8;
    always @(posedge clk or posedge localReset)
        XACC_reg_word9_p8 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk9_8) ? wmux9[71:64] : XACC_reg_word9_p8;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word9_p9;
    assign word9[79:72] = XACC_reg_word9_p9;
    always @(posedge clk or posedge localReset)
        XACC_reg_word9_p9 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk9_9) ? wmux9[79:72] : XACC_reg_word9_p9;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word9_p10;
    assign word9[87:80] = XACC_reg_word9_p10;
    always @(posedge clk or posedge localReset)
        XACC_reg_word9_p10 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk9_10) ? wmux9[87:80] : XACC_reg_word9_p10;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word9_p11;
    assign word9[95:88] = XACC_reg_word9_p11;
    always @(posedge clk or posedge localReset)
        XACC_reg_word9_p11 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk9_11) ? wmux9[95:88] : XACC_reg_word9_p11;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word9_p12;
    assign word9[103:96] = XACC_reg_word9_p12;
    always @(posedge clk or posedge localReset)
        XACC_reg_word9_p12 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk9_12) ? wmux9[103:96] : XACC_reg_word9_p12;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word9_p13;
    assign word9[111:104] = XACC_reg_word9_p13;
    always @(posedge clk or posedge localReset)
        XACC_reg_word9_p13 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk9_13) ? wmux9[111:104] : XACC_reg_word9_p13;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word9_p14;
    assign word9[119:112] = XACC_reg_word9_p14;
    always @(posedge clk or posedge localReset)
        XACC_reg_word9_p14 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk9_14) ? wmux9[119:112] : XACC_reg_word9_p14;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word9_p15;
    assign word9[127:120] = XACC_reg_word9_p15;
    always @(posedge clk or posedge localReset)
        XACC_reg_word9_p15 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk9_15) ? wmux9[127:120] : XACC_reg_word9_p15;

    wire [15:0] wr0_word_we10_C13 = wr0_we_C13 & {16{(wr0_addr_C13 == 5'd10)}};
    wire [15:0] wr1_word_we10_C13 = wr1_we_C13 & {16{(wr1_addr_C13 == 5'd10)}};
    wire [15:0] wr2_word_we10_C15 = wr2_we_C15 & {16{(wr2_addr_C15 == 5'd10)}};
    wire [15:0] wr3_word_we10_C14 = wr3_we_C14 & {16{(wr3_addr_C14 == 5'd10)}};
    wire [15:0] word10_we = 16'b0 | wr0_word_we10_C13 | wr1_word_we10_C13 | wr2_word_we10_C15 | wr3_word_we10_C14;
    wire gclk10_0;
assign gclk10_0 = word10_we[0];
    wire gclk10_1;
assign gclk10_1 = word10_we[1];
    wire gclk10_2;
assign gclk10_2 = word10_we[2];
    wire gclk10_3;
assign gclk10_3 = word10_we[3];
    wire gclk10_4;
assign gclk10_4 = word10_we[4];
    wire gclk10_5;
assign gclk10_5 = word10_we[5];
    wire gclk10_6;
assign gclk10_6 = word10_we[6];
    wire gclk10_7;
assign gclk10_7 = word10_we[7];
    wire gclk10_8;
assign gclk10_8 = word10_we[8];
    wire gclk10_9;
assign gclk10_9 = word10_we[9];
    wire gclk10_10;
assign gclk10_10 = word10_we[10];
    wire gclk10_11;
assign gclk10_11 = word10_we[11];
    wire gclk10_12;
assign gclk10_12 = word10_we[12];
    wire gclk10_13;
assign gclk10_13 = word10_we[13];
    wire gclk10_14;
assign gclk10_14 = word10_we[14];
    wire gclk10_15;
assign gclk10_15 = word10_we[15];
    wire [127:0] wmux10;
    reg [7:0] xtmux_1219;
    always @(*) begin
        xtmux_1219 = 8'b0;
        case({wr0_word_we10_C13[0],
            wr1_word_we10_C13[0],
            wr2_word_we10_C15[0],
            wr3_word_we10_C14[0]}) 
/* synopsys full_case */
            4'b1000: xtmux_1219 = wr0_data_C13[7:0];
            4'b0100: xtmux_1219 = wr1_data_C13[7:0];
            4'b0010: xtmux_1219 = wr2_data_C15[7:0];
            4'b0001: xtmux_1219 = wr3_data_C14[7:0];
        endcase
    end
    assign wmux10[7:0] = xtmux_1219;

    reg [7:0] xtmux_1220;
    always @(*) begin
        xtmux_1220 = 8'b0;
        case({wr0_word_we10_C13[1],
            wr1_word_we10_C13[1],
            wr2_word_we10_C15[1],
            wr3_word_we10_C14[1]}) 
/* synopsys full_case */
            4'b1000: xtmux_1220 = wr0_data_C13[15:8];
            4'b0100: xtmux_1220 = wr1_data_C13[15:8];
            4'b0010: xtmux_1220 = wr2_data_C15[15:8];
            4'b0001: xtmux_1220 = wr3_data_C14[15:8];
        endcase
    end
    assign wmux10[15:8] = xtmux_1220;

    reg [7:0] xtmux_1221;
    always @(*) begin
        xtmux_1221 = 8'b0;
        case({wr0_word_we10_C13[2],
            wr1_word_we10_C13[2],
            wr2_word_we10_C15[2],
            wr3_word_we10_C14[2]}) 
/* synopsys full_case */
            4'b1000: xtmux_1221 = wr0_data_C13[23:16];
            4'b0100: xtmux_1221 = wr1_data_C13[23:16];
            4'b0010: xtmux_1221 = wr2_data_C15[23:16];
            4'b0001: xtmux_1221 = wr3_data_C14[23:16];
        endcase
    end
    assign wmux10[23:16] = xtmux_1221;

    reg [7:0] xtmux_1222;
    always @(*) begin
        xtmux_1222 = 8'b0;
        case({wr0_word_we10_C13[3],
            wr1_word_we10_C13[3],
            wr2_word_we10_C15[3],
            wr3_word_we10_C14[3]}) 
/* synopsys full_case */
            4'b1000: xtmux_1222 = wr0_data_C13[31:24];
            4'b0100: xtmux_1222 = wr1_data_C13[31:24];
            4'b0010: xtmux_1222 = wr2_data_C15[31:24];
            4'b0001: xtmux_1222 = wr3_data_C14[31:24];
        endcase
    end
    assign wmux10[31:24] = xtmux_1222;

    reg [7:0] xtmux_1223;
    always @(*) begin
        xtmux_1223 = 8'b0;
        case({wr0_word_we10_C13[4],
            wr1_word_we10_C13[4],
            wr2_word_we10_C15[4],
            wr3_word_we10_C14[4]}) 
/* synopsys full_case */
            4'b1000: xtmux_1223 = wr0_data_C13[39:32];
            4'b0100: xtmux_1223 = wr1_data_C13[39:32];
            4'b0010: xtmux_1223 = wr2_data_C15[39:32];
            4'b0001: xtmux_1223 = wr3_data_C14[39:32];
        endcase
    end
    assign wmux10[39:32] = xtmux_1223;

    reg [7:0] xtmux_1224;
    always @(*) begin
        xtmux_1224 = 8'b0;
        case({wr0_word_we10_C13[5],
            wr1_word_we10_C13[5],
            wr2_word_we10_C15[5],
            wr3_word_we10_C14[5]}) 
/* synopsys full_case */
            4'b1000: xtmux_1224 = wr0_data_C13[47:40];
            4'b0100: xtmux_1224 = wr1_data_C13[47:40];
            4'b0010: xtmux_1224 = wr2_data_C15[47:40];
            4'b0001: xtmux_1224 = wr3_data_C14[47:40];
        endcase
    end
    assign wmux10[47:40] = xtmux_1224;

    reg [7:0] xtmux_1225;
    always @(*) begin
        xtmux_1225 = 8'b0;
        case({wr0_word_we10_C13[6],
            wr1_word_we10_C13[6],
            wr2_word_we10_C15[6],
            wr3_word_we10_C14[6]}) 
/* synopsys full_case */
            4'b1000: xtmux_1225 = wr0_data_C13[55:48];
            4'b0100: xtmux_1225 = wr1_data_C13[55:48];
            4'b0010: xtmux_1225 = wr2_data_C15[55:48];
            4'b0001: xtmux_1225 = wr3_data_C14[55:48];
        endcase
    end
    assign wmux10[55:48] = xtmux_1225;

    reg [7:0] xtmux_1226;
    always @(*) begin
        xtmux_1226 = 8'b0;
        case({wr0_word_we10_C13[7],
            wr1_word_we10_C13[7],
            wr2_word_we10_C15[7],
            wr3_word_we10_C14[7]}) 
/* synopsys full_case */
            4'b1000: xtmux_1226 = wr0_data_C13[63:56];
            4'b0100: xtmux_1226 = wr1_data_C13[63:56];
            4'b0010: xtmux_1226 = wr2_data_C15[63:56];
            4'b0001: xtmux_1226 = wr3_data_C14[63:56];
        endcase
    end
    assign wmux10[63:56] = xtmux_1226;

    reg [7:0] xtmux_1227;
    always @(*) begin
        xtmux_1227 = 8'b0;
        case({wr0_word_we10_C13[8],
            wr1_word_we10_C13[8],
            wr2_word_we10_C15[8],
            wr3_word_we10_C14[8]}) 
/* synopsys full_case */
            4'b1000: xtmux_1227 = wr0_data_C13[71:64];
            4'b0100: xtmux_1227 = wr1_data_C13[71:64];
            4'b0010: xtmux_1227 = wr2_data_C15[71:64];
            4'b0001: xtmux_1227 = wr3_data_C14[71:64];
        endcase
    end
    assign wmux10[71:64] = xtmux_1227;

    reg [7:0] xtmux_1228;
    always @(*) begin
        xtmux_1228 = 8'b0;
        case({wr0_word_we10_C13[9],
            wr1_word_we10_C13[9],
            wr2_word_we10_C15[9],
            wr3_word_we10_C14[9]}) 
/* synopsys full_case */
            4'b1000: xtmux_1228 = wr0_data_C13[79:72];
            4'b0100: xtmux_1228 = wr1_data_C13[79:72];
            4'b0010: xtmux_1228 = wr2_data_C15[79:72];
            4'b0001: xtmux_1228 = wr3_data_C14[79:72];
        endcase
    end
    assign wmux10[79:72] = xtmux_1228;

    reg [7:0] xtmux_1229;
    always @(*) begin
        xtmux_1229 = 8'b0;
        case({wr0_word_we10_C13[10],
            wr1_word_we10_C13[10],
            wr2_word_we10_C15[10],
            wr3_word_we10_C14[10]}) 
/* synopsys full_case */
            4'b1000: xtmux_1229 = wr0_data_C13[87:80];
            4'b0100: xtmux_1229 = wr1_data_C13[87:80];
            4'b0010: xtmux_1229 = wr2_data_C15[87:80];
            4'b0001: xtmux_1229 = wr3_data_C14[87:80];
        endcase
    end
    assign wmux10[87:80] = xtmux_1229;

    reg [7:0] xtmux_1230;
    always @(*) begin
        xtmux_1230 = 8'b0;
        case({wr0_word_we10_C13[11],
            wr1_word_we10_C13[11],
            wr2_word_we10_C15[11],
            wr3_word_we10_C14[11]}) 
/* synopsys full_case */
            4'b1000: xtmux_1230 = wr0_data_C13[95:88];
            4'b0100: xtmux_1230 = wr1_data_C13[95:88];
            4'b0010: xtmux_1230 = wr2_data_C15[95:88];
            4'b0001: xtmux_1230 = wr3_data_C14[95:88];
        endcase
    end
    assign wmux10[95:88] = xtmux_1230;

    reg [7:0] xtmux_1231;
    always @(*) begin
        xtmux_1231 = 8'b0;
        case({wr0_word_we10_C13[12],
            wr1_word_we10_C13[12],
            wr2_word_we10_C15[12],
            wr3_word_we10_C14[12]}) 
/* synopsys full_case */
            4'b1000: xtmux_1231 = wr0_data_C13[103:96];
            4'b0100: xtmux_1231 = wr1_data_C13[103:96];
            4'b0010: xtmux_1231 = wr2_data_C15[103:96];
            4'b0001: xtmux_1231 = wr3_data_C14[103:96];
        endcase
    end
    assign wmux10[103:96] = xtmux_1231;

    reg [7:0] xtmux_1232;
    always @(*) begin
        xtmux_1232 = 8'b0;
        case({wr0_word_we10_C13[13],
            wr1_word_we10_C13[13],
            wr2_word_we10_C15[13],
            wr3_word_we10_C14[13]}) 
/* synopsys full_case */
            4'b1000: xtmux_1232 = wr0_data_C13[111:104];
            4'b0100: xtmux_1232 = wr1_data_C13[111:104];
            4'b0010: xtmux_1232 = wr2_data_C15[111:104];
            4'b0001: xtmux_1232 = wr3_data_C14[111:104];
        endcase
    end
    assign wmux10[111:104] = xtmux_1232;

    reg [7:0] xtmux_1233;
    always @(*) begin
        xtmux_1233 = 8'b0;
        case({wr0_word_we10_C13[14],
            wr1_word_we10_C13[14],
            wr2_word_we10_C15[14],
            wr3_word_we10_C14[14]}) 
/* synopsys full_case */
            4'b1000: xtmux_1233 = wr0_data_C13[119:112];
            4'b0100: xtmux_1233 = wr1_data_C13[119:112];
            4'b0010: xtmux_1233 = wr2_data_C15[119:112];
            4'b0001: xtmux_1233 = wr3_data_C14[119:112];
        endcase
    end
    assign wmux10[119:112] = xtmux_1233;

    reg [7:0] xtmux_1234;
    always @(*) begin
        xtmux_1234 = 8'b0;
        case({wr0_word_we10_C13[15],
            wr1_word_we10_C13[15],
            wr2_word_we10_C15[15],
            wr3_word_we10_C14[15]}) 
/* synopsys full_case */
            4'b1000: xtmux_1234 = wr0_data_C13[127:120];
            4'b0100: xtmux_1234 = wr1_data_C13[127:120];
            4'b0010: xtmux_1234 = wr2_data_C15[127:120];
            4'b0001: xtmux_1234 = wr3_data_C14[127:120];
        endcase
    end
    assign wmux10[127:120] = xtmux_1234;

    wire [127:0] word10;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word10_p0;
    assign word10[7:0] = XACC_reg_word10_p0;
    always @(posedge clk or posedge localReset)
        XACC_reg_word10_p0 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk10_0) ? wmux10[7:0] : XACC_reg_word10_p0;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word10_p1;
    assign word10[15:8] = XACC_reg_word10_p1;
    always @(posedge clk or posedge localReset)
        XACC_reg_word10_p1 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk10_1) ? wmux10[15:8] : XACC_reg_word10_p1;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word10_p2;
    assign word10[23:16] = XACC_reg_word10_p2;
    always @(posedge clk or posedge localReset)
        XACC_reg_word10_p2 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk10_2) ? wmux10[23:16] : XACC_reg_word10_p2;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word10_p3;
    assign word10[31:24] = XACC_reg_word10_p3;
    always @(posedge clk or posedge localReset)
        XACC_reg_word10_p3 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk10_3) ? wmux10[31:24] : XACC_reg_word10_p3;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word10_p4;
    assign word10[39:32] = XACC_reg_word10_p4;
    always @(posedge clk or posedge localReset)
        XACC_reg_word10_p4 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk10_4) ? wmux10[39:32] : XACC_reg_word10_p4;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word10_p5;
    assign word10[47:40] = XACC_reg_word10_p5;
    always @(posedge clk or posedge localReset)
        XACC_reg_word10_p5 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk10_5) ? wmux10[47:40] : XACC_reg_word10_p5;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word10_p6;
    assign word10[55:48] = XACC_reg_word10_p6;
    always @(posedge clk or posedge localReset)
        XACC_reg_word10_p6 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk10_6) ? wmux10[55:48] : XACC_reg_word10_p6;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word10_p7;
    assign word10[63:56] = XACC_reg_word10_p7;
    always @(posedge clk or posedge localReset)
        XACC_reg_word10_p7 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk10_7) ? wmux10[63:56] : XACC_reg_word10_p7;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word10_p8;
    assign word10[71:64] = XACC_reg_word10_p8;
    always @(posedge clk or posedge localReset)
        XACC_reg_word10_p8 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk10_8) ? wmux10[71:64] : XACC_reg_word10_p8;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word10_p9;
    assign word10[79:72] = XACC_reg_word10_p9;
    always @(posedge clk or posedge localReset)
        XACC_reg_word10_p9 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk10_9) ? wmux10[79:72] : XACC_reg_word10_p9;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word10_p10;
    assign word10[87:80] = XACC_reg_word10_p10;
    always @(posedge clk or posedge localReset)
        XACC_reg_word10_p10 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk10_10) ? wmux10[87:80] : XACC_reg_word10_p10;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word10_p11;
    assign word10[95:88] = XACC_reg_word10_p11;
    always @(posedge clk or posedge localReset)
        XACC_reg_word10_p11 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk10_11) ? wmux10[95:88] : XACC_reg_word10_p11;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word10_p12;
    assign word10[103:96] = XACC_reg_word10_p12;
    always @(posedge clk or posedge localReset)
        XACC_reg_word10_p12 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk10_12) ? wmux10[103:96] : XACC_reg_word10_p12;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word10_p13;
    assign word10[111:104] = XACC_reg_word10_p13;
    always @(posedge clk or posedge localReset)
        XACC_reg_word10_p13 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk10_13) ? wmux10[111:104] : XACC_reg_word10_p13;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word10_p14;
    assign word10[119:112] = XACC_reg_word10_p14;
    always @(posedge clk or posedge localReset)
        XACC_reg_word10_p14 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk10_14) ? wmux10[119:112] : XACC_reg_word10_p14;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word10_p15;
    assign word10[127:120] = XACC_reg_word10_p15;
    always @(posedge clk or posedge localReset)
        XACC_reg_word10_p15 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk10_15) ? wmux10[127:120] : XACC_reg_word10_p15;

    wire [15:0] wr0_word_we11_C13 = wr0_we_C13 & {16{(wr0_addr_C13 == 5'd11)}};
    wire [15:0] wr1_word_we11_C13 = wr1_we_C13 & {16{(wr1_addr_C13 == 5'd11)}};
    wire [15:0] wr2_word_we11_C15 = wr2_we_C15 & {16{(wr2_addr_C15 == 5'd11)}};
    wire [15:0] wr3_word_we11_C14 = wr3_we_C14 & {16{(wr3_addr_C14 == 5'd11)}};
    wire [15:0] word11_we = 16'b0 | wr0_word_we11_C13 | wr1_word_we11_C13 | wr2_word_we11_C15 | wr3_word_we11_C14;
    wire gclk11_0;
assign gclk11_0 = word11_we[0];
    wire gclk11_1;
assign gclk11_1 = word11_we[1];
    wire gclk11_2;
assign gclk11_2 = word11_we[2];
    wire gclk11_3;
assign gclk11_3 = word11_we[3];
    wire gclk11_4;
assign gclk11_4 = word11_we[4];
    wire gclk11_5;
assign gclk11_5 = word11_we[5];
    wire gclk11_6;
assign gclk11_6 = word11_we[6];
    wire gclk11_7;
assign gclk11_7 = word11_we[7];
    wire gclk11_8;
assign gclk11_8 = word11_we[8];
    wire gclk11_9;
assign gclk11_9 = word11_we[9];
    wire gclk11_10;
assign gclk11_10 = word11_we[10];
    wire gclk11_11;
assign gclk11_11 = word11_we[11];
    wire gclk11_12;
assign gclk11_12 = word11_we[12];
    wire gclk11_13;
assign gclk11_13 = word11_we[13];
    wire gclk11_14;
assign gclk11_14 = word11_we[14];
    wire gclk11_15;
assign gclk11_15 = word11_we[15];
    wire [127:0] wmux11;
    reg [7:0] xtmux_1235;
    always @(*) begin
        xtmux_1235 = 8'b0;
        case({wr0_word_we11_C13[0],
            wr1_word_we11_C13[0],
            wr2_word_we11_C15[0],
            wr3_word_we11_C14[0]}) 
/* synopsys full_case */
            4'b1000: xtmux_1235 = wr0_data_C13[7:0];
            4'b0100: xtmux_1235 = wr1_data_C13[7:0];
            4'b0010: xtmux_1235 = wr2_data_C15[7:0];
            4'b0001: xtmux_1235 = wr3_data_C14[7:0];
        endcase
    end
    assign wmux11[7:0] = xtmux_1235;

    reg [7:0] xtmux_1236;
    always @(*) begin
        xtmux_1236 = 8'b0;
        case({wr0_word_we11_C13[1],
            wr1_word_we11_C13[1],
            wr2_word_we11_C15[1],
            wr3_word_we11_C14[1]}) 
/* synopsys full_case */
            4'b1000: xtmux_1236 = wr0_data_C13[15:8];
            4'b0100: xtmux_1236 = wr1_data_C13[15:8];
            4'b0010: xtmux_1236 = wr2_data_C15[15:8];
            4'b0001: xtmux_1236 = wr3_data_C14[15:8];
        endcase
    end
    assign wmux11[15:8] = xtmux_1236;

    reg [7:0] xtmux_1237;
    always @(*) begin
        xtmux_1237 = 8'b0;
        case({wr0_word_we11_C13[2],
            wr1_word_we11_C13[2],
            wr2_word_we11_C15[2],
            wr3_word_we11_C14[2]}) 
/* synopsys full_case */
            4'b1000: xtmux_1237 = wr0_data_C13[23:16];
            4'b0100: xtmux_1237 = wr1_data_C13[23:16];
            4'b0010: xtmux_1237 = wr2_data_C15[23:16];
            4'b0001: xtmux_1237 = wr3_data_C14[23:16];
        endcase
    end
    assign wmux11[23:16] = xtmux_1237;

    reg [7:0] xtmux_1238;
    always @(*) begin
        xtmux_1238 = 8'b0;
        case({wr0_word_we11_C13[3],
            wr1_word_we11_C13[3],
            wr2_word_we11_C15[3],
            wr3_word_we11_C14[3]}) 
/* synopsys full_case */
            4'b1000: xtmux_1238 = wr0_data_C13[31:24];
            4'b0100: xtmux_1238 = wr1_data_C13[31:24];
            4'b0010: xtmux_1238 = wr2_data_C15[31:24];
            4'b0001: xtmux_1238 = wr3_data_C14[31:24];
        endcase
    end
    assign wmux11[31:24] = xtmux_1238;

    reg [7:0] xtmux_1239;
    always @(*) begin
        xtmux_1239 = 8'b0;
        case({wr0_word_we11_C13[4],
            wr1_word_we11_C13[4],
            wr2_word_we11_C15[4],
            wr3_word_we11_C14[4]}) 
/* synopsys full_case */
            4'b1000: xtmux_1239 = wr0_data_C13[39:32];
            4'b0100: xtmux_1239 = wr1_data_C13[39:32];
            4'b0010: xtmux_1239 = wr2_data_C15[39:32];
            4'b0001: xtmux_1239 = wr3_data_C14[39:32];
        endcase
    end
    assign wmux11[39:32] = xtmux_1239;

    reg [7:0] xtmux_1240;
    always @(*) begin
        xtmux_1240 = 8'b0;
        case({wr0_word_we11_C13[5],
            wr1_word_we11_C13[5],
            wr2_word_we11_C15[5],
            wr3_word_we11_C14[5]}) 
/* synopsys full_case */
            4'b1000: xtmux_1240 = wr0_data_C13[47:40];
            4'b0100: xtmux_1240 = wr1_data_C13[47:40];
            4'b0010: xtmux_1240 = wr2_data_C15[47:40];
            4'b0001: xtmux_1240 = wr3_data_C14[47:40];
        endcase
    end
    assign wmux11[47:40] = xtmux_1240;

    reg [7:0] xtmux_1241;
    always @(*) begin
        xtmux_1241 = 8'b0;
        case({wr0_word_we11_C13[6],
            wr1_word_we11_C13[6],
            wr2_word_we11_C15[6],
            wr3_word_we11_C14[6]}) 
/* synopsys full_case */
            4'b1000: xtmux_1241 = wr0_data_C13[55:48];
            4'b0100: xtmux_1241 = wr1_data_C13[55:48];
            4'b0010: xtmux_1241 = wr2_data_C15[55:48];
            4'b0001: xtmux_1241 = wr3_data_C14[55:48];
        endcase
    end
    assign wmux11[55:48] = xtmux_1241;

    reg [7:0] xtmux_1242;
    always @(*) begin
        xtmux_1242 = 8'b0;
        case({wr0_word_we11_C13[7],
            wr1_word_we11_C13[7],
            wr2_word_we11_C15[7],
            wr3_word_we11_C14[7]}) 
/* synopsys full_case */
            4'b1000: xtmux_1242 = wr0_data_C13[63:56];
            4'b0100: xtmux_1242 = wr1_data_C13[63:56];
            4'b0010: xtmux_1242 = wr2_data_C15[63:56];
            4'b0001: xtmux_1242 = wr3_data_C14[63:56];
        endcase
    end
    assign wmux11[63:56] = xtmux_1242;

    reg [7:0] xtmux_1243;
    always @(*) begin
        xtmux_1243 = 8'b0;
        case({wr0_word_we11_C13[8],
            wr1_word_we11_C13[8],
            wr2_word_we11_C15[8],
            wr3_word_we11_C14[8]}) 
/* synopsys full_case */
            4'b1000: xtmux_1243 = wr0_data_C13[71:64];
            4'b0100: xtmux_1243 = wr1_data_C13[71:64];
            4'b0010: xtmux_1243 = wr2_data_C15[71:64];
            4'b0001: xtmux_1243 = wr3_data_C14[71:64];
        endcase
    end
    assign wmux11[71:64] = xtmux_1243;

    reg [7:0] xtmux_1244;
    always @(*) begin
        xtmux_1244 = 8'b0;
        case({wr0_word_we11_C13[9],
            wr1_word_we11_C13[9],
            wr2_word_we11_C15[9],
            wr3_word_we11_C14[9]}) 
/* synopsys full_case */
            4'b1000: xtmux_1244 = wr0_data_C13[79:72];
            4'b0100: xtmux_1244 = wr1_data_C13[79:72];
            4'b0010: xtmux_1244 = wr2_data_C15[79:72];
            4'b0001: xtmux_1244 = wr3_data_C14[79:72];
        endcase
    end
    assign wmux11[79:72] = xtmux_1244;

    reg [7:0] xtmux_1245;
    always @(*) begin
        xtmux_1245 = 8'b0;
        case({wr0_word_we11_C13[10],
            wr1_word_we11_C13[10],
            wr2_word_we11_C15[10],
            wr3_word_we11_C14[10]}) 
/* synopsys full_case */
            4'b1000: xtmux_1245 = wr0_data_C13[87:80];
            4'b0100: xtmux_1245 = wr1_data_C13[87:80];
            4'b0010: xtmux_1245 = wr2_data_C15[87:80];
            4'b0001: xtmux_1245 = wr3_data_C14[87:80];
        endcase
    end
    assign wmux11[87:80] = xtmux_1245;

    reg [7:0] xtmux_1246;
    always @(*) begin
        xtmux_1246 = 8'b0;
        case({wr0_word_we11_C13[11],
            wr1_word_we11_C13[11],
            wr2_word_we11_C15[11],
            wr3_word_we11_C14[11]}) 
/* synopsys full_case */
            4'b1000: xtmux_1246 = wr0_data_C13[95:88];
            4'b0100: xtmux_1246 = wr1_data_C13[95:88];
            4'b0010: xtmux_1246 = wr2_data_C15[95:88];
            4'b0001: xtmux_1246 = wr3_data_C14[95:88];
        endcase
    end
    assign wmux11[95:88] = xtmux_1246;

    reg [7:0] xtmux_1247;
    always @(*) begin
        xtmux_1247 = 8'b0;
        case({wr0_word_we11_C13[12],
            wr1_word_we11_C13[12],
            wr2_word_we11_C15[12],
            wr3_word_we11_C14[12]}) 
/* synopsys full_case */
            4'b1000: xtmux_1247 = wr0_data_C13[103:96];
            4'b0100: xtmux_1247 = wr1_data_C13[103:96];
            4'b0010: xtmux_1247 = wr2_data_C15[103:96];
            4'b0001: xtmux_1247 = wr3_data_C14[103:96];
        endcase
    end
    assign wmux11[103:96] = xtmux_1247;

    reg [7:0] xtmux_1248;
    always @(*) begin
        xtmux_1248 = 8'b0;
        case({wr0_word_we11_C13[13],
            wr1_word_we11_C13[13],
            wr2_word_we11_C15[13],
            wr3_word_we11_C14[13]}) 
/* synopsys full_case */
            4'b1000: xtmux_1248 = wr0_data_C13[111:104];
            4'b0100: xtmux_1248 = wr1_data_C13[111:104];
            4'b0010: xtmux_1248 = wr2_data_C15[111:104];
            4'b0001: xtmux_1248 = wr3_data_C14[111:104];
        endcase
    end
    assign wmux11[111:104] = xtmux_1248;

    reg [7:0] xtmux_1249;
    always @(*) begin
        xtmux_1249 = 8'b0;
        case({wr0_word_we11_C13[14],
            wr1_word_we11_C13[14],
            wr2_word_we11_C15[14],
            wr3_word_we11_C14[14]}) 
/* synopsys full_case */
            4'b1000: xtmux_1249 = wr0_data_C13[119:112];
            4'b0100: xtmux_1249 = wr1_data_C13[119:112];
            4'b0010: xtmux_1249 = wr2_data_C15[119:112];
            4'b0001: xtmux_1249 = wr3_data_C14[119:112];
        endcase
    end
    assign wmux11[119:112] = xtmux_1249;

    reg [7:0] xtmux_1250;
    always @(*) begin
        xtmux_1250 = 8'b0;
        case({wr0_word_we11_C13[15],
            wr1_word_we11_C13[15],
            wr2_word_we11_C15[15],
            wr3_word_we11_C14[15]}) 
/* synopsys full_case */
            4'b1000: xtmux_1250 = wr0_data_C13[127:120];
            4'b0100: xtmux_1250 = wr1_data_C13[127:120];
            4'b0010: xtmux_1250 = wr2_data_C15[127:120];
            4'b0001: xtmux_1250 = wr3_data_C14[127:120];
        endcase
    end
    assign wmux11[127:120] = xtmux_1250;

    wire [127:0] word11;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word11_p0;
    assign word11[7:0] = XACC_reg_word11_p0;
    always @(posedge clk or posedge localReset)
        XACC_reg_word11_p0 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk11_0) ? wmux11[7:0] : XACC_reg_word11_p0;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word11_p1;
    assign word11[15:8] = XACC_reg_word11_p1;
    always @(posedge clk or posedge localReset)
        XACC_reg_word11_p1 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk11_1) ? wmux11[15:8] : XACC_reg_word11_p1;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word11_p2;
    assign word11[23:16] = XACC_reg_word11_p2;
    always @(posedge clk or posedge localReset)
        XACC_reg_word11_p2 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk11_2) ? wmux11[23:16] : XACC_reg_word11_p2;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word11_p3;
    assign word11[31:24] = XACC_reg_word11_p3;
    always @(posedge clk or posedge localReset)
        XACC_reg_word11_p3 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk11_3) ? wmux11[31:24] : XACC_reg_word11_p3;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word11_p4;
    assign word11[39:32] = XACC_reg_word11_p4;
    always @(posedge clk or posedge localReset)
        XACC_reg_word11_p4 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk11_4) ? wmux11[39:32] : XACC_reg_word11_p4;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word11_p5;
    assign word11[47:40] = XACC_reg_word11_p5;
    always @(posedge clk or posedge localReset)
        XACC_reg_word11_p5 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk11_5) ? wmux11[47:40] : XACC_reg_word11_p5;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word11_p6;
    assign word11[55:48] = XACC_reg_word11_p6;
    always @(posedge clk or posedge localReset)
        XACC_reg_word11_p6 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk11_6) ? wmux11[55:48] : XACC_reg_word11_p6;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word11_p7;
    assign word11[63:56] = XACC_reg_word11_p7;
    always @(posedge clk or posedge localReset)
        XACC_reg_word11_p7 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk11_7) ? wmux11[63:56] : XACC_reg_word11_p7;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word11_p8;
    assign word11[71:64] = XACC_reg_word11_p8;
    always @(posedge clk or posedge localReset)
        XACC_reg_word11_p8 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk11_8) ? wmux11[71:64] : XACC_reg_word11_p8;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word11_p9;
    assign word11[79:72] = XACC_reg_word11_p9;
    always @(posedge clk or posedge localReset)
        XACC_reg_word11_p9 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk11_9) ? wmux11[79:72] : XACC_reg_word11_p9;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word11_p10;
    assign word11[87:80] = XACC_reg_word11_p10;
    always @(posedge clk or posedge localReset)
        XACC_reg_word11_p10 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk11_10) ? wmux11[87:80] : XACC_reg_word11_p10;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word11_p11;
    assign word11[95:88] = XACC_reg_word11_p11;
    always @(posedge clk or posedge localReset)
        XACC_reg_word11_p11 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk11_11) ? wmux11[95:88] : XACC_reg_word11_p11;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word11_p12;
    assign word11[103:96] = XACC_reg_word11_p12;
    always @(posedge clk or posedge localReset)
        XACC_reg_word11_p12 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk11_12) ? wmux11[103:96] : XACC_reg_word11_p12;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word11_p13;
    assign word11[111:104] = XACC_reg_word11_p13;
    always @(posedge clk or posedge localReset)
        XACC_reg_word11_p13 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk11_13) ? wmux11[111:104] : XACC_reg_word11_p13;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word11_p14;
    assign word11[119:112] = XACC_reg_word11_p14;
    always @(posedge clk or posedge localReset)
        XACC_reg_word11_p14 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk11_14) ? wmux11[119:112] : XACC_reg_word11_p14;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word11_p15;
    assign word11[127:120] = XACC_reg_word11_p15;
    always @(posedge clk or posedge localReset)
        XACC_reg_word11_p15 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk11_15) ? wmux11[127:120] : XACC_reg_word11_p15;

    wire [15:0] wr0_word_we12_C13 = wr0_we_C13 & {16{(wr0_addr_C13 == 5'd12)}};
    wire [15:0] wr1_word_we12_C13 = wr1_we_C13 & {16{(wr1_addr_C13 == 5'd12)}};
    wire [15:0] wr2_word_we12_C15 = wr2_we_C15 & {16{(wr2_addr_C15 == 5'd12)}};
    wire [15:0] wr3_word_we12_C14 = wr3_we_C14 & {16{(wr3_addr_C14 == 5'd12)}};
    wire [15:0] word12_we = 16'b0 | wr0_word_we12_C13 | wr1_word_we12_C13 | wr2_word_we12_C15 | wr3_word_we12_C14;
    wire gclk12_0;
assign gclk12_0 = word12_we[0];
    wire gclk12_1;
assign gclk12_1 = word12_we[1];
    wire gclk12_2;
assign gclk12_2 = word12_we[2];
    wire gclk12_3;
assign gclk12_3 = word12_we[3];
    wire gclk12_4;
assign gclk12_4 = word12_we[4];
    wire gclk12_5;
assign gclk12_5 = word12_we[5];
    wire gclk12_6;
assign gclk12_6 = word12_we[6];
    wire gclk12_7;
assign gclk12_7 = word12_we[7];
    wire gclk12_8;
assign gclk12_8 = word12_we[8];
    wire gclk12_9;
assign gclk12_9 = word12_we[9];
    wire gclk12_10;
assign gclk12_10 = word12_we[10];
    wire gclk12_11;
assign gclk12_11 = word12_we[11];
    wire gclk12_12;
assign gclk12_12 = word12_we[12];
    wire gclk12_13;
assign gclk12_13 = word12_we[13];
    wire gclk12_14;
assign gclk12_14 = word12_we[14];
    wire gclk12_15;
assign gclk12_15 = word12_we[15];
    wire [127:0] wmux12;
    reg [7:0] xtmux_1251;
    always @(*) begin
        xtmux_1251 = 8'b0;
        case({wr0_word_we12_C13[0],
            wr1_word_we12_C13[0],
            wr2_word_we12_C15[0],
            wr3_word_we12_C14[0]}) 
/* synopsys full_case */
            4'b1000: xtmux_1251 = wr0_data_C13[7:0];
            4'b0100: xtmux_1251 = wr1_data_C13[7:0];
            4'b0010: xtmux_1251 = wr2_data_C15[7:0];
            4'b0001: xtmux_1251 = wr3_data_C14[7:0];
        endcase
    end
    assign wmux12[7:0] = xtmux_1251;

    reg [7:0] xtmux_1252;
    always @(*) begin
        xtmux_1252 = 8'b0;
        case({wr0_word_we12_C13[1],
            wr1_word_we12_C13[1],
            wr2_word_we12_C15[1],
            wr3_word_we12_C14[1]}) 
/* synopsys full_case */
            4'b1000: xtmux_1252 = wr0_data_C13[15:8];
            4'b0100: xtmux_1252 = wr1_data_C13[15:8];
            4'b0010: xtmux_1252 = wr2_data_C15[15:8];
            4'b0001: xtmux_1252 = wr3_data_C14[15:8];
        endcase
    end
    assign wmux12[15:8] = xtmux_1252;

    reg [7:0] xtmux_1253;
    always @(*) begin
        xtmux_1253 = 8'b0;
        case({wr0_word_we12_C13[2],
            wr1_word_we12_C13[2],
            wr2_word_we12_C15[2],
            wr3_word_we12_C14[2]}) 
/* synopsys full_case */
            4'b1000: xtmux_1253 = wr0_data_C13[23:16];
            4'b0100: xtmux_1253 = wr1_data_C13[23:16];
            4'b0010: xtmux_1253 = wr2_data_C15[23:16];
            4'b0001: xtmux_1253 = wr3_data_C14[23:16];
        endcase
    end
    assign wmux12[23:16] = xtmux_1253;

    reg [7:0] xtmux_1254;
    always @(*) begin
        xtmux_1254 = 8'b0;
        case({wr0_word_we12_C13[3],
            wr1_word_we12_C13[3],
            wr2_word_we12_C15[3],
            wr3_word_we12_C14[3]}) 
/* synopsys full_case */
            4'b1000: xtmux_1254 = wr0_data_C13[31:24];
            4'b0100: xtmux_1254 = wr1_data_C13[31:24];
            4'b0010: xtmux_1254 = wr2_data_C15[31:24];
            4'b0001: xtmux_1254 = wr3_data_C14[31:24];
        endcase
    end
    assign wmux12[31:24] = xtmux_1254;

    reg [7:0] xtmux_1255;
    always @(*) begin
        xtmux_1255 = 8'b0;
        case({wr0_word_we12_C13[4],
            wr1_word_we12_C13[4],
            wr2_word_we12_C15[4],
            wr3_word_we12_C14[4]}) 
/* synopsys full_case */
            4'b1000: xtmux_1255 = wr0_data_C13[39:32];
            4'b0100: xtmux_1255 = wr1_data_C13[39:32];
            4'b0010: xtmux_1255 = wr2_data_C15[39:32];
            4'b0001: xtmux_1255 = wr3_data_C14[39:32];
        endcase
    end
    assign wmux12[39:32] = xtmux_1255;

    reg [7:0] xtmux_1256;
    always @(*) begin
        xtmux_1256 = 8'b0;
        case({wr0_word_we12_C13[5],
            wr1_word_we12_C13[5],
            wr2_word_we12_C15[5],
            wr3_word_we12_C14[5]}) 
/* synopsys full_case */
            4'b1000: xtmux_1256 = wr0_data_C13[47:40];
            4'b0100: xtmux_1256 = wr1_data_C13[47:40];
            4'b0010: xtmux_1256 = wr2_data_C15[47:40];
            4'b0001: xtmux_1256 = wr3_data_C14[47:40];
        endcase
    end
    assign wmux12[47:40] = xtmux_1256;

    reg [7:0] xtmux_1257;
    always @(*) begin
        xtmux_1257 = 8'b0;
        case({wr0_word_we12_C13[6],
            wr1_word_we12_C13[6],
            wr2_word_we12_C15[6],
            wr3_word_we12_C14[6]}) 
/* synopsys full_case */
            4'b1000: xtmux_1257 = wr0_data_C13[55:48];
            4'b0100: xtmux_1257 = wr1_data_C13[55:48];
            4'b0010: xtmux_1257 = wr2_data_C15[55:48];
            4'b0001: xtmux_1257 = wr3_data_C14[55:48];
        endcase
    end
    assign wmux12[55:48] = xtmux_1257;

    reg [7:0] xtmux_1258;
    always @(*) begin
        xtmux_1258 = 8'b0;
        case({wr0_word_we12_C13[7],
            wr1_word_we12_C13[7],
            wr2_word_we12_C15[7],
            wr3_word_we12_C14[7]}) 
/* synopsys full_case */
            4'b1000: xtmux_1258 = wr0_data_C13[63:56];
            4'b0100: xtmux_1258 = wr1_data_C13[63:56];
            4'b0010: xtmux_1258 = wr2_data_C15[63:56];
            4'b0001: xtmux_1258 = wr3_data_C14[63:56];
        endcase
    end
    assign wmux12[63:56] = xtmux_1258;

    reg [7:0] xtmux_1259;
    always @(*) begin
        xtmux_1259 = 8'b0;
        case({wr0_word_we12_C13[8],
            wr1_word_we12_C13[8],
            wr2_word_we12_C15[8],
            wr3_word_we12_C14[8]}) 
/* synopsys full_case */
            4'b1000: xtmux_1259 = wr0_data_C13[71:64];
            4'b0100: xtmux_1259 = wr1_data_C13[71:64];
            4'b0010: xtmux_1259 = wr2_data_C15[71:64];
            4'b0001: xtmux_1259 = wr3_data_C14[71:64];
        endcase
    end
    assign wmux12[71:64] = xtmux_1259;

    reg [7:0] xtmux_1260;
    always @(*) begin
        xtmux_1260 = 8'b0;
        case({wr0_word_we12_C13[9],
            wr1_word_we12_C13[9],
            wr2_word_we12_C15[9],
            wr3_word_we12_C14[9]}) 
/* synopsys full_case */
            4'b1000: xtmux_1260 = wr0_data_C13[79:72];
            4'b0100: xtmux_1260 = wr1_data_C13[79:72];
            4'b0010: xtmux_1260 = wr2_data_C15[79:72];
            4'b0001: xtmux_1260 = wr3_data_C14[79:72];
        endcase
    end
    assign wmux12[79:72] = xtmux_1260;

    reg [7:0] xtmux_1261;
    always @(*) begin
        xtmux_1261 = 8'b0;
        case({wr0_word_we12_C13[10],
            wr1_word_we12_C13[10],
            wr2_word_we12_C15[10],
            wr3_word_we12_C14[10]}) 
/* synopsys full_case */
            4'b1000: xtmux_1261 = wr0_data_C13[87:80];
            4'b0100: xtmux_1261 = wr1_data_C13[87:80];
            4'b0010: xtmux_1261 = wr2_data_C15[87:80];
            4'b0001: xtmux_1261 = wr3_data_C14[87:80];
        endcase
    end
    assign wmux12[87:80] = xtmux_1261;

    reg [7:0] xtmux_1262;
    always @(*) begin
        xtmux_1262 = 8'b0;
        case({wr0_word_we12_C13[11],
            wr1_word_we12_C13[11],
            wr2_word_we12_C15[11],
            wr3_word_we12_C14[11]}) 
/* synopsys full_case */
            4'b1000: xtmux_1262 = wr0_data_C13[95:88];
            4'b0100: xtmux_1262 = wr1_data_C13[95:88];
            4'b0010: xtmux_1262 = wr2_data_C15[95:88];
            4'b0001: xtmux_1262 = wr3_data_C14[95:88];
        endcase
    end
    assign wmux12[95:88] = xtmux_1262;

    reg [7:0] xtmux_1263;
    always @(*) begin
        xtmux_1263 = 8'b0;
        case({wr0_word_we12_C13[12],
            wr1_word_we12_C13[12],
            wr2_word_we12_C15[12],
            wr3_word_we12_C14[12]}) 
/* synopsys full_case */
            4'b1000: xtmux_1263 = wr0_data_C13[103:96];
            4'b0100: xtmux_1263 = wr1_data_C13[103:96];
            4'b0010: xtmux_1263 = wr2_data_C15[103:96];
            4'b0001: xtmux_1263 = wr3_data_C14[103:96];
        endcase
    end
    assign wmux12[103:96] = xtmux_1263;

    reg [7:0] xtmux_1264;
    always @(*) begin
        xtmux_1264 = 8'b0;
        case({wr0_word_we12_C13[13],
            wr1_word_we12_C13[13],
            wr2_word_we12_C15[13],
            wr3_word_we12_C14[13]}) 
/* synopsys full_case */
            4'b1000: xtmux_1264 = wr0_data_C13[111:104];
            4'b0100: xtmux_1264 = wr1_data_C13[111:104];
            4'b0010: xtmux_1264 = wr2_data_C15[111:104];
            4'b0001: xtmux_1264 = wr3_data_C14[111:104];
        endcase
    end
    assign wmux12[111:104] = xtmux_1264;

    reg [7:0] xtmux_1265;
    always @(*) begin
        xtmux_1265 = 8'b0;
        case({wr0_word_we12_C13[14],
            wr1_word_we12_C13[14],
            wr2_word_we12_C15[14],
            wr3_word_we12_C14[14]}) 
/* synopsys full_case */
            4'b1000: xtmux_1265 = wr0_data_C13[119:112];
            4'b0100: xtmux_1265 = wr1_data_C13[119:112];
            4'b0010: xtmux_1265 = wr2_data_C15[119:112];
            4'b0001: xtmux_1265 = wr3_data_C14[119:112];
        endcase
    end
    assign wmux12[119:112] = xtmux_1265;

    reg [7:0] xtmux_1266;
    always @(*) begin
        xtmux_1266 = 8'b0;
        case({wr0_word_we12_C13[15],
            wr1_word_we12_C13[15],
            wr2_word_we12_C15[15],
            wr3_word_we12_C14[15]}) 
/* synopsys full_case */
            4'b1000: xtmux_1266 = wr0_data_C13[127:120];
            4'b0100: xtmux_1266 = wr1_data_C13[127:120];
            4'b0010: xtmux_1266 = wr2_data_C15[127:120];
            4'b0001: xtmux_1266 = wr3_data_C14[127:120];
        endcase
    end
    assign wmux12[127:120] = xtmux_1266;

    wire [127:0] word12;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word12_p0;
    assign word12[7:0] = XACC_reg_word12_p0;
    always @(posedge clk or posedge localReset)
        XACC_reg_word12_p0 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk12_0) ? wmux12[7:0] : XACC_reg_word12_p0;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word12_p1;
    assign word12[15:8] = XACC_reg_word12_p1;
    always @(posedge clk or posedge localReset)
        XACC_reg_word12_p1 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk12_1) ? wmux12[15:8] : XACC_reg_word12_p1;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word12_p2;
    assign word12[23:16] = XACC_reg_word12_p2;
    always @(posedge clk or posedge localReset)
        XACC_reg_word12_p2 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk12_2) ? wmux12[23:16] : XACC_reg_word12_p2;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word12_p3;
    assign word12[31:24] = XACC_reg_word12_p3;
    always @(posedge clk or posedge localReset)
        XACC_reg_word12_p3 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk12_3) ? wmux12[31:24] : XACC_reg_word12_p3;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word12_p4;
    assign word12[39:32] = XACC_reg_word12_p4;
    always @(posedge clk or posedge localReset)
        XACC_reg_word12_p4 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk12_4) ? wmux12[39:32] : XACC_reg_word12_p4;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word12_p5;
    assign word12[47:40] = XACC_reg_word12_p5;
    always @(posedge clk or posedge localReset)
        XACC_reg_word12_p5 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk12_5) ? wmux12[47:40] : XACC_reg_word12_p5;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word12_p6;
    assign word12[55:48] = XACC_reg_word12_p6;
    always @(posedge clk or posedge localReset)
        XACC_reg_word12_p6 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk12_6) ? wmux12[55:48] : XACC_reg_word12_p6;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word12_p7;
    assign word12[63:56] = XACC_reg_word12_p7;
    always @(posedge clk or posedge localReset)
        XACC_reg_word12_p7 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk12_7) ? wmux12[63:56] : XACC_reg_word12_p7;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word12_p8;
    assign word12[71:64] = XACC_reg_word12_p8;
    always @(posedge clk or posedge localReset)
        XACC_reg_word12_p8 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk12_8) ? wmux12[71:64] : XACC_reg_word12_p8;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word12_p9;
    assign word12[79:72] = XACC_reg_word12_p9;
    always @(posedge clk or posedge localReset)
        XACC_reg_word12_p9 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk12_9) ? wmux12[79:72] : XACC_reg_word12_p9;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word12_p10;
    assign word12[87:80] = XACC_reg_word12_p10;
    always @(posedge clk or posedge localReset)
        XACC_reg_word12_p10 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk12_10) ? wmux12[87:80] : XACC_reg_word12_p10;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word12_p11;
    assign word12[95:88] = XACC_reg_word12_p11;
    always @(posedge clk or posedge localReset)
        XACC_reg_word12_p11 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk12_11) ? wmux12[95:88] : XACC_reg_word12_p11;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word12_p12;
    assign word12[103:96] = XACC_reg_word12_p12;
    always @(posedge clk or posedge localReset)
        XACC_reg_word12_p12 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk12_12) ? wmux12[103:96] : XACC_reg_word12_p12;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word12_p13;
    assign word12[111:104] = XACC_reg_word12_p13;
    always @(posedge clk or posedge localReset)
        XACC_reg_word12_p13 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk12_13) ? wmux12[111:104] : XACC_reg_word12_p13;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word12_p14;
    assign word12[119:112] = XACC_reg_word12_p14;
    always @(posedge clk or posedge localReset)
        XACC_reg_word12_p14 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk12_14) ? wmux12[119:112] : XACC_reg_word12_p14;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word12_p15;
    assign word12[127:120] = XACC_reg_word12_p15;
    always @(posedge clk or posedge localReset)
        XACC_reg_word12_p15 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk12_15) ? wmux12[127:120] : XACC_reg_word12_p15;

    wire [15:0] wr0_word_we13_C13 = wr0_we_C13 & {16{(wr0_addr_C13 == 5'd13)}};
    wire [15:0] wr1_word_we13_C13 = wr1_we_C13 & {16{(wr1_addr_C13 == 5'd13)}};
    wire [15:0] wr2_word_we13_C15 = wr2_we_C15 & {16{(wr2_addr_C15 == 5'd13)}};
    wire [15:0] wr3_word_we13_C14 = wr3_we_C14 & {16{(wr3_addr_C14 == 5'd13)}};
    wire [15:0] word13_we = 16'b0 | wr0_word_we13_C13 | wr1_word_we13_C13 | wr2_word_we13_C15 | wr3_word_we13_C14;
    wire gclk13_0;
assign gclk13_0 = word13_we[0];
    wire gclk13_1;
assign gclk13_1 = word13_we[1];
    wire gclk13_2;
assign gclk13_2 = word13_we[2];
    wire gclk13_3;
assign gclk13_3 = word13_we[3];
    wire gclk13_4;
assign gclk13_4 = word13_we[4];
    wire gclk13_5;
assign gclk13_5 = word13_we[5];
    wire gclk13_6;
assign gclk13_6 = word13_we[6];
    wire gclk13_7;
assign gclk13_7 = word13_we[7];
    wire gclk13_8;
assign gclk13_8 = word13_we[8];
    wire gclk13_9;
assign gclk13_9 = word13_we[9];
    wire gclk13_10;
assign gclk13_10 = word13_we[10];
    wire gclk13_11;
assign gclk13_11 = word13_we[11];
    wire gclk13_12;
assign gclk13_12 = word13_we[12];
    wire gclk13_13;
assign gclk13_13 = word13_we[13];
    wire gclk13_14;
assign gclk13_14 = word13_we[14];
    wire gclk13_15;
assign gclk13_15 = word13_we[15];
    wire [127:0] wmux13;
    reg [7:0] xtmux_1267;
    always @(*) begin
        xtmux_1267 = 8'b0;
        case({wr0_word_we13_C13[0],
            wr1_word_we13_C13[0],
            wr2_word_we13_C15[0],
            wr3_word_we13_C14[0]}) 
/* synopsys full_case */
            4'b1000: xtmux_1267 = wr0_data_C13[7:0];
            4'b0100: xtmux_1267 = wr1_data_C13[7:0];
            4'b0010: xtmux_1267 = wr2_data_C15[7:0];
            4'b0001: xtmux_1267 = wr3_data_C14[7:0];
        endcase
    end
    assign wmux13[7:0] = xtmux_1267;

    reg [7:0] xtmux_1268;
    always @(*) begin
        xtmux_1268 = 8'b0;
        case({wr0_word_we13_C13[1],
            wr1_word_we13_C13[1],
            wr2_word_we13_C15[1],
            wr3_word_we13_C14[1]}) 
/* synopsys full_case */
            4'b1000: xtmux_1268 = wr0_data_C13[15:8];
            4'b0100: xtmux_1268 = wr1_data_C13[15:8];
            4'b0010: xtmux_1268 = wr2_data_C15[15:8];
            4'b0001: xtmux_1268 = wr3_data_C14[15:8];
        endcase
    end
    assign wmux13[15:8] = xtmux_1268;

    reg [7:0] xtmux_1269;
    always @(*) begin
        xtmux_1269 = 8'b0;
        case({wr0_word_we13_C13[2],
            wr1_word_we13_C13[2],
            wr2_word_we13_C15[2],
            wr3_word_we13_C14[2]}) 
/* synopsys full_case */
            4'b1000: xtmux_1269 = wr0_data_C13[23:16];
            4'b0100: xtmux_1269 = wr1_data_C13[23:16];
            4'b0010: xtmux_1269 = wr2_data_C15[23:16];
            4'b0001: xtmux_1269 = wr3_data_C14[23:16];
        endcase
    end
    assign wmux13[23:16] = xtmux_1269;

    reg [7:0] xtmux_1270;
    always @(*) begin
        xtmux_1270 = 8'b0;
        case({wr0_word_we13_C13[3],
            wr1_word_we13_C13[3],
            wr2_word_we13_C15[3],
            wr3_word_we13_C14[3]}) 
/* synopsys full_case */
            4'b1000: xtmux_1270 = wr0_data_C13[31:24];
            4'b0100: xtmux_1270 = wr1_data_C13[31:24];
            4'b0010: xtmux_1270 = wr2_data_C15[31:24];
            4'b0001: xtmux_1270 = wr3_data_C14[31:24];
        endcase
    end
    assign wmux13[31:24] = xtmux_1270;

    reg [7:0] xtmux_1271;
    always @(*) begin
        xtmux_1271 = 8'b0;
        case({wr0_word_we13_C13[4],
            wr1_word_we13_C13[4],
            wr2_word_we13_C15[4],
            wr3_word_we13_C14[4]}) 
/* synopsys full_case */
            4'b1000: xtmux_1271 = wr0_data_C13[39:32];
            4'b0100: xtmux_1271 = wr1_data_C13[39:32];
            4'b0010: xtmux_1271 = wr2_data_C15[39:32];
            4'b0001: xtmux_1271 = wr3_data_C14[39:32];
        endcase
    end
    assign wmux13[39:32] = xtmux_1271;

    reg [7:0] xtmux_1272;
    always @(*) begin
        xtmux_1272 = 8'b0;
        case({wr0_word_we13_C13[5],
            wr1_word_we13_C13[5],
            wr2_word_we13_C15[5],
            wr3_word_we13_C14[5]}) 
/* synopsys full_case */
            4'b1000: xtmux_1272 = wr0_data_C13[47:40];
            4'b0100: xtmux_1272 = wr1_data_C13[47:40];
            4'b0010: xtmux_1272 = wr2_data_C15[47:40];
            4'b0001: xtmux_1272 = wr3_data_C14[47:40];
        endcase
    end
    assign wmux13[47:40] = xtmux_1272;

    reg [7:0] xtmux_1273;
    always @(*) begin
        xtmux_1273 = 8'b0;
        case({wr0_word_we13_C13[6],
            wr1_word_we13_C13[6],
            wr2_word_we13_C15[6],
            wr3_word_we13_C14[6]}) 
/* synopsys full_case */
            4'b1000: xtmux_1273 = wr0_data_C13[55:48];
            4'b0100: xtmux_1273 = wr1_data_C13[55:48];
            4'b0010: xtmux_1273 = wr2_data_C15[55:48];
            4'b0001: xtmux_1273 = wr3_data_C14[55:48];
        endcase
    end
    assign wmux13[55:48] = xtmux_1273;

    reg [7:0] xtmux_1274;
    always @(*) begin
        xtmux_1274 = 8'b0;
        case({wr0_word_we13_C13[7],
            wr1_word_we13_C13[7],
            wr2_word_we13_C15[7],
            wr3_word_we13_C14[7]}) 
/* synopsys full_case */
            4'b1000: xtmux_1274 = wr0_data_C13[63:56];
            4'b0100: xtmux_1274 = wr1_data_C13[63:56];
            4'b0010: xtmux_1274 = wr2_data_C15[63:56];
            4'b0001: xtmux_1274 = wr3_data_C14[63:56];
        endcase
    end
    assign wmux13[63:56] = xtmux_1274;

    reg [7:0] xtmux_1275;
    always @(*) begin
        xtmux_1275 = 8'b0;
        case({wr0_word_we13_C13[8],
            wr1_word_we13_C13[8],
            wr2_word_we13_C15[8],
            wr3_word_we13_C14[8]}) 
/* synopsys full_case */
            4'b1000: xtmux_1275 = wr0_data_C13[71:64];
            4'b0100: xtmux_1275 = wr1_data_C13[71:64];
            4'b0010: xtmux_1275 = wr2_data_C15[71:64];
            4'b0001: xtmux_1275 = wr3_data_C14[71:64];
        endcase
    end
    assign wmux13[71:64] = xtmux_1275;

    reg [7:0] xtmux_1276;
    always @(*) begin
        xtmux_1276 = 8'b0;
        case({wr0_word_we13_C13[9],
            wr1_word_we13_C13[9],
            wr2_word_we13_C15[9],
            wr3_word_we13_C14[9]}) 
/* synopsys full_case */
            4'b1000: xtmux_1276 = wr0_data_C13[79:72];
            4'b0100: xtmux_1276 = wr1_data_C13[79:72];
            4'b0010: xtmux_1276 = wr2_data_C15[79:72];
            4'b0001: xtmux_1276 = wr3_data_C14[79:72];
        endcase
    end
    assign wmux13[79:72] = xtmux_1276;

    reg [7:0] xtmux_1277;
    always @(*) begin
        xtmux_1277 = 8'b0;
        case({wr0_word_we13_C13[10],
            wr1_word_we13_C13[10],
            wr2_word_we13_C15[10],
            wr3_word_we13_C14[10]}) 
/* synopsys full_case */
            4'b1000: xtmux_1277 = wr0_data_C13[87:80];
            4'b0100: xtmux_1277 = wr1_data_C13[87:80];
            4'b0010: xtmux_1277 = wr2_data_C15[87:80];
            4'b0001: xtmux_1277 = wr3_data_C14[87:80];
        endcase
    end
    assign wmux13[87:80] = xtmux_1277;

    reg [7:0] xtmux_1278;
    always @(*) begin
        xtmux_1278 = 8'b0;
        case({wr0_word_we13_C13[11],
            wr1_word_we13_C13[11],
            wr2_word_we13_C15[11],
            wr3_word_we13_C14[11]}) 
/* synopsys full_case */
            4'b1000: xtmux_1278 = wr0_data_C13[95:88];
            4'b0100: xtmux_1278 = wr1_data_C13[95:88];
            4'b0010: xtmux_1278 = wr2_data_C15[95:88];
            4'b0001: xtmux_1278 = wr3_data_C14[95:88];
        endcase
    end
    assign wmux13[95:88] = xtmux_1278;

    reg [7:0] xtmux_1279;
    always @(*) begin
        xtmux_1279 = 8'b0;
        case({wr0_word_we13_C13[12],
            wr1_word_we13_C13[12],
            wr2_word_we13_C15[12],
            wr3_word_we13_C14[12]}) 
/* synopsys full_case */
            4'b1000: xtmux_1279 = wr0_data_C13[103:96];
            4'b0100: xtmux_1279 = wr1_data_C13[103:96];
            4'b0010: xtmux_1279 = wr2_data_C15[103:96];
            4'b0001: xtmux_1279 = wr3_data_C14[103:96];
        endcase
    end
    assign wmux13[103:96] = xtmux_1279;

    reg [7:0] xtmux_1280;
    always @(*) begin
        xtmux_1280 = 8'b0;
        case({wr0_word_we13_C13[13],
            wr1_word_we13_C13[13],
            wr2_word_we13_C15[13],
            wr3_word_we13_C14[13]}) 
/* synopsys full_case */
            4'b1000: xtmux_1280 = wr0_data_C13[111:104];
            4'b0100: xtmux_1280 = wr1_data_C13[111:104];
            4'b0010: xtmux_1280 = wr2_data_C15[111:104];
            4'b0001: xtmux_1280 = wr3_data_C14[111:104];
        endcase
    end
    assign wmux13[111:104] = xtmux_1280;

    reg [7:0] xtmux_1281;
    always @(*) begin
        xtmux_1281 = 8'b0;
        case({wr0_word_we13_C13[14],
            wr1_word_we13_C13[14],
            wr2_word_we13_C15[14],
            wr3_word_we13_C14[14]}) 
/* synopsys full_case */
            4'b1000: xtmux_1281 = wr0_data_C13[119:112];
            4'b0100: xtmux_1281 = wr1_data_C13[119:112];
            4'b0010: xtmux_1281 = wr2_data_C15[119:112];
            4'b0001: xtmux_1281 = wr3_data_C14[119:112];
        endcase
    end
    assign wmux13[119:112] = xtmux_1281;

    reg [7:0] xtmux_1282;
    always @(*) begin
        xtmux_1282 = 8'b0;
        case({wr0_word_we13_C13[15],
            wr1_word_we13_C13[15],
            wr2_word_we13_C15[15],
            wr3_word_we13_C14[15]}) 
/* synopsys full_case */
            4'b1000: xtmux_1282 = wr0_data_C13[127:120];
            4'b0100: xtmux_1282 = wr1_data_C13[127:120];
            4'b0010: xtmux_1282 = wr2_data_C15[127:120];
            4'b0001: xtmux_1282 = wr3_data_C14[127:120];
        endcase
    end
    assign wmux13[127:120] = xtmux_1282;

    wire [127:0] word13;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word13_p0;
    assign word13[7:0] = XACC_reg_word13_p0;
    always @(posedge clk or posedge localReset)
        XACC_reg_word13_p0 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk13_0) ? wmux13[7:0] : XACC_reg_word13_p0;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word13_p1;
    assign word13[15:8] = XACC_reg_word13_p1;
    always @(posedge clk or posedge localReset)
        XACC_reg_word13_p1 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk13_1) ? wmux13[15:8] : XACC_reg_word13_p1;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word13_p2;
    assign word13[23:16] = XACC_reg_word13_p2;
    always @(posedge clk or posedge localReset)
        XACC_reg_word13_p2 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk13_2) ? wmux13[23:16] : XACC_reg_word13_p2;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word13_p3;
    assign word13[31:24] = XACC_reg_word13_p3;
    always @(posedge clk or posedge localReset)
        XACC_reg_word13_p3 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk13_3) ? wmux13[31:24] : XACC_reg_word13_p3;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word13_p4;
    assign word13[39:32] = XACC_reg_word13_p4;
    always @(posedge clk or posedge localReset)
        XACC_reg_word13_p4 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk13_4) ? wmux13[39:32] : XACC_reg_word13_p4;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word13_p5;
    assign word13[47:40] = XACC_reg_word13_p5;
    always @(posedge clk or posedge localReset)
        XACC_reg_word13_p5 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk13_5) ? wmux13[47:40] : XACC_reg_word13_p5;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word13_p6;
    assign word13[55:48] = XACC_reg_word13_p6;
    always @(posedge clk or posedge localReset)
        XACC_reg_word13_p6 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk13_6) ? wmux13[55:48] : XACC_reg_word13_p6;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word13_p7;
    assign word13[63:56] = XACC_reg_word13_p7;
    always @(posedge clk or posedge localReset)
        XACC_reg_word13_p7 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk13_7) ? wmux13[63:56] : XACC_reg_word13_p7;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word13_p8;
    assign word13[71:64] = XACC_reg_word13_p8;
    always @(posedge clk or posedge localReset)
        XACC_reg_word13_p8 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk13_8) ? wmux13[71:64] : XACC_reg_word13_p8;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word13_p9;
    assign word13[79:72] = XACC_reg_word13_p9;
    always @(posedge clk or posedge localReset)
        XACC_reg_word13_p9 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk13_9) ? wmux13[79:72] : XACC_reg_word13_p9;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word13_p10;
    assign word13[87:80] = XACC_reg_word13_p10;
    always @(posedge clk or posedge localReset)
        XACC_reg_word13_p10 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk13_10) ? wmux13[87:80] : XACC_reg_word13_p10;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word13_p11;
    assign word13[95:88] = XACC_reg_word13_p11;
    always @(posedge clk or posedge localReset)
        XACC_reg_word13_p11 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk13_11) ? wmux13[95:88] : XACC_reg_word13_p11;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word13_p12;
    assign word13[103:96] = XACC_reg_word13_p12;
    always @(posedge clk or posedge localReset)
        XACC_reg_word13_p12 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk13_12) ? wmux13[103:96] : XACC_reg_word13_p12;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word13_p13;
    assign word13[111:104] = XACC_reg_word13_p13;
    always @(posedge clk or posedge localReset)
        XACC_reg_word13_p13 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk13_13) ? wmux13[111:104] : XACC_reg_word13_p13;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word13_p14;
    assign word13[119:112] = XACC_reg_word13_p14;
    always @(posedge clk or posedge localReset)
        XACC_reg_word13_p14 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk13_14) ? wmux13[119:112] : XACC_reg_word13_p14;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word13_p15;
    assign word13[127:120] = XACC_reg_word13_p15;
    always @(posedge clk or posedge localReset)
        XACC_reg_word13_p15 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk13_15) ? wmux13[127:120] : XACC_reg_word13_p15;

    wire [15:0] wr0_word_we14_C13 = wr0_we_C13 & {16{(wr0_addr_C13 == 5'd14)}};
    wire [15:0] wr1_word_we14_C13 = wr1_we_C13 & {16{(wr1_addr_C13 == 5'd14)}};
    wire [15:0] wr2_word_we14_C15 = wr2_we_C15 & {16{(wr2_addr_C15 == 5'd14)}};
    wire [15:0] wr3_word_we14_C14 = wr3_we_C14 & {16{(wr3_addr_C14 == 5'd14)}};
    wire [15:0] word14_we = 16'b0 | wr0_word_we14_C13 | wr1_word_we14_C13 | wr2_word_we14_C15 | wr3_word_we14_C14;
    wire gclk14_0;
assign gclk14_0 = word14_we[0];
    wire gclk14_1;
assign gclk14_1 = word14_we[1];
    wire gclk14_2;
assign gclk14_2 = word14_we[2];
    wire gclk14_3;
assign gclk14_3 = word14_we[3];
    wire gclk14_4;
assign gclk14_4 = word14_we[4];
    wire gclk14_5;
assign gclk14_5 = word14_we[5];
    wire gclk14_6;
assign gclk14_6 = word14_we[6];
    wire gclk14_7;
assign gclk14_7 = word14_we[7];
    wire gclk14_8;
assign gclk14_8 = word14_we[8];
    wire gclk14_9;
assign gclk14_9 = word14_we[9];
    wire gclk14_10;
assign gclk14_10 = word14_we[10];
    wire gclk14_11;
assign gclk14_11 = word14_we[11];
    wire gclk14_12;
assign gclk14_12 = word14_we[12];
    wire gclk14_13;
assign gclk14_13 = word14_we[13];
    wire gclk14_14;
assign gclk14_14 = word14_we[14];
    wire gclk14_15;
assign gclk14_15 = word14_we[15];
    wire [127:0] wmux14;
    reg [7:0] xtmux_1283;
    always @(*) begin
        xtmux_1283 = 8'b0;
        case({wr0_word_we14_C13[0],
            wr1_word_we14_C13[0],
            wr2_word_we14_C15[0],
            wr3_word_we14_C14[0]}) 
/* synopsys full_case */
            4'b1000: xtmux_1283 = wr0_data_C13[7:0];
            4'b0100: xtmux_1283 = wr1_data_C13[7:0];
            4'b0010: xtmux_1283 = wr2_data_C15[7:0];
            4'b0001: xtmux_1283 = wr3_data_C14[7:0];
        endcase
    end
    assign wmux14[7:0] = xtmux_1283;

    reg [7:0] xtmux_1284;
    always @(*) begin
        xtmux_1284 = 8'b0;
        case({wr0_word_we14_C13[1],
            wr1_word_we14_C13[1],
            wr2_word_we14_C15[1],
            wr3_word_we14_C14[1]}) 
/* synopsys full_case */
            4'b1000: xtmux_1284 = wr0_data_C13[15:8];
            4'b0100: xtmux_1284 = wr1_data_C13[15:8];
            4'b0010: xtmux_1284 = wr2_data_C15[15:8];
            4'b0001: xtmux_1284 = wr3_data_C14[15:8];
        endcase
    end
    assign wmux14[15:8] = xtmux_1284;

    reg [7:0] xtmux_1285;
    always @(*) begin
        xtmux_1285 = 8'b0;
        case({wr0_word_we14_C13[2],
            wr1_word_we14_C13[2],
            wr2_word_we14_C15[2],
            wr3_word_we14_C14[2]}) 
/* synopsys full_case */
            4'b1000: xtmux_1285 = wr0_data_C13[23:16];
            4'b0100: xtmux_1285 = wr1_data_C13[23:16];
            4'b0010: xtmux_1285 = wr2_data_C15[23:16];
            4'b0001: xtmux_1285 = wr3_data_C14[23:16];
        endcase
    end
    assign wmux14[23:16] = xtmux_1285;

    reg [7:0] xtmux_1286;
    always @(*) begin
        xtmux_1286 = 8'b0;
        case({wr0_word_we14_C13[3],
            wr1_word_we14_C13[3],
            wr2_word_we14_C15[3],
            wr3_word_we14_C14[3]}) 
/* synopsys full_case */
            4'b1000: xtmux_1286 = wr0_data_C13[31:24];
            4'b0100: xtmux_1286 = wr1_data_C13[31:24];
            4'b0010: xtmux_1286 = wr2_data_C15[31:24];
            4'b0001: xtmux_1286 = wr3_data_C14[31:24];
        endcase
    end
    assign wmux14[31:24] = xtmux_1286;

    reg [7:0] xtmux_1287;
    always @(*) begin
        xtmux_1287 = 8'b0;
        case({wr0_word_we14_C13[4],
            wr1_word_we14_C13[4],
            wr2_word_we14_C15[4],
            wr3_word_we14_C14[4]}) 
/* synopsys full_case */
            4'b1000: xtmux_1287 = wr0_data_C13[39:32];
            4'b0100: xtmux_1287 = wr1_data_C13[39:32];
            4'b0010: xtmux_1287 = wr2_data_C15[39:32];
            4'b0001: xtmux_1287 = wr3_data_C14[39:32];
        endcase
    end
    assign wmux14[39:32] = xtmux_1287;

    reg [7:0] xtmux_1288;
    always @(*) begin
        xtmux_1288 = 8'b0;
        case({wr0_word_we14_C13[5],
            wr1_word_we14_C13[5],
            wr2_word_we14_C15[5],
            wr3_word_we14_C14[5]}) 
/* synopsys full_case */
            4'b1000: xtmux_1288 = wr0_data_C13[47:40];
            4'b0100: xtmux_1288 = wr1_data_C13[47:40];
            4'b0010: xtmux_1288 = wr2_data_C15[47:40];
            4'b0001: xtmux_1288 = wr3_data_C14[47:40];
        endcase
    end
    assign wmux14[47:40] = xtmux_1288;

    reg [7:0] xtmux_1289;
    always @(*) begin
        xtmux_1289 = 8'b0;
        case({wr0_word_we14_C13[6],
            wr1_word_we14_C13[6],
            wr2_word_we14_C15[6],
            wr3_word_we14_C14[6]}) 
/* synopsys full_case */
            4'b1000: xtmux_1289 = wr0_data_C13[55:48];
            4'b0100: xtmux_1289 = wr1_data_C13[55:48];
            4'b0010: xtmux_1289 = wr2_data_C15[55:48];
            4'b0001: xtmux_1289 = wr3_data_C14[55:48];
        endcase
    end
    assign wmux14[55:48] = xtmux_1289;

    reg [7:0] xtmux_1290;
    always @(*) begin
        xtmux_1290 = 8'b0;
        case({wr0_word_we14_C13[7],
            wr1_word_we14_C13[7],
            wr2_word_we14_C15[7],
            wr3_word_we14_C14[7]}) 
/* synopsys full_case */
            4'b1000: xtmux_1290 = wr0_data_C13[63:56];
            4'b0100: xtmux_1290 = wr1_data_C13[63:56];
            4'b0010: xtmux_1290 = wr2_data_C15[63:56];
            4'b0001: xtmux_1290 = wr3_data_C14[63:56];
        endcase
    end
    assign wmux14[63:56] = xtmux_1290;

    reg [7:0] xtmux_1291;
    always @(*) begin
        xtmux_1291 = 8'b0;
        case({wr0_word_we14_C13[8],
            wr1_word_we14_C13[8],
            wr2_word_we14_C15[8],
            wr3_word_we14_C14[8]}) 
/* synopsys full_case */
            4'b1000: xtmux_1291 = wr0_data_C13[71:64];
            4'b0100: xtmux_1291 = wr1_data_C13[71:64];
            4'b0010: xtmux_1291 = wr2_data_C15[71:64];
            4'b0001: xtmux_1291 = wr3_data_C14[71:64];
        endcase
    end
    assign wmux14[71:64] = xtmux_1291;

    reg [7:0] xtmux_1292;
    always @(*) begin
        xtmux_1292 = 8'b0;
        case({wr0_word_we14_C13[9],
            wr1_word_we14_C13[9],
            wr2_word_we14_C15[9],
            wr3_word_we14_C14[9]}) 
/* synopsys full_case */
            4'b1000: xtmux_1292 = wr0_data_C13[79:72];
            4'b0100: xtmux_1292 = wr1_data_C13[79:72];
            4'b0010: xtmux_1292 = wr2_data_C15[79:72];
            4'b0001: xtmux_1292 = wr3_data_C14[79:72];
        endcase
    end
    assign wmux14[79:72] = xtmux_1292;

    reg [7:0] xtmux_1293;
    always @(*) begin
        xtmux_1293 = 8'b0;
        case({wr0_word_we14_C13[10],
            wr1_word_we14_C13[10],
            wr2_word_we14_C15[10],
            wr3_word_we14_C14[10]}) 
/* synopsys full_case */
            4'b1000: xtmux_1293 = wr0_data_C13[87:80];
            4'b0100: xtmux_1293 = wr1_data_C13[87:80];
            4'b0010: xtmux_1293 = wr2_data_C15[87:80];
            4'b0001: xtmux_1293 = wr3_data_C14[87:80];
        endcase
    end
    assign wmux14[87:80] = xtmux_1293;

    reg [7:0] xtmux_1294;
    always @(*) begin
        xtmux_1294 = 8'b0;
        case({wr0_word_we14_C13[11],
            wr1_word_we14_C13[11],
            wr2_word_we14_C15[11],
            wr3_word_we14_C14[11]}) 
/* synopsys full_case */
            4'b1000: xtmux_1294 = wr0_data_C13[95:88];
            4'b0100: xtmux_1294 = wr1_data_C13[95:88];
            4'b0010: xtmux_1294 = wr2_data_C15[95:88];
            4'b0001: xtmux_1294 = wr3_data_C14[95:88];
        endcase
    end
    assign wmux14[95:88] = xtmux_1294;

    reg [7:0] xtmux_1295;
    always @(*) begin
        xtmux_1295 = 8'b0;
        case({wr0_word_we14_C13[12],
            wr1_word_we14_C13[12],
            wr2_word_we14_C15[12],
            wr3_word_we14_C14[12]}) 
/* synopsys full_case */
            4'b1000: xtmux_1295 = wr0_data_C13[103:96];
            4'b0100: xtmux_1295 = wr1_data_C13[103:96];
            4'b0010: xtmux_1295 = wr2_data_C15[103:96];
            4'b0001: xtmux_1295 = wr3_data_C14[103:96];
        endcase
    end
    assign wmux14[103:96] = xtmux_1295;

    reg [7:0] xtmux_1296;
    always @(*) begin
        xtmux_1296 = 8'b0;
        case({wr0_word_we14_C13[13],
            wr1_word_we14_C13[13],
            wr2_word_we14_C15[13],
            wr3_word_we14_C14[13]}) 
/* synopsys full_case */
            4'b1000: xtmux_1296 = wr0_data_C13[111:104];
            4'b0100: xtmux_1296 = wr1_data_C13[111:104];
            4'b0010: xtmux_1296 = wr2_data_C15[111:104];
            4'b0001: xtmux_1296 = wr3_data_C14[111:104];
        endcase
    end
    assign wmux14[111:104] = xtmux_1296;

    reg [7:0] xtmux_1297;
    always @(*) begin
        xtmux_1297 = 8'b0;
        case({wr0_word_we14_C13[14],
            wr1_word_we14_C13[14],
            wr2_word_we14_C15[14],
            wr3_word_we14_C14[14]}) 
/* synopsys full_case */
            4'b1000: xtmux_1297 = wr0_data_C13[119:112];
            4'b0100: xtmux_1297 = wr1_data_C13[119:112];
            4'b0010: xtmux_1297 = wr2_data_C15[119:112];
            4'b0001: xtmux_1297 = wr3_data_C14[119:112];
        endcase
    end
    assign wmux14[119:112] = xtmux_1297;

    reg [7:0] xtmux_1298;
    always @(*) begin
        xtmux_1298 = 8'b0;
        case({wr0_word_we14_C13[15],
            wr1_word_we14_C13[15],
            wr2_word_we14_C15[15],
            wr3_word_we14_C14[15]}) 
/* synopsys full_case */
            4'b1000: xtmux_1298 = wr0_data_C13[127:120];
            4'b0100: xtmux_1298 = wr1_data_C13[127:120];
            4'b0010: xtmux_1298 = wr2_data_C15[127:120];
            4'b0001: xtmux_1298 = wr3_data_C14[127:120];
        endcase
    end
    assign wmux14[127:120] = xtmux_1298;

    wire [127:0] word14;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word14_p0;
    assign word14[7:0] = XACC_reg_word14_p0;
    always @(posedge clk or posedge localReset)
        XACC_reg_word14_p0 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk14_0) ? wmux14[7:0] : XACC_reg_word14_p0;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word14_p1;
    assign word14[15:8] = XACC_reg_word14_p1;
    always @(posedge clk or posedge localReset)
        XACC_reg_word14_p1 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk14_1) ? wmux14[15:8] : XACC_reg_word14_p1;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word14_p2;
    assign word14[23:16] = XACC_reg_word14_p2;
    always @(posedge clk or posedge localReset)
        XACC_reg_word14_p2 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk14_2) ? wmux14[23:16] : XACC_reg_word14_p2;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word14_p3;
    assign word14[31:24] = XACC_reg_word14_p3;
    always @(posedge clk or posedge localReset)
        XACC_reg_word14_p3 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk14_3) ? wmux14[31:24] : XACC_reg_word14_p3;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word14_p4;
    assign word14[39:32] = XACC_reg_word14_p4;
    always @(posedge clk or posedge localReset)
        XACC_reg_word14_p4 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk14_4) ? wmux14[39:32] : XACC_reg_word14_p4;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word14_p5;
    assign word14[47:40] = XACC_reg_word14_p5;
    always @(posedge clk or posedge localReset)
        XACC_reg_word14_p5 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk14_5) ? wmux14[47:40] : XACC_reg_word14_p5;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word14_p6;
    assign word14[55:48] = XACC_reg_word14_p6;
    always @(posedge clk or posedge localReset)
        XACC_reg_word14_p6 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk14_6) ? wmux14[55:48] : XACC_reg_word14_p6;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word14_p7;
    assign word14[63:56] = XACC_reg_word14_p7;
    always @(posedge clk or posedge localReset)
        XACC_reg_word14_p7 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk14_7) ? wmux14[63:56] : XACC_reg_word14_p7;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word14_p8;
    assign word14[71:64] = XACC_reg_word14_p8;
    always @(posedge clk or posedge localReset)
        XACC_reg_word14_p8 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk14_8) ? wmux14[71:64] : XACC_reg_word14_p8;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word14_p9;
    assign word14[79:72] = XACC_reg_word14_p9;
    always @(posedge clk or posedge localReset)
        XACC_reg_word14_p9 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk14_9) ? wmux14[79:72] : XACC_reg_word14_p9;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word14_p10;
    assign word14[87:80] = XACC_reg_word14_p10;
    always @(posedge clk or posedge localReset)
        XACC_reg_word14_p10 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk14_10) ? wmux14[87:80] : XACC_reg_word14_p10;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word14_p11;
    assign word14[95:88] = XACC_reg_word14_p11;
    always @(posedge clk or posedge localReset)
        XACC_reg_word14_p11 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk14_11) ? wmux14[95:88] : XACC_reg_word14_p11;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word14_p12;
    assign word14[103:96] = XACC_reg_word14_p12;
    always @(posedge clk or posedge localReset)
        XACC_reg_word14_p12 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk14_12) ? wmux14[103:96] : XACC_reg_word14_p12;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word14_p13;
    assign word14[111:104] = XACC_reg_word14_p13;
    always @(posedge clk or posedge localReset)
        XACC_reg_word14_p13 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk14_13) ? wmux14[111:104] : XACC_reg_word14_p13;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word14_p14;
    assign word14[119:112] = XACC_reg_word14_p14;
    always @(posedge clk or posedge localReset)
        XACC_reg_word14_p14 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk14_14) ? wmux14[119:112] : XACC_reg_word14_p14;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word14_p15;
    assign word14[127:120] = XACC_reg_word14_p15;
    always @(posedge clk or posedge localReset)
        XACC_reg_word14_p15 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk14_15) ? wmux14[127:120] : XACC_reg_word14_p15;

    wire [15:0] wr0_word_we15_C13 = wr0_we_C13 & {16{(wr0_addr_C13 == 5'd15)}};
    wire [15:0] wr1_word_we15_C13 = wr1_we_C13 & {16{(wr1_addr_C13 == 5'd15)}};
    wire [15:0] wr2_word_we15_C15 = wr2_we_C15 & {16{(wr2_addr_C15 == 5'd15)}};
    wire [15:0] wr3_word_we15_C14 = wr3_we_C14 & {16{(wr3_addr_C14 == 5'd15)}};
    wire [15:0] word15_we = 16'b0 | wr0_word_we15_C13 | wr1_word_we15_C13 | wr2_word_we15_C15 | wr3_word_we15_C14;
    wire gclk15_0;
assign gclk15_0 = word15_we[0];
    wire gclk15_1;
assign gclk15_1 = word15_we[1];
    wire gclk15_2;
assign gclk15_2 = word15_we[2];
    wire gclk15_3;
assign gclk15_3 = word15_we[3];
    wire gclk15_4;
assign gclk15_4 = word15_we[4];
    wire gclk15_5;
assign gclk15_5 = word15_we[5];
    wire gclk15_6;
assign gclk15_6 = word15_we[6];
    wire gclk15_7;
assign gclk15_7 = word15_we[7];
    wire gclk15_8;
assign gclk15_8 = word15_we[8];
    wire gclk15_9;
assign gclk15_9 = word15_we[9];
    wire gclk15_10;
assign gclk15_10 = word15_we[10];
    wire gclk15_11;
assign gclk15_11 = word15_we[11];
    wire gclk15_12;
assign gclk15_12 = word15_we[12];
    wire gclk15_13;
assign gclk15_13 = word15_we[13];
    wire gclk15_14;
assign gclk15_14 = word15_we[14];
    wire gclk15_15;
assign gclk15_15 = word15_we[15];
    wire [127:0] wmux15;
    reg [7:0] xtmux_1299;
    always @(*) begin
        xtmux_1299 = 8'b0;
        case({wr0_word_we15_C13[0],
            wr1_word_we15_C13[0],
            wr2_word_we15_C15[0],
            wr3_word_we15_C14[0]}) 
/* synopsys full_case */
            4'b1000: xtmux_1299 = wr0_data_C13[7:0];
            4'b0100: xtmux_1299 = wr1_data_C13[7:0];
            4'b0010: xtmux_1299 = wr2_data_C15[7:0];
            4'b0001: xtmux_1299 = wr3_data_C14[7:0];
        endcase
    end
    assign wmux15[7:0] = xtmux_1299;

    reg [7:0] xtmux_1300;
    always @(*) begin
        xtmux_1300 = 8'b0;
        case({wr0_word_we15_C13[1],
            wr1_word_we15_C13[1],
            wr2_word_we15_C15[1],
            wr3_word_we15_C14[1]}) 
/* synopsys full_case */
            4'b1000: xtmux_1300 = wr0_data_C13[15:8];
            4'b0100: xtmux_1300 = wr1_data_C13[15:8];
            4'b0010: xtmux_1300 = wr2_data_C15[15:8];
            4'b0001: xtmux_1300 = wr3_data_C14[15:8];
        endcase
    end
    assign wmux15[15:8] = xtmux_1300;

    reg [7:0] xtmux_1301;
    always @(*) begin
        xtmux_1301 = 8'b0;
        case({wr0_word_we15_C13[2],
            wr1_word_we15_C13[2],
            wr2_word_we15_C15[2],
            wr3_word_we15_C14[2]}) 
/* synopsys full_case */
            4'b1000: xtmux_1301 = wr0_data_C13[23:16];
            4'b0100: xtmux_1301 = wr1_data_C13[23:16];
            4'b0010: xtmux_1301 = wr2_data_C15[23:16];
            4'b0001: xtmux_1301 = wr3_data_C14[23:16];
        endcase
    end
    assign wmux15[23:16] = xtmux_1301;

    reg [7:0] xtmux_1302;
    always @(*) begin
        xtmux_1302 = 8'b0;
        case({wr0_word_we15_C13[3],
            wr1_word_we15_C13[3],
            wr2_word_we15_C15[3],
            wr3_word_we15_C14[3]}) 
/* synopsys full_case */
            4'b1000: xtmux_1302 = wr0_data_C13[31:24];
            4'b0100: xtmux_1302 = wr1_data_C13[31:24];
            4'b0010: xtmux_1302 = wr2_data_C15[31:24];
            4'b0001: xtmux_1302 = wr3_data_C14[31:24];
        endcase
    end
    assign wmux15[31:24] = xtmux_1302;

    reg [7:0] xtmux_1303;
    always @(*) begin
        xtmux_1303 = 8'b0;
        case({wr0_word_we15_C13[4],
            wr1_word_we15_C13[4],
            wr2_word_we15_C15[4],
            wr3_word_we15_C14[4]}) 
/* synopsys full_case */
            4'b1000: xtmux_1303 = wr0_data_C13[39:32];
            4'b0100: xtmux_1303 = wr1_data_C13[39:32];
            4'b0010: xtmux_1303 = wr2_data_C15[39:32];
            4'b0001: xtmux_1303 = wr3_data_C14[39:32];
        endcase
    end
    assign wmux15[39:32] = xtmux_1303;

    reg [7:0] xtmux_1304;
    always @(*) begin
        xtmux_1304 = 8'b0;
        case({wr0_word_we15_C13[5],
            wr1_word_we15_C13[5],
            wr2_word_we15_C15[5],
            wr3_word_we15_C14[5]}) 
/* synopsys full_case */
            4'b1000: xtmux_1304 = wr0_data_C13[47:40];
            4'b0100: xtmux_1304 = wr1_data_C13[47:40];
            4'b0010: xtmux_1304 = wr2_data_C15[47:40];
            4'b0001: xtmux_1304 = wr3_data_C14[47:40];
        endcase
    end
    assign wmux15[47:40] = xtmux_1304;

    reg [7:0] xtmux_1305;
    always @(*) begin
        xtmux_1305 = 8'b0;
        case({wr0_word_we15_C13[6],
            wr1_word_we15_C13[6],
            wr2_word_we15_C15[6],
            wr3_word_we15_C14[6]}) 
/* synopsys full_case */
            4'b1000: xtmux_1305 = wr0_data_C13[55:48];
            4'b0100: xtmux_1305 = wr1_data_C13[55:48];
            4'b0010: xtmux_1305 = wr2_data_C15[55:48];
            4'b0001: xtmux_1305 = wr3_data_C14[55:48];
        endcase
    end
    assign wmux15[55:48] = xtmux_1305;

    reg [7:0] xtmux_1306;
    always @(*) begin
        xtmux_1306 = 8'b0;
        case({wr0_word_we15_C13[7],
            wr1_word_we15_C13[7],
            wr2_word_we15_C15[7],
            wr3_word_we15_C14[7]}) 
/* synopsys full_case */
            4'b1000: xtmux_1306 = wr0_data_C13[63:56];
            4'b0100: xtmux_1306 = wr1_data_C13[63:56];
            4'b0010: xtmux_1306 = wr2_data_C15[63:56];
            4'b0001: xtmux_1306 = wr3_data_C14[63:56];
        endcase
    end
    assign wmux15[63:56] = xtmux_1306;

    reg [7:0] xtmux_1307;
    always @(*) begin
        xtmux_1307 = 8'b0;
        case({wr0_word_we15_C13[8],
            wr1_word_we15_C13[8],
            wr2_word_we15_C15[8],
            wr3_word_we15_C14[8]}) 
/* synopsys full_case */
            4'b1000: xtmux_1307 = wr0_data_C13[71:64];
            4'b0100: xtmux_1307 = wr1_data_C13[71:64];
            4'b0010: xtmux_1307 = wr2_data_C15[71:64];
            4'b0001: xtmux_1307 = wr3_data_C14[71:64];
        endcase
    end
    assign wmux15[71:64] = xtmux_1307;

    reg [7:0] xtmux_1308;
    always @(*) begin
        xtmux_1308 = 8'b0;
        case({wr0_word_we15_C13[9],
            wr1_word_we15_C13[9],
            wr2_word_we15_C15[9],
            wr3_word_we15_C14[9]}) 
/* synopsys full_case */
            4'b1000: xtmux_1308 = wr0_data_C13[79:72];
            4'b0100: xtmux_1308 = wr1_data_C13[79:72];
            4'b0010: xtmux_1308 = wr2_data_C15[79:72];
            4'b0001: xtmux_1308 = wr3_data_C14[79:72];
        endcase
    end
    assign wmux15[79:72] = xtmux_1308;

    reg [7:0] xtmux_1309;
    always @(*) begin
        xtmux_1309 = 8'b0;
        case({wr0_word_we15_C13[10],
            wr1_word_we15_C13[10],
            wr2_word_we15_C15[10],
            wr3_word_we15_C14[10]}) 
/* synopsys full_case */
            4'b1000: xtmux_1309 = wr0_data_C13[87:80];
            4'b0100: xtmux_1309 = wr1_data_C13[87:80];
            4'b0010: xtmux_1309 = wr2_data_C15[87:80];
            4'b0001: xtmux_1309 = wr3_data_C14[87:80];
        endcase
    end
    assign wmux15[87:80] = xtmux_1309;

    reg [7:0] xtmux_1310;
    always @(*) begin
        xtmux_1310 = 8'b0;
        case({wr0_word_we15_C13[11],
            wr1_word_we15_C13[11],
            wr2_word_we15_C15[11],
            wr3_word_we15_C14[11]}) 
/* synopsys full_case */
            4'b1000: xtmux_1310 = wr0_data_C13[95:88];
            4'b0100: xtmux_1310 = wr1_data_C13[95:88];
            4'b0010: xtmux_1310 = wr2_data_C15[95:88];
            4'b0001: xtmux_1310 = wr3_data_C14[95:88];
        endcase
    end
    assign wmux15[95:88] = xtmux_1310;

    reg [7:0] xtmux_1311;
    always @(*) begin
        xtmux_1311 = 8'b0;
        case({wr0_word_we15_C13[12],
            wr1_word_we15_C13[12],
            wr2_word_we15_C15[12],
            wr3_word_we15_C14[12]}) 
/* synopsys full_case */
            4'b1000: xtmux_1311 = wr0_data_C13[103:96];
            4'b0100: xtmux_1311 = wr1_data_C13[103:96];
            4'b0010: xtmux_1311 = wr2_data_C15[103:96];
            4'b0001: xtmux_1311 = wr3_data_C14[103:96];
        endcase
    end
    assign wmux15[103:96] = xtmux_1311;

    reg [7:0] xtmux_1312;
    always @(*) begin
        xtmux_1312 = 8'b0;
        case({wr0_word_we15_C13[13],
            wr1_word_we15_C13[13],
            wr2_word_we15_C15[13],
            wr3_word_we15_C14[13]}) 
/* synopsys full_case */
            4'b1000: xtmux_1312 = wr0_data_C13[111:104];
            4'b0100: xtmux_1312 = wr1_data_C13[111:104];
            4'b0010: xtmux_1312 = wr2_data_C15[111:104];
            4'b0001: xtmux_1312 = wr3_data_C14[111:104];
        endcase
    end
    assign wmux15[111:104] = xtmux_1312;

    reg [7:0] xtmux_1313;
    always @(*) begin
        xtmux_1313 = 8'b0;
        case({wr0_word_we15_C13[14],
            wr1_word_we15_C13[14],
            wr2_word_we15_C15[14],
            wr3_word_we15_C14[14]}) 
/* synopsys full_case */
            4'b1000: xtmux_1313 = wr0_data_C13[119:112];
            4'b0100: xtmux_1313 = wr1_data_C13[119:112];
            4'b0010: xtmux_1313 = wr2_data_C15[119:112];
            4'b0001: xtmux_1313 = wr3_data_C14[119:112];
        endcase
    end
    assign wmux15[119:112] = xtmux_1313;

    reg [7:0] xtmux_1314;
    always @(*) begin
        xtmux_1314 = 8'b0;
        case({wr0_word_we15_C13[15],
            wr1_word_we15_C13[15],
            wr2_word_we15_C15[15],
            wr3_word_we15_C14[15]}) 
/* synopsys full_case */
            4'b1000: xtmux_1314 = wr0_data_C13[127:120];
            4'b0100: xtmux_1314 = wr1_data_C13[127:120];
            4'b0010: xtmux_1314 = wr2_data_C15[127:120];
            4'b0001: xtmux_1314 = wr3_data_C14[127:120];
        endcase
    end
    assign wmux15[127:120] = xtmux_1314;

    wire [127:0] word15;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word15_p0;
    assign word15[7:0] = XACC_reg_word15_p0;
    always @(posedge clk or posedge localReset)
        XACC_reg_word15_p0 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk15_0) ? wmux15[7:0] : XACC_reg_word15_p0;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word15_p1;
    assign word15[15:8] = XACC_reg_word15_p1;
    always @(posedge clk or posedge localReset)
        XACC_reg_word15_p1 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk15_1) ? wmux15[15:8] : XACC_reg_word15_p1;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word15_p2;
    assign word15[23:16] = XACC_reg_word15_p2;
    always @(posedge clk or posedge localReset)
        XACC_reg_word15_p2 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk15_2) ? wmux15[23:16] : XACC_reg_word15_p2;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word15_p3;
    assign word15[31:24] = XACC_reg_word15_p3;
    always @(posedge clk or posedge localReset)
        XACC_reg_word15_p3 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk15_3) ? wmux15[31:24] : XACC_reg_word15_p3;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word15_p4;
    assign word15[39:32] = XACC_reg_word15_p4;
    always @(posedge clk or posedge localReset)
        XACC_reg_word15_p4 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk15_4) ? wmux15[39:32] : XACC_reg_word15_p4;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word15_p5;
    assign word15[47:40] = XACC_reg_word15_p5;
    always @(posedge clk or posedge localReset)
        XACC_reg_word15_p5 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk15_5) ? wmux15[47:40] : XACC_reg_word15_p5;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word15_p6;
    assign word15[55:48] = XACC_reg_word15_p6;
    always @(posedge clk or posedge localReset)
        XACC_reg_word15_p6 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk15_6) ? wmux15[55:48] : XACC_reg_word15_p6;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word15_p7;
    assign word15[63:56] = XACC_reg_word15_p7;
    always @(posedge clk or posedge localReset)
        XACC_reg_word15_p7 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk15_7) ? wmux15[63:56] : XACC_reg_word15_p7;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word15_p8;
    assign word15[71:64] = XACC_reg_word15_p8;
    always @(posedge clk or posedge localReset)
        XACC_reg_word15_p8 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk15_8) ? wmux15[71:64] : XACC_reg_word15_p8;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word15_p9;
    assign word15[79:72] = XACC_reg_word15_p9;
    always @(posedge clk or posedge localReset)
        XACC_reg_word15_p9 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk15_9) ? wmux15[79:72] : XACC_reg_word15_p9;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word15_p10;
    assign word15[87:80] = XACC_reg_word15_p10;
    always @(posedge clk or posedge localReset)
        XACC_reg_word15_p10 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk15_10) ? wmux15[87:80] : XACC_reg_word15_p10;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word15_p11;
    assign word15[95:88] = XACC_reg_word15_p11;
    always @(posedge clk or posedge localReset)
        XACC_reg_word15_p11 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk15_11) ? wmux15[95:88] : XACC_reg_word15_p11;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word15_p12;
    assign word15[103:96] = XACC_reg_word15_p12;
    always @(posedge clk or posedge localReset)
        XACC_reg_word15_p12 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk15_12) ? wmux15[103:96] : XACC_reg_word15_p12;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word15_p13;
    assign word15[111:104] = XACC_reg_word15_p13;
    always @(posedge clk or posedge localReset)
        XACC_reg_word15_p13 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk15_13) ? wmux15[111:104] : XACC_reg_word15_p13;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word15_p14;
    assign word15[119:112] = XACC_reg_word15_p14;
    always @(posedge clk or posedge localReset)
        XACC_reg_word15_p14 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk15_14) ? wmux15[119:112] : XACC_reg_word15_p14;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word15_p15;
    assign word15[127:120] = XACC_reg_word15_p15;
    always @(posedge clk or posedge localReset)
        XACC_reg_word15_p15 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk15_15) ? wmux15[127:120] : XACC_reg_word15_p15;

    wire [15:0] wr0_word_we16_C13 = wr0_we_C13 & {16{(wr0_addr_C13 == 5'd16)}};
    wire [15:0] wr1_word_we16_C13 = wr1_we_C13 & {16{(wr1_addr_C13 == 5'd16)}};
    wire [15:0] wr2_word_we16_C15 = wr2_we_C15 & {16{(wr2_addr_C15 == 5'd16)}};
    wire [15:0] wr3_word_we16_C14 = wr3_we_C14 & {16{(wr3_addr_C14 == 5'd16)}};
    wire [15:0] word16_we = 16'b0 | wr0_word_we16_C13 | wr1_word_we16_C13 | wr2_word_we16_C15 | wr3_word_we16_C14;
    wire gclk16_0;
assign gclk16_0 = word16_we[0];
    wire gclk16_1;
assign gclk16_1 = word16_we[1];
    wire gclk16_2;
assign gclk16_2 = word16_we[2];
    wire gclk16_3;
assign gclk16_3 = word16_we[3];
    wire gclk16_4;
assign gclk16_4 = word16_we[4];
    wire gclk16_5;
assign gclk16_5 = word16_we[5];
    wire gclk16_6;
assign gclk16_6 = word16_we[6];
    wire gclk16_7;
assign gclk16_7 = word16_we[7];
    wire gclk16_8;
assign gclk16_8 = word16_we[8];
    wire gclk16_9;
assign gclk16_9 = word16_we[9];
    wire gclk16_10;
assign gclk16_10 = word16_we[10];
    wire gclk16_11;
assign gclk16_11 = word16_we[11];
    wire gclk16_12;
assign gclk16_12 = word16_we[12];
    wire gclk16_13;
assign gclk16_13 = word16_we[13];
    wire gclk16_14;
assign gclk16_14 = word16_we[14];
    wire gclk16_15;
assign gclk16_15 = word16_we[15];
    wire [127:0] wmux16;
    reg [7:0] xtmux_1315;
    always @(*) begin
        xtmux_1315 = 8'b0;
        case({wr0_word_we16_C13[0],
            wr1_word_we16_C13[0],
            wr2_word_we16_C15[0],
            wr3_word_we16_C14[0]}) 
/* synopsys full_case */
            4'b1000: xtmux_1315 = wr0_data_C13[7:0];
            4'b0100: xtmux_1315 = wr1_data_C13[7:0];
            4'b0010: xtmux_1315 = wr2_data_C15[7:0];
            4'b0001: xtmux_1315 = wr3_data_C14[7:0];
        endcase
    end
    assign wmux16[7:0] = xtmux_1315;

    reg [7:0] xtmux_1316;
    always @(*) begin
        xtmux_1316 = 8'b0;
        case({wr0_word_we16_C13[1],
            wr1_word_we16_C13[1],
            wr2_word_we16_C15[1],
            wr3_word_we16_C14[1]}) 
/* synopsys full_case */
            4'b1000: xtmux_1316 = wr0_data_C13[15:8];
            4'b0100: xtmux_1316 = wr1_data_C13[15:8];
            4'b0010: xtmux_1316 = wr2_data_C15[15:8];
            4'b0001: xtmux_1316 = wr3_data_C14[15:8];
        endcase
    end
    assign wmux16[15:8] = xtmux_1316;

    reg [7:0] xtmux_1317;
    always @(*) begin
        xtmux_1317 = 8'b0;
        case({wr0_word_we16_C13[2],
            wr1_word_we16_C13[2],
            wr2_word_we16_C15[2],
            wr3_word_we16_C14[2]}) 
/* synopsys full_case */
            4'b1000: xtmux_1317 = wr0_data_C13[23:16];
            4'b0100: xtmux_1317 = wr1_data_C13[23:16];
            4'b0010: xtmux_1317 = wr2_data_C15[23:16];
            4'b0001: xtmux_1317 = wr3_data_C14[23:16];
        endcase
    end
    assign wmux16[23:16] = xtmux_1317;

    reg [7:0] xtmux_1318;
    always @(*) begin
        xtmux_1318 = 8'b0;
        case({wr0_word_we16_C13[3],
            wr1_word_we16_C13[3],
            wr2_word_we16_C15[3],
            wr3_word_we16_C14[3]}) 
/* synopsys full_case */
            4'b1000: xtmux_1318 = wr0_data_C13[31:24];
            4'b0100: xtmux_1318 = wr1_data_C13[31:24];
            4'b0010: xtmux_1318 = wr2_data_C15[31:24];
            4'b0001: xtmux_1318 = wr3_data_C14[31:24];
        endcase
    end
    assign wmux16[31:24] = xtmux_1318;

    reg [7:0] xtmux_1319;
    always @(*) begin
        xtmux_1319 = 8'b0;
        case({wr0_word_we16_C13[4],
            wr1_word_we16_C13[4],
            wr2_word_we16_C15[4],
            wr3_word_we16_C14[4]}) 
/* synopsys full_case */
            4'b1000: xtmux_1319 = wr0_data_C13[39:32];
            4'b0100: xtmux_1319 = wr1_data_C13[39:32];
            4'b0010: xtmux_1319 = wr2_data_C15[39:32];
            4'b0001: xtmux_1319 = wr3_data_C14[39:32];
        endcase
    end
    assign wmux16[39:32] = xtmux_1319;

    reg [7:0] xtmux_1320;
    always @(*) begin
        xtmux_1320 = 8'b0;
        case({wr0_word_we16_C13[5],
            wr1_word_we16_C13[5],
            wr2_word_we16_C15[5],
            wr3_word_we16_C14[5]}) 
/* synopsys full_case */
            4'b1000: xtmux_1320 = wr0_data_C13[47:40];
            4'b0100: xtmux_1320 = wr1_data_C13[47:40];
            4'b0010: xtmux_1320 = wr2_data_C15[47:40];
            4'b0001: xtmux_1320 = wr3_data_C14[47:40];
        endcase
    end
    assign wmux16[47:40] = xtmux_1320;

    reg [7:0] xtmux_1321;
    always @(*) begin
        xtmux_1321 = 8'b0;
        case({wr0_word_we16_C13[6],
            wr1_word_we16_C13[6],
            wr2_word_we16_C15[6],
            wr3_word_we16_C14[6]}) 
/* synopsys full_case */
            4'b1000: xtmux_1321 = wr0_data_C13[55:48];
            4'b0100: xtmux_1321 = wr1_data_C13[55:48];
            4'b0010: xtmux_1321 = wr2_data_C15[55:48];
            4'b0001: xtmux_1321 = wr3_data_C14[55:48];
        endcase
    end
    assign wmux16[55:48] = xtmux_1321;

    reg [7:0] xtmux_1322;
    always @(*) begin
        xtmux_1322 = 8'b0;
        case({wr0_word_we16_C13[7],
            wr1_word_we16_C13[7],
            wr2_word_we16_C15[7],
            wr3_word_we16_C14[7]}) 
/* synopsys full_case */
            4'b1000: xtmux_1322 = wr0_data_C13[63:56];
            4'b0100: xtmux_1322 = wr1_data_C13[63:56];
            4'b0010: xtmux_1322 = wr2_data_C15[63:56];
            4'b0001: xtmux_1322 = wr3_data_C14[63:56];
        endcase
    end
    assign wmux16[63:56] = xtmux_1322;

    reg [7:0] xtmux_1323;
    always @(*) begin
        xtmux_1323 = 8'b0;
        case({wr0_word_we16_C13[8],
            wr1_word_we16_C13[8],
            wr2_word_we16_C15[8],
            wr3_word_we16_C14[8]}) 
/* synopsys full_case */
            4'b1000: xtmux_1323 = wr0_data_C13[71:64];
            4'b0100: xtmux_1323 = wr1_data_C13[71:64];
            4'b0010: xtmux_1323 = wr2_data_C15[71:64];
            4'b0001: xtmux_1323 = wr3_data_C14[71:64];
        endcase
    end
    assign wmux16[71:64] = xtmux_1323;

    reg [7:0] xtmux_1324;
    always @(*) begin
        xtmux_1324 = 8'b0;
        case({wr0_word_we16_C13[9],
            wr1_word_we16_C13[9],
            wr2_word_we16_C15[9],
            wr3_word_we16_C14[9]}) 
/* synopsys full_case */
            4'b1000: xtmux_1324 = wr0_data_C13[79:72];
            4'b0100: xtmux_1324 = wr1_data_C13[79:72];
            4'b0010: xtmux_1324 = wr2_data_C15[79:72];
            4'b0001: xtmux_1324 = wr3_data_C14[79:72];
        endcase
    end
    assign wmux16[79:72] = xtmux_1324;

    reg [7:0] xtmux_1325;
    always @(*) begin
        xtmux_1325 = 8'b0;
        case({wr0_word_we16_C13[10],
            wr1_word_we16_C13[10],
            wr2_word_we16_C15[10],
            wr3_word_we16_C14[10]}) 
/* synopsys full_case */
            4'b1000: xtmux_1325 = wr0_data_C13[87:80];
            4'b0100: xtmux_1325 = wr1_data_C13[87:80];
            4'b0010: xtmux_1325 = wr2_data_C15[87:80];
            4'b0001: xtmux_1325 = wr3_data_C14[87:80];
        endcase
    end
    assign wmux16[87:80] = xtmux_1325;

    reg [7:0] xtmux_1326;
    always @(*) begin
        xtmux_1326 = 8'b0;
        case({wr0_word_we16_C13[11],
            wr1_word_we16_C13[11],
            wr2_word_we16_C15[11],
            wr3_word_we16_C14[11]}) 
/* synopsys full_case */
            4'b1000: xtmux_1326 = wr0_data_C13[95:88];
            4'b0100: xtmux_1326 = wr1_data_C13[95:88];
            4'b0010: xtmux_1326 = wr2_data_C15[95:88];
            4'b0001: xtmux_1326 = wr3_data_C14[95:88];
        endcase
    end
    assign wmux16[95:88] = xtmux_1326;

    reg [7:0] xtmux_1327;
    always @(*) begin
        xtmux_1327 = 8'b0;
        case({wr0_word_we16_C13[12],
            wr1_word_we16_C13[12],
            wr2_word_we16_C15[12],
            wr3_word_we16_C14[12]}) 
/* synopsys full_case */
            4'b1000: xtmux_1327 = wr0_data_C13[103:96];
            4'b0100: xtmux_1327 = wr1_data_C13[103:96];
            4'b0010: xtmux_1327 = wr2_data_C15[103:96];
            4'b0001: xtmux_1327 = wr3_data_C14[103:96];
        endcase
    end
    assign wmux16[103:96] = xtmux_1327;

    reg [7:0] xtmux_1328;
    always @(*) begin
        xtmux_1328 = 8'b0;
        case({wr0_word_we16_C13[13],
            wr1_word_we16_C13[13],
            wr2_word_we16_C15[13],
            wr3_word_we16_C14[13]}) 
/* synopsys full_case */
            4'b1000: xtmux_1328 = wr0_data_C13[111:104];
            4'b0100: xtmux_1328 = wr1_data_C13[111:104];
            4'b0010: xtmux_1328 = wr2_data_C15[111:104];
            4'b0001: xtmux_1328 = wr3_data_C14[111:104];
        endcase
    end
    assign wmux16[111:104] = xtmux_1328;

    reg [7:0] xtmux_1329;
    always @(*) begin
        xtmux_1329 = 8'b0;
        case({wr0_word_we16_C13[14],
            wr1_word_we16_C13[14],
            wr2_word_we16_C15[14],
            wr3_word_we16_C14[14]}) 
/* synopsys full_case */
            4'b1000: xtmux_1329 = wr0_data_C13[119:112];
            4'b0100: xtmux_1329 = wr1_data_C13[119:112];
            4'b0010: xtmux_1329 = wr2_data_C15[119:112];
            4'b0001: xtmux_1329 = wr3_data_C14[119:112];
        endcase
    end
    assign wmux16[119:112] = xtmux_1329;

    reg [7:0] xtmux_1330;
    always @(*) begin
        xtmux_1330 = 8'b0;
        case({wr0_word_we16_C13[15],
            wr1_word_we16_C13[15],
            wr2_word_we16_C15[15],
            wr3_word_we16_C14[15]}) 
/* synopsys full_case */
            4'b1000: xtmux_1330 = wr0_data_C13[127:120];
            4'b0100: xtmux_1330 = wr1_data_C13[127:120];
            4'b0010: xtmux_1330 = wr2_data_C15[127:120];
            4'b0001: xtmux_1330 = wr3_data_C14[127:120];
        endcase
    end
    assign wmux16[127:120] = xtmux_1330;

    wire [127:0] word16;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word16_p0;
    assign word16[7:0] = XACC_reg_word16_p0;
    always @(posedge clk or posedge localReset)
        XACC_reg_word16_p0 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk16_0) ? wmux16[7:0] : XACC_reg_word16_p0;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word16_p1;
    assign word16[15:8] = XACC_reg_word16_p1;
    always @(posedge clk or posedge localReset)
        XACC_reg_word16_p1 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk16_1) ? wmux16[15:8] : XACC_reg_word16_p1;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word16_p2;
    assign word16[23:16] = XACC_reg_word16_p2;
    always @(posedge clk or posedge localReset)
        XACC_reg_word16_p2 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk16_2) ? wmux16[23:16] : XACC_reg_word16_p2;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word16_p3;
    assign word16[31:24] = XACC_reg_word16_p3;
    always @(posedge clk or posedge localReset)
        XACC_reg_word16_p3 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk16_3) ? wmux16[31:24] : XACC_reg_word16_p3;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word16_p4;
    assign word16[39:32] = XACC_reg_word16_p4;
    always @(posedge clk or posedge localReset)
        XACC_reg_word16_p4 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk16_4) ? wmux16[39:32] : XACC_reg_word16_p4;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word16_p5;
    assign word16[47:40] = XACC_reg_word16_p5;
    always @(posedge clk or posedge localReset)
        XACC_reg_word16_p5 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk16_5) ? wmux16[47:40] : XACC_reg_word16_p5;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word16_p6;
    assign word16[55:48] = XACC_reg_word16_p6;
    always @(posedge clk or posedge localReset)
        XACC_reg_word16_p6 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk16_6) ? wmux16[55:48] : XACC_reg_word16_p6;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word16_p7;
    assign word16[63:56] = XACC_reg_word16_p7;
    always @(posedge clk or posedge localReset)
        XACC_reg_word16_p7 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk16_7) ? wmux16[63:56] : XACC_reg_word16_p7;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word16_p8;
    assign word16[71:64] = XACC_reg_word16_p8;
    always @(posedge clk or posedge localReset)
        XACC_reg_word16_p8 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk16_8) ? wmux16[71:64] : XACC_reg_word16_p8;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word16_p9;
    assign word16[79:72] = XACC_reg_word16_p9;
    always @(posedge clk or posedge localReset)
        XACC_reg_word16_p9 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk16_9) ? wmux16[79:72] : XACC_reg_word16_p9;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word16_p10;
    assign word16[87:80] = XACC_reg_word16_p10;
    always @(posedge clk or posedge localReset)
        XACC_reg_word16_p10 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk16_10) ? wmux16[87:80] : XACC_reg_word16_p10;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word16_p11;
    assign word16[95:88] = XACC_reg_word16_p11;
    always @(posedge clk or posedge localReset)
        XACC_reg_word16_p11 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk16_11) ? wmux16[95:88] : XACC_reg_word16_p11;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word16_p12;
    assign word16[103:96] = XACC_reg_word16_p12;
    always @(posedge clk or posedge localReset)
        XACC_reg_word16_p12 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk16_12) ? wmux16[103:96] : XACC_reg_word16_p12;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word16_p13;
    assign word16[111:104] = XACC_reg_word16_p13;
    always @(posedge clk or posedge localReset)
        XACC_reg_word16_p13 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk16_13) ? wmux16[111:104] : XACC_reg_word16_p13;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word16_p14;
    assign word16[119:112] = XACC_reg_word16_p14;
    always @(posedge clk or posedge localReset)
        XACC_reg_word16_p14 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk16_14) ? wmux16[119:112] : XACC_reg_word16_p14;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word16_p15;
    assign word16[127:120] = XACC_reg_word16_p15;
    always @(posedge clk or posedge localReset)
        XACC_reg_word16_p15 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk16_15) ? wmux16[127:120] : XACC_reg_word16_p15;

    wire [15:0] wr0_word_we17_C13 = wr0_we_C13 & {16{(wr0_addr_C13 == 5'd17)}};
    wire [15:0] wr1_word_we17_C13 = wr1_we_C13 & {16{(wr1_addr_C13 == 5'd17)}};
    wire [15:0] wr2_word_we17_C15 = wr2_we_C15 & {16{(wr2_addr_C15 == 5'd17)}};
    wire [15:0] wr3_word_we17_C14 = wr3_we_C14 & {16{(wr3_addr_C14 == 5'd17)}};
    wire [15:0] word17_we = 16'b0 | wr0_word_we17_C13 | wr1_word_we17_C13 | wr2_word_we17_C15 | wr3_word_we17_C14;
    wire gclk17_0;
assign gclk17_0 = word17_we[0];
    wire gclk17_1;
assign gclk17_1 = word17_we[1];
    wire gclk17_2;
assign gclk17_2 = word17_we[2];
    wire gclk17_3;
assign gclk17_3 = word17_we[3];
    wire gclk17_4;
assign gclk17_4 = word17_we[4];
    wire gclk17_5;
assign gclk17_5 = word17_we[5];
    wire gclk17_6;
assign gclk17_6 = word17_we[6];
    wire gclk17_7;
assign gclk17_7 = word17_we[7];
    wire gclk17_8;
assign gclk17_8 = word17_we[8];
    wire gclk17_9;
assign gclk17_9 = word17_we[9];
    wire gclk17_10;
assign gclk17_10 = word17_we[10];
    wire gclk17_11;
assign gclk17_11 = word17_we[11];
    wire gclk17_12;
assign gclk17_12 = word17_we[12];
    wire gclk17_13;
assign gclk17_13 = word17_we[13];
    wire gclk17_14;
assign gclk17_14 = word17_we[14];
    wire gclk17_15;
assign gclk17_15 = word17_we[15];
    wire [127:0] wmux17;
    reg [7:0] xtmux_1331;
    always @(*) begin
        xtmux_1331 = 8'b0;
        case({wr0_word_we17_C13[0],
            wr1_word_we17_C13[0],
            wr2_word_we17_C15[0],
            wr3_word_we17_C14[0]}) 
/* synopsys full_case */
            4'b1000: xtmux_1331 = wr0_data_C13[7:0];
            4'b0100: xtmux_1331 = wr1_data_C13[7:0];
            4'b0010: xtmux_1331 = wr2_data_C15[7:0];
            4'b0001: xtmux_1331 = wr3_data_C14[7:0];
        endcase
    end
    assign wmux17[7:0] = xtmux_1331;

    reg [7:0] xtmux_1332;
    always @(*) begin
        xtmux_1332 = 8'b0;
        case({wr0_word_we17_C13[1],
            wr1_word_we17_C13[1],
            wr2_word_we17_C15[1],
            wr3_word_we17_C14[1]}) 
/* synopsys full_case */
            4'b1000: xtmux_1332 = wr0_data_C13[15:8];
            4'b0100: xtmux_1332 = wr1_data_C13[15:8];
            4'b0010: xtmux_1332 = wr2_data_C15[15:8];
            4'b0001: xtmux_1332 = wr3_data_C14[15:8];
        endcase
    end
    assign wmux17[15:8] = xtmux_1332;

    reg [7:0] xtmux_1333;
    always @(*) begin
        xtmux_1333 = 8'b0;
        case({wr0_word_we17_C13[2],
            wr1_word_we17_C13[2],
            wr2_word_we17_C15[2],
            wr3_word_we17_C14[2]}) 
/* synopsys full_case */
            4'b1000: xtmux_1333 = wr0_data_C13[23:16];
            4'b0100: xtmux_1333 = wr1_data_C13[23:16];
            4'b0010: xtmux_1333 = wr2_data_C15[23:16];
            4'b0001: xtmux_1333 = wr3_data_C14[23:16];
        endcase
    end
    assign wmux17[23:16] = xtmux_1333;

    reg [7:0] xtmux_1334;
    always @(*) begin
        xtmux_1334 = 8'b0;
        case({wr0_word_we17_C13[3],
            wr1_word_we17_C13[3],
            wr2_word_we17_C15[3],
            wr3_word_we17_C14[3]}) 
/* synopsys full_case */
            4'b1000: xtmux_1334 = wr0_data_C13[31:24];
            4'b0100: xtmux_1334 = wr1_data_C13[31:24];
            4'b0010: xtmux_1334 = wr2_data_C15[31:24];
            4'b0001: xtmux_1334 = wr3_data_C14[31:24];
        endcase
    end
    assign wmux17[31:24] = xtmux_1334;

    reg [7:0] xtmux_1335;
    always @(*) begin
        xtmux_1335 = 8'b0;
        case({wr0_word_we17_C13[4],
            wr1_word_we17_C13[4],
            wr2_word_we17_C15[4],
            wr3_word_we17_C14[4]}) 
/* synopsys full_case */
            4'b1000: xtmux_1335 = wr0_data_C13[39:32];
            4'b0100: xtmux_1335 = wr1_data_C13[39:32];
            4'b0010: xtmux_1335 = wr2_data_C15[39:32];
            4'b0001: xtmux_1335 = wr3_data_C14[39:32];
        endcase
    end
    assign wmux17[39:32] = xtmux_1335;

    reg [7:0] xtmux_1336;
    always @(*) begin
        xtmux_1336 = 8'b0;
        case({wr0_word_we17_C13[5],
            wr1_word_we17_C13[5],
            wr2_word_we17_C15[5],
            wr3_word_we17_C14[5]}) 
/* synopsys full_case */
            4'b1000: xtmux_1336 = wr0_data_C13[47:40];
            4'b0100: xtmux_1336 = wr1_data_C13[47:40];
            4'b0010: xtmux_1336 = wr2_data_C15[47:40];
            4'b0001: xtmux_1336 = wr3_data_C14[47:40];
        endcase
    end
    assign wmux17[47:40] = xtmux_1336;

    reg [7:0] xtmux_1337;
    always @(*) begin
        xtmux_1337 = 8'b0;
        case({wr0_word_we17_C13[6],
            wr1_word_we17_C13[6],
            wr2_word_we17_C15[6],
            wr3_word_we17_C14[6]}) 
/* synopsys full_case */
            4'b1000: xtmux_1337 = wr0_data_C13[55:48];
            4'b0100: xtmux_1337 = wr1_data_C13[55:48];
            4'b0010: xtmux_1337 = wr2_data_C15[55:48];
            4'b0001: xtmux_1337 = wr3_data_C14[55:48];
        endcase
    end
    assign wmux17[55:48] = xtmux_1337;

    reg [7:0] xtmux_1338;
    always @(*) begin
        xtmux_1338 = 8'b0;
        case({wr0_word_we17_C13[7],
            wr1_word_we17_C13[7],
            wr2_word_we17_C15[7],
            wr3_word_we17_C14[7]}) 
/* synopsys full_case */
            4'b1000: xtmux_1338 = wr0_data_C13[63:56];
            4'b0100: xtmux_1338 = wr1_data_C13[63:56];
            4'b0010: xtmux_1338 = wr2_data_C15[63:56];
            4'b0001: xtmux_1338 = wr3_data_C14[63:56];
        endcase
    end
    assign wmux17[63:56] = xtmux_1338;

    reg [7:0] xtmux_1339;
    always @(*) begin
        xtmux_1339 = 8'b0;
        case({wr0_word_we17_C13[8],
            wr1_word_we17_C13[8],
            wr2_word_we17_C15[8],
            wr3_word_we17_C14[8]}) 
/* synopsys full_case */
            4'b1000: xtmux_1339 = wr0_data_C13[71:64];
            4'b0100: xtmux_1339 = wr1_data_C13[71:64];
            4'b0010: xtmux_1339 = wr2_data_C15[71:64];
            4'b0001: xtmux_1339 = wr3_data_C14[71:64];
        endcase
    end
    assign wmux17[71:64] = xtmux_1339;

    reg [7:0] xtmux_1340;
    always @(*) begin
        xtmux_1340 = 8'b0;
        case({wr0_word_we17_C13[9],
            wr1_word_we17_C13[9],
            wr2_word_we17_C15[9],
            wr3_word_we17_C14[9]}) 
/* synopsys full_case */
            4'b1000: xtmux_1340 = wr0_data_C13[79:72];
            4'b0100: xtmux_1340 = wr1_data_C13[79:72];
            4'b0010: xtmux_1340 = wr2_data_C15[79:72];
            4'b0001: xtmux_1340 = wr3_data_C14[79:72];
        endcase
    end
    assign wmux17[79:72] = xtmux_1340;

    reg [7:0] xtmux_1341;
    always @(*) begin
        xtmux_1341 = 8'b0;
        case({wr0_word_we17_C13[10],
            wr1_word_we17_C13[10],
            wr2_word_we17_C15[10],
            wr3_word_we17_C14[10]}) 
/* synopsys full_case */
            4'b1000: xtmux_1341 = wr0_data_C13[87:80];
            4'b0100: xtmux_1341 = wr1_data_C13[87:80];
            4'b0010: xtmux_1341 = wr2_data_C15[87:80];
            4'b0001: xtmux_1341 = wr3_data_C14[87:80];
        endcase
    end
    assign wmux17[87:80] = xtmux_1341;

    reg [7:0] xtmux_1342;
    always @(*) begin
        xtmux_1342 = 8'b0;
        case({wr0_word_we17_C13[11],
            wr1_word_we17_C13[11],
            wr2_word_we17_C15[11],
            wr3_word_we17_C14[11]}) 
/* synopsys full_case */
            4'b1000: xtmux_1342 = wr0_data_C13[95:88];
            4'b0100: xtmux_1342 = wr1_data_C13[95:88];
            4'b0010: xtmux_1342 = wr2_data_C15[95:88];
            4'b0001: xtmux_1342 = wr3_data_C14[95:88];
        endcase
    end
    assign wmux17[95:88] = xtmux_1342;

    reg [7:0] xtmux_1343;
    always @(*) begin
        xtmux_1343 = 8'b0;
        case({wr0_word_we17_C13[12],
            wr1_word_we17_C13[12],
            wr2_word_we17_C15[12],
            wr3_word_we17_C14[12]}) 
/* synopsys full_case */
            4'b1000: xtmux_1343 = wr0_data_C13[103:96];
            4'b0100: xtmux_1343 = wr1_data_C13[103:96];
            4'b0010: xtmux_1343 = wr2_data_C15[103:96];
            4'b0001: xtmux_1343 = wr3_data_C14[103:96];
        endcase
    end
    assign wmux17[103:96] = xtmux_1343;

    reg [7:0] xtmux_1344;
    always @(*) begin
        xtmux_1344 = 8'b0;
        case({wr0_word_we17_C13[13],
            wr1_word_we17_C13[13],
            wr2_word_we17_C15[13],
            wr3_word_we17_C14[13]}) 
/* synopsys full_case */
            4'b1000: xtmux_1344 = wr0_data_C13[111:104];
            4'b0100: xtmux_1344 = wr1_data_C13[111:104];
            4'b0010: xtmux_1344 = wr2_data_C15[111:104];
            4'b0001: xtmux_1344 = wr3_data_C14[111:104];
        endcase
    end
    assign wmux17[111:104] = xtmux_1344;

    reg [7:0] xtmux_1345;
    always @(*) begin
        xtmux_1345 = 8'b0;
        case({wr0_word_we17_C13[14],
            wr1_word_we17_C13[14],
            wr2_word_we17_C15[14],
            wr3_word_we17_C14[14]}) 
/* synopsys full_case */
            4'b1000: xtmux_1345 = wr0_data_C13[119:112];
            4'b0100: xtmux_1345 = wr1_data_C13[119:112];
            4'b0010: xtmux_1345 = wr2_data_C15[119:112];
            4'b0001: xtmux_1345 = wr3_data_C14[119:112];
        endcase
    end
    assign wmux17[119:112] = xtmux_1345;

    reg [7:0] xtmux_1346;
    always @(*) begin
        xtmux_1346 = 8'b0;
        case({wr0_word_we17_C13[15],
            wr1_word_we17_C13[15],
            wr2_word_we17_C15[15],
            wr3_word_we17_C14[15]}) 
/* synopsys full_case */
            4'b1000: xtmux_1346 = wr0_data_C13[127:120];
            4'b0100: xtmux_1346 = wr1_data_C13[127:120];
            4'b0010: xtmux_1346 = wr2_data_C15[127:120];
            4'b0001: xtmux_1346 = wr3_data_C14[127:120];
        endcase
    end
    assign wmux17[127:120] = xtmux_1346;

    wire [127:0] word17;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word17_p0;
    assign word17[7:0] = XACC_reg_word17_p0;
    always @(posedge clk or posedge localReset)
        XACC_reg_word17_p0 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk17_0) ? wmux17[7:0] : XACC_reg_word17_p0;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word17_p1;
    assign word17[15:8] = XACC_reg_word17_p1;
    always @(posedge clk or posedge localReset)
        XACC_reg_word17_p1 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk17_1) ? wmux17[15:8] : XACC_reg_word17_p1;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word17_p2;
    assign word17[23:16] = XACC_reg_word17_p2;
    always @(posedge clk or posedge localReset)
        XACC_reg_word17_p2 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk17_2) ? wmux17[23:16] : XACC_reg_word17_p2;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word17_p3;
    assign word17[31:24] = XACC_reg_word17_p3;
    always @(posedge clk or posedge localReset)
        XACC_reg_word17_p3 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk17_3) ? wmux17[31:24] : XACC_reg_word17_p3;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word17_p4;
    assign word17[39:32] = XACC_reg_word17_p4;
    always @(posedge clk or posedge localReset)
        XACC_reg_word17_p4 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk17_4) ? wmux17[39:32] : XACC_reg_word17_p4;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word17_p5;
    assign word17[47:40] = XACC_reg_word17_p5;
    always @(posedge clk or posedge localReset)
        XACC_reg_word17_p5 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk17_5) ? wmux17[47:40] : XACC_reg_word17_p5;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word17_p6;
    assign word17[55:48] = XACC_reg_word17_p6;
    always @(posedge clk or posedge localReset)
        XACC_reg_word17_p6 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk17_6) ? wmux17[55:48] : XACC_reg_word17_p6;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word17_p7;
    assign word17[63:56] = XACC_reg_word17_p7;
    always @(posedge clk or posedge localReset)
        XACC_reg_word17_p7 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk17_7) ? wmux17[63:56] : XACC_reg_word17_p7;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word17_p8;
    assign word17[71:64] = XACC_reg_word17_p8;
    always @(posedge clk or posedge localReset)
        XACC_reg_word17_p8 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk17_8) ? wmux17[71:64] : XACC_reg_word17_p8;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word17_p9;
    assign word17[79:72] = XACC_reg_word17_p9;
    always @(posedge clk or posedge localReset)
        XACC_reg_word17_p9 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk17_9) ? wmux17[79:72] : XACC_reg_word17_p9;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word17_p10;
    assign word17[87:80] = XACC_reg_word17_p10;
    always @(posedge clk or posedge localReset)
        XACC_reg_word17_p10 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk17_10) ? wmux17[87:80] : XACC_reg_word17_p10;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word17_p11;
    assign word17[95:88] = XACC_reg_word17_p11;
    always @(posedge clk or posedge localReset)
        XACC_reg_word17_p11 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk17_11) ? wmux17[95:88] : XACC_reg_word17_p11;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word17_p12;
    assign word17[103:96] = XACC_reg_word17_p12;
    always @(posedge clk or posedge localReset)
        XACC_reg_word17_p12 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk17_12) ? wmux17[103:96] : XACC_reg_word17_p12;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word17_p13;
    assign word17[111:104] = XACC_reg_word17_p13;
    always @(posedge clk or posedge localReset)
        XACC_reg_word17_p13 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk17_13) ? wmux17[111:104] : XACC_reg_word17_p13;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word17_p14;
    assign word17[119:112] = XACC_reg_word17_p14;
    always @(posedge clk or posedge localReset)
        XACC_reg_word17_p14 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk17_14) ? wmux17[119:112] : XACC_reg_word17_p14;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word17_p15;
    assign word17[127:120] = XACC_reg_word17_p15;
    always @(posedge clk or posedge localReset)
        XACC_reg_word17_p15 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk17_15) ? wmux17[127:120] : XACC_reg_word17_p15;

    wire [15:0] wr0_word_we18_C13 = wr0_we_C13 & {16{(wr0_addr_C13 == 5'd18)}};
    wire [15:0] wr1_word_we18_C13 = wr1_we_C13 & {16{(wr1_addr_C13 == 5'd18)}};
    wire [15:0] wr2_word_we18_C15 = wr2_we_C15 & {16{(wr2_addr_C15 == 5'd18)}};
    wire [15:0] wr3_word_we18_C14 = wr3_we_C14 & {16{(wr3_addr_C14 == 5'd18)}};
    wire [15:0] word18_we = 16'b0 | wr0_word_we18_C13 | wr1_word_we18_C13 | wr2_word_we18_C15 | wr3_word_we18_C14;
    wire gclk18_0;
assign gclk18_0 = word18_we[0];
    wire gclk18_1;
assign gclk18_1 = word18_we[1];
    wire gclk18_2;
assign gclk18_2 = word18_we[2];
    wire gclk18_3;
assign gclk18_3 = word18_we[3];
    wire gclk18_4;
assign gclk18_4 = word18_we[4];
    wire gclk18_5;
assign gclk18_5 = word18_we[5];
    wire gclk18_6;
assign gclk18_6 = word18_we[6];
    wire gclk18_7;
assign gclk18_7 = word18_we[7];
    wire gclk18_8;
assign gclk18_8 = word18_we[8];
    wire gclk18_9;
assign gclk18_9 = word18_we[9];
    wire gclk18_10;
assign gclk18_10 = word18_we[10];
    wire gclk18_11;
assign gclk18_11 = word18_we[11];
    wire gclk18_12;
assign gclk18_12 = word18_we[12];
    wire gclk18_13;
assign gclk18_13 = word18_we[13];
    wire gclk18_14;
assign gclk18_14 = word18_we[14];
    wire gclk18_15;
assign gclk18_15 = word18_we[15];
    wire [127:0] wmux18;
    reg [7:0] xtmux_1347;
    always @(*) begin
        xtmux_1347 = 8'b0;
        case({wr0_word_we18_C13[0],
            wr1_word_we18_C13[0],
            wr2_word_we18_C15[0],
            wr3_word_we18_C14[0]}) 
/* synopsys full_case */
            4'b1000: xtmux_1347 = wr0_data_C13[7:0];
            4'b0100: xtmux_1347 = wr1_data_C13[7:0];
            4'b0010: xtmux_1347 = wr2_data_C15[7:0];
            4'b0001: xtmux_1347 = wr3_data_C14[7:0];
        endcase
    end
    assign wmux18[7:0] = xtmux_1347;

    reg [7:0] xtmux_1348;
    always @(*) begin
        xtmux_1348 = 8'b0;
        case({wr0_word_we18_C13[1],
            wr1_word_we18_C13[1],
            wr2_word_we18_C15[1],
            wr3_word_we18_C14[1]}) 
/* synopsys full_case */
            4'b1000: xtmux_1348 = wr0_data_C13[15:8];
            4'b0100: xtmux_1348 = wr1_data_C13[15:8];
            4'b0010: xtmux_1348 = wr2_data_C15[15:8];
            4'b0001: xtmux_1348 = wr3_data_C14[15:8];
        endcase
    end
    assign wmux18[15:8] = xtmux_1348;

    reg [7:0] xtmux_1349;
    always @(*) begin
        xtmux_1349 = 8'b0;
        case({wr0_word_we18_C13[2],
            wr1_word_we18_C13[2],
            wr2_word_we18_C15[2],
            wr3_word_we18_C14[2]}) 
/* synopsys full_case */
            4'b1000: xtmux_1349 = wr0_data_C13[23:16];
            4'b0100: xtmux_1349 = wr1_data_C13[23:16];
            4'b0010: xtmux_1349 = wr2_data_C15[23:16];
            4'b0001: xtmux_1349 = wr3_data_C14[23:16];
        endcase
    end
    assign wmux18[23:16] = xtmux_1349;

    reg [7:0] xtmux_1350;
    always @(*) begin
        xtmux_1350 = 8'b0;
        case({wr0_word_we18_C13[3],
            wr1_word_we18_C13[3],
            wr2_word_we18_C15[3],
            wr3_word_we18_C14[3]}) 
/* synopsys full_case */
            4'b1000: xtmux_1350 = wr0_data_C13[31:24];
            4'b0100: xtmux_1350 = wr1_data_C13[31:24];
            4'b0010: xtmux_1350 = wr2_data_C15[31:24];
            4'b0001: xtmux_1350 = wr3_data_C14[31:24];
        endcase
    end
    assign wmux18[31:24] = xtmux_1350;

    reg [7:0] xtmux_1351;
    always @(*) begin
        xtmux_1351 = 8'b0;
        case({wr0_word_we18_C13[4],
            wr1_word_we18_C13[4],
            wr2_word_we18_C15[4],
            wr3_word_we18_C14[4]}) 
/* synopsys full_case */
            4'b1000: xtmux_1351 = wr0_data_C13[39:32];
            4'b0100: xtmux_1351 = wr1_data_C13[39:32];
            4'b0010: xtmux_1351 = wr2_data_C15[39:32];
            4'b0001: xtmux_1351 = wr3_data_C14[39:32];
        endcase
    end
    assign wmux18[39:32] = xtmux_1351;

    reg [7:0] xtmux_1352;
    always @(*) begin
        xtmux_1352 = 8'b0;
        case({wr0_word_we18_C13[5],
            wr1_word_we18_C13[5],
            wr2_word_we18_C15[5],
            wr3_word_we18_C14[5]}) 
/* synopsys full_case */
            4'b1000: xtmux_1352 = wr0_data_C13[47:40];
            4'b0100: xtmux_1352 = wr1_data_C13[47:40];
            4'b0010: xtmux_1352 = wr2_data_C15[47:40];
            4'b0001: xtmux_1352 = wr3_data_C14[47:40];
        endcase
    end
    assign wmux18[47:40] = xtmux_1352;

    reg [7:0] xtmux_1353;
    always @(*) begin
        xtmux_1353 = 8'b0;
        case({wr0_word_we18_C13[6],
            wr1_word_we18_C13[6],
            wr2_word_we18_C15[6],
            wr3_word_we18_C14[6]}) 
/* synopsys full_case */
            4'b1000: xtmux_1353 = wr0_data_C13[55:48];
            4'b0100: xtmux_1353 = wr1_data_C13[55:48];
            4'b0010: xtmux_1353 = wr2_data_C15[55:48];
            4'b0001: xtmux_1353 = wr3_data_C14[55:48];
        endcase
    end
    assign wmux18[55:48] = xtmux_1353;

    reg [7:0] xtmux_1354;
    always @(*) begin
        xtmux_1354 = 8'b0;
        case({wr0_word_we18_C13[7],
            wr1_word_we18_C13[7],
            wr2_word_we18_C15[7],
            wr3_word_we18_C14[7]}) 
/* synopsys full_case */
            4'b1000: xtmux_1354 = wr0_data_C13[63:56];
            4'b0100: xtmux_1354 = wr1_data_C13[63:56];
            4'b0010: xtmux_1354 = wr2_data_C15[63:56];
            4'b0001: xtmux_1354 = wr3_data_C14[63:56];
        endcase
    end
    assign wmux18[63:56] = xtmux_1354;

    reg [7:0] xtmux_1355;
    always @(*) begin
        xtmux_1355 = 8'b0;
        case({wr0_word_we18_C13[8],
            wr1_word_we18_C13[8],
            wr2_word_we18_C15[8],
            wr3_word_we18_C14[8]}) 
/* synopsys full_case */
            4'b1000: xtmux_1355 = wr0_data_C13[71:64];
            4'b0100: xtmux_1355 = wr1_data_C13[71:64];
            4'b0010: xtmux_1355 = wr2_data_C15[71:64];
            4'b0001: xtmux_1355 = wr3_data_C14[71:64];
        endcase
    end
    assign wmux18[71:64] = xtmux_1355;

    reg [7:0] xtmux_1356;
    always @(*) begin
        xtmux_1356 = 8'b0;
        case({wr0_word_we18_C13[9],
            wr1_word_we18_C13[9],
            wr2_word_we18_C15[9],
            wr3_word_we18_C14[9]}) 
/* synopsys full_case */
            4'b1000: xtmux_1356 = wr0_data_C13[79:72];
            4'b0100: xtmux_1356 = wr1_data_C13[79:72];
            4'b0010: xtmux_1356 = wr2_data_C15[79:72];
            4'b0001: xtmux_1356 = wr3_data_C14[79:72];
        endcase
    end
    assign wmux18[79:72] = xtmux_1356;

    reg [7:0] xtmux_1357;
    always @(*) begin
        xtmux_1357 = 8'b0;
        case({wr0_word_we18_C13[10],
            wr1_word_we18_C13[10],
            wr2_word_we18_C15[10],
            wr3_word_we18_C14[10]}) 
/* synopsys full_case */
            4'b1000: xtmux_1357 = wr0_data_C13[87:80];
            4'b0100: xtmux_1357 = wr1_data_C13[87:80];
            4'b0010: xtmux_1357 = wr2_data_C15[87:80];
            4'b0001: xtmux_1357 = wr3_data_C14[87:80];
        endcase
    end
    assign wmux18[87:80] = xtmux_1357;

    reg [7:0] xtmux_1358;
    always @(*) begin
        xtmux_1358 = 8'b0;
        case({wr0_word_we18_C13[11],
            wr1_word_we18_C13[11],
            wr2_word_we18_C15[11],
            wr3_word_we18_C14[11]}) 
/* synopsys full_case */
            4'b1000: xtmux_1358 = wr0_data_C13[95:88];
            4'b0100: xtmux_1358 = wr1_data_C13[95:88];
            4'b0010: xtmux_1358 = wr2_data_C15[95:88];
            4'b0001: xtmux_1358 = wr3_data_C14[95:88];
        endcase
    end
    assign wmux18[95:88] = xtmux_1358;

    reg [7:0] xtmux_1359;
    always @(*) begin
        xtmux_1359 = 8'b0;
        case({wr0_word_we18_C13[12],
            wr1_word_we18_C13[12],
            wr2_word_we18_C15[12],
            wr3_word_we18_C14[12]}) 
/* synopsys full_case */
            4'b1000: xtmux_1359 = wr0_data_C13[103:96];
            4'b0100: xtmux_1359 = wr1_data_C13[103:96];
            4'b0010: xtmux_1359 = wr2_data_C15[103:96];
            4'b0001: xtmux_1359 = wr3_data_C14[103:96];
        endcase
    end
    assign wmux18[103:96] = xtmux_1359;

    reg [7:0] xtmux_1360;
    always @(*) begin
        xtmux_1360 = 8'b0;
        case({wr0_word_we18_C13[13],
            wr1_word_we18_C13[13],
            wr2_word_we18_C15[13],
            wr3_word_we18_C14[13]}) 
/* synopsys full_case */
            4'b1000: xtmux_1360 = wr0_data_C13[111:104];
            4'b0100: xtmux_1360 = wr1_data_C13[111:104];
            4'b0010: xtmux_1360 = wr2_data_C15[111:104];
            4'b0001: xtmux_1360 = wr3_data_C14[111:104];
        endcase
    end
    assign wmux18[111:104] = xtmux_1360;

    reg [7:0] xtmux_1361;
    always @(*) begin
        xtmux_1361 = 8'b0;
        case({wr0_word_we18_C13[14],
            wr1_word_we18_C13[14],
            wr2_word_we18_C15[14],
            wr3_word_we18_C14[14]}) 
/* synopsys full_case */
            4'b1000: xtmux_1361 = wr0_data_C13[119:112];
            4'b0100: xtmux_1361 = wr1_data_C13[119:112];
            4'b0010: xtmux_1361 = wr2_data_C15[119:112];
            4'b0001: xtmux_1361 = wr3_data_C14[119:112];
        endcase
    end
    assign wmux18[119:112] = xtmux_1361;

    reg [7:0] xtmux_1362;
    always @(*) begin
        xtmux_1362 = 8'b0;
        case({wr0_word_we18_C13[15],
            wr1_word_we18_C13[15],
            wr2_word_we18_C15[15],
            wr3_word_we18_C14[15]}) 
/* synopsys full_case */
            4'b1000: xtmux_1362 = wr0_data_C13[127:120];
            4'b0100: xtmux_1362 = wr1_data_C13[127:120];
            4'b0010: xtmux_1362 = wr2_data_C15[127:120];
            4'b0001: xtmux_1362 = wr3_data_C14[127:120];
        endcase
    end
    assign wmux18[127:120] = xtmux_1362;

    wire [127:0] word18;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word18_p0;
    assign word18[7:0] = XACC_reg_word18_p0;
    always @(posedge clk or posedge localReset)
        XACC_reg_word18_p0 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk18_0) ? wmux18[7:0] : XACC_reg_word18_p0;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word18_p1;
    assign word18[15:8] = XACC_reg_word18_p1;
    always @(posedge clk or posedge localReset)
        XACC_reg_word18_p1 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk18_1) ? wmux18[15:8] : XACC_reg_word18_p1;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word18_p2;
    assign word18[23:16] = XACC_reg_word18_p2;
    always @(posedge clk or posedge localReset)
        XACC_reg_word18_p2 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk18_2) ? wmux18[23:16] : XACC_reg_word18_p2;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word18_p3;
    assign word18[31:24] = XACC_reg_word18_p3;
    always @(posedge clk or posedge localReset)
        XACC_reg_word18_p3 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk18_3) ? wmux18[31:24] : XACC_reg_word18_p3;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word18_p4;
    assign word18[39:32] = XACC_reg_word18_p4;
    always @(posedge clk or posedge localReset)
        XACC_reg_word18_p4 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk18_4) ? wmux18[39:32] : XACC_reg_word18_p4;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word18_p5;
    assign word18[47:40] = XACC_reg_word18_p5;
    always @(posedge clk or posedge localReset)
        XACC_reg_word18_p5 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk18_5) ? wmux18[47:40] : XACC_reg_word18_p5;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word18_p6;
    assign word18[55:48] = XACC_reg_word18_p6;
    always @(posedge clk or posedge localReset)
        XACC_reg_word18_p6 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk18_6) ? wmux18[55:48] : XACC_reg_word18_p6;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word18_p7;
    assign word18[63:56] = XACC_reg_word18_p7;
    always @(posedge clk or posedge localReset)
        XACC_reg_word18_p7 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk18_7) ? wmux18[63:56] : XACC_reg_word18_p7;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word18_p8;
    assign word18[71:64] = XACC_reg_word18_p8;
    always @(posedge clk or posedge localReset)
        XACC_reg_word18_p8 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk18_8) ? wmux18[71:64] : XACC_reg_word18_p8;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word18_p9;
    assign word18[79:72] = XACC_reg_word18_p9;
    always @(posedge clk or posedge localReset)
        XACC_reg_word18_p9 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk18_9) ? wmux18[79:72] : XACC_reg_word18_p9;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word18_p10;
    assign word18[87:80] = XACC_reg_word18_p10;
    always @(posedge clk or posedge localReset)
        XACC_reg_word18_p10 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk18_10) ? wmux18[87:80] : XACC_reg_word18_p10;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word18_p11;
    assign word18[95:88] = XACC_reg_word18_p11;
    always @(posedge clk or posedge localReset)
        XACC_reg_word18_p11 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk18_11) ? wmux18[95:88] : XACC_reg_word18_p11;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word18_p12;
    assign word18[103:96] = XACC_reg_word18_p12;
    always @(posedge clk or posedge localReset)
        XACC_reg_word18_p12 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk18_12) ? wmux18[103:96] : XACC_reg_word18_p12;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word18_p13;
    assign word18[111:104] = XACC_reg_word18_p13;
    always @(posedge clk or posedge localReset)
        XACC_reg_word18_p13 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk18_13) ? wmux18[111:104] : XACC_reg_word18_p13;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word18_p14;
    assign word18[119:112] = XACC_reg_word18_p14;
    always @(posedge clk or posedge localReset)
        XACC_reg_word18_p14 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk18_14) ? wmux18[119:112] : XACC_reg_word18_p14;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word18_p15;
    assign word18[127:120] = XACC_reg_word18_p15;
    always @(posedge clk or posedge localReset)
        XACC_reg_word18_p15 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk18_15) ? wmux18[127:120] : XACC_reg_word18_p15;

    wire [15:0] wr0_word_we19_C13 = wr0_we_C13 & {16{(wr0_addr_C13 == 5'd19)}};
    wire [15:0] wr1_word_we19_C13 = wr1_we_C13 & {16{(wr1_addr_C13 == 5'd19)}};
    wire [15:0] wr2_word_we19_C15 = wr2_we_C15 & {16{(wr2_addr_C15 == 5'd19)}};
    wire [15:0] wr3_word_we19_C14 = wr3_we_C14 & {16{(wr3_addr_C14 == 5'd19)}};
    wire [15:0] word19_we = 16'b0 | wr0_word_we19_C13 | wr1_word_we19_C13 | wr2_word_we19_C15 | wr3_word_we19_C14;
    wire gclk19_0;
assign gclk19_0 = word19_we[0];
    wire gclk19_1;
assign gclk19_1 = word19_we[1];
    wire gclk19_2;
assign gclk19_2 = word19_we[2];
    wire gclk19_3;
assign gclk19_3 = word19_we[3];
    wire gclk19_4;
assign gclk19_4 = word19_we[4];
    wire gclk19_5;
assign gclk19_5 = word19_we[5];
    wire gclk19_6;
assign gclk19_6 = word19_we[6];
    wire gclk19_7;
assign gclk19_7 = word19_we[7];
    wire gclk19_8;
assign gclk19_8 = word19_we[8];
    wire gclk19_9;
assign gclk19_9 = word19_we[9];
    wire gclk19_10;
assign gclk19_10 = word19_we[10];
    wire gclk19_11;
assign gclk19_11 = word19_we[11];
    wire gclk19_12;
assign gclk19_12 = word19_we[12];
    wire gclk19_13;
assign gclk19_13 = word19_we[13];
    wire gclk19_14;
assign gclk19_14 = word19_we[14];
    wire gclk19_15;
assign gclk19_15 = word19_we[15];
    wire [127:0] wmux19;
    reg [7:0] xtmux_1363;
    always @(*) begin
        xtmux_1363 = 8'b0;
        case({wr0_word_we19_C13[0],
            wr1_word_we19_C13[0],
            wr2_word_we19_C15[0],
            wr3_word_we19_C14[0]}) 
/* synopsys full_case */
            4'b1000: xtmux_1363 = wr0_data_C13[7:0];
            4'b0100: xtmux_1363 = wr1_data_C13[7:0];
            4'b0010: xtmux_1363 = wr2_data_C15[7:0];
            4'b0001: xtmux_1363 = wr3_data_C14[7:0];
        endcase
    end
    assign wmux19[7:0] = xtmux_1363;

    reg [7:0] xtmux_1364;
    always @(*) begin
        xtmux_1364 = 8'b0;
        case({wr0_word_we19_C13[1],
            wr1_word_we19_C13[1],
            wr2_word_we19_C15[1],
            wr3_word_we19_C14[1]}) 
/* synopsys full_case */
            4'b1000: xtmux_1364 = wr0_data_C13[15:8];
            4'b0100: xtmux_1364 = wr1_data_C13[15:8];
            4'b0010: xtmux_1364 = wr2_data_C15[15:8];
            4'b0001: xtmux_1364 = wr3_data_C14[15:8];
        endcase
    end
    assign wmux19[15:8] = xtmux_1364;

    reg [7:0] xtmux_1365;
    always @(*) begin
        xtmux_1365 = 8'b0;
        case({wr0_word_we19_C13[2],
            wr1_word_we19_C13[2],
            wr2_word_we19_C15[2],
            wr3_word_we19_C14[2]}) 
/* synopsys full_case */
            4'b1000: xtmux_1365 = wr0_data_C13[23:16];
            4'b0100: xtmux_1365 = wr1_data_C13[23:16];
            4'b0010: xtmux_1365 = wr2_data_C15[23:16];
            4'b0001: xtmux_1365 = wr3_data_C14[23:16];
        endcase
    end
    assign wmux19[23:16] = xtmux_1365;

    reg [7:0] xtmux_1366;
    always @(*) begin
        xtmux_1366 = 8'b0;
        case({wr0_word_we19_C13[3],
            wr1_word_we19_C13[3],
            wr2_word_we19_C15[3],
            wr3_word_we19_C14[3]}) 
/* synopsys full_case */
            4'b1000: xtmux_1366 = wr0_data_C13[31:24];
            4'b0100: xtmux_1366 = wr1_data_C13[31:24];
            4'b0010: xtmux_1366 = wr2_data_C15[31:24];
            4'b0001: xtmux_1366 = wr3_data_C14[31:24];
        endcase
    end
    assign wmux19[31:24] = xtmux_1366;

    reg [7:0] xtmux_1367;
    always @(*) begin
        xtmux_1367 = 8'b0;
        case({wr0_word_we19_C13[4],
            wr1_word_we19_C13[4],
            wr2_word_we19_C15[4],
            wr3_word_we19_C14[4]}) 
/* synopsys full_case */
            4'b1000: xtmux_1367 = wr0_data_C13[39:32];
            4'b0100: xtmux_1367 = wr1_data_C13[39:32];
            4'b0010: xtmux_1367 = wr2_data_C15[39:32];
            4'b0001: xtmux_1367 = wr3_data_C14[39:32];
        endcase
    end
    assign wmux19[39:32] = xtmux_1367;

    reg [7:0] xtmux_1368;
    always @(*) begin
        xtmux_1368 = 8'b0;
        case({wr0_word_we19_C13[5],
            wr1_word_we19_C13[5],
            wr2_word_we19_C15[5],
            wr3_word_we19_C14[5]}) 
/* synopsys full_case */
            4'b1000: xtmux_1368 = wr0_data_C13[47:40];
            4'b0100: xtmux_1368 = wr1_data_C13[47:40];
            4'b0010: xtmux_1368 = wr2_data_C15[47:40];
            4'b0001: xtmux_1368 = wr3_data_C14[47:40];
        endcase
    end
    assign wmux19[47:40] = xtmux_1368;

    reg [7:0] xtmux_1369;
    always @(*) begin
        xtmux_1369 = 8'b0;
        case({wr0_word_we19_C13[6],
            wr1_word_we19_C13[6],
            wr2_word_we19_C15[6],
            wr3_word_we19_C14[6]}) 
/* synopsys full_case */
            4'b1000: xtmux_1369 = wr0_data_C13[55:48];
            4'b0100: xtmux_1369 = wr1_data_C13[55:48];
            4'b0010: xtmux_1369 = wr2_data_C15[55:48];
            4'b0001: xtmux_1369 = wr3_data_C14[55:48];
        endcase
    end
    assign wmux19[55:48] = xtmux_1369;

    reg [7:0] xtmux_1370;
    always @(*) begin
        xtmux_1370 = 8'b0;
        case({wr0_word_we19_C13[7],
            wr1_word_we19_C13[7],
            wr2_word_we19_C15[7],
            wr3_word_we19_C14[7]}) 
/* synopsys full_case */
            4'b1000: xtmux_1370 = wr0_data_C13[63:56];
            4'b0100: xtmux_1370 = wr1_data_C13[63:56];
            4'b0010: xtmux_1370 = wr2_data_C15[63:56];
            4'b0001: xtmux_1370 = wr3_data_C14[63:56];
        endcase
    end
    assign wmux19[63:56] = xtmux_1370;

    reg [7:0] xtmux_1371;
    always @(*) begin
        xtmux_1371 = 8'b0;
        case({wr0_word_we19_C13[8],
            wr1_word_we19_C13[8],
            wr2_word_we19_C15[8],
            wr3_word_we19_C14[8]}) 
/* synopsys full_case */
            4'b1000: xtmux_1371 = wr0_data_C13[71:64];
            4'b0100: xtmux_1371 = wr1_data_C13[71:64];
            4'b0010: xtmux_1371 = wr2_data_C15[71:64];
            4'b0001: xtmux_1371 = wr3_data_C14[71:64];
        endcase
    end
    assign wmux19[71:64] = xtmux_1371;

    reg [7:0] xtmux_1372;
    always @(*) begin
        xtmux_1372 = 8'b0;
        case({wr0_word_we19_C13[9],
            wr1_word_we19_C13[9],
            wr2_word_we19_C15[9],
            wr3_word_we19_C14[9]}) 
/* synopsys full_case */
            4'b1000: xtmux_1372 = wr0_data_C13[79:72];
            4'b0100: xtmux_1372 = wr1_data_C13[79:72];
            4'b0010: xtmux_1372 = wr2_data_C15[79:72];
            4'b0001: xtmux_1372 = wr3_data_C14[79:72];
        endcase
    end
    assign wmux19[79:72] = xtmux_1372;

    reg [7:0] xtmux_1373;
    always @(*) begin
        xtmux_1373 = 8'b0;
        case({wr0_word_we19_C13[10],
            wr1_word_we19_C13[10],
            wr2_word_we19_C15[10],
            wr3_word_we19_C14[10]}) 
/* synopsys full_case */
            4'b1000: xtmux_1373 = wr0_data_C13[87:80];
            4'b0100: xtmux_1373 = wr1_data_C13[87:80];
            4'b0010: xtmux_1373 = wr2_data_C15[87:80];
            4'b0001: xtmux_1373 = wr3_data_C14[87:80];
        endcase
    end
    assign wmux19[87:80] = xtmux_1373;

    reg [7:0] xtmux_1374;
    always @(*) begin
        xtmux_1374 = 8'b0;
        case({wr0_word_we19_C13[11],
            wr1_word_we19_C13[11],
            wr2_word_we19_C15[11],
            wr3_word_we19_C14[11]}) 
/* synopsys full_case */
            4'b1000: xtmux_1374 = wr0_data_C13[95:88];
            4'b0100: xtmux_1374 = wr1_data_C13[95:88];
            4'b0010: xtmux_1374 = wr2_data_C15[95:88];
            4'b0001: xtmux_1374 = wr3_data_C14[95:88];
        endcase
    end
    assign wmux19[95:88] = xtmux_1374;

    reg [7:0] xtmux_1375;
    always @(*) begin
        xtmux_1375 = 8'b0;
        case({wr0_word_we19_C13[12],
            wr1_word_we19_C13[12],
            wr2_word_we19_C15[12],
            wr3_word_we19_C14[12]}) 
/* synopsys full_case */
            4'b1000: xtmux_1375 = wr0_data_C13[103:96];
            4'b0100: xtmux_1375 = wr1_data_C13[103:96];
            4'b0010: xtmux_1375 = wr2_data_C15[103:96];
            4'b0001: xtmux_1375 = wr3_data_C14[103:96];
        endcase
    end
    assign wmux19[103:96] = xtmux_1375;

    reg [7:0] xtmux_1376;
    always @(*) begin
        xtmux_1376 = 8'b0;
        case({wr0_word_we19_C13[13],
            wr1_word_we19_C13[13],
            wr2_word_we19_C15[13],
            wr3_word_we19_C14[13]}) 
/* synopsys full_case */
            4'b1000: xtmux_1376 = wr0_data_C13[111:104];
            4'b0100: xtmux_1376 = wr1_data_C13[111:104];
            4'b0010: xtmux_1376 = wr2_data_C15[111:104];
            4'b0001: xtmux_1376 = wr3_data_C14[111:104];
        endcase
    end
    assign wmux19[111:104] = xtmux_1376;

    reg [7:0] xtmux_1377;
    always @(*) begin
        xtmux_1377 = 8'b0;
        case({wr0_word_we19_C13[14],
            wr1_word_we19_C13[14],
            wr2_word_we19_C15[14],
            wr3_word_we19_C14[14]}) 
/* synopsys full_case */
            4'b1000: xtmux_1377 = wr0_data_C13[119:112];
            4'b0100: xtmux_1377 = wr1_data_C13[119:112];
            4'b0010: xtmux_1377 = wr2_data_C15[119:112];
            4'b0001: xtmux_1377 = wr3_data_C14[119:112];
        endcase
    end
    assign wmux19[119:112] = xtmux_1377;

    reg [7:0] xtmux_1378;
    always @(*) begin
        xtmux_1378 = 8'b0;
        case({wr0_word_we19_C13[15],
            wr1_word_we19_C13[15],
            wr2_word_we19_C15[15],
            wr3_word_we19_C14[15]}) 
/* synopsys full_case */
            4'b1000: xtmux_1378 = wr0_data_C13[127:120];
            4'b0100: xtmux_1378 = wr1_data_C13[127:120];
            4'b0010: xtmux_1378 = wr2_data_C15[127:120];
            4'b0001: xtmux_1378 = wr3_data_C14[127:120];
        endcase
    end
    assign wmux19[127:120] = xtmux_1378;

    wire [127:0] word19;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word19_p0;
    assign word19[7:0] = XACC_reg_word19_p0;
    always @(posedge clk or posedge localReset)
        XACC_reg_word19_p0 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk19_0) ? wmux19[7:0] : XACC_reg_word19_p0;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word19_p1;
    assign word19[15:8] = XACC_reg_word19_p1;
    always @(posedge clk or posedge localReset)
        XACC_reg_word19_p1 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk19_1) ? wmux19[15:8] : XACC_reg_word19_p1;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word19_p2;
    assign word19[23:16] = XACC_reg_word19_p2;
    always @(posedge clk or posedge localReset)
        XACC_reg_word19_p2 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk19_2) ? wmux19[23:16] : XACC_reg_word19_p2;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word19_p3;
    assign word19[31:24] = XACC_reg_word19_p3;
    always @(posedge clk or posedge localReset)
        XACC_reg_word19_p3 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk19_3) ? wmux19[31:24] : XACC_reg_word19_p3;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word19_p4;
    assign word19[39:32] = XACC_reg_word19_p4;
    always @(posedge clk or posedge localReset)
        XACC_reg_word19_p4 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk19_4) ? wmux19[39:32] : XACC_reg_word19_p4;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word19_p5;
    assign word19[47:40] = XACC_reg_word19_p5;
    always @(posedge clk or posedge localReset)
        XACC_reg_word19_p5 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk19_5) ? wmux19[47:40] : XACC_reg_word19_p5;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word19_p6;
    assign word19[55:48] = XACC_reg_word19_p6;
    always @(posedge clk or posedge localReset)
        XACC_reg_word19_p6 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk19_6) ? wmux19[55:48] : XACC_reg_word19_p6;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word19_p7;
    assign word19[63:56] = XACC_reg_word19_p7;
    always @(posedge clk or posedge localReset)
        XACC_reg_word19_p7 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk19_7) ? wmux19[63:56] : XACC_reg_word19_p7;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word19_p8;
    assign word19[71:64] = XACC_reg_word19_p8;
    always @(posedge clk or posedge localReset)
        XACC_reg_word19_p8 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk19_8) ? wmux19[71:64] : XACC_reg_word19_p8;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word19_p9;
    assign word19[79:72] = XACC_reg_word19_p9;
    always @(posedge clk or posedge localReset)
        XACC_reg_word19_p9 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk19_9) ? wmux19[79:72] : XACC_reg_word19_p9;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word19_p10;
    assign word19[87:80] = XACC_reg_word19_p10;
    always @(posedge clk or posedge localReset)
        XACC_reg_word19_p10 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk19_10) ? wmux19[87:80] : XACC_reg_word19_p10;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word19_p11;
    assign word19[95:88] = XACC_reg_word19_p11;
    always @(posedge clk or posedge localReset)
        XACC_reg_word19_p11 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk19_11) ? wmux19[95:88] : XACC_reg_word19_p11;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word19_p12;
    assign word19[103:96] = XACC_reg_word19_p12;
    always @(posedge clk or posedge localReset)
        XACC_reg_word19_p12 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk19_12) ? wmux19[103:96] : XACC_reg_word19_p12;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word19_p13;
    assign word19[111:104] = XACC_reg_word19_p13;
    always @(posedge clk or posedge localReset)
        XACC_reg_word19_p13 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk19_13) ? wmux19[111:104] : XACC_reg_word19_p13;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word19_p14;
    assign word19[119:112] = XACC_reg_word19_p14;
    always @(posedge clk or posedge localReset)
        XACC_reg_word19_p14 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk19_14) ? wmux19[119:112] : XACC_reg_word19_p14;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word19_p15;
    assign word19[127:120] = XACC_reg_word19_p15;
    always @(posedge clk or posedge localReset)
        XACC_reg_word19_p15 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk19_15) ? wmux19[127:120] : XACC_reg_word19_p15;

    wire [15:0] wr0_word_we20_C13 = wr0_we_C13 & {16{(wr0_addr_C13 == 5'd20)}};
    wire [15:0] wr1_word_we20_C13 = wr1_we_C13 & {16{(wr1_addr_C13 == 5'd20)}};
    wire [15:0] wr2_word_we20_C15 = wr2_we_C15 & {16{(wr2_addr_C15 == 5'd20)}};
    wire [15:0] wr3_word_we20_C14 = wr3_we_C14 & {16{(wr3_addr_C14 == 5'd20)}};
    wire [15:0] word20_we = 16'b0 | wr0_word_we20_C13 | wr1_word_we20_C13 | wr2_word_we20_C15 | wr3_word_we20_C14;
    wire gclk20_0;
assign gclk20_0 = word20_we[0];
    wire gclk20_1;
assign gclk20_1 = word20_we[1];
    wire gclk20_2;
assign gclk20_2 = word20_we[2];
    wire gclk20_3;
assign gclk20_3 = word20_we[3];
    wire gclk20_4;
assign gclk20_4 = word20_we[4];
    wire gclk20_5;
assign gclk20_5 = word20_we[5];
    wire gclk20_6;
assign gclk20_6 = word20_we[6];
    wire gclk20_7;
assign gclk20_7 = word20_we[7];
    wire gclk20_8;
assign gclk20_8 = word20_we[8];
    wire gclk20_9;
assign gclk20_9 = word20_we[9];
    wire gclk20_10;
assign gclk20_10 = word20_we[10];
    wire gclk20_11;
assign gclk20_11 = word20_we[11];
    wire gclk20_12;
assign gclk20_12 = word20_we[12];
    wire gclk20_13;
assign gclk20_13 = word20_we[13];
    wire gclk20_14;
assign gclk20_14 = word20_we[14];
    wire gclk20_15;
assign gclk20_15 = word20_we[15];
    wire [127:0] wmux20;
    reg [7:0] xtmux_1379;
    always @(*) begin
        xtmux_1379 = 8'b0;
        case({wr0_word_we20_C13[0],
            wr1_word_we20_C13[0],
            wr2_word_we20_C15[0],
            wr3_word_we20_C14[0]}) 
/* synopsys full_case */
            4'b1000: xtmux_1379 = wr0_data_C13[7:0];
            4'b0100: xtmux_1379 = wr1_data_C13[7:0];
            4'b0010: xtmux_1379 = wr2_data_C15[7:0];
            4'b0001: xtmux_1379 = wr3_data_C14[7:0];
        endcase
    end
    assign wmux20[7:0] = xtmux_1379;

    reg [7:0] xtmux_1380;
    always @(*) begin
        xtmux_1380 = 8'b0;
        case({wr0_word_we20_C13[1],
            wr1_word_we20_C13[1],
            wr2_word_we20_C15[1],
            wr3_word_we20_C14[1]}) 
/* synopsys full_case */
            4'b1000: xtmux_1380 = wr0_data_C13[15:8];
            4'b0100: xtmux_1380 = wr1_data_C13[15:8];
            4'b0010: xtmux_1380 = wr2_data_C15[15:8];
            4'b0001: xtmux_1380 = wr3_data_C14[15:8];
        endcase
    end
    assign wmux20[15:8] = xtmux_1380;

    reg [7:0] xtmux_1381;
    always @(*) begin
        xtmux_1381 = 8'b0;
        case({wr0_word_we20_C13[2],
            wr1_word_we20_C13[2],
            wr2_word_we20_C15[2],
            wr3_word_we20_C14[2]}) 
/* synopsys full_case */
            4'b1000: xtmux_1381 = wr0_data_C13[23:16];
            4'b0100: xtmux_1381 = wr1_data_C13[23:16];
            4'b0010: xtmux_1381 = wr2_data_C15[23:16];
            4'b0001: xtmux_1381 = wr3_data_C14[23:16];
        endcase
    end
    assign wmux20[23:16] = xtmux_1381;

    reg [7:0] xtmux_1382;
    always @(*) begin
        xtmux_1382 = 8'b0;
        case({wr0_word_we20_C13[3],
            wr1_word_we20_C13[3],
            wr2_word_we20_C15[3],
            wr3_word_we20_C14[3]}) 
/* synopsys full_case */
            4'b1000: xtmux_1382 = wr0_data_C13[31:24];
            4'b0100: xtmux_1382 = wr1_data_C13[31:24];
            4'b0010: xtmux_1382 = wr2_data_C15[31:24];
            4'b0001: xtmux_1382 = wr3_data_C14[31:24];
        endcase
    end
    assign wmux20[31:24] = xtmux_1382;

    reg [7:0] xtmux_1383;
    always @(*) begin
        xtmux_1383 = 8'b0;
        case({wr0_word_we20_C13[4],
            wr1_word_we20_C13[4],
            wr2_word_we20_C15[4],
            wr3_word_we20_C14[4]}) 
/* synopsys full_case */
            4'b1000: xtmux_1383 = wr0_data_C13[39:32];
            4'b0100: xtmux_1383 = wr1_data_C13[39:32];
            4'b0010: xtmux_1383 = wr2_data_C15[39:32];
            4'b0001: xtmux_1383 = wr3_data_C14[39:32];
        endcase
    end
    assign wmux20[39:32] = xtmux_1383;

    reg [7:0] xtmux_1384;
    always @(*) begin
        xtmux_1384 = 8'b0;
        case({wr0_word_we20_C13[5],
            wr1_word_we20_C13[5],
            wr2_word_we20_C15[5],
            wr3_word_we20_C14[5]}) 
/* synopsys full_case */
            4'b1000: xtmux_1384 = wr0_data_C13[47:40];
            4'b0100: xtmux_1384 = wr1_data_C13[47:40];
            4'b0010: xtmux_1384 = wr2_data_C15[47:40];
            4'b0001: xtmux_1384 = wr3_data_C14[47:40];
        endcase
    end
    assign wmux20[47:40] = xtmux_1384;

    reg [7:0] xtmux_1385;
    always @(*) begin
        xtmux_1385 = 8'b0;
        case({wr0_word_we20_C13[6],
            wr1_word_we20_C13[6],
            wr2_word_we20_C15[6],
            wr3_word_we20_C14[6]}) 
/* synopsys full_case */
            4'b1000: xtmux_1385 = wr0_data_C13[55:48];
            4'b0100: xtmux_1385 = wr1_data_C13[55:48];
            4'b0010: xtmux_1385 = wr2_data_C15[55:48];
            4'b0001: xtmux_1385 = wr3_data_C14[55:48];
        endcase
    end
    assign wmux20[55:48] = xtmux_1385;

    reg [7:0] xtmux_1386;
    always @(*) begin
        xtmux_1386 = 8'b0;
        case({wr0_word_we20_C13[7],
            wr1_word_we20_C13[7],
            wr2_word_we20_C15[7],
            wr3_word_we20_C14[7]}) 
/* synopsys full_case */
            4'b1000: xtmux_1386 = wr0_data_C13[63:56];
            4'b0100: xtmux_1386 = wr1_data_C13[63:56];
            4'b0010: xtmux_1386 = wr2_data_C15[63:56];
            4'b0001: xtmux_1386 = wr3_data_C14[63:56];
        endcase
    end
    assign wmux20[63:56] = xtmux_1386;

    reg [7:0] xtmux_1387;
    always @(*) begin
        xtmux_1387 = 8'b0;
        case({wr0_word_we20_C13[8],
            wr1_word_we20_C13[8],
            wr2_word_we20_C15[8],
            wr3_word_we20_C14[8]}) 
/* synopsys full_case */
            4'b1000: xtmux_1387 = wr0_data_C13[71:64];
            4'b0100: xtmux_1387 = wr1_data_C13[71:64];
            4'b0010: xtmux_1387 = wr2_data_C15[71:64];
            4'b0001: xtmux_1387 = wr3_data_C14[71:64];
        endcase
    end
    assign wmux20[71:64] = xtmux_1387;

    reg [7:0] xtmux_1388;
    always @(*) begin
        xtmux_1388 = 8'b0;
        case({wr0_word_we20_C13[9],
            wr1_word_we20_C13[9],
            wr2_word_we20_C15[9],
            wr3_word_we20_C14[9]}) 
/* synopsys full_case */
            4'b1000: xtmux_1388 = wr0_data_C13[79:72];
            4'b0100: xtmux_1388 = wr1_data_C13[79:72];
            4'b0010: xtmux_1388 = wr2_data_C15[79:72];
            4'b0001: xtmux_1388 = wr3_data_C14[79:72];
        endcase
    end
    assign wmux20[79:72] = xtmux_1388;

    reg [7:0] xtmux_1389;
    always @(*) begin
        xtmux_1389 = 8'b0;
        case({wr0_word_we20_C13[10],
            wr1_word_we20_C13[10],
            wr2_word_we20_C15[10],
            wr3_word_we20_C14[10]}) 
/* synopsys full_case */
            4'b1000: xtmux_1389 = wr0_data_C13[87:80];
            4'b0100: xtmux_1389 = wr1_data_C13[87:80];
            4'b0010: xtmux_1389 = wr2_data_C15[87:80];
            4'b0001: xtmux_1389 = wr3_data_C14[87:80];
        endcase
    end
    assign wmux20[87:80] = xtmux_1389;

    reg [7:0] xtmux_1390;
    always @(*) begin
        xtmux_1390 = 8'b0;
        case({wr0_word_we20_C13[11],
            wr1_word_we20_C13[11],
            wr2_word_we20_C15[11],
            wr3_word_we20_C14[11]}) 
/* synopsys full_case */
            4'b1000: xtmux_1390 = wr0_data_C13[95:88];
            4'b0100: xtmux_1390 = wr1_data_C13[95:88];
            4'b0010: xtmux_1390 = wr2_data_C15[95:88];
            4'b0001: xtmux_1390 = wr3_data_C14[95:88];
        endcase
    end
    assign wmux20[95:88] = xtmux_1390;

    reg [7:0] xtmux_1391;
    always @(*) begin
        xtmux_1391 = 8'b0;
        case({wr0_word_we20_C13[12],
            wr1_word_we20_C13[12],
            wr2_word_we20_C15[12],
            wr3_word_we20_C14[12]}) 
/* synopsys full_case */
            4'b1000: xtmux_1391 = wr0_data_C13[103:96];
            4'b0100: xtmux_1391 = wr1_data_C13[103:96];
            4'b0010: xtmux_1391 = wr2_data_C15[103:96];
            4'b0001: xtmux_1391 = wr3_data_C14[103:96];
        endcase
    end
    assign wmux20[103:96] = xtmux_1391;

    reg [7:0] xtmux_1392;
    always @(*) begin
        xtmux_1392 = 8'b0;
        case({wr0_word_we20_C13[13],
            wr1_word_we20_C13[13],
            wr2_word_we20_C15[13],
            wr3_word_we20_C14[13]}) 
/* synopsys full_case */
            4'b1000: xtmux_1392 = wr0_data_C13[111:104];
            4'b0100: xtmux_1392 = wr1_data_C13[111:104];
            4'b0010: xtmux_1392 = wr2_data_C15[111:104];
            4'b0001: xtmux_1392 = wr3_data_C14[111:104];
        endcase
    end
    assign wmux20[111:104] = xtmux_1392;

    reg [7:0] xtmux_1393;
    always @(*) begin
        xtmux_1393 = 8'b0;
        case({wr0_word_we20_C13[14],
            wr1_word_we20_C13[14],
            wr2_word_we20_C15[14],
            wr3_word_we20_C14[14]}) 
/* synopsys full_case */
            4'b1000: xtmux_1393 = wr0_data_C13[119:112];
            4'b0100: xtmux_1393 = wr1_data_C13[119:112];
            4'b0010: xtmux_1393 = wr2_data_C15[119:112];
            4'b0001: xtmux_1393 = wr3_data_C14[119:112];
        endcase
    end
    assign wmux20[119:112] = xtmux_1393;

    reg [7:0] xtmux_1394;
    always @(*) begin
        xtmux_1394 = 8'b0;
        case({wr0_word_we20_C13[15],
            wr1_word_we20_C13[15],
            wr2_word_we20_C15[15],
            wr3_word_we20_C14[15]}) 
/* synopsys full_case */
            4'b1000: xtmux_1394 = wr0_data_C13[127:120];
            4'b0100: xtmux_1394 = wr1_data_C13[127:120];
            4'b0010: xtmux_1394 = wr2_data_C15[127:120];
            4'b0001: xtmux_1394 = wr3_data_C14[127:120];
        endcase
    end
    assign wmux20[127:120] = xtmux_1394;

    wire [127:0] word20;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word20_p0;
    assign word20[7:0] = XACC_reg_word20_p0;
    always @(posedge clk or posedge localReset)
        XACC_reg_word20_p0 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk20_0) ? wmux20[7:0] : XACC_reg_word20_p0;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word20_p1;
    assign word20[15:8] = XACC_reg_word20_p1;
    always @(posedge clk or posedge localReset)
        XACC_reg_word20_p1 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk20_1) ? wmux20[15:8] : XACC_reg_word20_p1;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word20_p2;
    assign word20[23:16] = XACC_reg_word20_p2;
    always @(posedge clk or posedge localReset)
        XACC_reg_word20_p2 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk20_2) ? wmux20[23:16] : XACC_reg_word20_p2;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word20_p3;
    assign word20[31:24] = XACC_reg_word20_p3;
    always @(posedge clk or posedge localReset)
        XACC_reg_word20_p3 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk20_3) ? wmux20[31:24] : XACC_reg_word20_p3;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word20_p4;
    assign word20[39:32] = XACC_reg_word20_p4;
    always @(posedge clk or posedge localReset)
        XACC_reg_word20_p4 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk20_4) ? wmux20[39:32] : XACC_reg_word20_p4;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word20_p5;
    assign word20[47:40] = XACC_reg_word20_p5;
    always @(posedge clk or posedge localReset)
        XACC_reg_word20_p5 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk20_5) ? wmux20[47:40] : XACC_reg_word20_p5;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word20_p6;
    assign word20[55:48] = XACC_reg_word20_p6;
    always @(posedge clk or posedge localReset)
        XACC_reg_word20_p6 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk20_6) ? wmux20[55:48] : XACC_reg_word20_p6;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word20_p7;
    assign word20[63:56] = XACC_reg_word20_p7;
    always @(posedge clk or posedge localReset)
        XACC_reg_word20_p7 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk20_7) ? wmux20[63:56] : XACC_reg_word20_p7;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word20_p8;
    assign word20[71:64] = XACC_reg_word20_p8;
    always @(posedge clk or posedge localReset)
        XACC_reg_word20_p8 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk20_8) ? wmux20[71:64] : XACC_reg_word20_p8;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word20_p9;
    assign word20[79:72] = XACC_reg_word20_p9;
    always @(posedge clk or posedge localReset)
        XACC_reg_word20_p9 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk20_9) ? wmux20[79:72] : XACC_reg_word20_p9;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word20_p10;
    assign word20[87:80] = XACC_reg_word20_p10;
    always @(posedge clk or posedge localReset)
        XACC_reg_word20_p10 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk20_10) ? wmux20[87:80] : XACC_reg_word20_p10;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word20_p11;
    assign word20[95:88] = XACC_reg_word20_p11;
    always @(posedge clk or posedge localReset)
        XACC_reg_word20_p11 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk20_11) ? wmux20[95:88] : XACC_reg_word20_p11;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word20_p12;
    assign word20[103:96] = XACC_reg_word20_p12;
    always @(posedge clk or posedge localReset)
        XACC_reg_word20_p12 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk20_12) ? wmux20[103:96] : XACC_reg_word20_p12;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word20_p13;
    assign word20[111:104] = XACC_reg_word20_p13;
    always @(posedge clk or posedge localReset)
        XACC_reg_word20_p13 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk20_13) ? wmux20[111:104] : XACC_reg_word20_p13;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word20_p14;
    assign word20[119:112] = XACC_reg_word20_p14;
    always @(posedge clk or posedge localReset)
        XACC_reg_word20_p14 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk20_14) ? wmux20[119:112] : XACC_reg_word20_p14;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word20_p15;
    assign word20[127:120] = XACC_reg_word20_p15;
    always @(posedge clk or posedge localReset)
        XACC_reg_word20_p15 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk20_15) ? wmux20[127:120] : XACC_reg_word20_p15;

    wire [15:0] wr0_word_we21_C13 = wr0_we_C13 & {16{(wr0_addr_C13 == 5'd21)}};
    wire [15:0] wr1_word_we21_C13 = wr1_we_C13 & {16{(wr1_addr_C13 == 5'd21)}};
    wire [15:0] wr2_word_we21_C15 = wr2_we_C15 & {16{(wr2_addr_C15 == 5'd21)}};
    wire [15:0] wr3_word_we21_C14 = wr3_we_C14 & {16{(wr3_addr_C14 == 5'd21)}};
    wire [15:0] word21_we = 16'b0 | wr0_word_we21_C13 | wr1_word_we21_C13 | wr2_word_we21_C15 | wr3_word_we21_C14;
    wire gclk21_0;
assign gclk21_0 = word21_we[0];
    wire gclk21_1;
assign gclk21_1 = word21_we[1];
    wire gclk21_2;
assign gclk21_2 = word21_we[2];
    wire gclk21_3;
assign gclk21_3 = word21_we[3];
    wire gclk21_4;
assign gclk21_4 = word21_we[4];
    wire gclk21_5;
assign gclk21_5 = word21_we[5];
    wire gclk21_6;
assign gclk21_6 = word21_we[6];
    wire gclk21_7;
assign gclk21_7 = word21_we[7];
    wire gclk21_8;
assign gclk21_8 = word21_we[8];
    wire gclk21_9;
assign gclk21_9 = word21_we[9];
    wire gclk21_10;
assign gclk21_10 = word21_we[10];
    wire gclk21_11;
assign gclk21_11 = word21_we[11];
    wire gclk21_12;
assign gclk21_12 = word21_we[12];
    wire gclk21_13;
assign gclk21_13 = word21_we[13];
    wire gclk21_14;
assign gclk21_14 = word21_we[14];
    wire gclk21_15;
assign gclk21_15 = word21_we[15];
    wire [127:0] wmux21;
    reg [7:0] xtmux_1395;
    always @(*) begin
        xtmux_1395 = 8'b0;
        case({wr0_word_we21_C13[0],
            wr1_word_we21_C13[0],
            wr2_word_we21_C15[0],
            wr3_word_we21_C14[0]}) 
/* synopsys full_case */
            4'b1000: xtmux_1395 = wr0_data_C13[7:0];
            4'b0100: xtmux_1395 = wr1_data_C13[7:0];
            4'b0010: xtmux_1395 = wr2_data_C15[7:0];
            4'b0001: xtmux_1395 = wr3_data_C14[7:0];
        endcase
    end
    assign wmux21[7:0] = xtmux_1395;

    reg [7:0] xtmux_1396;
    always @(*) begin
        xtmux_1396 = 8'b0;
        case({wr0_word_we21_C13[1],
            wr1_word_we21_C13[1],
            wr2_word_we21_C15[1],
            wr3_word_we21_C14[1]}) 
/* synopsys full_case */
            4'b1000: xtmux_1396 = wr0_data_C13[15:8];
            4'b0100: xtmux_1396 = wr1_data_C13[15:8];
            4'b0010: xtmux_1396 = wr2_data_C15[15:8];
            4'b0001: xtmux_1396 = wr3_data_C14[15:8];
        endcase
    end
    assign wmux21[15:8] = xtmux_1396;

    reg [7:0] xtmux_1397;
    always @(*) begin
        xtmux_1397 = 8'b0;
        case({wr0_word_we21_C13[2],
            wr1_word_we21_C13[2],
            wr2_word_we21_C15[2],
            wr3_word_we21_C14[2]}) 
/* synopsys full_case */
            4'b1000: xtmux_1397 = wr0_data_C13[23:16];
            4'b0100: xtmux_1397 = wr1_data_C13[23:16];
            4'b0010: xtmux_1397 = wr2_data_C15[23:16];
            4'b0001: xtmux_1397 = wr3_data_C14[23:16];
        endcase
    end
    assign wmux21[23:16] = xtmux_1397;

    reg [7:0] xtmux_1398;
    always @(*) begin
        xtmux_1398 = 8'b0;
        case({wr0_word_we21_C13[3],
            wr1_word_we21_C13[3],
            wr2_word_we21_C15[3],
            wr3_word_we21_C14[3]}) 
/* synopsys full_case */
            4'b1000: xtmux_1398 = wr0_data_C13[31:24];
            4'b0100: xtmux_1398 = wr1_data_C13[31:24];
            4'b0010: xtmux_1398 = wr2_data_C15[31:24];
            4'b0001: xtmux_1398 = wr3_data_C14[31:24];
        endcase
    end
    assign wmux21[31:24] = xtmux_1398;

    reg [7:0] xtmux_1399;
    always @(*) begin
        xtmux_1399 = 8'b0;
        case({wr0_word_we21_C13[4],
            wr1_word_we21_C13[4],
            wr2_word_we21_C15[4],
            wr3_word_we21_C14[4]}) 
/* synopsys full_case */
            4'b1000: xtmux_1399 = wr0_data_C13[39:32];
            4'b0100: xtmux_1399 = wr1_data_C13[39:32];
            4'b0010: xtmux_1399 = wr2_data_C15[39:32];
            4'b0001: xtmux_1399 = wr3_data_C14[39:32];
        endcase
    end
    assign wmux21[39:32] = xtmux_1399;

    reg [7:0] xtmux_1400;
    always @(*) begin
        xtmux_1400 = 8'b0;
        case({wr0_word_we21_C13[5],
            wr1_word_we21_C13[5],
            wr2_word_we21_C15[5],
            wr3_word_we21_C14[5]}) 
/* synopsys full_case */
            4'b1000: xtmux_1400 = wr0_data_C13[47:40];
            4'b0100: xtmux_1400 = wr1_data_C13[47:40];
            4'b0010: xtmux_1400 = wr2_data_C15[47:40];
            4'b0001: xtmux_1400 = wr3_data_C14[47:40];
        endcase
    end
    assign wmux21[47:40] = xtmux_1400;

    reg [7:0] xtmux_1401;
    always @(*) begin
        xtmux_1401 = 8'b0;
        case({wr0_word_we21_C13[6],
            wr1_word_we21_C13[6],
            wr2_word_we21_C15[6],
            wr3_word_we21_C14[6]}) 
/* synopsys full_case */
            4'b1000: xtmux_1401 = wr0_data_C13[55:48];
            4'b0100: xtmux_1401 = wr1_data_C13[55:48];
            4'b0010: xtmux_1401 = wr2_data_C15[55:48];
            4'b0001: xtmux_1401 = wr3_data_C14[55:48];
        endcase
    end
    assign wmux21[55:48] = xtmux_1401;

    reg [7:0] xtmux_1402;
    always @(*) begin
        xtmux_1402 = 8'b0;
        case({wr0_word_we21_C13[7],
            wr1_word_we21_C13[7],
            wr2_word_we21_C15[7],
            wr3_word_we21_C14[7]}) 
/* synopsys full_case */
            4'b1000: xtmux_1402 = wr0_data_C13[63:56];
            4'b0100: xtmux_1402 = wr1_data_C13[63:56];
            4'b0010: xtmux_1402 = wr2_data_C15[63:56];
            4'b0001: xtmux_1402 = wr3_data_C14[63:56];
        endcase
    end
    assign wmux21[63:56] = xtmux_1402;

    reg [7:0] xtmux_1403;
    always @(*) begin
        xtmux_1403 = 8'b0;
        case({wr0_word_we21_C13[8],
            wr1_word_we21_C13[8],
            wr2_word_we21_C15[8],
            wr3_word_we21_C14[8]}) 
/* synopsys full_case */
            4'b1000: xtmux_1403 = wr0_data_C13[71:64];
            4'b0100: xtmux_1403 = wr1_data_C13[71:64];
            4'b0010: xtmux_1403 = wr2_data_C15[71:64];
            4'b0001: xtmux_1403 = wr3_data_C14[71:64];
        endcase
    end
    assign wmux21[71:64] = xtmux_1403;

    reg [7:0] xtmux_1404;
    always @(*) begin
        xtmux_1404 = 8'b0;
        case({wr0_word_we21_C13[9],
            wr1_word_we21_C13[9],
            wr2_word_we21_C15[9],
            wr3_word_we21_C14[9]}) 
/* synopsys full_case */
            4'b1000: xtmux_1404 = wr0_data_C13[79:72];
            4'b0100: xtmux_1404 = wr1_data_C13[79:72];
            4'b0010: xtmux_1404 = wr2_data_C15[79:72];
            4'b0001: xtmux_1404 = wr3_data_C14[79:72];
        endcase
    end
    assign wmux21[79:72] = xtmux_1404;

    reg [7:0] xtmux_1405;
    always @(*) begin
        xtmux_1405 = 8'b0;
        case({wr0_word_we21_C13[10],
            wr1_word_we21_C13[10],
            wr2_word_we21_C15[10],
            wr3_word_we21_C14[10]}) 
/* synopsys full_case */
            4'b1000: xtmux_1405 = wr0_data_C13[87:80];
            4'b0100: xtmux_1405 = wr1_data_C13[87:80];
            4'b0010: xtmux_1405 = wr2_data_C15[87:80];
            4'b0001: xtmux_1405 = wr3_data_C14[87:80];
        endcase
    end
    assign wmux21[87:80] = xtmux_1405;

    reg [7:0] xtmux_1406;
    always @(*) begin
        xtmux_1406 = 8'b0;
        case({wr0_word_we21_C13[11],
            wr1_word_we21_C13[11],
            wr2_word_we21_C15[11],
            wr3_word_we21_C14[11]}) 
/* synopsys full_case */
            4'b1000: xtmux_1406 = wr0_data_C13[95:88];
            4'b0100: xtmux_1406 = wr1_data_C13[95:88];
            4'b0010: xtmux_1406 = wr2_data_C15[95:88];
            4'b0001: xtmux_1406 = wr3_data_C14[95:88];
        endcase
    end
    assign wmux21[95:88] = xtmux_1406;

    reg [7:0] xtmux_1407;
    always @(*) begin
        xtmux_1407 = 8'b0;
        case({wr0_word_we21_C13[12],
            wr1_word_we21_C13[12],
            wr2_word_we21_C15[12],
            wr3_word_we21_C14[12]}) 
/* synopsys full_case */
            4'b1000: xtmux_1407 = wr0_data_C13[103:96];
            4'b0100: xtmux_1407 = wr1_data_C13[103:96];
            4'b0010: xtmux_1407 = wr2_data_C15[103:96];
            4'b0001: xtmux_1407 = wr3_data_C14[103:96];
        endcase
    end
    assign wmux21[103:96] = xtmux_1407;

    reg [7:0] xtmux_1408;
    always @(*) begin
        xtmux_1408 = 8'b0;
        case({wr0_word_we21_C13[13],
            wr1_word_we21_C13[13],
            wr2_word_we21_C15[13],
            wr3_word_we21_C14[13]}) 
/* synopsys full_case */
            4'b1000: xtmux_1408 = wr0_data_C13[111:104];
            4'b0100: xtmux_1408 = wr1_data_C13[111:104];
            4'b0010: xtmux_1408 = wr2_data_C15[111:104];
            4'b0001: xtmux_1408 = wr3_data_C14[111:104];
        endcase
    end
    assign wmux21[111:104] = xtmux_1408;

    reg [7:0] xtmux_1409;
    always @(*) begin
        xtmux_1409 = 8'b0;
        case({wr0_word_we21_C13[14],
            wr1_word_we21_C13[14],
            wr2_word_we21_C15[14],
            wr3_word_we21_C14[14]}) 
/* synopsys full_case */
            4'b1000: xtmux_1409 = wr0_data_C13[119:112];
            4'b0100: xtmux_1409 = wr1_data_C13[119:112];
            4'b0010: xtmux_1409 = wr2_data_C15[119:112];
            4'b0001: xtmux_1409 = wr3_data_C14[119:112];
        endcase
    end
    assign wmux21[119:112] = xtmux_1409;

    reg [7:0] xtmux_1410;
    always @(*) begin
        xtmux_1410 = 8'b0;
        case({wr0_word_we21_C13[15],
            wr1_word_we21_C13[15],
            wr2_word_we21_C15[15],
            wr3_word_we21_C14[15]}) 
/* synopsys full_case */
            4'b1000: xtmux_1410 = wr0_data_C13[127:120];
            4'b0100: xtmux_1410 = wr1_data_C13[127:120];
            4'b0010: xtmux_1410 = wr2_data_C15[127:120];
            4'b0001: xtmux_1410 = wr3_data_C14[127:120];
        endcase
    end
    assign wmux21[127:120] = xtmux_1410;

    wire [127:0] word21;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word21_p0;
    assign word21[7:0] = XACC_reg_word21_p0;
    always @(posedge clk or posedge localReset)
        XACC_reg_word21_p0 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk21_0) ? wmux21[7:0] : XACC_reg_word21_p0;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word21_p1;
    assign word21[15:8] = XACC_reg_word21_p1;
    always @(posedge clk or posedge localReset)
        XACC_reg_word21_p1 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk21_1) ? wmux21[15:8] : XACC_reg_word21_p1;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word21_p2;
    assign word21[23:16] = XACC_reg_word21_p2;
    always @(posedge clk or posedge localReset)
        XACC_reg_word21_p2 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk21_2) ? wmux21[23:16] : XACC_reg_word21_p2;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word21_p3;
    assign word21[31:24] = XACC_reg_word21_p3;
    always @(posedge clk or posedge localReset)
        XACC_reg_word21_p3 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk21_3) ? wmux21[31:24] : XACC_reg_word21_p3;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word21_p4;
    assign word21[39:32] = XACC_reg_word21_p4;
    always @(posedge clk or posedge localReset)
        XACC_reg_word21_p4 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk21_4) ? wmux21[39:32] : XACC_reg_word21_p4;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word21_p5;
    assign word21[47:40] = XACC_reg_word21_p5;
    always @(posedge clk or posedge localReset)
        XACC_reg_word21_p5 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk21_5) ? wmux21[47:40] : XACC_reg_word21_p5;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word21_p6;
    assign word21[55:48] = XACC_reg_word21_p6;
    always @(posedge clk or posedge localReset)
        XACC_reg_word21_p6 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk21_6) ? wmux21[55:48] : XACC_reg_word21_p6;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word21_p7;
    assign word21[63:56] = XACC_reg_word21_p7;
    always @(posedge clk or posedge localReset)
        XACC_reg_word21_p7 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk21_7) ? wmux21[63:56] : XACC_reg_word21_p7;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word21_p8;
    assign word21[71:64] = XACC_reg_word21_p8;
    always @(posedge clk or posedge localReset)
        XACC_reg_word21_p8 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk21_8) ? wmux21[71:64] : XACC_reg_word21_p8;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word21_p9;
    assign word21[79:72] = XACC_reg_word21_p9;
    always @(posedge clk or posedge localReset)
        XACC_reg_word21_p9 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk21_9) ? wmux21[79:72] : XACC_reg_word21_p9;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word21_p10;
    assign word21[87:80] = XACC_reg_word21_p10;
    always @(posedge clk or posedge localReset)
        XACC_reg_word21_p10 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk21_10) ? wmux21[87:80] : XACC_reg_word21_p10;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word21_p11;
    assign word21[95:88] = XACC_reg_word21_p11;
    always @(posedge clk or posedge localReset)
        XACC_reg_word21_p11 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk21_11) ? wmux21[95:88] : XACC_reg_word21_p11;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word21_p12;
    assign word21[103:96] = XACC_reg_word21_p12;
    always @(posedge clk or posedge localReset)
        XACC_reg_word21_p12 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk21_12) ? wmux21[103:96] : XACC_reg_word21_p12;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word21_p13;
    assign word21[111:104] = XACC_reg_word21_p13;
    always @(posedge clk or posedge localReset)
        XACC_reg_word21_p13 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk21_13) ? wmux21[111:104] : XACC_reg_word21_p13;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word21_p14;
    assign word21[119:112] = XACC_reg_word21_p14;
    always @(posedge clk or posedge localReset)
        XACC_reg_word21_p14 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk21_14) ? wmux21[119:112] : XACC_reg_word21_p14;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word21_p15;
    assign word21[127:120] = XACC_reg_word21_p15;
    always @(posedge clk or posedge localReset)
        XACC_reg_word21_p15 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk21_15) ? wmux21[127:120] : XACC_reg_word21_p15;

    wire [15:0] wr0_word_we22_C13 = wr0_we_C13 & {16{(wr0_addr_C13 == 5'd22)}};
    wire [15:0] wr1_word_we22_C13 = wr1_we_C13 & {16{(wr1_addr_C13 == 5'd22)}};
    wire [15:0] wr2_word_we22_C15 = wr2_we_C15 & {16{(wr2_addr_C15 == 5'd22)}};
    wire [15:0] wr3_word_we22_C14 = wr3_we_C14 & {16{(wr3_addr_C14 == 5'd22)}};
    wire [15:0] word22_we = 16'b0 | wr0_word_we22_C13 | wr1_word_we22_C13 | wr2_word_we22_C15 | wr3_word_we22_C14;
    wire gclk22_0;
assign gclk22_0 = word22_we[0];
    wire gclk22_1;
assign gclk22_1 = word22_we[1];
    wire gclk22_2;
assign gclk22_2 = word22_we[2];
    wire gclk22_3;
assign gclk22_3 = word22_we[3];
    wire gclk22_4;
assign gclk22_4 = word22_we[4];
    wire gclk22_5;
assign gclk22_5 = word22_we[5];
    wire gclk22_6;
assign gclk22_6 = word22_we[6];
    wire gclk22_7;
assign gclk22_7 = word22_we[7];
    wire gclk22_8;
assign gclk22_8 = word22_we[8];
    wire gclk22_9;
assign gclk22_9 = word22_we[9];
    wire gclk22_10;
assign gclk22_10 = word22_we[10];
    wire gclk22_11;
assign gclk22_11 = word22_we[11];
    wire gclk22_12;
assign gclk22_12 = word22_we[12];
    wire gclk22_13;
assign gclk22_13 = word22_we[13];
    wire gclk22_14;
assign gclk22_14 = word22_we[14];
    wire gclk22_15;
assign gclk22_15 = word22_we[15];
    wire [127:0] wmux22;
    reg [7:0] xtmux_1411;
    always @(*) begin
        xtmux_1411 = 8'b0;
        case({wr0_word_we22_C13[0],
            wr1_word_we22_C13[0],
            wr2_word_we22_C15[0],
            wr3_word_we22_C14[0]}) 
/* synopsys full_case */
            4'b1000: xtmux_1411 = wr0_data_C13[7:0];
            4'b0100: xtmux_1411 = wr1_data_C13[7:0];
            4'b0010: xtmux_1411 = wr2_data_C15[7:0];
            4'b0001: xtmux_1411 = wr3_data_C14[7:0];
        endcase
    end
    assign wmux22[7:0] = xtmux_1411;

    reg [7:0] xtmux_1412;
    always @(*) begin
        xtmux_1412 = 8'b0;
        case({wr0_word_we22_C13[1],
            wr1_word_we22_C13[1],
            wr2_word_we22_C15[1],
            wr3_word_we22_C14[1]}) 
/* synopsys full_case */
            4'b1000: xtmux_1412 = wr0_data_C13[15:8];
            4'b0100: xtmux_1412 = wr1_data_C13[15:8];
            4'b0010: xtmux_1412 = wr2_data_C15[15:8];
            4'b0001: xtmux_1412 = wr3_data_C14[15:8];
        endcase
    end
    assign wmux22[15:8] = xtmux_1412;

    reg [7:0] xtmux_1413;
    always @(*) begin
        xtmux_1413 = 8'b0;
        case({wr0_word_we22_C13[2],
            wr1_word_we22_C13[2],
            wr2_word_we22_C15[2],
            wr3_word_we22_C14[2]}) 
/* synopsys full_case */
            4'b1000: xtmux_1413 = wr0_data_C13[23:16];
            4'b0100: xtmux_1413 = wr1_data_C13[23:16];
            4'b0010: xtmux_1413 = wr2_data_C15[23:16];
            4'b0001: xtmux_1413 = wr3_data_C14[23:16];
        endcase
    end
    assign wmux22[23:16] = xtmux_1413;

    reg [7:0] xtmux_1414;
    always @(*) begin
        xtmux_1414 = 8'b0;
        case({wr0_word_we22_C13[3],
            wr1_word_we22_C13[3],
            wr2_word_we22_C15[3],
            wr3_word_we22_C14[3]}) 
/* synopsys full_case */
            4'b1000: xtmux_1414 = wr0_data_C13[31:24];
            4'b0100: xtmux_1414 = wr1_data_C13[31:24];
            4'b0010: xtmux_1414 = wr2_data_C15[31:24];
            4'b0001: xtmux_1414 = wr3_data_C14[31:24];
        endcase
    end
    assign wmux22[31:24] = xtmux_1414;

    reg [7:0] xtmux_1415;
    always @(*) begin
        xtmux_1415 = 8'b0;
        case({wr0_word_we22_C13[4],
            wr1_word_we22_C13[4],
            wr2_word_we22_C15[4],
            wr3_word_we22_C14[4]}) 
/* synopsys full_case */
            4'b1000: xtmux_1415 = wr0_data_C13[39:32];
            4'b0100: xtmux_1415 = wr1_data_C13[39:32];
            4'b0010: xtmux_1415 = wr2_data_C15[39:32];
            4'b0001: xtmux_1415 = wr3_data_C14[39:32];
        endcase
    end
    assign wmux22[39:32] = xtmux_1415;

    reg [7:0] xtmux_1416;
    always @(*) begin
        xtmux_1416 = 8'b0;
        case({wr0_word_we22_C13[5],
            wr1_word_we22_C13[5],
            wr2_word_we22_C15[5],
            wr3_word_we22_C14[5]}) 
/* synopsys full_case */
            4'b1000: xtmux_1416 = wr0_data_C13[47:40];
            4'b0100: xtmux_1416 = wr1_data_C13[47:40];
            4'b0010: xtmux_1416 = wr2_data_C15[47:40];
            4'b0001: xtmux_1416 = wr3_data_C14[47:40];
        endcase
    end
    assign wmux22[47:40] = xtmux_1416;

    reg [7:0] xtmux_1417;
    always @(*) begin
        xtmux_1417 = 8'b0;
        case({wr0_word_we22_C13[6],
            wr1_word_we22_C13[6],
            wr2_word_we22_C15[6],
            wr3_word_we22_C14[6]}) 
/* synopsys full_case */
            4'b1000: xtmux_1417 = wr0_data_C13[55:48];
            4'b0100: xtmux_1417 = wr1_data_C13[55:48];
            4'b0010: xtmux_1417 = wr2_data_C15[55:48];
            4'b0001: xtmux_1417 = wr3_data_C14[55:48];
        endcase
    end
    assign wmux22[55:48] = xtmux_1417;

    reg [7:0] xtmux_1418;
    always @(*) begin
        xtmux_1418 = 8'b0;
        case({wr0_word_we22_C13[7],
            wr1_word_we22_C13[7],
            wr2_word_we22_C15[7],
            wr3_word_we22_C14[7]}) 
/* synopsys full_case */
            4'b1000: xtmux_1418 = wr0_data_C13[63:56];
            4'b0100: xtmux_1418 = wr1_data_C13[63:56];
            4'b0010: xtmux_1418 = wr2_data_C15[63:56];
            4'b0001: xtmux_1418 = wr3_data_C14[63:56];
        endcase
    end
    assign wmux22[63:56] = xtmux_1418;

    reg [7:0] xtmux_1419;
    always @(*) begin
        xtmux_1419 = 8'b0;
        case({wr0_word_we22_C13[8],
            wr1_word_we22_C13[8],
            wr2_word_we22_C15[8],
            wr3_word_we22_C14[8]}) 
/* synopsys full_case */
            4'b1000: xtmux_1419 = wr0_data_C13[71:64];
            4'b0100: xtmux_1419 = wr1_data_C13[71:64];
            4'b0010: xtmux_1419 = wr2_data_C15[71:64];
            4'b0001: xtmux_1419 = wr3_data_C14[71:64];
        endcase
    end
    assign wmux22[71:64] = xtmux_1419;

    reg [7:0] xtmux_1420;
    always @(*) begin
        xtmux_1420 = 8'b0;
        case({wr0_word_we22_C13[9],
            wr1_word_we22_C13[9],
            wr2_word_we22_C15[9],
            wr3_word_we22_C14[9]}) 
/* synopsys full_case */
            4'b1000: xtmux_1420 = wr0_data_C13[79:72];
            4'b0100: xtmux_1420 = wr1_data_C13[79:72];
            4'b0010: xtmux_1420 = wr2_data_C15[79:72];
            4'b0001: xtmux_1420 = wr3_data_C14[79:72];
        endcase
    end
    assign wmux22[79:72] = xtmux_1420;

    reg [7:0] xtmux_1421;
    always @(*) begin
        xtmux_1421 = 8'b0;
        case({wr0_word_we22_C13[10],
            wr1_word_we22_C13[10],
            wr2_word_we22_C15[10],
            wr3_word_we22_C14[10]}) 
/* synopsys full_case */
            4'b1000: xtmux_1421 = wr0_data_C13[87:80];
            4'b0100: xtmux_1421 = wr1_data_C13[87:80];
            4'b0010: xtmux_1421 = wr2_data_C15[87:80];
            4'b0001: xtmux_1421 = wr3_data_C14[87:80];
        endcase
    end
    assign wmux22[87:80] = xtmux_1421;

    reg [7:0] xtmux_1422;
    always @(*) begin
        xtmux_1422 = 8'b0;
        case({wr0_word_we22_C13[11],
            wr1_word_we22_C13[11],
            wr2_word_we22_C15[11],
            wr3_word_we22_C14[11]}) 
/* synopsys full_case */
            4'b1000: xtmux_1422 = wr0_data_C13[95:88];
            4'b0100: xtmux_1422 = wr1_data_C13[95:88];
            4'b0010: xtmux_1422 = wr2_data_C15[95:88];
            4'b0001: xtmux_1422 = wr3_data_C14[95:88];
        endcase
    end
    assign wmux22[95:88] = xtmux_1422;

    reg [7:0] xtmux_1423;
    always @(*) begin
        xtmux_1423 = 8'b0;
        case({wr0_word_we22_C13[12],
            wr1_word_we22_C13[12],
            wr2_word_we22_C15[12],
            wr3_word_we22_C14[12]}) 
/* synopsys full_case */
            4'b1000: xtmux_1423 = wr0_data_C13[103:96];
            4'b0100: xtmux_1423 = wr1_data_C13[103:96];
            4'b0010: xtmux_1423 = wr2_data_C15[103:96];
            4'b0001: xtmux_1423 = wr3_data_C14[103:96];
        endcase
    end
    assign wmux22[103:96] = xtmux_1423;

    reg [7:0] xtmux_1424;
    always @(*) begin
        xtmux_1424 = 8'b0;
        case({wr0_word_we22_C13[13],
            wr1_word_we22_C13[13],
            wr2_word_we22_C15[13],
            wr3_word_we22_C14[13]}) 
/* synopsys full_case */
            4'b1000: xtmux_1424 = wr0_data_C13[111:104];
            4'b0100: xtmux_1424 = wr1_data_C13[111:104];
            4'b0010: xtmux_1424 = wr2_data_C15[111:104];
            4'b0001: xtmux_1424 = wr3_data_C14[111:104];
        endcase
    end
    assign wmux22[111:104] = xtmux_1424;

    reg [7:0] xtmux_1425;
    always @(*) begin
        xtmux_1425 = 8'b0;
        case({wr0_word_we22_C13[14],
            wr1_word_we22_C13[14],
            wr2_word_we22_C15[14],
            wr3_word_we22_C14[14]}) 
/* synopsys full_case */
            4'b1000: xtmux_1425 = wr0_data_C13[119:112];
            4'b0100: xtmux_1425 = wr1_data_C13[119:112];
            4'b0010: xtmux_1425 = wr2_data_C15[119:112];
            4'b0001: xtmux_1425 = wr3_data_C14[119:112];
        endcase
    end
    assign wmux22[119:112] = xtmux_1425;

    reg [7:0] xtmux_1426;
    always @(*) begin
        xtmux_1426 = 8'b0;
        case({wr0_word_we22_C13[15],
            wr1_word_we22_C13[15],
            wr2_word_we22_C15[15],
            wr3_word_we22_C14[15]}) 
/* synopsys full_case */
            4'b1000: xtmux_1426 = wr0_data_C13[127:120];
            4'b0100: xtmux_1426 = wr1_data_C13[127:120];
            4'b0010: xtmux_1426 = wr2_data_C15[127:120];
            4'b0001: xtmux_1426 = wr3_data_C14[127:120];
        endcase
    end
    assign wmux22[127:120] = xtmux_1426;

    wire [127:0] word22;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word22_p0;
    assign word22[7:0] = XACC_reg_word22_p0;
    always @(posedge clk or posedge localReset)
        XACC_reg_word22_p0 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk22_0) ? wmux22[7:0] : XACC_reg_word22_p0;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word22_p1;
    assign word22[15:8] = XACC_reg_word22_p1;
    always @(posedge clk or posedge localReset)
        XACC_reg_word22_p1 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk22_1) ? wmux22[15:8] : XACC_reg_word22_p1;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word22_p2;
    assign word22[23:16] = XACC_reg_word22_p2;
    always @(posedge clk or posedge localReset)
        XACC_reg_word22_p2 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk22_2) ? wmux22[23:16] : XACC_reg_word22_p2;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word22_p3;
    assign word22[31:24] = XACC_reg_word22_p3;
    always @(posedge clk or posedge localReset)
        XACC_reg_word22_p3 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk22_3) ? wmux22[31:24] : XACC_reg_word22_p3;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word22_p4;
    assign word22[39:32] = XACC_reg_word22_p4;
    always @(posedge clk or posedge localReset)
        XACC_reg_word22_p4 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk22_4) ? wmux22[39:32] : XACC_reg_word22_p4;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word22_p5;
    assign word22[47:40] = XACC_reg_word22_p5;
    always @(posedge clk or posedge localReset)
        XACC_reg_word22_p5 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk22_5) ? wmux22[47:40] : XACC_reg_word22_p5;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word22_p6;
    assign word22[55:48] = XACC_reg_word22_p6;
    always @(posedge clk or posedge localReset)
        XACC_reg_word22_p6 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk22_6) ? wmux22[55:48] : XACC_reg_word22_p6;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word22_p7;
    assign word22[63:56] = XACC_reg_word22_p7;
    always @(posedge clk or posedge localReset)
        XACC_reg_word22_p7 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk22_7) ? wmux22[63:56] : XACC_reg_word22_p7;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word22_p8;
    assign word22[71:64] = XACC_reg_word22_p8;
    always @(posedge clk or posedge localReset)
        XACC_reg_word22_p8 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk22_8) ? wmux22[71:64] : XACC_reg_word22_p8;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word22_p9;
    assign word22[79:72] = XACC_reg_word22_p9;
    always @(posedge clk or posedge localReset)
        XACC_reg_word22_p9 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk22_9) ? wmux22[79:72] : XACC_reg_word22_p9;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word22_p10;
    assign word22[87:80] = XACC_reg_word22_p10;
    always @(posedge clk or posedge localReset)
        XACC_reg_word22_p10 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk22_10) ? wmux22[87:80] : XACC_reg_word22_p10;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word22_p11;
    assign word22[95:88] = XACC_reg_word22_p11;
    always @(posedge clk or posedge localReset)
        XACC_reg_word22_p11 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk22_11) ? wmux22[95:88] : XACC_reg_word22_p11;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word22_p12;
    assign word22[103:96] = XACC_reg_word22_p12;
    always @(posedge clk or posedge localReset)
        XACC_reg_word22_p12 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk22_12) ? wmux22[103:96] : XACC_reg_word22_p12;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word22_p13;
    assign word22[111:104] = XACC_reg_word22_p13;
    always @(posedge clk or posedge localReset)
        XACC_reg_word22_p13 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk22_13) ? wmux22[111:104] : XACC_reg_word22_p13;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word22_p14;
    assign word22[119:112] = XACC_reg_word22_p14;
    always @(posedge clk or posedge localReset)
        XACC_reg_word22_p14 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk22_14) ? wmux22[119:112] : XACC_reg_word22_p14;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word22_p15;
    assign word22[127:120] = XACC_reg_word22_p15;
    always @(posedge clk or posedge localReset)
        XACC_reg_word22_p15 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk22_15) ? wmux22[127:120] : XACC_reg_word22_p15;

    wire [15:0] wr0_word_we23_C13 = wr0_we_C13 & {16{(wr0_addr_C13 == 5'd23)}};
    wire [15:0] wr1_word_we23_C13 = wr1_we_C13 & {16{(wr1_addr_C13 == 5'd23)}};
    wire [15:0] wr2_word_we23_C15 = wr2_we_C15 & {16{(wr2_addr_C15 == 5'd23)}};
    wire [15:0] wr3_word_we23_C14 = wr3_we_C14 & {16{(wr3_addr_C14 == 5'd23)}};
    wire [15:0] word23_we = 16'b0 | wr0_word_we23_C13 | wr1_word_we23_C13 | wr2_word_we23_C15 | wr3_word_we23_C14;
    wire gclk23_0;
assign gclk23_0 = word23_we[0];
    wire gclk23_1;
assign gclk23_1 = word23_we[1];
    wire gclk23_2;
assign gclk23_2 = word23_we[2];
    wire gclk23_3;
assign gclk23_3 = word23_we[3];
    wire gclk23_4;
assign gclk23_4 = word23_we[4];
    wire gclk23_5;
assign gclk23_5 = word23_we[5];
    wire gclk23_6;
assign gclk23_6 = word23_we[6];
    wire gclk23_7;
assign gclk23_7 = word23_we[7];
    wire gclk23_8;
assign gclk23_8 = word23_we[8];
    wire gclk23_9;
assign gclk23_9 = word23_we[9];
    wire gclk23_10;
assign gclk23_10 = word23_we[10];
    wire gclk23_11;
assign gclk23_11 = word23_we[11];
    wire gclk23_12;
assign gclk23_12 = word23_we[12];
    wire gclk23_13;
assign gclk23_13 = word23_we[13];
    wire gclk23_14;
assign gclk23_14 = word23_we[14];
    wire gclk23_15;
assign gclk23_15 = word23_we[15];
    wire [127:0] wmux23;
    reg [7:0] xtmux_1427;
    always @(*) begin
        xtmux_1427 = 8'b0;
        case({wr0_word_we23_C13[0],
            wr1_word_we23_C13[0],
            wr2_word_we23_C15[0],
            wr3_word_we23_C14[0]}) 
/* synopsys full_case */
            4'b1000: xtmux_1427 = wr0_data_C13[7:0];
            4'b0100: xtmux_1427 = wr1_data_C13[7:0];
            4'b0010: xtmux_1427 = wr2_data_C15[7:0];
            4'b0001: xtmux_1427 = wr3_data_C14[7:0];
        endcase
    end
    assign wmux23[7:0] = xtmux_1427;

    reg [7:0] xtmux_1428;
    always @(*) begin
        xtmux_1428 = 8'b0;
        case({wr0_word_we23_C13[1],
            wr1_word_we23_C13[1],
            wr2_word_we23_C15[1],
            wr3_word_we23_C14[1]}) 
/* synopsys full_case */
            4'b1000: xtmux_1428 = wr0_data_C13[15:8];
            4'b0100: xtmux_1428 = wr1_data_C13[15:8];
            4'b0010: xtmux_1428 = wr2_data_C15[15:8];
            4'b0001: xtmux_1428 = wr3_data_C14[15:8];
        endcase
    end
    assign wmux23[15:8] = xtmux_1428;

    reg [7:0] xtmux_1429;
    always @(*) begin
        xtmux_1429 = 8'b0;
        case({wr0_word_we23_C13[2],
            wr1_word_we23_C13[2],
            wr2_word_we23_C15[2],
            wr3_word_we23_C14[2]}) 
/* synopsys full_case */
            4'b1000: xtmux_1429 = wr0_data_C13[23:16];
            4'b0100: xtmux_1429 = wr1_data_C13[23:16];
            4'b0010: xtmux_1429 = wr2_data_C15[23:16];
            4'b0001: xtmux_1429 = wr3_data_C14[23:16];
        endcase
    end
    assign wmux23[23:16] = xtmux_1429;

    reg [7:0] xtmux_1430;
    always @(*) begin
        xtmux_1430 = 8'b0;
        case({wr0_word_we23_C13[3],
            wr1_word_we23_C13[3],
            wr2_word_we23_C15[3],
            wr3_word_we23_C14[3]}) 
/* synopsys full_case */
            4'b1000: xtmux_1430 = wr0_data_C13[31:24];
            4'b0100: xtmux_1430 = wr1_data_C13[31:24];
            4'b0010: xtmux_1430 = wr2_data_C15[31:24];
            4'b0001: xtmux_1430 = wr3_data_C14[31:24];
        endcase
    end
    assign wmux23[31:24] = xtmux_1430;

    reg [7:0] xtmux_1431;
    always @(*) begin
        xtmux_1431 = 8'b0;
        case({wr0_word_we23_C13[4],
            wr1_word_we23_C13[4],
            wr2_word_we23_C15[4],
            wr3_word_we23_C14[4]}) 
/* synopsys full_case */
            4'b1000: xtmux_1431 = wr0_data_C13[39:32];
            4'b0100: xtmux_1431 = wr1_data_C13[39:32];
            4'b0010: xtmux_1431 = wr2_data_C15[39:32];
            4'b0001: xtmux_1431 = wr3_data_C14[39:32];
        endcase
    end
    assign wmux23[39:32] = xtmux_1431;

    reg [7:0] xtmux_1432;
    always @(*) begin
        xtmux_1432 = 8'b0;
        case({wr0_word_we23_C13[5],
            wr1_word_we23_C13[5],
            wr2_word_we23_C15[5],
            wr3_word_we23_C14[5]}) 
/* synopsys full_case */
            4'b1000: xtmux_1432 = wr0_data_C13[47:40];
            4'b0100: xtmux_1432 = wr1_data_C13[47:40];
            4'b0010: xtmux_1432 = wr2_data_C15[47:40];
            4'b0001: xtmux_1432 = wr3_data_C14[47:40];
        endcase
    end
    assign wmux23[47:40] = xtmux_1432;

    reg [7:0] xtmux_1433;
    always @(*) begin
        xtmux_1433 = 8'b0;
        case({wr0_word_we23_C13[6],
            wr1_word_we23_C13[6],
            wr2_word_we23_C15[6],
            wr3_word_we23_C14[6]}) 
/* synopsys full_case */
            4'b1000: xtmux_1433 = wr0_data_C13[55:48];
            4'b0100: xtmux_1433 = wr1_data_C13[55:48];
            4'b0010: xtmux_1433 = wr2_data_C15[55:48];
            4'b0001: xtmux_1433 = wr3_data_C14[55:48];
        endcase
    end
    assign wmux23[55:48] = xtmux_1433;

    reg [7:0] xtmux_1434;
    always @(*) begin
        xtmux_1434 = 8'b0;
        case({wr0_word_we23_C13[7],
            wr1_word_we23_C13[7],
            wr2_word_we23_C15[7],
            wr3_word_we23_C14[7]}) 
/* synopsys full_case */
            4'b1000: xtmux_1434 = wr0_data_C13[63:56];
            4'b0100: xtmux_1434 = wr1_data_C13[63:56];
            4'b0010: xtmux_1434 = wr2_data_C15[63:56];
            4'b0001: xtmux_1434 = wr3_data_C14[63:56];
        endcase
    end
    assign wmux23[63:56] = xtmux_1434;

    reg [7:0] xtmux_1435;
    always @(*) begin
        xtmux_1435 = 8'b0;
        case({wr0_word_we23_C13[8],
            wr1_word_we23_C13[8],
            wr2_word_we23_C15[8],
            wr3_word_we23_C14[8]}) 
/* synopsys full_case */
            4'b1000: xtmux_1435 = wr0_data_C13[71:64];
            4'b0100: xtmux_1435 = wr1_data_C13[71:64];
            4'b0010: xtmux_1435 = wr2_data_C15[71:64];
            4'b0001: xtmux_1435 = wr3_data_C14[71:64];
        endcase
    end
    assign wmux23[71:64] = xtmux_1435;

    reg [7:0] xtmux_1436;
    always @(*) begin
        xtmux_1436 = 8'b0;
        case({wr0_word_we23_C13[9],
            wr1_word_we23_C13[9],
            wr2_word_we23_C15[9],
            wr3_word_we23_C14[9]}) 
/* synopsys full_case */
            4'b1000: xtmux_1436 = wr0_data_C13[79:72];
            4'b0100: xtmux_1436 = wr1_data_C13[79:72];
            4'b0010: xtmux_1436 = wr2_data_C15[79:72];
            4'b0001: xtmux_1436 = wr3_data_C14[79:72];
        endcase
    end
    assign wmux23[79:72] = xtmux_1436;

    reg [7:0] xtmux_1437;
    always @(*) begin
        xtmux_1437 = 8'b0;
        case({wr0_word_we23_C13[10],
            wr1_word_we23_C13[10],
            wr2_word_we23_C15[10],
            wr3_word_we23_C14[10]}) 
/* synopsys full_case */
            4'b1000: xtmux_1437 = wr0_data_C13[87:80];
            4'b0100: xtmux_1437 = wr1_data_C13[87:80];
            4'b0010: xtmux_1437 = wr2_data_C15[87:80];
            4'b0001: xtmux_1437 = wr3_data_C14[87:80];
        endcase
    end
    assign wmux23[87:80] = xtmux_1437;

    reg [7:0] xtmux_1438;
    always @(*) begin
        xtmux_1438 = 8'b0;
        case({wr0_word_we23_C13[11],
            wr1_word_we23_C13[11],
            wr2_word_we23_C15[11],
            wr3_word_we23_C14[11]}) 
/* synopsys full_case */
            4'b1000: xtmux_1438 = wr0_data_C13[95:88];
            4'b0100: xtmux_1438 = wr1_data_C13[95:88];
            4'b0010: xtmux_1438 = wr2_data_C15[95:88];
            4'b0001: xtmux_1438 = wr3_data_C14[95:88];
        endcase
    end
    assign wmux23[95:88] = xtmux_1438;

    reg [7:0] xtmux_1439;
    always @(*) begin
        xtmux_1439 = 8'b0;
        case({wr0_word_we23_C13[12],
            wr1_word_we23_C13[12],
            wr2_word_we23_C15[12],
            wr3_word_we23_C14[12]}) 
/* synopsys full_case */
            4'b1000: xtmux_1439 = wr0_data_C13[103:96];
            4'b0100: xtmux_1439 = wr1_data_C13[103:96];
            4'b0010: xtmux_1439 = wr2_data_C15[103:96];
            4'b0001: xtmux_1439 = wr3_data_C14[103:96];
        endcase
    end
    assign wmux23[103:96] = xtmux_1439;

    reg [7:0] xtmux_1440;
    always @(*) begin
        xtmux_1440 = 8'b0;
        case({wr0_word_we23_C13[13],
            wr1_word_we23_C13[13],
            wr2_word_we23_C15[13],
            wr3_word_we23_C14[13]}) 
/* synopsys full_case */
            4'b1000: xtmux_1440 = wr0_data_C13[111:104];
            4'b0100: xtmux_1440 = wr1_data_C13[111:104];
            4'b0010: xtmux_1440 = wr2_data_C15[111:104];
            4'b0001: xtmux_1440 = wr3_data_C14[111:104];
        endcase
    end
    assign wmux23[111:104] = xtmux_1440;

    reg [7:0] xtmux_1441;
    always @(*) begin
        xtmux_1441 = 8'b0;
        case({wr0_word_we23_C13[14],
            wr1_word_we23_C13[14],
            wr2_word_we23_C15[14],
            wr3_word_we23_C14[14]}) 
/* synopsys full_case */
            4'b1000: xtmux_1441 = wr0_data_C13[119:112];
            4'b0100: xtmux_1441 = wr1_data_C13[119:112];
            4'b0010: xtmux_1441 = wr2_data_C15[119:112];
            4'b0001: xtmux_1441 = wr3_data_C14[119:112];
        endcase
    end
    assign wmux23[119:112] = xtmux_1441;

    reg [7:0] xtmux_1442;
    always @(*) begin
        xtmux_1442 = 8'b0;
        case({wr0_word_we23_C13[15],
            wr1_word_we23_C13[15],
            wr2_word_we23_C15[15],
            wr3_word_we23_C14[15]}) 
/* synopsys full_case */
            4'b1000: xtmux_1442 = wr0_data_C13[127:120];
            4'b0100: xtmux_1442 = wr1_data_C13[127:120];
            4'b0010: xtmux_1442 = wr2_data_C15[127:120];
            4'b0001: xtmux_1442 = wr3_data_C14[127:120];
        endcase
    end
    assign wmux23[127:120] = xtmux_1442;

    wire [127:0] word23;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word23_p0;
    assign word23[7:0] = XACC_reg_word23_p0;
    always @(posedge clk or posedge localReset)
        XACC_reg_word23_p0 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk23_0) ? wmux23[7:0] : XACC_reg_word23_p0;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word23_p1;
    assign word23[15:8] = XACC_reg_word23_p1;
    always @(posedge clk or posedge localReset)
        XACC_reg_word23_p1 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk23_1) ? wmux23[15:8] : XACC_reg_word23_p1;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word23_p2;
    assign word23[23:16] = XACC_reg_word23_p2;
    always @(posedge clk or posedge localReset)
        XACC_reg_word23_p2 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk23_2) ? wmux23[23:16] : XACC_reg_word23_p2;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word23_p3;
    assign word23[31:24] = XACC_reg_word23_p3;
    always @(posedge clk or posedge localReset)
        XACC_reg_word23_p3 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk23_3) ? wmux23[31:24] : XACC_reg_word23_p3;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word23_p4;
    assign word23[39:32] = XACC_reg_word23_p4;
    always @(posedge clk or posedge localReset)
        XACC_reg_word23_p4 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk23_4) ? wmux23[39:32] : XACC_reg_word23_p4;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word23_p5;
    assign word23[47:40] = XACC_reg_word23_p5;
    always @(posedge clk or posedge localReset)
        XACC_reg_word23_p5 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk23_5) ? wmux23[47:40] : XACC_reg_word23_p5;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word23_p6;
    assign word23[55:48] = XACC_reg_word23_p6;
    always @(posedge clk or posedge localReset)
        XACC_reg_word23_p6 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk23_6) ? wmux23[55:48] : XACC_reg_word23_p6;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word23_p7;
    assign word23[63:56] = XACC_reg_word23_p7;
    always @(posedge clk or posedge localReset)
        XACC_reg_word23_p7 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk23_7) ? wmux23[63:56] : XACC_reg_word23_p7;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word23_p8;
    assign word23[71:64] = XACC_reg_word23_p8;
    always @(posedge clk or posedge localReset)
        XACC_reg_word23_p8 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk23_8) ? wmux23[71:64] : XACC_reg_word23_p8;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word23_p9;
    assign word23[79:72] = XACC_reg_word23_p9;
    always @(posedge clk or posedge localReset)
        XACC_reg_word23_p9 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk23_9) ? wmux23[79:72] : XACC_reg_word23_p9;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word23_p10;
    assign word23[87:80] = XACC_reg_word23_p10;
    always @(posedge clk or posedge localReset)
        XACC_reg_word23_p10 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk23_10) ? wmux23[87:80] : XACC_reg_word23_p10;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word23_p11;
    assign word23[95:88] = XACC_reg_word23_p11;
    always @(posedge clk or posedge localReset)
        XACC_reg_word23_p11 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk23_11) ? wmux23[95:88] : XACC_reg_word23_p11;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word23_p12;
    assign word23[103:96] = XACC_reg_word23_p12;
    always @(posedge clk or posedge localReset)
        XACC_reg_word23_p12 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk23_12) ? wmux23[103:96] : XACC_reg_word23_p12;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word23_p13;
    assign word23[111:104] = XACC_reg_word23_p13;
    always @(posedge clk or posedge localReset)
        XACC_reg_word23_p13 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk23_13) ? wmux23[111:104] : XACC_reg_word23_p13;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word23_p14;
    assign word23[119:112] = XACC_reg_word23_p14;
    always @(posedge clk or posedge localReset)
        XACC_reg_word23_p14 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk23_14) ? wmux23[119:112] : XACC_reg_word23_p14;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word23_p15;
    assign word23[127:120] = XACC_reg_word23_p15;
    always @(posedge clk or posedge localReset)
        XACC_reg_word23_p15 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk23_15) ? wmux23[127:120] : XACC_reg_word23_p15;

    wire [15:0] wr0_word_we24_C13 = wr0_we_C13 & {16{(wr0_addr_C13 == 5'd24)}};
    wire [15:0] wr1_word_we24_C13 = wr1_we_C13 & {16{(wr1_addr_C13 == 5'd24)}};
    wire [15:0] wr2_word_we24_C15 = wr2_we_C15 & {16{(wr2_addr_C15 == 5'd24)}};
    wire [15:0] wr3_word_we24_C14 = wr3_we_C14 & {16{(wr3_addr_C14 == 5'd24)}};
    wire [15:0] word24_we = 16'b0 | wr0_word_we24_C13 | wr1_word_we24_C13 | wr2_word_we24_C15 | wr3_word_we24_C14;
    wire gclk24_0;
assign gclk24_0 = word24_we[0];
    wire gclk24_1;
assign gclk24_1 = word24_we[1];
    wire gclk24_2;
assign gclk24_2 = word24_we[2];
    wire gclk24_3;
assign gclk24_3 = word24_we[3];
    wire gclk24_4;
assign gclk24_4 = word24_we[4];
    wire gclk24_5;
assign gclk24_5 = word24_we[5];
    wire gclk24_6;
assign gclk24_6 = word24_we[6];
    wire gclk24_7;
assign gclk24_7 = word24_we[7];
    wire gclk24_8;
assign gclk24_8 = word24_we[8];
    wire gclk24_9;
assign gclk24_9 = word24_we[9];
    wire gclk24_10;
assign gclk24_10 = word24_we[10];
    wire gclk24_11;
assign gclk24_11 = word24_we[11];
    wire gclk24_12;
assign gclk24_12 = word24_we[12];
    wire gclk24_13;
assign gclk24_13 = word24_we[13];
    wire gclk24_14;
assign gclk24_14 = word24_we[14];
    wire gclk24_15;
assign gclk24_15 = word24_we[15];
    wire [127:0] wmux24;
    reg [7:0] xtmux_1443;
    always @(*) begin
        xtmux_1443 = 8'b0;
        case({wr0_word_we24_C13[0],
            wr1_word_we24_C13[0],
            wr2_word_we24_C15[0],
            wr3_word_we24_C14[0]}) 
/* synopsys full_case */
            4'b1000: xtmux_1443 = wr0_data_C13[7:0];
            4'b0100: xtmux_1443 = wr1_data_C13[7:0];
            4'b0010: xtmux_1443 = wr2_data_C15[7:0];
            4'b0001: xtmux_1443 = wr3_data_C14[7:0];
        endcase
    end
    assign wmux24[7:0] = xtmux_1443;

    reg [7:0] xtmux_1444;
    always @(*) begin
        xtmux_1444 = 8'b0;
        case({wr0_word_we24_C13[1],
            wr1_word_we24_C13[1],
            wr2_word_we24_C15[1],
            wr3_word_we24_C14[1]}) 
/* synopsys full_case */
            4'b1000: xtmux_1444 = wr0_data_C13[15:8];
            4'b0100: xtmux_1444 = wr1_data_C13[15:8];
            4'b0010: xtmux_1444 = wr2_data_C15[15:8];
            4'b0001: xtmux_1444 = wr3_data_C14[15:8];
        endcase
    end
    assign wmux24[15:8] = xtmux_1444;

    reg [7:0] xtmux_1445;
    always @(*) begin
        xtmux_1445 = 8'b0;
        case({wr0_word_we24_C13[2],
            wr1_word_we24_C13[2],
            wr2_word_we24_C15[2],
            wr3_word_we24_C14[2]}) 
/* synopsys full_case */
            4'b1000: xtmux_1445 = wr0_data_C13[23:16];
            4'b0100: xtmux_1445 = wr1_data_C13[23:16];
            4'b0010: xtmux_1445 = wr2_data_C15[23:16];
            4'b0001: xtmux_1445 = wr3_data_C14[23:16];
        endcase
    end
    assign wmux24[23:16] = xtmux_1445;

    reg [7:0] xtmux_1446;
    always @(*) begin
        xtmux_1446 = 8'b0;
        case({wr0_word_we24_C13[3],
            wr1_word_we24_C13[3],
            wr2_word_we24_C15[3],
            wr3_word_we24_C14[3]}) 
/* synopsys full_case */
            4'b1000: xtmux_1446 = wr0_data_C13[31:24];
            4'b0100: xtmux_1446 = wr1_data_C13[31:24];
            4'b0010: xtmux_1446 = wr2_data_C15[31:24];
            4'b0001: xtmux_1446 = wr3_data_C14[31:24];
        endcase
    end
    assign wmux24[31:24] = xtmux_1446;

    reg [7:0] xtmux_1447;
    always @(*) begin
        xtmux_1447 = 8'b0;
        case({wr0_word_we24_C13[4],
            wr1_word_we24_C13[4],
            wr2_word_we24_C15[4],
            wr3_word_we24_C14[4]}) 
/* synopsys full_case */
            4'b1000: xtmux_1447 = wr0_data_C13[39:32];
            4'b0100: xtmux_1447 = wr1_data_C13[39:32];
            4'b0010: xtmux_1447 = wr2_data_C15[39:32];
            4'b0001: xtmux_1447 = wr3_data_C14[39:32];
        endcase
    end
    assign wmux24[39:32] = xtmux_1447;

    reg [7:0] xtmux_1448;
    always @(*) begin
        xtmux_1448 = 8'b0;
        case({wr0_word_we24_C13[5],
            wr1_word_we24_C13[5],
            wr2_word_we24_C15[5],
            wr3_word_we24_C14[5]}) 
/* synopsys full_case */
            4'b1000: xtmux_1448 = wr0_data_C13[47:40];
            4'b0100: xtmux_1448 = wr1_data_C13[47:40];
            4'b0010: xtmux_1448 = wr2_data_C15[47:40];
            4'b0001: xtmux_1448 = wr3_data_C14[47:40];
        endcase
    end
    assign wmux24[47:40] = xtmux_1448;

    reg [7:0] xtmux_1449;
    always @(*) begin
        xtmux_1449 = 8'b0;
        case({wr0_word_we24_C13[6],
            wr1_word_we24_C13[6],
            wr2_word_we24_C15[6],
            wr3_word_we24_C14[6]}) 
/* synopsys full_case */
            4'b1000: xtmux_1449 = wr0_data_C13[55:48];
            4'b0100: xtmux_1449 = wr1_data_C13[55:48];
            4'b0010: xtmux_1449 = wr2_data_C15[55:48];
            4'b0001: xtmux_1449 = wr3_data_C14[55:48];
        endcase
    end
    assign wmux24[55:48] = xtmux_1449;

    reg [7:0] xtmux_1450;
    always @(*) begin
        xtmux_1450 = 8'b0;
        case({wr0_word_we24_C13[7],
            wr1_word_we24_C13[7],
            wr2_word_we24_C15[7],
            wr3_word_we24_C14[7]}) 
/* synopsys full_case */
            4'b1000: xtmux_1450 = wr0_data_C13[63:56];
            4'b0100: xtmux_1450 = wr1_data_C13[63:56];
            4'b0010: xtmux_1450 = wr2_data_C15[63:56];
            4'b0001: xtmux_1450 = wr3_data_C14[63:56];
        endcase
    end
    assign wmux24[63:56] = xtmux_1450;

    reg [7:0] xtmux_1451;
    always @(*) begin
        xtmux_1451 = 8'b0;
        case({wr0_word_we24_C13[8],
            wr1_word_we24_C13[8],
            wr2_word_we24_C15[8],
            wr3_word_we24_C14[8]}) 
/* synopsys full_case */
            4'b1000: xtmux_1451 = wr0_data_C13[71:64];
            4'b0100: xtmux_1451 = wr1_data_C13[71:64];
            4'b0010: xtmux_1451 = wr2_data_C15[71:64];
            4'b0001: xtmux_1451 = wr3_data_C14[71:64];
        endcase
    end
    assign wmux24[71:64] = xtmux_1451;

    reg [7:0] xtmux_1452;
    always @(*) begin
        xtmux_1452 = 8'b0;
        case({wr0_word_we24_C13[9],
            wr1_word_we24_C13[9],
            wr2_word_we24_C15[9],
            wr3_word_we24_C14[9]}) 
/* synopsys full_case */
            4'b1000: xtmux_1452 = wr0_data_C13[79:72];
            4'b0100: xtmux_1452 = wr1_data_C13[79:72];
            4'b0010: xtmux_1452 = wr2_data_C15[79:72];
            4'b0001: xtmux_1452 = wr3_data_C14[79:72];
        endcase
    end
    assign wmux24[79:72] = xtmux_1452;

    reg [7:0] xtmux_1453;
    always @(*) begin
        xtmux_1453 = 8'b0;
        case({wr0_word_we24_C13[10],
            wr1_word_we24_C13[10],
            wr2_word_we24_C15[10],
            wr3_word_we24_C14[10]}) 
/* synopsys full_case */
            4'b1000: xtmux_1453 = wr0_data_C13[87:80];
            4'b0100: xtmux_1453 = wr1_data_C13[87:80];
            4'b0010: xtmux_1453 = wr2_data_C15[87:80];
            4'b0001: xtmux_1453 = wr3_data_C14[87:80];
        endcase
    end
    assign wmux24[87:80] = xtmux_1453;

    reg [7:0] xtmux_1454;
    always @(*) begin
        xtmux_1454 = 8'b0;
        case({wr0_word_we24_C13[11],
            wr1_word_we24_C13[11],
            wr2_word_we24_C15[11],
            wr3_word_we24_C14[11]}) 
/* synopsys full_case */
            4'b1000: xtmux_1454 = wr0_data_C13[95:88];
            4'b0100: xtmux_1454 = wr1_data_C13[95:88];
            4'b0010: xtmux_1454 = wr2_data_C15[95:88];
            4'b0001: xtmux_1454 = wr3_data_C14[95:88];
        endcase
    end
    assign wmux24[95:88] = xtmux_1454;

    reg [7:0] xtmux_1455;
    always @(*) begin
        xtmux_1455 = 8'b0;
        case({wr0_word_we24_C13[12],
            wr1_word_we24_C13[12],
            wr2_word_we24_C15[12],
            wr3_word_we24_C14[12]}) 
/* synopsys full_case */
            4'b1000: xtmux_1455 = wr0_data_C13[103:96];
            4'b0100: xtmux_1455 = wr1_data_C13[103:96];
            4'b0010: xtmux_1455 = wr2_data_C15[103:96];
            4'b0001: xtmux_1455 = wr3_data_C14[103:96];
        endcase
    end
    assign wmux24[103:96] = xtmux_1455;

    reg [7:0] xtmux_1456;
    always @(*) begin
        xtmux_1456 = 8'b0;
        case({wr0_word_we24_C13[13],
            wr1_word_we24_C13[13],
            wr2_word_we24_C15[13],
            wr3_word_we24_C14[13]}) 
/* synopsys full_case */
            4'b1000: xtmux_1456 = wr0_data_C13[111:104];
            4'b0100: xtmux_1456 = wr1_data_C13[111:104];
            4'b0010: xtmux_1456 = wr2_data_C15[111:104];
            4'b0001: xtmux_1456 = wr3_data_C14[111:104];
        endcase
    end
    assign wmux24[111:104] = xtmux_1456;

    reg [7:0] xtmux_1457;
    always @(*) begin
        xtmux_1457 = 8'b0;
        case({wr0_word_we24_C13[14],
            wr1_word_we24_C13[14],
            wr2_word_we24_C15[14],
            wr3_word_we24_C14[14]}) 
/* synopsys full_case */
            4'b1000: xtmux_1457 = wr0_data_C13[119:112];
            4'b0100: xtmux_1457 = wr1_data_C13[119:112];
            4'b0010: xtmux_1457 = wr2_data_C15[119:112];
            4'b0001: xtmux_1457 = wr3_data_C14[119:112];
        endcase
    end
    assign wmux24[119:112] = xtmux_1457;

    reg [7:0] xtmux_1458;
    always @(*) begin
        xtmux_1458 = 8'b0;
        case({wr0_word_we24_C13[15],
            wr1_word_we24_C13[15],
            wr2_word_we24_C15[15],
            wr3_word_we24_C14[15]}) 
/* synopsys full_case */
            4'b1000: xtmux_1458 = wr0_data_C13[127:120];
            4'b0100: xtmux_1458 = wr1_data_C13[127:120];
            4'b0010: xtmux_1458 = wr2_data_C15[127:120];
            4'b0001: xtmux_1458 = wr3_data_C14[127:120];
        endcase
    end
    assign wmux24[127:120] = xtmux_1458;

    wire [127:0] word24;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word24_p0;
    assign word24[7:0] = XACC_reg_word24_p0;
    always @(posedge clk or posedge localReset)
        XACC_reg_word24_p0 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk24_0) ? wmux24[7:0] : XACC_reg_word24_p0;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word24_p1;
    assign word24[15:8] = XACC_reg_word24_p1;
    always @(posedge clk or posedge localReset)
        XACC_reg_word24_p1 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk24_1) ? wmux24[15:8] : XACC_reg_word24_p1;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word24_p2;
    assign word24[23:16] = XACC_reg_word24_p2;
    always @(posedge clk or posedge localReset)
        XACC_reg_word24_p2 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk24_2) ? wmux24[23:16] : XACC_reg_word24_p2;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word24_p3;
    assign word24[31:24] = XACC_reg_word24_p3;
    always @(posedge clk or posedge localReset)
        XACC_reg_word24_p3 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk24_3) ? wmux24[31:24] : XACC_reg_word24_p3;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word24_p4;
    assign word24[39:32] = XACC_reg_word24_p4;
    always @(posedge clk or posedge localReset)
        XACC_reg_word24_p4 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk24_4) ? wmux24[39:32] : XACC_reg_word24_p4;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word24_p5;
    assign word24[47:40] = XACC_reg_word24_p5;
    always @(posedge clk or posedge localReset)
        XACC_reg_word24_p5 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk24_5) ? wmux24[47:40] : XACC_reg_word24_p5;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word24_p6;
    assign word24[55:48] = XACC_reg_word24_p6;
    always @(posedge clk or posedge localReset)
        XACC_reg_word24_p6 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk24_6) ? wmux24[55:48] : XACC_reg_word24_p6;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word24_p7;
    assign word24[63:56] = XACC_reg_word24_p7;
    always @(posedge clk or posedge localReset)
        XACC_reg_word24_p7 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk24_7) ? wmux24[63:56] : XACC_reg_word24_p7;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word24_p8;
    assign word24[71:64] = XACC_reg_word24_p8;
    always @(posedge clk or posedge localReset)
        XACC_reg_word24_p8 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk24_8) ? wmux24[71:64] : XACC_reg_word24_p8;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word24_p9;
    assign word24[79:72] = XACC_reg_word24_p9;
    always @(posedge clk or posedge localReset)
        XACC_reg_word24_p9 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk24_9) ? wmux24[79:72] : XACC_reg_word24_p9;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word24_p10;
    assign word24[87:80] = XACC_reg_word24_p10;
    always @(posedge clk or posedge localReset)
        XACC_reg_word24_p10 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk24_10) ? wmux24[87:80] : XACC_reg_word24_p10;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word24_p11;
    assign word24[95:88] = XACC_reg_word24_p11;
    always @(posedge clk or posedge localReset)
        XACC_reg_word24_p11 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk24_11) ? wmux24[95:88] : XACC_reg_word24_p11;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word24_p12;
    assign word24[103:96] = XACC_reg_word24_p12;
    always @(posedge clk or posedge localReset)
        XACC_reg_word24_p12 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk24_12) ? wmux24[103:96] : XACC_reg_word24_p12;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word24_p13;
    assign word24[111:104] = XACC_reg_word24_p13;
    always @(posedge clk or posedge localReset)
        XACC_reg_word24_p13 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk24_13) ? wmux24[111:104] : XACC_reg_word24_p13;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word24_p14;
    assign word24[119:112] = XACC_reg_word24_p14;
    always @(posedge clk or posedge localReset)
        XACC_reg_word24_p14 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk24_14) ? wmux24[119:112] : XACC_reg_word24_p14;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word24_p15;
    assign word24[127:120] = XACC_reg_word24_p15;
    always @(posedge clk or posedge localReset)
        XACC_reg_word24_p15 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk24_15) ? wmux24[127:120] : XACC_reg_word24_p15;

    wire [15:0] wr0_word_we25_C13 = wr0_we_C13 & {16{(wr0_addr_C13 == 5'd25)}};
    wire [15:0] wr1_word_we25_C13 = wr1_we_C13 & {16{(wr1_addr_C13 == 5'd25)}};
    wire [15:0] wr2_word_we25_C15 = wr2_we_C15 & {16{(wr2_addr_C15 == 5'd25)}};
    wire [15:0] wr3_word_we25_C14 = wr3_we_C14 & {16{(wr3_addr_C14 == 5'd25)}};
    wire [15:0] word25_we = 16'b0 | wr0_word_we25_C13 | wr1_word_we25_C13 | wr2_word_we25_C15 | wr3_word_we25_C14;
    wire gclk25_0;
assign gclk25_0 = word25_we[0];
    wire gclk25_1;
assign gclk25_1 = word25_we[1];
    wire gclk25_2;
assign gclk25_2 = word25_we[2];
    wire gclk25_3;
assign gclk25_3 = word25_we[3];
    wire gclk25_4;
assign gclk25_4 = word25_we[4];
    wire gclk25_5;
assign gclk25_5 = word25_we[5];
    wire gclk25_6;
assign gclk25_6 = word25_we[6];
    wire gclk25_7;
assign gclk25_7 = word25_we[7];
    wire gclk25_8;
assign gclk25_8 = word25_we[8];
    wire gclk25_9;
assign gclk25_9 = word25_we[9];
    wire gclk25_10;
assign gclk25_10 = word25_we[10];
    wire gclk25_11;
assign gclk25_11 = word25_we[11];
    wire gclk25_12;
assign gclk25_12 = word25_we[12];
    wire gclk25_13;
assign gclk25_13 = word25_we[13];
    wire gclk25_14;
assign gclk25_14 = word25_we[14];
    wire gclk25_15;
assign gclk25_15 = word25_we[15];
    wire [127:0] wmux25;
    reg [7:0] xtmux_1459;
    always @(*) begin
        xtmux_1459 = 8'b0;
        case({wr0_word_we25_C13[0],
            wr1_word_we25_C13[0],
            wr2_word_we25_C15[0],
            wr3_word_we25_C14[0]}) 
/* synopsys full_case */
            4'b1000: xtmux_1459 = wr0_data_C13[7:0];
            4'b0100: xtmux_1459 = wr1_data_C13[7:0];
            4'b0010: xtmux_1459 = wr2_data_C15[7:0];
            4'b0001: xtmux_1459 = wr3_data_C14[7:0];
        endcase
    end
    assign wmux25[7:0] = xtmux_1459;

    reg [7:0] xtmux_1460;
    always @(*) begin
        xtmux_1460 = 8'b0;
        case({wr0_word_we25_C13[1],
            wr1_word_we25_C13[1],
            wr2_word_we25_C15[1],
            wr3_word_we25_C14[1]}) 
/* synopsys full_case */
            4'b1000: xtmux_1460 = wr0_data_C13[15:8];
            4'b0100: xtmux_1460 = wr1_data_C13[15:8];
            4'b0010: xtmux_1460 = wr2_data_C15[15:8];
            4'b0001: xtmux_1460 = wr3_data_C14[15:8];
        endcase
    end
    assign wmux25[15:8] = xtmux_1460;

    reg [7:0] xtmux_1461;
    always @(*) begin
        xtmux_1461 = 8'b0;
        case({wr0_word_we25_C13[2],
            wr1_word_we25_C13[2],
            wr2_word_we25_C15[2],
            wr3_word_we25_C14[2]}) 
/* synopsys full_case */
            4'b1000: xtmux_1461 = wr0_data_C13[23:16];
            4'b0100: xtmux_1461 = wr1_data_C13[23:16];
            4'b0010: xtmux_1461 = wr2_data_C15[23:16];
            4'b0001: xtmux_1461 = wr3_data_C14[23:16];
        endcase
    end
    assign wmux25[23:16] = xtmux_1461;

    reg [7:0] xtmux_1462;
    always @(*) begin
        xtmux_1462 = 8'b0;
        case({wr0_word_we25_C13[3],
            wr1_word_we25_C13[3],
            wr2_word_we25_C15[3],
            wr3_word_we25_C14[3]}) 
/* synopsys full_case */
            4'b1000: xtmux_1462 = wr0_data_C13[31:24];
            4'b0100: xtmux_1462 = wr1_data_C13[31:24];
            4'b0010: xtmux_1462 = wr2_data_C15[31:24];
            4'b0001: xtmux_1462 = wr3_data_C14[31:24];
        endcase
    end
    assign wmux25[31:24] = xtmux_1462;

    reg [7:0] xtmux_1463;
    always @(*) begin
        xtmux_1463 = 8'b0;
        case({wr0_word_we25_C13[4],
            wr1_word_we25_C13[4],
            wr2_word_we25_C15[4],
            wr3_word_we25_C14[4]}) 
/* synopsys full_case */
            4'b1000: xtmux_1463 = wr0_data_C13[39:32];
            4'b0100: xtmux_1463 = wr1_data_C13[39:32];
            4'b0010: xtmux_1463 = wr2_data_C15[39:32];
            4'b0001: xtmux_1463 = wr3_data_C14[39:32];
        endcase
    end
    assign wmux25[39:32] = xtmux_1463;

    reg [7:0] xtmux_1464;
    always @(*) begin
        xtmux_1464 = 8'b0;
        case({wr0_word_we25_C13[5],
            wr1_word_we25_C13[5],
            wr2_word_we25_C15[5],
            wr3_word_we25_C14[5]}) 
/* synopsys full_case */
            4'b1000: xtmux_1464 = wr0_data_C13[47:40];
            4'b0100: xtmux_1464 = wr1_data_C13[47:40];
            4'b0010: xtmux_1464 = wr2_data_C15[47:40];
            4'b0001: xtmux_1464 = wr3_data_C14[47:40];
        endcase
    end
    assign wmux25[47:40] = xtmux_1464;

    reg [7:0] xtmux_1465;
    always @(*) begin
        xtmux_1465 = 8'b0;
        case({wr0_word_we25_C13[6],
            wr1_word_we25_C13[6],
            wr2_word_we25_C15[6],
            wr3_word_we25_C14[6]}) 
/* synopsys full_case */
            4'b1000: xtmux_1465 = wr0_data_C13[55:48];
            4'b0100: xtmux_1465 = wr1_data_C13[55:48];
            4'b0010: xtmux_1465 = wr2_data_C15[55:48];
            4'b0001: xtmux_1465 = wr3_data_C14[55:48];
        endcase
    end
    assign wmux25[55:48] = xtmux_1465;

    reg [7:0] xtmux_1466;
    always @(*) begin
        xtmux_1466 = 8'b0;
        case({wr0_word_we25_C13[7],
            wr1_word_we25_C13[7],
            wr2_word_we25_C15[7],
            wr3_word_we25_C14[7]}) 
/* synopsys full_case */
            4'b1000: xtmux_1466 = wr0_data_C13[63:56];
            4'b0100: xtmux_1466 = wr1_data_C13[63:56];
            4'b0010: xtmux_1466 = wr2_data_C15[63:56];
            4'b0001: xtmux_1466 = wr3_data_C14[63:56];
        endcase
    end
    assign wmux25[63:56] = xtmux_1466;

    reg [7:0] xtmux_1467;
    always @(*) begin
        xtmux_1467 = 8'b0;
        case({wr0_word_we25_C13[8],
            wr1_word_we25_C13[8],
            wr2_word_we25_C15[8],
            wr3_word_we25_C14[8]}) 
/* synopsys full_case */
            4'b1000: xtmux_1467 = wr0_data_C13[71:64];
            4'b0100: xtmux_1467 = wr1_data_C13[71:64];
            4'b0010: xtmux_1467 = wr2_data_C15[71:64];
            4'b0001: xtmux_1467 = wr3_data_C14[71:64];
        endcase
    end
    assign wmux25[71:64] = xtmux_1467;

    reg [7:0] xtmux_1468;
    always @(*) begin
        xtmux_1468 = 8'b0;
        case({wr0_word_we25_C13[9],
            wr1_word_we25_C13[9],
            wr2_word_we25_C15[9],
            wr3_word_we25_C14[9]}) 
/* synopsys full_case */
            4'b1000: xtmux_1468 = wr0_data_C13[79:72];
            4'b0100: xtmux_1468 = wr1_data_C13[79:72];
            4'b0010: xtmux_1468 = wr2_data_C15[79:72];
            4'b0001: xtmux_1468 = wr3_data_C14[79:72];
        endcase
    end
    assign wmux25[79:72] = xtmux_1468;

    reg [7:0] xtmux_1469;
    always @(*) begin
        xtmux_1469 = 8'b0;
        case({wr0_word_we25_C13[10],
            wr1_word_we25_C13[10],
            wr2_word_we25_C15[10],
            wr3_word_we25_C14[10]}) 
/* synopsys full_case */
            4'b1000: xtmux_1469 = wr0_data_C13[87:80];
            4'b0100: xtmux_1469 = wr1_data_C13[87:80];
            4'b0010: xtmux_1469 = wr2_data_C15[87:80];
            4'b0001: xtmux_1469 = wr3_data_C14[87:80];
        endcase
    end
    assign wmux25[87:80] = xtmux_1469;

    reg [7:0] xtmux_1470;
    always @(*) begin
        xtmux_1470 = 8'b0;
        case({wr0_word_we25_C13[11],
            wr1_word_we25_C13[11],
            wr2_word_we25_C15[11],
            wr3_word_we25_C14[11]}) 
/* synopsys full_case */
            4'b1000: xtmux_1470 = wr0_data_C13[95:88];
            4'b0100: xtmux_1470 = wr1_data_C13[95:88];
            4'b0010: xtmux_1470 = wr2_data_C15[95:88];
            4'b0001: xtmux_1470 = wr3_data_C14[95:88];
        endcase
    end
    assign wmux25[95:88] = xtmux_1470;

    reg [7:0] xtmux_1471;
    always @(*) begin
        xtmux_1471 = 8'b0;
        case({wr0_word_we25_C13[12],
            wr1_word_we25_C13[12],
            wr2_word_we25_C15[12],
            wr3_word_we25_C14[12]}) 
/* synopsys full_case */
            4'b1000: xtmux_1471 = wr0_data_C13[103:96];
            4'b0100: xtmux_1471 = wr1_data_C13[103:96];
            4'b0010: xtmux_1471 = wr2_data_C15[103:96];
            4'b0001: xtmux_1471 = wr3_data_C14[103:96];
        endcase
    end
    assign wmux25[103:96] = xtmux_1471;

    reg [7:0] xtmux_1472;
    always @(*) begin
        xtmux_1472 = 8'b0;
        case({wr0_word_we25_C13[13],
            wr1_word_we25_C13[13],
            wr2_word_we25_C15[13],
            wr3_word_we25_C14[13]}) 
/* synopsys full_case */
            4'b1000: xtmux_1472 = wr0_data_C13[111:104];
            4'b0100: xtmux_1472 = wr1_data_C13[111:104];
            4'b0010: xtmux_1472 = wr2_data_C15[111:104];
            4'b0001: xtmux_1472 = wr3_data_C14[111:104];
        endcase
    end
    assign wmux25[111:104] = xtmux_1472;

    reg [7:0] xtmux_1473;
    always @(*) begin
        xtmux_1473 = 8'b0;
        case({wr0_word_we25_C13[14],
            wr1_word_we25_C13[14],
            wr2_word_we25_C15[14],
            wr3_word_we25_C14[14]}) 
/* synopsys full_case */
            4'b1000: xtmux_1473 = wr0_data_C13[119:112];
            4'b0100: xtmux_1473 = wr1_data_C13[119:112];
            4'b0010: xtmux_1473 = wr2_data_C15[119:112];
            4'b0001: xtmux_1473 = wr3_data_C14[119:112];
        endcase
    end
    assign wmux25[119:112] = xtmux_1473;

    reg [7:0] xtmux_1474;
    always @(*) begin
        xtmux_1474 = 8'b0;
        case({wr0_word_we25_C13[15],
            wr1_word_we25_C13[15],
            wr2_word_we25_C15[15],
            wr3_word_we25_C14[15]}) 
/* synopsys full_case */
            4'b1000: xtmux_1474 = wr0_data_C13[127:120];
            4'b0100: xtmux_1474 = wr1_data_C13[127:120];
            4'b0010: xtmux_1474 = wr2_data_C15[127:120];
            4'b0001: xtmux_1474 = wr3_data_C14[127:120];
        endcase
    end
    assign wmux25[127:120] = xtmux_1474;

    wire [127:0] word25;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word25_p0;
    assign word25[7:0] = XACC_reg_word25_p0;
    always @(posedge clk or posedge localReset)
        XACC_reg_word25_p0 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk25_0) ? wmux25[7:0] : XACC_reg_word25_p0;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word25_p1;
    assign word25[15:8] = XACC_reg_word25_p1;
    always @(posedge clk or posedge localReset)
        XACC_reg_word25_p1 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk25_1) ? wmux25[15:8] : XACC_reg_word25_p1;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word25_p2;
    assign word25[23:16] = XACC_reg_word25_p2;
    always @(posedge clk or posedge localReset)
        XACC_reg_word25_p2 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk25_2) ? wmux25[23:16] : XACC_reg_word25_p2;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word25_p3;
    assign word25[31:24] = XACC_reg_word25_p3;
    always @(posedge clk or posedge localReset)
        XACC_reg_word25_p3 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk25_3) ? wmux25[31:24] : XACC_reg_word25_p3;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word25_p4;
    assign word25[39:32] = XACC_reg_word25_p4;
    always @(posedge clk or posedge localReset)
        XACC_reg_word25_p4 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk25_4) ? wmux25[39:32] : XACC_reg_word25_p4;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word25_p5;
    assign word25[47:40] = XACC_reg_word25_p5;
    always @(posedge clk or posedge localReset)
        XACC_reg_word25_p5 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk25_5) ? wmux25[47:40] : XACC_reg_word25_p5;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word25_p6;
    assign word25[55:48] = XACC_reg_word25_p6;
    always @(posedge clk or posedge localReset)
        XACC_reg_word25_p6 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk25_6) ? wmux25[55:48] : XACC_reg_word25_p6;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word25_p7;
    assign word25[63:56] = XACC_reg_word25_p7;
    always @(posedge clk or posedge localReset)
        XACC_reg_word25_p7 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk25_7) ? wmux25[63:56] : XACC_reg_word25_p7;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word25_p8;
    assign word25[71:64] = XACC_reg_word25_p8;
    always @(posedge clk or posedge localReset)
        XACC_reg_word25_p8 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk25_8) ? wmux25[71:64] : XACC_reg_word25_p8;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word25_p9;
    assign word25[79:72] = XACC_reg_word25_p9;
    always @(posedge clk or posedge localReset)
        XACC_reg_word25_p9 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk25_9) ? wmux25[79:72] : XACC_reg_word25_p9;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word25_p10;
    assign word25[87:80] = XACC_reg_word25_p10;
    always @(posedge clk or posedge localReset)
        XACC_reg_word25_p10 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk25_10) ? wmux25[87:80] : XACC_reg_word25_p10;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word25_p11;
    assign word25[95:88] = XACC_reg_word25_p11;
    always @(posedge clk or posedge localReset)
        XACC_reg_word25_p11 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk25_11) ? wmux25[95:88] : XACC_reg_word25_p11;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word25_p12;
    assign word25[103:96] = XACC_reg_word25_p12;
    always @(posedge clk or posedge localReset)
        XACC_reg_word25_p12 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk25_12) ? wmux25[103:96] : XACC_reg_word25_p12;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word25_p13;
    assign word25[111:104] = XACC_reg_word25_p13;
    always @(posedge clk or posedge localReset)
        XACC_reg_word25_p13 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk25_13) ? wmux25[111:104] : XACC_reg_word25_p13;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word25_p14;
    assign word25[119:112] = XACC_reg_word25_p14;
    always @(posedge clk or posedge localReset)
        XACC_reg_word25_p14 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk25_14) ? wmux25[119:112] : XACC_reg_word25_p14;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word25_p15;
    assign word25[127:120] = XACC_reg_word25_p15;
    always @(posedge clk or posedge localReset)
        XACC_reg_word25_p15 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk25_15) ? wmux25[127:120] : XACC_reg_word25_p15;

    wire [15:0] wr0_word_we26_C13 = wr0_we_C13 & {16{(wr0_addr_C13 == 5'd26)}};
    wire [15:0] wr1_word_we26_C13 = wr1_we_C13 & {16{(wr1_addr_C13 == 5'd26)}};
    wire [15:0] wr2_word_we26_C15 = wr2_we_C15 & {16{(wr2_addr_C15 == 5'd26)}};
    wire [15:0] wr3_word_we26_C14 = wr3_we_C14 & {16{(wr3_addr_C14 == 5'd26)}};
    wire [15:0] word26_we = 16'b0 | wr0_word_we26_C13 | wr1_word_we26_C13 | wr2_word_we26_C15 | wr3_word_we26_C14;
    wire gclk26_0;
assign gclk26_0 = word26_we[0];
    wire gclk26_1;
assign gclk26_1 = word26_we[1];
    wire gclk26_2;
assign gclk26_2 = word26_we[2];
    wire gclk26_3;
assign gclk26_3 = word26_we[3];
    wire gclk26_4;
assign gclk26_4 = word26_we[4];
    wire gclk26_5;
assign gclk26_5 = word26_we[5];
    wire gclk26_6;
assign gclk26_6 = word26_we[6];
    wire gclk26_7;
assign gclk26_7 = word26_we[7];
    wire gclk26_8;
assign gclk26_8 = word26_we[8];
    wire gclk26_9;
assign gclk26_9 = word26_we[9];
    wire gclk26_10;
assign gclk26_10 = word26_we[10];
    wire gclk26_11;
assign gclk26_11 = word26_we[11];
    wire gclk26_12;
assign gclk26_12 = word26_we[12];
    wire gclk26_13;
assign gclk26_13 = word26_we[13];
    wire gclk26_14;
assign gclk26_14 = word26_we[14];
    wire gclk26_15;
assign gclk26_15 = word26_we[15];
    wire [127:0] wmux26;
    reg [7:0] xtmux_1475;
    always @(*) begin
        xtmux_1475 = 8'b0;
        case({wr0_word_we26_C13[0],
            wr1_word_we26_C13[0],
            wr2_word_we26_C15[0],
            wr3_word_we26_C14[0]}) 
/* synopsys full_case */
            4'b1000: xtmux_1475 = wr0_data_C13[7:0];
            4'b0100: xtmux_1475 = wr1_data_C13[7:0];
            4'b0010: xtmux_1475 = wr2_data_C15[7:0];
            4'b0001: xtmux_1475 = wr3_data_C14[7:0];
        endcase
    end
    assign wmux26[7:0] = xtmux_1475;

    reg [7:0] xtmux_1476;
    always @(*) begin
        xtmux_1476 = 8'b0;
        case({wr0_word_we26_C13[1],
            wr1_word_we26_C13[1],
            wr2_word_we26_C15[1],
            wr3_word_we26_C14[1]}) 
/* synopsys full_case */
            4'b1000: xtmux_1476 = wr0_data_C13[15:8];
            4'b0100: xtmux_1476 = wr1_data_C13[15:8];
            4'b0010: xtmux_1476 = wr2_data_C15[15:8];
            4'b0001: xtmux_1476 = wr3_data_C14[15:8];
        endcase
    end
    assign wmux26[15:8] = xtmux_1476;

    reg [7:0] xtmux_1477;
    always @(*) begin
        xtmux_1477 = 8'b0;
        case({wr0_word_we26_C13[2],
            wr1_word_we26_C13[2],
            wr2_word_we26_C15[2],
            wr3_word_we26_C14[2]}) 
/* synopsys full_case */
            4'b1000: xtmux_1477 = wr0_data_C13[23:16];
            4'b0100: xtmux_1477 = wr1_data_C13[23:16];
            4'b0010: xtmux_1477 = wr2_data_C15[23:16];
            4'b0001: xtmux_1477 = wr3_data_C14[23:16];
        endcase
    end
    assign wmux26[23:16] = xtmux_1477;

    reg [7:0] xtmux_1478;
    always @(*) begin
        xtmux_1478 = 8'b0;
        case({wr0_word_we26_C13[3],
            wr1_word_we26_C13[3],
            wr2_word_we26_C15[3],
            wr3_word_we26_C14[3]}) 
/* synopsys full_case */
            4'b1000: xtmux_1478 = wr0_data_C13[31:24];
            4'b0100: xtmux_1478 = wr1_data_C13[31:24];
            4'b0010: xtmux_1478 = wr2_data_C15[31:24];
            4'b0001: xtmux_1478 = wr3_data_C14[31:24];
        endcase
    end
    assign wmux26[31:24] = xtmux_1478;

    reg [7:0] xtmux_1479;
    always @(*) begin
        xtmux_1479 = 8'b0;
        case({wr0_word_we26_C13[4],
            wr1_word_we26_C13[4],
            wr2_word_we26_C15[4],
            wr3_word_we26_C14[4]}) 
/* synopsys full_case */
            4'b1000: xtmux_1479 = wr0_data_C13[39:32];
            4'b0100: xtmux_1479 = wr1_data_C13[39:32];
            4'b0010: xtmux_1479 = wr2_data_C15[39:32];
            4'b0001: xtmux_1479 = wr3_data_C14[39:32];
        endcase
    end
    assign wmux26[39:32] = xtmux_1479;

    reg [7:0] xtmux_1480;
    always @(*) begin
        xtmux_1480 = 8'b0;
        case({wr0_word_we26_C13[5],
            wr1_word_we26_C13[5],
            wr2_word_we26_C15[5],
            wr3_word_we26_C14[5]}) 
/* synopsys full_case */
            4'b1000: xtmux_1480 = wr0_data_C13[47:40];
            4'b0100: xtmux_1480 = wr1_data_C13[47:40];
            4'b0010: xtmux_1480 = wr2_data_C15[47:40];
            4'b0001: xtmux_1480 = wr3_data_C14[47:40];
        endcase
    end
    assign wmux26[47:40] = xtmux_1480;

    reg [7:0] xtmux_1481;
    always @(*) begin
        xtmux_1481 = 8'b0;
        case({wr0_word_we26_C13[6],
            wr1_word_we26_C13[6],
            wr2_word_we26_C15[6],
            wr3_word_we26_C14[6]}) 
/* synopsys full_case */
            4'b1000: xtmux_1481 = wr0_data_C13[55:48];
            4'b0100: xtmux_1481 = wr1_data_C13[55:48];
            4'b0010: xtmux_1481 = wr2_data_C15[55:48];
            4'b0001: xtmux_1481 = wr3_data_C14[55:48];
        endcase
    end
    assign wmux26[55:48] = xtmux_1481;

    reg [7:0] xtmux_1482;
    always @(*) begin
        xtmux_1482 = 8'b0;
        case({wr0_word_we26_C13[7],
            wr1_word_we26_C13[7],
            wr2_word_we26_C15[7],
            wr3_word_we26_C14[7]}) 
/* synopsys full_case */
            4'b1000: xtmux_1482 = wr0_data_C13[63:56];
            4'b0100: xtmux_1482 = wr1_data_C13[63:56];
            4'b0010: xtmux_1482 = wr2_data_C15[63:56];
            4'b0001: xtmux_1482 = wr3_data_C14[63:56];
        endcase
    end
    assign wmux26[63:56] = xtmux_1482;

    reg [7:0] xtmux_1483;
    always @(*) begin
        xtmux_1483 = 8'b0;
        case({wr0_word_we26_C13[8],
            wr1_word_we26_C13[8],
            wr2_word_we26_C15[8],
            wr3_word_we26_C14[8]}) 
/* synopsys full_case */
            4'b1000: xtmux_1483 = wr0_data_C13[71:64];
            4'b0100: xtmux_1483 = wr1_data_C13[71:64];
            4'b0010: xtmux_1483 = wr2_data_C15[71:64];
            4'b0001: xtmux_1483 = wr3_data_C14[71:64];
        endcase
    end
    assign wmux26[71:64] = xtmux_1483;

    reg [7:0] xtmux_1484;
    always @(*) begin
        xtmux_1484 = 8'b0;
        case({wr0_word_we26_C13[9],
            wr1_word_we26_C13[9],
            wr2_word_we26_C15[9],
            wr3_word_we26_C14[9]}) 
/* synopsys full_case */
            4'b1000: xtmux_1484 = wr0_data_C13[79:72];
            4'b0100: xtmux_1484 = wr1_data_C13[79:72];
            4'b0010: xtmux_1484 = wr2_data_C15[79:72];
            4'b0001: xtmux_1484 = wr3_data_C14[79:72];
        endcase
    end
    assign wmux26[79:72] = xtmux_1484;

    reg [7:0] xtmux_1485;
    always @(*) begin
        xtmux_1485 = 8'b0;
        case({wr0_word_we26_C13[10],
            wr1_word_we26_C13[10],
            wr2_word_we26_C15[10],
            wr3_word_we26_C14[10]}) 
/* synopsys full_case */
            4'b1000: xtmux_1485 = wr0_data_C13[87:80];
            4'b0100: xtmux_1485 = wr1_data_C13[87:80];
            4'b0010: xtmux_1485 = wr2_data_C15[87:80];
            4'b0001: xtmux_1485 = wr3_data_C14[87:80];
        endcase
    end
    assign wmux26[87:80] = xtmux_1485;

    reg [7:0] xtmux_1486;
    always @(*) begin
        xtmux_1486 = 8'b0;
        case({wr0_word_we26_C13[11],
            wr1_word_we26_C13[11],
            wr2_word_we26_C15[11],
            wr3_word_we26_C14[11]}) 
/* synopsys full_case */
            4'b1000: xtmux_1486 = wr0_data_C13[95:88];
            4'b0100: xtmux_1486 = wr1_data_C13[95:88];
            4'b0010: xtmux_1486 = wr2_data_C15[95:88];
            4'b0001: xtmux_1486 = wr3_data_C14[95:88];
        endcase
    end
    assign wmux26[95:88] = xtmux_1486;

    reg [7:0] xtmux_1487;
    always @(*) begin
        xtmux_1487 = 8'b0;
        case({wr0_word_we26_C13[12],
            wr1_word_we26_C13[12],
            wr2_word_we26_C15[12],
            wr3_word_we26_C14[12]}) 
/* synopsys full_case */
            4'b1000: xtmux_1487 = wr0_data_C13[103:96];
            4'b0100: xtmux_1487 = wr1_data_C13[103:96];
            4'b0010: xtmux_1487 = wr2_data_C15[103:96];
            4'b0001: xtmux_1487 = wr3_data_C14[103:96];
        endcase
    end
    assign wmux26[103:96] = xtmux_1487;

    reg [7:0] xtmux_1488;
    always @(*) begin
        xtmux_1488 = 8'b0;
        case({wr0_word_we26_C13[13],
            wr1_word_we26_C13[13],
            wr2_word_we26_C15[13],
            wr3_word_we26_C14[13]}) 
/* synopsys full_case */
            4'b1000: xtmux_1488 = wr0_data_C13[111:104];
            4'b0100: xtmux_1488 = wr1_data_C13[111:104];
            4'b0010: xtmux_1488 = wr2_data_C15[111:104];
            4'b0001: xtmux_1488 = wr3_data_C14[111:104];
        endcase
    end
    assign wmux26[111:104] = xtmux_1488;

    reg [7:0] xtmux_1489;
    always @(*) begin
        xtmux_1489 = 8'b0;
        case({wr0_word_we26_C13[14],
            wr1_word_we26_C13[14],
            wr2_word_we26_C15[14],
            wr3_word_we26_C14[14]}) 
/* synopsys full_case */
            4'b1000: xtmux_1489 = wr0_data_C13[119:112];
            4'b0100: xtmux_1489 = wr1_data_C13[119:112];
            4'b0010: xtmux_1489 = wr2_data_C15[119:112];
            4'b0001: xtmux_1489 = wr3_data_C14[119:112];
        endcase
    end
    assign wmux26[119:112] = xtmux_1489;

    reg [7:0] xtmux_1490;
    always @(*) begin
        xtmux_1490 = 8'b0;
        case({wr0_word_we26_C13[15],
            wr1_word_we26_C13[15],
            wr2_word_we26_C15[15],
            wr3_word_we26_C14[15]}) 
/* synopsys full_case */
            4'b1000: xtmux_1490 = wr0_data_C13[127:120];
            4'b0100: xtmux_1490 = wr1_data_C13[127:120];
            4'b0010: xtmux_1490 = wr2_data_C15[127:120];
            4'b0001: xtmux_1490 = wr3_data_C14[127:120];
        endcase
    end
    assign wmux26[127:120] = xtmux_1490;

    wire [127:0] word26;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word26_p0;
    assign word26[7:0] = XACC_reg_word26_p0;
    always @(posedge clk or posedge localReset)
        XACC_reg_word26_p0 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk26_0) ? wmux26[7:0] : XACC_reg_word26_p0;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word26_p1;
    assign word26[15:8] = XACC_reg_word26_p1;
    always @(posedge clk or posedge localReset)
        XACC_reg_word26_p1 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk26_1) ? wmux26[15:8] : XACC_reg_word26_p1;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word26_p2;
    assign word26[23:16] = XACC_reg_word26_p2;
    always @(posedge clk or posedge localReset)
        XACC_reg_word26_p2 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk26_2) ? wmux26[23:16] : XACC_reg_word26_p2;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word26_p3;
    assign word26[31:24] = XACC_reg_word26_p3;
    always @(posedge clk or posedge localReset)
        XACC_reg_word26_p3 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk26_3) ? wmux26[31:24] : XACC_reg_word26_p3;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word26_p4;
    assign word26[39:32] = XACC_reg_word26_p4;
    always @(posedge clk or posedge localReset)
        XACC_reg_word26_p4 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk26_4) ? wmux26[39:32] : XACC_reg_word26_p4;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word26_p5;
    assign word26[47:40] = XACC_reg_word26_p5;
    always @(posedge clk or posedge localReset)
        XACC_reg_word26_p5 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk26_5) ? wmux26[47:40] : XACC_reg_word26_p5;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word26_p6;
    assign word26[55:48] = XACC_reg_word26_p6;
    always @(posedge clk or posedge localReset)
        XACC_reg_word26_p6 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk26_6) ? wmux26[55:48] : XACC_reg_word26_p6;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word26_p7;
    assign word26[63:56] = XACC_reg_word26_p7;
    always @(posedge clk or posedge localReset)
        XACC_reg_word26_p7 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk26_7) ? wmux26[63:56] : XACC_reg_word26_p7;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word26_p8;
    assign word26[71:64] = XACC_reg_word26_p8;
    always @(posedge clk or posedge localReset)
        XACC_reg_word26_p8 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk26_8) ? wmux26[71:64] : XACC_reg_word26_p8;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word26_p9;
    assign word26[79:72] = XACC_reg_word26_p9;
    always @(posedge clk or posedge localReset)
        XACC_reg_word26_p9 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk26_9) ? wmux26[79:72] : XACC_reg_word26_p9;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word26_p10;
    assign word26[87:80] = XACC_reg_word26_p10;
    always @(posedge clk or posedge localReset)
        XACC_reg_word26_p10 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk26_10) ? wmux26[87:80] : XACC_reg_word26_p10;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word26_p11;
    assign word26[95:88] = XACC_reg_word26_p11;
    always @(posedge clk or posedge localReset)
        XACC_reg_word26_p11 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk26_11) ? wmux26[95:88] : XACC_reg_word26_p11;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word26_p12;
    assign word26[103:96] = XACC_reg_word26_p12;
    always @(posedge clk or posedge localReset)
        XACC_reg_word26_p12 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk26_12) ? wmux26[103:96] : XACC_reg_word26_p12;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word26_p13;
    assign word26[111:104] = XACC_reg_word26_p13;
    always @(posedge clk or posedge localReset)
        XACC_reg_word26_p13 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk26_13) ? wmux26[111:104] : XACC_reg_word26_p13;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word26_p14;
    assign word26[119:112] = XACC_reg_word26_p14;
    always @(posedge clk or posedge localReset)
        XACC_reg_word26_p14 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk26_14) ? wmux26[119:112] : XACC_reg_word26_p14;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word26_p15;
    assign word26[127:120] = XACC_reg_word26_p15;
    always @(posedge clk or posedge localReset)
        XACC_reg_word26_p15 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk26_15) ? wmux26[127:120] : XACC_reg_word26_p15;

    wire [15:0] wr0_word_we27_C13 = wr0_we_C13 & {16{(wr0_addr_C13 == 5'd27)}};
    wire [15:0] wr1_word_we27_C13 = wr1_we_C13 & {16{(wr1_addr_C13 == 5'd27)}};
    wire [15:0] wr2_word_we27_C15 = wr2_we_C15 & {16{(wr2_addr_C15 == 5'd27)}};
    wire [15:0] wr3_word_we27_C14 = wr3_we_C14 & {16{(wr3_addr_C14 == 5'd27)}};
    wire [15:0] word27_we = 16'b0 | wr0_word_we27_C13 | wr1_word_we27_C13 | wr2_word_we27_C15 | wr3_word_we27_C14;
    wire gclk27_0;
assign gclk27_0 = word27_we[0];
    wire gclk27_1;
assign gclk27_1 = word27_we[1];
    wire gclk27_2;
assign gclk27_2 = word27_we[2];
    wire gclk27_3;
assign gclk27_3 = word27_we[3];
    wire gclk27_4;
assign gclk27_4 = word27_we[4];
    wire gclk27_5;
assign gclk27_5 = word27_we[5];
    wire gclk27_6;
assign gclk27_6 = word27_we[6];
    wire gclk27_7;
assign gclk27_7 = word27_we[7];
    wire gclk27_8;
assign gclk27_8 = word27_we[8];
    wire gclk27_9;
assign gclk27_9 = word27_we[9];
    wire gclk27_10;
assign gclk27_10 = word27_we[10];
    wire gclk27_11;
assign gclk27_11 = word27_we[11];
    wire gclk27_12;
assign gclk27_12 = word27_we[12];
    wire gclk27_13;
assign gclk27_13 = word27_we[13];
    wire gclk27_14;
assign gclk27_14 = word27_we[14];
    wire gclk27_15;
assign gclk27_15 = word27_we[15];
    wire [127:0] wmux27;
    reg [7:0] xtmux_1491;
    always @(*) begin
        xtmux_1491 = 8'b0;
        case({wr0_word_we27_C13[0],
            wr1_word_we27_C13[0],
            wr2_word_we27_C15[0],
            wr3_word_we27_C14[0]}) 
/* synopsys full_case */
            4'b1000: xtmux_1491 = wr0_data_C13[7:0];
            4'b0100: xtmux_1491 = wr1_data_C13[7:0];
            4'b0010: xtmux_1491 = wr2_data_C15[7:0];
            4'b0001: xtmux_1491 = wr3_data_C14[7:0];
        endcase
    end
    assign wmux27[7:0] = xtmux_1491;

    reg [7:0] xtmux_1492;
    always @(*) begin
        xtmux_1492 = 8'b0;
        case({wr0_word_we27_C13[1],
            wr1_word_we27_C13[1],
            wr2_word_we27_C15[1],
            wr3_word_we27_C14[1]}) 
/* synopsys full_case */
            4'b1000: xtmux_1492 = wr0_data_C13[15:8];
            4'b0100: xtmux_1492 = wr1_data_C13[15:8];
            4'b0010: xtmux_1492 = wr2_data_C15[15:8];
            4'b0001: xtmux_1492 = wr3_data_C14[15:8];
        endcase
    end
    assign wmux27[15:8] = xtmux_1492;

    reg [7:0] xtmux_1493;
    always @(*) begin
        xtmux_1493 = 8'b0;
        case({wr0_word_we27_C13[2],
            wr1_word_we27_C13[2],
            wr2_word_we27_C15[2],
            wr3_word_we27_C14[2]}) 
/* synopsys full_case */
            4'b1000: xtmux_1493 = wr0_data_C13[23:16];
            4'b0100: xtmux_1493 = wr1_data_C13[23:16];
            4'b0010: xtmux_1493 = wr2_data_C15[23:16];
            4'b0001: xtmux_1493 = wr3_data_C14[23:16];
        endcase
    end
    assign wmux27[23:16] = xtmux_1493;

    reg [7:0] xtmux_1494;
    always @(*) begin
        xtmux_1494 = 8'b0;
        case({wr0_word_we27_C13[3],
            wr1_word_we27_C13[3],
            wr2_word_we27_C15[3],
            wr3_word_we27_C14[3]}) 
/* synopsys full_case */
            4'b1000: xtmux_1494 = wr0_data_C13[31:24];
            4'b0100: xtmux_1494 = wr1_data_C13[31:24];
            4'b0010: xtmux_1494 = wr2_data_C15[31:24];
            4'b0001: xtmux_1494 = wr3_data_C14[31:24];
        endcase
    end
    assign wmux27[31:24] = xtmux_1494;

    reg [7:0] xtmux_1495;
    always @(*) begin
        xtmux_1495 = 8'b0;
        case({wr0_word_we27_C13[4],
            wr1_word_we27_C13[4],
            wr2_word_we27_C15[4],
            wr3_word_we27_C14[4]}) 
/* synopsys full_case */
            4'b1000: xtmux_1495 = wr0_data_C13[39:32];
            4'b0100: xtmux_1495 = wr1_data_C13[39:32];
            4'b0010: xtmux_1495 = wr2_data_C15[39:32];
            4'b0001: xtmux_1495 = wr3_data_C14[39:32];
        endcase
    end
    assign wmux27[39:32] = xtmux_1495;

    reg [7:0] xtmux_1496;
    always @(*) begin
        xtmux_1496 = 8'b0;
        case({wr0_word_we27_C13[5],
            wr1_word_we27_C13[5],
            wr2_word_we27_C15[5],
            wr3_word_we27_C14[5]}) 
/* synopsys full_case */
            4'b1000: xtmux_1496 = wr0_data_C13[47:40];
            4'b0100: xtmux_1496 = wr1_data_C13[47:40];
            4'b0010: xtmux_1496 = wr2_data_C15[47:40];
            4'b0001: xtmux_1496 = wr3_data_C14[47:40];
        endcase
    end
    assign wmux27[47:40] = xtmux_1496;

    reg [7:0] xtmux_1497;
    always @(*) begin
        xtmux_1497 = 8'b0;
        case({wr0_word_we27_C13[6],
            wr1_word_we27_C13[6],
            wr2_word_we27_C15[6],
            wr3_word_we27_C14[6]}) 
/* synopsys full_case */
            4'b1000: xtmux_1497 = wr0_data_C13[55:48];
            4'b0100: xtmux_1497 = wr1_data_C13[55:48];
            4'b0010: xtmux_1497 = wr2_data_C15[55:48];
            4'b0001: xtmux_1497 = wr3_data_C14[55:48];
        endcase
    end
    assign wmux27[55:48] = xtmux_1497;

    reg [7:0] xtmux_1498;
    always @(*) begin
        xtmux_1498 = 8'b0;
        case({wr0_word_we27_C13[7],
            wr1_word_we27_C13[7],
            wr2_word_we27_C15[7],
            wr3_word_we27_C14[7]}) 
/* synopsys full_case */
            4'b1000: xtmux_1498 = wr0_data_C13[63:56];
            4'b0100: xtmux_1498 = wr1_data_C13[63:56];
            4'b0010: xtmux_1498 = wr2_data_C15[63:56];
            4'b0001: xtmux_1498 = wr3_data_C14[63:56];
        endcase
    end
    assign wmux27[63:56] = xtmux_1498;

    reg [7:0] xtmux_1499;
    always @(*) begin
        xtmux_1499 = 8'b0;
        case({wr0_word_we27_C13[8],
            wr1_word_we27_C13[8],
            wr2_word_we27_C15[8],
            wr3_word_we27_C14[8]}) 
/* synopsys full_case */
            4'b1000: xtmux_1499 = wr0_data_C13[71:64];
            4'b0100: xtmux_1499 = wr1_data_C13[71:64];
            4'b0010: xtmux_1499 = wr2_data_C15[71:64];
            4'b0001: xtmux_1499 = wr3_data_C14[71:64];
        endcase
    end
    assign wmux27[71:64] = xtmux_1499;

    reg [7:0] xtmux_1500;
    always @(*) begin
        xtmux_1500 = 8'b0;
        case({wr0_word_we27_C13[9],
            wr1_word_we27_C13[9],
            wr2_word_we27_C15[9],
            wr3_word_we27_C14[9]}) 
/* synopsys full_case */
            4'b1000: xtmux_1500 = wr0_data_C13[79:72];
            4'b0100: xtmux_1500 = wr1_data_C13[79:72];
            4'b0010: xtmux_1500 = wr2_data_C15[79:72];
            4'b0001: xtmux_1500 = wr3_data_C14[79:72];
        endcase
    end
    assign wmux27[79:72] = xtmux_1500;

    reg [7:0] xtmux_1501;
    always @(*) begin
        xtmux_1501 = 8'b0;
        case({wr0_word_we27_C13[10],
            wr1_word_we27_C13[10],
            wr2_word_we27_C15[10],
            wr3_word_we27_C14[10]}) 
/* synopsys full_case */
            4'b1000: xtmux_1501 = wr0_data_C13[87:80];
            4'b0100: xtmux_1501 = wr1_data_C13[87:80];
            4'b0010: xtmux_1501 = wr2_data_C15[87:80];
            4'b0001: xtmux_1501 = wr3_data_C14[87:80];
        endcase
    end
    assign wmux27[87:80] = xtmux_1501;

    reg [7:0] xtmux_1502;
    always @(*) begin
        xtmux_1502 = 8'b0;
        case({wr0_word_we27_C13[11],
            wr1_word_we27_C13[11],
            wr2_word_we27_C15[11],
            wr3_word_we27_C14[11]}) 
/* synopsys full_case */
            4'b1000: xtmux_1502 = wr0_data_C13[95:88];
            4'b0100: xtmux_1502 = wr1_data_C13[95:88];
            4'b0010: xtmux_1502 = wr2_data_C15[95:88];
            4'b0001: xtmux_1502 = wr3_data_C14[95:88];
        endcase
    end
    assign wmux27[95:88] = xtmux_1502;

    reg [7:0] xtmux_1503;
    always @(*) begin
        xtmux_1503 = 8'b0;
        case({wr0_word_we27_C13[12],
            wr1_word_we27_C13[12],
            wr2_word_we27_C15[12],
            wr3_word_we27_C14[12]}) 
/* synopsys full_case */
            4'b1000: xtmux_1503 = wr0_data_C13[103:96];
            4'b0100: xtmux_1503 = wr1_data_C13[103:96];
            4'b0010: xtmux_1503 = wr2_data_C15[103:96];
            4'b0001: xtmux_1503 = wr3_data_C14[103:96];
        endcase
    end
    assign wmux27[103:96] = xtmux_1503;

    reg [7:0] xtmux_1504;
    always @(*) begin
        xtmux_1504 = 8'b0;
        case({wr0_word_we27_C13[13],
            wr1_word_we27_C13[13],
            wr2_word_we27_C15[13],
            wr3_word_we27_C14[13]}) 
/* synopsys full_case */
            4'b1000: xtmux_1504 = wr0_data_C13[111:104];
            4'b0100: xtmux_1504 = wr1_data_C13[111:104];
            4'b0010: xtmux_1504 = wr2_data_C15[111:104];
            4'b0001: xtmux_1504 = wr3_data_C14[111:104];
        endcase
    end
    assign wmux27[111:104] = xtmux_1504;

    reg [7:0] xtmux_1505;
    always @(*) begin
        xtmux_1505 = 8'b0;
        case({wr0_word_we27_C13[14],
            wr1_word_we27_C13[14],
            wr2_word_we27_C15[14],
            wr3_word_we27_C14[14]}) 
/* synopsys full_case */
            4'b1000: xtmux_1505 = wr0_data_C13[119:112];
            4'b0100: xtmux_1505 = wr1_data_C13[119:112];
            4'b0010: xtmux_1505 = wr2_data_C15[119:112];
            4'b0001: xtmux_1505 = wr3_data_C14[119:112];
        endcase
    end
    assign wmux27[119:112] = xtmux_1505;

    reg [7:0] xtmux_1506;
    always @(*) begin
        xtmux_1506 = 8'b0;
        case({wr0_word_we27_C13[15],
            wr1_word_we27_C13[15],
            wr2_word_we27_C15[15],
            wr3_word_we27_C14[15]}) 
/* synopsys full_case */
            4'b1000: xtmux_1506 = wr0_data_C13[127:120];
            4'b0100: xtmux_1506 = wr1_data_C13[127:120];
            4'b0010: xtmux_1506 = wr2_data_C15[127:120];
            4'b0001: xtmux_1506 = wr3_data_C14[127:120];
        endcase
    end
    assign wmux27[127:120] = xtmux_1506;

    wire [127:0] word27;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word27_p0;
    assign word27[7:0] = XACC_reg_word27_p0;
    always @(posedge clk or posedge localReset)
        XACC_reg_word27_p0 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk27_0) ? wmux27[7:0] : XACC_reg_word27_p0;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word27_p1;
    assign word27[15:8] = XACC_reg_word27_p1;
    always @(posedge clk or posedge localReset)
        XACC_reg_word27_p1 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk27_1) ? wmux27[15:8] : XACC_reg_word27_p1;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word27_p2;
    assign word27[23:16] = XACC_reg_word27_p2;
    always @(posedge clk or posedge localReset)
        XACC_reg_word27_p2 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk27_2) ? wmux27[23:16] : XACC_reg_word27_p2;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word27_p3;
    assign word27[31:24] = XACC_reg_word27_p3;
    always @(posedge clk or posedge localReset)
        XACC_reg_word27_p3 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk27_3) ? wmux27[31:24] : XACC_reg_word27_p3;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word27_p4;
    assign word27[39:32] = XACC_reg_word27_p4;
    always @(posedge clk or posedge localReset)
        XACC_reg_word27_p4 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk27_4) ? wmux27[39:32] : XACC_reg_word27_p4;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word27_p5;
    assign word27[47:40] = XACC_reg_word27_p5;
    always @(posedge clk or posedge localReset)
        XACC_reg_word27_p5 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk27_5) ? wmux27[47:40] : XACC_reg_word27_p5;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word27_p6;
    assign word27[55:48] = XACC_reg_word27_p6;
    always @(posedge clk or posedge localReset)
        XACC_reg_word27_p6 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk27_6) ? wmux27[55:48] : XACC_reg_word27_p6;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word27_p7;
    assign word27[63:56] = XACC_reg_word27_p7;
    always @(posedge clk or posedge localReset)
        XACC_reg_word27_p7 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk27_7) ? wmux27[63:56] : XACC_reg_word27_p7;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word27_p8;
    assign word27[71:64] = XACC_reg_word27_p8;
    always @(posedge clk or posedge localReset)
        XACC_reg_word27_p8 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk27_8) ? wmux27[71:64] : XACC_reg_word27_p8;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word27_p9;
    assign word27[79:72] = XACC_reg_word27_p9;
    always @(posedge clk or posedge localReset)
        XACC_reg_word27_p9 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk27_9) ? wmux27[79:72] : XACC_reg_word27_p9;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word27_p10;
    assign word27[87:80] = XACC_reg_word27_p10;
    always @(posedge clk or posedge localReset)
        XACC_reg_word27_p10 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk27_10) ? wmux27[87:80] : XACC_reg_word27_p10;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word27_p11;
    assign word27[95:88] = XACC_reg_word27_p11;
    always @(posedge clk or posedge localReset)
        XACC_reg_word27_p11 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk27_11) ? wmux27[95:88] : XACC_reg_word27_p11;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word27_p12;
    assign word27[103:96] = XACC_reg_word27_p12;
    always @(posedge clk or posedge localReset)
        XACC_reg_word27_p12 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk27_12) ? wmux27[103:96] : XACC_reg_word27_p12;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word27_p13;
    assign word27[111:104] = XACC_reg_word27_p13;
    always @(posedge clk or posedge localReset)
        XACC_reg_word27_p13 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk27_13) ? wmux27[111:104] : XACC_reg_word27_p13;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word27_p14;
    assign word27[119:112] = XACC_reg_word27_p14;
    always @(posedge clk or posedge localReset)
        XACC_reg_word27_p14 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk27_14) ? wmux27[119:112] : XACC_reg_word27_p14;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word27_p15;
    assign word27[127:120] = XACC_reg_word27_p15;
    always @(posedge clk or posedge localReset)
        XACC_reg_word27_p15 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk27_15) ? wmux27[127:120] : XACC_reg_word27_p15;

    wire [15:0] wr0_word_we28_C13 = wr0_we_C13 & {16{(wr0_addr_C13 == 5'd28)}};
    wire [15:0] wr1_word_we28_C13 = wr1_we_C13 & {16{(wr1_addr_C13 == 5'd28)}};
    wire [15:0] wr2_word_we28_C15 = wr2_we_C15 & {16{(wr2_addr_C15 == 5'd28)}};
    wire [15:0] wr3_word_we28_C14 = wr3_we_C14 & {16{(wr3_addr_C14 == 5'd28)}};
    wire [15:0] word28_we = 16'b0 | wr0_word_we28_C13 | wr1_word_we28_C13 | wr2_word_we28_C15 | wr3_word_we28_C14;
    wire gclk28_0;
assign gclk28_0 = word28_we[0];
    wire gclk28_1;
assign gclk28_1 = word28_we[1];
    wire gclk28_2;
assign gclk28_2 = word28_we[2];
    wire gclk28_3;
assign gclk28_3 = word28_we[3];
    wire gclk28_4;
assign gclk28_4 = word28_we[4];
    wire gclk28_5;
assign gclk28_5 = word28_we[5];
    wire gclk28_6;
assign gclk28_6 = word28_we[6];
    wire gclk28_7;
assign gclk28_7 = word28_we[7];
    wire gclk28_8;
assign gclk28_8 = word28_we[8];
    wire gclk28_9;
assign gclk28_9 = word28_we[9];
    wire gclk28_10;
assign gclk28_10 = word28_we[10];
    wire gclk28_11;
assign gclk28_11 = word28_we[11];
    wire gclk28_12;
assign gclk28_12 = word28_we[12];
    wire gclk28_13;
assign gclk28_13 = word28_we[13];
    wire gclk28_14;
assign gclk28_14 = word28_we[14];
    wire gclk28_15;
assign gclk28_15 = word28_we[15];
    wire [127:0] wmux28;
    reg [7:0] xtmux_1507;
    always @(*) begin
        xtmux_1507 = 8'b0;
        case({wr0_word_we28_C13[0],
            wr1_word_we28_C13[0],
            wr2_word_we28_C15[0],
            wr3_word_we28_C14[0]}) 
/* synopsys full_case */
            4'b1000: xtmux_1507 = wr0_data_C13[7:0];
            4'b0100: xtmux_1507 = wr1_data_C13[7:0];
            4'b0010: xtmux_1507 = wr2_data_C15[7:0];
            4'b0001: xtmux_1507 = wr3_data_C14[7:0];
        endcase
    end
    assign wmux28[7:0] = xtmux_1507;

    reg [7:0] xtmux_1508;
    always @(*) begin
        xtmux_1508 = 8'b0;
        case({wr0_word_we28_C13[1],
            wr1_word_we28_C13[1],
            wr2_word_we28_C15[1],
            wr3_word_we28_C14[1]}) 
/* synopsys full_case */
            4'b1000: xtmux_1508 = wr0_data_C13[15:8];
            4'b0100: xtmux_1508 = wr1_data_C13[15:8];
            4'b0010: xtmux_1508 = wr2_data_C15[15:8];
            4'b0001: xtmux_1508 = wr3_data_C14[15:8];
        endcase
    end
    assign wmux28[15:8] = xtmux_1508;

    reg [7:0] xtmux_1509;
    always @(*) begin
        xtmux_1509 = 8'b0;
        case({wr0_word_we28_C13[2],
            wr1_word_we28_C13[2],
            wr2_word_we28_C15[2],
            wr3_word_we28_C14[2]}) 
/* synopsys full_case */
            4'b1000: xtmux_1509 = wr0_data_C13[23:16];
            4'b0100: xtmux_1509 = wr1_data_C13[23:16];
            4'b0010: xtmux_1509 = wr2_data_C15[23:16];
            4'b0001: xtmux_1509 = wr3_data_C14[23:16];
        endcase
    end
    assign wmux28[23:16] = xtmux_1509;

    reg [7:0] xtmux_1510;
    always @(*) begin
        xtmux_1510 = 8'b0;
        case({wr0_word_we28_C13[3],
            wr1_word_we28_C13[3],
            wr2_word_we28_C15[3],
            wr3_word_we28_C14[3]}) 
/* synopsys full_case */
            4'b1000: xtmux_1510 = wr0_data_C13[31:24];
            4'b0100: xtmux_1510 = wr1_data_C13[31:24];
            4'b0010: xtmux_1510 = wr2_data_C15[31:24];
            4'b0001: xtmux_1510 = wr3_data_C14[31:24];
        endcase
    end
    assign wmux28[31:24] = xtmux_1510;

    reg [7:0] xtmux_1511;
    always @(*) begin
        xtmux_1511 = 8'b0;
        case({wr0_word_we28_C13[4],
            wr1_word_we28_C13[4],
            wr2_word_we28_C15[4],
            wr3_word_we28_C14[4]}) 
/* synopsys full_case */
            4'b1000: xtmux_1511 = wr0_data_C13[39:32];
            4'b0100: xtmux_1511 = wr1_data_C13[39:32];
            4'b0010: xtmux_1511 = wr2_data_C15[39:32];
            4'b0001: xtmux_1511 = wr3_data_C14[39:32];
        endcase
    end
    assign wmux28[39:32] = xtmux_1511;

    reg [7:0] xtmux_1512;
    always @(*) begin
        xtmux_1512 = 8'b0;
        case({wr0_word_we28_C13[5],
            wr1_word_we28_C13[5],
            wr2_word_we28_C15[5],
            wr3_word_we28_C14[5]}) 
/* synopsys full_case */
            4'b1000: xtmux_1512 = wr0_data_C13[47:40];
            4'b0100: xtmux_1512 = wr1_data_C13[47:40];
            4'b0010: xtmux_1512 = wr2_data_C15[47:40];
            4'b0001: xtmux_1512 = wr3_data_C14[47:40];
        endcase
    end
    assign wmux28[47:40] = xtmux_1512;

    reg [7:0] xtmux_1513;
    always @(*) begin
        xtmux_1513 = 8'b0;
        case({wr0_word_we28_C13[6],
            wr1_word_we28_C13[6],
            wr2_word_we28_C15[6],
            wr3_word_we28_C14[6]}) 
/* synopsys full_case */
            4'b1000: xtmux_1513 = wr0_data_C13[55:48];
            4'b0100: xtmux_1513 = wr1_data_C13[55:48];
            4'b0010: xtmux_1513 = wr2_data_C15[55:48];
            4'b0001: xtmux_1513 = wr3_data_C14[55:48];
        endcase
    end
    assign wmux28[55:48] = xtmux_1513;

    reg [7:0] xtmux_1514;
    always @(*) begin
        xtmux_1514 = 8'b0;
        case({wr0_word_we28_C13[7],
            wr1_word_we28_C13[7],
            wr2_word_we28_C15[7],
            wr3_word_we28_C14[7]}) 
/* synopsys full_case */
            4'b1000: xtmux_1514 = wr0_data_C13[63:56];
            4'b0100: xtmux_1514 = wr1_data_C13[63:56];
            4'b0010: xtmux_1514 = wr2_data_C15[63:56];
            4'b0001: xtmux_1514 = wr3_data_C14[63:56];
        endcase
    end
    assign wmux28[63:56] = xtmux_1514;

    reg [7:0] xtmux_1515;
    always @(*) begin
        xtmux_1515 = 8'b0;
        case({wr0_word_we28_C13[8],
            wr1_word_we28_C13[8],
            wr2_word_we28_C15[8],
            wr3_word_we28_C14[8]}) 
/* synopsys full_case */
            4'b1000: xtmux_1515 = wr0_data_C13[71:64];
            4'b0100: xtmux_1515 = wr1_data_C13[71:64];
            4'b0010: xtmux_1515 = wr2_data_C15[71:64];
            4'b0001: xtmux_1515 = wr3_data_C14[71:64];
        endcase
    end
    assign wmux28[71:64] = xtmux_1515;

    reg [7:0] xtmux_1516;
    always @(*) begin
        xtmux_1516 = 8'b0;
        case({wr0_word_we28_C13[9],
            wr1_word_we28_C13[9],
            wr2_word_we28_C15[9],
            wr3_word_we28_C14[9]}) 
/* synopsys full_case */
            4'b1000: xtmux_1516 = wr0_data_C13[79:72];
            4'b0100: xtmux_1516 = wr1_data_C13[79:72];
            4'b0010: xtmux_1516 = wr2_data_C15[79:72];
            4'b0001: xtmux_1516 = wr3_data_C14[79:72];
        endcase
    end
    assign wmux28[79:72] = xtmux_1516;

    reg [7:0] xtmux_1517;
    always @(*) begin
        xtmux_1517 = 8'b0;
        case({wr0_word_we28_C13[10],
            wr1_word_we28_C13[10],
            wr2_word_we28_C15[10],
            wr3_word_we28_C14[10]}) 
/* synopsys full_case */
            4'b1000: xtmux_1517 = wr0_data_C13[87:80];
            4'b0100: xtmux_1517 = wr1_data_C13[87:80];
            4'b0010: xtmux_1517 = wr2_data_C15[87:80];
            4'b0001: xtmux_1517 = wr3_data_C14[87:80];
        endcase
    end
    assign wmux28[87:80] = xtmux_1517;

    reg [7:0] xtmux_1518;
    always @(*) begin
        xtmux_1518 = 8'b0;
        case({wr0_word_we28_C13[11],
            wr1_word_we28_C13[11],
            wr2_word_we28_C15[11],
            wr3_word_we28_C14[11]}) 
/* synopsys full_case */
            4'b1000: xtmux_1518 = wr0_data_C13[95:88];
            4'b0100: xtmux_1518 = wr1_data_C13[95:88];
            4'b0010: xtmux_1518 = wr2_data_C15[95:88];
            4'b0001: xtmux_1518 = wr3_data_C14[95:88];
        endcase
    end
    assign wmux28[95:88] = xtmux_1518;

    reg [7:0] xtmux_1519;
    always @(*) begin
        xtmux_1519 = 8'b0;
        case({wr0_word_we28_C13[12],
            wr1_word_we28_C13[12],
            wr2_word_we28_C15[12],
            wr3_word_we28_C14[12]}) 
/* synopsys full_case */
            4'b1000: xtmux_1519 = wr0_data_C13[103:96];
            4'b0100: xtmux_1519 = wr1_data_C13[103:96];
            4'b0010: xtmux_1519 = wr2_data_C15[103:96];
            4'b0001: xtmux_1519 = wr3_data_C14[103:96];
        endcase
    end
    assign wmux28[103:96] = xtmux_1519;

    reg [7:0] xtmux_1520;
    always @(*) begin
        xtmux_1520 = 8'b0;
        case({wr0_word_we28_C13[13],
            wr1_word_we28_C13[13],
            wr2_word_we28_C15[13],
            wr3_word_we28_C14[13]}) 
/* synopsys full_case */
            4'b1000: xtmux_1520 = wr0_data_C13[111:104];
            4'b0100: xtmux_1520 = wr1_data_C13[111:104];
            4'b0010: xtmux_1520 = wr2_data_C15[111:104];
            4'b0001: xtmux_1520 = wr3_data_C14[111:104];
        endcase
    end
    assign wmux28[111:104] = xtmux_1520;

    reg [7:0] xtmux_1521;
    always @(*) begin
        xtmux_1521 = 8'b0;
        case({wr0_word_we28_C13[14],
            wr1_word_we28_C13[14],
            wr2_word_we28_C15[14],
            wr3_word_we28_C14[14]}) 
/* synopsys full_case */
            4'b1000: xtmux_1521 = wr0_data_C13[119:112];
            4'b0100: xtmux_1521 = wr1_data_C13[119:112];
            4'b0010: xtmux_1521 = wr2_data_C15[119:112];
            4'b0001: xtmux_1521 = wr3_data_C14[119:112];
        endcase
    end
    assign wmux28[119:112] = xtmux_1521;

    reg [7:0] xtmux_1522;
    always @(*) begin
        xtmux_1522 = 8'b0;
        case({wr0_word_we28_C13[15],
            wr1_word_we28_C13[15],
            wr2_word_we28_C15[15],
            wr3_word_we28_C14[15]}) 
/* synopsys full_case */
            4'b1000: xtmux_1522 = wr0_data_C13[127:120];
            4'b0100: xtmux_1522 = wr1_data_C13[127:120];
            4'b0010: xtmux_1522 = wr2_data_C15[127:120];
            4'b0001: xtmux_1522 = wr3_data_C14[127:120];
        endcase
    end
    assign wmux28[127:120] = xtmux_1522;

    wire [127:0] word28;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word28_p0;
    assign word28[7:0] = XACC_reg_word28_p0;
    always @(posedge clk or posedge localReset)
        XACC_reg_word28_p0 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk28_0) ? wmux28[7:0] : XACC_reg_word28_p0;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word28_p1;
    assign word28[15:8] = XACC_reg_word28_p1;
    always @(posedge clk or posedge localReset)
        XACC_reg_word28_p1 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk28_1) ? wmux28[15:8] : XACC_reg_word28_p1;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word28_p2;
    assign word28[23:16] = XACC_reg_word28_p2;
    always @(posedge clk or posedge localReset)
        XACC_reg_word28_p2 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk28_2) ? wmux28[23:16] : XACC_reg_word28_p2;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word28_p3;
    assign word28[31:24] = XACC_reg_word28_p3;
    always @(posedge clk or posedge localReset)
        XACC_reg_word28_p3 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk28_3) ? wmux28[31:24] : XACC_reg_word28_p3;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word28_p4;
    assign word28[39:32] = XACC_reg_word28_p4;
    always @(posedge clk or posedge localReset)
        XACC_reg_word28_p4 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk28_4) ? wmux28[39:32] : XACC_reg_word28_p4;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word28_p5;
    assign word28[47:40] = XACC_reg_word28_p5;
    always @(posedge clk or posedge localReset)
        XACC_reg_word28_p5 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk28_5) ? wmux28[47:40] : XACC_reg_word28_p5;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word28_p6;
    assign word28[55:48] = XACC_reg_word28_p6;
    always @(posedge clk or posedge localReset)
        XACC_reg_word28_p6 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk28_6) ? wmux28[55:48] : XACC_reg_word28_p6;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word28_p7;
    assign word28[63:56] = XACC_reg_word28_p7;
    always @(posedge clk or posedge localReset)
        XACC_reg_word28_p7 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk28_7) ? wmux28[63:56] : XACC_reg_word28_p7;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word28_p8;
    assign word28[71:64] = XACC_reg_word28_p8;
    always @(posedge clk or posedge localReset)
        XACC_reg_word28_p8 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk28_8) ? wmux28[71:64] : XACC_reg_word28_p8;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word28_p9;
    assign word28[79:72] = XACC_reg_word28_p9;
    always @(posedge clk or posedge localReset)
        XACC_reg_word28_p9 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk28_9) ? wmux28[79:72] : XACC_reg_word28_p9;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word28_p10;
    assign word28[87:80] = XACC_reg_word28_p10;
    always @(posedge clk or posedge localReset)
        XACC_reg_word28_p10 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk28_10) ? wmux28[87:80] : XACC_reg_word28_p10;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word28_p11;
    assign word28[95:88] = XACC_reg_word28_p11;
    always @(posedge clk or posedge localReset)
        XACC_reg_word28_p11 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk28_11) ? wmux28[95:88] : XACC_reg_word28_p11;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word28_p12;
    assign word28[103:96] = XACC_reg_word28_p12;
    always @(posedge clk or posedge localReset)
        XACC_reg_word28_p12 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk28_12) ? wmux28[103:96] : XACC_reg_word28_p12;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word28_p13;
    assign word28[111:104] = XACC_reg_word28_p13;
    always @(posedge clk or posedge localReset)
        XACC_reg_word28_p13 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk28_13) ? wmux28[111:104] : XACC_reg_word28_p13;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word28_p14;
    assign word28[119:112] = XACC_reg_word28_p14;
    always @(posedge clk or posedge localReset)
        XACC_reg_word28_p14 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk28_14) ? wmux28[119:112] : XACC_reg_word28_p14;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word28_p15;
    assign word28[127:120] = XACC_reg_word28_p15;
    always @(posedge clk or posedge localReset)
        XACC_reg_word28_p15 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk28_15) ? wmux28[127:120] : XACC_reg_word28_p15;

    wire [15:0] wr0_word_we29_C13 = wr0_we_C13 & {16{(wr0_addr_C13 == 5'd29)}};
    wire [15:0] wr1_word_we29_C13 = wr1_we_C13 & {16{(wr1_addr_C13 == 5'd29)}};
    wire [15:0] wr2_word_we29_C15 = wr2_we_C15 & {16{(wr2_addr_C15 == 5'd29)}};
    wire [15:0] wr3_word_we29_C14 = wr3_we_C14 & {16{(wr3_addr_C14 == 5'd29)}};
    wire [15:0] word29_we = 16'b0 | wr0_word_we29_C13 | wr1_word_we29_C13 | wr2_word_we29_C15 | wr3_word_we29_C14;
    wire gclk29_0;
assign gclk29_0 = word29_we[0];
    wire gclk29_1;
assign gclk29_1 = word29_we[1];
    wire gclk29_2;
assign gclk29_2 = word29_we[2];
    wire gclk29_3;
assign gclk29_3 = word29_we[3];
    wire gclk29_4;
assign gclk29_4 = word29_we[4];
    wire gclk29_5;
assign gclk29_5 = word29_we[5];
    wire gclk29_6;
assign gclk29_6 = word29_we[6];
    wire gclk29_7;
assign gclk29_7 = word29_we[7];
    wire gclk29_8;
assign gclk29_8 = word29_we[8];
    wire gclk29_9;
assign gclk29_9 = word29_we[9];
    wire gclk29_10;
assign gclk29_10 = word29_we[10];
    wire gclk29_11;
assign gclk29_11 = word29_we[11];
    wire gclk29_12;
assign gclk29_12 = word29_we[12];
    wire gclk29_13;
assign gclk29_13 = word29_we[13];
    wire gclk29_14;
assign gclk29_14 = word29_we[14];
    wire gclk29_15;
assign gclk29_15 = word29_we[15];
    wire [127:0] wmux29;
    reg [7:0] xtmux_1523;
    always @(*) begin
        xtmux_1523 = 8'b0;
        case({wr0_word_we29_C13[0],
            wr1_word_we29_C13[0],
            wr2_word_we29_C15[0],
            wr3_word_we29_C14[0]}) 
/* synopsys full_case */
            4'b1000: xtmux_1523 = wr0_data_C13[7:0];
            4'b0100: xtmux_1523 = wr1_data_C13[7:0];
            4'b0010: xtmux_1523 = wr2_data_C15[7:0];
            4'b0001: xtmux_1523 = wr3_data_C14[7:0];
        endcase
    end
    assign wmux29[7:0] = xtmux_1523;

    reg [7:0] xtmux_1524;
    always @(*) begin
        xtmux_1524 = 8'b0;
        case({wr0_word_we29_C13[1],
            wr1_word_we29_C13[1],
            wr2_word_we29_C15[1],
            wr3_word_we29_C14[1]}) 
/* synopsys full_case */
            4'b1000: xtmux_1524 = wr0_data_C13[15:8];
            4'b0100: xtmux_1524 = wr1_data_C13[15:8];
            4'b0010: xtmux_1524 = wr2_data_C15[15:8];
            4'b0001: xtmux_1524 = wr3_data_C14[15:8];
        endcase
    end
    assign wmux29[15:8] = xtmux_1524;

    reg [7:0] xtmux_1525;
    always @(*) begin
        xtmux_1525 = 8'b0;
        case({wr0_word_we29_C13[2],
            wr1_word_we29_C13[2],
            wr2_word_we29_C15[2],
            wr3_word_we29_C14[2]}) 
/* synopsys full_case */
            4'b1000: xtmux_1525 = wr0_data_C13[23:16];
            4'b0100: xtmux_1525 = wr1_data_C13[23:16];
            4'b0010: xtmux_1525 = wr2_data_C15[23:16];
            4'b0001: xtmux_1525 = wr3_data_C14[23:16];
        endcase
    end
    assign wmux29[23:16] = xtmux_1525;

    reg [7:0] xtmux_1526;
    always @(*) begin
        xtmux_1526 = 8'b0;
        case({wr0_word_we29_C13[3],
            wr1_word_we29_C13[3],
            wr2_word_we29_C15[3],
            wr3_word_we29_C14[3]}) 
/* synopsys full_case */
            4'b1000: xtmux_1526 = wr0_data_C13[31:24];
            4'b0100: xtmux_1526 = wr1_data_C13[31:24];
            4'b0010: xtmux_1526 = wr2_data_C15[31:24];
            4'b0001: xtmux_1526 = wr3_data_C14[31:24];
        endcase
    end
    assign wmux29[31:24] = xtmux_1526;

    reg [7:0] xtmux_1527;
    always @(*) begin
        xtmux_1527 = 8'b0;
        case({wr0_word_we29_C13[4],
            wr1_word_we29_C13[4],
            wr2_word_we29_C15[4],
            wr3_word_we29_C14[4]}) 
/* synopsys full_case */
            4'b1000: xtmux_1527 = wr0_data_C13[39:32];
            4'b0100: xtmux_1527 = wr1_data_C13[39:32];
            4'b0010: xtmux_1527 = wr2_data_C15[39:32];
            4'b0001: xtmux_1527 = wr3_data_C14[39:32];
        endcase
    end
    assign wmux29[39:32] = xtmux_1527;

    reg [7:0] xtmux_1528;
    always @(*) begin
        xtmux_1528 = 8'b0;
        case({wr0_word_we29_C13[5],
            wr1_word_we29_C13[5],
            wr2_word_we29_C15[5],
            wr3_word_we29_C14[5]}) 
/* synopsys full_case */
            4'b1000: xtmux_1528 = wr0_data_C13[47:40];
            4'b0100: xtmux_1528 = wr1_data_C13[47:40];
            4'b0010: xtmux_1528 = wr2_data_C15[47:40];
            4'b0001: xtmux_1528 = wr3_data_C14[47:40];
        endcase
    end
    assign wmux29[47:40] = xtmux_1528;

    reg [7:0] xtmux_1529;
    always @(*) begin
        xtmux_1529 = 8'b0;
        case({wr0_word_we29_C13[6],
            wr1_word_we29_C13[6],
            wr2_word_we29_C15[6],
            wr3_word_we29_C14[6]}) 
/* synopsys full_case */
            4'b1000: xtmux_1529 = wr0_data_C13[55:48];
            4'b0100: xtmux_1529 = wr1_data_C13[55:48];
            4'b0010: xtmux_1529 = wr2_data_C15[55:48];
            4'b0001: xtmux_1529 = wr3_data_C14[55:48];
        endcase
    end
    assign wmux29[55:48] = xtmux_1529;

    reg [7:0] xtmux_1530;
    always @(*) begin
        xtmux_1530 = 8'b0;
        case({wr0_word_we29_C13[7],
            wr1_word_we29_C13[7],
            wr2_word_we29_C15[7],
            wr3_word_we29_C14[7]}) 
/* synopsys full_case */
            4'b1000: xtmux_1530 = wr0_data_C13[63:56];
            4'b0100: xtmux_1530 = wr1_data_C13[63:56];
            4'b0010: xtmux_1530 = wr2_data_C15[63:56];
            4'b0001: xtmux_1530 = wr3_data_C14[63:56];
        endcase
    end
    assign wmux29[63:56] = xtmux_1530;

    reg [7:0] xtmux_1531;
    always @(*) begin
        xtmux_1531 = 8'b0;
        case({wr0_word_we29_C13[8],
            wr1_word_we29_C13[8],
            wr2_word_we29_C15[8],
            wr3_word_we29_C14[8]}) 
/* synopsys full_case */
            4'b1000: xtmux_1531 = wr0_data_C13[71:64];
            4'b0100: xtmux_1531 = wr1_data_C13[71:64];
            4'b0010: xtmux_1531 = wr2_data_C15[71:64];
            4'b0001: xtmux_1531 = wr3_data_C14[71:64];
        endcase
    end
    assign wmux29[71:64] = xtmux_1531;

    reg [7:0] xtmux_1532;
    always @(*) begin
        xtmux_1532 = 8'b0;
        case({wr0_word_we29_C13[9],
            wr1_word_we29_C13[9],
            wr2_word_we29_C15[9],
            wr3_word_we29_C14[9]}) 
/* synopsys full_case */
            4'b1000: xtmux_1532 = wr0_data_C13[79:72];
            4'b0100: xtmux_1532 = wr1_data_C13[79:72];
            4'b0010: xtmux_1532 = wr2_data_C15[79:72];
            4'b0001: xtmux_1532 = wr3_data_C14[79:72];
        endcase
    end
    assign wmux29[79:72] = xtmux_1532;

    reg [7:0] xtmux_1533;
    always @(*) begin
        xtmux_1533 = 8'b0;
        case({wr0_word_we29_C13[10],
            wr1_word_we29_C13[10],
            wr2_word_we29_C15[10],
            wr3_word_we29_C14[10]}) 
/* synopsys full_case */
            4'b1000: xtmux_1533 = wr0_data_C13[87:80];
            4'b0100: xtmux_1533 = wr1_data_C13[87:80];
            4'b0010: xtmux_1533 = wr2_data_C15[87:80];
            4'b0001: xtmux_1533 = wr3_data_C14[87:80];
        endcase
    end
    assign wmux29[87:80] = xtmux_1533;

    reg [7:0] xtmux_1534;
    always @(*) begin
        xtmux_1534 = 8'b0;
        case({wr0_word_we29_C13[11],
            wr1_word_we29_C13[11],
            wr2_word_we29_C15[11],
            wr3_word_we29_C14[11]}) 
/* synopsys full_case */
            4'b1000: xtmux_1534 = wr0_data_C13[95:88];
            4'b0100: xtmux_1534 = wr1_data_C13[95:88];
            4'b0010: xtmux_1534 = wr2_data_C15[95:88];
            4'b0001: xtmux_1534 = wr3_data_C14[95:88];
        endcase
    end
    assign wmux29[95:88] = xtmux_1534;

    reg [7:0] xtmux_1535;
    always @(*) begin
        xtmux_1535 = 8'b0;
        case({wr0_word_we29_C13[12],
            wr1_word_we29_C13[12],
            wr2_word_we29_C15[12],
            wr3_word_we29_C14[12]}) 
/* synopsys full_case */
            4'b1000: xtmux_1535 = wr0_data_C13[103:96];
            4'b0100: xtmux_1535 = wr1_data_C13[103:96];
            4'b0010: xtmux_1535 = wr2_data_C15[103:96];
            4'b0001: xtmux_1535 = wr3_data_C14[103:96];
        endcase
    end
    assign wmux29[103:96] = xtmux_1535;

    reg [7:0] xtmux_1536;
    always @(*) begin
        xtmux_1536 = 8'b0;
        case({wr0_word_we29_C13[13],
            wr1_word_we29_C13[13],
            wr2_word_we29_C15[13],
            wr3_word_we29_C14[13]}) 
/* synopsys full_case */
            4'b1000: xtmux_1536 = wr0_data_C13[111:104];
            4'b0100: xtmux_1536 = wr1_data_C13[111:104];
            4'b0010: xtmux_1536 = wr2_data_C15[111:104];
            4'b0001: xtmux_1536 = wr3_data_C14[111:104];
        endcase
    end
    assign wmux29[111:104] = xtmux_1536;

    reg [7:0] xtmux_1537;
    always @(*) begin
        xtmux_1537 = 8'b0;
        case({wr0_word_we29_C13[14],
            wr1_word_we29_C13[14],
            wr2_word_we29_C15[14],
            wr3_word_we29_C14[14]}) 
/* synopsys full_case */
            4'b1000: xtmux_1537 = wr0_data_C13[119:112];
            4'b0100: xtmux_1537 = wr1_data_C13[119:112];
            4'b0010: xtmux_1537 = wr2_data_C15[119:112];
            4'b0001: xtmux_1537 = wr3_data_C14[119:112];
        endcase
    end
    assign wmux29[119:112] = xtmux_1537;

    reg [7:0] xtmux_1538;
    always @(*) begin
        xtmux_1538 = 8'b0;
        case({wr0_word_we29_C13[15],
            wr1_word_we29_C13[15],
            wr2_word_we29_C15[15],
            wr3_word_we29_C14[15]}) 
/* synopsys full_case */
            4'b1000: xtmux_1538 = wr0_data_C13[127:120];
            4'b0100: xtmux_1538 = wr1_data_C13[127:120];
            4'b0010: xtmux_1538 = wr2_data_C15[127:120];
            4'b0001: xtmux_1538 = wr3_data_C14[127:120];
        endcase
    end
    assign wmux29[127:120] = xtmux_1538;

    wire [127:0] word29;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word29_p0;
    assign word29[7:0] = XACC_reg_word29_p0;
    always @(posedge clk or posedge localReset)
        XACC_reg_word29_p0 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk29_0) ? wmux29[7:0] : XACC_reg_word29_p0;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word29_p1;
    assign word29[15:8] = XACC_reg_word29_p1;
    always @(posedge clk or posedge localReset)
        XACC_reg_word29_p1 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk29_1) ? wmux29[15:8] : XACC_reg_word29_p1;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word29_p2;
    assign word29[23:16] = XACC_reg_word29_p2;
    always @(posedge clk or posedge localReset)
        XACC_reg_word29_p2 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk29_2) ? wmux29[23:16] : XACC_reg_word29_p2;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word29_p3;
    assign word29[31:24] = XACC_reg_word29_p3;
    always @(posedge clk or posedge localReset)
        XACC_reg_word29_p3 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk29_3) ? wmux29[31:24] : XACC_reg_word29_p3;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word29_p4;
    assign word29[39:32] = XACC_reg_word29_p4;
    always @(posedge clk or posedge localReset)
        XACC_reg_word29_p4 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk29_4) ? wmux29[39:32] : XACC_reg_word29_p4;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word29_p5;
    assign word29[47:40] = XACC_reg_word29_p5;
    always @(posedge clk or posedge localReset)
        XACC_reg_word29_p5 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk29_5) ? wmux29[47:40] : XACC_reg_word29_p5;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word29_p6;
    assign word29[55:48] = XACC_reg_word29_p6;
    always @(posedge clk or posedge localReset)
        XACC_reg_word29_p6 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk29_6) ? wmux29[55:48] : XACC_reg_word29_p6;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word29_p7;
    assign word29[63:56] = XACC_reg_word29_p7;
    always @(posedge clk or posedge localReset)
        XACC_reg_word29_p7 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk29_7) ? wmux29[63:56] : XACC_reg_word29_p7;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word29_p8;
    assign word29[71:64] = XACC_reg_word29_p8;
    always @(posedge clk or posedge localReset)
        XACC_reg_word29_p8 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk29_8) ? wmux29[71:64] : XACC_reg_word29_p8;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word29_p9;
    assign word29[79:72] = XACC_reg_word29_p9;
    always @(posedge clk or posedge localReset)
        XACC_reg_word29_p9 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk29_9) ? wmux29[79:72] : XACC_reg_word29_p9;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word29_p10;
    assign word29[87:80] = XACC_reg_word29_p10;
    always @(posedge clk or posedge localReset)
        XACC_reg_word29_p10 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk29_10) ? wmux29[87:80] : XACC_reg_word29_p10;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word29_p11;
    assign word29[95:88] = XACC_reg_word29_p11;
    always @(posedge clk or posedge localReset)
        XACC_reg_word29_p11 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk29_11) ? wmux29[95:88] : XACC_reg_word29_p11;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word29_p12;
    assign word29[103:96] = XACC_reg_word29_p12;
    always @(posedge clk or posedge localReset)
        XACC_reg_word29_p12 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk29_12) ? wmux29[103:96] : XACC_reg_word29_p12;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word29_p13;
    assign word29[111:104] = XACC_reg_word29_p13;
    always @(posedge clk or posedge localReset)
        XACC_reg_word29_p13 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk29_13) ? wmux29[111:104] : XACC_reg_word29_p13;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word29_p14;
    assign word29[119:112] = XACC_reg_word29_p14;
    always @(posedge clk or posedge localReset)
        XACC_reg_word29_p14 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk29_14) ? wmux29[119:112] : XACC_reg_word29_p14;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word29_p15;
    assign word29[127:120] = XACC_reg_word29_p15;
    always @(posedge clk or posedge localReset)
        XACC_reg_word29_p15 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk29_15) ? wmux29[127:120] : XACC_reg_word29_p15;

    wire [15:0] wr0_word_we30_C13 = wr0_we_C13 & {16{(wr0_addr_C13 == 5'd30)}};
    wire [15:0] wr1_word_we30_C13 = wr1_we_C13 & {16{(wr1_addr_C13 == 5'd30)}};
    wire [15:0] wr2_word_we30_C15 = wr2_we_C15 & {16{(wr2_addr_C15 == 5'd30)}};
    wire [15:0] wr3_word_we30_C14 = wr3_we_C14 & {16{(wr3_addr_C14 == 5'd30)}};
    wire [15:0] word30_we = 16'b0 | wr0_word_we30_C13 | wr1_word_we30_C13 | wr2_word_we30_C15 | wr3_word_we30_C14;
    wire gclk30_0;
assign gclk30_0 = word30_we[0];
    wire gclk30_1;
assign gclk30_1 = word30_we[1];
    wire gclk30_2;
assign gclk30_2 = word30_we[2];
    wire gclk30_3;
assign gclk30_3 = word30_we[3];
    wire gclk30_4;
assign gclk30_4 = word30_we[4];
    wire gclk30_5;
assign gclk30_5 = word30_we[5];
    wire gclk30_6;
assign gclk30_6 = word30_we[6];
    wire gclk30_7;
assign gclk30_7 = word30_we[7];
    wire gclk30_8;
assign gclk30_8 = word30_we[8];
    wire gclk30_9;
assign gclk30_9 = word30_we[9];
    wire gclk30_10;
assign gclk30_10 = word30_we[10];
    wire gclk30_11;
assign gclk30_11 = word30_we[11];
    wire gclk30_12;
assign gclk30_12 = word30_we[12];
    wire gclk30_13;
assign gclk30_13 = word30_we[13];
    wire gclk30_14;
assign gclk30_14 = word30_we[14];
    wire gclk30_15;
assign gclk30_15 = word30_we[15];
    wire [127:0] wmux30;
    reg [7:0] xtmux_1539;
    always @(*) begin
        xtmux_1539 = 8'b0;
        case({wr0_word_we30_C13[0],
            wr1_word_we30_C13[0],
            wr2_word_we30_C15[0],
            wr3_word_we30_C14[0]}) 
/* synopsys full_case */
            4'b1000: xtmux_1539 = wr0_data_C13[7:0];
            4'b0100: xtmux_1539 = wr1_data_C13[7:0];
            4'b0010: xtmux_1539 = wr2_data_C15[7:0];
            4'b0001: xtmux_1539 = wr3_data_C14[7:0];
        endcase
    end
    assign wmux30[7:0] = xtmux_1539;

    reg [7:0] xtmux_1540;
    always @(*) begin
        xtmux_1540 = 8'b0;
        case({wr0_word_we30_C13[1],
            wr1_word_we30_C13[1],
            wr2_word_we30_C15[1],
            wr3_word_we30_C14[1]}) 
/* synopsys full_case */
            4'b1000: xtmux_1540 = wr0_data_C13[15:8];
            4'b0100: xtmux_1540 = wr1_data_C13[15:8];
            4'b0010: xtmux_1540 = wr2_data_C15[15:8];
            4'b0001: xtmux_1540 = wr3_data_C14[15:8];
        endcase
    end
    assign wmux30[15:8] = xtmux_1540;

    reg [7:0] xtmux_1541;
    always @(*) begin
        xtmux_1541 = 8'b0;
        case({wr0_word_we30_C13[2],
            wr1_word_we30_C13[2],
            wr2_word_we30_C15[2],
            wr3_word_we30_C14[2]}) 
/* synopsys full_case */
            4'b1000: xtmux_1541 = wr0_data_C13[23:16];
            4'b0100: xtmux_1541 = wr1_data_C13[23:16];
            4'b0010: xtmux_1541 = wr2_data_C15[23:16];
            4'b0001: xtmux_1541 = wr3_data_C14[23:16];
        endcase
    end
    assign wmux30[23:16] = xtmux_1541;

    reg [7:0] xtmux_1542;
    always @(*) begin
        xtmux_1542 = 8'b0;
        case({wr0_word_we30_C13[3],
            wr1_word_we30_C13[3],
            wr2_word_we30_C15[3],
            wr3_word_we30_C14[3]}) 
/* synopsys full_case */
            4'b1000: xtmux_1542 = wr0_data_C13[31:24];
            4'b0100: xtmux_1542 = wr1_data_C13[31:24];
            4'b0010: xtmux_1542 = wr2_data_C15[31:24];
            4'b0001: xtmux_1542 = wr3_data_C14[31:24];
        endcase
    end
    assign wmux30[31:24] = xtmux_1542;

    reg [7:0] xtmux_1543;
    always @(*) begin
        xtmux_1543 = 8'b0;
        case({wr0_word_we30_C13[4],
            wr1_word_we30_C13[4],
            wr2_word_we30_C15[4],
            wr3_word_we30_C14[4]}) 
/* synopsys full_case */
            4'b1000: xtmux_1543 = wr0_data_C13[39:32];
            4'b0100: xtmux_1543 = wr1_data_C13[39:32];
            4'b0010: xtmux_1543 = wr2_data_C15[39:32];
            4'b0001: xtmux_1543 = wr3_data_C14[39:32];
        endcase
    end
    assign wmux30[39:32] = xtmux_1543;

    reg [7:0] xtmux_1544;
    always @(*) begin
        xtmux_1544 = 8'b0;
        case({wr0_word_we30_C13[5],
            wr1_word_we30_C13[5],
            wr2_word_we30_C15[5],
            wr3_word_we30_C14[5]}) 
/* synopsys full_case */
            4'b1000: xtmux_1544 = wr0_data_C13[47:40];
            4'b0100: xtmux_1544 = wr1_data_C13[47:40];
            4'b0010: xtmux_1544 = wr2_data_C15[47:40];
            4'b0001: xtmux_1544 = wr3_data_C14[47:40];
        endcase
    end
    assign wmux30[47:40] = xtmux_1544;

    reg [7:0] xtmux_1545;
    always @(*) begin
        xtmux_1545 = 8'b0;
        case({wr0_word_we30_C13[6],
            wr1_word_we30_C13[6],
            wr2_word_we30_C15[6],
            wr3_word_we30_C14[6]}) 
/* synopsys full_case */
            4'b1000: xtmux_1545 = wr0_data_C13[55:48];
            4'b0100: xtmux_1545 = wr1_data_C13[55:48];
            4'b0010: xtmux_1545 = wr2_data_C15[55:48];
            4'b0001: xtmux_1545 = wr3_data_C14[55:48];
        endcase
    end
    assign wmux30[55:48] = xtmux_1545;

    reg [7:0] xtmux_1546;
    always @(*) begin
        xtmux_1546 = 8'b0;
        case({wr0_word_we30_C13[7],
            wr1_word_we30_C13[7],
            wr2_word_we30_C15[7],
            wr3_word_we30_C14[7]}) 
/* synopsys full_case */
            4'b1000: xtmux_1546 = wr0_data_C13[63:56];
            4'b0100: xtmux_1546 = wr1_data_C13[63:56];
            4'b0010: xtmux_1546 = wr2_data_C15[63:56];
            4'b0001: xtmux_1546 = wr3_data_C14[63:56];
        endcase
    end
    assign wmux30[63:56] = xtmux_1546;

    reg [7:0] xtmux_1547;
    always @(*) begin
        xtmux_1547 = 8'b0;
        case({wr0_word_we30_C13[8],
            wr1_word_we30_C13[8],
            wr2_word_we30_C15[8],
            wr3_word_we30_C14[8]}) 
/* synopsys full_case */
            4'b1000: xtmux_1547 = wr0_data_C13[71:64];
            4'b0100: xtmux_1547 = wr1_data_C13[71:64];
            4'b0010: xtmux_1547 = wr2_data_C15[71:64];
            4'b0001: xtmux_1547 = wr3_data_C14[71:64];
        endcase
    end
    assign wmux30[71:64] = xtmux_1547;

    reg [7:0] xtmux_1548;
    always @(*) begin
        xtmux_1548 = 8'b0;
        case({wr0_word_we30_C13[9],
            wr1_word_we30_C13[9],
            wr2_word_we30_C15[9],
            wr3_word_we30_C14[9]}) 
/* synopsys full_case */
            4'b1000: xtmux_1548 = wr0_data_C13[79:72];
            4'b0100: xtmux_1548 = wr1_data_C13[79:72];
            4'b0010: xtmux_1548 = wr2_data_C15[79:72];
            4'b0001: xtmux_1548 = wr3_data_C14[79:72];
        endcase
    end
    assign wmux30[79:72] = xtmux_1548;

    reg [7:0] xtmux_1549;
    always @(*) begin
        xtmux_1549 = 8'b0;
        case({wr0_word_we30_C13[10],
            wr1_word_we30_C13[10],
            wr2_word_we30_C15[10],
            wr3_word_we30_C14[10]}) 
/* synopsys full_case */
            4'b1000: xtmux_1549 = wr0_data_C13[87:80];
            4'b0100: xtmux_1549 = wr1_data_C13[87:80];
            4'b0010: xtmux_1549 = wr2_data_C15[87:80];
            4'b0001: xtmux_1549 = wr3_data_C14[87:80];
        endcase
    end
    assign wmux30[87:80] = xtmux_1549;

    reg [7:0] xtmux_1550;
    always @(*) begin
        xtmux_1550 = 8'b0;
        case({wr0_word_we30_C13[11],
            wr1_word_we30_C13[11],
            wr2_word_we30_C15[11],
            wr3_word_we30_C14[11]}) 
/* synopsys full_case */
            4'b1000: xtmux_1550 = wr0_data_C13[95:88];
            4'b0100: xtmux_1550 = wr1_data_C13[95:88];
            4'b0010: xtmux_1550 = wr2_data_C15[95:88];
            4'b0001: xtmux_1550 = wr3_data_C14[95:88];
        endcase
    end
    assign wmux30[95:88] = xtmux_1550;

    reg [7:0] xtmux_1551;
    always @(*) begin
        xtmux_1551 = 8'b0;
        case({wr0_word_we30_C13[12],
            wr1_word_we30_C13[12],
            wr2_word_we30_C15[12],
            wr3_word_we30_C14[12]}) 
/* synopsys full_case */
            4'b1000: xtmux_1551 = wr0_data_C13[103:96];
            4'b0100: xtmux_1551 = wr1_data_C13[103:96];
            4'b0010: xtmux_1551 = wr2_data_C15[103:96];
            4'b0001: xtmux_1551 = wr3_data_C14[103:96];
        endcase
    end
    assign wmux30[103:96] = xtmux_1551;

    reg [7:0] xtmux_1552;
    always @(*) begin
        xtmux_1552 = 8'b0;
        case({wr0_word_we30_C13[13],
            wr1_word_we30_C13[13],
            wr2_word_we30_C15[13],
            wr3_word_we30_C14[13]}) 
/* synopsys full_case */
            4'b1000: xtmux_1552 = wr0_data_C13[111:104];
            4'b0100: xtmux_1552 = wr1_data_C13[111:104];
            4'b0010: xtmux_1552 = wr2_data_C15[111:104];
            4'b0001: xtmux_1552 = wr3_data_C14[111:104];
        endcase
    end
    assign wmux30[111:104] = xtmux_1552;

    reg [7:0] xtmux_1553;
    always @(*) begin
        xtmux_1553 = 8'b0;
        case({wr0_word_we30_C13[14],
            wr1_word_we30_C13[14],
            wr2_word_we30_C15[14],
            wr3_word_we30_C14[14]}) 
/* synopsys full_case */
            4'b1000: xtmux_1553 = wr0_data_C13[119:112];
            4'b0100: xtmux_1553 = wr1_data_C13[119:112];
            4'b0010: xtmux_1553 = wr2_data_C15[119:112];
            4'b0001: xtmux_1553 = wr3_data_C14[119:112];
        endcase
    end
    assign wmux30[119:112] = xtmux_1553;

    reg [7:0] xtmux_1554;
    always @(*) begin
        xtmux_1554 = 8'b0;
        case({wr0_word_we30_C13[15],
            wr1_word_we30_C13[15],
            wr2_word_we30_C15[15],
            wr3_word_we30_C14[15]}) 
/* synopsys full_case */
            4'b1000: xtmux_1554 = wr0_data_C13[127:120];
            4'b0100: xtmux_1554 = wr1_data_C13[127:120];
            4'b0010: xtmux_1554 = wr2_data_C15[127:120];
            4'b0001: xtmux_1554 = wr3_data_C14[127:120];
        endcase
    end
    assign wmux30[127:120] = xtmux_1554;

    wire [127:0] word30;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word30_p0;
    assign word30[7:0] = XACC_reg_word30_p0;
    always @(posedge clk or posedge localReset)
        XACC_reg_word30_p0 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk30_0) ? wmux30[7:0] : XACC_reg_word30_p0;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word30_p1;
    assign word30[15:8] = XACC_reg_word30_p1;
    always @(posedge clk or posedge localReset)
        XACC_reg_word30_p1 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk30_1) ? wmux30[15:8] : XACC_reg_word30_p1;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word30_p2;
    assign word30[23:16] = XACC_reg_word30_p2;
    always @(posedge clk or posedge localReset)
        XACC_reg_word30_p2 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk30_2) ? wmux30[23:16] : XACC_reg_word30_p2;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word30_p3;
    assign word30[31:24] = XACC_reg_word30_p3;
    always @(posedge clk or posedge localReset)
        XACC_reg_word30_p3 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk30_3) ? wmux30[31:24] : XACC_reg_word30_p3;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word30_p4;
    assign word30[39:32] = XACC_reg_word30_p4;
    always @(posedge clk or posedge localReset)
        XACC_reg_word30_p4 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk30_4) ? wmux30[39:32] : XACC_reg_word30_p4;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word30_p5;
    assign word30[47:40] = XACC_reg_word30_p5;
    always @(posedge clk or posedge localReset)
        XACC_reg_word30_p5 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk30_5) ? wmux30[47:40] : XACC_reg_word30_p5;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word30_p6;
    assign word30[55:48] = XACC_reg_word30_p6;
    always @(posedge clk or posedge localReset)
        XACC_reg_word30_p6 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk30_6) ? wmux30[55:48] : XACC_reg_word30_p6;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word30_p7;
    assign word30[63:56] = XACC_reg_word30_p7;
    always @(posedge clk or posedge localReset)
        XACC_reg_word30_p7 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk30_7) ? wmux30[63:56] : XACC_reg_word30_p7;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word30_p8;
    assign word30[71:64] = XACC_reg_word30_p8;
    always @(posedge clk or posedge localReset)
        XACC_reg_word30_p8 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk30_8) ? wmux30[71:64] : XACC_reg_word30_p8;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word30_p9;
    assign word30[79:72] = XACC_reg_word30_p9;
    always @(posedge clk or posedge localReset)
        XACC_reg_word30_p9 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk30_9) ? wmux30[79:72] : XACC_reg_word30_p9;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word30_p10;
    assign word30[87:80] = XACC_reg_word30_p10;
    always @(posedge clk or posedge localReset)
        XACC_reg_word30_p10 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk30_10) ? wmux30[87:80] : XACC_reg_word30_p10;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word30_p11;
    assign word30[95:88] = XACC_reg_word30_p11;
    always @(posedge clk or posedge localReset)
        XACC_reg_word30_p11 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk30_11) ? wmux30[95:88] : XACC_reg_word30_p11;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word30_p12;
    assign word30[103:96] = XACC_reg_word30_p12;
    always @(posedge clk or posedge localReset)
        XACC_reg_word30_p12 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk30_12) ? wmux30[103:96] : XACC_reg_word30_p12;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word30_p13;
    assign word30[111:104] = XACC_reg_word30_p13;
    always @(posedge clk or posedge localReset)
        XACC_reg_word30_p13 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk30_13) ? wmux30[111:104] : XACC_reg_word30_p13;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word30_p14;
    assign word30[119:112] = XACC_reg_word30_p14;
    always @(posedge clk or posedge localReset)
        XACC_reg_word30_p14 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk30_14) ? wmux30[119:112] : XACC_reg_word30_p14;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word30_p15;
    assign word30[127:120] = XACC_reg_word30_p15;
    always @(posedge clk or posedge localReset)
        XACC_reg_word30_p15 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk30_15) ? wmux30[127:120] : XACC_reg_word30_p15;

    wire [15:0] wr0_word_we31_C13 = wr0_we_C13 & {16{(wr0_addr_C13 == 5'd31)}};
    wire [15:0] wr1_word_we31_C13 = wr1_we_C13 & {16{(wr1_addr_C13 == 5'd31)}};
    wire [15:0] wr2_word_we31_C15 = wr2_we_C15 & {16{(wr2_addr_C15 == 5'd31)}};
    wire [15:0] wr3_word_we31_C14 = wr3_we_C14 & {16{(wr3_addr_C14 == 5'd31)}};
    wire [15:0] word31_we = 16'b0 | wr0_word_we31_C13 | wr1_word_we31_C13 | wr2_word_we31_C15 | wr3_word_we31_C14;
    wire gclk31_0;
assign gclk31_0 = word31_we[0];
    wire gclk31_1;
assign gclk31_1 = word31_we[1];
    wire gclk31_2;
assign gclk31_2 = word31_we[2];
    wire gclk31_3;
assign gclk31_3 = word31_we[3];
    wire gclk31_4;
assign gclk31_4 = word31_we[4];
    wire gclk31_5;
assign gclk31_5 = word31_we[5];
    wire gclk31_6;
assign gclk31_6 = word31_we[6];
    wire gclk31_7;
assign gclk31_7 = word31_we[7];
    wire gclk31_8;
assign gclk31_8 = word31_we[8];
    wire gclk31_9;
assign gclk31_9 = word31_we[9];
    wire gclk31_10;
assign gclk31_10 = word31_we[10];
    wire gclk31_11;
assign gclk31_11 = word31_we[11];
    wire gclk31_12;
assign gclk31_12 = word31_we[12];
    wire gclk31_13;
assign gclk31_13 = word31_we[13];
    wire gclk31_14;
assign gclk31_14 = word31_we[14];
    wire gclk31_15;
assign gclk31_15 = word31_we[15];
    wire [127:0] wmux31;
    reg [7:0] xtmux_1555;
    always @(*) begin
        xtmux_1555 = 8'b0;
        case({wr0_word_we31_C13[0],
            wr1_word_we31_C13[0],
            wr2_word_we31_C15[0],
            wr3_word_we31_C14[0]}) 
/* synopsys full_case */
            4'b1000: xtmux_1555 = wr0_data_C13[7:0];
            4'b0100: xtmux_1555 = wr1_data_C13[7:0];
            4'b0010: xtmux_1555 = wr2_data_C15[7:0];
            4'b0001: xtmux_1555 = wr3_data_C14[7:0];
        endcase
    end
    assign wmux31[7:0] = xtmux_1555;

    reg [7:0] xtmux_1556;
    always @(*) begin
        xtmux_1556 = 8'b0;
        case({wr0_word_we31_C13[1],
            wr1_word_we31_C13[1],
            wr2_word_we31_C15[1],
            wr3_word_we31_C14[1]}) 
/* synopsys full_case */
            4'b1000: xtmux_1556 = wr0_data_C13[15:8];
            4'b0100: xtmux_1556 = wr1_data_C13[15:8];
            4'b0010: xtmux_1556 = wr2_data_C15[15:8];
            4'b0001: xtmux_1556 = wr3_data_C14[15:8];
        endcase
    end
    assign wmux31[15:8] = xtmux_1556;

    reg [7:0] xtmux_1557;
    always @(*) begin
        xtmux_1557 = 8'b0;
        case({wr0_word_we31_C13[2],
            wr1_word_we31_C13[2],
            wr2_word_we31_C15[2],
            wr3_word_we31_C14[2]}) 
/* synopsys full_case */
            4'b1000: xtmux_1557 = wr0_data_C13[23:16];
            4'b0100: xtmux_1557 = wr1_data_C13[23:16];
            4'b0010: xtmux_1557 = wr2_data_C15[23:16];
            4'b0001: xtmux_1557 = wr3_data_C14[23:16];
        endcase
    end
    assign wmux31[23:16] = xtmux_1557;

    reg [7:0] xtmux_1558;
    always @(*) begin
        xtmux_1558 = 8'b0;
        case({wr0_word_we31_C13[3],
            wr1_word_we31_C13[3],
            wr2_word_we31_C15[3],
            wr3_word_we31_C14[3]}) 
/* synopsys full_case */
            4'b1000: xtmux_1558 = wr0_data_C13[31:24];
            4'b0100: xtmux_1558 = wr1_data_C13[31:24];
            4'b0010: xtmux_1558 = wr2_data_C15[31:24];
            4'b0001: xtmux_1558 = wr3_data_C14[31:24];
        endcase
    end
    assign wmux31[31:24] = xtmux_1558;

    reg [7:0] xtmux_1559;
    always @(*) begin
        xtmux_1559 = 8'b0;
        case({wr0_word_we31_C13[4],
            wr1_word_we31_C13[4],
            wr2_word_we31_C15[4],
            wr3_word_we31_C14[4]}) 
/* synopsys full_case */
            4'b1000: xtmux_1559 = wr0_data_C13[39:32];
            4'b0100: xtmux_1559 = wr1_data_C13[39:32];
            4'b0010: xtmux_1559 = wr2_data_C15[39:32];
            4'b0001: xtmux_1559 = wr3_data_C14[39:32];
        endcase
    end
    assign wmux31[39:32] = xtmux_1559;

    reg [7:0] xtmux_1560;
    always @(*) begin
        xtmux_1560 = 8'b0;
        case({wr0_word_we31_C13[5],
            wr1_word_we31_C13[5],
            wr2_word_we31_C15[5],
            wr3_word_we31_C14[5]}) 
/* synopsys full_case */
            4'b1000: xtmux_1560 = wr0_data_C13[47:40];
            4'b0100: xtmux_1560 = wr1_data_C13[47:40];
            4'b0010: xtmux_1560 = wr2_data_C15[47:40];
            4'b0001: xtmux_1560 = wr3_data_C14[47:40];
        endcase
    end
    assign wmux31[47:40] = xtmux_1560;

    reg [7:0] xtmux_1561;
    always @(*) begin
        xtmux_1561 = 8'b0;
        case({wr0_word_we31_C13[6],
            wr1_word_we31_C13[6],
            wr2_word_we31_C15[6],
            wr3_word_we31_C14[6]}) 
/* synopsys full_case */
            4'b1000: xtmux_1561 = wr0_data_C13[55:48];
            4'b0100: xtmux_1561 = wr1_data_C13[55:48];
            4'b0010: xtmux_1561 = wr2_data_C15[55:48];
            4'b0001: xtmux_1561 = wr3_data_C14[55:48];
        endcase
    end
    assign wmux31[55:48] = xtmux_1561;

    reg [7:0] xtmux_1562;
    always @(*) begin
        xtmux_1562 = 8'b0;
        case({wr0_word_we31_C13[7],
            wr1_word_we31_C13[7],
            wr2_word_we31_C15[7],
            wr3_word_we31_C14[7]}) 
/* synopsys full_case */
            4'b1000: xtmux_1562 = wr0_data_C13[63:56];
            4'b0100: xtmux_1562 = wr1_data_C13[63:56];
            4'b0010: xtmux_1562 = wr2_data_C15[63:56];
            4'b0001: xtmux_1562 = wr3_data_C14[63:56];
        endcase
    end
    assign wmux31[63:56] = xtmux_1562;

    reg [7:0] xtmux_1563;
    always @(*) begin
        xtmux_1563 = 8'b0;
        case({wr0_word_we31_C13[8],
            wr1_word_we31_C13[8],
            wr2_word_we31_C15[8],
            wr3_word_we31_C14[8]}) 
/* synopsys full_case */
            4'b1000: xtmux_1563 = wr0_data_C13[71:64];
            4'b0100: xtmux_1563 = wr1_data_C13[71:64];
            4'b0010: xtmux_1563 = wr2_data_C15[71:64];
            4'b0001: xtmux_1563 = wr3_data_C14[71:64];
        endcase
    end
    assign wmux31[71:64] = xtmux_1563;

    reg [7:0] xtmux_1564;
    always @(*) begin
        xtmux_1564 = 8'b0;
        case({wr0_word_we31_C13[9],
            wr1_word_we31_C13[9],
            wr2_word_we31_C15[9],
            wr3_word_we31_C14[9]}) 
/* synopsys full_case */
            4'b1000: xtmux_1564 = wr0_data_C13[79:72];
            4'b0100: xtmux_1564 = wr1_data_C13[79:72];
            4'b0010: xtmux_1564 = wr2_data_C15[79:72];
            4'b0001: xtmux_1564 = wr3_data_C14[79:72];
        endcase
    end
    assign wmux31[79:72] = xtmux_1564;

    reg [7:0] xtmux_1565;
    always @(*) begin
        xtmux_1565 = 8'b0;
        case({wr0_word_we31_C13[10],
            wr1_word_we31_C13[10],
            wr2_word_we31_C15[10],
            wr3_word_we31_C14[10]}) 
/* synopsys full_case */
            4'b1000: xtmux_1565 = wr0_data_C13[87:80];
            4'b0100: xtmux_1565 = wr1_data_C13[87:80];
            4'b0010: xtmux_1565 = wr2_data_C15[87:80];
            4'b0001: xtmux_1565 = wr3_data_C14[87:80];
        endcase
    end
    assign wmux31[87:80] = xtmux_1565;

    reg [7:0] xtmux_1566;
    always @(*) begin
        xtmux_1566 = 8'b0;
        case({wr0_word_we31_C13[11],
            wr1_word_we31_C13[11],
            wr2_word_we31_C15[11],
            wr3_word_we31_C14[11]}) 
/* synopsys full_case */
            4'b1000: xtmux_1566 = wr0_data_C13[95:88];
            4'b0100: xtmux_1566 = wr1_data_C13[95:88];
            4'b0010: xtmux_1566 = wr2_data_C15[95:88];
            4'b0001: xtmux_1566 = wr3_data_C14[95:88];
        endcase
    end
    assign wmux31[95:88] = xtmux_1566;

    reg [7:0] xtmux_1567;
    always @(*) begin
        xtmux_1567 = 8'b0;
        case({wr0_word_we31_C13[12],
            wr1_word_we31_C13[12],
            wr2_word_we31_C15[12],
            wr3_word_we31_C14[12]}) 
/* synopsys full_case */
            4'b1000: xtmux_1567 = wr0_data_C13[103:96];
            4'b0100: xtmux_1567 = wr1_data_C13[103:96];
            4'b0010: xtmux_1567 = wr2_data_C15[103:96];
            4'b0001: xtmux_1567 = wr3_data_C14[103:96];
        endcase
    end
    assign wmux31[103:96] = xtmux_1567;

    reg [7:0] xtmux_1568;
    always @(*) begin
        xtmux_1568 = 8'b0;
        case({wr0_word_we31_C13[13],
            wr1_word_we31_C13[13],
            wr2_word_we31_C15[13],
            wr3_word_we31_C14[13]}) 
/* synopsys full_case */
            4'b1000: xtmux_1568 = wr0_data_C13[111:104];
            4'b0100: xtmux_1568 = wr1_data_C13[111:104];
            4'b0010: xtmux_1568 = wr2_data_C15[111:104];
            4'b0001: xtmux_1568 = wr3_data_C14[111:104];
        endcase
    end
    assign wmux31[111:104] = xtmux_1568;

    reg [7:0] xtmux_1569;
    always @(*) begin
        xtmux_1569 = 8'b0;
        case({wr0_word_we31_C13[14],
            wr1_word_we31_C13[14],
            wr2_word_we31_C15[14],
            wr3_word_we31_C14[14]}) 
/* synopsys full_case */
            4'b1000: xtmux_1569 = wr0_data_C13[119:112];
            4'b0100: xtmux_1569 = wr1_data_C13[119:112];
            4'b0010: xtmux_1569 = wr2_data_C15[119:112];
            4'b0001: xtmux_1569 = wr3_data_C14[119:112];
        endcase
    end
    assign wmux31[119:112] = xtmux_1569;

    reg [7:0] xtmux_1570;
    always @(*) begin
        xtmux_1570 = 8'b0;
        case({wr0_word_we31_C13[15],
            wr1_word_we31_C13[15],
            wr2_word_we31_C15[15],
            wr3_word_we31_C14[15]}) 
/* synopsys full_case */
            4'b1000: xtmux_1570 = wr0_data_C13[127:120];
            4'b0100: xtmux_1570 = wr1_data_C13[127:120];
            4'b0010: xtmux_1570 = wr2_data_C15[127:120];
            4'b0001: xtmux_1570 = wr3_data_C14[127:120];
        endcase
    end
    assign wmux31[127:120] = xtmux_1570;

    wire [127:0] word31;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word31_p0;
    assign word31[7:0] = XACC_reg_word31_p0;
    always @(posedge clk or posedge localReset)
        XACC_reg_word31_p0 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk31_0) ? wmux31[7:0] : XACC_reg_word31_p0;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word31_p1;
    assign word31[15:8] = XACC_reg_word31_p1;
    always @(posedge clk or posedge localReset)
        XACC_reg_word31_p1 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk31_1) ? wmux31[15:8] : XACC_reg_word31_p1;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word31_p2;
    assign word31[23:16] = XACC_reg_word31_p2;
    always @(posedge clk or posedge localReset)
        XACC_reg_word31_p2 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk31_2) ? wmux31[23:16] : XACC_reg_word31_p2;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word31_p3;
    assign word31[31:24] = XACC_reg_word31_p3;
    always @(posedge clk or posedge localReset)
        XACC_reg_word31_p3 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk31_3) ? wmux31[31:24] : XACC_reg_word31_p3;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word31_p4;
    assign word31[39:32] = XACC_reg_word31_p4;
    always @(posedge clk or posedge localReset)
        XACC_reg_word31_p4 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk31_4) ? wmux31[39:32] : XACC_reg_word31_p4;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word31_p5;
    assign word31[47:40] = XACC_reg_word31_p5;
    always @(posedge clk or posedge localReset)
        XACC_reg_word31_p5 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk31_5) ? wmux31[47:40] : XACC_reg_word31_p5;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word31_p6;
    assign word31[55:48] = XACC_reg_word31_p6;
    always @(posedge clk or posedge localReset)
        XACC_reg_word31_p6 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk31_6) ? wmux31[55:48] : XACC_reg_word31_p6;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word31_p7;
    assign word31[63:56] = XACC_reg_word31_p7;
    always @(posedge clk or posedge localReset)
        XACC_reg_word31_p7 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk31_7) ? wmux31[63:56] : XACC_reg_word31_p7;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word31_p8;
    assign word31[71:64] = XACC_reg_word31_p8;
    always @(posedge clk or posedge localReset)
        XACC_reg_word31_p8 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk31_8) ? wmux31[71:64] : XACC_reg_word31_p8;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word31_p9;
    assign word31[79:72] = XACC_reg_word31_p9;
    always @(posedge clk or posedge localReset)
        XACC_reg_word31_p9 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk31_9) ? wmux31[79:72] : XACC_reg_word31_p9;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word31_p10;
    assign word31[87:80] = XACC_reg_word31_p10;
    always @(posedge clk or posedge localReset)
        XACC_reg_word31_p10 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk31_10) ? wmux31[87:80] : XACC_reg_word31_p10;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word31_p11;
    assign word31[95:88] = XACC_reg_word31_p11;
    always @(posedge clk or posedge localReset)
        XACC_reg_word31_p11 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk31_11) ? wmux31[95:88] : XACC_reg_word31_p11;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word31_p12;
    assign word31[103:96] = XACC_reg_word31_p12;
    always @(posedge clk or posedge localReset)
        XACC_reg_word31_p12 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk31_12) ? wmux31[103:96] : XACC_reg_word31_p12;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word31_p13;
    assign word31[111:104] = XACC_reg_word31_p13;
    always @(posedge clk or posedge localReset)
        XACC_reg_word31_p13 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk31_13) ? wmux31[111:104] : XACC_reg_word31_p13;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word31_p14;
    assign word31[119:112] = XACC_reg_word31_p14;
    always @(posedge clk or posedge localReset)
        XACC_reg_word31_p14 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk31_14) ? wmux31[119:112] : XACC_reg_word31_p14;
// synopsys async_set_reset "localReset"
    reg [7:0] XACC_reg_word31_p15;
    assign word31[127:120] = XACC_reg_word31_p15;
    always @(posedge clk or posedge localReset)
        XACC_reg_word31_p15 <= `XT_SEQ_DELAY (localReset) ? 8'b0 : 
        (1'b1 & gclk31_15) ? wmux31[127:120] : XACC_reg_word31_p15;

    wire [127:0] rd0_data_pre_C9;
reg [127:0] xtmuxe_141;
always @(*) begin
    xtmuxe_141 = 128'b0;
    case(rd0_addr_C9[4:0])
        5'd0 : xtmuxe_141 = word0;
        5'd1 : xtmuxe_141 = word1;
        5'd2 : xtmuxe_141 = word2;
        5'd3 : xtmuxe_141 = word3;
        5'd4 : xtmuxe_141 = word4;
        5'd5 : xtmuxe_141 = word5;
        5'd6 : xtmuxe_141 = word6;
        5'd7 : xtmuxe_141 = word7;
        5'd8 : xtmuxe_141 = word8;
        5'd9 : xtmuxe_141 = word9;
        5'd10 : xtmuxe_141 = word10;
        5'd11 : xtmuxe_141 = word11;
        5'd12 : xtmuxe_141 = word12;
        5'd13 : xtmuxe_141 = word13;
        5'd14 : xtmuxe_141 = word14;
        5'd15 : xtmuxe_141 = word15;
        5'd16 : xtmuxe_141 = word16;
        5'd17 : xtmuxe_141 = word17;
        5'd18 : xtmuxe_141 = word18;
        5'd19 : xtmuxe_141 = word19;
        5'd20 : xtmuxe_141 = word20;
        5'd21 : xtmuxe_141 = word21;
        5'd22 : xtmuxe_141 = word22;
        5'd23 : xtmuxe_141 = word23;
        5'd24 : xtmuxe_141 = word24;
        5'd25 : xtmuxe_141 = word25;
        5'd26 : xtmuxe_141 = word26;
        5'd27 : xtmuxe_141 = word27;
        5'd28 : xtmuxe_141 = word28;
        5'd29 : xtmuxe_141 = word29;
        5'd30 : xtmuxe_141 = word30;
        5'd31 : xtmuxe_141 = word31;
`ifdef NOXPROP
        default : xtmuxe_141 = {128{1'b0}};
`else
        default : xtmuxe_141 = {128{1'bx}};
`endif
    endcase
end
assign rd0_data_pre_C9 = xtmuxe_141;

    assign rd0_data_C9 = rd0_data_pre_C9;
    wire [127:0] rd1_data_pre_C9;
reg [127:0] xtmuxe_142;
always @(*) begin
    xtmuxe_142 = 128'b0;
    case(rd1_addr_C9[4:0])
        5'd0 : xtmuxe_142 = word0;
        5'd1 : xtmuxe_142 = word1;
        5'd2 : xtmuxe_142 = word2;
        5'd3 : xtmuxe_142 = word3;
        5'd4 : xtmuxe_142 = word4;
        5'd5 : xtmuxe_142 = word5;
        5'd6 : xtmuxe_142 = word6;
        5'd7 : xtmuxe_142 = word7;
        5'd8 : xtmuxe_142 = word8;
        5'd9 : xtmuxe_142 = word9;
        5'd10 : xtmuxe_142 = word10;
        5'd11 : xtmuxe_142 = word11;
        5'd12 : xtmuxe_142 = word12;
        5'd13 : xtmuxe_142 = word13;
        5'd14 : xtmuxe_142 = word14;
        5'd15 : xtmuxe_142 = word15;
        5'd16 : xtmuxe_142 = word16;
        5'd17 : xtmuxe_142 = word17;
        5'd18 : xtmuxe_142 = word18;
        5'd19 : xtmuxe_142 = word19;
        5'd20 : xtmuxe_142 = word20;
        5'd21 : xtmuxe_142 = word21;
        5'd22 : xtmuxe_142 = word22;
        5'd23 : xtmuxe_142 = word23;
        5'd24 : xtmuxe_142 = word24;
        5'd25 : xtmuxe_142 = word25;
        5'd26 : xtmuxe_142 = word26;
        5'd27 : xtmuxe_142 = word27;
        5'd28 : xtmuxe_142 = word28;
        5'd29 : xtmuxe_142 = word29;
        5'd30 : xtmuxe_142 = word30;
        5'd31 : xtmuxe_142 = word31;
`ifdef NOXPROP
        default : xtmuxe_142 = {128{1'b0}};
`else
        default : xtmuxe_142 = {128{1'bx}};
`endif
    endcase
end
assign rd1_data_pre_C9 = xtmuxe_142;

    assign rd1_data_C9 = rd1_data_pre_C9;
    wire [127:0] rd2_data_pre_C9;
reg [127:0] xtmuxe_143;
always @(*) begin
    xtmuxe_143 = 128'b0;
    case(rd2_addr_C9[4:0])
        5'd0 : xtmuxe_143 = word0;
        5'd1 : xtmuxe_143 = word1;
        5'd2 : xtmuxe_143 = word2;
        5'd3 : xtmuxe_143 = word3;
        5'd4 : xtmuxe_143 = word4;
        5'd5 : xtmuxe_143 = word5;
        5'd6 : xtmuxe_143 = word6;
        5'd7 : xtmuxe_143 = word7;
        5'd8 : xtmuxe_143 = word8;
        5'd9 : xtmuxe_143 = word9;
        5'd10 : xtmuxe_143 = word10;
        5'd11 : xtmuxe_143 = word11;
        5'd12 : xtmuxe_143 = word12;
        5'd13 : xtmuxe_143 = word13;
        5'd14 : xtmuxe_143 = word14;
        5'd15 : xtmuxe_143 = word15;
        5'd16 : xtmuxe_143 = word16;
        5'd17 : xtmuxe_143 = word17;
        5'd18 : xtmuxe_143 = word18;
        5'd19 : xtmuxe_143 = word19;
        5'd20 : xtmuxe_143 = word20;
        5'd21 : xtmuxe_143 = word21;
        5'd22 : xtmuxe_143 = word22;
        5'd23 : xtmuxe_143 = word23;
        5'd24 : xtmuxe_143 = word24;
        5'd25 : xtmuxe_143 = word25;
        5'd26 : xtmuxe_143 = word26;
        5'd27 : xtmuxe_143 = word27;
        5'd28 : xtmuxe_143 = word28;
        5'd29 : xtmuxe_143 = word29;
        5'd30 : xtmuxe_143 = word30;
        5'd31 : xtmuxe_143 = word31;
`ifdef NOXPROP
        default : xtmuxe_143 = {128{1'b0}};
`else
        default : xtmuxe_143 = {128{1'bx}};
`endif
    endcase
end
assign rd2_data_pre_C9 = xtmuxe_143;

    assign rd2_data_C9 = rd2_data_pre_C9;
    wire [127:0] rd3_data_pre_C9;
reg [127:0] xtmuxe_144;
always @(*) begin
    xtmuxe_144 = 128'b0;
    case(rd3_addr_C9[4:0])
        5'd0 : xtmuxe_144 = word0;
        5'd1 : xtmuxe_144 = word1;
        5'd2 : xtmuxe_144 = word2;
        5'd3 : xtmuxe_144 = word3;
        5'd4 : xtmuxe_144 = word4;
        5'd5 : xtmuxe_144 = word5;
        5'd6 : xtmuxe_144 = word6;
        5'd7 : xtmuxe_144 = word7;
        5'd8 : xtmuxe_144 = word8;
        5'd9 : xtmuxe_144 = word9;
        5'd10 : xtmuxe_144 = word10;
        5'd11 : xtmuxe_144 = word11;
        5'd12 : xtmuxe_144 = word12;
        5'd13 : xtmuxe_144 = word13;
        5'd14 : xtmuxe_144 = word14;
        5'd15 : xtmuxe_144 = word15;
        5'd16 : xtmuxe_144 = word16;
        5'd17 : xtmuxe_144 = word17;
        5'd18 : xtmuxe_144 = word18;
        5'd19 : xtmuxe_144 = word19;
        5'd20 : xtmuxe_144 = word20;
        5'd21 : xtmuxe_144 = word21;
        5'd22 : xtmuxe_144 = word22;
        5'd23 : xtmuxe_144 = word23;
        5'd24 : xtmuxe_144 = word24;
        5'd25 : xtmuxe_144 = word25;
        5'd26 : xtmuxe_144 = word26;
        5'd27 : xtmuxe_144 = word27;
        5'd28 : xtmuxe_144 = word28;
        5'd29 : xtmuxe_144 = word29;
        5'd30 : xtmuxe_144 = word30;
        5'd31 : xtmuxe_144 = word31;
`ifdef NOXPROP
        default : xtmuxe_144 = {128{1'b0}};
`else
        default : xtmuxe_144 = {128{1'bx}};
`endif
    endcase
end
assign rd3_data_pre_C9 = xtmuxe_144;

    assign rd3_data_C9 = rd3_data_pre_C9;
    wire [127:0] rd4_data_pre_C9;
reg [127:0] xtmuxe_145;
always @(*) begin
    xtmuxe_145 = 128'b0;
    case(rd4_addr_C9[4:0])
        5'd0 : xtmuxe_145 = word0;
        5'd1 : xtmuxe_145 = word1;
        5'd2 : xtmuxe_145 = word2;
        5'd3 : xtmuxe_145 = word3;
        5'd4 : xtmuxe_145 = word4;
        5'd5 : xtmuxe_145 = word5;
        5'd6 : xtmuxe_145 = word6;
        5'd7 : xtmuxe_145 = word7;
        5'd8 : xtmuxe_145 = word8;
        5'd9 : xtmuxe_145 = word9;
        5'd10 : xtmuxe_145 = word10;
        5'd11 : xtmuxe_145 = word11;
        5'd12 : xtmuxe_145 = word12;
        5'd13 : xtmuxe_145 = word13;
        5'd14 : xtmuxe_145 = word14;
        5'd15 : xtmuxe_145 = word15;
        5'd16 : xtmuxe_145 = word16;
        5'd17 : xtmuxe_145 = word17;
        5'd18 : xtmuxe_145 = word18;
        5'd19 : xtmuxe_145 = word19;
        5'd20 : xtmuxe_145 = word20;
        5'd21 : xtmuxe_145 = word21;
        5'd22 : xtmuxe_145 = word22;
        5'd23 : xtmuxe_145 = word23;
        5'd24 : xtmuxe_145 = word24;
        5'd25 : xtmuxe_145 = word25;
        5'd26 : xtmuxe_145 = word26;
        5'd27 : xtmuxe_145 = word27;
        5'd28 : xtmuxe_145 = word28;
        5'd29 : xtmuxe_145 = word29;
        5'd30 : xtmuxe_145 = word30;
        5'd31 : xtmuxe_145 = word31;
`ifdef NOXPROP
        default : xtmuxe_145 = {128{1'b0}};
`else
        default : xtmuxe_145 = {128{1'bx}};
`endif
    endcase
end
assign rd4_data_pre_C9 = xtmuxe_145;

    assign rd4_data_C9 = rd4_data_pre_C9;
    wire [127:0] rd5_data_pre_C9;
reg [127:0] xtmuxe_146;
always @(*) begin
    xtmuxe_146 = 128'b0;
    case(rd5_addr_C9[4:0])
        5'd0 : xtmuxe_146 = word0;
        5'd1 : xtmuxe_146 = word1;
        5'd2 : xtmuxe_146 = word2;
        5'd3 : xtmuxe_146 = word3;
        5'd4 : xtmuxe_146 = word4;
        5'd5 : xtmuxe_146 = word5;
        5'd6 : xtmuxe_146 = word6;
        5'd7 : xtmuxe_146 = word7;
        5'd8 : xtmuxe_146 = word8;
        5'd9 : xtmuxe_146 = word9;
        5'd10 : xtmuxe_146 = word10;
        5'd11 : xtmuxe_146 = word11;
        5'd12 : xtmuxe_146 = word12;
        5'd13 : xtmuxe_146 = word13;
        5'd14 : xtmuxe_146 = word14;
        5'd15 : xtmuxe_146 = word15;
        5'd16 : xtmuxe_146 = word16;
        5'd17 : xtmuxe_146 = word17;
        5'd18 : xtmuxe_146 = word18;
        5'd19 : xtmuxe_146 = word19;
        5'd20 : xtmuxe_146 = word20;
        5'd21 : xtmuxe_146 = word21;
        5'd22 : xtmuxe_146 = word22;
        5'd23 : xtmuxe_146 = word23;
        5'd24 : xtmuxe_146 = word24;
        5'd25 : xtmuxe_146 = word25;
        5'd26 : xtmuxe_146 = word26;
        5'd27 : xtmuxe_146 = word27;
        5'd28 : xtmuxe_146 = word28;
        5'd29 : xtmuxe_146 = word29;
        5'd30 : xtmuxe_146 = word30;
        5'd31 : xtmuxe_146 = word31;
`ifdef NOXPROP
        default : xtmuxe_146 = {128{1'b0}};
`else
        default : xtmuxe_146 = {128{1'bx}};
`endif
    endcase
end
assign rd5_data_pre_C9 = xtmuxe_146;

    assign rd5_data_C9 = rd5_data_pre_C9;
    wire [127:0] rd6_data_pre_C9;
reg [127:0] xtmuxe_147;
always @(*) begin
    xtmuxe_147 = 128'b0;
    case(rd6_addr_C9[4:0])
        5'd0 : xtmuxe_147 = word0;
        5'd1 : xtmuxe_147 = word1;
        5'd2 : xtmuxe_147 = word2;
        5'd3 : xtmuxe_147 = word3;
        5'd4 : xtmuxe_147 = word4;
        5'd5 : xtmuxe_147 = word5;
        5'd6 : xtmuxe_147 = word6;
        5'd7 : xtmuxe_147 = word7;
        5'd8 : xtmuxe_147 = word8;
        5'd9 : xtmuxe_147 = word9;
        5'd10 : xtmuxe_147 = word10;
        5'd11 : xtmuxe_147 = word11;
        5'd12 : xtmuxe_147 = word12;
        5'd13 : xtmuxe_147 = word13;
        5'd14 : xtmuxe_147 = word14;
        5'd15 : xtmuxe_147 = word15;
        5'd16 : xtmuxe_147 = word16;
        5'd17 : xtmuxe_147 = word17;
        5'd18 : xtmuxe_147 = word18;
        5'd19 : xtmuxe_147 = word19;
        5'd20 : xtmuxe_147 = word20;
        5'd21 : xtmuxe_147 = word21;
        5'd22 : xtmuxe_147 = word22;
        5'd23 : xtmuxe_147 = word23;
        5'd24 : xtmuxe_147 = word24;
        5'd25 : xtmuxe_147 = word25;
        5'd26 : xtmuxe_147 = word26;
        5'd27 : xtmuxe_147 = word27;
        5'd28 : xtmuxe_147 = word28;
        5'd29 : xtmuxe_147 = word29;
        5'd30 : xtmuxe_147 = word30;
        5'd31 : xtmuxe_147 = word31;
`ifdef NOXPROP
        default : xtmuxe_147 = {128{1'b0}};
`else
        default : xtmuxe_147 = {128{1'bx}};
`endif
    endcase
end
assign rd6_data_pre_C9 = xtmuxe_147;

    assign rd6_data_C9 = rd6_data_pre_C9;
endmodule*/

import chisel3._
import chisel3.util._
import chisel3.experimental.{chiselName, annotate, ChiselAnnotation}
//import chisel3.internal.instanceId.InstanceId
import firrtl.annotations._
import primitives._


class VecRegSlice(
    val numRegs: Int = 32, // 寄存器数量，默认32
    val regWidth: Int = 128, // 寄存器宽度，默认128位
    val numWritePorts: Int = 4, // 写端口数量，默认4
    val numReadPorts: Int = 6 // 写端口数量，默认4
) extends Module {
    val addrWidth = log2Ceil(numRegs)
    val io = IO(new Bundle {
        // val clk         = Input(Clock())
        // val localReset  = Input(Bool())
        val wr_addr     = Input(Vec(numWritePorts, UInt(addrWidth.W)))
        val wr_data     = Input(Vec(numWritePorts, UInt(regWidth.W)))
        val we          = Input(Vec(numWritePorts, UInt((regWidth/8).W)))
        val rd_addr     = Input(Vec(numReadPorts, UInt(addrWidth.W)))
        val rd_data     = Output(Vec(numReadPorts,UInt(regWidth.W)))
})

    // def nameSignals[T <: Data](signal: T, name: String): T = {
    //     annotate(new ChiselAnnotation {
    //         def toFirrtl: Annotation = {
    //             val ref = chisel3.experimental.ref(signal)
    //             firrtl.annotations.Annotation(ref, classOf[firrtl.transforms.DontTouchAnnotation], "")
    //         }
    //     })
    //     signal.suggestName(name)
    //     signal
    // }

    val words = Wire(Vec(numRegs,UInt(regWidth.W)))
    val regWidthByByte= regWidth/8
    for (regIdx <- 0 until numRegs) {

        val finalWdata = Wire(Vec(regWidth/8,UInt(8.W)))
        for (byteIdx <- 0 until regWidthByByte) {   //for each byte
            val wr = Wire(Vec(numWritePorts, Bool()))
            val dataVec = Wire(Vec(numWritePorts, UInt(8.W)))
            
            for (wrPort <- 0 until numWritePorts) {
                wr(wrPort) := io.we(wrPort)(byteIdx) && (io.wr_addr(wrPort) === regIdx.U)
                dataVec(wrPort) := io.wr_data(wrPort)(byteIdx*8 + 7, byteIdx*8)
            }

            val wmux = Mux1H(wr, dataVec)
            val word_we= wr.reduce(_ || _)

            // withClockAndReset(io.clk, io.reset.asAsyncReset()) {
               // val regByte = RegNext(selectedData, 0.U(8.W))
                //nameSignals(regByte, s"XACC_reg_word${regIdx}_p${byteIdx / 8}")
           /*  when(word_we) {
                    finalWdata(byteIdx)/* (byteIdx*8 + 7, byteIdx*8) */ := wmux
                }.otherwise{
                    finalWdata(byteIdx) :=  words(regIdx)(byteIdx*8 + 7, byteIdx*8)
            } */
            val Xacc_reg_p = g_ff(8,word_we,wmux)
            Xacc_reg_p.suggestName(s"reg${regIdx}_p${byteIdx}")
            //annotate(annotateName(s"Xacc_reg${regIdx}_p${byteIdx}"), Xacc_reg_p)
            finalWdata(byteIdx) :=Xacc_reg_p
            //words(regIdx).bitSet(byteIdx*8 + 7, byteIdx*8,Xacc_reg_B)

           // }
        }
        words(regIdx) :=Cat(finalWdata.reverse)

    }

  for (i <- 0 until numReadPorts) {
    io.rd_data(i) := MuxCase(0.U(regWidth.W), words.zipWithIndex.map { 
        case (word, idx) =>    (io.rd_addr(i) === idx.U, word)
    })
  }



}