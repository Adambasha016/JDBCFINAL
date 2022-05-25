package org.blg.marathalli.jspiderApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchStmtDemo
{
	public static void main(String[] args)
	{
		Connection con=null;
		Statement stmt =null;
		String iQry="insert into jspider.Student2 value (9,'10ben',86.12)";
		String uQry="update jspider.Student2 set perc=66.43 where id=5";
		String dQry="delete from jspider.Student2 where perc=76.12";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=mohan");
			stmt=con.createStatement();
			stmt.addBatch(iQry);
			stmt.addBatch(uQry);
			stmt.addBatch(dQry);
			System.out.println("queries added to batch");
			int arr[]= stmt.executeBatch();
			System.out.println("queries execued from batch");
			for(int i:arr)
			{
				System.out.println(i);
			}
			
			
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(stmt!=null)
			{
				try {
					stmt.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
		
	}

}
