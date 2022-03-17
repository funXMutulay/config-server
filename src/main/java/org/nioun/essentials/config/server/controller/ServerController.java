package org.nioun.essentials.config.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ServerController {
	
	@RequestMapping(value={"/","/index","/home"})
	public String index() {
		return "index";
	}
	
	
}
