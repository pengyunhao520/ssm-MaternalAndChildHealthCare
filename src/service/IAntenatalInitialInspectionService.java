package service;

import java.util.List;

import org.springframework.stereotype.Service;

import domain.AntenatalInitialInspection;
import mapper.BaseMapper;

public interface IAntenatalInitialInspectionService extends IBaseService<AntenatalInitialInspection>{
	List<AntenatalInitialInspection> selectAllByidnumber(String idnumber);
}
