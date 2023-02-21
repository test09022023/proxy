package com.proxyy.proxy;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/lookoutwebhook")
public class TestWebHook {
	
	
	////testing push
	
	@PostMapping("/readEvent")
	public String apllyRegExOnData(@RequestBody String filePolicy,@RequestHeader(value="X-GitHub-Event") String userAgent,@RequestHeader Map<String, String> headers) throws IOException, InterruptedException {
		System.out.println(userAgent+ " ::: "+filePolicy);
		//commenting following sysout
		//System.out.println("Headers"+ " ::: "+headers);
		return "";
	}
}
