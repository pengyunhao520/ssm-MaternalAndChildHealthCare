package mapper;

import domain.SysArea;
import domain.SysCity;

import java.util.List;

public interface SysAreaMapper extends BaseMapper<SysArea>{
	public List<SysArea> selectByCityID(String cityid);
}