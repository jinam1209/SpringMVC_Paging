package com.myweb.ctrl;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myweb.domain.MemberVO;
import com.myweb.domain.PageVO;
import com.myweb.handler.PagingHandler;
import com.myweb.service.member.MemberServiceRule;

@RequestMapping("/member/*")
@Controller
public class MemberController {
	private static Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Inject
	private MemberServiceRule msv;
	
	@GetMapping("/logout")
	public String logout(RedirectAttributes reAttr, HttpSession ses) {
		ses.invalidate();
		reAttr.addFlashAttribute("result", "Logout Success");
		return "redirect:/";
	}
	
	@PostMapping("/modify")
	public String modify(MemberVO mvo, RedirectAttributes reAttr, HttpSession ses) {
		int isUp = msv.modify(mvo);
//		  if(isUp > 0) { ses.setAttribute("ses", mvo); }
//		  reAttr.addFlashAttribute("result", ses.getAttribute("ses") != null ?
//		  "Member Modify Success" : "Member Modify Fail"); // ses.getID()
		return "redirect:/member/list";
	}
	
	@GetMapping("/modify")
	public void modify(@RequestParam("email")String email, Model model) { // view로 나가려면 model 있어야됨 ~~
		model.addAttribute("mvo", msv.detail(email));
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("email")String email, RedirectAttributes reAttr) {
		int isUp = msv.remove(email);
		reAttr.addFlashAttribute("result", isUp > 0 ? "Removing Member Success" : "Removing Member Fail");
		return "redirect:/member/list";
	}
	
	@GetMapping("/list")
	public void list(Model model, PageVO pgvo) {
		model.addAttribute("m_list", msv.getList(pgvo));
		int totalCount = msv.getTotalCount(pgvo);
		model.addAttribute("pghdl", new PagingHandler(totalCount, pgvo));
	}
	
	@PostMapping("/login")
	public String login(MemberVO mvo, HttpSession ses, RedirectAttributes reAttr) {
		MemberVO info = msv.login(mvo);
		if(info != null) {
			ses.setAttribute("ses", info);
			ses.setMaxInactiveInterval(10*60); // 10 min
		}
		reAttr.addFlashAttribute("result", ses.getAttribute("ses") != null ? 
				"Login Success" : "Login Fail"); // view로 전달하는 기능은 없음!, ctrl 주소체계를 거쳐서 보내야함 (reAttr 특징임)
		return ses.getAttribute("ses") != null ? "redirect:/" : "redirect:/member/login";
	}
	
	@GetMapping("/login")
	public void login() {
		logger.info("/WEB-INF/views/member/login.jsp");
	}
	
	@ResponseBody // 응답 개체 바디부분에 return 값만 보내줌
	@PostMapping("/checkEmail")
	public String emailCheck(@RequestParam("email") String email) {
		int isExist = msv.checkEmial(email);
		return isExist > 0 ? "1" : "0";
	}
	
	@PostMapping("/register") // 4.3부터 적용 가능
	public String register(MemberVO mvo, RedirectAttributes reAttr) {
		int isUp = msv.register(mvo);
		reAttr.addFlashAttribute("result", isUp > 0 ? "Register Success" : "Register Fail");
		return isUp > 0 ? "redirect:/" : "redirect:/member/register"; // ctrl 부르려면 redirect: 사용
	}

	@GetMapping("/register") // register 자동으로 return
	public void register() { // register.jsp 불러줌
		logger.info("/WEB-INF/views/member/register.jsp - GET");
	}
}
