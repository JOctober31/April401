/**
 * <pre>
 * com.april.groupware.attendance.service.imple
 * Class Name : attendanceDaoImple.java
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
package com.april.groupware.attendance.service.imple;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.april.groupware.attendance.service.AttendanceDao;
import com.april.groupware.attendance.service.AttendanceVO;
import com.april.groupware.cmn.DTO;
import com.april.groupware.reserve.service.imple.ReserveDaoImple;

/**
 * @author SIST
 *
 */
@Repository
public class AttendanceDaoImple implements AttendanceDao {
	private final Logger LOG = LoggerFactory.getLogger(ReserveDaoImple.class); //LOG
	
	@Autowired
	private JdbcTemplate jdbcTemplete; //JdbcTemplate
	
	private RowMapper<AttendanceVO> rowMapper = new RowMapper<AttendanceVO>() {
		public AttendanceVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			AttendanceVO outData = new AttendanceVO();
			
			outData.setSeq(rs.getString("seq"));
			outData.setUserId(rs.getString("id"));
			outData.setAttendTime(rs.getString("attend_time"));
			outData.setLeaveTime(rs.getString("lv_ffc_time"));
			outData.setAttendYN(rs.getString("attend_yn"));
			outData.setLeaveYN(rs.getString("lv_ffc_yn"));
			outData.setWorkTime(rs.getString("work_time"));
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
	
	//출근
	@Override
	public int doInsert(DTO dto) {
		int flag = 0;
		AttendanceVO inVO = (AttendanceVO) dto;
		
		//Query(SQL) 수행
		StringBuilder sb = new StringBuilder();

		sb.append("INSERT INTO attendance ( \n");
		sb.append("    seq,                 \n");
		sb.append("    id,                  \n");
		sb.append("    attend_time,         \n");
		sb.append("    lv_ffc_time,         \n");
		sb.append("    attend_yn,           \n");
		sb.append("    lv_ffc_yn,           \n");
		sb.append("    work_time,           \n");
		sb.append("    reg_id,              \n");
		sb.append("    reg_date,            \n");
		sb.append(") VALUES (               \n");
		sb.append("    ?,                   \n");
		sb.append("    ?,                   \n");
		sb.append("    ?,                   \n");
		sb.append("    ?,                   \n");
		sb.append("    ?,                   \n");
		sb.append("    ?,                   \n");
		sb.append("    ?,                   \n");
		sb.append("    ?,                   \n");
		sb.append("    sysdate              \n");
		sb.append(")                        \n");
		
		LOG.debug("===============================");
		LOG.debug("=Query(SQL)= : \n"+sb.toString());
		LOG.debug("===============================");
		
		Object[] args = {inVO.getSeq(), 
				inVO.getUserId(), 
				inVO.getAttendTime(), 
				inVO.getLeaveTime(), 
				inVO.getAttendYN(),
				inVO.getLeaveYN(), 
				inVO.getWorkTime(), 
				inVO.getRegId()};
		
		flag = this.jdbcTemplete.update(sb.toString(), args);
		
		LOG.debug("===============================");
		LOG.debug("=Param= : "+inVO);
		LOG.debug("===============================");
		
		LOG.debug("===============================");
		LOG.debug("=flag= : "+flag);
		LOG.debug("===============================");
		
		return flag;
	}
	
	//퇴근
	public int LeaveUpdate(DTO dto) {
		int flag = 0;
		AttendanceVO inVO = (AttendanceVO) dto;
		
		//Query(SQL) 수행
		StringBuilder sb = new StringBuilder();

		sb.append("UPDATE attendance	\n");
		sb.append("SET lv_ffc_time = ?, \n");
		sb.append("    lv_ffc_yn = ?,   \n");
		sb.append("    state = ?,   	\n");
		sb.append("    work_time = ?,   \n");
		sb.append("    mod_id = ?,      \n");
		sb.append("    mod_date = ?     \n");
		sb.append("WHERE id = ?         \n");
		
		LOG.debug("===============================");
		LOG.debug("=Query(SQL)= : \n"+sb.toString());
		LOG.debug("===============================");
		
		//inVO.getUserId(), 
		Object[] args = {inVO.getAttendTime(), 
				inVO.getLeaveTime(), 
				inVO.getLeaveYN(), 
				inVO.getWorkTime(), 
				inVO.getModId(),
				inVO.getModDate(),
				inVO.getUserId()};
		
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
	public int doUpdate(DTO dto) {
		int flag = 0;
		AttendanceVO inVO = (AttendanceVO) dto;
		
		//Query(SQL) 수행
		StringBuilder sb = new StringBuilder();

		sb.append("UPDATE attendance	\n");
		sb.append("SET attend_time = ?, \n");
		sb.append("    lv_ffc_time = ?, \n");
		sb.append("    attend_yn = ?,   \n");
		sb.append("    lv_ffc_yn = ?,   \n");
		sb.append("    state = ?,   	\n");
		sb.append("    work_time = ?,   \n");
		sb.append("    mod_id = ?,      \n");
		sb.append("    mod_date = ?     \n");
		sb.append("WHERE id = ?         \n");
		
		LOG.debug("===============================");
		LOG.debug("=Query(SQL)= : \n"+sb.toString());
		LOG.debug("===============================");
		
		//inVO.getUserId(), 
		Object[] args = {inVO.getAttendTime(), 
				inVO.getLeaveTime(), 
				inVO.getAttendYN(),
				inVO.getLeaveYN(), 
				inVO.getWorkTime(), 
				inVO.getModId(),
				inVO.getModDate(),
				inVO.getUserId()};
		
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
		int flag = 0;
		AttendanceVO inVO = (AttendanceVO) dto;
		
		//Query(SQL) 수행
		StringBuilder sb = new StringBuilder();

		sb.append("DELETE FROM attendance \n");
		sb.append("WHERE seq = ?          \n");
		sb.append("AND id = ?             \n");
		
		LOG.debug("===============================");
		LOG.debug("=Query(SQL)= : \n"+sb.toString());
		LOG.debug("===============================");
		
		//inVO.getUserId(), 
		Object[] args = {inVO.getSeq(), inVO.getUserId()};
		
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
	public DTO doSelectOne(DTO dto) {
		AttendanceVO inVO = (AttendanceVO) dto;
		AttendanceVO outVO = null;
		
		//Query(SQL) 수행
		StringBuilder sb = new StringBuilder();

		sb.append("SELECT seq,		\n");
		sb.append("    attend_time, \n");
		sb.append("    lv_ffc_time, \n");
		sb.append("    attend_yn,   \n");
		sb.append("    lv_ffc_yn,   \n");
		sb.append("    work_time,   \n");
		sb.append("    reg_id,      \n");
		sb.append("    mod_id,      \n");
		sb.append("    TO_CHAR(mod_date, 'YYYY/MM/DD HH24:MI:SS') AS mod_date, \n");
		sb.append("    TO_CHAR(reg_date, 'YYYY/MM/DD HH24:MI:SS') AS reg_date, \n");
		//rowMapper용---------------------
		sb.append("    1 rnum,       \n");
		sb.append("    1 total	     \n");
		//rowMapper용---------------------
		sb.append("FROM attendance  \n");
		sb.append("WHERE id = ?     \n");
		
		LOG.debug("===============================");
		LOG.debug("=Query(SQL)= : \n"+sb.toString());
		LOG.debug("===============================");
		
		//inVO.getUserId(), 
		Object[] args = {inVO.getRegId()};
		
		outVO = this.jdbcTemplete.queryForObject(sb.toString(), args, rowMapper);
		
		LOG.debug("===============================");
		LOG.debug("=Param= : "+inVO.getRegId());
		LOG.debug("===============================");
		
		LOG.debug("===============================");
		LOG.debug("=flag= : "+outVO);
		LOG.debug("===============================");
		
		return outVO;
	}

	@Override
	public List<?> getAll(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> doRetrieve(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
