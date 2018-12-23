package kr.or.ddit.alba.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.alba.service.IAlbaService;

@Controller
public class AlbaDeleteController {
	@Inject
	IAlbaService service;
	
	@RequestMapping(value="/alba/albaDelete.do", method=RequestMethod.GET)
	public String process(
			@RequestParam(required=true , name="who")String alba_code,
			RedirectAttributes redirectAttributes
			){
		ServiceResult result =
				service.deleteAlba(alba_code);
		
		String viewName = null;
		switch (result) {
			case OK:
				viewName = "redirect:/alba/albaList.do";
				break;
			case INVALIDPASSWORD:
				viewName = "redirect:/alba/albaView.do?who="+alba_code;
				redirectAttributes.addFlashAttribute("message", "비번 오류");
				break;
	
			default:
				viewName = "redirect:/alba/albaView.do?who="+alba_code;
				redirectAttributes.addFlashAttribute("message", "서버 오류");
				break;
		}
		return viewName;
	}
}
