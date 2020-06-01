package service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import mapper.BaseMapper;
import query.BaseQuery;
import service.IBaseService;
import util.PageList;

/*
 （1）在类上添加这个@Transactional注解，类中的每个方法都使用这个注解的策略进行事务管理
 如果某个方法不想使用类定义的事务管理的策略，需要重新定义测试，重新加@Transactional注解
（2）@Transactional这个注解是可以被子类继承的
 */
@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
public class BaseServiceImpl<T> implements IBaseService<T>{

	//高版本的Mybatis支持这种写法
	@Autowired
	private BaseMapper<T> mapper;
	@Override
	//@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Transactional
	public int delete(Serializable id) {
		return mapper.deleteByPrimaryKey(id);
	}
	@Override
	@Transactional
	public int add(T record) {
		return mapper.insert(record);
	}
	@Override
	public T getOne(Serializable id) {
		return mapper.selectByPrimaryKey(id);
	}
	@Override
	public List<T> getAll() {
		return mapper.selectAll();
	}
	@Override
	@Transactional
	public int update(T t) {
		return mapper.updateByPrimaryKey(t);
	}
	@Override
	public PageList<T> getByQuery(BaseQuery query) {
		//设置分页插件的分页条件
		Page page = PageHelper.startPage(query.getPage(), query.getRows());
		List<T> list = mapper.selectByQuery(query);
		//结果封装到PageList
		PageList<T> pl = new PageList<>();
		pl.setTotal(page.getTotal());
		pl.setRows(list);
		return pl;
	}

}
