package com.hzlh.service.impl;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.hzlh.base.ResultBase;
import com.hzlh.base.SystemDefined;
import com.hzlh.service.FileService;
@Service
public class FileServiceImpl implements FileService{

	@Override
	public ResultBase<String> upload(CommonsMultipartFile[] files) {
		// TODO Auto-generated method stub
		ResultBase<String> rb=new ResultBase<String>();
		rb.setCode(SystemDefined.ResultCode.SUCCESS);
		rb.setMsg("文件上传成功！");
			for(CommonsMultipartFile file:files){
				File f=new File("D:/upload/"+file.getOriginalFilename());
				try {
					file.transferTo(f);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}

		return rb;
	}

	@Override
	public ResultBase<String[]> list() {
		File file=new File("D:/upload");
		if(!file.exists())
			file.mkdir();
		ResultBase<String[]> rb=new ResultBase<String[]>();
		rb.setObj(file.list());
		rb.setCode(SystemDefined.ResultCode.SUCCESS);
		rb.setMsg("获取文件列表成功！");
		return rb;
	}



}
