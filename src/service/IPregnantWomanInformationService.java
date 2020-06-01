package service;

import java.util.List;

import domain.PregnantWomanInformation;

public interface IPregnantWomanInformationService extends IBaseService<PregnantWomanInformation>{

	List<PregnantWomanInformation> selectAllByhusbandid(Integer husbandid);
	List<PregnantWomanInformation> selectPreWomanidnumber();
}
