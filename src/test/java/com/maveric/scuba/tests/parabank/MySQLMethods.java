package com.maveric.scuba.tests.parabank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.maveric.scuba.utils.Scubautils;

public class MySQLMethods {

	private static final String URL = "jdbc:mysql://localhost:3306";
	private static final String user = "root";
	private static final String password = "sowmika18";

	private static Connection con;
	private static Statement statement;
	private static ResultSet rs;
	private static PreparedStatement pre;

	static Scubautils reFunc = new Scubautils();

	public static String getFirstName() {
		String query = "SELECT first_name FROM sakila.actor Order By RAND() LIMIT 1;";
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println();
				return "";
			}
			con = DriverManager.getConnection(URL, user, password);
			statement = con.createStatement();
			rs = statement.executeQuery(query);
			while (rs.next()) {
				System.out.print(rs.getString("first_name"));
				return rs.getString("first_name");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Exception outside");
		} finally {
			try {
				con.close();
				rs.close();
				statement.close();
			} catch (Exception e) {
				e.printStackTrace();
				return "";
			}
		}
		return "";
	}

	public static List<String> getParabankData() {
		String query = "SELECT * FROM parabank.register Order By RAND() LIMIT 1;";
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println();
				return null;
			}
			con = DriverManager.getConnection(URL, user, password);
			statement = con.createStatement();
			rs = statement.executeQuery(query);
			final ResultSetMetaData meta = rs.getMetaData();
			final int columnCount = meta.getColumnCount();
			final List<List<String>> rowList = new LinkedList<List<String>>();

//			while (rs.next()) {
			rs.next();
			final List<String> columnList = new LinkedList<String>();
			rowList.add(columnList);

			for (int column = 1; column <= columnCount; ++column) {
				final Object value = rs.getObject(column);
				columnList.add(String.valueOf(value));
			}

//			}

			return columnList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Exception outside");
		} finally {
			try {
				con.close();
				rs.close();
				statement.close();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	public static void insertParabank() throws SQLException {
		String queryName = String.format("SELECT * FROM sakila.actor where first_name = '%s';", getFirstName());
		String queryAddress = String.format("SELECT * FROM sakila.address Order By RAND() LIMIT 1;");
		String queryInsert = String.format("insert into parabank.parabank values(?,?,?,?,?,?,?,?,?,?);");
		String queryCity = "SELECT ci.city, con.country FROM sakila.country as con join sakila.city as ci on ci.country_id = con.country_id Order By RAND() LIMIT 1;";

		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println();
			}
			con = DriverManager.getConnection(URL, user, password);
			statement = con.createStatement();
			pre = con.prepareStatement(queryInsert);
			rs = statement.executeQuery(queryName);

			rs.next();
//			while (rs.next()) {
			pre.setString(1, rs.getString("first_name"));
			pre.setString(9, rs.getString("first_name") + reFunc.randomNumber(1200));
			pre.setString(2, rs.getString("last_name"));
			System.out.println(rs.getString("first_name"));
			System.out.println(rs.getString("last_name"));
//			}

			rs = statement.executeQuery(queryAddress);
			rs.next();
			pre.setString(3, rs.getString("address"));

			rs = statement.executeQuery(queryCity);
			rs.next();
			pre.setString(4, rs.getString("country"));
			pre.setString(5, rs.getString("city"));

			pre.setInt(8, reFunc.randomNumber(999999));// Zip
			pre.setString(6, String.format("%s%s", reFunc.randomNumber(99999), reFunc.randomNumber(99999)));// Phone
			pre.setString(7, reFunc.randomText(10));// SSN
			pre.setString(10, reFunc.randomText(10));// Pass
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();

//			pre.setString(11, dtf.format(now));// create

			int data = pre.executeUpdate();
			if (data == 1) {
				System.out.println("ROW Inserted Successfully!");
			} else {
				System.out.println("Error! Row cannot be Inserted");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Exception outside");
		} finally {
			con.close();
			rs.close();
			statement.close();

		}
	}

	public static void deleterow() throws SQLException {
		String query = "DELETE FROM emp1 where empid=111";

		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			con = DriverManager.getConnection(URL, user, password);
			statement = con.createStatement();
			int data = statement.executeUpdate(query);
			if (data == 1) {
				System.out.println("ROW Deleted Successfully!");
			} else {
				System.out.println("ROW Exisits!");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			con.close();
			// rs.close();
			statement.close();

		}
	}

	public static void Insertrow() throws SQLException {

		String query = "insert into emp1 values(?,?,?)";
		String query1 = "UPDATE emp1 SET salary = ? WHERE empid = ?";

		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			con = DriverManager.getConnection(URL, user, password);
			pre = con.prepareStatement(query1);
			statement = con.createStatement();

			Scanner input = new Scanner(System.in);

			System.out.print("Enter the empid:  ");
			int eid = input.nextInt();
			System.out.println();

			System.out.print("Enter the employee salary:  ");
			String esal = input.next();
			System.out.println();
//            
//            System.out.print("Enter the employee name:  ");
//            String ename = input.next();
//            System.out.println();
//            
			pre.setInt(2, eid);
//            pre.setString(2, ename);
			pre.setString(1, esal);
			int data = pre.executeUpdate();
			if (data == 1) {
				System.out.println("ROW Inserted Successfully!");
			} else {
				System.out.println("Error! Row cannot be Inserted");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			con.close();
			// rs.close();
			statement.close();

		}
	}

	public static void main(String[] args) throws SQLException {
//		getrow();
		// deleterow();
//		Insertrow();
		for (int i = 0; i < 2; i++) {
			insertParabank();
		}
//		System.out.println("reFunc.randomNumber(10) : " + reFunc.randomNumber(10));
//		System.out.println("reFunc.randomText(10) : " + reFunc.randomText(10));

	}

}
