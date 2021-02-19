package com.aia.op.member.dao;

import java.util.List;
import java.util.Map;

import com.aia.op.member.model.Member;
import com.aia.op.member.model.MemberXML;
import com.aia.op.member.model.MemberXmlList;

public interface MemberDaoInterface {
	
	public Member selectByIdpw(String uid, String pw);
	
	// ȸ�� ��ü ����Ʈ ��ȯ
	public List<Member> selectTotalList();
	
	// ��ü XML ȸ�� ����Ʈ
	public List<MemberXML> selectTotalListXml();
	
	// idx ������� �˻��� ȸ���� ���� ��ȯ
	public Member selectByIdx(int idx);
	
	// ȸ�� ����
	public int insertMember(Member member);
	
	// ��ü �Խù��� ���� : �˻� ����
	public int totalCount(Map search);
	
	// ��ü �Խù���  List<Member> �� ��ȯ
	public List<Member> selectList(Map search);

	// ȸ�� �̸��� ���� ó��
	public int verify(String id, String code);

	
	public Member selectMemberById(String email);
	
	
	
	
	
	
	
	
	

}

