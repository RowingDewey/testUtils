package cn.wangzh.xml.response;

import java.util.List;

public class Accounts {

	private List<Account> Account;

	public List<Account> getAccount() {
		return Account;
	}

	public void setAccount(List<Account> account) {
		Account = account;
	}

	@Override
	public String toString() {
		return "Account [Account=" + Account + "]";
	}
	
}
