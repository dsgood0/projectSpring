package com.khrd.persistence;

import java.util.List;

import com.khrd.domain.Criteria;
import com.khrd.domain.ProjectVO;

public interface ProjectDAO {
	public void insert(ProjectVO vo);
	public List<ProjectVO> list();
	public ProjectVO selectByNo(int no);
	public void update(ProjectVO vo);
	public void delete(int no);
	
	public List<ProjectVO> listPage(int page, int perPage);
	public List<ProjectVO> listCriteria(Criteria cri);
	public int listCount();
}
