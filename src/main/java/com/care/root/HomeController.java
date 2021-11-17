
package com.care.root;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@GetMapping("getuser")
	public String getUser() {
		return "getuser";
	}

	@GetMapping("rest01")
	public String rest01() {
		return "rest01";
	}

	@GetMapping("non_ajax")
	public String nonAjax() {
		System.out.println("non ajax 실행!!!");
		return "non_ajax";
	}

	@GetMapping("ajax")
	public String ajax() {
		System.out.println("ajax 실행!!!");
		return "ajax";
	}

	static int cnt = 0;

	@GetMapping("ajax_result")
	@ResponseBody
	public String ajaxResult() {
		// System.out.println(1 + "안녕"); => 1안녕
		return ++cnt + "";
	}

	@GetMapping("ajax01")
	public String ajax01() {
		return "ajax01";
	}

	@PostMapping(value = "ajax_result01", produces = "application/json; charset=utf-8")
	@ResponseBody
	// public InfoDTO ajaxResult01(@RequestBody InfoDTO dto) {
	public Map<String, Object> ajaxResult01(@RequestBody Map<String, Object> dto) {
		System.out.println("이름 : " + dto.get("name"));
		System.out.println("나이 : " + dto.get("age"));
		System.out.println("주소 : " + dto.get("addr"));
		return dto;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

}