package model;

public class User {
	private String username;
	private String password;
	private String name;
	private String mobileNo;
	private int id;
	private String imagePath;
	 private String friendStatus; 
	public String getImagePath() {
		return imagePath;
	}
	public String getFriendStatus() {
		return friendStatus;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public void setFriendStatus(String friendStatus) {
		this.friendStatus = friendStatus;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public void setImage(String nString) {
		this.imagePath=nString;
		
	}
	public String getImage()
	{
		return imagePath;
	}
	
}
