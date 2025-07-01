package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;

import datalayer.DataBase;
import model.User;

public class UserDAO extends ActionSupport {
	private static final String URL = "jdbc:mysql://localhost:3306/ chatApplication";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Admin";
	
	static DataBase database=null;

	

	public static DataBase getInstance()
	{
		if(database==null)
			database=new DataBase();
		return database;
	}

	public List<User> getUser(String searchQuery) throws SQLException {
		List<User> userList = new ArrayList<>();
		System.out.println("user dao list"+"///"+searchQuery);
		userList = new ArrayList<>();
		String query = "SELECT * FROM  USER";
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement statement = conn.prepareStatement(query);
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				if (!(DataBase.getUser().getUsername().equals(resultSet.getString("username")))&&(resultSet.getString("username").startsWith(searchQuery))) {
					User user = new User();
					user.setName(resultSet.getString("name"));
					user.setMobileNo(resultSet.getString("mobileNo"));
					user.setId(resultSet.getInt("id"));
					user.setImage(resultSet.getNString("profileimage"));
					 String status = UserDAO.getInstance().isFriends(UserDAO.getInstance().getUser().getId(), user.getId());
					 user.setFriendStatus(status);
					userList.add(user);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(userList.size()+"///++++++");
		return userList;
	}

	
	public Connection connection() throws SQLException {
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}

}
