//  -- 46434
class SramRWAccess(ramNum: Int=2,bkNum: Int=2,sbkNum: Int=8,byteEnWidth: Int=8,addrWidth: Int=18)  extends Module {
   val entryBits=addrWidth-log2Ceil(sbkNum*byteEnWidth)
   val ramIdBits=log2Ceil(ramNum)
   val io =IO(new Bundle{
        val final_addr_req_sb     =Input(Vec(sbkNum*bkNum,UInt(addrWidth.W)))
        val final_val_dram_req_sb =Input(Vec(sbkNum*bkNum,Bool()))
        val final_dram_id_rdreq_sb=Input(Vec(sbkNum*bkNum,UInt(ramIdBits.W)))
		val final_dram_id_wrreq_sb=Input(Vec(sbkNum*bkNum,UInt(ramIdBits.W)))
        val final_sc8_req_sb      =Input(Vec(sbkNum*bkNum,Bool()))
        val final_sc16_req_sb     =Input(Vec(sbkNum*bkNum,Bool()))
        val final_inc16_req_sb    =Input(Vec(sbkNum*bkNum,Bool()))
        val final_wr_req_notrmw_sb=Input(Vec(sbkNum*bkNum,Bool()))
        val final_wr_req_sb       =Input(Vec(sbkNum*bkNum,Bool()))
		val final_byte_en_req_sb  =Input(Vec(sbkNum*bkNum,UInt(byteEnWidth.W)))
		val G2generalCLK          =Input(Bool())
		val G2generalCLKEn        =Input(Clock()) 
        val WaitClkGate           =Input(Bool())
        val MyReset               =Input(Bool())

        val DRamRdAddrSB          =Output(Vec(ramNum,Vec(bkNum,Vec(sbkNum,UInt(entryBits.W)))))
        val DRamWrAddrSB          =Output(Vec(ramNum,Vec(bkNum,Vec(sbkNum,UInt(entryBits.W)))))
		val DRamRdSB              =Output(Vec(ramNum,Vec(bkNum,Vec(sbkNum,Bool()))))
        val DRamWrSB              =Output(Vec(ramNum,Vec(bkNum,Vec(sbkNum,Bool()))))
		val DRamRd                =Output(Vec(ramNum,Vec(bkNum,Bool())))
        val DRamWr                =Output(Vec(ramNum,Vec(bkNum,Bool())))
		
        val DRamRmwRd             =Output(Vec(ramNum,Vec(bkNum,Bool())))
        val DRamRmwWr             =Output(Vec(ramNum,Vec(bkNum,Bool())))
        val DRamRdByteEn          =Output(Vec(ramNum,Vec(bkNum,UInt(sbkNum*byteEnWidth.W))))
        val DRamWrByteEn          =Output(Vec(ramNum,Vec(bkNum,UInt(sbkNum*byteEnWidth.W))))
   })

     val G2CLK=io.G2generalCLK
     val g2GateEnable= (!io.WaitClkGate) && io.G2generalCLKEn
	 val reset =  io.MyReset.asAsyncReset
     val internalDramSbByteEn = Wire(Vec(ramNum,Vec(bkNum,UInt(sbkNum*byteEnWidth.W))))
	 val DRamWr_notrmw_sb  =Wire(Vec(ramNum,Vec(bkNum,Vec(sbkNum,Bool()))))
     val DRamRmwRd_sb	   =Wire(Vec(ramNum,Vec(bkNum,Vec(sbkNum,Bool())))) 
	 
      for(ramId <- 0 until ramNum)
	     for(bkId <- 0 until bkNum){
		   for(sbkId <- 0 until sbkNum){
                io.DRamRdAddrSB(ramId)(bkId)(sbkId) := final_addr_req_sb(bkId*sbkNum+sbkId)(17,7)
                val DRamRd_sb_var= final_val_dram_req_sb(bkId*sbkNum+sbkId) &&  (final_dram_id_rdreq_sb(bkId*sbkNum+sbkId) === ramId.U(1.W))
				                                 !(final_sc8_req_sb(bkId*sbkNum+sbkId) || final_sc16_req_sb(bkId*sbkNum+sbkId))
				val DRamWr_sb_var=final_wr_req_sb0 && (final_dram_id_wrreq_sb0 === ramId.U(1.W))
				val DRamWr_notrmw_sb(ramId)(bkId)(sbkId)   = final_wr_req_notrmw_sb(bkId*sbkNum+sbkId) && 
				                     (final_dram_id_wrreq_sb(bkId*sbkNum+sbkId) === ramId.U(ramIdBits.W))
				val DRamRmwRd_sb(ramId)(bkId)(sbkId)       = final_val_dram_req_sb(bkId*sbkNum+sbkId) && 
				                     (final_dram_id_rdreq_sb(bkId*sbkNum+sbkId) === ramId.U(ramIdBits.W)) && 
									 final_inc16_req_sb(bkId*sbkNum+sbkId)
				internalDramSbByteEn(ramId)(bkId)(sbkId) := final_byte_en_req_sb(bkId*sbkNum+sbkId)
				io.DRamRdSB(ramId)(bkId)(sbkId)    :=xcff(1,G2CLK,reset,g2GateEnable,DRamRd_sb_var)
                io.DRamWrSB(ramId)(bkId)(sbkId)    :=xcff(1,G2CLK,reset,g2GateEnable,DRamWr_sb_var)
				

           }
		   io.DRamRd(ramId)(bkId)       := io.DRamRdSB(ramId)(bkId).orR
		   io.DRamWr(ramId)(bkId)       := DRamWr_notrmw_sb(ramId)(bkId).orR
		   io.DRamRmwRd(ramId)(bkId)    := DRamRmwRd_sb(ramId)(bkId).orR
		   val DRamRmwWr_pre = io.DRamWrSB(ramId)(bkId).orR
           io.DRamRmwWr(ramId)(bkId)    :=xcff(1.G2CLK,reset,g2GateEnable,DRamRmwWr_pre)   
		   val bankByteEn    = Cat(internalDramSbByteEn(ramId)(bkId).reverse)
		   io.DRamRdByteEn(ramId)(bkId)  := bankByteEn
		   io.DRamWrByteEn(ramId)(bkId)  := bankByteEn


		}

       

}


/* 
wire SG0DRam0Rd_sb0;
wire SG0DRam0Wr_sb0;
wire SG0DRam0Wr_notrmw_sb0;
wire SG0DRam0RmwRd_sb0;
wire SG0DRam0RmwWr_sb0;
wire [7:0] Internal_SG0DRam0ByteEn_req_sb0;
wire [10:0] Internal_SG0DRam0AddrS0;
        assign Internal_SG0DRam0AddrS0 = final_addr_req_sb0[17:7];
        assign SG0DRam0RdAddrS0 = Internal_SG0DRam0AddrS0;
        assign SG0DRam0WrAddrS0 = Internal_SG0DRam0AddrS0;
        assign SG0DRam0Rd_sb0   = final_val_dram_req_sb0 && (final_dram_id_rdreq_sb0 == 1'h0)
							&& !(final_sc8_req_sb0 || final_sc16_req_sb0)
										;
// Output to the DRAM logic
reg SG0DRam0RdS0_reg;
assign SG0DRam0RdS0 = SG0DRam0RdS0_reg;
always @(posedge G2generalCLK or posedge MyReset) SG0DRam0RdS0_reg <= `XT_SEQ_DELAY MyReset ? 1'b0 :
    ((~WaitClkGate) & (G2generalCLKEn)) ? SG0DRam0Rd_sb0 : SG0DRam0RdS0_reg;
        assign SG0DRam0RmwRd_sb0   = final_val_dram_req_sb0 && (final_dram_id_rdreq_sb0 == 1'h0)
							&& final_inc16_req_sb0
										;

        assign SG0DRam0Wr_notrmw_sb0   = final_wr_req_notrmw_sb0 && (final_dram_id_wrreq_sb0 == 1'h0);
        assign SG0DRam0Wr_sb0   = final_wr_req_sb0 && (final_dram_id_wrreq_sb0 == 1'h0);
// Output to the DRAM logic
reg SG0DRam0WrS0_reg;
assign SG0DRam0WrS0 = SG0DRam0WrS0_reg;
always @(posedge G2generalCLK or posedge MyReset) SG0DRam0WrS0_reg <= `XT_SEQ_DELAY MyReset ? 1'b0 :
    ((~WaitClkGate) & (G2generalCLKEn)) ? SG0DRam0Wr_sb0 : SG0DRam0WrS0_reg;
        assign SG0DRam0RmwWr_sb0   = val_dram_req_sb0_stage5 && inc16_req_bank0_stage5 && (dram_id_req_bank0_stage5 == 1'h0);

        assign Internal_SG0DRam0ByteEn_req_sb0 = final_byte_en_req_sb0; 
        
        */


/*         
      assign SG0DRam0Rd    = 
		SG0DRam0Rd_sb0 ||
		SG0DRam0Rd_sb1 ||
		SG0DRam0Rd_sb2 ||
		SG0DRam0Rd_sb3 ||
		SG0DRam0Rd_sb4 ||
		SG0DRam0Rd_sb5 ||
		SG0DRam0Rd_sb6 ||
		SG0DRam0Rd_sb7 ||
		1'b0;

        assign SG0DRam0Wr    = 
		SG0DRam0Wr_notrmw_sb0 ||
		SG0DRam0Wr_notrmw_sb1 ||
		SG0DRam0Wr_notrmw_sb2 ||
		SG0DRam0Wr_notrmw_sb3 ||
		SG0DRam0Wr_notrmw_sb4 ||
		SG0DRam0Wr_notrmw_sb5 ||
		SG0DRam0Wr_notrmw_sb6 ||
		SG0DRam0Wr_notrmw_sb7 ||
		1'b0;

	assign	SG0DRam0RmwRd = 
		SG0DRam0RmwRd_sb0 ||
		SG0DRam0RmwRd_sb1 ||
		SG0DRam0RmwRd_sb2 ||
		SG0DRam0RmwRd_sb3 ||
		SG0DRam0RmwRd_sb4 ||
		SG0DRam0RmwRd_sb5 ||
		SG0DRam0RmwRd_sb6 ||
		SG0DRam0RmwRd_sb7 ||
		1'b0;
wire SG0DRam0RmwWr_pre;
	assign  SG0DRam0RmwWr_pre = 
		SG0DRam0RmwWr_sb0 ||
		SG0DRam0RmwWr_sb1 ||
		SG0DRam0RmwWr_sb2 ||
		SG0DRam0RmwWr_sb3 ||
		SG0DRam0RmwWr_sb4 ||
		SG0DRam0RmwWr_sb5 ||
		SG0DRam0RmwWr_sb6 ||
		SG0DRam0RmwWr_sb7 ||
		1'b0;
reg SG0DRam0RmwWr_reg;
assign SG0DRam0RmwWr = SG0DRam0RmwWr_reg;
always @(posedge G2generalCLK or posedge MyReset) SG0DRam0RmwWr_reg <= `XT_SEQ_DELAY MyReset ? 1'b0 :
    ((~WaitClkGate) & (G2generalCLKEn)) ? SG0DRam0RmwWr_pre : SG0DRam0RmwWr_reg;

        assign SG0DRam0RdByteEn  = {Internal_SG0DRam0ByteEn_req_sb7 ,
                                  Internal_SG0DRam0ByteEn_req_sb6 ,
                                  Internal_SG0DRam0ByteEn_req_sb5 ,
                                  Internal_SG0DRam0ByteEn_req_sb4 ,
                                  Internal_SG0DRam0ByteEn_req_sb3 ,
                                  Internal_SG0DRam0ByteEn_req_sb2 ,
                                  Internal_SG0DRam0ByteEn_req_sb1 ,
                                  Internal_SG0DRam0ByteEn_req_sb0};
        assign SG0DRam0WrByteEn = SG0DRam0RdByteEn; 
        */