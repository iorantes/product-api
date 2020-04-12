package com.test.products.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SGD_USER")
public class User extends AbstractBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3550819256922155862L;

	@Id
	@Column(name = "SGD_USER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Column(name = "SGD_USER_NAME")
	private String userNomb;

	@Column(name = "SGD_USER_TEL")
	private Integer userTel;

	@Column(name = "SGD_USER_USERNAME")
	private String userNick;

	@Column(name = "SGD_USER_BORNDATE")
	private Date userBornDate;

	@Column(name = "SGD_USER_MAIL")
	private String userMail;

	@Column(name = "SGD_USER_USERPWD")
	private String userPWD;

	@Column(name = "SGD_USER_ACTIVE")
	private Integer userActive;

	@Column(name = "SGD_USER_RESETPWD")
	private Date userReset;

	@Column(name = "SGD_USER_ROLE")
	private String userRol;

	public User() {
		super();
	}

	public User(Long userId, String userNomb, Integer userTel, String userNick, Date userBornDate, String userMail,
			String userPWD, Integer userActive, Date userReset, String userRol) {
		super();
		this.userId = userId;
		this.userNomb = userNomb;
		this.userTel = userTel;
		this.userNick = userNick;
		this.userBornDate = userBornDate;
		this.userMail = userMail;
		this.userPWD = userPWD;
		this.userActive = userActive;
		this.userReset = userReset;
		this.userRol = userRol;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserNomb() {
		return userNomb;
	}

	public void setUserNomb(String userNomb) {
		this.userNomb = userNomb;
	}

	public Integer getUserTel() {
		return userTel;
	}

	public void setUserTel(Integer userTel) {
		this.userTel = userTel;
	}

	public String getUserNick() {
		return userNick;
	}

	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}

	public Date getUserBornDate() {
		return userBornDate;
	}

	public void setUserBornDate(Date userBornDate) {
		this.userBornDate = userBornDate;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getUserPWD() {
		return userPWD;
	}

	public void setUserPWD(String userPWD) {
		this.userPWD = userPWD;
	}

	public Integer getUserActive() {
		return userActive;
	}

	public void setUserActive(Integer userActive) {
		this.userActive = userActive;
	}

	public Date getUserReset() {
		return userReset;
	}

	public void setUserReset(Date userReset) {
		this.userReset = userReset;
	}

	public String getUserRol() {
		return userRol;
	}

	public void setUserRol(String userRol) {
		this.userRol = userRol;
	}

}
