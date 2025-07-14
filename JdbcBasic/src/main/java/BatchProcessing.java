import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchProcessing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:postgresql://localhost:5432/AtharvDB?user=postgres&password=atharv";
		try {
			Connection connect=CommonConnection.getConnection();
			// Step 3
			String sql = "insert into employee values(?,?,?)";
			PreparedStatement pstmt = connect.prepareStatement(sql);

			// BatchProcessing we used to insert multiple values in table only compiling one
			// time
			// addBatch() //creates buffer memory
			pstmt.setInt(1, 3);
			pstmt.setString(2, "Atharv");
			pstmt.setDouble(3, 4000);
			pstmt.addBatch();

			pstmt.setInt(1, 4);
			pstmt.setString(2, "Pranit");
			pstmt.setDouble(3, 5000);
			pstmt.addBatch();

			pstmt.setInt(1, 5);
			pstmt.setString(2, "Rahul");
			pstmt.setDouble(3, 1000);
			pstmt.addBatch();

			pstmt.executeBatch();
			connect.close();
			System.out.println("Sucess");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}