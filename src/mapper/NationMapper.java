package mapper;

import domain.Nation;
import java.util.List;

public interface NationMapper extends BaseMapper<Nation>{
    int deleteByPrimaryKey(Integer nationid);

    int insert(Nation record);

    Nation selectByPrimaryKey(Integer nationid);

    List<Nation> selectAll();

    int updateByPrimaryKey(Nation record);
}