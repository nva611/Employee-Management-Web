package com.ute.an.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ute.an.dao.EmployeeDAO;
import com.ute.an.model.Employee;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/")
public class EmployeeServlet extends HttpServlet {
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	private static final long serialVersionUID = 1L;
    private EmployeeDAO employeeDAO;
	
	public void init() {
		employeeDAO = new EmployeeDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertEmployee(request, response);
				break;
			case "/search":
				searchEmployee(request, response);
				break;
			case "/delete":
				deleteEmployee(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateEmployee(request, response);
				break;
			default:
				listEmployee(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	private void updateEmployee(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		//String bDate = request.getParameter("date") + "-" + request.getParameter("month") + "-" + request.getParameter("year");
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("bDate"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String bDate = formatter.format(date);
		String homeTown = request.getParameter("homeTown");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String status = request.getParameter("status");

		Employee book = new Employee(id, name, sex, bDate, homeTown, phone, address, status);
		System.out.print("BOOOK" + book.getbDate());
		employeeDAO.updateEmployee(book);
		response.sendRedirect("list");
	}
	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String id = request.getParameter("id");
		employeeDAO.deleteEmployee(id);
		response.sendRedirect("list");

	}
	private void searchEmployee(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String id = request.getParameter("id");
		Employee employee = employeeDAO.selectEmployee(id);
		
		ArrayList<Employee> listEmployee = new ArrayList<Employee>();
		if(employee!=null)
			listEmployee.add(employee);
		
		request.setAttribute("listEmployee", listEmployee);
		request.setAttribute("found", listEmployee.size());
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-list.jsp");
		try {
			
			dispatcher.forward(request, response);
			
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void insertEmployee(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("bDate"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("DATE: " + date);
		//String bDate = request.getParameter("date") + "-" + request.getParameter("month") + "-" + request.getParameter("year");
		String bDate = formatter.format(date);
//		System.out.println("DATE req" + request.getParameter("bDate"));
//		System.out.println("DATE 1" + date);
//		System.out.println("DATE 2" + bDate);
		String homeTown = request.getParameter("homeTown");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String status = request.getParameter("status");
		Employee newUser = new Employee(id, name, sex, bDate, homeTown, phone, address, status);
		
		employeeDAO.insertEmployee(newUser);
		response.sendRedirect("list");
	}
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
		dispatcher.forward(request, response);
	}
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String id = request.getParameter("id");
		Employee employee = employeeDAO.selectEmployee(id);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
		java.util.Date date = null;
		try {
			date = formatter.parse(employee.getbDate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("date", date);
		request.setAttribute("employee", employee);
		dispatcher.forward(request, response);

	}
	private void listEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		ArrayList<Employee> listEmployee = employeeDAO.selectAllEmployees();
		request.setAttribute("listEmployee", listEmployee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-list.jsp");
		dispatcher.forward(request, response);
	}

}
