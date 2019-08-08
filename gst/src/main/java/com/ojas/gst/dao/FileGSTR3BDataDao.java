package com.ojas.gst.dao;

import com.ojas.gst.entity.FileGSTR3BData;
import com.ojas.gst.entity.GSTR3BEntity;
import com.ojas.gst.entity.RefferenceId;

public interface FileGSTR3BDataDao extends Dao<FileGSTR3BData, Long> {

	RefferenceId findByGstinAndRet_period(GSTR3BEntity entity);
	
	FileGSTR3BData findByFileGSTR3B(GSTR3BEntity entity);
}
