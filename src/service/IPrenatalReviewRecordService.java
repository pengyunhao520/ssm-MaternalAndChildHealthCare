package service;

import java.util.List;

import domain.PrenatalReviewRecord;

public interface IPrenatalReviewRecordService extends IBaseService<PrenatalReviewRecord>{
	//根据idnumber查询所有
	List<PrenatalReviewRecord> selectAllByidnumber(String idnumber);
}
