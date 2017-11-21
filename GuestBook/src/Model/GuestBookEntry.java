package Model;

public class GuestBookEntry {
	private Integer Key;
	private String Name;
	private String Message;
	public GuestBookEntry() {}
	public GuestBookEntry(Integer Key,String Name, String Message) {
		this.Key = Key;
		this.Name = Name;
		this.Message = Message;
	}
	public Integer getKey() {
		return Key;
	}
	public void setKey(Integer Key) {
		this.Key = Key;
	}
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String Message) {
		this.Message = Message;
	}
	
}
