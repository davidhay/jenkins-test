package com.ealanta;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("web")
public class Controller {
	
	private @Value("git.commit.id") String gitCommitId;
	private @Value("git.commit.message.full") String gitCommitMessage;
	
	@RequestMapping("/hello/{name}")
	@ResponseBody
	public String hello(@PathVariable("name") String name) {
		if(name == null || name.length() == 0) {
			name = "Anonymous";
		}
		return "Hello "+name;
	}
	
	@RequestMapping("/info")
	@ResponseBody
	public String info() {
		return "001";
	}
	
	@RequestMapping("/git")
	@ResponseBody
	public Map<String,String> gitinfo() {
		Map<String,String> result = new HashMap<>();
		result.put("id", this.gitCommitId);
		result.put("message", this.gitCommitMessage);
		return result;
	}
}
