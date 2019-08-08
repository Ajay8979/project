package com.ojas.gst.entity;
/**
 * 
 * @author akrishna
 *
 */
public class RefundClaimDetails {

	private IGRFClaim igrfclm;
	private CGRFClaim cgrfclm;
	private SGRFClaim sgrfclm;
	private CSRFClaim csrfclm;
	private Double bankacc;
	public IGRFClaim getIgrfclm() {
		return igrfclm;
	}
	public void setIgrfclm(IGRFClaim igrfclm) {
		this.igrfclm = igrfclm;
	}
	public CGRFClaim getCgrfclm() {
		return cgrfclm;
	}
	public void setCgrfclm(CGRFClaim cgrfclm) {
		this.cgrfclm = cgrfclm;
	}
	public SGRFClaim getSgrfclm() {
		return sgrfclm;
	}
	public void setSgrfclm(SGRFClaim sgrfclm) {
		this.sgrfclm = sgrfclm;
	}
	public CSRFClaim getCsrfclm() {
		return csrfclm;
	}
	public void setCsrfclm(CSRFClaim csrfclm) {
		this.csrfclm = csrfclm;
	}
	public Double getBankacc() {
		return bankacc;
	}
	public void setBankacc(Double bankacc) {
		this.bankacc = bankacc;
	}
	
	
	
}
