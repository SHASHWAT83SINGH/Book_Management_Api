package com.api.book.upload.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUpload {
	public final String UPLOAD_DIR = "C:\\Users\\SHASHWAT\\Documents\\workspace-spring-tool-suite-4-4.20.0.RELEASE\\bootrestbook\\src\\main\\resources\\static\\image";
    public boolean uploadfile(MultipartFile file)
    {
    	boolean f =false;
    	
    	try
    	{
			/*
			 * InputStream is=file.getInputStream(); byte data[]= new byte [is.available()];
			 * is.read(data); FileOutputStream fos = new
			 * FileOutputStream(UPLOAD_DIR+"\\"+file.getOriginalFilename());
			 * fos.write(data); f=true;
			 */
    		
    		// UPAR WALI CHEEZ KO EK LINE ME BHI LEEKH SAKTE HAI.
    		
    		
    		Files.copy(file.getInputStream(),Paths.get(UPLOAD_DIR + File.separator+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
    		
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return f;
    }
}
