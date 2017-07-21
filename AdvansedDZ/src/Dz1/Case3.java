package Dz1;

import java.sql.*;
import java.util.Scanner;

public class Case3 implements Case {
	private final Connection connection;
	private final Scanner sc = new Scanner(System.in);
	private static final String DELETE_FROM_DZ1="DELETE FROM dz1 where "
			+ "first_name=?,last_name=?,idifikant_kay=?,_number=?,hobby=?,weight=?,height=?," 
			+ "gender=?,date_of_born=?,proffesion=?"; 
	public Case3(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean doWork() {
		try {
			System.out.println("if you want delete by id input 1 or"
					+ " if you want delete by all parameters input 2");
			switch (sc.next()) {
			case "1":
				String id =sc.next();
				PreparedStatement statement =
				connection.prepareStatement("DELETE FROM dz1 where id="+id);
				int rowsAffected = statement.executeUpdate();
	            System.out.println("Видалено об'єктів: " + rowsAffected);
				break;
    /////////////////////////////////////////////////////////////////////
			case "2":
					PreparedStatement statement1 =
					connection.prepareStatement(DELETE_FROM_DZ1);
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
				
				statement1.setString(1, a);
				statement1.setString(2, b);
				statement1.setInt(3, c);
				statement1.setInt(4, d);
				statement1.setString(5, e);
				statement1.setInt(6, f);
				statement1.setInt(7, g);
				statement1.setString(8, h);
				statement1.setInt(9,i);
				statement1.setString(10, j);
				statement1.executeUpdate();
				 int rowsAffected1 = statement1.executeUpdate();
		            System.out.println("Видалено об'єктів: " + rowsAffected1);
				statement1.close();
				break;

			default:
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return true;
	}

}
