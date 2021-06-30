package com.myweb.orm;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

import javax.inject.Inject;

import org.apache.tika.Tika;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.myweb.domain.FilesVO;
import com.myweb.persistence.files.FilesDAORule;

import net.coobird.thumbnailator.Thumbnails;


@Component
public class FileProcessor { // file size check => orm or handler 에 만들면 됨
	private static Logger logger = LoggerFactory.getLogger(FileProcessor.class);
	
	@Inject
	private FilesDAORule fdao;

	public int upload_file(MultipartFile[] files, int pno) {
		final String UP_DIR = "C:\\_javaweb\\_spring\\workspace\\upload";
		
		// upload/2021/06/28/uuid_fname.jpg => if 이미지 : uuid_th_fname.jpg(이미지면 썸네일도 만듦)
		
		LocalDate date = LocalDate.now(); // w3school > java (오늘 날짜)
		String today = date.toString(); // 2021-06-28
		today = today.replace("-", File.separator); // 2021\\06\\28
		
		File folder = new File(UP_DIR, today);
		
		if(!folder.exists()) folder.mkdirs(); // 계층구조로 만들 땐 mkdirs()를 많이 씀
		
		int isUp = 1;
		
		for (MultipartFile f : files) {
			FilesVO fvo = new FilesVO();
//			today = today.replace("\\","/");
			fvo.setSavedir(today);
			
			String originalFileName = f.getOriginalFilename(); // 원래 filename
			logger.info(">>> originalFileName ? : " +originalFileName);
						
			fvo.setFname(originalFileName);
			
			UUID uuid = UUID.randomUUID(); // 유니크한 값
			fvo.setUuid(uuid.toString());
			
			String fullFileName = uuid.toString() + "_" + originalFileName; // 실제로 만들어진 filename(저장되는 이름)
			File storeFile = new File(folder, fullFileName);
						
			try {
				f.transferTo(storeFile);
				
				if(isImageFile(storeFile)) {
					fvo.setFtype(1); // image면 1 아니면 0(default)
					File thumbnail = new File(folder, uuid.toString()+"_th_"+ originalFileName);
					Thumbnails.of(storeFile).size(100,100).toFile(thumbnail);
				}
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			fvo.setPno(pno);
			isUp *= fdao.insert(fvo);
		}
		return isUp;
	}

	private boolean isImageFile(File storeFile) {
		try {
			String mimeType = new Tika().detect(storeFile);
			return mimeType.startsWith("image") ? true : false; // mimeType가 image로 시작?
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public int deleteFile(String uuid) {
		return fdao.delete(uuid);
	}
}
