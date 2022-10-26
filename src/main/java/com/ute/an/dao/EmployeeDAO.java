package com.ute.an.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;

import com.ute.an.model.Employee;





public class EmployeeDAO {
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	private String jdbcURL = "jdbc:mysql://localhost:3306/qlnv?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "0339930201An.";

	private static final String INSERT_USERS_SQL = "INSERT INTO employee" + "  (id, name, sex, bDate, homeTown, phone, address, status) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?, ?);";

	private static final String SELECT_USER_BY_ID = "select * from employee where id =?";
	private static final String SELECT_ALL_USERS = "select * from employee";
	private static final String DELETE_USERS_SQL = "delete from employee where id = ?;";
	private static final String UPDATE_USERS_SQL = "update employee set name= ?, sex =?, bDate= ?, homeTown= ?, phone= ?, address= ?, status= ? where id = ?;";

	public EmployeeDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			System.out.println("Connected to Database.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed.");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public boolean updateEmployee(Employee employee) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			Date date = null;
			try {
				System.out.print(employee.getbDate());
				date = formatter.parse(employee.getbDate());
			} catch (ParseException e) {
				//System.out.println("ERROROORO\n");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			preparedStatement.setString(8, employee.getId());
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setBoolean(2, employee.getSex().equals("1") ? true : false);
			preparedStatement.setDate(3, new java.sql.Date(date.getTime()));
			preparedStatement.setString(4, employee.getHomeTown());
			preparedStatement.setString(5, employee.getPhone());
			preparedStatement.setString(6, employee.getAddress());
			preparedStatement.setString(7, employee.getStatus());

			rowUpdated = preparedStatement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	public boolean deleteEmployee(String id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setString(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	public void insertEmployee(Employee employee) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			Date date = null;
			try {
				date = formatter.parse(employee.getbDate());
			} catch (ParseException e) {
				//System.out.println("ERROROORO\n");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("Set param\n");
			preparedStatement.setString(1, employee.getId());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setBoolean(3, employee.getSex().equals("1") ? true : false);
			preparedStatement.setDate(4, new java.sql.Date(date.getTime()));
			preparedStatement.setString(5, employee.getHomeTown());
			preparedStatement.setString(6, employee.getPhone());
			preparedStatement.setString(7, employee.getAddress());
			preparedStatement.setString(8, employee.getStatus());
			//System.out.println("SQL" + preparedStatement);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	public Employee selectEmployee(String id) {
		Employee employee = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setString(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				String bDate = formatter.format(new Date(rs.getDate("bDate").getTime()));
				String homeTown = rs.getString("homeTown");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String status = rs.getString("status");
				employee = new Employee(id, name, sex, bDate, homeTown, phone, address, status);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return employee;
	}
	public ArrayList<Employee> selectAllEmployees() {
		// using try-with-resources to avoid closing resources (boiler plate code)
		ArrayList<Employee> users = new ArrayList<Employee>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String sex = rs.getString("sex").equalsIgnoreCase("1") ? "Male" : "Female";
				String bDate = formatter.format(new Date(rs.getDate("bDate").getTime()));
				String homeTown = rs.getString("homeTown");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String status = getStringStatus(rs.getString("status"));
				Employee employee = new Employee(id, name, sex, bDate, homeTown, phone, address, status);
				users.add(employee);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
	private String getStringStatus(String status) {
		if(status.equalsIgnoreCase("1"))
			return "Active";
		else if(status.equalsIgnoreCase("2"))
			return "Temporarily locked";
		else 
			return "Locked forever";
			
	}
}
