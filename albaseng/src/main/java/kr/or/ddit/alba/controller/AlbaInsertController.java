package kr.or.ddit.alba.controller;

import java.util.ArrayList;
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
import kr.or.ddit.vo.LicenseVO;

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
		
		if(license != null){
			List<LicenseVO> licList = new ArrayList<>();
			LicenseVO licVO = null;
			for(String lic : license){
				licVO = new LicenseVO();
				licVO.setLic_code(lic);
				licList.add(licVO);
			}
			alba.setLicense(licList);
			
			for(LicenseVO str : licList){
				System.out.println(str.getLic_code());
			}
		}
		
//		if(valid){
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
//		}
//		else{
//			view = "alba/albaForm";
//		}
		mav.setViewName(view);
		return mav;
	}

	@RequestMapping(value="/alba/albaInsert.do" , method=RequestMethod.GET)
	public String getProcess(Model model){
		return "alba/albaForm";
	}
	
	
	@ModelAttribute("gradeMap")
	public List<Map<String, Object>> gradeMapList(){
		List<Map<String, Object>> gradeMap = otherDAO.selectGrade();
		return gradeMap;
	}
	
	@ModelAttribute("licenseMap")
	public List<Map<String, Object>> licenseMapList(){
		List<Map<String, Object>> licenseMap = otherDAO.selectLicense();
		return licenseMap;
	}
}
