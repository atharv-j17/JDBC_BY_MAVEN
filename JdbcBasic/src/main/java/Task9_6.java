import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Task9_6 {
	static Connection connect;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:postgresql://localhost:5432/AtharvDB?user=postgres&password=atharv";
		try {
			Class.forName("org.postgresql.Driver");
			connect = DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Insert(2, "Pencile");
		Update(4, "Book");
		Delete(6);
		FindALL(1);
	}

	public static void Insert(int id, String pname) {

		try {
			String sql = "insert into product values(?,?)";
			PreparedStatement pstmt = connect.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, pname);
			pstmt.execute();
			System.out.println("DATA SUCESSFULLY INTERED");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void Update(int id, String setpname) {

		try {
			String sql = "update product set name=? where int=?";
			PreparedStatement pstmt = connect.prepareStatement(sql);
			pstmt.setInt(2, id);
			pstmt.setString(1, setpname);
			pstmt.executeUpdate();
			System.out.println("DATA SUCESSFULLY UPDATED");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void Delete(int id) {

		try {
			String sql = "DELETE FROM product WHERE int=?";
			PreparedStatement pstmt = connect.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			System.out.println("DATA SUCESSFULLY DELETED");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void FindALL(int id) {

		try {
			String sql = "SELECT * FROM product WHERE int=?";
			PreparedStatement pstmt = connect.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
