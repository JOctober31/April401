/**
 * <pre>
 * com.april.groupware.attendance.imple
 * Class Name : UserUpdateDaoImple.java
 * Description : 
 * Modification Information
 * 
 * 수정일         수정자        수정내용
 * ------------ ----------- -------------------------------
 * 2020-05-02           최초생성
 *
 * @author 쌍용교육센터 E반 April
 * @since 2020-05-02 
 * @version 1.0
 * 
 *  Copyright (C) by April All right reserved.
 * </pre>
 */
package com.april.groupware.dash.service.imple;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.april.groupware.cmn.DTO;
import com.april.groupware.dash.service.DashDao;
import com.april.groupware.org.service.OrgDao;
import com.april.groupware.org.service.OrgVO;

/**
 * @author JUHEE 
 *
 */
@Repository
public class DashDaoImple implements DashDao {
	private final Logger LOG = LoggerFactory.getLogger(DashDaoImple.class); //LOG
	
	@Autowired
	private JdbcTemplate jdbcTemplete; //JdbcTemplate
	
	private RowMapper<OrgVO> rowMapper = new RowMapper<OrgVO>() {
		public OrgVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			OrgVO outData = new OrgVO();

			outData.setId(rs.getString("id"));
			outData.setPassword(rs.getString("password"));
			outData.setDeptNm(rs.getString("dept_nm"));
			outData.setDeptCd(rs.getString("dept_cd"));
			outData.setParentDeptCd(rs.getString("parent_dept_cd"));
			
			outData.setAuth(rs.getString("auth"));
			outData.setName(rs.getString("name"));
			outData.setPosition(rs.getString("position"));
			outData.setMobile(rs.getString("mobile"));
			outData.setEmail(rs.getString("email"));
			
			outData.setAddress(rs.getString("address"));
			outData.setHiredate(rs.getString("hire_date"));
			outData.setBirth(rs.getString("birth"));
			outData.setVacationCnt(rs.getString("vacation_cnt"));
			outData.setMilitaryYN(rs.getString("military_yn"));
			
			outData.setDspsnYN(rs.getString("dspsn_yn"));
			outData.setGrade(rs.getString("grade"));
			outData.setOrgFileName(rs.getString("org_file_nm"));
			outData.setModFileName(rs.getString("mod_file_nm"));
			outData.setImgPath(rs.getString("img_path"));
			
			outData.setExt(rs.getString("ext"));
			outData.setFileSize(rs.getString("file_size"));
			outData.setRegId(rs.getString("reg_id"));
			outData.setRegDate(rs.getString("reg_date"));
			outData.setModId(rs.getString("mod_id"));
			outData.setModDate(rs.getString("mod_date"));
			//end
			outData.setNum(rs.getInt("rnum"));
			outData.setTotalCnt(rs.getInt("total"));
			
			return outData;
		}
	};
	
	public DashDaoImple() {
		
	}
	
	@Override
	public int doInsert(DTO dto) {
		int flag = 0;
		
		
		return 0;
	}

	@Override
	public int doUpdate(DTO dto) {
		int flag = 0;
		OrgVO inVO = (OrgVO) dto;
		
		//Query(SQL) 수행
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE organization	   \n");
		sb.append("SET password = ?,       \n");
		sb.append("    mobile = ?,         \n");
		sb.append("    email = ?,          \n");
		sb.append("    address = ?,        \n");
		sb.append("    military_yn = ?,    \n");
		sb.append("    dspsn_yn = ?,       \n");
		sb.append("    grade = ?,          \n");
		sb.append("    org_file_nm = ?,    \n");
		sb.append("    mod_file_nm = ?,    \n");
		sb.append("    img_path = ?,       \n");
		sb.append("    ext = ?,            \n");
		sb.append("    file_size = ?,      \n");
		sb.append("    mod_id = ?,         \n");
		sb.append("    mod_date = sysdate  \n");
		sb.append("WHERE id = ?            \n");
		
		LOG.debug("===============================");
		LOG.debug("=Query(SQL)= : \n"+sb.toString());
		LOG.debug("===============================");
		
		//inVO.getUserId(), 
		Object[] args = {inVO.getPassword(), 
				inVO.getMobile(), 
				inVO.getEmail(), 
				inVO.getAddress(), 
				inVO.getMilitaryYN(), 
				inVO.getDspsnYN(), 
				inVO.getGrade(), 
				inVO.getOrgFileName(), 
				inVO.getModFileName(), 
				inVO.getImgPath(), 
				inVO.getExt(),
				inVO.getFileSize(),
				inVO.getId(), 
				inVO.getId()};
		
		flag = this.jdbcTemplete.update(sb.toString(), args);
		
		LOG.debug("===============================");
		LOG.debug("=Param= : "+inVO);
		LOG.debug("===============================");
		
		LOG.debug("===============================");
		LOG.debug("=flag= : "+flag);
		LOG.debug("===============================");
		
		return flag;
	}

	@Override
	public int doDelete(DTO dto) {
		return 0;
	}

	@Override
	public DTO doSelectOne(DTO dto) {
		int flag = 0;
		OrgVO inVO = (OrgVO) dto; //파라미터
		OrgVO outVO = null; //리턴 값
		
		//Query(SQL) 수행
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT id,			\n");
		sb.append("    password,        \n");
		sb.append("    dept_nm,         \n");
		sb.append("    dept_cd,         \n");
		sb.append("    parent_dept_cd,  \n");
		sb.append("    auth,            \n");
		sb.append("    name,            \n");
		sb.append("    position,        \n");
		sb.append("    mobile,          \n");
		sb.append("    email,           \n");
		sb.append("    address,         \n");
		sb.append("    hire_date,       \n");
		sb.append("    birth,           \n");
		sb.append("    vacation_cnt,    \n");
		sb.append("    military_yn,     \n");
		sb.append("    dspsn_yn,        \n");
		sb.append("    grade,           \n");
		sb.append("    org_file_nm,     \n");
		sb.append("    mod_file_nm,     \n");
		sb.append("    img_path,        \n");
		sb.append("    ext,             \n");
		sb.append("    file_size,       \n");
		sb.append("    reg_id,          \n");
		sb.append("    TO_CHAR(reg_date, 'YYYY/MM/DD HH24:MI:SS') AS reg_date, \n");
		sb.append("    mod_id,          \n");
		sb.append("    TO_CHAR(mod_date, 'YYYY/MM/DD HH24:MI:SS') AS mod_date, \n");
		//rowMapper용------------------
		sb.append("    1 rnum,     \n");
		sb.append("    1 total     \n");
		//rowMapper용------------------
		sb.append("FROM organization    \n");
		sb.append("WHERE id = ?         \n");
		
		LOG.debug("===============================");
		LOG.debug("=Query(SQL)= : \n"+sb.toString());
		LOG.debug("===============================");
		LOG.debug("=Param= : "+inVO.getId());
		LOG.debug("===============================");
		
		Object[] args = {inVO.getId()};
		outVO = this.jdbcTemplete.queryForObject(sb.toString(), args, rowMapper);
		LOG.debug("===============================");
		LOG.debug("=outVO= : "+outVO);
		LOG.debug("===============================");
				
		return outVO;
	}

	@Override
	public List<?> getAll(DTO dto) {
		return null;
	}

	@Override
	public List<?> doRetrieve(DTO dto) {
		return null;
	}

}
