package net.org.myinfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/")
	String index() {
		return "index";
	}
	 
	@RequestMapping(value = "page/{id}")
	public String getState(@PathVariable String id) {
		System.out.println("call success");
		switch (id) {
		case "ataglance":
			return "ataglance";
		case "attraction":
			return "attraction";
		case "emergency":
			return "emergency";
		case "govtoffices":
			return "govtoffices";
		case "about":
			return "About";
	 	case "gallery":
			return "Gallery";
		default:
			break;
		}
		return "ataglance";
	}
}