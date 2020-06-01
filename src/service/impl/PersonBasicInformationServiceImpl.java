package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.PersonBasicInformation;
import mapper.PersonBasicInformationMapper;
import service.IPersonBasicInformationService;

@Service
public class PersonBasicInformationServiceImpl extends BaseServiceImpl<PersonBasicInformation> implements IPersonBasicInformationService {
	
	@Autowired
	private PersonBasicInformationMapper pbiMapper;
	
	@Override
	public List<PersonBasicInformation> selectIDnumber() {
		List<PersonBasicInformation> list = pbiMapper.selectIDnumber();
		return list;
	}

}
