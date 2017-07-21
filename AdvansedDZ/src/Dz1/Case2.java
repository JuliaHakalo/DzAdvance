package Dz1;

import java.sql.*;
import java.util.Scanner;

public class Case2 implements Case {
	private final Connection connection;
	private final Scanner sc = new Scanner(System.in);
	public static final String INSERT_TO_DZ1
	="INSERT INTO dz1(first_name,last_name,idifikant_kay,_number,hobby,weight,height,"
			+ "gender,date_of_born,proffesion) VALUES(?,?,?,?,?,?,?,?,?,?)";
	public Case2(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean doWork() {

		try {
			
			System.out.print("first_name=");
			String	a=sc.next();
		System.out.println();
/////////////////////////////////////////////////////////////////////
		System.out.print("last_name=");
			String b=sc.next();
		System.out.println();
/////////////////////////////////////////////////////////////////////
		System.out.print("idifikant_kay=");
			int  c=sc.nextInt();
		System.out.println();
/////////////////////////////////////////////////////////////////////
		System.out.print("_number=");
		    int d = sc.nextInt();
		System.out.println();
/////////////////////////////////////////////////////////////////////
		System.out.print("hobby=");
			String e=sc.next();
		System.out.println();
/////////////////////////////////////////////////////////////////////
		System.out.print("weight=");
			int f=sc.nextInt();
		System.out.println();
/////////////////////////////////////////////////////////////////////
		System.out.print("height=");
			int g=sc.nextInt();
		System.out.println();
/////////////////////////////////////////////////////////////////////
		System.out.print("gender=");
			String h=sc.next();
		System.out.println();
/////////////////////////////////////////////////////////////////////
		System.out.print("date_of_born=");
		    int i=sc.nextInt();
		System.out.println();
/////////////////////////////////////////////////////////////////////
		System.out.print("proffesion=");
		String  j=sc.next();
		System.out.println();
/////////////////////////////////////////////////////////////////////
			
			PreparedStatement statement =
					connection.prepareStatement(INSERT_TO_DZ1);
			
			statement.setString(1, a);
			statement.setString(2, b);
			statement.setInt(3, c);
			statement.setInt(4, d);
			statement.setString(5, e);
			statement.setInt(6, f);
			statement.setInt(7, g);
			statement.setString(8, h);
			statement.setInt(9,i);
			statement.setString(10, j);
			statement.executeUpdate();
			int rowsAffected = statement.executeUpdate();
            System.out.println("Вставлено об'єктів: " + rowsAffected);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

}
