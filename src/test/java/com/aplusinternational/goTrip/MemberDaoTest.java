package com.aplusinternational.goTrip;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MemberDaoTest {
//	@Autowired
	//private SimpleMemberDao dao;
	
	@Test
	public void testInsertMember() throws Exception {
		System.out.print("짲즈으나ㅓ나ㅓㅏ마마\n");
	}
}
