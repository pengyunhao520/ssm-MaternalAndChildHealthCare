package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.PregnantWomanInformation;
import domain.PrewomanGeneticHistory;
import mapper.PregnantWomanInformationMapper;
import service.IPregnantWomanInformationService;

@Service
public class PregnantWomanInformationServiceImpl extends BaseServiceImpl<PregnantWomanInformation> implements IPregnantWomanInformationService{

	@Autowired
	private PregnantWomanInformationMapper pwiMapper;

	@Override
	public List<PregnantWomanInformation> selectAllByhusbandid(Integer husbandid) {
		List<PregnantWomanInformation> allByhusbandid = pwiMapper.selectAllByhusbandid(husbandid);
		return allByhusbandid;
	}

	@Override
	public List<PregnantWomanInformation> selectPreWomanidnumber() {
		return pwiMapper.selectPreWomanidnumber();
	}
}
