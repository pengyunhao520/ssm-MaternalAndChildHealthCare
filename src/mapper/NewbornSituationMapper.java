package mapper;

import domain.NewbornSituation;
import java.util.List;

public interface NewbornSituationMapper extends BaseMapper<NewbornSituation>{
    int deleteByPrimaryKey(Integer id);

    int insert(NewbornSituation record);

    NewbornSituation selectByPrimaryKey(Integer id);

    List<NewbornSituation> selectAll();

    int updateByPrimaryKey(NewbornSituation record);
}