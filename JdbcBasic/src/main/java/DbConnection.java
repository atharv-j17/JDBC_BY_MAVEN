import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url="jdbc:postgresql://localhost:5432/AtharvDB";
		String username="postgres";
		String pass="atharv";
		try {
			Class.forName("org.postgresql.Driver");
			Connection connect=DriverManager.getConnection(url, username, pass);
			 Statement stmt= connect.createStatement();
			 String sql="select * from product";
//				String sql1="insert into product values(4,'Book');";
				ResultSet rs=stmt.executeQuery(sql);
//				stmt.executeUpdate(sql1);
//				printing the reference of our table
				System.out.println(rs);
//				fetching data from the database
				while(rs.next()) {
					System.out.println(rs.getInt(1) +" "+ rs.getString(2));
				}
				//close the connection
				connect.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

//statement interface only works with static query
//for dynamic query preparedstatement
