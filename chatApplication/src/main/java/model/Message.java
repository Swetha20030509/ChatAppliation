package model;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Message {
	private int senderId;
    private int receiverId;
    private String content;
    private Date timestamp;
	public String getTimestamp() {
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
        return sdf.format(timestamp);
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	

}
