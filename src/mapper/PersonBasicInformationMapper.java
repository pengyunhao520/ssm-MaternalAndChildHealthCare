package mapper;

import domain.PersonBasicInformation;
import java.util.List;

public interface PersonBasicInformationMapper extends BaseMapper<PersonBasicInformation>{
    List<PersonBasicInformation> selectIDnumber();
    
}