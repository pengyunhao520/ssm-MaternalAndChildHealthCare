package mapper;

import java.util.List;

import domain.PrenatalReviewRecord;

public interface PrenatalReviewRecordMapper extends BaseMapper<PrenatalReviewRecord>{
	//根据idnumber查询所有
	List<PrenatalReviewRecord> selectAllByidnumber(String idnumber);
}