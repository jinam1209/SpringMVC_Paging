package com.myweb.ctrl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myweb.domain.PageVO;
import com.myweb.domain.ProductVO;
import com.myweb.handler.PagingHandler;
import com.myweb.orm.FileProcessor;
import com.myweb.service.product.ProductServiceRule;

@RequestMapping("/product/*")
@Controller
public class ProductController {
	private static Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Inject
	private ProductServiceRule psv;
	
	@Inject
	private FileProcessor fp;
	
	@ResponseBody
	@PostMapping("/del_file")
	public String del_file(@RequestParam("uuid") String uuid) {
		int isUp = fp.deleteFile(uuid);
		return isUp > 0 ? "1" : "0"; // MemberController checkEmail 같은 방법
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("pno") int pno, PageVO pgvo, RedirectAttributes reAttr) {
		int isUp = psv.remove(pno);
		reAttr.addFlashAttribute("result", isUp > 0 ? "상품삭제 성공" : "상품삭제 실패");
		reAttr.addFlashAttribute("pgvo", pgvo);
		return "redirect:/product/list";
	}
	
	@PostMapping("/modify")
	public String modify(ProductVO pvo, RedirectAttributes reAtrr, PageVO pgvo,
			@RequestParam(name="files", required = false)MultipartFile[] files) {
		int isUp = psv.modify(pvo);
		if(isUp > 0 && files[0].getSize() > 0) {
			isUp = fp.upload_file(files, pvo.getPno()); // 파일 수정
		}
		reAtrr.addFlashAttribute("result", isUp > 0 ? "상품수정 성공" : "상품 수정 실패");
		reAtrr.addFlashAttribute("pgvo", pgvo);
		return "redirect:/product/detail?pno=" + pvo.getPno(); // GET 방식
	}
	
	@GetMapping({"/detail", "/modify"})
	public void detail(Model model, @RequestParam("pno") int pno, 
			@ModelAttribute("pgvo") PageVO pgvo) { // 받은 걸 다시 view로 반환해야 할 때 @ModelAttribute 사용
		model.addAttribute("pvo", psv.detail(pno));
	}
	
	@GetMapping("/list")
	public void list(Model model, PageVO pgvo) {
		model.addAttribute("list", psv.getList(pgvo));
		int totalCount = psv.getTotalCount(pgvo);
		model.addAttribute("pghdl", new PagingHandler(totalCount, pgvo));
	}
	@PostMapping("/register")
	public String register(ProductVO pvo, RedirectAttributes reAttr,
			@RequestParam(name="files", required = false)MultipartFile[] files) { // required 넘어오긴 하지만 필수는 아님
		int isUp = psv.register(pvo);
		if(isUp > 0) {
			if(files[0].getSize() > 0 ) { // size가 0보다 크면 file O
				int pno = psv.getCurrPno();
				isUp = fp.upload_file(files, pno);
			}
		}
		reAttr.addFlashAttribute("result", isUp > 0 ? "상품등록 성공" : "상품등록 실패");
		return "redirect:/product/list";
	}
	
	@GetMapping("/register")
	public void register() {
		logger.info("/WEB-INF/views/product/register.jsp");
	}

}
