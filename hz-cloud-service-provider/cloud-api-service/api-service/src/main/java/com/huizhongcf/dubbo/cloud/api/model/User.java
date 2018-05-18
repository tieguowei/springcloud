package com.huizhongcf.dubbo.cloud.api.model;

import java.io.Serializable;

public class User implements Serializable {
	private Integer userid;
	private String username;
	private String passwd;
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}
