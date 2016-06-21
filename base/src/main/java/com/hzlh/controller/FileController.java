package com.hzlh.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.hzlh.base.ResultBase;
import com.hzlh.service.FileService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@RestController
@Api(value="FileController",description="文件上传下载测试")
@RequestMapping(value="/file")
public class FileController {
	@Autowired
	private FileService flieService;
	
	@ApiOperation(value="文件上传",notes="文件上传")
	@RequestMapping(value="upload",method=RequestMethod.POST)
	
	public ResultBase<String> upload(
			@ApiParam(name="files",value="files") @RequestParam(value="files") CommonsMultipartFile files){
		CommonsMultipartFile[] cmf=new CommonsMultipartFile[]{files};
		return flieService.upload(cmf);
	}
	
	@ApiOperation(value="文件列表",notes="文件列表")
	@RequestMapping(value="list",method=RequestMethod.POST)
	
	public ResultBase<String[]> list(){
		
		return flieService.list();
	}
	
	@ApiOperation(value="文件下载",notes="文件下载")
	@RequestMapping(value="down",method=RequestMethod.GET)
	
	public ResponseEntity<byte[]> down(
			@ApiParam(name="fileName",value="文件名") @RequestParam(value="fileName") String fileName){
		File file=new File("D:/upload/"+fileName);  
		HttpHeaders headers = new HttpHeaders();    
        
        try {
			headers.setContentDispositionFormData("attachment", new String(fileName.getBytes("UTF-8"), "ISO8859-1"));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}   
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM); 
        ResponseEntity<byte[]> entity = null;
		try {
			entity = new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
			        headers, HttpStatus.CREATED);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return entity;
	}
}
