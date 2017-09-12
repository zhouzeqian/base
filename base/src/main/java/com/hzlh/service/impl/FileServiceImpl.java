package com.hzlh.service.impl;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hzlh.base.ResultBase;
import com.hzlh.base.SystemDefined;
import com.hzlh.service.FileService;
@Service
public class FileServiceImpl implements FileService{

	@Override
	public ResultBase<String> upload(MultipartFile[] files) {
		// TODO Auto-generated method stub
		ResultBase<String> rb=new ResultBase<String>();
		rb.setCode(SystemDefined.ResultCode.SUCCESS);
		rb.setMsg("文件上传成功！");
			for(MultipartFile file:files){
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

	@Override
	public ResultBase<String> delete(String fileName) {
		File file=new File("D:/upload/"+fileName);
		ResultBase<String> rb=new ResultBase<String>();
		if(file.exists()){
			file.delete();
			rb.setCode(SystemDefined.ResultCode.SUCCESS);
			rb.setMsg("文件删除成功！");
			return rb;
		}else{
			rb.setCode(SystemDefined.ResultCode.FAILURE);
			rb.setMsg("文件不存在！");
			return rb;
		}
	}

	@Override
	public ResultBase<String> rename(String oldName, String newName) {
		File file=new File("D:/upload/"+oldName);
		ResultBase<String> rb=new ResultBase<String>();
		if(file.exists()){
			file.renameTo(new File("D:/upload/"+newName));
			rb.setCode(SystemDefined.ResultCode.SUCCESS);
			rb.setMsg("文件重命名成功！");
			return rb;
		}else{
			rb.setCode(SystemDefined.ResultCode.FAILURE);
			rb.setMsg("文件不存在！");
			return rb;
		}
	}



}
