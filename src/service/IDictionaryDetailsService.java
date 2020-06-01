package service;

import java.util.List;

import domain.DictionaryDetails;

public interface IDictionaryDetailsService extends IBaseService<DictionaryDetails>{
	 List<DictionaryDetails> selectByfetalposition();
	 List<DictionaryDetails> selectByfetalpresentation();
}
