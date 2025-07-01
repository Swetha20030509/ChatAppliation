package loginPage;
import datalayer.DataBase;
import model.User;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import action.Friendrequest;
public class LoginAction extends ActionSupport {
	
	String mobileNo;
	String password;
	User user;
	ArrayList<User> friends;
	
	
	public ArrayList<User> getFriends() {
		return friends;
	}


	public void setFriends(ArrayList<User> friends) {
		this.friends = friends;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String execute() throws ClassNotFoundException 
	    {
			
			 user=DataBase.validateUser(getMobileNo(),getPassword());
			 setUser(user);
				if(user!=null)
				{
					setFriends(Friendrequest.getFriends(user.getId()));
	            return SUCCESS;
				}
				else
				{
					return ERROR;
				}
	    }
}
