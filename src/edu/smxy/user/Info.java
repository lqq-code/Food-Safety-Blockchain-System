package edu.smxy.user;

public class Info {
	private String username;
	private String info;
	private String str;

	public Info() {
		super();
	}

	public Info(String username, String info, String str) {
		super();
		this.username = username;
		this.info = info;
		this.str = str;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		return "Info [username=" + username + ", info=" + info + ", str=" + str
				+ "]";
	}
	
}
