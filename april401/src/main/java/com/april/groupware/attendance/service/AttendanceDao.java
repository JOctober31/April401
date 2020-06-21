/**
 * <pre>
 * com.april.groupware.attendance.service
 * Class Name : attendanceDao.java
 * Description : 
 * Modification Information
 * 
 * 수정일         수정자        수정내용
 * ------------ ----------- -------------------------------
 * 2020-05-06           최초생성
 *
 * @author 쌍용교육센터 E반 April
 * @since 2020-05-06 
 * @version 1.0
 * 
 *  Copyright (C) by April All right reserved.
 * </pre>
 */
package com.april.groupware.attendance.service;

import java.text.ParseException;
import java.util.List;

import com.april.groupware.cmn.DTO;

/**
 * @author SIST
 *
 */
public interface AttendanceDao {
	/**
	 * 
	 * Method Name:doInsert 
	 * 작성일: 2020. 5. 10.
	 * 작성자: JIEUN
	 * 설명:
	 * @param dto
	 * @return
	 * @throws ParseException 
	 */
	public int doInsert(DTO dto) throws ParseException;
	
	/**
	 * 
	 * Method Name:doUpdate
	 * 작성일: 2020. 5. 10.
	 * 작성자: JIEUN
	 * 설명:
	 * @param dto
	 * @return
	 */
	public int doUpdate(DTO dto);
	
	public int doLeaveUpdate(DTO dto);
	
	public int doEarlyLeave(DTO dto);
	
	/**
	 * 
	 * Method Name:doDelete
	 * 작성일: 2020. 5. 10.
	 * 작성자: JIEUN
	 * 설명:
	 * @param dto
	 * @return
	 */
	public int doDelete(DTO dto);
	
	public int doAttendCheck(DTO dto);
	
	/**
	 * 
	 * Method Name:doSelectOne
	 * 작성일: 2020. 5. 10.
	 * 작성자: JIEUN
	 * 설명:
	 * @param dto
	 * @return
	 */
	public DTO doSelectOne(DTO dto);
	
	/**
	 * 
	 * Method Name:getAll
	 * 작성일: 2020. 5. 10.
	 * 작성자: JIEUN
	 * 설명:
	 * @param dto
	 * @return
	 */
	public List<?> getAll(DTO dto);
	
	/**
	 * 
	 * Method Name:doRetrieve
	 * 작성일: 2020. 5. 10.
	 * 작성자: JIEUN
	 * 설명:
	 * @param dto
	 * @return
	 */
	public List<?> doRetrieve(DTO dto);

}
