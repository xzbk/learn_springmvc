package com.group.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传controller
 * @author Administrator
 *
 */
@Controller
public class FileUploadController {
	/**
	 * 文件上传
	 * @return
	 */
	@RequestMapping("/upload")
	public String upload(String username,MultipartFile file) {
		String originalFilename = file.getOriginalFilename();
		System.out.println(originalFilename);
		try {
			file.transferTo(new File("F:/"+originalFilename));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
}
