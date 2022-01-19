package com.dwav;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.dwav.dao.ImageDAO;
import com.dwav.vo.ImageVO;


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
								   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class ImageTest {
	final Logger  LOG = LogManager.getLogger(getClass());
	
	@Autowired
	ImageDAO idao;
	
	@Test
	public void test1() {
		LOG.debug("addImage() INSERTED ROWS : " + idao.addImage(new ImageVO(1, "Path/to/image2.png")));
	}
	@Test
	public void test2() {
		List<ImageVO> imgList = new ArrayList<>();
		imgList.add(new ImageVO(1, "my/path/to/dest"));
		imgList.add(new ImageVO(1, "Test/path"));
		LOG.debug("addImageList() INSERTED ROWS : " + idao.addImageList(imgList));
	}
	
	
	@Test
	public void test3() {
		LOG.debug("getImageList() Result : ");
		List<ImageVO> imageList = idao.getImageByAccomId(1);
		for (ImageVO imageVO : imageList) {
			LOG.debug(imageVO);
		}
	}
	
	
	@Test
	public void test4() {
		LOG.debug("deleteImageByImageId() AFFECTED ROWS :  : " +  idao.deleteImageByImageId(1));
	}

}
