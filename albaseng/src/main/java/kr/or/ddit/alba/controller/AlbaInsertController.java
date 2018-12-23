package kr.or.ddit.alba.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.alba.dao.IOtherDAO;
import kr.or.ddit.alba.service.IAlbaService;
import kr.or.ddit.vo.AlbaVO;

@Controller
public class AlbaInsertController {
	
	@Inject
	IAlbaService service;
	
	@Inject
	IOtherDAO otherDAO;
	
	@RequestMapping(value="/alba/albaInsert.do" , method=RequestMethod.POST)
	public ModelAndView postProcess(
			@ModelAttribute("alba") AlbaVO alba,
			Errors errors,
			@RequestParam(required=false) String[] license
			){
		boolean valid = !errors.hasErrors();
		String view = null;
		ModelAndView mav = new ModelAndView();
		
		if(valid){
			ServiceResult result =  service.createAlba(alba);
			switch (result) {
			case OK:
				view = "redirect:/alba/albaList.do";
				break;
			case FAILED:
				view = "alba/albaForm";
				mav.addObject("alba", alba);
				break;

			default:
				break;
			}
		}else{
			view = "alba/albaForm";
		}
		
		mav.setViewName(view);
		return mav;
	}

	@RequestMapping(value="/alba/albaInsert.do" , method=RequestMethod.GET)
	public String getProcess(Model model){

		List<Map<String, String>> gradeMap = otherDAO.selectGrade();
		List<Map<String, String>> licenseMap = otherDAO.selectLicense();
		model.addAttribute("gradeMap", gradeMap);
		model.addAttribute("licenseMap", licenseMap);
		
		return "alba/albaForm";
	}
}
