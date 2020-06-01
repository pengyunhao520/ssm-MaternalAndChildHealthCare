package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.SysStreet;
import mapper.SysStreetMapper;
import service.ISysStreetService;

@Service
public class SysStreetServiceImpl extends BaseServiceImpl<SysStreet> implements ISysStreetService {

	@Autowired
	private SysStreetMapper streetMapper;
	
	@Override
	public List<SysStreet> selectBycountyID(String countyid) {
		// TODO Auto-generated method stub
		return streetMapper.selectBycountyID(countyid);
	}

}
