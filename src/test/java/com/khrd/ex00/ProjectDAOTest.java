package com.khrd.ex00;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.khrd.domain.ProjectVO;
import com.khrd.persistence.ProjectDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ProjectDAOTest {

	@Autowired
	private ProjectDAO dao;
	
	//@Test
	public void testDAO() {
		System.out.println(dao);
	}
	
	//@Test
	public void insertTest() {
		//ProjectVO vo = new ProjectVO(null, "제목", "내용", new Date((new Timestamp("2019-10-10")).getTime()), new Date((new Timestamp("2019-12-12")).getTime()), "1");		
		//dao.insert(vo);
	}
	
	//@Test
	public void listTest() {
		dao.list();
	}
	
	//@Test
	public void selectByIdTest() {
		dao.selectByNo(1);
	}
	
	//@Test
	public void updateTest() {
		//ProjectVO vo = new ProjectVO(1, "제목", "내용", new Date("2019-12-10"), new Date("2019-12-12"), 1);
		//dao.update(vo);
	}
	
	//@Test
	public void deleteTest() {
		dao.delete(1);
	}
}
