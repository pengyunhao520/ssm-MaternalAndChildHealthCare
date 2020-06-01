package service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.SysCity;
import domain.User;
import mapper.SysCityMapper;
import mapper.UserMapper;
import query.BaseQuery;
import service.ISysCityService;
import util.PageList;

@Service
public class SysCityServiceImpl extends BaseServiceImpl<SysCity> implements ISysCityService {

	@Autowired
	private SysCityMapper cityMapper;
	
	@Override
	public List<SysCity> selectByProvinceID(String provinceid) {
		// TODO Auto-generated method stub
		return cityMapper.selectByProvinceID(provinceid);
	}


	
}
