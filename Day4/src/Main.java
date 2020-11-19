import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
	public static Connection connect(){
		Connection conn = null;
		String url = "jdbc:sqlite:C:\\Users\\Samal\\Desktop\\Brungilda\\Triangle\\db.db";
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		return conn;
	}
	public static ArrayList<Student> selecStudents() {
		Connection conn = connect();
		ArrayList<Student> students = new ArrayList<Student>();
		try {
		
			Statement stmt  = conn.createStatement();
			String sql = "select id, name, surname from student";
			ResultSet res = stmt.executeQuery(sql);
			while(res.next()) {
				Student student = new Student(res.getInt(1), res.getString("name"), res.getString(3));
				students.add(student);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return students;
	}
	public static void insertStudent(String name, String surname) {
		Connection conn = connect();

		try {
		
			Statement stmt  = conn.createStatement();
			String sql = "insert into student (name, surname) values('"+name+"', '"+surname+"')";
		    stmt.executeUpdate(sql);
	
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void deleteStudent(String name) {
		Connection conn = connect();

		try {
		
			Statement stmt  = conn.createStatement();
			String sql = "DELETE FROM student WHERE name='"+name+"'";
		    stmt.executeUpdate(sql);
	
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String name = in.next(), surname = in.next();
		insertStudent(name, surname);
		ArrayList<Student> students = selecStudents();
		for(Student s: students) {
			s.run();
		}
		deleteStudent(name);
		ArrayList<Student> students2 = selecStudents();
		for(Student s: students2) {
			System.out.println(s);
		}
//		Scanner in = new Scanner(System.in);
//		try {
//			int a = in.nextInt(), b = in.nextInt();
//			System.out.println(a/b);
//		}catch(ArithmeticException e) {
//			System.out.println(e.getMessage());
//		}catch(InputMismatchException e) {
//			System.out.println("Error!1111");
//		}finally {
//			System.out.println("Uau");
//		}
//		System.out.println("Hello");
	}

}
