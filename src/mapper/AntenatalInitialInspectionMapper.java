package mapper;

import java.util.List;

import domain.AntenatalInitialInspection;
import domain.PremaritaHealthInformation;

public interface AntenatalInitialInspectionMapper extends BaseMapper<AntenatalInitialInspection>{
	List<AntenatalInitialInspection> selectAllByidnumber(String idnumber);
}