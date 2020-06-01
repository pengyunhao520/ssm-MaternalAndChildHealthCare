package service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.SysArea;
import mapper.SysAreaMapper;
import query.BaseQuery;
import service.ISysAreaService;
import util.PageList;

@Service
public class SysAreaServiceImpl extends BaseServiceImpl<SysArea> implements ISysAreaService {

	@Autowired
	private SysAreaMapper areaMapper;
	
	@Override
	public List<SysArea> selectByCityID(String cityid) {
		// TODO Auto-generated method stub
		return areaMapper.selectByCityID(cityid);
	}

	
}
