package com.jinkuangkj.open.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@Controller
@RequestMapping("component")
public class ComponentController {
	
	
	@Value("${spring.servlet.multipart.location}")
    private String uploadPicturePath;
	
	@javax.annotation.Resource
	private ResourceLoader resourceLoader;
	
	@ResponseBody
	@RequestMapping("upload")
	public Map<String,Object> upload(@RequestParam("file") MultipartFile multipartFile) {
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			String fileName = multipartFile.getOriginalFilename();
			String fileTyle=fileName.substring(multipartFile.getOriginalFilename().lastIndexOf("."),fileName.length());
			String newName = String.valueOf(System.currentTimeMillis()) + fileTyle;
			File file = new File(newName);
			multipartFile.transferTo(file);
			map.put("code", true);
			map.put("msg", "上传成功");
			map.put("value", "/component/"+newName);
		} catch (IOException e) {
			log.error("上传图片错误:{}",e);
			map.put("code", false);
			map.put("value", "上传失败");
		}
		return map;
	}
	
	
	@ResponseBody
	@RequestMapping("/{fileName:.+}")
    public ResponseEntity<Resource> show(@PathVariable String fileName){
        try
		{
    		//resourceLoader.getResource("file:" + uploadPicturePath + fileName) 返回指定路径的资源句柄，这里返回的就是URL [file:D:/springboot/upload/test.png]
    		//ResponseEntity.ok(T) 返回指定内容主体
        	log.info("下载文件:{}",fileName);
        	return ResponseEntity.ok(resourceLoader.getResource("file:" + uploadPicturePath +"/" + fileName));
		} catch (Exception e) {
   	 		return ResponseEntity.notFound().build();
		}
    }

	@RequestMapping("index")
	public String getUpload() {
		return "admin/upload/index";
	}
	
	@RequestMapping("img")
	public String img() {
		return "admin/upload/img";
	}

}
