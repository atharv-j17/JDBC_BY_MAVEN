import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class storeProcedureinsert {
	// by preparedstatement
	/*
	 * public static void main(String[] args) { // TODO Auto-generated method stub
	 * String url =
	 * "jdbc:postgresql://localhost:5432/AtharvDB?user=postgres&password=atharv";
	 * try { Class.forName("org.postgresql.Driver"); Connection connect =
	 * DriverManager.getConnection(url); String
	 * sql="call student_procedure(?,?,?,?,?);"; PreparedStatement pstmt=
	 * connect.prepareStatement(sql); pstmt.setString(1,"2");
	 * pstmt.setString(2,"Niraj"); pstmt.setString(3,"B+ve");
	 * pstmt.setString(4,"MAle"); pstmt.setString(5,"21234567");
	 * pstmt.executeUpdate(); } catch (ClassNotFoundException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } catch (SQLException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); } }
	 */

	// by callable statement
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/AtharvDB?user=postgres&password=atharv";
		try {
			Class.forName("org.postgresql.Driver");
			Connection connect = DriverManager.getConnection(url);
			String sql = "call student_procedure(?,?,?,?,?);";
			CallableStatement pstc = connect.prepareCall(sql);
			pstc.setString(1, "3");
			pstc.setString(2, "Tushar");
			pstc.setString(3, "B+ve");
			pstc.setString(4, "MAle");
			pstc.setString(5, "21234567");
			pstc.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
