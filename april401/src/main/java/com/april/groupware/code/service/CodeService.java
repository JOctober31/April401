package com.april.groupware.code.service;

import java.util.List;

import com.april.groupware.cmn.DTO;

public interface CodeService {
	/**
	 * 목록조회
	 * @param dto
	 * @return
	 */
	public List<?> doRetrieve(DTO dto);
}
