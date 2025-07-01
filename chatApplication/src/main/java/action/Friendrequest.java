package action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import datalayer.DataBase;
import model.User;

public class Friendrequest extends ActionSupport {
	private static final String URL = "jdbc:mysql://localhost:3306/ chatApplication";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Admin";
	private int senderId;
	private int receiverId;
	
 
  private static  ArrayList<User> acceptFriends=new ArrayList<>();
	
  
	public static ArrayList<User> getAcceptFriends() {
	return acceptFriends;
}
public static void setAcceptFriends(ArrayList<User> acceptFriends) {
	Friendrequest.acceptFriends = acceptFriends;
}
	
	public int getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	public int getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}
	public String execute() throws SQLException
	{
		System.out.println("hello");
		String query="INSERT INTO friend_requests(senderId,receiverId, status) VALUES(?,?,?)";
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1,getSenderId());
            stmt.setInt(2, getReceiverId()); 
            stmt.setString(3, "PENDING"); 
            int rowsAffected = stmt.executeUpdate();
	            }
		return SUCCESS;
	}
	
	
	public String acceptRequests()
	{
		//System.out.println("==================");
		//System.out.println(getSenderId()+"********");
		//System.out.println(getReceiverId()+"...//....");
		String query="Update friend_requests set status='accepted' where senderId=? && receiverId=?";
		try {
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1,  getReceiverId());
			statement.setInt(2,  getSenderId());
			int rowsAffected = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public static ArrayList<User> getFriends(int currentUserId)
	{
		System.out.println(currentUserId+".....");
		acceptFriends=new ArrayList<>();
		String query = "SELECT fr.id AS friend_request_id, " +
	               "u1.id AS sender_id, " +
	               "u1.name AS sender_name, " +
	               "u1.profileimage AS  profileimage," +
	               "u2.id AS receiver_id, " +
	               "u2.name AS receiver_name " +
	               "FROM friend_requests fr " +
	               "JOIN user u1 ON fr.senderId = u1.id " +
	               "JOIN user u2 ON fr.receiverId = u2.id " +
	               "WHERE fr.receiverId = ? AND fr.status = 'accepted'";

		  try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		       PreparedStatement statement = conn.prepareStatement(query)) {
		      statement.setInt(1, currentUserId);
		      
		      try (ResultSet resultSet = statement.executeQuery()) {
		          while (resultSet.next()) {
		              User user = new User();
		              user.setId(resultSet.getInt("sender_id"));
		              user.setName(resultSet.getString("sender_name"));
		              user.setImage(resultSet.getString("profileimage"));
		              acceptFriends.add(user);
		          }
		      }
		  } catch (SQLException e) {
		      e.printStackTrace();
		     
		  }
		   query = "SELECT fr.id AS friend_request_id, " +
                
                  "u2.id AS receiver_id, " +
                  "u2.name AS receiver_name, " +
                  "u2.profileimage AS profileimage " +
                  "FROM friend_requests fr " +
                  "JOIN user u1 ON fr.senderId = u1.id " +
                  "JOIN user u2 ON fr.receiverId = u2.id " +
                  "WHERE fr.senderId = ? AND fr.status = 'accepted'";

		  try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		       PreparedStatement statement = conn.prepareStatement(query)) {
		      statement.setInt(1, currentUserId);
		      try (ResultSet resultSet = statement.executeQuery()) {
		          while (resultSet.next()) {
		              User user = new User();
		              user.setId(resultSet.getInt("receiver_id"));
		              user.setName(resultSet.getString("receiver_name"));
		              user.setImage(resultSet.getString("profileimage"));
		              System.out.println(user.getImage()+"===");
		              acceptFriends.add(user);
		          }
		      }
		  } catch (SQLException e) {
		      e.printStackTrace();
		     
		  }
				System.out.println("--------------");
				System.out.println(acceptFriends.size()+"///////////////");
		return acceptFriends;
	}
	public  static ArrayList<User> displayFriendRequests()
	{
		System.out.println("....//hhhh");
		 ArrayList<User> userList=new ArrayList<User>();
		int currentUserId=DataBase.getUser().getId();
		 String query = "SELECT fr.id AS friend_request_id, " +
	               "u1.id AS id, " +
	               "u1.name AS sender_name, " +
	               "u2.name AS receiver_name " +
	               "FROM friend_requests fr " +
	               "JOIN user u1 ON fr.senderId = u1.id " +
	               "JOIN user u2 ON fr.receiverId = u2.id " +
	               "WHERE fr.receiverId = ? AND fr.status = 'pending'";

  try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
       PreparedStatement statement = conn.prepareStatement(query)) {
      statement.setInt(1, currentUserId);
      try (ResultSet resultSet = statement.executeQuery()) {
          while (resultSet.next()) {
              User user = new User();
              user.setId(resultSet.getInt("id"));
              user.setName(resultSet.getString("sender_name"));
              userList.add(user);
          }
      }
  } catch (SQLException e) {
      e.printStackTrace();
  }
		System.out.println(userList.size()+"***********");
		return userList;
	}
	public Connection connection() throws SQLException
	{
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
}
