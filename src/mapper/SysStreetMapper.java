package mapper;

import domain.SysStreet;
import java.util.List;

import org.aspectj.util.LangUtil.ProcessController.Thrown;

public interface SysStreetMapper extends BaseMapper<SysStreet>{
   public List<SysStreet> selectBycountyID(String countyid);
}