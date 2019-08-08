package com.ojas.gst.entity;

import java.util.List;

public class PaymentOfTax {
	
	private List<TaxPayable> tx_py; 

	private List<TaxPaidCash> pdcash;
	
	private TaxPaidITC pditc;

	public List<TaxPayable> getTx_py() {
		return tx_py;
	}

	public void setTx_py(List<TaxPayable> tx_py) {
		this.tx_py = tx_py;
	}

	public List<TaxPaidCash> getPdcash() {
		return pdcash;
	}

	public void setPdcash(List<TaxPaidCash> pdcash) {
		this.pdcash = pdcash;
	}

	public TaxPaidITC getPditc() {
		return pditc;
	}

	public void setPditc(TaxPaidITC pditc) {
		this.pditc = pditc;
	}
	
	
	
	
}
