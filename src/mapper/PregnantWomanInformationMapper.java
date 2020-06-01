package mapper;

import domain.PregnantWomanInformation;

import java.util.List;

public interface PregnantWomanInformationMapper extends BaseMapper<PregnantWomanInformation>{
	List<PregnantWomanInformation> selectAllByhusbandid(Integer husbandid);
	List<PregnantWomanInformation> selectPreWomanidnumber();
	
}