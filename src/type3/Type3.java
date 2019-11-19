package type3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Type3 {
	public static void main(String[] args) throws Exception {
		// register type 3 jdbc driver
		Class.forName("ids.sql.IDSDriver");

		// Establish the connection
		// My Java app connect to IDSServer(proxy server) and IDSServer will connect to DB(is this
		// case 'Access DATABASE')
		Connection connection = DriverManager.getConnection("jdbc:ids://localhost:12/conn?dsn='accdsn'");

		// create Jdbc statement obj
		Statement statement = connection.createStatement();

		// execute the SQL query
		ResultSet resultSet = statement.executeQuery("select *from student");

		// process the resultSet object
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
		}
		
		connection.close();
		statement.close();
		resultSet.close();

	}

}
