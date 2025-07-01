package action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import model.User;

public class Request extends ActionSupport {
	ArrayList<User> userList=new ArrayList<>();
	public ArrayList<User> getUserList() {
		return userList;
	}
	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}
	private int senderId;
	private int receiverId;
	public int getSenderId() {
		return senderId;
	}
	public int getReceiverId() {
		return receiverId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}
	public String execute() throws SQLException
	{
		 userList=Friendrequest.displayFriendRequests();
		System.out.println("%%%4444   "+userList.size());
		return "success";
	}

}
