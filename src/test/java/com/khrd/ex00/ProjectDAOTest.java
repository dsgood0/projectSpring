package com.khrd.ex00;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	
	@Test
	public void insertTest() throws ParseException {
		ProjectVO vo = new ProjectVO();
		vo.setTitle("제목");
		vo.setContent("내용");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date sdate = sdf.parse("2019-12-13");
		vo.setStartdate(sdate);
		Date edate = sdf.parse("2019-12-14");
		vo.setEnddate(edate);
		vo.setState(1);
		dao.insert(vo);
	}
	
	@Test
	public void listTest() {
		dao.list();
	}
	
	@Test
	public void selectByIdTest() {
		dao.selectByNo(1);
	}
	
	@Test
	public void updateTest() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date sdate = sdf.parse("2019-12-13");
		Date edate = sdf.parse("2019-12-14");
		ProjectVO vo = new ProjectVO(1, "제목2", "내용2", sdate, edate, 1);
		dao.update(vo);
	}
	
	@Test
	public void deleteTest() {
		dao.delete(1);
	}
}
