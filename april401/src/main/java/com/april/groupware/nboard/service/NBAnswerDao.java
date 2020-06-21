/**
 * 
 */
package com.april.groupware.nboard.service;

import java.util.List;

import com.april.groupware.cmn.DTO;


/**
 * @author 양은영
 *
 */
public interface NBAnswerDao {

	/**
	* Cnt증가
	* @param dto
	* @return int
	*/
	public int doUpdateReadCnt(DTO dto);
	
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
	 * 단건조회
	 * @param dto
	 * @return DTO
	 */
	public DTO doSelectOne(DTO dto);
	
	/**
	 * 삭제
	 * @param dto
	 * @return int
	 */
	public int doDelete(DTO dto);
	
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
}
