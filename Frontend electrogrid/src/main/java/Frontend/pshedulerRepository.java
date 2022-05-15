package Frontend;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class pshedulerRepository {
Connection con = null;
	
	public pshedulerRepository() {
		String url = "jdbc:mysql://localhost:3308/electrogrid";
		String username = "root";
		String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	public List<psheduler> getPshedulers(){
		List<psheduler> pshedulers = new ArrayList<>();
		String sql = "select * from pshedule";
		String output = "";
		
		try {
			Connection con = connect();
			if (con == null)
			{
				return "Error while connecting to the database for reading.";
			}
 
			// Prepare the html table to be displayed
			 output = "<table border='1'><tr><th>Powercut Schedule Code</th>" 
			 + "<th>Duration</th>"
			 + "<th>Location</th>"
			 + "<th>Reason</th>" 
			 + "<th>Description</th>" 
			 + "<th>Update</th><th>Remove</th></tr>";
			 
			 String query = "select * from pshedules"; 
			 Statement st = con.createStatement();
			ResultSet rs1 = st.executeQuery(sql);
			
			// iterate through the rows in the result set
			while(rs1.next()) {
				psheduler p = new psheduler();
				p.setpLid(rs1.getInt(1));
				p.setpLocation(rs1.getString(2));
				p.setpDuration(rs1.getString(3));
				p.setpReason(rs1.getString(4));
				p.setpDescription(rs1.getString(5));
				
				pshedulers.add(p);
				
				// Add into the html table
				output += "<tr><td>"+1+"</td>"; 
				output += "<td>"+2+"</td>"; 
				output += "<td>"+3+"</td>"; 
				output += "<td>"+4+"</td>"; 
				output += "<td>"+5+"</td>"; 
				 
				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' "
				 + "class='btnUpdate btn btn-secondary' data-itemid='" +1+ "'></td>"
				 + "<td><input name='btnRemove' type='button' value='Remove' "
				 + "class='btnRemove btn btn-danger' data-itemid='" +1+ "'></td></tr>"; 
			}
			con.close(); 
			 // Complete the html table
			output += "</table>"; 
			 
		} catch (Exception e) {
			output = "Error while reading the Schedule"; 
			 System.err.println(e.getMessage()); 
		}
		
		return output;
		
	}
	
	public psheduler createpsheduler(int id) {
		List<psheduler> pshedulers = new ArrayList<>();
		String sql = "select * from pshedule where id="+id;
		psheduler p = new psheduler();
		try {
			
			{
				Connection con = connect();
				
				if (con == null)
				{
					return "Error while connecting to the database for inserting.";
				}
				// create a prepared statement
				String query = " insert into psheduler(`pLid`,`pduration`,`plocation`,`preason`,`pdesc`)"+ " values (?, ?, ?, ?, ?)";
			 
				PreparedStatement preparedStmt = con.prepareStatement(query);
				
				
			 
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				//binding values
				p.setpLid(rs.getInt(1));
				p.setpLocation(rs.getString(2));
				p.setpDuration(rs.getString(3));
				p.setpReason(rs.getString(4));
				p.setpDescription(rs.getString(5));
				

				// execute the statement
				preparedStmt.execute();
				con.close();
				String newItems = getPshedulers();
				output = "{\"status\":\"success\", \"data\": \"" +newItems + "\"}";
				
				
				pshedulers.add(p);
			}
		} catch (Exception e) {
			 output = "{\"status\":\"error\", \"data\":\"Error while inserting the item.\"}";
			 System.err.println(e.getMessage());
		}
		
		return output;
	
	}
	public void updatepsheduler(psheduler p1) {
		String sql = "insert into pshedule values(?,?,?,?,?)";
		
		String output = "";
		try {
			
			 Connection con = connect();
			 if (con == null)
			 {
				 return "Error while connecting to the database for updating.";
			 }
			 
			 // create a prepared statement
			 String query = "UPDATE pschedule SET pLid=?,pLocation=?,pDuration=?,pReason=?, pDescription=? WHERE pLid=?";
		}
			PreparedStatement st = con.prepareStatement(sql);
			
			// binding values
			
			st.setInt(1, p1.getpLid());
			st.setString(2,p1.getpLocation());
			st.setString(3, p1.getpDuration());
			st.setString(4, p1.getpReason());
			st.setString(5, p1.getpDescription());
			
			st.executeUpdate();
			con.close();
			
			 String newPshedulers = getPshedulers();
			 output = "{\"status\":\"success\", \"data\": \"" +
			newPshedulers + "\"}";
			
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while updating the PSchedule.\"}";
			 System.err.println(e.getMessage());
		}
		return output;
	}
	
	public void update(psheduler p1) {
		
		String output = "";
		String sql = "update pshedule set location=?,duration=?,reason=?,description=? where id=?";
		try {
			
			 Connection con = connect();
			 if (con == null)
			 {
				 return "Error while connecting to the database for deleting.";
			 }
			 
			// create a prepared statement
			 String query = "delete from items where pLid=?";
			PreparedStatement st = con.prepareStatement(sql);
			

			 // binding values
			 preparedStmt.setInt(1, Integer.parseInt(pLid));
			 
			 // execute the statement
			 preparedStmt.execute();
			 con.close();
			 String newPshedulers = getPshedulers();
			 output = "{\"status\":\"success\", \"data\": \"" +
			newPshedulers + "\"}";
			
		
			
		} catch (Exception e) {
			 output = "{\"status\":\"error\", \"data\": \"Error while deleting the item.\"}";
			 System.err.println(e.getMessage());
		}
		return output;
	}
	
	
}
