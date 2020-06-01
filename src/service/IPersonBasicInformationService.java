package service;

import java.util.List;

import domain.PersonBasicInformation;

public interface IPersonBasicInformationService extends IBaseService<PersonBasicInformation>{

	List<PersonBasicInformation> selectIDnumber();
	
}
