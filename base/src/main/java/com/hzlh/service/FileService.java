package com.hzlh.service;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.hzlh.base.ResultBase;

public interface FileService {

	public ResultBase<String> upload(CommonsMultipartFile[] files);
	
	public ResultBase<String[]> list();
	
}
