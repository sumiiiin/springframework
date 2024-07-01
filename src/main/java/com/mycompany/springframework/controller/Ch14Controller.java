package com.mycompany.springframework.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springframework.aspect.LoginCheck;
import com.mycompany.springframework.aspect.RuntimeCheck;
import com.mycompany.springframework.dto.Ch13Board;
import com.mycompany.springframework.dto.Ch13Pager;
import com.mycompany.springframework.service.Ch13Service;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/ch14")
public class Ch14Controller { 
	@GetMapping("/adviceKind")
	public String adviceKind(Model model) {
		model.addAttribute("chNum","ch14");
		return "ch14/adviceKind";
	}
   @RequestMapping("/before")
   public String before(Model model) {
      log.info("실행");
      model.addAttribute("chNum", "ch14");
      return "redirect:/ch14/adviceKind";
   }
   
   @RequestMapping("/after")
   public String after(Model model) {
      log.info("실행");
      model.addAttribute("chNum", "ch14");
      return "redirect:/ch14/adviceKind";
   }
   
   @RequestMapping("/afterReturning")
   public String afterReturning(Model model) {
      log.info("실행");
      model.addAttribute("chNum", "ch14");
      return "redirect:/ch14/adviceKind";
   }
   
   @RequestMapping("/afterThrowing")
   public String afterThrowing(Model model) {
      log.info("실행");
      model.addAttribute("chNum", "ch14");
      boolean result = true;
      if(result) {
         throw new RuntimeException("예외가 발생한 이유");
      }
      return "redirect:/ch14/adviceKind";
   }
   
   @RequestMapping("/around")
   public String around(Model model) {
      log.info("실행");
      model.addAttribute("chNum", "ch14");
      return "redirect:/ch14/adviceKind";
   }
   
   @RequestMapping("/loginCheck")
   @LoginCheck // 로그인이 되어 있어야 메소드 실행하고 안되어 있으면 로그인 폼으로 이동
   public String loginCheck(Model model) {
      log.info("실행");
      model.addAttribute("chNum", "ch14");
      return "ch14/loginCheck";
   }   
   
   @Autowired
   private Ch13Service ch13Service;
   
   @RequestMapping("/runtimeCheck")
   @RuntimeCheck // 메소드가 실행되는 시간을 체크
   public String runtimeCheck(Model model) {
      log.info("실행");
      int totalRows = ch13Service.getTotalRows();
      Ch13Pager pager = new Ch13Pager(5, 5, totalRows, 1);      
      List<Ch13Board> list = ch13Service.getBoardList(pager);
      model.addAttribute("chNum", "ch14");
      return "ch14/runtimeCheck";
   }
}
