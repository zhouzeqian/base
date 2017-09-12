package com.hzlh.service;

import org.springframework.web.multipart.MultipartFile;

import com.hzlh.base.ResultBase;

public interface FileService {

	public ResultBase<String> upload(MultipartFile[] files);
	
	public ResultBase<String[]> list();
	
	public ResultBase<String> delete(String fileName);
	
	public ResultBase<String> rename(String oldName,String newName);

	
}
