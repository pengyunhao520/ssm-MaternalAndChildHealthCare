package service;

import java.util.List;

import domain.PremaritaHealthInformation;

public interface IPremaritaHealthInformationService extends IBaseService<PremaritaHealthInformation>{
	List<PremaritaHealthInformation> selectAllByidnumber(String idnumber);
}
