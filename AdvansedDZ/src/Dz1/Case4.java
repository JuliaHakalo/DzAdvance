package Dz1;

import java.sql.*;
import java.util.Scanner;

public class Case4 implements Case{
	private final Connection connection;
	private final Scanner sc = new Scanner(System.in);
	public  final String SELECT_DZ1_BY_ALL = 
			"SELECT id,first_name,last_name,idifikant_kay,_number,hobby,weight,height," + 
			"gender,date_of_born,proffesion FROM dz1";
	public  final String SELECT_DZ1_BY_ID = 
			"SELECT first_name FROM dz1";
	public Case4(Connection connection) {
		this.connection = connection;
	}
	@Override
	public boolean doWork() {
		try {System.out.println("if you want select All input 1"
				+ " if you want select first_name input2");
			switch (sc.next()) {
			case "1":
				PreparedStatement statement = 
				connection.prepareStatement(SELECT_DZ1_BY_ALL);
				ResultSet rs = statement.executeQuery();
				while(rs.next()){
					System.out.println("id="+rs.getInt("id")+
						" "+"first_name="+rs.getString("first_name")+
						" "+"last_name="+rs.getString("last_name")+
						" "+"idifikant_kay="+rs.getInt("idifikant_kay")+
						" "+"_number="+rs.getInt("_number")+
						" "+"hobby="+rs.getString("hobby")+
						" "+"weight="+rs.getInt("weight")+
						" "+"first_name="+rs.getInt("height")+
						" "+"gender="+rs.getString("gender")+
						" "+"date_of_born="+rs.getInt("date_of_born")+
						" "+"proffesion="+rs.getString("proffesion"));
				}
				rs.close();
				statement.close();
				break;
			case "2":
				PreparedStatement statement1 = 
				connection.prepareStatement(SELECT_DZ1_BY_ID);
				ResultSet rs1 = statement1.executeQuery();
				while(rs1.next()){
					System.out.println(rs1.getString("first_name"));
				}
				rs1.close();
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
