package com.home;

import com.home.dao.StudentDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMybatisDemo2ApplicationTests {
	@Autowired
	private StudentDao studentDao;

	@Test
	public void contextLoads() {
		System.out.println(studentDao.getAll());
	}

}
