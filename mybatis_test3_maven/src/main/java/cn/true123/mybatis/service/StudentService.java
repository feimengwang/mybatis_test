package cn.true123.mybatis.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.true123.mybatis.domain.Student;
import cn.true123.mybatis.mapper.StudentMapper;
import cn.true123.mybatis.util.MyBatisSqlSessionFactory;

public class StudentService {
	public static void main(String[] args) {
		StudentService studentService = new StudentService();//.insertStudent(new Student(10099, "dd", "dd@email.com", new Date()));
		System.out.println(studentService.selectStudentWithAddress(10023));
	}

	public List<Student> findAllStudents() {
		SqlSessionFactory sessionFactory = MyBatisSqlSessionFactory.getInstance().getSessionFactory();
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			StudentMapper studentMapper = session.getMapper(StudentMapper.class);
			return studentMapper.findAllStudents();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Student findStudentById(Integer id) {
		SqlSessionFactory sessionFactory = MyBatisSqlSessionFactory.getInstance().getSessionFactory();
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			// return
			// session.selectOne("cn.true123.mybatis.mapper.StudentMapper.findStudentById",id);
			StudentMapper studentMapper = session.getMapper(StudentMapper.class);
			return studentMapper.findStudentById(id);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void insertStudent(Student student) {
		SqlSessionFactory sessionFactory = MyBatisSqlSessionFactory.getInstance().getSessionFactory();
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			StudentMapper studentMapper = session.getMapper(StudentMapper.class);
			studentMapper.insertStudent(student);
			session.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateStudent(Student student) {
		SqlSessionFactory sessionFactory = MyBatisSqlSessionFactory.getInstance().getSessionFactory();
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			StudentMapper studentMapper = session.getMapper(StudentMapper.class);
			studentMapper.updateStudent(student);
			session.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public Student selectStudentWithAddress(int id) {
		SqlSessionFactory sessionFactory = MyBatisSqlSessionFactory.getInstance().getSessionFactory();
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			// return
			// session.selectOne("cn.true123.mybatis.mapper.StudentMapper.findStudentById",id);
			StudentMapper studentMapper = session.getMapper(StudentMapper.class);
			return studentMapper.selectStudentWithAddress(id);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
