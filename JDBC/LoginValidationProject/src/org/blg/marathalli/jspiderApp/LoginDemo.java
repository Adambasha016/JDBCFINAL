package org.blg.marathalli.jspiderApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class LoginDemo 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sQury="select * from jspider.Student1 where id=? and name=?";
		Scanner sc=new Scanner(System.in);
		System.out.println("enter id");
		int id=sc.nextInt();
		System.out.println("enter name");
		String name=sc.next();
		sc.close();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=mohan");
			pstmt=(PreparedStatement) con.prepareStatement(sQury);
			System.out.println("query compiled");
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			System.err.println("set a date for a palace holder before execution");
			rs=pstmt.executeQuery();
			System.out.println("query exequted");
			if(rs.next())
			{
				String umane=rs.getNString(3);
				System.out.println("the usrer name= "+umane);
			}
			else
			{
				System.out.println("invalid id/name");
			}


		}

		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			System.out.println("costrly resourses are closed");
		}	
	}


}
