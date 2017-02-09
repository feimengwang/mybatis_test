package cn.true123.mybatis.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.true123.mybatis.domain.Student;
import cn.true123.mybatis.mapper.StudentMapper2;
import cn.true123.mybatis.util.MyBatisSqlSessionFactory;

public class StudentService2 {
	public static void main(String[] args) {
		StudentService2 studentService = new StudentService2();//.insertStudent(new Student(10099, "dd", "dd@email.com", new Date()));
		System.out.println(studentService.selectStudentWithAddress(10023));
	}

	
	public Student selectStudentWithAddress(int id) {
		SqlSessionFactory sessionFactory = MyBatisSqlSessionFactory.getInstance().getSessionFactory();
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			// return
			// session.selectOne("cn.true123.mybatis.mapper.StudentMapper.findStudentById",id);
			StudentMapper2 studentMapper = session.getMapper(StudentMapper2.class);
			return studentMapper.selectStudentWithAddress(id);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
