import java.sql.Connection;
import java.sql.DriverManager;

public class CommonConnection {
	public static Connection getConnection() {
		Connection connect = null;
		// Step 1 load driver class
		try {
			Class.forName("org.postgresql.Driver");
			connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AtharvDB?user=postgres&password=atharv");
		} catch (Exception e) {
			// TODO Auto-generated catch block

		}

		return connect;
	}
}
