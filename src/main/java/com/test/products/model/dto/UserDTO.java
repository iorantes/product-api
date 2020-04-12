package com.test.products.model.dto;

public class UserDTO {

	private String name;
	private Integer tel;
	private String nick;
	private String bornDate;
	private String mail;
	private String pwd;
	private Integer active;
	private String rol;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTel() {
		return tel;
	}

	public void setTel(Integer tel) {
		this.tel = tel;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getBornDate() {
		return bornDate;
	}

	public void setBornDate(String bornDate) {
		this.bornDate = bornDate;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public UserDTO() {
		super();
	}

	public UserDTO(String name, Integer tel, String nick, String bornDate, String mail, String pwd, Integer active,
			String rol) {
		super();
		this.name = name;
		this.tel = tel;
		this.nick = nick;
		this.bornDate = bornDate;
		this.mail = mail;
		this.pwd = pwd;
		this.active = active;
		this.rol = rol;
	}

}
