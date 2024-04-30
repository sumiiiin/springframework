package com.mycompany.springframework.controller;

import java.util.Date;


import org.json.JSONObject;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.springframework.dto.Ch03Dto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch03")
public class Ch03Controller {
	@RequestMapping("/receiveParamData")
	public String receiveMethodData(
			String param1,
			String param2,
			String param3,
			String param4,
			String param5,
			String param6,
			Model model) {
		
		log.info("실행");
		log.info("param1: "+param1); //변수를 잘 받아온걸 확인 함
		log.info("param2: "+param2); // +연산자 사용해야 나옴...당연함 이건 java임
		log.info("param3: "+param3);
		log.info("param4: "+param4);
		log.info("param5: "+param5);
		log.info("param6: "+param6); // 값이 없을 경우 서버에서는 null로 표시 된다.
		model.addAttribute("param1",param1); // 앞의 문자열을 파라미터의 이름 뒤의 변수의 값을 파라미터의 값으로 사용한다.
		model.addAttribute("param2",param2);
		model.addAttribute("param3",param3);
		model.addAttribute("param4",param4);
		model.addAttribute("param5",param5);
		model.addAttribute("param6",param6);
		model.addAttribute("chNum","ch03");
		return"ch03/receiveParamData";
	}
	
	@GetMapping("/postMethodForm")
	public String postMethodForm(Model model) {
		model.addAttribute("chNum","ch03");
		return "ch03/postMethodForm";
	}
	@RequestMapping("/requestParamAnnotatoin")
	public String requestParamAnnotatoin(
			@RequestParam(value="param1") String arg1, // 파라미터 이름이 다르게 넘어왔을 때 매핑하기
			@RequestParam(value="param2") String arg2, 
			@RequestParam("param3") String arg3,
			@RequestParam("param4") String arg4,
			@RequestParam("param5") String arg5,
			Model model) {
	
		model.addAttribute("param1",arg1); // 앞의 문자열을 파라미터의 이름 뒤의 변수의 값을 파라미터의 값으로 사용한다.
		model.addAttribute("param2",arg2);
		model.addAttribute("param3",arg3);
		model.addAttribute("param4",arg4);
		model.addAttribute("param5",arg5);
		model.addAttribute("chNum","ch03");
		return"ch03/receiveParamData";
	}
	
	@RequestMapping("/requestParamAnnotatoinRequired")
	public String requestParamAnnotatoinRequired(

			@RequestParam(required=true) String param1, // required가 true면 이 매개변수는 꼭 받아와야 한다. 안가져오면 메소드 호출 시 서버에서 오류남 
			String param2,
			String param3,
			String param4,
			String param5,
			String param6,
			Model model) {
		
		model.addAttribute("param1",param1); // 앞의 문자열을 파라미터의 이름 뒤의 변수의 값을 파라미터의 값으로 사용한다.
		model.addAttribute("param2",param2);
		model.addAttribute("param3",param3);
		model.addAttribute("param4",param4);
		model.addAttribute("param5",param5);
		model.addAttribute("param6",param6);
		model.addAttribute("chNum","ch03");
		return"ch03/receiveParamData";
	}
	
	@RequestMapping("/requestParamAnnotatoinDefaultValue")
	public String requestParamAnnotatoinDefaultValue(

			String param1,
			String param2,
			String param3,
			String param4,
			String param5,
			@RequestParam(defaultValue="기본값") String param6, // 값이 없을 경우 기본적으로 넣는 값
			Model model) {
		
		model.addAttribute("param1",param1); // 앞의 문자열을 파라미터의 이름 뒤의 변수의 값을 파라미터의 값으로 사용한다.
		model.addAttribute("param2",param2);
		model.addAttribute("param3",param3);
		model.addAttribute("param4",param4);
		model.addAttribute("param5",param5);
		model.addAttribute("param6",param6);
		model.addAttribute("chNum","ch03");
		return"ch03/receiveParamData";
	}
	
	@RequestMapping("/typeChange")
	public String typeChange(

			String param1,
			int param2, // 알맞은 데이터 타입을 앞에 선언하면 문제 없지만 타입변환도 안되는거 들어오면 400에러가 난다. 
			double param3, 
			boolean param4,
			@DateTimeFormat(pattern="yyyy-MM-dd") Date param5, // 그냥 Date로 하면 안 뜬다.DateTimeFormat으로 해줘야 뜬다. 
			//int param6, // 값이 없는데 int로 하면 500오류뜬다 근데 String으로 할 때는 null뜨고오류도 안났는데...
			@RequestParam(defaultValue="0") int param6, // 그래서 값이 넘어오지 않는데 int로 받고 싶다면 기본값을 지정해 주어야 한다.
			Model model) {
		
		model.addAttribute("param1",param1); // 앞의 문자열을 파라미터의 이름 뒤의 변수의 값을 파라미터의 값으로 사용한다.
		model.addAttribute("param2",param2);
		model.addAttribute("param3",param3);
		model.addAttribute("param4",param4);
		model.addAttribute("param5",param5);
		model.addAttribute("param6",param6);
		model.addAttribute("chNum","ch03");
		return"ch03/receiveParamData";
	}
	
	@RequestMapping("/getDto")
	public String getDto(@ModelAttribute("dto") Ch03Dto dto, Model model) {
		model.addAttribute("chNum","ch03"); // 객체는 모델에 추가 안해도 된다.
		log.info("실행");
		log.info("param1" + dto.getParam1());
		log.info("param2" + dto.getParam2());
		log.info("param3" + dto.getParam3());
		log.info("param4" + dto.isParam4());
		log.info("param5" + dto.getParam5());
		return"ch03/getDto";
	}
	
	@GetMapping("/ajax")
	public String ajax(Model modle) {
		modle.addAttribute("chNum","ch03");
		return "ch03/ajax";
	}
	
	@PostMapping(value="/getAjaxParams",
				produces="application/json; charset=UTF-8")
	@ResponseBody
	public String getAjaxParams(Ch03Dto dto) {
		JSONObject jsonobject = new JSONObject(); // ajax에 function data만든다?
		jsonobject.put("param1", dto.getParam1());
		jsonobject.put("param2", dto.getParam2());
		jsonobject.put("param3", dto.getParam3());
		jsonobject.put("param4", dto.isParam4());
		jsonobject.put("param51", dto.getParam5());
		return jsonobject.toString();
	}

}
