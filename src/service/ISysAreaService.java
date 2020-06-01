package service;

import java.util.List;

import domain.SysArea;

public interface ISysAreaService extends IBaseService<SysArea> {
	public List<SysArea> selectByCityID(String cityid);
}
