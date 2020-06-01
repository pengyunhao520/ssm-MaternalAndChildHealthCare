
package service;

import java.io.Serializable;
import java.util.List;

import query.BaseQuery;
import util.PageList;

public interface IBaseService<T> {

	//删除
	int delete(Serializable id);
	//添加
    int add(T record);
    //查一个
    T getOne(Serializable id);
    //查所有
    List<T> getAll();
    //修改
    int update(T t);
    //条件分页查询
    PageList<T> getByQuery(BaseQuery query);
	
}
