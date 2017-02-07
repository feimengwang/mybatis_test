package cn.true123.mybatis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.true123.mybatis.domain.Student;

public class JDBCStudentService {
	public static void main(String[] args) {
		JDBCStudentService service = new JDBCStudentService();
		Student student1 = new Student(1005, "wang wu1", "wangwu1@mail.com", new Date());
		Student student2 = new Student(1006, "wang wu2", "wangwu2@mail.com", new Date());
		Student student3 = new Student(1007, "wang wu3", "wangwu3@mail.com", new Date());
		List<Student> sqlList = new ArrayList<>();
		sqlList.add(student1);
		sqlList.add(student2);
		sqlList.add(student3);
		service.createStudents(sqlList);

	}

	public void createStudent(Student student) {
		Connection connection = getCon();
		try {
			Statement statement = connection.createStatement();
			String insertSql = "INSERT INTO mybatis.student (studId,name,email,dob) VALUES({0},''{1}'',''{2}'',''{3}'')";
			System.out.println(formatSql(insertSql, student));
			statement.execute(formatSql(insertSql, student));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public Connection getCon() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis", "root", "root");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void createStudents(List<Student> students) {
		Connection connection = getCon();
		try {
			Statement statement = connection.createStatement();
			for (Student student : students) {
				String insertSql = "INSERT INTO mybatis.student (studId,name,email,dob) VALUES({0},''{1}'',''{2}'',''{3}'')";
				System.out.println(formatSql(insertSql, student));
				statement.addBatch(formatSql(insertSql, student));
			}
			statement.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private String formatSql(String sql, Student student) {
		return MessageFormat.format(sql, new Object[] { String.valueOf(student.getStudId()), student.getName(),
				student.getEmail(), formatDate(student.getDob()) });
	}

	private String formatDate(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.format(date);
	}
}
