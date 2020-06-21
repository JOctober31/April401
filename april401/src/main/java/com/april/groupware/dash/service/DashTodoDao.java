/**
 * 
 */
package com.april.groupware.dash.service;

import java.util.List;

import com.april.groupware.cmn.DTO;

/**
 * @author sist
 *
 */
public interface DashTodoDao {

	public DTO doSelectOne(DTO dto);
	
	public DTO doDeptSelectOne(DTO dto);
	
	public List<?> doRetrieve(DTO dto);
	
}

