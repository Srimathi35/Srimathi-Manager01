package com.jdbc.demo;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	public class Manager01 {
		
		static Connection connection=null;
		static Statement statement =null;
		static ResultSet rs =null;
		static {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}

		public static void main(String[] args) throws SQLException {
			// TODO Auto-generated method stub
			String query=null;
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Products","root","");
				statement= connection.createStatement();			
				//String query="CREATE TABLE product1(id int, name varchar(99),address varchar(100),price int,quntity int)";
				//step 5		
				//String query="insert into product1 values(01,'Tiger','Chennai',20,1)";	
				//System.out.println(query);
				//statement.executeUpdate(query);			
				query="select * from product1";
				rs = statement.executeQuery(query);
				while(rs.next())
				{
					
					System.out.println(rs.getInt(1) +", "+rs.getString(2)+", "+rs.getString(3)+", "+rs.getInt(4)+", "+rs.getInt(5));
				}
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				rs.close();
				statement.close();
				connection.close();
			}	
			//step 4		
			System.out.println("Done");
		}

	}
