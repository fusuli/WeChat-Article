package org.fusu.wechat.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author fusuli
 *
 */
@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello(Map<String, Object> map) {
		map.put("name", "[Angel -- 守护天使]");
		return "hello";
	}
}
