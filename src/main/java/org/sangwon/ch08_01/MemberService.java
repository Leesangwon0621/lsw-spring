package org.sangwon.ch08_01;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sangwon.ch03.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	Logger logger = LogManager.getLogger();
	@Autowired
	MemberDao memberDao = null;

	/**
	 * memberDao setter for injection
	 */
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void selectAll() {
		List<Member> members = memberDao.selectAll(0, 100);
		logger.debug(members);
	}

	public void updateMember() {
		Member member = memberDao.selectByEmail("sunha0822@naver.com");
		member.setPassword("b");
		memberDao.update(member);
		logger.debug("Update complete.");
	}

	public void insertMember() {
		Member member = new Member();
		member.setEmail("w871334@naver.com");
		member.setPassword("a");
		member.setName("이상원");
		memberDao.insert(member);
		logger.debug("Insert complete.");
	}
}