package com.mycompany.springframework.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.springframework.dto.Ch07Board;
import com.mycompany.springframework.dto.Ch07JoinForm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch07")
public class Ch07Controller {
	@GetMapping("/request1")
	public ModelAndView request1_modelAndView(Model model) {
		// 데이터 생성
		List<Ch07Board> boardList = new ArrayList<>();
		for(int i = 1; i<=10; i++) {
			boardList.add(new Ch07Board(i,"제목"+i, "봄날이여" + i, "글쓴이"+i, 0, new Date()));
		}
		
		ModelAndView modelAndView = new ModelAndView();
		// request 범위 저장에 boardList 저장
		modelAndView.addObject("boardList",boardList);
		modelAndView.addObject("chNum","ch07");
		//viewName을 저장
		modelAndView.setViewName("ch07/requestData");
		model.addAttribute("chNum","ch07");
		return modelAndView;
	}
	
	@ModelAttribute("jobList") // 모델에 저장하는 다른 방법, 컨트롤러의 모든 메소드가 사용할 수 있는 데이터 이다.
	public List<String> getJobList(){
		List<String> jobList = new ArrayList<>();
		jobList.add("개발자");
		jobList.add("공무원");
		jobList.add("은행원");
		return jobList;
	}
	
	@ModelAttribute("cityList")
	public List<String> getCityList(){
		List<String> cityList = new ArrayList<>();
		cityList.add("서울");
		cityList.add("대전");
		cityList.add("제주");
		return cityList;
	}
		
	
	@GetMapping("/request2") // 이건 메뉴에 a태그에서 오는 요청 방식이다.
	public String request2_dto(Model model) {
		model.addAttribute("chNum","ch07");
		
/*		List<String> jobList = new ArrayList<>();
		jobList.add("개발자");
		jobList.add("공무원");
		jobList.add("은행원");*/
		// 데이터를 직접 만듦
		
		//model.addAttribute("jobList",jobList); // 변수이름을 forEach에 사용
		//model.addAttribute("defaultJob","강도"); jobList에 없는 걸 사용하면 jsp에서 걸러진다.
		// jsp에서 리스트 객체 사용 가능해짐
		
		// 양식에 기본값 세팅하기
		Ch07JoinForm joinForm = new Ch07JoinForm(); //dto객체 생성
		joinForm.setMjob("공무원");// setter사용해서 필드에 값 세팅
		joinForm.setMcity("제주");
		joinForm.setMid("soo");
		model.addAttribute("joinForm", joinForm); // 세팅이 된 객체를 모델에 추가함
		return "ch07/joinForm"; // 모델의 데이터는 이 jsp에서 사용한다.
	}
	
	@PostMapping("/request2") // 요청경로는 위와 같지만 요청 방식이 다르다. 이건 form의 action에서 오는 요청방식이다.
	public String postRequest2(Model model, @ModelAttribute("joinForm") Ch07JoinForm joinForm) {
		// @ModelAttribute("joinForm") Ch07JoinForm joinForm -> 기본적으로 사용할 수 있는 ch07JoinForm이 아닌 joinForm으로 사용하고 싶을 때 사용
		model.addAttribute("chNum","ch07");
		//model.addAttribute("ch07JoinForm", joinForm); dto를 매개변수로 주는것은 이 코드와 같은 역할을 하기에 주석처리해도 사용 가능하다.
		return "ch07/memberInfo";
	}
	
	@GetMapping("/sessionLoginForm")
	public String sessionLoginForm(Model model) {
		model.addAttribute("chNum","ch07");
		return "ch07/loginForm";
	}
	
	@PostMapping("/sessionLogin") //
	public String sessionLogin(Model model, HttpSession session) {
		session.setAttribute("login", "success"); // 세션에 login이름에 success값을 넣어라
		return "redirect:/ch07/sessionLoginForm";
	}
	
	@GetMapping("/sessionLogout")
	public String sessionLogout(Model model, HttpSession session) {
		session.removeAttribute("login"); // 세션에 login이름에 저장된 걸 지워라
		return "redirect:/ch07/sessionLoginForm";
	}
	
	@GetMapping("/application")
	public String application(Model model, HttpServletRequest request) {
		model.addAttribute("chNum","ch07");
		
		//application 범위에서 counter 이름의 값(객체)를 가져오기
		ServletContext application = request.getServletContext();
		Integer counter = (Integer) application.getAttribute("counter");
		
		// 값 (객체) 존재 유무에 따라 처리
		if(counter == null) {
			application.setAttribute("counter", 1); // 값이 없으면 기본 조회수는 1이야
		} else {
			application.setAttribute("counter", 1+counter); // 값이 있으면 기본 조회수에 1을 더해
		}
		
		
		return "ch07/applicationData";
	}

}
