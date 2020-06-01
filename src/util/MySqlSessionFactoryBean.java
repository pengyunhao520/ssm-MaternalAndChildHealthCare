package util;

import java.io.IOException;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;

public class MySqlSessionFactoryBean extends SqlSessionFactoryBean{

	@Override
	protected SqlSessionFactory buildSqlSessionFactory() throws IOException {
		try {
			return super.buildSqlSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
