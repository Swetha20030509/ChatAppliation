package action;

import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateProfileAction extends ActionSupport {

	private File dp;                    // Uploaded file
    private String dpFileName;  // Filename
    private int userId;
    public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}


	private static final String URL = "jdbc:mysql://localhost:3306/ chatApplication";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Admin";
//    private String dpContentType;       // MIME type

    public void setDp(File dp) { this.dp = dp; }
    public void setDpFileName(String dpFileName) { this.dpFileName = dpFileName; }
   

    public String execute() {
        try {
        	//System.out.println(dp.getPath()+"//--");
        	System.out.println(dpFileName+"****");
        	String uploadPath = "C:/Users/ELCOT/eclipse-workspace/chatApplication/src/main/webapp/upload";
        	File folder = new File(uploadPath);
        	if (!folder.exists()) {
        	    folder.mkdirs(); // create the directory if it doesn't exist
        	}
            File destFile = new File(uploadPath, dpFileName);
            try (InputStream in = new FileInputStream(dp);
                 OutputStream out = new FileOutputStream(destFile)) {
                byte[] buffer = new byte[1024];
                int len;
                while ((len = in.read(buffer)) > 0) {
                    out.write(buffer, 0, len);
                }
            }
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String updateimageQuery="update user set profileimage=? where id=?";
            PreparedStatement ps = conn.prepareStatement(updateimageQuery);
            ps.setString(1, dpFileName);
            ps.setInt(2, userId);
            ps.executeUpdate();
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }
}
