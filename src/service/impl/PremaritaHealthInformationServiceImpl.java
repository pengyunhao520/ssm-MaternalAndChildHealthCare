package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.PremaritaHealthInformation;
import mapper.PremaritaHealthInformationMapper;
import service.IPremaritaHealthInformationService;

@Service
public class PremaritaHealthInformationServiceImpl extends BaseServiceImpl<PremaritaHealthInformation> implements IPremaritaHealthInformationService{

	@Autowired
	private PremaritaHealthInformationMapper phiMapper;
	
	@Override
	public List<PremaritaHealthInformation> selectAllByidnumber(String idnumber) {
		List<PremaritaHealthInformation> allByidnumber = phiMapper.selectAllByidnumber(idnumber);
		return allByidnumber;
	}
	

}
