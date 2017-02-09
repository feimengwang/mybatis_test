package cn.true123.mybatis.mapper;

import java.util.List;

import cn.true123.mybatis.domain.Student;

public interface StudentMapper2 {
	public List<Student> findAllStudents();

	public Student findStudentById(Integer id);

	public void insertStudent(Student student);

	public void updateStudent(Student student);
	public Student selectStudentWithAddress(int id);
}
