 
package com.aia.op.member.model;

import java.sql.Date;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonFormat;


/*
	2020.08.11
	verify �÷� �߰�, 	code �߰�
	verify : ���� ���� �ڵ�
	code : ���� �ڵ�
*/
public class Member {

	private int idx;
	private String uid;
	private String upw;
	private String uname;
	private String uphoto;
	// �̸��� �����ڵ�
	private String code;
	// �̸��� �������� Ȯ��
	private char verify;
	private Date regdate;

	public Member(int idx, String uid, String upw, String uname, String uphoto, String code, Date regdate) {
		this.idx = idx;
		this.uid = uid;
		this.upw = upw;
		this.uname = uname;
		this.uphoto = uphoto;
		this.code = code;
		this.regdate = regdate;
		// 2020.08.11 �߰�
		getRandomSting();
	}

	// MemberRegRequest -> Member
	public Member(String uid, String upw, String uname) {
		this(0, uid, upw, uname, null, null, null);
	}

	public Member() {
		// 2020.08.11 �߰�
		getRandomSting();
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUpw() {
		return upw;
	}

	public void setUpw(String upw) {
		this.upw = upw;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUphoto() {
		return uphoto;
	}

	public void setUphoto(String uphoto) {
		this.uphoto = uphoto;
	}

	public Date getRegdate() {
		return regdate;
	}


	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	// java.sql.Date -> java.util.Date
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	public java.util.Date getToDate() {// ${member.toDate}
		return new java.util.Date(regdate.getTime());
	}

	// Member -> LoginInfo : �α��� ó���� ������ ������
	public LoginInfo toLoginInfo() {
		return new LoginInfo(uid, uname, uphoto);
	}

	@Override
	public String toString() {
		return "Member [idx=" + idx + ", uid=" + uid + ", upw=" + upw + ", uname=" + uname + ", uphoto=" + uphoto
				+ ", regdate=" + regdate + "]";
	}
	
	

	// 2020.08.11 �߰�
	public char getVerify() {
		return verify;
	}	
	// 2020.08.11 �߰�
	public void setVerify(char verify) {
		this.verify = verify;
	}
	// 2020.08.11 �߰�
	public String getCode() {
		return code;
	}
	// 2020.08.11 �߰�
	public void setCode(String code) {
		this.code = code;
	}

	// 2020.08.11 �߰�
	// ���� + ���� ���� �߻�
	private void getRandomSting() {
		
		Random r = new Random(System.nanoTime());
		StringBuffer sb = new StringBuffer();
		
		for(int i=0 ; i<20 ; i++ ) {
			if(r.nextBoolean()) {
				sb.append(r.nextInt(10));
			} else {
				sb.append((char)(r.nextInt(26)+97));
			}
		}
		
		System.out.println("���� �ڵ� ���� : " + sb) ;
		
		setCode(sb.toString());
		
		//return  sb.toString();		
	}
	

}