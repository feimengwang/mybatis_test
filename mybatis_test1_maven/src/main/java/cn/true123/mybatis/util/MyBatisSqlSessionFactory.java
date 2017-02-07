package cn.true123.mybatis.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisSqlSessionFactory {
	private static SqlSessionFactory sqlSessionFactory = null;

	private static MyBatisSqlSessionFactory myBatisSqlSessionFactory = new MyBatisSqlSessionFactory();

	public static void main(String[] args) {
		System.out.println(getInstance().getSessionFactory());
	}

	private MyBatisSqlSessionFactory() {
		if (sqlSessionFactory == null) {
			try {
				InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
				
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static MyBatisSqlSessionFactory getInstance() {
		return myBatisSqlSessionFactory;
	}

	public SqlSessionFactory getSessionFactory() {
		return sqlSessionFactory;
	}
}
