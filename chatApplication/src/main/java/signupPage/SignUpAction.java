package signupPage;
import datalayer.DataBase;
import com.opensymphony.xwork2.ActionSupport;
public class SignUpAction extends ActionSupport {
	 private String name;
	    private String password;
	    private String mobileNo;
	    private String username;
		

		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public String getMobileNo() {
			return mobileNo;
		}


		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}


		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}


		public String execute() throws ClassNotFoundException 
	    {
	    	System.out.println(name);
	        boolean success = DataBase.addUser(name,mobileNo,username,password);
	        if (success) {
	        	System.out.println("Signup - Success"+name);
	            return SUCCESS; 
	        } else {
	        	System.out.println("Signup - Username/Email already exists");
	            return ERROR; 
	        }
	    }

}
