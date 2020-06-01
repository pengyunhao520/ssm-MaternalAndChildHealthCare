package mapper;

import java.io.Serializable;
import java.util.List;

import query.BaseQuery;

public interface BaseMapper<T> {
	//删除
		int deleteByPrimaryKey(Serializable id);
		//添加
	    int insert(T record);
	    //查一个
	    T selectByPrimaryKey(Serializable id);
	    //查所有
	    List<T> selectAll();
	    //修改
	    int updateByPrimaryKey(T t);
	    
	    //条件查询
	    List<T> selectByQuery(BaseQuery query);
	    
}
