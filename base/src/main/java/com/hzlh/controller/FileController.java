package com.hzlh.controller;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hzlh.base.ResultBase;
import com.hzlh.service.FileService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(description = "文件上传下载")
@RequestMapping(value = "/file")
public class FileController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private FileService flieService;

	@ApiOperation(value = "文件上传", notes = "文件上传")
	@RequestMapping(value = "upload", method = RequestMethod.POST)

	public ResultBase<String> upload(
			@ApiParam(name = "files", value = "files") @RequestParam(value = "files", required = true) MultipartFile files) {
		MultipartFile[] cmf = new MultipartFile[] { files };
		return flieService.upload(cmf);
	}

	@ApiOperation(value = "文件列表", notes = "文件列表")
	@RequestMapping(value = "list", method = RequestMethod.POST)

	public ResultBase<String[]> list() {

		return flieService.list();
	}

	@ApiOperation(value = "文件下载", notes = "文件下载")
	@RequestMapping(value = "down", method = RequestMethod.GET)

	public ResponseEntity<byte[]> down(
			@ApiParam(name = "fileName", value = "文件名") @RequestParam(value = "fileName") String fileName) {
		log.info("文件名:" + fileName);
		File file = new File("D:/upload/" + fileName);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentDispositionFormData("attachment", fileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		ResponseEntity<byte[]> entity = null;
		try {
			entity = new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return entity;
	}

	@ApiOperation(value = "文件删除", notes = "文件删除")
	@RequestMapping(value = "delete", method = RequestMethod.POST)

	public ResultBase<String> delete(
			@ApiParam(name = "fileName", value = "文件名") @RequestParam(value = "fileName") String fileName) {

		return flieService.delete(fileName);
	}

	@ApiOperation(value = "文件重命名", notes = "文件重命名")
	@RequestMapping(value = "rename", method = RequestMethod.POST)

	public ResultBase<String> rename(
			@ApiParam(name = "oldName", value = "旧文件名") @RequestParam(value = "oldName") String oldName,
			@ApiParam(name = "newName", value = "新文件名") @RequestParam(value = "newName") String newName) {

		return flieService.rename(oldName, newName);
	}
}
