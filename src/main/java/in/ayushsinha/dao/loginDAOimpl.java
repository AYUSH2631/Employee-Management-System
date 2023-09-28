package in.ayushsinha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.ayushsinha.entity.login;
import in.ayushsinha.util.DBConnectionUtil;

public class loginDAOimpl implements loginDAO {

	@Override
	public String authenticate(login login) {
		
		String sql="select * from tbl_login where email=? and password=?";
		
		try {
			
			Connection connection=DBConnectionUtil.openConnection();
			PreparedStatement p=connection.prepareStatement(sql);
			p.setString(1,login.getEmail());
			p.setString(2,login.getPassword());
			ResultSet rs=p.executeQuery();
			
			if(rs.next()) {
				return "true";
			}
			else
				return "false";
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return "error";
	}

}
