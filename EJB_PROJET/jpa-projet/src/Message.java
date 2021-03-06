
import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the message database table.
 * 
 */
@Entity
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int messageId;

	private String content;

	private String date;

	private String fromUser;

	private boolean isRead;

	private String time;

	private String toUser;

    public Message() {
    }
    
	@SuppressWarnings("deprecation")
	public Message(String fromUser, String toUser, String content, String time) {
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.content = content;
		this.time = time;
		this.date = new Date().toLocaleString().split(" ")[0];
		this.isRead = false;
	}
    
    
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getMessageId() {
		return this.messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFromUser() {
		return this.fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public boolean getIsRead() {
		return this.isRead;
	}

	public void setIsRead(boolean isRead) {
		this.isRead = isRead;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getToUser() {
		return this.toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

}