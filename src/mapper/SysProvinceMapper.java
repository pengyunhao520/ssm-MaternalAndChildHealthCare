package mapper;

import domain.SysProvince;
import java.util.List;

public interface SysProvinceMapper extends BaseMapper<SysProvince>{
    int deleteByPrimaryKey(Integer id);

    int insert(SysProvince record);

    SysProvince selectByPrimaryKey(Integer id);

    List<SysProvince> selectAll();

    int updateByPrimaryKey(SysProvince record);
}