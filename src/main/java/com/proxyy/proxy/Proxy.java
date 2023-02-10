package com.proxyy.proxy;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import net.minidev.json.JSONObject;

@Controller
@ResponseBody
@RequestMapping("/ProxyService")
public class Proxy {
	
	@Autowired
	RestTemplate template;
	
	@PostMapping("/testData")
	public String apllyRegExOnData(@RequestBody String filePolicy) throws IOException, InterruptedException {
		Thread.sleep(1000);
		JSONObject obj = new JSONObject();
		obj.put("filePath", "D:\\FIleBuffer\\Default SSN Renamed.pdf");
		  List<String> data = new ArrayList<String>();
		  data.add("(?s)(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}");
		  data.add("^6[0-9]{15}$");
		  obj.put("regEx", data);
		  System.out.println("Sending Extraction and token instruction to content master for :"+obj);
		   JSONObject json111 = template.postForObject("http://localhost:8080/contentMaster/processFile", obj, JSONObject.class);
		   System.out.println("Got the response from contentMaster : "+json111);
		   
		   Thread.currentThread().sleep(7000);
		   
		   json111 = template.postForObject("http://localhost:8080/contentMaster/processFile", obj, JSONObject.class);
		   System.out.println("Got the response from contentMaster : "+json111);
		   
		   
		   Thread.currentThread().sleep(8000);
		   
		   json111 = template.postForObject("http://localhost:8080/contentMaster/processFile", obj, JSONObject.class);
		   System.out.println("Got the response from contentMaster : "+json111);
		return null;
	}

}
