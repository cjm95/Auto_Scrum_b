package com.bespin.auto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.bespin.auto.domain.User;
import com.bespin.auto.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired private UserService userService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public void insertGet(User user, Model model) throws Exception{
		// 기본 생성자
	}

	/*---------------------------- search -------------------------------*/
	@RequestMapping(value = "member", method = RequestMethod.GET)
	public String getDB(Model model, @RequestParam("action") String id,  @RequestParam("selectAttr") String attr ) throws IOException {
		int i = 1;
		if(attr.equals("num")) i=0;
		else if(attr.equals("name")) i=1;
		else i=2;

		List<User> vo = userService.getDB(id, i);
		model.addAttribute("listAll", vo);
		
		return "memberlist";
	}
	
	@RequestMapping(value = "members", method = RequestMethod.GET)
	public String getDBAll(Model model) throws Exception {
		List<User> vo = userService.getDBAll();
		model.addAttribute("listAll", vo);
		
		return "memberlist";
	}
	
	@RequestMapping(value = "details", method = RequestMethod.GET)
	public String getDBUpdate(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model) throws IOException {
		String num = httpServletRequest.getParameter("num");
		logger.info("searchUpdate({})", num);
		List<User> vo = userService.getDB(num, 0);
		User use = new User();
		model.addAttribute("listAll", vo);
	
		use.setNum(vo.get(0).getNum());
		use.setName(vo.get(0).getName());
		use.setTeam(vo.get(0).getTeam());
		use.setAge(vo.get(0).getAge());

		return "UserView_ASC";
	}
	
	
	/*-------------------------------- Insert ----------------------------------*/
	
	@RequestMapping(value="/registration", method = RequestMethod.POST)
	public String insertPOST(User user, Model model) throws Exception{
		userService.insert(user);
		user.getNum();
		
		return "success";
	}
	
	/*------------------------------- Delete ------------------------------------*/
	
	@RequestMapping(value = "/removal/{Arr}", method = RequestMethod.DELETE)
	@ResponseBody
	public RedirectView deleteCustomer(@PathVariable final String[] Arr) {
		String [] bn = Arr;

		logger.info("delete({})", Arr);

			User user = new User();
			for(int i =0;i<bn.length;i++) {
				user.setCurnum(Integer.parseInt(bn[i].replace("BG", "")));
				int result = userService.delete(user.getCurnum());
			}
			return new RedirectView("http://ec2-13-125-253-208.ap-northeast-2.compute.amazonaws.com
:8088/auto/members");
	}

	
	/*------------------------------- Update ------------------------------------*/
	
	@RequestMapping(value="/UserView_ASC", method = RequestMethod.GET)
	public String update(Model model, @RequestParam("num") String bid) throws Exception{
		logger.info("UpdateController"+bid);
		User context = new User();
		context.setNum(Integer.parseInt(bid.replaceAll(" ", "")));
		model.addAttribute("num", context);
		return "UserView_ASC";
	}
	
	@RequestMapping(value = "/modification/{num}", method = RequestMethod.PUT)
	public String update( @PathVariable final int num, 
			@RequestParam(value = "usernum") String usernum,
            @RequestParam(value = "username") String username,
            @RequestParam(value = "department") String department,
            @RequestParam(value = "age") int age) {
		

		  User user = new User();
		  user.setAge(age);
		  user.setName(username);
		  user.setNum(Integer.parseInt(usernum)); 
		  user.setTeam(department);
		  user.setCurnum(num);
		 
		logger.info("update({})", user);

		// BoardService의 메소드를 사용해서 게시글을 수정(DB 테이블 수정)
		int result = userService.update(user.getCurnum(), user);
		
		// 게시글 수정 이후에 상세보기 페이지로 이동(redirect)
		return "redirect:/members";
	}
}
