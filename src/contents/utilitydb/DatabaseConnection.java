package egen.utilitydb;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
//import com.mysql.jdbc.Connection;

public class DatabaseConnection {
	
	private final static String URL="jdbc:mysql://localhost:3306/restaurant";
	private final static String USER="root";
	private final static String PASSWORD="";
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection connectToDB(){
		Connection con=null;
		try {
			con=DriverManager.getConnection(URL,USER, PASSWORD);
			System.out.println("Connection Successful");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("No Connection"+e.getMessage());
		}
		return con;
	}
	public static void closeResources(PreparedStatement ps, ResultSet rs,Connection con){
		try {
			if(ps!=null){
				ps.close();
			}
			if(rs!=null){
				rs.close();
			}
			if(con!=null){
		        con.close();
			}
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public static void main(String args[]){
		DatabaseConnection.connectToDB();
	}
}
