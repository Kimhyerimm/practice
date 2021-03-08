package com.aia.op.member.service;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aia.op.member.dao.MemberDaoInterface;
import com.aia.op.member.model.Member;
import com.aia.op.member.model.MemberRegRequest;

@Service
public class MemberRegService {

//	@Autowired
//	MemberDao dao;

//	@Autowired
//	MybatisMemberDao dao;

	private MemberDaoInterface dao;

	// �ڵ� ���۸� ���� sqlSessionTemplate ��ü ����
	// @Inject : Ÿ�Կ� �´� ���� ( java ���� ���� : Ư�� �����ӿ�ũ�� �������� ���� )
	@Inject
	private SqlSessionTemplate sessionTemplate;

	//2020.08.11 ����
	/* @Autowired */
	/* private MailSenderService mailService; */

	public int memberReg(MemberRegRequest regRequest, HttpServletRequest request) {

		dao = sessionTemplate.getMapper(MemberDaoInterface.class);

		int result = 0;

		// Dao �޼��忡 ������ ��ü : �Է��� �����͸� ��� �����ϴ� ������ �ʿ��մϴ�.
		Member member = regRequest.toMember();

		System.out.println("�Է� �� IDX ===> " + member.getIdx());

		try {

			MultipartFile file = regRequest.getPhoto();

			System.out.println(regRequest);

			// ������ �ִٸ� ���� ������ ���������� �����ϰ�, ���ٸ� �⺻ �̹��� ������ ��θ� �����Ѵ�.
			if (file != null && !file.isEmpty() && file.getSize() > 0) {

				// ���� ������ ���
				String uri = request.getSession().getServletContext().getInitParameter("memberUploadPath");

				// �ý����� ����(����) ���
				String realPath = request.getSession().getServletContext().getRealPath(uri);

				// ������ �̹��� ������ ���ο� �̸� ����
				String newFileName = System.nanoTime() + "_" + file.getOriginalFilename();

				// ������ ����ҿ� ���� ����
				File saveFile = new File(realPath, newFileName);
				file.transferTo(saveFile);
				System.out.println("���� �Ϸ� : " + newFileName);

				// �����ͺ��̽��� ������ Member ��ü�� �����͸� �ϼ��Ѵ�. : ���� ���
				member.setUphoto(newFileName);

			} else {
				member.setUphoto("defalult.png");
			}

			result = dao.insertMember(member);

			System.out.println("�Է� �� IDX ===> " + member.getIdx());

			// ���� �߼�
			// 2020.08.11 ����
			/* mailService.send(member.getUid(), member.getCode()); */

		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

		return result;
	}

}