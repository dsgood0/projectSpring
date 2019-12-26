package com.khrd.service;

import java.util.List;

import com.khrd.domain.Criteria;
import com.khrd.domain.ProjectVO;

public interface ProjectService {
	public void regist(ProjectVO vo);
	public List<ProjectVO> list();
	public ProjectVO selectByNo(int no);
	public void modify(ProjectVO vo);
	public void remove(int no);
	
	public List<ProjectVO> listCriteria(Criteria cri);
	public int listCount();
}
