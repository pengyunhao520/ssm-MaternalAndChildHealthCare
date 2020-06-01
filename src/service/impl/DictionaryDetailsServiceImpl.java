package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.DictionaryDetails;
import mapper.DictionaryDetailsMapper;
import service.IDictionaryDetailsService;

@Service
public class DictionaryDetailsServiceImpl extends BaseServiceImpl<DictionaryDetails> implements IDictionaryDetailsService{
	
	@Autowired
	private DictionaryDetailsMapper ddMapper;
	
	//查询所有fetalposition
	@Override
	public List<DictionaryDetails> selectByfetalposition() {
		return ddMapper.selectByfetalposition();
	}
	
	//查询所有fetalpresentation
	@Override
	public List<DictionaryDetails> selectByfetalpresentation() {
		return ddMapper.selectByfetalpresentation();
	}

}
