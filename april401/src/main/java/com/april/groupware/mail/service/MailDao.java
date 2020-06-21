package com.april.groupware.mail.service;

import java.util.List;

import com.april.groupware.cmn.DTO;

public interface MailDao {

	/**
	 * 등록
	 * @param dto
	 * @return int
	 */
	public int doInsert(DTO dto);
	
	/**
	 * 수정   
	 * @param dto
	 * @return int
	 */
	public int doUpdate(DTO dto);
	
	/**
	 * disable 수정   
	 * @param dto
	 * @return int
	 */
	public int doUpdateDisable(DTO dto);
	
	/**
	 * read 수정   
	 * @param dto
	 * @return int
	 */
	public int doUpdateRead(DTO dto);
	
	/**
	 * 단건조회
	 * @param dto
	 * @return DTO
	 */
	public DTO doSelectOne(DTO dto);
	
	/**
	 * ORGANIZATION 테이블에서 Id 조회
	 * @param dto
	 * @return
	 */
	public DTO doSelectUserId(DTO dto);
	
	/**
	 * ORGANIZATION 테이블에서 Image 조회
	 * @param dto
	 * @return
	 */
	public DTO doSelectImage(DTO dto);
	
	/**
	 * 삭제
	 * @param dto
	 * @return int
	 */
	public int doDelete(DTO dto);
	
	/**
	 * 받은 메일 목록조회
	 * @param dto
	 * @return
	 */
	public List<?> doRetrieve(DTO dto);
	
	/**
	 * 보낸 메일 목록조회
	 * @param dto
	 * @return
	 */
	public List<?> doRetrieveSent(DTO dto);
	
	/**
	 * 휴지통 목록조회
	 * @param dto
	 * @return
	 */
	public List<?> doRetrieveTrash(DTO dto);
	   
	/**
	 * 전체 조회
	 * @param dto
	 * @return
	 */
	public List<?> getAll(DTO dto);
	
	/**
	 * 전체 조회 Count
	 * @param dto
	 * @return
	 */
	public int getAllCount(DTO dto);	   
}
