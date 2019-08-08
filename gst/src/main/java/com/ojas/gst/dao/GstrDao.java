package com.ojas.gst.dao;

import com.ojas.gst.returns.entity.B2BAResponse;
import com.ojas.gst.returns.entity.B2BResponse;
import com.ojas.gst.returns.entity.B2CLAResponse;
import com.ojas.gst.returns.entity.B2CLResponse;
import com.ojas.gst.returns.entity.B2CSAResponse;
import com.ojas.gst.returns.entity.B2CSResponse;
import com.ojas.gst.returns.entity.CDNRAResponse;
import com.ojas.gst.returns.entity.CDNRResponse;
import com.ojas.gst.returns.entity.CDNURAResponse;
import com.ojas.gst.returns.entity.CDNURResponse;
import com.ojas.gst.returns.entity.DocResponse;
import com.ojas.gst.returns.entity.EXPAResponse;
import com.ojas.gst.returns.entity.EXPResponse;
import com.ojas.gst.returns.entity.Gstr1Request;
import com.ojas.gst.returns.entity.HSNResponse;
import com.ojas.gst.returns.entity.NilResponse;
import com.ojas.gst.returns.entity.RefferenceId;
import com.ojas.gst.returns.entity.TXPADataResponse;
import com.ojas.gst.returns.entity.TXPResponse;

public interface GstrDao extends Dao<Gstr1Request, Long> {

//	RefferenceId findByGstinAndRet_period(GSTR1Entity entity);
	//public TXPADataResponse getGSTR1TxpdaDataByGSTIn(GSTR1Entity gstr1Entity);
	TXPADataResponse getGSTR1TxpdaDataByGSTIn(String gstin, String ret_period);
	RefferenceId findByGstinAndRet_period(String gstin, String ret_period);
	Gstr1Request getGSTR1data(String gstin,String ret_period);
	
	TXPResponse getGSTR1TxpaDataByGSTIn(String gstin,String ret_period);
	NilResponse getGSTR1nil(String gstin, String ret_period);
	HSNResponse getGSTR1hsn(String gstin,String ret_period);
	EXPAResponse getGSTR1Expa(String gstin, String ret_period);
	EXPResponse getGSTR1Exp(String gstin, String ret_period);
	DocResponse getGSTR1Doc(String gstin, String ret_period);
	CDNURAResponse getGSTR1CDNURA(String gstin,String ret_period);
	CDNURResponse getGSTR1CDNUR(String gstin,String ret_period);
	CDNRAResponse getGSTR1CDNRA(String gstin, String ret_period);
	CDNRResponse getGSTR1CDNR(String gstin, String ret_period);
	B2CSAResponse getGSTR1B2CSA(String gstin, String ret_period);
	B2CSResponse getGSTR1B2CS(String gstin, String ret_period);
	B2CLAResponse getGSTR1B2CLA(String gstin, String ret_period);
	B2CLResponse getGSTR1B2CL(String gstin, String ret_period);
	B2BAResponse getGSTR1B2BA(String gstin, String ret_period);
	B2BResponse getGSTR1B2B(String gstin, String ret_period);
}
