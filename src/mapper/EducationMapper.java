package mapper;

import domain.Education;
import java.util.List;

public interface EducationMapper extends BaseMapper<Education>{
    int deleteByPrimaryKey(Integer id);

    int insert(Education record);

    Education selectByPrimaryKey(Integer id);

    List<Education> selectAll();

    int updateByPrimaryKey(Education record);
}