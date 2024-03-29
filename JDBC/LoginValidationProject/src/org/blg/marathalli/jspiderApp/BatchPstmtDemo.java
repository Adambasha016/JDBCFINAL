package org.blg.marathalli.jspiderApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class BatchPstmtDemo 
{

	public static void main(String[] args)
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		String iQry="insert into jspider.Student2 value (12,'xxx',81.92)";
		String uQry="update jspider.Student2 set perc=62.33 where id=10";
		try {

			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=mohan");
			System.out.println("connection establised");
			pstmt=(PreparedStatement) con.prepareStatement(iQry);
			System.out.println("platform created");
			pstmt.addBatch();
			int arr[]=pstmt.executeBatch();
			for(int i:arr)
			{
				System.out.println(i);
			}
			System.out.println("batch executed ones");
			pstmt1=(PreparedStatement) con.prepareStatement(uQry);
			pstmt1.addBatch();
			int arr1 []=pstmt1.executeBatch();
			for(int i:arr1)
			{
				System.out.println(i);
			}
			System.out.println("batch executed twise");
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(pstmt1!=null)
			{
				try {
					pstmt1.close();
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
			System.out.println("costly resorces are closed  by adam");
		}
	}
}





