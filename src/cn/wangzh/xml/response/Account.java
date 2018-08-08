package cn.wangzh.xml.response;

public class Account {
	private String code;
	private String pass;
	private String name;
	private String money;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	
	@Override
	public String toString() {
		return "Account [code=" + code + ", money=" + money + ", name=" + name
				+ ", pass=" + pass + "]";
	}
	

}
