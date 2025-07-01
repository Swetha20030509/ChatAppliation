package action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.opensymphony.xwork2.ActionSupport;

import model.User;
import model.Message;
import java.util.ArrayList;
public class SendMessage extends ActionSupport{
	 private static final String URL = "jdbc:mysql://localhost:3306/ chatApplication";
	    private static final String USERNAME = "root";
	    private static final String PASSWORD = "Admin";
    private int senderId;
    private int receiverId;
    private String content;
     ArrayList<Message> allmessage=new ArrayList<>();
    public  ArrayList<Message> getAllmessage() {
		return allmessage;
	}

	public void setAllmessage(ArrayList<Message> allmessage) {
		this.allmessage = allmessage;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
    public String retrieveMessage()
    {
    	System.out.println(getSenderId()+"sen");
    	System.out.println(receiverId+"rec");
    	allmessage=new ArrayList<>();
    	String selectQuery = "SELECT " +
               
                "m.content AS content, " +
                "m.time, " +
                "sender.id AS sender_id, " +
                "sender.name AS sender_name, " +
                "receiver.id AS receiver_id, " +
                "receiver.name AS receiver_name " +
                "FROM " +
                "messages m " +
                "JOIN user sender ON m.sender_id = sender.id " +
                "JOIN user receiver ON m.receiver_id = receiver.id " +
                "WHERE " +
                "(m.sender_id = ? AND m.receiver_id = ?) OR " +
                "(m.sender_id = ? AND m.receiver_id = ?) " +
                "ORDER BY m.time ASC";


    	  try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    	       PreparedStatement statement = conn.prepareStatement(selectQuery)) {
    		  statement.setInt(1, getSenderId());
    		  statement.setInt(2, getReceiverId());
    		  statement.setInt(3, getReceiverId());
    		  statement.setInt(4,  getSenderId());
    	      try (ResultSet resultSet = statement.executeQuery()) {
    	          while (resultSet.next()) {
    	              Message message=new Message();
    	              message.setSenderId(resultSet.getInt("sender_id"));
    	              message.setReceiverId(resultSet.getInt("receiver_id"));
    	              message.setContent(resultSet.getString("content"));
    	              message.setTimestamp(resultSet.getTimestamp("time"));
    	              allmessage.add(message);
    	          }
    	      }
    	  } catch (SQLException e) {
    	      e.printStackTrace();
    	     
    	  }
    	  System.out.println(allmessage.size()+".....nnnnn");
    	  
    	  
    	  return SUCCESS;
    }
    public String storeMessage()
    {
    	String insertQuery = "INSERT INTO messages (sender_id, receiver_id, content) VALUES (?, ?, ?)";
    	   try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
  	             PreparedStatement stmt = conn.prepareStatement(insertQuery)) {
  	            stmt.setInt(1, getSenderId());
  	            stmt.setInt(2,getReceiverId() );
  	            stmt.setString(3, getContent());
  	           
  	            int rowsAffected = stmt.executeUpdate();
  	         
  	        } catch (SQLException e) {
  	            e.printStackTrace();
  	           
  	        }
       return SUCCESS;
    }
}
