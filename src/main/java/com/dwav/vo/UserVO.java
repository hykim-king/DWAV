package com.dwav.vo;

import com.dwav.cmn.DTO;

/**
 * @author Dosn
 *
 */
public class UserVO extends DTO {
	/** 유저 ID */
	private String user_id      ;
	
	/** 비밀번호 */
	private String user_pwd   ;      
	
	/** 성 */
	private String first_name;
	
	/** 이름 */
	private String last_name;

	/** 생년월일 */
	private String birth_date;
	
	/** 이메일 */
	private String email;
	
	/** 이메일 */
	private String user_ph_num;

	/** 유저 사진 */
	private String user_img;
	
	/** 유저 소개 */
	private String user_intro;
	
	/** 가입 날짜 */
	private String join_date;
	
	/** 이메일 인증 여부 */
	private int email_auth;
	
	private String user_state;
	

	public UserVO() {}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getUser_pwd() {
		return user_pwd;
	}


	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getBirth_date() {
		return birth_date;
	}


	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUser_ph_num() {
		return user_ph_num;
	}


	public void setUser_ph_num(String user_ph_num) {
		this.user_ph_num = user_ph_num;
	}


	public String getUser_img() {
		return user_img;
	}


	public void setUser_img(String user_img) {
		this.user_img = user_img;
	}


	public String getUser_intro() {
		return user_intro;
	}


	public void setUser_intro(String user_intro) {
		this.user_intro = user_intro;
	}


	public String getJoin_date() {
		return join_date;
	}


	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}


	public int getEmail_auth() {
		return email_auth;
	}


	public void setEmail_auth(int email_auth) {
		this.email_auth = email_auth;
	}


	public String getUser_state() {
		return user_state;
	}


	public void setUser_state(String user_state) {
		this.user_state = user_state;
	}


	@Override
	public String toString() {
		return "UserVO [user_id=" + user_id + ", user_pwd=" + user_pwd + ", first_name=" + first_name + ", last_name="
				+ last_name + ", birth_date=" + birth_date + ", email=" + email + ", user_ph_num=" + user_ph_num
				+ ", user_img=" + user_img + ", user_intro=" + user_intro + ", join_date=" + join_date + ", email_auth="
				+ email_auth + ", user_state=" + user_state + ", toString()=" + super.toString() + "]";
	}


	public UserVO(String user_id, String user_pwd, String first_name, String last_name, String birth_date, String email,
			String user_ph_num, String user_img, String user_intro) {
		super();
		this.user_id = user_id;
		this.user_pwd = user_pwd;
		this.first_name = first_name;
		this.last_name = last_name;
		this.birth_date = birth_date;
		this.email = email;
		this.user_ph_num = user_ph_num;
		this.user_img = user_img;
		this.user_intro = user_intro;
		this.user_state = user_state;
	}





	
	
}
