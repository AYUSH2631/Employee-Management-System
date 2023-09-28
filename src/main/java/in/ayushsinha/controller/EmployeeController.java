package in.ayushsinha.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ayushsinha.dao.DAOImplement;
import in.ayushsinha.dao.EmployeeDAO;
import in.ayushsinha.entity.Employee;

public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RequestDispatcher dispatcher=null;
	
	EmployeeDAO employeeDAO=null;
	
	public EmployeeController() {
		employeeDAO=new DAOImplement();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
String action = request.getParameter("action");
		
		if(action == null) {
			action = "LIST";
		}
		
		switch(action) {
			
			case "LIST":
				listEmployee(request, response);
				break;

			case "EDIT":
				getSingleEmployee(request,response);
				break;
				
				
			case "DELETE":
				deleteEmployee(request,response);
			
			
			default:
				listEmployee(request, response);
				break;

			
		}
		
	}

	
	private void getSingleEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		
		Employee employee = employeeDAO.get(Integer.parseInt(id));
		request.setAttribute("employee", employee);
		
		System.out.println(employee.getDob());
		 dispatcher=request.getRequestDispatcher("/views/employee-add.jsp");
		 dispatcher.forward(request, response);
		 
		 

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		String fname=request.getParameter("fname");
		String dob=request.getParameter("dob");
		String Department=request.getParameter("Department");
		Employee e=new Employee();
		
		e.setName(fname);
		e.setDob(dob);
		e.setDepartment(Department);
		
		
		if(id.isEmpty())
		{
			 boolean saved = employeeDAO.save(e);
			if(saved) {
				request.setAttribute("message","saved Succesfully");
			}
			
		}
		else {
			e.setId(Integer.parseInt(id));
			
			 boolean saved = employeeDAO.update(e);
				
				if(saved) {
					request.setAttribute("message","updated Succesfully");
				}
			
		}
		
		
		listEmployee(request,response);
		
	}
	
	private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    dispatcher=request.getRequestDispatcher("/views/employee-list.jsp");
		
		
		List<Employee> list = employeeDAO.get();
		request.setAttribute("list", list);
		System.out.println("hii");
		System.out.println("List of employees: " + list); // Add this line for debugging

		dispatcher.forward(request, response);
	}
	
     private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
	
		if(employeeDAO.delete(Integer.parseInt(id))) {
			request.setAttribute("NOTIFICATION", "Employee Deleted Successfully!");
		}
		
		listEmployee(request, response);
	}



}

