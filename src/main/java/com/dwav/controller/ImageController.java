package com.dwav.controller;

<<<<<<< HEAD
import java.sql.SQLException;
=======
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
>>>>>>> 130ebcfb197275a9f3e0dc0e667afae0bfb27a2d

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.ResponseBody;

import com.dwav.cmn.MessageVO;
import com.dwav.service.ImageService;
import com.dwav.vo.HomeVO;
import com.dwav.vo.ImageVO;

=======
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.dwav.cmn.MessageVO;
import com.dwav.service.ImageService;
import com.dwav.vo.FileVO;
import com.dwav.vo.HomeVO;
import com.dwav.vo.ImageVO;

import com.dwav.vo.StringUtil;
>>>>>>> 130ebcfb197275a9f3e0dc0e667afae0bfb27a2d
import com.google.gson.Gson;



<<<<<<< HEAD
=======

>>>>>>> 130ebcfb197275a9f3e0dc0e667afae0bfb27a2d
@Controller("ImageController")
@RequestMapping("image")
public class ImageController {

	final Logger LOG = LogManager.getFormatterLogger(getClass());
	final String VIEW_NAME = "image/image_mng";
	
	@Autowired
	ImageService imageService;
	
	ImageController(){}
	
	
	@RequestMapping(value = "/json_view",method = RequestMethod.GET)
	public String jsonView(Model model)throws SQLException{
		
		return "json/json_view";
	}
	
	@RequestMapping(value ="/DeleteHome.do", method= RequestMethod.GET
			,produces = "application/json;charset=UTF-8")
    @ResponseBody	//스프링에서 비동기 처리를 하는 경우,HTTP 요청의 분문 body 부분이 그대로 전달된다.
	public String DeleteImg(ImageVO inVO)throws SQLException{
		LOG.debug("=========================");
		LOG.debug("=inVO="+inVO);
		LOG.debug("=========================");
		
		String resultMsg = "";
		
		int flag = imageService.DeleteImg(inVO);
		
		if(1==flag) {
			resultMsg = inVO.getImage_id()+"가 삭제 되었습니다.";
		}else {
			resultMsg = "삭제 실패";
		}
		
		MessageVO message=new MessageVO(flag+"", resultMsg);
		
		Gson gson=new Gson();
		
		String jsonString = gson.toJson(message);
		LOG.debug("=jsonString=\n"+jsonString);
		
		return jsonString;
	}

	@RequestMapping(value="/SelectHome.do" ,method = RequestMethod.GET
			,produces = "application/json;charset=UTF-8")
	@ResponseBody //스프링에서 비동기 처리를 하는 경우,HTTP 요청의 분문 body 부분이 그대로 전달된다.	
	public String SelectImg(ImageVO inVO) throws SQLException{
		LOG.debug("=========================");
		LOG.debug("=inVO="+inVO);
		LOG.debug("=========================");	
		
		ImageVO outVO = imageService.SelectImg(inVO);
		LOG.debug("=========================");
		LOG.debug("=outVO="+outVO);
		LOG.debug("=========================");
		
		Gson gson=new Gson();
		String jsonString = gson.toJson(outVO);
		LOG.debug("=========================");
		LOG.debug("=jsonString="+jsonString);
		LOG.debug("=========================");		
		return jsonString;
	} 
	
	
	@RequestMapping(value="/InsertHome.do" ,method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody //스프링에서 비동기 처리를 하는 경우,HTTP 요청의 분문 body 부분이 그대로 전달된다.
	public String InsertHome(ImageVO inVO) throws SQLException {
		LOG.debug("=========================");
		LOG.debug("=inVO="+inVO);
		LOG.debug("=========================");		
		String resultMsg = "";
		
		int flag = imageService.InsertImg(inVO);
		
		if(1==flag) {
			resultMsg = inVO.getImage_id()+"가 등록 되었습니다.";
		}else {
			resultMsg = "등록 실패";
		}		
		
		MessageVO message=new MessageVO(flag+"", resultMsg);
		
		Gson gson=new Gson();
		
		String jsonString = gson.toJson(message);
		LOG.debug("=jsonString=\n"+jsonString);
		
		return jsonString;		
		
	}
	
<<<<<<< HEAD
=======
	//image file save path
    final String IMG_PATH = "D:\\RPA_20210928\\04_SPRING\\project\\DWAV\\src\\main\\webapp\\resources\\upload_img";
    //final String IMG_PATH = "D:\\RPA_20210928\\04_SPRING\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\SW_HR13_01\\resources\\upload_img";
    
   
  
    
	//http://localhost:8080/ehr/file/file_view.do
	@RequestMapping(value = "/file_view.do")
	public String fileView() {
		LOG.debug("====================");
		LOG.debug("=fileView()=");
		LOG.debug("====================");		
		
		return "file/file_upload";
	}
	
	@RequestMapping(value="/upload.do",method = RequestMethod.POST)
	public ModelAndView  upload(MultipartHttpServletRequest  mReg, ModelAndView  modelAndView) 
			throws IllegalStateException,IOException{
		LOG.debug("====================");
		LOG.debug("=upload()=");
		LOG.debug("====================");		
		
		//동적 폴더 생성
		File imgRootDir = new File(IMG_PATH);
		if(imgRootDir.isDirectory() ==false) {
			imgRootDir.mkdir();
			LOG.debug("=imgRootDir 생성=");
		}
		
		
		String title = StringUtil.nvl(mReg.getParameter("title"),"");
		String fileDiv = mReg.getParameter("file_div");
		LOG.debug("title="+title);
		LOG.debug("fileDiv="+fileDiv);
		
		List<FileVO> list = new ArrayList<>();
		
		Iterator<String> files = mReg.getFileNames();
		while( files.hasNext()) {
			FileVO  fileVO=new FileVO();
			
			
			String upFilNm = files.next();
			LOG.debug("upFilNm="+upFilNm);
			
			MultipartFile mFile = mReg.getFile(upFilNm);
			//원본파일명
			String orgFileNm = mFile.getOriginalFilename();
			LOG.debug("orgFileNm="+orgFileNm);
			
			//파일이 없는 경우
			if(null == orgFileNm || "".equals(orgFileNm)) {
				continue;
			}
			//저장파일명
			//yyyyMMddHH24mmss+UUID
			String saveFileName = StringUtil.getRenameFile("yyyyMMddHH24mmss");
			
			//확장자:  pom.xml
			String ext = "";
			
			if(orgFileNm.lastIndexOf(".")>-1) {
				ext = orgFileNm.substring(orgFileNm.lastIndexOf(".")+1);
				saveFileName+="."+ext;
			}
			LOG.debug("saveFileName="+saveFileName);
			
			//파일사이즈
			long fileSize = mFile.getSize();//bytes.
			String savePath = "";
			
			if("20".equals(fileDiv)) {//img
				savePath = IMG_PATH;
			}
			
			fileVO.setOrgFileNm(orgFileNm);//원본 파일명
			fileVO.setSaveFileNm(saveFileName);//저장파일명
			fileVO.setFileSize(fileSize);//파일 사이즈
			fileVO.setExt(ext);//확장자
			fileVO.setSavePath(savePath);//저장경로
			LOG.debug("fileVO="+fileVO);
			list.add(fileVO);
			
			
			File  renameFile = new File(savePath,fileVO.getSaveFileNm());
			//file서버에 저장
			mFile.transferTo(renameFile);
			
			
		}//--while
		
		
		
		modelAndView.addObject("list", list);
		modelAndView.setViewName("file/file_upload");
		return modelAndView;
	}
	
	
	
	
	
	
	
	
	

	
	
>>>>>>> 130ebcfb197275a9f3e0dc0e667afae0bfb27a2d
	
}
