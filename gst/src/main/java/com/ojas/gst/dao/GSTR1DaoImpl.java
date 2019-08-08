package com.ojas.gst.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.ojas.gst.returns.entity.B2BAInvoice;
import com.ojas.gst.returns.entity.B2BAResponse;
import com.ojas.gst.returns.entity.B2BInvoices;
import com.ojas.gst.returns.entity.B2BResponse;
import com.ojas.gst.returns.entity.B2CLAInVoices;
import com.ojas.gst.returns.entity.B2CLAResponse;
import com.ojas.gst.returns.entity.B2CLInvoices;
import com.ojas.gst.returns.entity.B2CLResponse;
import com.ojas.gst.returns.entity.B2CSA;
import com.ojas.gst.returns.entity.B2CSAResponse;
import com.ojas.gst.returns.entity.B2CSDetails;
import com.ojas.gst.returns.entity.B2CSResponse;
import com.ojas.gst.returns.entity.CDNRAData;
import com.ojas.gst.returns.entity.CDNRAResponse;
import com.ojas.gst.returns.entity.CDNRData;
import com.ojas.gst.returns.entity.CDNRResponse;
import com.ojas.gst.returns.entity.CDNURAData;
import com.ojas.gst.returns.entity.CDNURAResponse;
import com.ojas.gst.returns.entity.CDNURData;
import com.ojas.gst.returns.entity.CDNURResponse;
import com.ojas.gst.returns.entity.DOCIssuedInvoices;
import com.ojas.gst.returns.entity.DocResponse;
import com.ojas.gst.returns.entity.EXPAInvoices;
import com.ojas.gst.returns.entity.EXPAResponse;
import com.ojas.gst.returns.entity.EXPInvoices;
import com.ojas.gst.returns.entity.EXPResponse;
import com.ojas.gst.returns.entity.Gstr1Request;
import com.ojas.gst.returns.entity.HSNData;
import com.ojas.gst.returns.entity.HSNResponse;
import com.ojas.gst.returns.entity.NilResponse;
import com.ojas.gst.returns.entity.NilSupplies;
import com.ojas.gst.returns.entity.RefferenceId;
import com.ojas.gst.returns.entity.TXPAData;
import com.ojas.gst.returns.entity.TXPADataResponse;
import com.ojas.gst.returns.entity.TXPInvoices;
import com.ojas.gst.returns.entity.TXPResponse;



public class GSTR1DaoImpl extends JpaDao<Gstr1Request, Long> implements GstrDao {

	public GSTR1DaoImpl() {
		super(Gstr1Request.class);
		// TODO Auto-generated constructor stub
	}

	public GSTR1DaoImpl(Class<Gstr1Request> entityClass, EntityManager entityManager) {
		super(entityClass);
		this.entityManager = entityManager;
	}

	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	public void setEntityManager(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public RefferenceId findByGstinAndRet_period(String gstin, String ret_period) {
		Query nativeQuery = this.entityManager.createNativeQuery(
				"select * from gstr1request where gstin = '" + gstin + "' and ret_period ='" + ret_period + "'");
		List<Object[]> resultList = nativeQuery.getResultList();
		RefferenceId refferenceId = new RefferenceId();
		for (Object[] result : resultList) {
			String string = result[1].toString();
			refferenceId.setRef_Id(string);
			return refferenceId;
		}
		return null;
	}

	@Override
	public TXPADataResponse getGSTR1TxpdaDataByGSTIn(String gstin, String ret_period) {

		TypedQuery<Gstr1Request> createQuery = this.entityManager.createQuery(
				"from Gstr1Request g where g.gstin = '" + gstin + "' and g.ret_period ='" + ret_period + "'",
				Gstr1Request.class);
		List<Gstr1Request> resultList = createQuery.getResultList();

		TXPADataResponse txpaDataResponse = new TXPADataResponse();
		for (Gstr1Request gstr1Request : resultList) {
			List<TXPAData> txpda = gstr1Request.getTxpda();
			txpaDataResponse.setTxpda(txpda);

		}

		return txpaDataResponse;

	}

	@Override
	public Gstr1Request getGSTR1data(String gstin, String ret_period) {

		TypedQuery<Gstr1Request> createQuery = this.entityManager.createQuery(
				"from Gstr1Request g where g.gstin = '" + gstin + "' and g.ret_period ='" + ret_period + "'",
				Gstr1Request.class);
		List<Gstr1Request> resultList = createQuery.getResultList();
		for (Gstr1Request gstr1Request : resultList) {
			return gstr1Request;

		}
		return null;

	}

	@Override
	public TXPResponse getGSTR1TxpaDataByGSTIn(String gstin, String ret_period) {
		TypedQuery<Gstr1Request> createQuery = this.entityManager.createQuery(
				"from Gstr1Request g where g.gstin = '" + gstin + "' and g.ret_period ='" + ret_period + "'",
				Gstr1Request.class);
		List<Gstr1Request> resultList = createQuery.getResultList();

		TXPResponse txpResponse = new TXPResponse();
		for (Gstr1Request gstr1Request : resultList) {
			List<TXPInvoices> txpda = gstr1Request.getTxpd();
			txpResponse.setTxpd(txpda);

		}

		return txpResponse;
	}

	@Override
	public NilResponse getGSTR1nil(String gstin, String ret_period) {
		TypedQuery<Gstr1Request> createQuery = this.entityManager.createQuery(
				"from Gstr1Request g where g.gstin = '" + gstin + "' and g.ret_period ='" + ret_period + "'",
				Gstr1Request.class);
		List<Gstr1Request> resultList = createQuery.getResultList();

		NilResponse nil = new NilResponse();
		for (Gstr1Request gstr1Request : resultList) {
			NilSupplies nil1 = gstr1Request.getNil();
			nil.setNil(nil1);

		}

		return nil;
	}

	@Override
	public HSNResponse getGSTR1hsn(String gstin, String ret_period) {
		TypedQuery<Gstr1Request> createQuery = this.entityManager.createQuery(
				"from Gstr1Request g where g.gstin = '" + gstin + "' and g.ret_period ='" + ret_period + "'",
				Gstr1Request.class);
		List<Gstr1Request> resultList = createQuery.getResultList();

		HSNResponse hsnResponse = new HSNResponse();
		for (Gstr1Request gstr1Request : resultList) {
			HSNData hsn = gstr1Request.getHsn();
			hsnResponse.setHsnData(hsn);

		}

		return hsnResponse;
	}

	@Override
	public EXPAResponse getGSTR1Expa(String gstin, String ret_period) {

		TypedQuery<Gstr1Request> createQuery = this.entityManager.createQuery(
				"from Gstr1Request g where g.gstin = '" + gstin + "' and g.ret_period ='" + ret_period + "'",
				Gstr1Request.class);
		List<Gstr1Request> resultList = createQuery.getResultList();
		EXPAResponse expaResponse = new EXPAResponse();
		for (Gstr1Request gstr1Request : resultList) {
			List<EXPAInvoices> expa = gstr1Request.getExpa();
			expaResponse.setExpa(expa);

		}
		return expaResponse;
	}

	@Override
	public EXPResponse getGSTR1Exp(String gstin, String ret_period) {
		TypedQuery<Gstr1Request> createQuery = this.entityManager.createQuery(
				"from Gstr1Request g where g.gstin = '" + gstin + "' and g.ret_period ='" + ret_period + "'",
				Gstr1Request.class);
		List<Gstr1Request> resultList = createQuery.getResultList();
		EXPResponse expResponse = new EXPResponse();
		for (Gstr1Request gstr1Request : resultList) {
			List<EXPInvoices> exp = gstr1Request.getExp();
			expResponse.setExp(exp);
		}
		return expResponse;
	}

	@Override
	public DocResponse getGSTR1Doc(String gstin, String ret_period) {
		TypedQuery<Gstr1Request> createQuery = this.entityManager.createQuery(
				"from Gstr1Request g where g.gstin = '" + gstin + "' and g.ret_period ='" + ret_period + "'",
				Gstr1Request.class);
		List<Gstr1Request> resultList = createQuery.getResultList();
		DocResponse docResponse = new DocResponse();
		for (Gstr1Request gstr1Request : resultList) {
			DOCIssuedInvoices doc_issue = gstr1Request.getDoc_issue();
			docResponse.setDoc_issue(doc_issue);
		}
		return docResponse;
	}

	@Override
	public CDNURAResponse getGSTR1CDNURA(String gstin, String ret_period) {
		TypedQuery<Gstr1Request> createQuery = this.entityManager.createQuery(
				"from Gstr1Request g where g.gstin = '" + gstin + "' and g.ret_period ='" + ret_period + "'",
				Gstr1Request.class);
		List<Gstr1Request> resultList = createQuery.getResultList();
		CDNURAResponse cdnuraResponse = new CDNURAResponse();
		for (Gstr1Request gstr1Request : resultList) {
			List<CDNURAData> cdnura = gstr1Request.getCdnura();
			cdnuraResponse.setCdnura(cdnura);
		}
		return cdnuraResponse;
	}

	@Override
	public CDNURResponse getGSTR1CDNUR(String gstin, String ret_period) {
		TypedQuery<Gstr1Request> createQuery = this.entityManager.createQuery(
				"from Gstr1Request g where g.gstin = '" + gstin + "' and g.ret_period ='" + ret_period + "'",
				Gstr1Request.class);
		List<Gstr1Request> resultList = createQuery.getResultList();
		CDNURResponse Response = new CDNURResponse();
		for (Gstr1Request gstr1Request : resultList) {
			List<CDNURData> cdnura = gstr1Request.getCdnur();
			Response.setCdnur(cdnura);
		}
		return Response;
	}

	@Override
	public CDNRAResponse getGSTR1CDNRA(String gstin, String ret_period) {
		TypedQuery<Gstr1Request> createQuery = this.entityManager.createQuery(
				"from Gstr1Request g where g.gstin = '" + gstin + "' and g.ret_period ='" + ret_period + "'",
				Gstr1Request.class);
		List<Gstr1Request> resultList = createQuery.getResultList();
		CDNRAResponse cdnraResponse = new CDNRAResponse();
		for (Gstr1Request gstr1Request : resultList) {
			List<CDNRAData> cdnra = gstr1Request.getCdnra();
			cdnraResponse.setCdnra(cdnra);
		}
		return cdnraResponse;
	}

	@Override
	public CDNRResponse getGSTR1CDNR(String gstin, String ret_period) {
		TypedQuery<Gstr1Request> createQuery = this.entityManager.createQuery(
				"from Gstr1Request g where g.gstin = '" + gstin + "' and g.ret_period ='" + ret_period + "'",
				Gstr1Request.class);
		List<Gstr1Request> resultList = createQuery.getResultList();
		CDNRResponse cdnrResponse = new CDNRResponse();
		for (Gstr1Request gstr1Request : resultList) {
			List<CDNRData> cdnr = gstr1Request.getCdnr();
			cdnrResponse.setCdnr(cdnr);
		}
		return cdnrResponse;
	}

	@Override
	public B2CSAResponse getGSTR1B2CSA(String gstin, String ret_period) {
		TypedQuery<Gstr1Request> createQuery = this.entityManager.createQuery(
				"from Gstr1Request g where g.gstin = '" + gstin + "' and g.ret_period ='" + ret_period + "'",
				Gstr1Request.class);
		List<Gstr1Request> resultList = createQuery.getResultList();
		B2CSAResponse b2csaResponse = new B2CSAResponse();
		for (Gstr1Request gstr1Request : resultList) {
			List<B2CSA> b2vsa = gstr1Request.getB2csa();
			b2csaResponse.setB2csa(b2vsa);
		}
		return b2csaResponse;
	}

	@Override
	public B2CSResponse getGSTR1B2CS(String gstin, String ret_period) {
		TypedQuery<Gstr1Request> createQuery = this.entityManager.createQuery(
				"from Gstr1Request g where g.gstin = '" + gstin + "' and g.ret_period ='" + ret_period + "'",
				Gstr1Request.class);
		List<Gstr1Request> resultList = createQuery.getResultList();
		B2CSResponse b2csResponse = new B2CSResponse();
		for (Gstr1Request gstr1Request : resultList) {
			List<B2CSDetails> b2cs = gstr1Request.getB2cs();
			b2csResponse.setB2cs(b2cs);

		}
		return b2csResponse;
	}

	@Override
	public B2CLAResponse getGSTR1B2CLA(String gstin, String ret_period) {
		TypedQuery<Gstr1Request> createQuery = this.entityManager.createQuery(
				"from Gstr1Request g where g.gstin = '" + gstin + "' and g.ret_period ='" + ret_period + "'",
				Gstr1Request.class);
		List<Gstr1Request> resultList = createQuery.getResultList();
		B2CLAResponse b2claResponse = new B2CLAResponse();
		for (Gstr1Request gstr1Request : resultList) {
			List<B2CLAInVoices> b2cla = gstr1Request.getB2cla();
			b2claResponse.setB2cla(b2cla);

		}
		return b2claResponse;
	}

	@Override
	public B2CLResponse getGSTR1B2CL(String gstin, String ret_period) {
		TypedQuery<Gstr1Request> createQuery = this.entityManager.createQuery(
				"from Gstr1Request g where g.gstin = '" + gstin + "' and g.ret_period ='" + ret_period + "'",
				Gstr1Request.class);
		List<Gstr1Request> resultList = createQuery.getResultList();
		 B2CLResponse b2clResponse = new B2CLResponse();
		for (Gstr1Request gstr1Request : resultList) {
			List<B2CLInvoices> b2cl = gstr1Request.getB2cl();
		b2clResponse.setB2cl(b2cl);

		}
		return b2clResponse;
	}

	@Override
	public B2BAResponse getGSTR1B2BA(String gstin, String ret_period) {
		TypedQuery<Gstr1Request> createQuery = this.entityManager.createQuery(
				"from Gstr1Request g where g.gstin = '" + gstin + "' and g.ret_period ='" + ret_period + "'",
				Gstr1Request.class);
		List<Gstr1Request> resultList = createQuery.getResultList();
		B2BAResponse b2baResponse = new B2BAResponse();
		for (Gstr1Request gstr1Request : resultList) {
			List<B2BAInvoice> b2cl = gstr1Request.getB2ba();
		b2baResponse.setB2ba(b2cl);

		}
		return b2baResponse;
	}

	@Override
	public B2BResponse getGSTR1B2B(String gstin, String ret_period) {
		TypedQuery<Gstr1Request> createQuery = this.entityManager.createQuery(
				"from Gstr1Request g where g.gstin = '" + gstin + "' and g.ret_period ='" + ret_period + "'",
				Gstr1Request.class);
		List<Gstr1Request> resultList = createQuery.getResultList();
	 B2BResponse b2bResponse = new B2BResponse();
		for (Gstr1Request gstr1Request : resultList) {
		 List<B2BInvoices> b2b = gstr1Request.getB2b();
		b2bResponse.setB2b(b2b);

		}
		return b2bResponse;
	}
}
