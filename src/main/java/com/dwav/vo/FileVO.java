/**
 * package: com.pcwk.ehr.cmn
 * file name: FileVO.java
 * description: 파일 VO
 * user: HKEDU
 * create date: 2022-01-18
 * version: 0.5
 * Copyright (c) by PCWK All right reserved.
 * Modification Information
 * 수정일   수정자    수정내용
 *-----------------------------------------------------
 * 2022-01-18 최초생성
 *-----------------------------------------------------
 */
package com.dwav.vo;

/**
 * @author HKEDU
 *
 */
public class FileVO extends DTO {
	/** 원본파일명 */
	private String orgFileNm;

	/** 저장파일명 */
	private String saveFileNm;

	/** 파일사이즈 */
	private long fileSize;

	/** 확장자 */
	private String ext;

	/** 저장경로 */
	private String savePath;

	public FileVO() {
	}

	public String getOrgFileNm() {
		return orgFileNm;
	}

	public void setOrgFileNm(String orgFileNm) {
		this.orgFileNm = orgFileNm;
	}

	public String getSaveFileNm() {
		return saveFileNm;
	}

	public void setSaveFileNm(String saveFileNm) {
		this.saveFileNm = saveFileNm;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	@Override
	public String toString() {
		return "FileVO [orgFileNm=" + orgFileNm + ", saveFileNm=" + saveFileNm + ", fileSize=" + fileSize + ", ext="
				+ ext + ", savePath=" + savePath + ", toString()=" + super.toString() + "]";
	}
	
	
	

}
