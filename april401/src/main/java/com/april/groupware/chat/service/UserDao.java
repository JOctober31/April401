package com.april.groupware.chat.service;

import java.util.List;

import com.april.groupware.cmn.DTO;

public interface UserDao {


	/**
	 * 단건조회
	 * @param dto
	 * @return DTO
	 */
	public DTO doSelectOne(DTO dto);
	 
	
	/**
	 * 목록조회
	 * @param dto
	 * @return
	 */
	public List<?> doRetrieve(DTO dto);
	   
	/**
	 * 전체 조회
	 * @param dto
	 * @return
	 */
	public List<?> getAll(DTO dto);


	/**
	 * 데이터 추가:테스트용
	 * @param dto
	 * @return
	 */
	public int doInsert(DTO dto);
}
