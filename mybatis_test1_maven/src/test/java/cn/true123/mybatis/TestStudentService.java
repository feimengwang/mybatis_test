package cn.true123.mybatis;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.true123.mybatis.domain.Student;
import cn.true123.mybatis.service.StudentService;

public class TestStudentService {

	private static StudentService studentService;

	@BeforeClass
	public static void setup() {
		studentService = new StudentService();
	}

	@AfterClass
	public static void teardown() {
		studentService = null;
	}

	@Test
	public void testInsertStudent() {

		Student student = new Student(10023, "testUnit", "xxx@email.com", new Date());
		studentService.insertStudent(student);
		Student student2 = studentService.findStudentById(10023);
		Assert.assertNotNull(student2);
		Assert.assertArrayEquals("the name is the same", new Object[] { "testUnit" }, new Object[] { "testUnit" });
	}
}
