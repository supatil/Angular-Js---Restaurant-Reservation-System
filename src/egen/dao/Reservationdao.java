package egen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
//import java.sql.*;


import egen.exception.AppException;
import egen.model.Authentication;

//import com.mysql.jdbc.Connection;


import egen.model.Reservation;
import egen.utilitydb.DatabaseConnection;

public class Reservationdao {
	public List<Reservation> getAll() throws AppException{
		
	     List<Reservation> reserve = new ArrayList<Reservation>();
	     Connection con= DatabaseConnection.connectToDB();
	     ResultSet rs = null;
	     PreparedStatement ps =null;
		try {
			ps = con.prepareStatement("SELECT * FROM reservation");
		  
	     rs = ps.executeQuery();
	     System.out.println(rs);
	     while(rs.next()){
	    	 Reservation res=new Reservation();
	    	 res.setId(rs.getInt("ID"));
	    	 res.setFirstName(rs.getString("First_Name"));
	    	 res.setLastName(rs.getString("Last_Name"));
	    	 res.setEmail(rs.getString("Email"));
	    	 res.setPhoneNumber(rs.getDouble("Phone_Number"));
	    	 res.setTotal(rs.getInt("Total_People"));
	    	 res.setDate(rs.getDate("Date_Time"));
	    	 reserve.add(res);
	     }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("Error in fetching record from database",e.getCause());
		}
		finally{
			DatabaseConnection.closeResources(ps, rs, con);
		}
	     return reserve;
	}

	public Reservation addPerson(Reservation res) throws AppException{
		
		 Connection con= DatabaseConnection.connectToDB();
	     ResultSet rs = null;
	     PreparedStatement ps =null;
	     
		try {
			ps = con.prepareStatement("INSERT INTO reservation(First_Name,Last_Name,Email,Phone_Number,Total_People,Date_Time) VALUES(?,?,?,?,?,?)");
			ps.setString(1, res.getFirstName());
			ps.setString(2, res.getLastName());
			ps.setString(3, res.getEmail());
			ps.setDouble(4, res.getPhoneNumber());
			ps.setInt(5, res.getTotal());
		    ps.setDate(6, res.getDate());
		    ps.executeUpdate();
	     
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("Error in adding record to database",e.getCause());
		}
		finally{
			DatabaseConnection.closeResources(ps, rs, con);
		}
	     return res;
	}
	public void deletePerson(int custId) throws AppException{
		
		 Connection con= DatabaseConnection.connectToDB();
	     ResultSet rs = null;
	     PreparedStatement ps =null;
		try {
			System.out.println("in delete");
			ps = con.prepareStatement("DELETE FROM reservation WHERE ID=?");
			ps.setInt(1, custId);
	        ps.executeUpdate();
	    	}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("Error in fetching record from database",e.getCause());
		}
		finally{
			DatabaseConnection.closeResources(ps, rs, con);
		}
	    
	}
	public boolean authenticate(Authentication auth){
		return true;
	}
}
