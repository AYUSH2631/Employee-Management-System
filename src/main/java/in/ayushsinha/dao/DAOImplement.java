package in.ayushsinha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.ayushsinha.entity.Employee;
import in.ayushsinha.util.DBConnectionUtil;

public class DAOImplement implements EmployeeDAO {

    Connection connection = null;
    ResultSet resultSet = null;
    Statement statement = null;
    PreparedStatement preparedStatement=null;

    @Override
    public List<Employee> get() {

        List<Employee> list = null;

        System.out.println("Ayush");

        try {
            list = new ArrayList<Employee>();
            
            // Assign the database connection to the 'connection' variable
            connection = DBConnectionUtil.openConnection();

            String sql = "SELECT * FROM tbl_employee";
            statement = connection.createStatement();

            resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setDob(resultSet.getString("dob"));
                employee.setDepartment(resultSet.getString("department"));
                
                list.add(employee);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
	public boolean save(Employee e) {
		boolean flag = false;
		try {
			String sql = "INSERT INTO tbl_employee(name, department, dob)VALUES"
					+ "('"+e.getName()+"', '"+e.getDepartment()+"', '"+e.getDob()+"')";
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	@Override
	public Employee get(int id) {
		
		Employee employee=null;
		
		try {
			employee=new Employee();
			String sql="select * from tbl_employee WHERE id="+id;
			connection=DBConnectionUtil.openConnection();
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sql);
			
			while(resultSet.next())
			{
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setDob(resultSet.getString("dob"));
				employee.setDepartment(resultSet.getString("department"));
			}
			
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		
		System.out.println(employee.getId());
		
		return employee;
		
	}

	@Override
	public boolean update(Employee e) {
		
		boolean flag=false;
		
		try {
			
			String sql = "UPDATE tbl_employee SET name = '"+e.getName()+"', "+ "department = '"+e.getDepartment()+"', dob = '"+e.getDob()+"' where id="+e.getId();
			connection=DBConnectionUtil.openConnection();
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag=true;
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		
		return flag;
		
		
		
	}
	
	@Override
	public boolean delete(int id) {
		boolean flag = false;
		try {
			String sql = "DELETE FROM tbl_employee where id="+id;
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}



		
		
	
}
