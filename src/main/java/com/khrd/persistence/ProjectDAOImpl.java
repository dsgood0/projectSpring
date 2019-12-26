package com.khrd.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.khrd.domain.Criteria;
import com.khrd.domain.ProjectVO;

@Repository
public class ProjectDAOImpl implements ProjectDAO {

	private final static String namespace = "mappers.ProjectMapper";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insert(ProjectVO vo) {
		sqlSession.insert(namespace + ".insert", vo);
	}

	@Override
	public List<ProjectVO> list() {
		return sqlSession.selectList(namespace + ".list");
	}

	@Override
	public ProjectVO selectByNo(int no) {
		return sqlSession.selectOne(namespace + ".selectByNo", no);
	}

	@Override
	public void update(ProjectVO vo) {
		sqlSession.update(namespace + ".update", vo);
	}

	@Override
	public void delete(int no) {
		sqlSession.delete(namespace + ".delete", no);
	}

	@Override
	public List<ProjectVO> listPage(int page, int perPage) {
		// TODO Auto-generated method stub
		page = (page-1) * perPage;
				
		Map<String, Integer> map = new HashMap<>();
		map.put("page", page);
		map.put("perPage", perPage);
				
		return sqlSession.selectList(namespace + ".listPage", map);
	}

	@Override
	public int listCount() {
		return sqlSession.selectOne(namespace + ".listCount");
	}

	@Override
	public List<ProjectVO> listCriteria(Criteria cri) {
		return sqlSession.selectList(namespace + ".listCri", cri);
	}

}
