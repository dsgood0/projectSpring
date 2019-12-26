package com.khrd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khrd.domain.Criteria;
import com.khrd.domain.ProjectVO;
import com.khrd.persistence.ProjectDAO;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDAO dao;
	
	@Override
	public void regist(ProjectVO vo) {
		dao.insert(vo);
	}

	@Override
	public List<ProjectVO> list() {
		return dao.list();
	}

	@Override
	public ProjectVO selectByNo(int no) {
		return dao.selectByNo(no);
	}

	@Override
	public void modify(ProjectVO vo) {
		dao.update(vo);
	}

	@Override
	public void remove(int no) {
		dao.delete(no);
	}

	@Override
	public List<ProjectVO> listCriteria(Criteria cri) {
		return dao.listCriteria(cri);
	}
	
	@Override
	public int listCount() {
		return dao.listCount();
	}

}
