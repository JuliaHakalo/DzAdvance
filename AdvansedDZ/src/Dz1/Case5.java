package Dz1;

import java.sql.*;
import java.util.Scanner;

public class Case5 implements Case {
	
	private PreparedStatement statement1;
	private final Connection connection;
	private final Scanner sc = new Scanner(System.in);
	private final String UPDATE_TABLE = "UPDATE dz1 set first_name=?,last_name=?,idifikant_kay=?,"
						+ "_number=?,hobby=?,weight=?,height=?,"+ 
						"gender=?,date_of_born=?,proffesion=? WHERE  id = ?";
	private final String UPDATE_TABLE1 = "UPDATE dz1 set first_name=? WHERE  id = ?";
	private final String UPDATE_TABLE2 = "UPDATE dz1 set last_name=? WHERE  id = ?";
	private final String UPDATE_TABLE3 = "UPDATE dz1 set idifikant_kay=? WHERE  id = ?";
	private final String UPDATE_TABLE4 = "UPDATE dz1 set _number=? WHERE  id = ?";
	private final String UPDATE_TABLE5 = "UPDATE dz1 set hobby=? WHERE  id = ?";
	private final String UPDATE_TABLE6 = "UPDATE dz1 set weight=? WHERE  id = ?";
	private final String UPDATE_TABLE7 = "UPDATE dz1 set height=?,WHERE  id = ?";
	private final String UPDATE_TABLE8 = "UPDATE dz1 set gender=? WHERE  id = ?";
	private final String UPDATE_TABLE9 = "UPDATE dz1 set date_of_born=? WHERE  id = ?";
	private final String UPDATE_TABLE10 = "UPDATE dz1 set  proffesion=? WHERE  id = ?";
	
	public Case5(Connection connection) {
		this.connection = connection;
	}
	@Override
	public boolean doWork() {
		try {
				System.out.println("input 1 to udate first_name");
				System.out.println("input 2 to udate last_name");
				System.out.println("input 3 to udate idifikant_kay");
				System.out.println("input 4 to udate _number");
				System.out.println("input 5 to udate hobby");
				System.out.println("input 6 to udate weight");
				System.out.println("input 7 to udate height");
				System.out.println("input 8 to udate gender");
				System.out.println("input 9 to udate date_of_born");
				System.out.println("input 10 to udate proffesion");
				System.out.println("input 11 to udate All");
			switch (sc.next()) {
			case "1":
				PreparedStatement statement1 = 
				connection.prepareStatement(UPDATE_TABLE1);
				System.out.print("first_name=");
				String	a=sc.next();
				System.out.print("id=");
				int _id=sc.nextInt();
			System.out.println();
	/////////////////////////////////////////////////////////////////////
			statement1.setString(1, a);
			statement1.setInt(2,_id);
			statement1.executeUpdate();
				break;
			case "2":
				 statement1 = 
				connection.prepareStatement(UPDATE_TABLE2);
			System.out.print("last_name=");
			String b=sc.next();
			System.out.print("id=");
			int _id1=sc.nextInt();
			System.out.println();
	/////////////////////////////////////////////////////////////////////
			statement1.setString(1, b);
			statement1.setInt(2, _id1);
			statement1.executeUpdate();
				break;
			case "3":
				 statement1 = 
				connection.prepareStatement(UPDATE_TABLE3);
			System.out.print("idifikant_kay=");
			int  c=sc.nextInt();
			System.out.print("id=");
			int _id2=sc.nextInt();
			System.out.println();
	/////////////////////////////////////////////////////////////////////
			statement1.setInt(1, c);
			statement1.setInt(2, _id2);
			statement1.executeUpdate();
				break;
			case "4":
				 statement1 = 
				connection.prepareStatement(UPDATE_TABLE4);
			System.out.print("_number=");
			int d = sc.nextInt();
			System.out.print("id=");
			int _id3=sc.nextInt();
			System.out.println();
	/////////////////////////////////////////////////////////////////////
			statement1.setInt(1, d);
			statement1.setInt(2, _id3);
			statement1.executeUpdate();
				break;
			case "5":
				 statement1 = 
				connection.prepareStatement(UPDATE_TABLE5);
			System.out.print("hobby=");
			String e=sc.next();
			System.out.print("id=");
			int _id4=sc.nextInt();
			System.out.println();
	/////////////////////////////////////////////////////////////////////
			statement1.setString(1, e);
			statement1.setInt(2, _id4);
			statement1.executeUpdate();
				break;
			case "6":
				 statement1 = 
				connection.prepareStatement(UPDATE_TABLE6);
			System.out.print("weight=");
			int f=sc.nextInt();
			System.out.print("id=");
			int _id5=sc.nextInt();
			System.out.println();
	/////////////////////////////////////////////////////////////////////
			statement1.setInt(1, f);
			statement1.setInt(2, _id5);
			statement1.executeUpdate();
				break;
			case "7":
				 statement1 = 
				connection.prepareStatement(UPDATE_TABLE7);
			System.out.print("height=");
			int g=sc.nextInt();
			System.out.print("id=");
			int _id6=sc.nextInt();
			System.out.println();
	/////////////////////////////////////////////////////////////////////
			statement1.setInt(1, g);
			statement1.setInt(2, _id6);
			statement1.executeUpdate();
				break;
			case "8":
				 statement1 = 
				connection.prepareStatement(UPDATE_TABLE8);
			System.out.print("gender=");
			String h=sc.next();
			System.out.print("id=");
			int _id7=sc.nextInt();
			System.out.println();
	/////////////////////////////////////////////////////////////////////
			statement1.setString(1, h);
			statement1.setInt(2, _id7);
			statement1.executeUpdate();
				break;
			case "9":
				 statement1 = 
				connection.prepareStatement(UPDATE_TABLE9);
			System.out.print("date_of_born=");
			int i=sc.nextInt();
			System.out.print("id=");
			int _id8=sc.nextInt();
			System.out.println();
	/////////////////////////////////////////////////////////////////////
			statement1.setInt(1,i);
			statement1.setInt(2, _id8);
			statement1.executeUpdate();
				break;
			case "10":
				 statement1 = 
				connection.prepareStatement(UPDATE_TABLE10);
			System.out.print("proffesion=");
			String  j=sc.next();
			System.out.print("id=");
			int _id9=sc.nextInt();
			System.out.println();
	/////////////////////////////////////////////////////////////////////
			statement1.setString(1, j);
			statement1.setInt(2, _id9);
			statement1.executeUpdate();
				break;
			case "11":
				 statement1 = 
				connection.prepareStatement(UPDATE_TABLE);
				System.out.print("first_name=");
				String	a1=sc.next();
			System.out.println();
	/////////////////////////////////////////////////////////////////////
			System.out.print("last_name=");
				String b1=sc.next();
			System.out.println();
	/////////////////////////////////////////////////////////////////////
			System.out.print("idifikant_kay=");
				int  c1=sc.nextInt();
			System.out.println();
	/////////////////////////////////////////////////////////////////////
			System.out.print("_number=");
			    int d1 = sc.nextInt();
			System.out.println();
	/////////////////////////////////////////////////////////////////////
			System.out.print("hobby=");
				String e1=sc.next();
			System.out.println();
	/////////////////////////////////////////////////////////////////////
			System.out.print("weight=");
				int f1=sc.nextInt();
			System.out.println();
	/////////////////////////////////////////////////////////////////////
			System.out.print("height=");
				int g1=sc.nextInt();
			System.out.println();
	/////////////////////////////////////////////////////////////////////
			System.out.print("gender=");
				String h1=sc.next();
			System.out.println();
	/////////////////////////////////////////////////////////////////////
			System.out.print("date_of_born=");
			    int i1=sc.nextInt();
			System.out.println();
	/////////////////////////////////////////////////////////////////////
			System.out.print("proffesion=");
			String  j1=sc.next();
			System.out.println();
			System.out.print("id=");
			int _id10=sc.nextInt();
	/////////////////////////////////////////////////////////////////////
			statement1.setString(1, a1);
			statement1.setString(2, b1);
			statement1.setInt(3, c1);
			statement1.setInt(4, d1);
			statement1.setString(5, e1);
			statement1.setInt(6, f1);
			statement1.setInt(7, g1);
			statement1.setString(8, h1);
			statement1.setInt(9,i1);
			statement1.setString(10, j1);
			statement1.setInt(11, _id10);
			statement1.executeUpdate();
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
