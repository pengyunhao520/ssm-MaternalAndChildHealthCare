package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.AntenatalInitialInspection;
import mapper.AntenatalInitialInspectionMapper;
import service.IAntenatalInitialInspectionService;

@Service
public class AntenatalInitialInspectionServiceImpl extends BaseServiceImpl<AntenatalInitialInspection> implements IAntenatalInitialInspectionService{
	
	@Autowired
	private AntenatalInitialInspectionMapper AiiMapper;
	
	@Override
	public List<AntenatalInitialInspection> selectAllByidnumber(String idnumber) {
		List<AntenatalInitialInspection> byidnumber = AiiMapper.selectAllByidnumber(idnumber);
		return byidnumber;
	}

}
