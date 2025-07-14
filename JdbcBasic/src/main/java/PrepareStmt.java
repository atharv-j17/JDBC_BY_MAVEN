import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PrepareStmt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:postgresql://localhost:5432/AtharvDB";
		String username="postgres";
		String pass="atharv";
		try {
			Class.forName("org.postgresql.Driver");
			Connection connect=DriverManager.getConnection(url, username, pass);
			 String sql="insert into product values(?,?)";
			 PreparedStatement pstmt= connect.prepareStatement(sql);
			 pstmt.setInt(1, 7);
			 pstmt.setString(2, "bottle");
			 pstmt.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
