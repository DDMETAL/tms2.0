package com.dmetal.tms.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	/**首页控制器*/
	@RequestMapping("indexUI")
	public String indexUI() {
		return "index";
	}
}
