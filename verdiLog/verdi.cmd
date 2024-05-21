simSetSimulator "-vcssv" -exec "simv" -args "+dumpon +TC=dual_div +vcs+lic+wait"
debImport "-dbdir" "simv.daidir"
debLoadSimResult /data2/open-riscv/acemicro/acemicro_m1/m1-v0/dual_div.fsdb
wvCreateWindow
wvRestoreSignal -win $_nWave2 \
           "/data2/open-riscv/acemicro/acemicro_m1/m1-v0/signal.rc" \
           -overWriteAutoAlias on -appendSignals on
wvSelectSignal -win $_nWave2 {( "G1" 10 )} 
wvSelectSignal -win $_nWave2 {( "G1" 10 )} 
wvSelectSignal -win $_nWave2 {( "G1" 4 )} 
wvSelectSignal -win $_nWave2 {( "G1" 1 )} 
wvZoomOut -win $_nWave2
wvZoomOut -win $_nWave2
wvZoomOut -win $_nWave2
wvZoomOut -win $_nWave2
wvSelectSignal -win $_nWave2 {( "G1" 8 )} 
wvSelectSignal -win $_nWave2 {( "G1" 11 )} 
wvSelectSignal -win $_nWave2 {( "G1" 14 )} 
wvSelectSignal -win $_nWave2 {( "G1" 12 )} 
wvCut -win $_nWave2
wvSetPosition -win $_nWave2 {("G1" 5)}
wvSelectSignal -win $_nWave2 {( "G1" 13 )} 
wvCut -win $_nWave2
wvSetPosition -win $_nWave2 {("G1" 5)}
wvSelectSignal -win $_nWave2 {( "G1" 12 )} 
wvSelectSignal -win $_nWave2 {( "G1" 11 )} 
wvSetPosition -win $_nWave2 {("G1" 11)}
wvSetPosition -win $_nWave2 {("G1" 12)}
wvSetPosition -win $_nWave2 {("G1" 13)}
wvSetPosition -win $_nWave2 {("G1" 14)}
wvSetPosition -win $_nWave2 {("G1" 15)}
wvSetPosition -win $_nWave2 {("G1" 16)}
wvSetPosition -win $_nWave2 {("G1" 17)}
wvSetPosition -win $_nWave2 {("G1" 18)}
wvSetPosition -win $_nWave2 {("G1" 19)}
wvSetPosition -win $_nWave2 {("G1" 20)}
wvSetPosition -win $_nWave2 {("G2" 0)}
wvMoveSelected -win $_nWave2
wvSetPosition -win $_nWave2 {("G2" 1)}
wvSetPosition -win $_nWave2 {("G2" 1)}
wvGetSignalOpen -win $_nWave2
wvGetSignalSetSignalFilter -win $_nWave2 "*div*"
wvSetPosition -win $_nWave2 {("G2" 1)}
wvSetPosition -win $_nWave2 {("G2" 1)}
wvAddSignal -win $_nWave2 -clear
wvAddSignal -win $_nWave2 -group {"G1" \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_inst_wb1\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i1_cinst_d\[15:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i1_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_ib0_valid_d} -height 25 \
{/tb_top/rvtop/veer/dec/mul_p} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc4_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift2} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib1_ib0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib2_ib0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib2_ib1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib3_ib1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib3_ib2} -height 25 \
}
wvAddSignal -win $_nWave2 -group {"G2" \
{/tb_top/rvtop/veer/dec/dec_tlu_dual_issue_disable} -height 25 \
}
wvAddSignal -win $_nWave2 -group {"G3" \
}
wvSetPosition -win $_nWave2 {("G2" 1)}
wvSetPosition -win $_nWave2 {("G2" 11)}
wvSetPosition -win $_nWave2 {("G2" 11)}
wvAddSignal -win $_nWave2 -clear
wvAddSignal -win $_nWave2 -group {"G1" \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_inst_wb1\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i1_cinst_d\[15:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i1_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_ib0_valid_d} -height 25 \
{/tb_top/rvtop/veer/dec/mul_p} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc4_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift2} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib1_ib0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib2_ib0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib2_ib1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib3_ib1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib3_ib2} -height 25 \
}
wvAddSignal -win $_nWave2 -group {"G2" \
{/tb_top/rvtop/veer/dec/dec_tlu_dual_issue_disable} -height 25 \
{/tb_top/rvtop/veer/dec/decode/div_p} -height 25 \
{/tb_top/rvtop/veer/dec/decode/div_pc\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/decode/div_stall} -height 25 \
{/tb_top/rvtop/veer/dec/decode/div_trigger\[3:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/decode/div_waddr_wb\[4:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/decode/div_wen_wb} -height 25 \
{/tb_top/rvtop/veer/dec/decode/exu_div_finish} -height 25 \
{/tb_top/rvtop/veer/dec/decode/exu_div_result\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/decode/exu_div_stall} -height 25 \
{/tb_top/rvtop/veer/dec/decode/i0_div_decode_d} -height 25 \
}
wvAddSignal -win $_nWave2 -group {"G3" \
}
wvSelectSignal -win $_nWave2 {( "G2" 2 3 4 5 6 7 8 9 10 11 )} 
wvSetPosition -win $_nWave2 {("G2" 11)}
wvSetPosition -win $_nWave2 {("G2" 11)}
wvSetPosition -win $_nWave2 {("G2" 11)}
wvAddSignal -win $_nWave2 -clear
wvAddSignal -win $_nWave2 -group {"G1" \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_inst_wb1\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i1_cinst_d\[15:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i1_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_ib0_valid_d} -height 25 \
{/tb_top/rvtop/veer/dec/mul_p} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc4_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift2} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib1_ib0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib2_ib0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib2_ib1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib3_ib1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib3_ib2} -height 25 \
}
wvAddSignal -win $_nWave2 -group {"G2" \
{/tb_top/rvtop/veer/dec/dec_tlu_dual_issue_disable} -height 25 \
{/tb_top/rvtop/veer/dec/decode/div_p} -height 25 \
{/tb_top/rvtop/veer/dec/decode/div_pc\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/decode/div_stall} -height 25 \
{/tb_top/rvtop/veer/dec/decode/div_trigger\[3:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/decode/div_waddr_wb\[4:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/decode/div_wen_wb} -height 25 \
{/tb_top/rvtop/veer/dec/decode/exu_div_finish} -height 25 \
{/tb_top/rvtop/veer/dec/decode/exu_div_result\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/decode/exu_div_stall} -height 25 \
{/tb_top/rvtop/veer/dec/decode/i0_div_decode_d} -height 25 \
}
wvAddSignal -win $_nWave2 -group {"G3" \
}
wvSelectSignal -win $_nWave2 {( "G2" 2 3 4 5 6 7 8 9 10 11 )} 
wvSetPosition -win $_nWave2 {("G2" 11)}
wvGetSignalClose -win $_nWave2
wvSelectSignal -win $_nWave2 {( "G2" 5 )} 
wvSelectSignal -win $_nWave2 {( "G2" 2 )} 
wvSelectSignal -win $_nWave2 {( "G2" 4 )} 
wvSelectSignal -win $_nWave2 {( "G2" 8 )} 
wvSelectSignal -win $_nWave2 {( "G2" 9 )} 
wvZoom -win $_nWave2 473.362241 1184.565804
wvScrollUp -win $_nWave2 10
wvGetSignalOpen -win $_nWave2
wvGetSignalSetScope -win $_nWave2 "/_vcs_unit__1703114041"
wvGetSignalSetScope -win $_nWave2 "/tb_top"
wvGetSignalSetScope -win $_nWave2 "/tb_top/rvtop"
wvGetSignalSetScope -win $_nWave2 "/tb_top/rvtop/veer"
wvGetSignalSetScope -win $_nWave2 "/tb_top/rvtop/veer/dec"
wvGetSignalSetScope -win $_nWave2 "/tb_top/rvtop/veer/dec/decode"
wvGetSignalSetScope -win $_nWave2 "/tb_top/rvtop/veer/dec/instbuff"
wvGetSignalSetScope -win $_nWave2 "/tb_top/rvtop/veer/dec/decode"
wvGetSignalSetScope -win $_nWave2 "/tb_top/rvtop/veer/dec"
wvGetSignalSetScope -win $_nWave2 "/tb_top/rvtop/veer"
wvGetSignalSetSignalFilter -win $_nWave2 "*clk*"
wvSetPosition -win $_nWave2 {("G2" 11)}
wvSetPosition -win $_nWave2 {("G2" 11)}
wvAddSignal -win $_nWave2 -clear
wvAddSignal -win $_nWave2 -group {"G1" \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_inst_wb1\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i1_cinst_d\[15:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i1_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_ib0_valid_d} -height 25 \
{/tb_top/rvtop/veer/dec/mul_p} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc4_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift2} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib1_ib0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib2_ib0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib2_ib1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib3_ib1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib3_ib2} -height 25 \
}
wvAddSignal -win $_nWave2 -group {"G2" \
{/tb_top/rvtop/veer/dec/dec_tlu_dual_issue_disable} -height 25 \
{/tb_top/rvtop/veer/dec/decode/div_p} -height 25 \
{/tb_top/rvtop/veer/dec/decode/div_pc\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/decode/div_stall} -height 25 \
{/tb_top/rvtop/veer/dec/decode/div_trigger\[3:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/decode/div_waddr_wb\[4:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/decode/div_wen_wb} -height 25 \
{/tb_top/rvtop/veer/dec/decode/exu_div_finish} -height 25 \
{/tb_top/rvtop/veer/dec/decode/exu_div_result\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/decode/exu_div_stall} -height 25 \
{/tb_top/rvtop/veer/dec/decode/i0_div_decode_d} -height 25 \
}
wvAddSignal -win $_nWave2 -group {"G3" \
}
wvSetPosition -win $_nWave2 {("G2" 11)}
wvSetPosition -win $_nWave2 {("G2" 12)}
wvSetPosition -win $_nWave2 {("G2" 12)}
wvAddSignal -win $_nWave2 -clear
wvAddSignal -win $_nWave2 -group {"G1" \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_inst_wb1\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i1_cinst_d\[15:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i1_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_ib0_valid_d} -height 25 \
{/tb_top/rvtop/veer/dec/mul_p} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc4_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift2} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib1_ib0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib2_ib0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib2_ib1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib3_ib1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib3_ib2} -height 25 \
}
wvAddSignal -win $_nWave2 -group {"G2" \
{/tb_top/rvtop/veer/dec/dec_tlu_dual_issue_disable} -height 25 \
{/tb_top/rvtop/veer/dec/decode/div_p} -height 25 \
{/tb_top/rvtop/veer/dec/decode/div_pc\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/decode/div_stall} -height 25 \
{/tb_top/rvtop/veer/dec/decode/div_trigger\[3:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/decode/div_waddr_wb\[4:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/decode/div_wen_wb} -height 25 \
{/tb_top/rvtop/veer/dec/decode/exu_div_finish} -height 25 \
{/tb_top/rvtop/veer/dec/decode/exu_div_result\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/decode/exu_div_stall} -height 25 \
{/tb_top/rvtop/veer/dec/decode/i0_div_decode_d} -height 25 \
{/tb_top/rvtop/veer/clk} -height 25 \
}
wvAddSignal -win $_nWave2 -group {"G3" \
}
wvSelectSignal -win $_nWave2 {( "G2" 12 )} 
wvSetPosition -win $_nWave2 {("G2" 12)}
wvSetPosition -win $_nWave2 {("G2" 12)}
wvSetPosition -win $_nWave2 {("G2" 12)}
wvAddSignal -win $_nWave2 -clear
wvAddSignal -win $_nWave2 -group {"G1" \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_inst_wb1\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i1_cinst_d\[15:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i1_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_ib0_valid_d} -height 25 \
{/tb_top/rvtop/veer/dec/mul_p} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc4_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift2} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib1_ib0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib2_ib0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib2_ib1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib3_ib1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib3_ib2} -height 25 \
}
wvAddSignal -win $_nWave2 -group {"G2" \
{/tb_top/rvtop/veer/dec/dec_tlu_dual_issue_disable} -height 25 \
{/tb_top/rvtop/veer/dec/decode/div_p} -height 25 \
{/tb_top/rvtop/veer/dec/decode/div_pc\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/decode/div_stall} -height 25 \
{/tb_top/rvtop/veer/dec/decode/div_trigger\[3:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/decode/div_waddr_wb\[4:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/decode/div_wen_wb} -height 25 \
{/tb_top/rvtop/veer/dec/decode/exu_div_finish} -height 25 \
{/tb_top/rvtop/veer/dec/decode/exu_div_result\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/decode/exu_div_stall} -height 25 \
{/tb_top/rvtop/veer/dec/decode/i0_div_decode_d} -height 25 \
{/tb_top/rvtop/veer/clk} -height 25 \
}
wvAddSignal -win $_nWave2 -group {"G3" \
}
wvSelectSignal -win $_nWave2 {( "G2" 12 )} 
wvSetPosition -win $_nWave2 {("G2" 12)}
wvGetSignalClose -win $_nWave2
wvSetPosition -win $_nWave2 {("G2" 11)}
wvSetPosition -win $_nWave2 {("G2" 10)}
wvSetPosition -win $_nWave2 {("G2" 9)}
wvSetPosition -win $_nWave2 {("G2" 8)}
wvSetPosition -win $_nWave2 {("G2" 7)}
wvSetPosition -win $_nWave2 {("G2" 6)}
wvSetPosition -win $_nWave2 {("G2" 5)}
wvSetPosition -win $_nWave2 {("G2" 4)}
wvSetPosition -win $_nWave2 {("G2" 3)}
wvSetPosition -win $_nWave2 {("G2" 2)}
wvSetPosition -win $_nWave2 {("G2" 1)}
wvSetPosition -win $_nWave2 {("G2" 0)}
wvMoveSelected -win $_nWave2
wvSetPosition -win $_nWave2 {("G2" 0)}
wvSetPosition -win $_nWave2 {("G2" 1)}
wvSelectSignal -win $_nWave2 {( "G2" 8 )} 
wvSelectSignal -win $_nWave2 {( "G2" 9 )} 
wvSelectSignal -win $_nWave2 {( "G2" 8 )} 
wvSelectSignal -win $_nWave2 {( "G2" 10 )} 
wvSelectSignal -win $_nWave2 {( "G2" 11 )} 
wvScrollUp -win $_nWave2 11
wvScrollDown -win $_nWave2 11
wvSelectSignal -win $_nWave2 {( "G2" 3 )} 
wvSetPosition -win $_nWave2 {("G2" 3)}
wvSetPosition -win $_nWave2 {("G2" 2)}
wvSetPosition -win $_nWave2 {("G2" 1)}
wvMoveSelected -win $_nWave2
wvSetPosition -win $_nWave2 {("G2" 1)}
wvSetPosition -win $_nWave2 {("G2" 2)}
wvSelectSignal -win $_nWave2 {( "G2" 3 )} 
wvSetPosition -win $_nWave2 {("G2" 3)}
wvSetPosition -win $_nWave2 {("G2" 2)}
wvSetPosition -win $_nWave2 {("G2" 1)}
wvSetPosition -win $_nWave2 {("G2" 0)}
wvSetPosition -win $_nWave2 {("G1" 19)}
wvMoveSelected -win $_nWave2
wvSetPosition -win $_nWave2 {("G1" 19)}
wvSetPosition -win $_nWave2 {("G1" 20)}
wvSelectSignal -win $_nWave2 {( "G2" 5 )} 
wvSelectSignal -win $_nWave2 {( "G2" 6 )} 
wvScrollUp -win $_nWave2 1
wvScrollUp -win $_nWave2 1
wvScrollUp -win $_nWave2 1
wvScrollUp -win $_nWave2 1
wvScrollUp -win $_nWave2 1
wvScrollUp -win $_nWave2 1
wvScrollUp -win $_nWave2 1
wvScrollUp -win $_nWave2 1
wvScrollUp -win $_nWave2 1
wvScrollUp -win $_nWave2 1
wvScrollUp -win $_nWave2 1
wvScrollDown -win $_nWave2 0
wvScrollDown -win $_nWave2 0
wvScrollDown -win $_nWave2 0
wvSelectSignal -win $_nWave2 {( "G1" 4 )} 
wvSelectSignal -win $_nWave2 {( "G1" 5 )} 
wvSelectSignal -win $_nWave2 {( "G1" 1 )} 
wvSelectSignal -win $_nWave2 {( "G1" 7 )} 
wvSelectSignal -win $_nWave2 {( "G1" 8 )} 
wvZoom -win $_nWave2 473.362241 963.825802
wvSetCursor -win $_nWave2 605.018685 -snap {("G1" 5)}
wvSetCursor -win $_nWave2 625.806544 -snap {("G1" 7)}
wvSelectSignal -win $_nWave2 {( "G2" 4 )} 
wvSetCursor -win $_nWave2 665.866482 -snap {("G2" 4)}
wvSetCursor -win $_nWave2 624.723843 -snap {("G1" 7)}
wvSelectSignal -win $_nWave2 {( "G1" 7 )} 
wvSelectSignal -win $_nWave2 {( "G2" 4 )} 
wvSelectSignal -win $_nWave2 {( "G1" 2 )} 
wvSaveSignal -win $_nWave2 \
           "/data2/open-riscv/acemicro/acemicro_m1/m1-v0/signal.rc"
verdiDockWidgetSetCurTab -dock widgetDock_MTB_SOURCE_TAB_1
srcHBSelect "tb_top.rvtop.veer.dec" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcSetScope -win $_nTrace1 "tb_top.rvtop.veer.dec.decode" -delim "."
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "dec_i0_decode_d" -line 158 -pos 1 -win $_nTrace1
srcAction -pos 157 5 7 -win $_nTrace1 -name "dec_i0_decode_d" -ctrlKey off
srcSetOptions -win $_nTrace1 -annotate on
schSetOptions -win $_nSchema1 -annotate on
srcDeselectAll -win $_nTrace1
srcSelect -signal "dec_i0_decode_d" -line 1399 -pos 1 -win $_nTrace1
srcSetOptions -win $_nTrace1 -annotate off
schSetOptions -win $_nSchema1 -annotate off
srcSetOptions -win $_nTrace1 -annotate on
schSetOptions -win $_nSchema1 -annotate on
verdiDockWidgetSetCurTab -dock windowDock_nWave_2
wvSetCursor -win $_nWave2 615.845695 -snap {("G1" 8)}
wvSetCursor -win $_nWave2 614.979534 -snap {("G1" 5)}
verdiDockWidgetSetCurTab -dock widgetDock_MTB_SOURCE_TAB_1
srcDeselectAll -win $_nTrace1
srcSelect -signal "i1_block_d" -line 1406 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "i1_block_d" -line 1406 -pos 1 -win $_nTrace1
srcAction -pos 1405 20 2 -win $_nTrace1 -name "i1_block_d" -ctrlKey off
verdiDockWidgetSetCurTab -dock windowDock_nWave_2
wvSetCursor -win $_nWave2 625.156924 -snap {("G1" 7)}
wvSetCursor -win $_nWave2 665.216862 -snap {("G1" 6)}
wvSetCursor -win $_nWave2 654.822932 -snap {("G1" 1)}
wvSetCursor -win $_nWave2 624.723843 -snap {("G1" 7)}
verdiDockWidgetSetCurTab -dock widgetDock_MTB_SOURCE_TAB_1
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "i0_block_d" -line 1399 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "i0_block_d" -line 1399 -pos 1 -win $_nTrace1
srcAction -pos 1398 12 7 -win $_nTrace1 -name "i0_block_d" -ctrlKey off
srcDeselectAll -win $_nTrace1
srcSelect -signal "i1_mul_block_d" -line 1358 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "i1_mul_block_d" -line 1358 -pos 1 -win $_nTrace1
srcAction -pos 1357 1 6 -win $_nTrace1 -name "i1_mul_block_d" -ctrlKey off
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
verdiDockWidgetSetCurTab -dock windowDock_nWave_2
verdiDockWidgetSetCurTab -dock widgetDock_MTB_SOURCE_TAB_1
verdiDockWidgetSetCurTab -dock windowDock_nWave_2
verdiDockWidgetSetCurTab -dock widgetDock_MTB_SOURCE_TAB_1
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "i0_block_d" -line 1399 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "i0_block_d" -line 1399 -pos 1 -win $_nTrace1
srcAction -pos 1398 12 7 -win $_nTrace1 -name "i0_block_d" -ctrlKey off
srcDeselectAll -win $_nTrace1
srcSelect -signal "i0_mul_block_d" -line 1337 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "i0_mul_block_d" -line 1337 -pos 1 -win $_nTrace1
srcAction -pos 1336 1 9 -win $_nTrace1 -name "i0_mul_block_d" -ctrlKey off
verdiDockWidgetSetCurTab -dock windowDock_nWave_2
wvSetCursor -win $_nWave2 635.117773 -snap {("G2" 0)}
wvSetCursor -win $_nWave2 624.723843 -snap {("G1" 7)}
wvSetCursor -win $_nWave2 634.901233 -snap {("G2" 1)}
verdiDockWidgetSetCurTab -dock widgetDock_MTB_SOURCE_TAB_1
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
verdiDockWidgetSetCurTab -dock windowDock_nWave_2
wvSetCursor -win $_nWave2 644.862082 -snap {("G2" 1)}
wvSetCursor -win $_nWave2 656.988334 -snap {("G2" 1)}
verdiDockWidgetSetCurTab -dock widgetDock_MTB_SOURCE_TAB_1
srcDeselectAll -win $_nTrace1
srcSelect -signal "presync_stall" -line 1333 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "presync_stall" -line 1333 -pos 1 -win $_nTrace1
srcAction -pos 1332 1 8 -win $_nTrace1 -name "presync_stall" -ctrlKey off
srcDeselectAll -win $_nTrace1
srcSelect -signal "prior_inflight_eff" -line 1321 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "prior_inflight_eff" -line 1321 -pos 1 -win $_nTrace1
srcAction -pos 1320 12 8 -win $_nTrace1 -name "prior_inflight_eff" -ctrlKey off
srcDeselectAll -win $_nTrace1
srcSelect -signal "prior_inflight_e1e3" -line 1323 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "prior_inflight_e1e3" -line 1323 -pos 1 -win $_nTrace1
srcAction -pos 1322 13 14 -win $_nTrace1 -name "prior_inflight_e1e3" -ctrlKey off
srcDeselectAll -win $_nTrace1
srcSelect -signal "e3d.i0valid" -line 1438 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "e3d.i0valid" -line 1438 -pos 1 -win $_nTrace1
srcAction -pos 1437 1 7 -win $_nTrace1 -name "e3d.i0valid" -ctrlKey off
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode.e3ff.genblock.dff.dffs" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "e3d.i0valid" -line 1438 -pos 1 -win $_nTrace1
srcAction -pos 1437 1 6 -win $_nTrace1 -name "e3d.i0valid" -ctrlKey off
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode.e3ff.genblock.dff.dffs" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -win $_nTrace1 -range {1438 1438 2 2 1 4}
srcDeselectAll -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSearchString "e3d" -win $_nTrace1 -prev -case
srcSelect -win $_nTrace1 -range {1371 1371 2 2 1 4}
srcSearchString "e3d" -win $_nTrace1 -prev -case
srcSelect -win $_nTrace1 -range {796 796 18 18 1 4}
srcSearchString "e3d" -win $_nTrace1 -prev -case
srcSelect -win $_nTrace1 -range {796 796 14 14 1 4}
srcSearchString "e3d" -win $_nTrace1 -prev -case
srcSelect -win $_nTrace1 -range {796 796 9 9 1 4}
srcSearchString "e3d" -win $_nTrace1 -prev -case
srcSelect -win $_nTrace1 -range {581 581 10 10 1 4}
srcSearchString "e3d" -win $_nTrace1 -prev -case
srcSelect -win $_nTrace1 -range {580 580 13 14 1 1}
srcSearchString "e3d" -win $_nTrace1 -prev -case
srcSelect -win $_nTrace1 -range {2267 2267 27 27 1 4}
nsMsgSwitchTab -tab general
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcDeselectAll -win $_nTrace1
srcSelect -signal "e3d.i0rs1bype3\[3\]" -line 1685 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "e3d.i0rs1bype3\[3\]" -line 1685 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "e3d.i0rs1bype3\[3\]" -line 1685 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "e3d.i0rs1bype3\[3:0\]" -line 1667 -pos 1 -win $_nTrace1
srcSelect -win $_nTrace1 -range {1667 1667 9 9 2 4} -backward
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcSearchString "e3d" -win $_nTrace1 -next -case
srcDeselectAll -win $_nTrace1
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "prior_inflight_e1e3" -line 1323 -pos 1 -win $_nTrace1
srcAction -pos 1322 13 13 -win $_nTrace1 -name "prior_inflight_e1e3" -ctrlKey off
srcDeselectAll -win $_nTrace1
srcSelect -signal "e3d.i0valid" -line 1438 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "e3d.i0valid" -line 1438 -pos 1 -win $_nTrace1
srcAction -pos 1437 1 8 -win $_nTrace1 -name "e3d.i0valid" -ctrlKey off
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode.e3ff.genblock.dff.dffs" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "i0_block_d" -line 1399 -pos 1 -win $_nTrace1
srcAction -pos 1398 12 5 -win $_nTrace1 -name "i0_block_d" -ctrlKey off
srcDeselectAll -win $_nTrace1
srcSelect -signal "presync_stall" -line 1333 -pos 1 -win $_nTrace1
srcAddSelectedToWave -clipboard -win $_nTrace1
wvDrop -win $_nWave2
verdiDockWidgetSetCurTab -dock windowDock_nWave_2
wvSetCursor -win $_nWave2 623.857683 -snap {("G1" 7)}
verdiDockWidgetSetCurTab -dock widgetDock_MTB_SOURCE_TAB_1
srcDeselectAll -win $_nTrace1
srcSelect -signal "presync_stall" -line 1333 -pos 1 -win $_nTrace1
srcAction -pos 1332 1 10 -win $_nTrace1 -name "presync_stall" -ctrlKey off
srcDeselectAll -win $_nTrace1
srcSelect -signal "i0_presync" -line 1321 -pos 1 -win $_nTrace1
srcAction -pos 1320 8 7 -win $_nTrace1 -name "i0_presync" -ctrlKey off
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "prior_inflight_eff" -line 1321 -pos 1 -win $_nTrace1
srcAction -pos 1320 12 5 -win $_nTrace1 -name "prior_inflight_eff" -ctrlKey off
srcDeselectAll -win $_nTrace1
verdiDockWidgetSetCurTab -dock windowDock_nWave_2
verdiDockWidgetSetCurTab -dock widgetDock_MTB_SOURCE_TAB_1
srcDeselectAll -win $_nTrace1
srcSelect -signal "i0_presync" -line 1321 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "i0_presync" -line 1321 -pos 1 -win $_nTrace1
srcAction -pos 1320 8 6 -win $_nTrace1 -name "i0_presync" -ctrlKey off
srcDeselectAll -win $_nTrace1
srcSelect -signal "i0_dp.presync" -line 1297 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "i0_dp.presync" -line 1297 -pos 1 -win $_nTrace1
srcAction -pos 1296 7 7 -win $_nTrace1 -name "i0_dp.presync" -ctrlKey off
srcDeselectAll -win $_nTrace1
srcSelect -signal "i0_dp_raw" -line 667 -pos 1 -win $_nTrace1
srcAction -pos 666 5 5 -win $_nTrace1 -name "i0_dp_raw" -ctrlKey off
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode.i0_dec" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
verdiDockWidgetSetCurTab -dock windowDock_nWave_2
verdiDockWidgetSetCurTab -dock widgetDock_MTB_SOURCE_TAB_1
srcDeselectAll -win $_nTrace1
srcSelect -signal "presync_stall" -line 1333 -pos 1 -win $_nTrace1
verdiDockWidgetSetCurTab -dock windowDock_nWave_2
wvSelectSignal -win $_nWave2 {( "G1" 10 )} 
wvSetCursor -win $_nWave2 623.857683 -snap {("G1" 21)}
wvSetCursor -win $_nWave2 655.256012 -snap {("G1" 21)}
verdiDockWidgetSetCurTab -dock widgetDock_MTB_SOURCE_TAB_1
srcDeselectAll -win $_nTrace1
srcSelect -signal "prior_inflight_e1e3" -line 1323 -pos 1 -win $_nTrace1
srcAction -pos 1322 13 7 -win $_nTrace1 -name "prior_inflight_e1e3" -ctrlKey off
srcDeselectAll -win $_nTrace1
srcSelect -signal "e3d.i0valid" -line 1438 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -win $_nTrace1 -range {1438 1438 2 2 1 4}
srcDeselectAll -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "e3d.i0valid" -line 1438 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "e3d.i0valid" -line 1438 -pos 1 -win $_nTrace1
srcAction -pos 1437 1 1 -win $_nTrace1 -name "e3d.i0valid" -ctrlKey off
srcDeselectAll -win $_nTrace1
srcSelect -signal "WIDTH" -win $_nTrace1
srcAction -pos 37 5 7 -win $_nTrace1 -name "din\[WIDTH-1:0\]" -ctrlKey off
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode.e3ff.genblock.dff.dffs" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode.e3ff.genblock.dff.dffs" -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "din\[WIDTH-1:0\]" -line 38 -pos 1 -win $_nTrace1
srcAction -pos 37 5 1 -win $_nTrace1 -name "din\[WIDTH-1:0\]" -ctrlKey off
srcDeselectAll -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "din\[WIDTH-1:0\]" -line 54 -pos 1 -win $_nTrace1
srcAction -pos 53 20 2 -win $_nTrace1 -name "din\[WIDTH-1:0\]" -ctrlKey off
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode.e3ff.genblock.dff" -win $_nTrace1
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode.e3ff.genblock.dff" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode.e3ff.genblock.dff.dffs" -win $_nTrace1
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode.e3ff.genblock.dff.dffs" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "e3d.i0valid" -line 1438 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "e3d.i0valid" -line 1438 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "e3d.i0valid" -line 1438 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -win $_nTrace1 -range {1438 1438 2 2 1 4}
srcShowDefine -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "e3d.i0valid" -line 1438 -pos 1 -win $_nTrace1
verdiDockWidgetSetCurTab -dock windowDock_nWave_2
wvSelectSignal -win $_nWave2 {( "G2" 3 )} 
wvSelectSignal -win $_nWave2 {( "G2" 10 )} 
wvSetCursor -win $_nWave2 664.567241 -snap {("G1" 5)}
wvSetCursor -win $_nWave2 623.641142 -snap {("G1" 7)}
wvSelectSignal -win $_nWave2 {( "G1" 13 )} 
wvSelectSignal -win $_nWave2 {( "G1" 8 )} 
verdiDockWidgetSetCurTab -dock widgetDock_MTB_SOURCE_TAB_1
srcSearchString "i1_pc_d" -win $_nTrace1 -next -case
verdiDockWidgetSetCurTab -dock windowDock_nWave_2
verdiDockWidgetSetCurTab -dock widgetDock_MTB_SOURCE_TAB_1
srcSearchString "*i1_pc_d" -win $_nTrace1 -next -case
srcSearchString "*i1_pc_d" -win $_nTrace1 -prev -case
srcSearchString "*i1_pc_d" -win $_nTrace1 -prev -case
srcSearchString "*i1_pc_d" -win $_nTrace1 -next -case
srcSearchString "*i1_pc_d" -win $_nTrace1 -next -case
srcHBSelect "tb_top.rvtop.veer.dec" -win $_nTrace1
srcSearchString "*i1_pc_d" -win $_nTrace1 -prev -case
srcSearchString "*i1_pc_d" -win $_nTrace1 -prev -case
srcSearchString "*i1_pc_d" -win $_nTrace1 -prev -case
srcSearchString "*i1_pc_d" -win $_nTrace1 -next -case
srcSearchString "*i1_pc_d" -win $_nTrace1 -next -case
srcSearchString "*i1_pc_d" -win $_nTrace1 -next -case
srcSearchString "*i1_pc_d" -win $_nTrace1 -next -case
srcSearchString "*i1_pc_d" -win $_nTrace1 -next -case
srcHBSelect "tb_top.rvtop.veer.dec" -win $_nTrace1
srcSetScope -win $_nTrace1 "tb_top.rvtop.veer.dec" -delim "."
srcHBSelect "tb_top.rvtop.veer.dec" -win $_nTrace1
srcSearchString "*i1_pc_d" -win $_nTrace1 -prev -case
srcSelect -win $_nTrace1 -range {278 278 15 16 5 1}
nsMsgSwitchTab -tab general
srcDeselectAll -win $_nTrace1
srcSelect -signal "dec_i1_pc_d" -line 278 -pos 1 -win $_nTrace1
srcAction -pos 277 14 5 -win $_nTrace1 -name "dec_i1_pc_d" -ctrlKey off
srcDeselectAll -win $_nTrace1
srcSelect -signal "pc1\[31:1\]" -line 292 -pos 1 -win $_nTrace1
srcAction -pos 291 7 1 -win $_nTrace1 -name "pc1\[31:1\]" -ctrlKey off
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff.pc1ff.genblock.dff.dffs" -win \
           $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -win $_nTrace1 -range {295 295 8 8 1 4}
srcDeselectAll -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "pc1\[0\]" -line 295 -pos 1 -win $_nTrace1
srcAction -pos 294 7 1 -win $_nTrace1 -name "pc1\[0\]" -ctrlKey off
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff.pc1ff.genblock.dff.dffs" -win \
           $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -win $_nTrace1 -range {292 292 8 8 1 4}
srcSearchString "pc1" -win $_nTrace1 -next -case
srcSearchString "pc1" -win $_nTrace1 -prev -case
srcSelect -win $_nTrace1 -range {292 292 8 8 1 4}
srcSearchString "pc1" -win $_nTrace1 -prev -case
srcSelect -win $_nTrace1 -range {289 289 8 8 1 4}
srcSearchString "pc1" -win $_nTrace1 -prev -case
srcSelect -win $_nTrace1 -range {286 286 8 8 1 4}
srcSearchString "pc1" -win $_nTrace1 -prev -case
srcSelect -win $_nTrace1 -range {283 283 8 8 1 4}
srcSearchString "pc1" -win $_nTrace1 -prev -case
srcSelect -win $_nTrace1 -range {280 280 8 8 1 4}
srcSearchString "pc1" -win $_nTrace1 -prev -case
srcSelect -win $_nTrace1 -range {273 273 12 12 1 4}
srcSearchString "pc1" -win $_nTrace1 -prev -case
srcSelect -win $_nTrace1 -range {269 269 32 32 1 4}
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec" -win $_nTrace1
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcForwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec" -win $_nTrace1
srcForwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
srcForwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff.pc1ff.genblock.dff.dffs" -win \
           $_nTrace1
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff.pc1ff.genblock.dff.dffs" -win \
           $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec" -win $_nTrace1
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcForwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec" -win $_nTrace1
srcForwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
srcForwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff.pc1ff.genblock.dff.dffs" -win \
           $_nTrace1
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff.pc1ff.genblock.dff.dffs" -win \
           $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
srcSearchString "pc1" -win $_nTrace1 -next -case
srcSearchString "pc1" -win $_nTrace1 -next -case
srcSearchString "pc1" -win $_nTrace1 -next -case
verdiDockWidgetSetCurTab -dock windowDock_nWave_2
verdiDockWidgetSetCurTab -dock widgetDock_MTB_SOURCE_TAB_1
verdiDockWidgetSetCurTab -dock windowDock_nWave_2
wvSelectSignal -win $_nWave2 {( "G1" 8 )} 
wvSelectSignal -win $_nWave2 {( "G1" 13 )} 
wvSelectSignal -win $_nWave2 {( "G1" 15 )} 
wvSelectSignal -win $_nWave2 {( "G1" 14 )} 
wvSetCursor -win $_nWave2 664.350701 -snap {("G1" 7)}
wvSetCursor -win $_nWave2 624.290763 -snap {("G1" 7)}
verdiDockWidgetSetCurTab -dock widgetDock_MTB_SOURCE_TAB_1
verdiDockWidgetSetCurTab -dock windowDock_nWave_2
verdiDockWidgetSetCurTab -dock widgetDock_MTB_SOURCE_TAB_1
srcDeselectAll -win $_nTrace1
srcSelect -signal "pc1\[31:1\]" -line 292 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "dec_i1_pc_d\[31:1\]" -line 292 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
verdiDockWidgetUndock -dock widgetDock_MTB_SOURCE_TAB_1
verdiDockWidgetHide -dock widgetDock_<Watch>
srcTBSetHiddenView -view WatchView
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
srcSetScope -win $_nTrace1 "tb_top.rvtop.veer.dec.instbuff" -delim "."
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
srcSetScope -win $_nTrace1 "tb_top.rvtop.veer.dec.instbuff" -delim "."
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
verdiDockWidgetMaximize -dock windowDock_nWave_2
verdiDockWidgetRestore -dock windowDock_nWave_2
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
srcCreateSourceTab -win $_nTrace1 -scope "tb_top.rvtop.veer.dec.instbuff"
srcSetActiveSourceTab -win $_nTrace1 -tab 1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
verdiDockWidgetSetCurTab -dock widgetDock_MTB_SOURCE_TAB_1
verdiDockWidgetHide -dock windowDock_nWave_2
srcSetActiveSourceTab -win $_nTrace1 -tab 2
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
verdiDockWidgetSetCurTab -dock widgetDock_MTB_SOURCE_TAB_2
srcSetActiveSourceTab -win $_nTrace1 -tab 1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
verdiDockWidgetSetCurTab -dock widgetDock_MTB_SOURCE_TAB_1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
srcCloseSourceTab -win $_nTrace1 -tab 1
srcDeselectAll -win $_nTrace1
verdiDockWidgetUndock -dock widgetDock_MTB_SOURCE_TAB_2
verdiDockWidgetDock -dock widgetDock_MTB_SOURCE_TAB_2
verdiDockWidgetHide -dock widgetDock_MTB_SOURCE_TAB_2
verdiDockWidgetHide -dock widgetDock_<Inst._Tree>
verdiDockWidgetHide -dock widgetDock_<Decl._Tree>
verdiDockWidgetHide -dock widgetDock_<Stack>
srcTBSetHiddenView -view StackView
verdiWindowPreviousLayout -win $_Verdi_1
verdiDockWidgetHide -dock widgetDock_<Stack>
srcTBSetHiddenView -view StackView
verdiDockWidgetHide -dock widgetDock_<Class._Tree>
srcTBSetHiddenView -view ClassView
verdiDockWidgetHide -dock widgetDock_<Object._Tree>
srcTBSetHiddenView -view ObjectView
verdiDockWidgetDisplay -dock windowDock_nWave_2
verdiDockWidgetDisplay -dock widgetDock_MTB_SOURCE_TAB_2
verdiDockWidgetDisplay -dock widgetDock_<Inst._Tree>
verdiDockWidgetSetCurTab -dock widgetDock_MTB_SOURCE_TAB_2
srcDeselectAll -win $_nTrace1
srcSelect -signal "dec_i1_pc_d" -line 78 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "dec_i1_pc_d" -line 78 -pos 1 -win $_nTrace1
srcAction -pos 77 11 8 -win $_nTrace1 -name "dec_i1_pc_d" -ctrlKey off
srcDeselectAll -win $_nTrace1
srcSelect -signal "pc1\[31:1\]" -line 292 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "pc1\[31:1\]" -line 292 -pos 1 -win $_nTrace1
srcAction -pos 291 7 2 -win $_nTrace1 -name "pc1\[31:1\]" -ctrlKey off
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff.pc1ff.genblock.dff.dffs" -win \
           $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
srcForwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
verdiDockWidgetSetCurTab -dock windowDock_nWave_2
verdiDockWidgetSetCurTab -dock widgetDock_MTB_SOURCE_TAB_2
srcDeselectAll -win $_nTrace1
srcSelect -signal "ibwrite\[1\]" -line 269 -pos 1 -win $_nTrace1
srcAddSelectedToWave -clipboard -win $_nTrace1
wvDrop -win $_nWave2
verdiDockWidgetSetCurTab -dock windowDock_nWave_2
verdiDockWidgetSetCurTab -dock widgetDock_MTB_SOURCE_TAB_2
srcDeselectAll -win $_nTrace1
srcSelect -signal "ibwrite\[1\]" -line 269 -pos 1 -win $_nTrace1
srcAction -pos 268 17 4 -win $_nTrace1 -name "ibwrite\[1\]" -ctrlKey off
srcDeselectAll -win $_nTrace1
srcSelect -signal "shift_ib1_ib0" -line 237 -pos 1 -win $_nTrace1
srcAction -pos 236 5 7 -win $_nTrace1 -name "shift_ib1_ib0" -ctrlKey off
srcDeselectAll -win $_nTrace1
srcSelect -signal "shift1" -line 454 -pos 1 -win $_nTrace1
srcAction -pos 453 7 3 -win $_nTrace1 -name "shift1" -ctrlKey off
srcDeselectAll -win $_nTrace1
srcSelect -signal "dec_i1_decode_d" -line 432 -pos 1 -win $_nTrace1
srcAction -pos 431 12 8 -win $_nTrace1 -name "dec_i1_decode_d" -ctrlKey off
srcDeselectAll -win $_nTrace1
srcSelect -signal "i1_block_d" -line 1406 -pos 1 -win $_nTrace1
srcAction -pos 1405 20 6 -win $_nTrace1 -name "i1_block_d" -ctrlKey off
srcDeselectAll -win $_nTrace1
srcSelect -signal "i0_postsync" -line 1346 -pos 1 -win $_nTrace1
srcAction -pos 1345 5 3 -win $_nTrace1 -name "i0_postsync" -ctrlKey off
srcDeselectAll -win $_nTrace1
srcSelect -signal "i0_dp.postsync" -line 1299 -pos 1 -win $_nTrace1
srcAction -pos 1298 7 11 -win $_nTrace1 -name "i0_dp.postsync" -ctrlKey off
srcDeselectAll -win $_nTrace1
srcSelect -signal "i0_dp_raw" -line 667 -pos 1 -win $_nTrace1
srcAction -pos 666 5 8 -win $_nTrace1 -name "i0_dp_raw" -ctrlKey off
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode.i0_dec" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "dec_i0_decode_d" -line 432 -pos 1 -win $_nTrace1
srcAction -pos 431 7 8 -win $_nTrace1 -name "dec_i0_decode_d" -ctrlKey off
srcDeselectAll -win $_nTrace1
srcSelect -signal "i0_block_d" -line 1399 -pos 1 -win $_nTrace1
srcAction -pos 1398 12 5 -win $_nTrace1 -name "i0_block_d" -ctrlKey off
verdiDockWidgetSetCurTab -dock windowDock_nWave_2
wvSetCursor -win $_nWave2 654.998100 -snap {("G1" 1)}
wvSetCursor -win $_nWave2 665.402064 -snap {("G1" 6)}
wvSetCursor -win $_nWave2 626.820700 -snap {("G1" 7)}
wvSelectSignal -win $_nWave2 {( "G1" 13 )} 
wvSelectSignal -win $_nWave2 {( "G1" 8 )} 
verdiDockWidgetSetCurTab -dock widgetDock_MTB_SOURCE_TAB_2
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
verdiDockWidgetSetCurTab -dock windowDock_nWave_2
wvSetCursor -win $_nWave2 614.899492 -snap {("G1" 13)}
wvSetCursor -win $_nWave2 625.303455 -snap {("G1" 10)}
verdiDockWidgetSetCurTab -dock widgetDock_MTB_SOURCE_TAB_2
srcDeselectAll -win $_nTrace1
srcSelect -signal "write_i0_ib1" -line 264 -pos 1 -win $_nTrace1
srcAction -pos 263 11 8 -win $_nTrace1 -name "write_i0_ib1" -ctrlKey off
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -win $_nTrace1 -range {266 266 12 12 1 4}
srcSearchString "pc2" -win $_nTrace1 -next -case
srcSearchString "pc2" -win $_nTrace1 -prev -case
srcSelect -win $_nTrace1 -range {266 266 12 12 1 4}
srcSearchString "pc2" -win $_nTrace1 -prev -case
srcSelect -win $_nTrace1 -range {261 261 4 5 1 1}
srcSearchString "pc2" -win $_nTrace1 -prev -case
srcSelect -win $_nTrace1 -range {257 257 32 32 1 4}
srcDeselectAll -win $_nTrace1
srcSelect -signal "write_i0_ib1" -line 264 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "write_i0_ib1" -line 264 -pos 1 -win $_nTrace1
srcAction -pos 263 11 7 -win $_nTrace1 -name "write_i0_ib1" -ctrlKey off
srcDeselectAll -win $_nTrace1
srcSelect -signal "ifu_i0_val" -line 445 -pos 1 -win $_nTrace1
srcAction -pos 444 16 4 -win $_nTrace1 -name "ifu_i0_val" -ctrlKey off
srcDeselectAll -win $_nTrace1
srcSelect -signal "ifu_i0_valid" -line 172 -pos 1 -win $_nTrace1
srcAction -pos 171 7 7 -win $_nTrace1 -name "ifu_i0_valid" -ctrlKey off
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.ifu.aln" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff.genblk1" -win $_nTrace1
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff.genblk1" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.instbuff" -win $_nTrace1
debExit
