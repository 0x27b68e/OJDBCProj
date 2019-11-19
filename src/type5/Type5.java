package type5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Type5 {
	
	//loading jdbc driver class is optional
	//Class.forName("com.ddtek.jdbc.oracle.OracleDriver");
	private void man() throws SQLException {
		//Establish the connection
		String url = "jdbc:datadirect:orcle://localhost:1521;ServiceName=xe";
		Connection connection = DriverManager.getConnection(url, "system", "manager");
		
		//send the execute the query
		Statement st = connection.createStatement();
		ResultSet result = st.executeQuery("selection *from student");
		while(result.next()) {
			System.out.println(result.getInt(1) + " " + result.getString(2) + result.getString(3));
		}
		connection.close();
		st.close();
		result.close();
	}

}
