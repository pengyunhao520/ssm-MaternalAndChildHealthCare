package mapper;


import java.util.List;

import domain.DictionaryDetails;

public interface DictionaryDetailsMapper extends BaseMapper<DictionaryDetails>{
	 List<DictionaryDetails> selectByfetalposition();
	 List<DictionaryDetails> selectByfetalpresentation();
}