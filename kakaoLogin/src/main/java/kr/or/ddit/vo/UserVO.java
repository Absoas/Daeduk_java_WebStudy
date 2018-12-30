package kr.or.ddit.vo;

import java.util.Date;

import lombok.Data;

@Data
public class UserVO {
	private String user_id;
	private String user_email;
	private String user_name;
	private String user_password;
	private String user_profileImagePath;
	private int user_sex;
	private String user_birth;
	private String user_job;
	private String user_phoneNumber;
	private String user_authCode;
	private String user_authStatus;
	private String user_isTutor;
	private String user_status;
	private String pageNumber;
	private String rnum;
	private Date user_log;
	private int ages;
	private int age_count;
	private int user_isAdmin;
	private int unReadCount;
}