package action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import DAO.UserDAO;
import model.User;

public class Contact extends ActionSupport{
	ArrayList<User> friendList=new ArrayList<>();
	public ArrayList<User> getFriendList() {
		System.out.println("getter"+friendList.size());
		return friendList;
	}
	public void setFriendList(ArrayList<User> friendList) {
		System.out.println("setter"+friendList.size());
		this.friendList = friendList;
	}
	public String execute() throws SQLException
	{
		System.out.println("open contact");
		 friendList = Friendrequest.getFriends(UserDAO.getInstance().getUser().getId());
		System.out.println(friendList.size()+"//friend");
		return "success";
	}

}
