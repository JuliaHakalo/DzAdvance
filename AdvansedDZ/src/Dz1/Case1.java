package Dz1;
import java.sql.*;
public class Case1 implements Case {
	private final Connection connection;
	private final String CREATE_TABLE_DZ1_QUERY=
			"CREATE TABLE IF NOT EXISTS dz1(id INT PRIMARY KEY AUTO_INCREMENT,"
			+ "first_name VARCHAR(20),last_name VARCHAR(40),"
			+"idifikant_kay INT,_number INT,hobby VARCHAR(255),weight INT,height INT,"+
			"gender VARCHAR(255),date_of_born INT,proffesion VARCHAR(255))";
	public Case1(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean doWork() {
		try {
			Statement statement = connection.createStatement();
			statement.execute(CREATE_TABLE_DZ1_QUERY);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

}
