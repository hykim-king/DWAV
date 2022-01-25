package com.dwav.ServiceImpl;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD

=======
import com.dwav.dao.HomeDao;
>>>>>>> 130ebcfb197275a9f3e0dc0e667afae0bfb27a2d
import com.dwav.dao.ImageDao;
import com.dwav.service.ImageService;
import com.dwav.vo.ImageVO;


@Service
public class ImageServiceImpl implements ImageService {

final Logger LOG = LogManager.getLogger(getClass());
	
	
	@Autowired
	ImageService imageService;
	
	
	@Override
	public ImageVO SelectImg(ImageVO inVO) throws SQLException {
		
		return imageService.SelectImg(inVO);
	}


	@Override
	public int InsertImg(ImageVO inVO) throws SQLException {
		
		return imageService.InsertImg(inVO);
	}

	@Override
	public int DeleteImg(ImageVO inVO) throws SQLException {
		
		return imageService.DeleteImg(inVO);
	}





	


}
