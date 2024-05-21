simSetSimulator "-vcssv" -exec "./simv" -args "+dumpon +vcs+lic+wait"
debImport "-dbdir" "./simv.daidir"
debLoadSimResult /data2/open-riscv/acemicro/acemicro_m1/m1-v0/simv.fsdb
wvCreateWindow
verdiSetFont -font "Bitstream Vera Sans" -size "26"
verdiSetFont -monoFont "Courier" -monoFontSize "24"
simSetInteractiveFsdbFile inter.fsdb
simSetSvtbMode off
srcSetPreference -filterPowerAwareInstruments off -profileTime off -iconSize \
           large
tbvSetPreference -dynamicDumpMDA 1 -dynamicDumpStruct 1 -dynamicDumpSystemCStruct \
           1 -dynamicDumpSystemCPlain 1 -dynamicDumpSystemCFIFO 1
wvGetSignalOpen -win $_nWave2
wvGetSignalSetScope -win $_nWave2 "/_vcs_unit__1703114041"
wvGetSignalSetScope -win $_nWave2 "/tb_top/rvtop/veer"
wvGetSignalSetScope -win $_nWave2 "/tb_top/rvtop/veer/dec/instbuff"
wvSetPosition -win $_nWave2 {("G1" 1)}
wvSetPosition -win $_nWave2 {("G1" 1)}
wvAddSignal -win $_nWave2 -clear
wvAddSignal -win $_nWave2 -group {"G1" \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_decode_d} -height 25 \
}
wvAddSignal -win $_nWave2 -group {"G2" \
}
wvSelectSignal -win $_nWave2 {( "G1" 1 )} 
wvSetPosition -win $_nWave2 {("G1" 1)}
wvSetPosition -win $_nWave2 {("G1" 3)}
wvSetPosition -win $_nWave2 {("G1" 3)}
wvAddSignal -win $_nWave2 -clear
wvAddSignal -win $_nWave2 -group {"G1" \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_instr_d\[31:0\]} -height 25 \
}
wvAddSignal -win $_nWave2 -group {"G2" \
}
wvSelectSignal -win $_nWave2 {( "G1" 2 3 )} 
wvSetPosition -win $_nWave2 {("G1" 3)}
wvSetPosition -win $_nWave2 {("G1" 4)}
wvSetPosition -win $_nWave2 {("G1" 4)}
wvAddSignal -win $_nWave2 -clear
wvAddSignal -win $_nWave2 -group {"G1" \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
}
wvAddSignal -win $_nWave2 -group {"G2" \
}
wvSelectSignal -win $_nWave2 {( "G1" 4 )} 
wvSetPosition -win $_nWave2 {("G1" 4)}
wvSetPosition -win $_nWave2 {("G1" 7)}
wvSetPosition -win $_nWave2 {("G1" 7)}
wvAddSignal -win $_nWave2 -clear
wvAddSignal -win $_nWave2 -group {"G1" \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift2} -height 25 \
}
wvAddSignal -win $_nWave2 -group {"G2" \
}
wvSelectSignal -win $_nWave2 {( "G1" 5 6 7 )} 
wvSetPosition -win $_nWave2 {("G1" 7)}
wvSetPosition -win $_nWave2 {("G1" 12)}
wvSetPosition -win $_nWave2 {("G1" 12)}
wvAddSignal -win $_nWave2 -clear
wvAddSignal -win $_nWave2 -group {"G1" \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
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
}
wvSelectSignal -win $_nWave2 {( "G1" 8 9 10 11 12 )} 
wvSetPosition -win $_nWave2 {("G1" 12)}
wvSetPosition -win $_nWave2 {("G1" 13)}
wvSetPosition -win $_nWave2 {("G1" 13)}
wvAddSignal -win $_nWave2 -clear
wvAddSignal -win $_nWave2 -group {"G1" \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift2} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib1_ib0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib2_ib0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib2_ib1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib3_ib1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib3_ib2} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_instr_d\[31:0\]} -height 25 \
}
wvAddSignal -win $_nWave2 -group {"G2" \
}
wvSelectSignal -win $_nWave2 {( "G1" 13 )} 
wvSetPosition -win $_nWave2 {("G1" 13)}
wvSetPosition -win $_nWave2 {("G1" 12)}
wvSetPosition -win $_nWave2 {("G1" 11)}
wvSetPosition -win $_nWave2 {("G1" 10)}
wvSetPosition -win $_nWave2 {("G1" 9)}
wvSetPosition -win $_nWave2 {("G1" 8)}
wvSetPosition -win $_nWave2 {("G1" 7)}
wvSetPosition -win $_nWave2 {("G1" 6)}
wvSetPosition -win $_nWave2 {("G1" 5)}
wvSetPosition -win $_nWave2 {("G1" 4)}
wvSetPosition -win $_nWave2 {("G1" 3)}
wvSetPosition -win $_nWave2 {("G1" 2)}
wvMoveSelected -win $_nWave2
wvSetPosition -win $_nWave2 {("G1" 2)}
wvSetPosition -win $_nWave2 {("G1" 3)}
wvSelectSignal -win $_nWave2 {( "G1" 2 )} 
wvSelectSignal -win $_nWave2 {( "G1" 2 )} 
wvGetSignalClose -win $_nWave2
wvSelectSignal -win $_nWave2 {( "G1" 2 )} 
wvCut -win $_nWave2
wvSetPosition -win $_nWave2 {("G1" 3)}
wvSetPosition -win $_nWave2 {("G1" 2)}
wvSelectSignal -win $_nWave2 {( "G1" 1 )} 
wvGetSignalOpen -win $_nWave2
wvGetSignalSetScope -win $_nWave2 "/_vcs_unit__1703114041"
wvGetSignalSetScope -win $_nWave2 "/tb_top"
wvGetSignalSetScope -win $_nWave2 "/tb_top/rvtop"
wvGetSignalSetScope -win $_nWave2 "/tb_top/rvtop/veer"
wvGetSignalSetScope -win $_nWave2 "/tb_top/rvtop/veer/dec"
wvGetSignalSetScope -win $_nWave2 "/tb_top/rvtop/veer/dec/instbuff"
wvGetSignalSetScope -win $_nWave2 "/tb_top/rvtop/veer/dec/instbuff"
wvGetSignalSetSignalFilter -win $_nWave2 "dec_i1_decode*"
wvSetPosition -win $_nWave2 {("G1" 2)}
wvSetPosition -win $_nWave2 {("G1" 2)}
wvAddSignal -win $_nWave2 -clear
wvAddSignal -win $_nWave2 -group {"G1" \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
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
}
wvSetPosition -win $_nWave2 {("G1" 2)}
wvSetPosition -win $_nWave2 {("G1" 3)}
wvSetPosition -win $_nWave2 {("G1" 3)}
wvAddSignal -win $_nWave2 -clear
wvAddSignal -win $_nWave2 -group {"G1" \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
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
}
wvSelectSignal -win $_nWave2 {( "G1" 3 )} 
wvSetPosition -win $_nWave2 {("G1" 3)}
wvSetPosition -win $_nWave2 {("G1" 3)}
wvSetPosition -win $_nWave2 {("G1" 3)}
wvAddSignal -win $_nWave2 -clear
wvAddSignal -win $_nWave2 -group {"G1" \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
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
}
wvSelectSignal -win $_nWave2 {( "G1" 3 )} 
wvSetPosition -win $_nWave2 {("G1" 3)}
wvGetSignalClose -win $_nWave2
wvSetPosition -win $_nWave2 {("G1" 2)}
wvSetPosition -win $_nWave2 {("G1" 1)}
wvMoveSelected -win $_nWave2
wvSetPosition -win $_nWave2 {("G1" 1)}
wvSetPosition -win $_nWave2 {("G1" 2)}
wvGetSignalOpen -win $_nWave2
wvGetSignalSetScope -win $_nWave2 "/_vcs_unit__1703114041"
wvGetSignalSetScope -win $_nWave2 "/tb_top"
wvGetSignalSetScope -win $_nWave2 "/tb_top/rvtop"
wvGetSignalSetScope -win $_nWave2 "/tb_top/rvtop/veer"
wvGetSignalSetScope -win $_nWave2 "/tb_top/rvtop/veer/dec"
wvGetSignalSetScope -win $_nWave2 "/tb_top/rvtop/veer/dec/instbuff"
wvGetSignalSetScope -win $_nWave2 "/tb_top/rvtop/veer/dec/instbuff"
wvGetSignalSetScope -win $_nWave2 "/tb_top/rvtop/veer/dec"
wvGetSignalSetSignalFilter -win $_nWave2 "*"
wvSetPosition -win $_nWave2 {("G1" 2)}
wvSetPosition -win $_nWave2 {("G1" 2)}
wvAddSignal -win $_nWave2 -clear
wvAddSignal -win $_nWave2 -group {"G1" \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
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
}
wvSetPosition -win $_nWave2 {("G1" 2)}
wvSetPosition -win $_nWave2 {("G1" 4)}
wvSetPosition -win $_nWave2 {("G1" 4)}
wvAddSignal -win $_nWave2 -clear
wvAddSignal -win $_nWave2 -group {"G1" \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_inst_wb1\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
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
}
wvSelectSignal -win $_nWave2 {( "G1" 3 4 )} 
wvSetPosition -win $_nWave2 {("G1" 4)}
wvSetPosition -win $_nWave2 {("G1" 5)}
wvSetPosition -win $_nWave2 {("G1" 5)}
wvAddSignal -win $_nWave2 -clear
wvAddSignal -win $_nWave2 -group {"G1" \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_inst_wb1\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i1_cinst_d\[15:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
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
}
wvSelectSignal -win $_nWave2 {( "G1" 5 )} 
wvSetPosition -win $_nWave2 {("G1" 5)}
wvSetPosition -win $_nWave2 {("G1" 6)}
wvSetPosition -win $_nWave2 {("G1" 6)}
wvAddSignal -win $_nWave2 -clear
wvAddSignal -win $_nWave2 -group {"G1" \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_inst_wb1\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i1_cinst_d\[15:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
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
}
wvSelectSignal -win $_nWave2 {( "G1" 6 )} 
wvSetPosition -win $_nWave2 {("G1" 6)}
wvSetPosition -win $_nWave2 {("G1" 9)}
wvSetPosition -win $_nWave2 {("G1" 9)}
wvAddSignal -win $_nWave2 -clear
wvAddSignal -win $_nWave2 -group {"G1" \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_inst_wb1\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i1_cinst_d\[15:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_ib0_valid_d} -height 25 \
{/tb_top/rvtop/veer/dec/mul_p} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
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
}
wvSelectSignal -win $_nWave2 {( "G1" 7 8 9 )} 
wvSetPosition -win $_nWave2 {("G1" 9)}
wvSetPosition -win $_nWave2 {("G1" 10)}
wvSetPosition -win $_nWave2 {("G1" 10)}
wvAddSignal -win $_nWave2 -clear
wvAddSignal -win $_nWave2 -group {"G1" \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_inst_wb1\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i1_cinst_d\[15:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_ib0_valid_d} -height 25 \
{/tb_top/rvtop/veer/dec/mul_p} -height 25 \
{/tb_top/rvtop/veer/dec/dec_tlu_dual_issue_disable} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
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
}
wvSelectSignal -win $_nWave2 {( "G1" 10 )} 
wvSetPosition -win $_nWave2 {("G1" 10)}
wvSetPosition -win $_nWave2 {("G1" 12)}
wvSetPosition -win $_nWave2 {("G1" 12)}
wvAddSignal -win $_nWave2 -clear
wvAddSignal -win $_nWave2 -group {"G1" \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_inst_wb1\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i1_cinst_d\[15:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_ib0_valid_d} -height 25 \
{/tb_top/rvtop/veer/dec/mul_p} -height 25 \
{/tb_top/rvtop/veer/dec/dec_tlu_dual_issue_disable} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i1_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
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
}
wvSelectSignal -win $_nWave2 {( "G1" 11 12 )} 
wvSetPosition -win $_nWave2 {("G1" 12)}
wvSetPosition -win $_nWave2 {("G1" 13)}
wvSetPosition -win $_nWave2 {("G1" 13)}
wvAddSignal -win $_nWave2 -clear
wvAddSignal -win $_nWave2 -group {"G1" \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_inst_wb1\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i1_cinst_d\[15:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_ib0_valid_d} -height 25 \
{/tb_top/rvtop/veer/dec/mul_p} -height 25 \
{/tb_top/rvtop/veer/dec/dec_tlu_dual_issue_disable} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i1_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc4_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
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
}
wvSelectSignal -win $_nWave2 {( "G1" 13 )} 
wvSetPosition -win $_nWave2 {("G1" 13)}
wvGetSignalSetSignalFilter -win $_nWave2 "*dec_i1_pc_d"
wvSetPosition -win $_nWave2 {("G1" 13)}
wvSetPosition -win $_nWave2 {("G1" 13)}
wvAddSignal -win $_nWave2 -clear
wvAddSignal -win $_nWave2 -group {"G1" \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_inst_wb1\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i1_cinst_d\[15:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_ib0_valid_d} -height 25 \
{/tb_top/rvtop/veer/dec/mul_p} -height 25 \
{/tb_top/rvtop/veer/dec/dec_tlu_dual_issue_disable} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i1_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc4_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
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
}
wvSelectSignal -win $_nWave2 {( "G1" 13 )} 
wvSetPosition -win $_nWave2 {("G1" 13)}
wvSetPosition -win $_nWave2 {("G1" 14)}
wvSetPosition -win $_nWave2 {("G1" 14)}
wvAddSignal -win $_nWave2 -clear
wvAddSignal -win $_nWave2 -group {"G1" \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_inst_wb1\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i1_cinst_d\[15:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_ib0_valid_d} -height 25 \
{/tb_top/rvtop/veer/dec/mul_p} -height 25 \
{/tb_top/rvtop/veer/dec/dec_tlu_dual_issue_disable} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i1_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc4_d} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i1_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
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
}
wvSelectSignal -win $_nWave2 {( "G1" 14 )} 
wvSetPosition -win $_nWave2 {("G1" 14)}
wvSetPosition -win $_nWave2 {("G1" 14)}
wvSetPosition -win $_nWave2 {("G1" 14)}
wvAddSignal -win $_nWave2 -clear
wvAddSignal -win $_nWave2 -group {"G1" \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_inst_wb1\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i1_cinst_d\[15:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_ib0_valid_d} -height 25 \
{/tb_top/rvtop/veer/dec/mul_p} -height 25 \
{/tb_top/rvtop/veer/dec/dec_tlu_dual_issue_disable} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i1_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc4_d} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i1_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
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
}
wvSelectSignal -win $_nWave2 {( "G1" 14 )} 
wvSetPosition -win $_nWave2 {("G1" 14)}
wvGetSignalClose -win $_nWave2
wvSelectSignal -win $_nWave2 {( "G1" 13 )} 
wvSelectSignal -win $_nWave2 {( "G1" 14 )} 
wvSetPosition -win $_nWave2 {("G1" 13)}
wvSetPosition -win $_nWave2 {("G1" 12)}
wvSetPosition -win $_nWave2 {("G1" 11)}
wvMoveSelected -win $_nWave2
wvSetPosition -win $_nWave2 {("G1" 11)}
wvSetPosition -win $_nWave2 {("G1" 12)}
wvSelectSignal -win $_nWave2 {( "G1" 13 )} 
wvCut -win $_nWave2
wvSetPosition -win $_nWave2 {("G1" 12)}
wvSelectSignal -win $_nWave2 {( "G1" 9 )} 
wvSelectSignal -win $_nWave2 {( "G1" 7 )} 
wvSelectSignal -win $_nWave2 {( "G1" 12 )} 
wvSetPosition -win $_nWave2 {("G1" 11)}
wvSetPosition -win $_nWave2 {("G1" 10)}
wvSetPosition -win $_nWave2 {("G1" 9)}
wvSetPosition -win $_nWave2 {("G1" 8)}
wvSetPosition -win $_nWave2 {("G1" 7)}
wvSetPosition -win $_nWave2 {("G1" 6)}
wvMoveSelected -win $_nWave2
wvSetPosition -win $_nWave2 {("G1" 6)}
wvSetPosition -win $_nWave2 {("G1" 7)}
wvSelectSignal -win $_nWave2 {( "G1" 8 )} 
wvCut -win $_nWave2
wvSetPosition -win $_nWave2 {("G1" 7)}
wvSelectSignal -win $_nWave2 {( "G1" 6 )} 
wvSelectSignal -win $_nWave2 {( "G1" 7 )} 
wvSelectSignal -win $_nWave2 {( "G1" 6 )} 
wvZoomOut -win $_nWave2
wvZoomOut -win $_nWave2
wvZoomOut -win $_nWave2
wvZoomOut -win $_nWave2
wvZoomOut -win $_nWave2
wvZoomOut -win $_nWave2
wvZoomOut -win $_nWave2
wvZoomOut -win $_nWave2
wvZoom -win $_nWave2 337.858407 941.176991
wvZoom -win $_nWave2 465.996867 663.543660
wvSetCursor -win $_nWave2 484.717194 -snap {("G1" 9)}
wvZoomOut -win $_nWave2
wvZoomOut -win $_nWave2
wvZoomOut -win $_nWave2
wvSetCursor -win $_nWave2 1123.510964 -snap {("G1" 7)}
wvZoom -win $_nWave2 158.503622 543.107997
wvSetCursor -win $_nWave2 485.388978 -snap {("G1" 6)}
wvSelectSignal -win $_nWave2 {( "G1" 3 )} 
wvCut -win $_nWave2
wvSetPosition -win $_nWave2 {("G1" 7)}
wvSetPosition -win $_nWave2 {("G1" 6)}
wvSelectSignal -win $_nWave2 {( "G1" 12 )} 
wvSetPosition -win $_nWave2 {("G1" 12)}
wvSetPosition -win $_nWave2 {("G1" 11)}
wvSetPosition -win $_nWave2 {("G1" 10)}
wvSetPosition -win $_nWave2 {("G1" 9)}
wvSetPosition -win $_nWave2 {("G1" 8)}
wvSetPosition -win $_nWave2 {("G1" 7)}
wvSetPosition -win $_nWave2 {("G1" 6)}
wvSetPosition -win $_nWave2 {("G1" 5)}
wvSetPosition -win $_nWave2 {("G1" 4)}
wvSetPosition -win $_nWave2 {("G1" 3)}
wvSetPosition -win $_nWave2 {("G1" 2)}
wvSetPosition -win $_nWave2 {("G1" 3)}
wvMoveSelected -win $_nWave2
wvSetPosition -win $_nWave2 {("G1" 3)}
wvSetPosition -win $_nWave2 {("G1" 4)}
wvSelectSignal -win $_nWave2 {( "G1" 5 6 7 8 9 10 11 12 13 )} 
wvSelectSignal -win $_nWave2 {( "G1" 13 )} 
wvSelectSignal -win $_nWave2 {( "G1" 14 )} 
wvSelectSignal -win $_nWave2 {( "G1" 13 )} 
wvSetPosition -win $_nWave2 {("G1" 13)}
wvSetPosition -win $_nWave2 {("G1" 12)}
wvSetPosition -win $_nWave2 {("G1" 11)}
wvSetPosition -win $_nWave2 {("G1" 10)}
wvSetPosition -win $_nWave2 {("G1" 9)}
wvSetPosition -win $_nWave2 {("G1" 8)}
wvSetPosition -win $_nWave2 {("G1" 7)}
wvSetPosition -win $_nWave2 {("G1" 6)}
wvSetPosition -win $_nWave2 {("G1" 5)}
wvSetPosition -win $_nWave2 {("G1" 4)}
wvMoveSelected -win $_nWave2
wvSetPosition -win $_nWave2 {("G1" 4)}
wvSetPosition -win $_nWave2 {("G1" 5)}
wvSelectSignal -win $_nWave2 {( "G1" 3 )} 
wvZoom -win $_nWave2 372.361807 538.995340
wvSelectSignal -win $_nWave2 {( "G1" 4 )} 
wvSelectSignal -win $_nWave2 {( "G1" 2 )} 
wvSelectSignal -win $_nWave2 {( "G1" 2 )} 
wvSaveSignal -win $_nWave2 \
           "/data2/open-riscv/acemicro/acemicro_m1/m1-v0/signal.rc"
wvSelectSignal -win $_nWave2 {( "G1" 2 )} 
wvShowOneTraceSignals -win $_nWave2 -signal \
           "/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d" -driver
srcDeselectAll -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "dec_i1_decode_d" -line 1406 -pos 1 -win $_nTrace1
srcTraceValueChange "tb_top.rvtop.veer.dec.decode.dec_i1_decode_d" -win $_nTrace1
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "i0_legal_decode_d" -line 1406 -pos 1 -win $_nTrace1
srcAction -pos 1405 7 4 -win $_nTrace1 -name "i0_legal_decode_d" -ctrlKey off
srcDeselectAll -win $_nTrace1
srcSelect -signal "i0_legal_decode_d" -line 1406 -pos 1 -win $_nTrace1
srcSetOptions -win $_nTrace1 -annotate on
schSetOptions -win $_nSchema1 -annotate on
srcDeselectAll -win $_nTrace1
srcSelect -signal "i0_legal_decode_d" -line 1406 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "i1_block_d" -line 1406 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "i1_block_d" -line 1406 -pos 1 -win $_nTrace1
srcAction -pos 1405 20 3 -win $_nTrace1 -name "i1_block_d" -ctrlKey off
srcDeselectAll -win $_nTrace1
srcSelect -signal "i1_mul2_block_d" -line 1361 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "i1_mul2_block_d" -line 1361 -pos 1 -win $_nTrace1
srcAction -pos 1360 1 9 -win $_nTrace1 -name "i1_mul2_block_d" -ctrlKey off
srcDeselectAll -win $_nTrace1
srcSelect -signal "i1_dp.mul" -line 1302 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "i1_dp.mul" -line 1302 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "i1_dp.mul" -line 1302 -pos 1 -win $_nTrace1
srcAction -pos 1301 7 2 -win $_nTrace1 -name "i1_dp.mul" -ctrlKey off
srcDeselectAll -win $_nTrace1
srcSelect -signal "i1_dp_raw" -line 678 -pos 1 -win $_nTrace1
srcAction -pos 677 5 4 -win $_nTrace1 -name "i1_dp_raw" -ctrlKey off
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode.i1_dec" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcShowDefine -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "i1_dp_raw" -line 678 -pos 1 -win $_nTrace1
srcAction -pos 677 5 6 -win $_nTrace1 -name "i1_dp_raw" -ctrlKey off
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode.i1_dec" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcSearchString "i1_dp_raw" -win $_nTrace1 -next -case
srcSearchString "i1_dp_raw" -win $_nTrace1 -next -case
srcSearchString "i1_dp_raw" -win $_nTrace1 -next -case
srcSearchString "i1_dp_raw" -win $_nTrace1 -next -case
srcSearchString "i1_dp_raw" -win $_nTrace1 -next -case
srcSearchString "i1_dp_raw" -win $_nTrace1 -next -case
srcSearchString "i1_dp_raw" -win $_nTrace1 -next -case
srcSearchString "i1_dp_raw" -win $_nTrace1 -next -case
srcSearchString "i1_dp_raw" -win $_nTrace1 -next -case
srcSearchString "i1_dp_raw" -win $_nTrace1 -next -case
srcSearchString "i1_dp_raw" -win $_nTrace1 -next -case
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "i1_block_d" -line 1406 -pos 1 -win $_nTrace1
srcAction -pos 1405 20 6 -win $_nTrace1 -name "i1_block_d" -ctrlKey off
srcDeselectAll -win $_nTrace1
srcSelect -signal "i1_mul_block_d" -line 1358 -pos 1 -win $_nTrace1
srcAction -pos 1357 1 9 -win $_nTrace1 -name "i1_mul_block_d" -ctrlKey off
srcDeselectAll -win $_nTrace1
srcSelect -signal "i1_mul_block_d" -line 1358 -pos 1 -win $_nTrace1
srcAction -pos 1357 1 9 -win $_nTrace1 -name "i1_mul_block_d" -ctrlKey off
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "i1_mul2_block_d" -line 1361 -pos 1 -win $_nTrace1
srcAction -pos 1360 1 11 -win $_nTrace1 -name "i1_mul2_block_d" -ctrlKey off
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "i1_load_block_d" -line 1357 -pos 1 -win $_nTrace1
srcAction -pos 1356 1 9 -win $_nTrace1 -name "i1_load_block_d" -ctrlKey off
verdiDockWidgetSetCurTab -dock windowDock_nWave_2
wvSelectSignal -win $_nWave2 {( "G1" 21 )} 
wvSelectSignal -win $_nWave2 {( "G1" 20 )} 
wvSelectSignal -win $_nWave2 {( "G1" 21 )} 
wvCut -win $_nWave2
wvSetPosition -win $_nWave2 {("G1" 2)}
wvSelectSignal -win $_nWave2 {( "G1" 21 )} 
wvSelectSignal -win $_nWave2 {( "G1" 22 )} 
wvSelectSignal -win $_nWave2 {( "G1" 24 )} 
wvZoomOut -win $_nWave2
wvZoomOut -win $_nWave2
wvZoomOut -win $_nWave2
wvZoomOut -win $_nWave2
wvSelectSignal -win $_nWave2 \
           {( "G1//tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d@485(1s)#ActiveDriver" \
           1 )} 
wvZoom -win $_nWave2 1432.351388 2388.563990
wvZoomOut -win $_nWave2
wvZoomOut -win $_nWave2
wvZoomOut -win $_nWave2
wvSelectSignal -win $_nWave2 \
           {( "G1//tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d@485(1s)#ActiveDriver" \
           1 )} 
wvCut -win $_nWave2
wvSetPosition -win $_nWave2 {("G1" 2)}
wvZoom -win $_nWave2 371.466953 1312.726437
wvSelectSignal -win $_nWave2 \
           {( "G1//tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d@485(1s)#ActiveDriver" \
           2 )} 
wvCut -win $_nWave2
wvSetPosition -win $_nWave2 {("G1" 2)}
wvSelectSignal -win $_nWave2 \
           {( "G1//tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d@485(1s)#ActiveDriver" \
           2 )} 
wvSelectSignal -win $_nWave2 {( "G1" 11 )} 
wvCut -win $_nWave2
wvSetPosition -win $_nWave2 {("G1" 2)}
wvSelectSignal -win $_nWave2 {( "G1" 15 )} 
wvSetPosition -win $_nWave2 {("G1" 15)}
wvSetPosition -win $_nWave2 {("G1" 16)}
wvSetPosition -win $_nWave2 {("G1" 17)}
wvSetPosition -win $_nWave2 {("G1" 18)}
wvSetPosition -win $_nWave2 {("G1" 19)}
wvSetPosition -win $_nWave2 {("G1" 20)}
wvSetPosition -win $_nWave2 {("G1" 21)}
wvSetPosition -win $_nWave2 {("G1" 22)}
wvSetPosition -win $_nWave2 {("G1" 23)}
wvSetPosition -win $_nWave2 {("G1" 24)}
wvSetPosition -win $_nWave2 {("G1" 25)}
wvSetPosition -win $_nWave2 {("G2" 0)}
wvSetPosition -win $_nWave2 {("G1" 25)}
wvMoveSelected -win $_nWave2
wvSetPosition -win $_nWave2 {("G1" 25)}
wvSelectSignal -win $_nWave2 {( "G1" 17 )} 
wvZoom -win $_nWave2 438.478431 1074.506444
wvSelectSignal -win $_nWave2 {( "G1" 19 )} 
wvSelectSignal -win $_nWave2 {( "G1" 9 )} 
wvSetCursor -win $_nWave2 615.676359 -snap {("G1" 10)}
wvSelectSignal -win $_nWave2 {( "G1" 12 )} 
wvSelectSignal -win $_nWave2 {( "G1" 19 )} 
wvSetCursor -win $_nWave2 663.973048 -snap {("G1" 10)}
wvSetCursor -win $_nWave2 674.972785 -snap {("G1" 10)}
wvSetCursor -win $_nWave2 685.448725 -snap {("G1" 9)}
wvSelectSignal -win $_nWave2 {( "G1" 11 )} 
wvSetCursor -win $_nWave2 485.882061 -snap {("G1" 11)}
wvSetCursor -win $_nWave2 605.831579 -snap {("G1" 11)}
wvSetCursor -win $_nWave2 483.786873 -snap {("G1" 11)}
wvSetCursor -win $_nWave2 494.000915 -snap {("G1" 11)}
wvSelectSignal -win $_nWave2 {( "G1" 11 )} 
wvSelectSignal -win $_nWave2 {( "G1" 11 12 )} 
wvSetPosition -win $_nWave2 {("G1" 11)}
wvSetPosition -win $_nWave2 {("G1" 10)}
wvSetPosition -win $_nWave2 {("G1" 9)}
wvSetPosition -win $_nWave2 {("G1" 8)}
wvSetPosition -win $_nWave2 \
           {("G1//tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d@485(1s)#ActiveDriver" 4)}
wvSetPosition -win $_nWave2 \
           {("G1//tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d@485(1s)#ActiveDriver" 3)}
wvSetPosition -win $_nWave2 \
           {("G1//tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d@485(1s)#ActiveDriver" 2)}
wvSetPosition -win $_nWave2 \
           {("G1//tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d@485(1s)#ActiveDriver" 1)}
wvSetPosition -win $_nWave2 \
           {("G1//tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d@485(1s)#ActiveDriver" 0)}
wvSetPosition -win $_nWave2 {("G1" 2)}
wvSetPosition -win $_nWave2 {("G1" 1)}
wvSetPosition -win $_nWave2 {("G1" 0)}
wvMoveSelected -win $_nWave2
wvSetPosition -win $_nWave2 {("G1" 0)}
wvSetPosition -win $_nWave2 {("G1" 2)}
wvSetCursor -win $_nWave2 474.096628 -snap {("G1" 2)}
wvSetCursor -win $_nWave2 484.310670 -snap {("G1" 14)}
wvSelectSignal -win $_nWave2 {( "G1" 18 )} 
wvSetCursor -win $_nWave2 615.521823 -snap {("G1" 19)}
wvSetCursor -win $_nWave2 484.834467 -snap {("G1" 1)}
wvSelectSignal -win $_nWave2 {( "G1" 19 )} 
wvSetCursor -win $_nWave2 614.736128 -snap {("G1" 19)}
wvSelectSignal -win $_nWave2 {( "G1" 17 )} 
wvSelectSignal -win $_nWave2 {( "G1" 17 18 )} 
wvSelectSignal -win $_nWave2 {( "G1" 17 18 19 )} 
wvSetPosition -win $_nWave2 {("G1" 17)}
wvSetPosition -win $_nWave2 {("G1" 16)}
wvSetPosition -win $_nWave2 {("G1" 15)}
wvSetPosition -win $_nWave2 {("G1" 14)}
wvSetPosition -win $_nWave2 {("G1" 13)}
wvSetPosition -win $_nWave2 {("G1" 12)}
wvSetPosition -win $_nWave2 {("G1" 11)}
wvSetPosition -win $_nWave2 {("G1" 10)}
wvSetPosition -win $_nWave2 \
           {("G1//tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d@485(1s)#ActiveDriver" 4)}
wvSetPosition -win $_nWave2 {("G1" 10)}
wvSetPosition -win $_nWave2 {("G1" 11)}
wvSetPosition -win $_nWave2 {("G1" 12)}
wvSetPosition -win $_nWave2 {("G1" 13)}
wvSetPosition -win $_nWave2 {("G1" 14)}
wvSetPosition -win $_nWave2 {("G1" 15)}
wvSetPosition -win $_nWave2 {("G1" 16)}
wvSetPosition -win $_nWave2 {("G1" 17)}
wvSetPosition -win $_nWave2 {("G1" 14)}
wvSetPosition -win $_nWave2 {("G1" 13)}
wvSetPosition -win $_nWave2 {("G1" 12)}
wvSetPosition -win $_nWave2 {("G1" 11)}
wvSetPosition -win $_nWave2 {("G1" 10)}
wvSetPosition -win $_nWave2 \
           {("G1//tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d@485(1s)#ActiveDriver" 4)}
wvSetPosition -win $_nWave2 {("G1" 10)}
wvSetPosition -win $_nWave2 {("G1" 11)}
wvSetPosition -win $_nWave2 {("G1" 12)}
wvSetPosition -win $_nWave2 {("G1" 15)}
wvSetPosition -win $_nWave2 {("G1" 16)}
wvSetPosition -win $_nWave2 {("G1" 15)}
wvSetPosition -win $_nWave2 {("G1" 14)}
wvSetPosition -win $_nWave2 {("G1" 13)}
wvSetPosition -win $_nWave2 \
           {("G1//tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d@485(1s)#ActiveDriver" 0)}
wvSetPosition -win $_nWave2 \
           {("G1//tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d@485(1s)#ActiveDriver" 1)}
wvSetPosition -win $_nWave2 \
           {("G1//tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d@485(1s)#ActiveDriver" 0)}
wvSetPosition -win $_nWave2 {("G1" 4)}
wvMoveSelected -win $_nWave2
wvSetPosition -win $_nWave2 {("G1" 4)}
wvSetPosition -win $_nWave2 {("G1" 7)}
wvGetSignalOpen -win $_nWave2
wvGetSignalSetScope -win $_nWave2 "/_vcs_unit__1703114041"
wvGetSignalSetScope -win $_nWave2 "/tb_top"
wvGetSignalSetScope -win $_nWave2 "/tb_top/rvtop"
wvGetSignalSetScope -win $_nWave2 "/tb_top/rvtop/veer"
wvGetSignalSetScope -win $_nWave2 "/tb_top/rvtop/veer/dec"
wvGetSignalSetScope -win $_nWave2 "/tb_top/rvtop/veer/dec/instbuff"
wvGetSignalSetScope -win $_nWave2 "/tb_top/rvtop/veer/dec"
wvGetSignalSetScope -win $_nWave2 "/tb_top"
wvGetSignalSetSignalFilter -win $_nWave2 "*"
wvSetPosition -win $_nWave2 {("G1" 7)}
wvSetPosition -win $_nWave2 {("G1" 7)}
wvAddSignal -win $_nWave2 -clear
wvAddSignal -win $_nWave2 -group {"G1" \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i1_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift2} -height 25 \
}
wvAddSignal -win $_nWave2 -group {"G1//tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d@485(1s)#ActiveDriver" \
{/tb_top/rvtop/veer/dec/decode/freeze} -height 25 \
{/tb_top/rvtop/veer/dec/decode/i1_block_d} -height 25 \
{/tb_top/rvtop/veer/dec/decode/i1_dp.legal} -height 25 \
{/tb_top/rvtop/veer/dec/decode/i1_valid_d} -height 25 \
}
wvAddSignal -win $_nWave2 -group {"G1" {/tb_top/rvtop/veer/dec/dec_i0_inst_wb1\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_ib0_valid_d} -height 25 \
{/tb_top/rvtop/veer/dec/mul_p} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc4_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib1_ib0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib2_ib0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib2_ib1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib3_ib1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib3_ib2} -height 25 \
{/tb_top/rvtop/veer/dec/dec_tlu_dual_issue_disable} -height 25 \
}
wvAddSignal -win $_nWave2 -group {"G2" \
}
wvSetPosition -win $_nWave2 {("G1" 7)}
wvSetPosition -win $_nWave2 {("G1" 8)}
wvSetPosition -win $_nWave2 {("G1" 8)}
wvAddSignal -win $_nWave2 -clear
wvAddSignal -win $_nWave2 -group {"G1" \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i1_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift2} -height 25 \
{/tb_top/rvtop/clk} -height 25 \
}
wvAddSignal -win $_nWave2 -group {"G1//tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d@485(1s)#ActiveDriver" \
{/tb_top/rvtop/veer/dec/decode/freeze} -height 25 \
{/tb_top/rvtop/veer/dec/decode/i1_block_d} -height 25 \
{/tb_top/rvtop/veer/dec/decode/i1_dp.legal} -height 25 \
{/tb_top/rvtop/veer/dec/decode/i1_valid_d} -height 25 \
}
wvAddSignal -win $_nWave2 -group {"G1" {/tb_top/rvtop/veer/dec/dec_i0_inst_wb1\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_ib0_valid_d} -height 25 \
{/tb_top/rvtop/veer/dec/mul_p} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc4_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib1_ib0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib2_ib0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib2_ib1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib3_ib1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib3_ib2} -height 25 \
{/tb_top/rvtop/veer/dec/dec_tlu_dual_issue_disable} -height 25 \
}
wvAddSignal -win $_nWave2 -group {"G2" \
}
wvSelectSignal -win $_nWave2 {( "G1" 8 )} 
wvSetPosition -win $_nWave2 {("G1" 8)}
wvSetPosition -win $_nWave2 {("G1" 8)}
wvSetPosition -win $_nWave2 {("G1" 8)}
wvAddSignal -win $_nWave2 -clear
wvAddSignal -win $_nWave2 -group {"G1" \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i1_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift2} -height 25 \
{/tb_top/rvtop/clk} -height 25 \
}
wvAddSignal -win $_nWave2 -group {"G1//tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d@485(1s)#ActiveDriver" \
{/tb_top/rvtop/veer/dec/decode/freeze} -height 25 \
{/tb_top/rvtop/veer/dec/decode/i1_block_d} -height 25 \
{/tb_top/rvtop/veer/dec/decode/i1_dp.legal} -height 25 \
{/tb_top/rvtop/veer/dec/decode/i1_valid_d} -height 25 \
}
wvAddSignal -win $_nWave2 -group {"G1" {/tb_top/rvtop/veer/dec/dec_i0_inst_wb1\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_ib0_valid_d} -height 25 \
{/tb_top/rvtop/veer/dec/mul_p} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc4_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib1_ib0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib2_ib0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib2_ib1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib3_ib1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib3_ib2} -height 25 \
{/tb_top/rvtop/veer/dec/dec_tlu_dual_issue_disable} -height 25 \
}
wvAddSignal -win $_nWave2 -group {"G2" \
}
wvSelectSignal -win $_nWave2 {( "G1" 8 )} 
wvSetPosition -win $_nWave2 {("G1" 8)}
wvGetSignalClose -win $_nWave2
wvSetPosition -win $_nWave2 {("G1" 7)}
wvSetPosition -win $_nWave2 {("G1" 6)}
wvSetPosition -win $_nWave2 {("G1" 5)}
wvSetPosition -win $_nWave2 {("G1" 4)}
wvSetPosition -win $_nWave2 {("G1" 3)}
wvSetPosition -win $_nWave2 {("G1" 2)}
wvSetPosition -win $_nWave2 {("G1" 1)}
wvSetPosition -win $_nWave2 {("G1" 0)}
wvMoveSelected -win $_nWave2
wvSetPosition -win $_nWave2 {("G1" 0)}
wvSetPosition -win $_nWave2 {("G1" 1)}
wvSelectSignal -win $_nWave2 {( "G1" 7 )} 
wvSelectSignal -win $_nWave2 \
           {( "G1//tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d@485(1s)#ActiveDriver" \
           2 )} 
wvGetSignalOpen -win $_nWave2
wvGetSignalSetScope -win $_nWave2 "/_vcs_unit__1703114041"
wvGetSignalSetScope -win $_nWave2 "/tb_top"
wvGetSignalSetScope -win $_nWave2 "/tb_top/rvtop"
wvGetSignalSetScope -win $_nWave2 "/tb_top/rvtop/veer"
wvGetSignalSetScope -win $_nWave2 "/tb_top/rvtop/veer/dec"
wvGetSignalSetScope -win $_nWave2 "/tb_top/rvtop/veer/dec/instbuff"
wvGetSignalSetScope -win $_nWave2 "/tb_top/rvtop"
wvGetSignalSetSignalFilter -win $_nWave2 "*i0_block_d"
wvSetPosition -win $_nWave2 {("G1" 1)}
wvSetPosition -win $_nWave2 {("G1" 1)}
wvAddSignal -win $_nWave2 -clear
wvAddSignal -win $_nWave2 -group {"G1" \
{/tb_top/rvtop/clk} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i1_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift2} -height 25 \
}
wvAddSignal -win $_nWave2 -group {"G1//tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d@485(1s)#ActiveDriver" \
{/tb_top/rvtop/veer/dec/decode/freeze} -height 25 \
{/tb_top/rvtop/veer/dec/decode/i1_block_d} -height 25 \
{/tb_top/rvtop/veer/dec/decode/i1_dp.legal} -height 25 \
{/tb_top/rvtop/veer/dec/decode/i1_valid_d} -height 25 \
}
wvAddSignal -win $_nWave2 -group {"G1" {/tb_top/rvtop/veer/dec/dec_i0_inst_wb1\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_ib0_valid_d} -height 25 \
{/tb_top/rvtop/veer/dec/mul_p} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc4_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib1_ib0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib2_ib0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib2_ib1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib3_ib1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib3_ib2} -height 25 \
{/tb_top/rvtop/veer/dec/dec_tlu_dual_issue_disable} -height 25 \
}
wvAddSignal -win $_nWave2 -group {"G2" \
}
wvSetPosition -win $_nWave2 {("G1" 1)}
wvGetSignalSetScope -win $_nWave2 "/tb_top/rvtop/veer/dec"
wvGetSignalSetSignalFilter -win $_nWave2 "*i0_block_d*"
wvSetPosition -win $_nWave2 {("G1" 1)}
wvSetPosition -win $_nWave2 {("G1" 1)}
wvAddSignal -win $_nWave2 -clear
wvAddSignal -win $_nWave2 -group {"G1" \
{/tb_top/rvtop/clk} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i1_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift2} -height 25 \
}
wvAddSignal -win $_nWave2 -group {"G1//tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d@485(1s)#ActiveDriver" \
{/tb_top/rvtop/veer/dec/decode/freeze} -height 25 \
{/tb_top/rvtop/veer/dec/decode/i1_block_d} -height 25 \
{/tb_top/rvtop/veer/dec/decode/i1_dp.legal} -height 25 \
{/tb_top/rvtop/veer/dec/decode/i1_valid_d} -height 25 \
}
wvAddSignal -win $_nWave2 -group {"G1" {/tb_top/rvtop/veer/dec/dec_i0_inst_wb1\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_ib0_valid_d} -height 25 \
{/tb_top/rvtop/veer/dec/mul_p} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc4_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib1_ib0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib2_ib0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib2_ib1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib3_ib1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib3_ib2} -height 25 \
{/tb_top/rvtop/veer/dec/dec_tlu_dual_issue_disable} -height 25 \
}
wvAddSignal -win $_nWave2 -group {"G2" \
}
wvSetPosition -win $_nWave2 {("G1" 1)}
wvSetPosition -win $_nWave2 {("G1" 2)}
wvSetPosition -win $_nWave2 {("G1" 2)}
wvAddSignal -win $_nWave2 -clear
wvAddSignal -win $_nWave2 -group {"G1" \
{/tb_top/rvtop/clk} -height 25 \
{/tb_top/rvtop/veer/dec/decode/i0_block_d} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i1_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift2} -height 25 \
}
wvAddSignal -win $_nWave2 -group {"G1//tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d@485(1s)#ActiveDriver" \
{/tb_top/rvtop/veer/dec/decode/freeze} -height 25 \
{/tb_top/rvtop/veer/dec/decode/i1_block_d} -height 25 \
{/tb_top/rvtop/veer/dec/decode/i1_dp.legal} -height 25 \
{/tb_top/rvtop/veer/dec/decode/i1_valid_d} -height 25 \
}
wvAddSignal -win $_nWave2 -group {"G1" {/tb_top/rvtop/veer/dec/dec_i0_inst_wb1\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_ib0_valid_d} -height 25 \
{/tb_top/rvtop/veer/dec/mul_p} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc4_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib1_ib0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib2_ib0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib2_ib1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib3_ib1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib3_ib2} -height 25 \
{/tb_top/rvtop/veer/dec/dec_tlu_dual_issue_disable} -height 25 \
}
wvAddSignal -win $_nWave2 -group {"G2" \
}
wvSelectSignal -win $_nWave2 {( "G1" 2 )} 
wvSetPosition -win $_nWave2 {("G1" 2)}
wvSetPosition -win $_nWave2 {("G1" 2)}
wvSetPosition -win $_nWave2 {("G1" 2)}
wvAddSignal -win $_nWave2 -clear
wvAddSignal -win $_nWave2 -group {"G1" \
{/tb_top/rvtop/clk} -height 25 \
{/tb_top/rvtop/veer/dec/decode/i0_block_d} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i1_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift2} -height 25 \
}
wvAddSignal -win $_nWave2 -group {"G1//tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d@485(1s)#ActiveDriver" \
{/tb_top/rvtop/veer/dec/decode/freeze} -height 25 \
{/tb_top/rvtop/veer/dec/decode/i1_block_d} -height 25 \
{/tb_top/rvtop/veer/dec/decode/i1_dp.legal} -height 25 \
{/tb_top/rvtop/veer/dec/decode/i1_valid_d} -height 25 \
}
wvAddSignal -win $_nWave2 -group {"G1" {/tb_top/rvtop/veer/dec/dec_i0_inst_wb1\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i0_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/dec_i1_instr_d\[31:0\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_ib0_valid_d} -height 25 \
{/tb_top/rvtop/veer/dec/mul_p} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc_d\[31:1\]} -height 25 \
{/tb_top/rvtop/veer/dec/dec_i0_pc4_d} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib1_ib0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib2_ib0} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib2_ib1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib3_ib1} -height 25 \
{/tb_top/rvtop/veer/dec/instbuff/shift_ib3_ib2} -height 25 \
{/tb_top/rvtop/veer/dec/dec_tlu_dual_issue_disable} -height 25 \
}
wvAddSignal -win $_nWave2 -group {"G2" \
}
wvSelectSignal -win $_nWave2 {( "G1" 2 )} 
wvSetPosition -win $_nWave2 {("G1" 2)}
wvGetSignalClose -win $_nWave2
wvSelectSignal -win $_nWave2 \
           {( "G1//tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d@485(1s)#ActiveDriver" \
           2 )} 
wvSetPosition -win $_nWave2 \
           {("G1//tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d@485(1s)#ActiveDriver" 2)}
wvSetPosition -win $_nWave2 \
           {("G1//tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d@485(1s)#ActiveDriver" 1)}
wvSetPosition -win $_nWave2 \
           {("G1//tb_top/rvtop/veer/dec/instbuff/dec_i1_decode_d@485(1s)#ActiveDriver" 0)}
wvSetPosition -win $_nWave2 {("G1" 9)}
wvMoveSelected -win $_nWave2
wvSetPosition -win $_nWave2 {("G1" 9)}
wvSetPosition -win $_nWave2 {("G1" 10)}
wvSelectSignal -win $_nWave2 {( "G1" 2 )} 
wvSetPosition -win $_nWave2 {("G1" 2)}
wvSetPosition -win $_nWave2 {("G1" 3)}
wvSetPosition -win $_nWave2 {("G1" 4)}
wvSetPosition -win $_nWave2 {("G1" 5)}
wvSetPosition -win $_nWave2 {("G1" 6)}
wvSetPosition -win $_nWave2 {("G1" 7)}
wvSetPosition -win $_nWave2 {("G1" 8)}
wvSetPosition -win $_nWave2 {("G1" 9)}
wvMoveSelected -win $_nWave2
wvSetPosition -win $_nWave2 {("G1" 9)}
wvSelectSignal -win $_nWave2 {( "G1" 9 )} 
wvSelectSignal -win $_nWave2 {( "G1" 10 )} 
wvSetCursor -win $_nWave2 504.476855 -snap {("G1" 4)}
wvSetCursor -win $_nWave2 515.214694 -snap {("G1" 1)}
wvSetCursor -win $_nWave2 525.690635 -snap {("G1" 9)}
wvSetCursor -win $_nWave2 605.045883 -snap {("G1" 7)}
wvSelectSignal -win $_nWave2 {( "G1" 6 )} 
wvSelectSignal -win $_nWave2 {( "G1" 6 )} 
wvSelectSignal -win $_nWave2 {( "G1" 6 )} 
wvSelectSignal -win $_nWave2 {( "G1" 9 )} 
verdiDockWidgetSetCurTab -dock widgetDock_MTB_SOURCE_TAB_1
verdiDockWidgetSetCurTab -dock windowDock_nWave_2
wvSelectSignal -win $_nWave2 {( "G1" 9 )} 
wvShowOneTraceSignals -win $_nWave2 -signal \
           "/tb_top/rvtop/veer/dec/decode/i0_block_d" -chainDriver
verdiDockWidgetSetCurTab -dock widgetDock_MTB_SOURCE_TAB_1
srcDeselectAll -win $_nTrace1
srcSelect -signal "dec_i1_decode_d" -line 2051 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "dec_i1_decode_d" -line 2051 -pos 1 -win $_nTrace1
srcAction -pos 2050 11 9 -win $_nTrace1 -name "dec_i1_decode_d" -ctrlKey off
verdiDockWidgetSetCurTab -dock windowDock_nWave_2
wvSetCursor -win $_nWave2 504.476855 -snap {("G1" 4)}
wvSelectSignal -win $_nWave2 {( "G1" 3 )} 
wvSelectSignal -win $_nWave2 {( "G1" 4 )} 
wvSelectSignal -win $_nWave2 {( "G1" 5 )} 
wvSelectSignal -win $_nWave2 {( "G1" 4 )} 
verdiDockWidgetSetCurTab -dock widgetDock_MTB_SOURCE_TAB_1
srcDeselectAll -win $_nTrace1
srcSelect -signal "i0_block_d" -line 1399 -pos 1 -win $_nTrace1
srcAction -pos 1398 12 3 -win $_nTrace1 -name "i0_block_d" -ctrlKey off
srcDeselectAll -win $_nTrace1
srcSelect -signal "i0_mul_block_d" -line 1337 -pos 1 -win $_nTrace1
srcAction -pos 1336 1 6 -win $_nTrace1 -name "i0_mul_block_d" -ctrlKey off
srcDeselectAll -win $_nTrace1
srcSelect -signal "i0_rs1_class_d.mul" -line 1918 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "i0_rs1_class_d.mul" -line 1918 -pos 1 -win $_nTrace1
srcAction -pos 1917 12 10 -win $_nTrace1 -name "i0_rs1_class_d.mul" -ctrlKey off
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "i0_rs1_match_e1_e2" -line 1918 -pos 1 -win $_nTrace1
srcAction -pos 1917 16 11 -win $_nTrace1 -name "i0_rs1_match_e1_e2" -ctrlKey off
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "i0_block_d" -line 1399 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "i0_block_d" -line 1399 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "i0_block_d" -line 1399 -pos 1 -win $_nTrace1
srcAction -pos 1398 12 3 -win $_nTrace1 -name "i0_block_d" -ctrlKey off
srcDeselectAll -win $_nTrace1
srcSelect -signal "i0_mul_block_d" -line 1337 -pos 1 -win $_nTrace1
srcAction -pos 1336 1 7 -win $_nTrace1 -name "i0_mul_block_d" -ctrlKey off
srcDeselectAll -win $_nTrace1
srcSelect -signal "i0_not_alu_eff" -line 1918 -pos 1 -win $_nTrace1
srcAction -pos 1917 8 8 -win $_nTrace1 -name "i0_not_alu_eff" -ctrlKey off
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
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top" -win $_nTrace1
srcForwardHistory -win $_nTrace1
srcHBSelect "tb_top" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcForwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcForwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcForwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
verdiDockWidgetSetCurTab -dock windowDock_nWave_2
wvSelectSignal -win $_nWave2 {( "G1" 10 )} 
verdiDockWidgetSetCurTab -dock widgetDock_MTB_SOURCE_TAB_1
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
verdiDockWidgetSetCurTab -dock windowDock_nWave_2
wvSelectSignal -win $_nWave2 {( "G1" 2 )} 
wvSelectSignal -win $_nWave2 {( "G1" 5 )} 
wvSelectSignal -win $_nWave2 {( "G1" 4 )} 
verdiDockWidgetSetCurTab -dock widgetDock_MTB_SOURCE_TAB_1
srcDeselectAll -win $_nTrace1
srcSelect -signal "i0_block_d" -line 1399 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "i0_block_d" -line 1399 -pos 1 -win $_nTrace1
srcAction -pos 1398 12 6 -win $_nTrace1 -name "i0_block_d" -ctrlKey off
srcDeselectAll -win $_nTrace1
srcSelect -signal "i0_mul_block_d" -line 1337 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "i0_mul_block_d" -line 1337 -pos 1 -win $_nTrace1
srcAction -pos 1336 1 6 -win $_nTrace1 -name "i0_mul_block_d" -ctrlKey off
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "i1_block_d" -line 1343 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "i1_block_d" -line 1343 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "i1_block_d" -line 1343 -pos 1 -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "i1_block_d" -line 1343 -pos 1 -win $_nTrace1
srcShowCalling -win $_nTrace1
srcSelect -win $_nTrace1 -range {576 576 4 5 1 1}
srcHBSelect "tb_top.rvtop.veer.dec" -win $_nTrace1
srcBackwardHistory -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec" -win $_nTrace1
srcHBSelect "tb_top.rvtop.veer.dec.decode" -win $_nTrace1
srcTraceLoad "tb_top.rvtop.veer.dec.decode.i1_block_d" -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "dec_i1_decode_d" -line 1406 -pos 1 -win $_nTrace1
srcTraceLoad "tb_top.rvtop.veer.dec.decode.dec_i1_decode_d" -win $_nTrace1
srcTraceLoad "tb_top.rvtop.veer.dec.decode.dec_i1_decode_d" -win $_nTrace1
srcTraceLoad "tb_top.rvtop.veer.dec.decode.dec_i1_decode_d" -win $_nTrace1
srcDeselectAll -win $_nTrace1
srcSelect -signal "dec_i1_decode_d" -line 1409 -pos 1 -win $_nTrace1
srcAction -pos 1408 12 5 -win $_nTrace1 -name "dec_i1_decode_d" -ctrlKey off
srcDeselectAll -win $_nTrace1
srcTBInvokeSim
verdiDockWidgetSetCurTab -dock windowDock_nWave_2
wvSetCursor -win $_nWave2 33.023660 -snap {("G1" 5)}
verdiDockWidgetHide -dock widgetDock_<Member>
srcTBSetHiddenView -view MemberView
verdiDockWidgetHide -dock widgetDock_<Local>
srcTBSetHiddenView -view LocalView
wvSetCursor -win $_nWave2 156.886863 -snap {("G1" 6)}
nsMsgSwitchTab -tab general
debExit
