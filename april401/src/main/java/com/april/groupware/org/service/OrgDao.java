/**
 * 
 */
package com.april.groupware.org.service;

import java.util.List;

import com.april.groupware.cmn.DTO;

/**
 * @author JUHEE
 *
 */
public interface OrgDao {
	/**
	 * 
	 * Method Name:doInsert 
	 * 작성일: 2020. 5. 2.
	 * 작성자: JIEUN
	 * 설명:
	 * @param dto
	 * @return
	 */
	public int doInsert(DTO dto);
	
	/**
	 * 
	 * Method Name:doUpdate
	 * 작성일: 2020. 5. 2.
	 * 작성자: JIEUN
	 * 설명:
	 * @param dto
	 * @return
	 */
	public int doUpdate(DTO dto);
	
	/**
	 * 
	 * Method Name:doDelete
	 * 작성일: 2020. 5. 2.
	 * 작성자: JIEUN
	 * 설명:
	 * @param dto
	 * @return
	 */
	public int doDelete(DTO dto);
	
	/**
	 * 
	 * Method Name:doSelectOne
	 * 작성일: 2020. 5. 2.
	 * 작성자: JIEUN
	 * 설명:
	 * @param dto
	 * @return
	 */
	public DTO doSelectOne(DTO dto);
	
	/**
	 * 
	 * Method Name:getAll
	 * 작성일: 2020. 5. 2.
	 * 작성자: JIEUN
	 * 설명:
	 * @param dto
	 * @return
	 */
	public List<?> getAll(DTO dto);
	
	/**
	 * 
	 * Method Name:doRetrieve
	 * 작성일: 2020. 5. 2.
	 * 작성자: JIEUN
	 * 설명:
	 * @param dto
	 * @return
	 */
	public List<?> doRetrieve(DTO dto);

}
