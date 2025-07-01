package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import model.User;

public class SearchUser extends ActionSupport {
	List<User> userList = new ArrayList<>();
	String searchQuery;
	public List<User> getUserList() {
		return userList;
	}
	public String getSearchQuery() {
		return searchQuery;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public void setSearchQuery(String searchQuery) {
		 System.out.println("Setter called! Value = " + searchQuery);
		this.searchQuery = searchQuery;
	}
	public String execute() throws SQLException {
		System.out.println("Search Query: " + getSearchQuery());
		UserDAO dao = new UserDAO();
		userList = dao.getUser(getSearchQuery());
		System.out.println("User found: " + userList.size());
		return "success";
	}
}
