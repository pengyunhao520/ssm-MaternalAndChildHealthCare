package service;

import java.util.List;

import domain.SysStreet;

public interface ISysStreetService extends IBaseService<SysStreet> {
	public List<SysStreet> selectBycountyID(String countyid);
}
