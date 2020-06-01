package service;

import java.util.List;

import domain.SysCity;
import domain.User;

public interface ISysCityService extends IBaseService<SysCity> {
	public List<SysCity> selectByProvinceID(String provinceid);
}
