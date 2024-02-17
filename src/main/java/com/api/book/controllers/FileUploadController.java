package com.api.book.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.book.upload.helper.FileUpload;

@RestController
public class FileUploadController {
	@Autowired
	private FileUpload fileupload;

	@PostMapping("/upload")
	public ResponseEntity<String> uploadfile(@RequestParam("file") MultipartFile file)
	{
		/*
		 * System.out.println(file.getOriginalFilename());
		 * System.out.println(file.getSize());
		 * System.out.println(file.getContentType());
		 * System.out.println(file.getName());
		 */
		 
		try
		{
			
			  if(file.isEmpty()) { return
			  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file"); }
			  if(file.getContentType().equals("image/jpeg")) 
			  { 
				return
			  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("only jpeg content type are allow"); }
			 
		
		//NOW FILE UPLOAD CODE
		boolean f=fileupload.uploadfile(file);
		if(f)
		{
			return ResponseEntity.ok("file is succesfully uploaded");
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong plz try again");
	}
}
