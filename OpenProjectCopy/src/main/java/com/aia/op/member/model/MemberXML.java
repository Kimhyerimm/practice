package com.aia.op.member.model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

/*import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;*/

import com.fasterxml.jackson.annotation.JsonFormat;

/*@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"idx", "uid", "upw", "uname", "uphoto", "regdate"})*/
public class MemberXML {

	private int idx;
	private String uid;
	private String upw;
	private String uname;
	private String uphoto;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private LocalDate regdate;
	
	public MemberXML(int idx, String uid, String upw, String uname, String uphoto, LocalDate regdate) {
		this.idx = idx;
		this.uid = uid;
		this.upw = upw;
		this.uname = uname;
		this.uphoto = uphoto;
		this.regdate = regdate;
	}

	// MemberRegRequest -> Member
	public MemberXML(String uid, String upw, String uname) {
		this(0, uid, upw, uname, null, null);
	}

	public MemberXML() {
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

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	public LocalDate getRegdate() {
		return regdate;
	}

	public void setRegdate(LocalDate regdate) {
		this.regdate = regdate;
	}

	// java.sql.Date -> java.util.Date
//	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
//	public Date getToDate() {// ${member.toDate}
//		return new Date(regdate.getTime());
//	}
	
	// Member -> LoginInfo : 로그인 처리시 저장할 데이터
	public LoginInfo toLoginInfo() {
		return new LoginInfo(uid, uname, uphoto) ;
	}

	@Override
	public String toString() {
		return "Member [idx=" + idx + ", uid=" + uid + ", upw=" + upw + ", uname=" + uname + ", uphoto=" + uphoto
				+ ", regdate=" + regdate + "]";
	}

}