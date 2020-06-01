package mapper;

import java.util.List;

import domain.PremaritaHealthInformation;

public interface PremaritaHealthInformationMapper extends BaseMapper<PremaritaHealthInformation>{
	List<PremaritaHealthInformation> selectAllByidnumber(String idnumber);
}