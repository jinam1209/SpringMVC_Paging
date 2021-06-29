package com.myweb.ctrl;

import java.util.List;

import javax.inject.Inject;

import org.mp4parser.support.RequiresParseDetailAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myweb.domain.CommentVO;
import com.myweb.domain.PageVO;
import com.myweb.service.comment.CommentServiceRule;

@RequestMapping("/comment/*")
@RestController // @ResponseBody 장착되어있음
public class CommentController {
	private static Logger logger = LoggerFactory.getLogger(CommentController.class);

	@Inject
	private CommentServiceRule csv;
	
	@RequestMapping(value = "/{cno}", method = {RequestMethod.PATCH, RequestMethod.PUT},
	consumes = "application/json", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> modify(@PathVariable("cno")int cno,
			@RequestBody CommentVO cvo) { // 수정
		return csv.modify(cvo) > 0 ? 
				new ResponseEntity<String>("1", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping(value = "/{cno}", produces = MediaType.TEXT_PLAIN_VALUE) // String 이라는 뜻
	public ResponseEntity<String> remove(@PathVariable("cno")int cno) { // 삭제
		return csv.remove(cno) > 0 ?
				new ResponseEntity<String>("1", HttpStatus.OK) // 지워짐
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value = {"/pno/{pno}/{range}/{keyword}","/pno/{pno}"}, 
			produces = {MediaType.APPLICATION_ATOM_XML_VALUE,
					MediaType.APPLICATION_JSON_UTF8_VALUE}) // {pno} 변수화
	public ResponseEntity<List<CommentVO>> list(@PathVariable("pno")int pno,
			@PathVariable(value = "range", required = false)String range, @PathVariable(value = "keyword", required = false)String keyword) { // 리스트, @PathVariable = 들어오는 path 값을 변수화 시킴
//		List<CommentVO> list = csv.getList(pno); 
		return new ResponseEntity<List<CommentVO>>(csv.getList(pno, new PageVO(range, keyword)),
				HttpStatus.OK); // ResponseEntity랑 HttpStatus는 짝꿍
	}
	
	@PostMapping(value = "/register", consumes = "application/json",
			produces = "application/text; charset=utf-8") // (json으로 받아서 text로 가공) 무엇을 받을 것이며 어떻게 처리할 것인지도 선언해야됨~!!
	public ResponseEntity<String> register(@RequestBody CommentVO cvo) { // 비동기 통신
		int isUp = csv.register(cvo);
		return isUp > 0 ?
				new ResponseEntity<String>("1", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR); // 결과값 detail.jsp에서 받음
	}
}
