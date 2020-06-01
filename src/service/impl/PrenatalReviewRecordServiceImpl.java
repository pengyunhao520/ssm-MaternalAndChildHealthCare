package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.PrenatalReviewRecord;
import mapper.PrenatalReviewRecordMapper;
import service.IPrenatalReviewRecordService;

@Service
public class PrenatalReviewRecordServiceImpl extends BaseServiceImpl<PrenatalReviewRecord> implements IPrenatalReviewRecordService{
	
	@Autowired
	private PrenatalReviewRecordMapper prrMapper;
	
	//根据idnumber查询所有
	@Override
	public List<PrenatalReviewRecord> selectAllByidnumber(String idnumber) {
		return prrMapper.selectAllByidnumber(idnumber);
	}

}
