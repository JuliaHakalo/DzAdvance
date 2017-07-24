package Dz1;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
Scanner sc = new Scanner(System.in);
	public static final String CONNECTION_URL = 
		"jdbc:mysql://localhost:3306/dz1?useSSL=false";	
		public static final String USER = "root";
		public static final String PASSWORD = "1307195422";
		//////////////////////////////////////////////////////////////////////////
				public static void main(String[] args) {
			try(Connection connection 
					= DriverManager.getConnection(CONNECTION_URL,USER,PASSWORD)){
				Map<String,Case> map = new HashMap<>();
		//////////////////////////////////////////////////////////////////////////
				Scanner sc = new Scanner(System.in);
				map.put("1",new Case1(connection));
				map.put("2",new Case2(connection));
				map.put("3",new Case3(connection));
				map.put("4",new Case4(connection));
				map.put("5",new Case5(connection));
				do {
					System.out.println("Enter 1 to create table");
					System.out.println("Enter 2 to insert in table");
					System.out.println("Enter 3 to delete from table");
					System.out.println("Enter 4 to select from table");
					System.out.println("Enter 5 to update table");

				} while (map.getOrDefault(sc.next(),()->false).doWork());
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
