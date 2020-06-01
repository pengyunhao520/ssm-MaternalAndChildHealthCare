package mapper;

import domain.SysCity;
import domain.User;
import service.ISysCityService;

import java.util.List;

public interface SysCityMapper extends BaseMapper<SysCity>{
	
	public List<SysCity> selectByProvinceID(String provinceid);
}