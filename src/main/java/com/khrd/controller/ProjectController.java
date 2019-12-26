package com.khrd.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.khrd.domain.Criteria;
import com.khrd.domain.PageMaker;
import com.khrd.domain.ProjectVO;
import com.khrd.service.ProjectService;

@RequestMapping("/project/*")
@Controller
public class ProjectController {
	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired
	ProjectService service;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void list(Model model) {
		logger.info("--------- list ----------");
		List<ProjectVO> list = service.list();
		model.addAttribute("list", list);
	}
	
	@RequestMapping(value = "listPage", method = RequestMethod.GET)
	public void listPage(Criteria cri, Model model) {
		logger.info("--------- listPage ----------");
		List<ProjectVO> list = service.listCriteria(cri);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCount());
		
		model.addAttribute("list", list);
		model.addAttribute("pageMaker", pageMaker);	
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void detail(int no, Model model) {
		logger.info("--------- detail ----------");
		ProjectVO vo = service.selectByNo(no);
		model.addAttribute("vo", vo);
	}
	
	@RequestMapping(value = "detailPage", method = RequestMethod.GET)
	public void detailPage(int no, Criteria cri, Model model) {
		logger.info("--------- detailPage ----------");
		ProjectVO vo = service.selectByNo(no);
		model.addAttribute("vo", vo);
		model.addAttribute("cri", cri);
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add(ProjectVO vo) {
		logger.info("--------- Add ----------");
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addResult(ProjectVO vo) {
		logger.info("--------- AddResult ----------");
		service.regist(vo);
		
		return "redirect:/project/listPage";
	}
	
	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public void modifyForm(int no, Model model) {
		logger.info("--------- modifyForm ----------");
		ProjectVO vo = service.selectByNo(no);
		model.addAttribute("vo", vo);
	}	
	
	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String modifyConfirm(ProjectVO vo) {
		logger.info("--------- modifyConfirm ----------");
		service.modify(vo);
		
		return "redirect:/project/list";
	}	

	@RequestMapping(value = "modifyPage", method=RequestMethod.GET)
	public void modifyPage(int no, Criteria cri, Model model) {
		logger.info("-------------modifyPage----------------");
		
		ProjectVO vo = service.selectByNo(no);
		
		model.addAttribute("vo", vo);
		model.addAttribute("cri", cri);		
	}
	
	@RequestMapping(value = "modifyPage", method=RequestMethod.POST)
	public String modifyResultPage(ProjectVO vo, Criteria cri) {
		logger.info("-------------modifyResultPage----------------");
		
		service.modify(vo);
		
		return "redirect:/project/detailPage?no="+vo.getNo()+"&page="+cri.getPage();
	}
	
	@RequestMapping(value = "remove", method = RequestMethod.GET)
	public String remove(int no) {
		logger.info("--------- remove ----------");
		service.remove(no);
		
		return "redirect:/project/list";
	}
	
	@RequestMapping(value = "removePage", method=RequestMethod.GET)
	public String removePage(int no, Criteria cri) {
		logger.info("-------------remove----------------");
		
		service.remove(no);
		
		return "redirect:/project/listPage?page="+cri.getPage();
	}
}
