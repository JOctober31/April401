package com.april.groupware.chat.service;

import java.util.List;

import com.april.groupware.cmn.DTO;

public interface ChatDao {
 

	/**
	 * 단건조회
	 * @param dto
	 * @return DTO
	 */
	public DTO doSelectOne(DTO dto);
	 
	
	/**
	 * 목록조회
	 * @param dto
	 * @return DTO
	 */
	public List<?> doRetrieve(DTO dto);
	   
	/**
	 * 전체 조회
	 * @param dto
	 * @return DTO
	 */
	public List<?> getAll(DTO dto);


	/**
	 * 데이터 추가:테스트용
	 * @param dto
	 * @return DTO
	 */
	public int doInsert(DTO dto);
}
