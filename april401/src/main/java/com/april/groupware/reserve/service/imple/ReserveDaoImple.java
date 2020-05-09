/**
 * <pre>
 * com.april.groupware.reserve
 * Class Name : ReserveDaoImple.java
 * Description : 
 * Modification Information
 * 
 * 수정일         수정자        수정내용
 * ------------ ----------- -------------------------------
 * 2020-05-05           최초생성
 *
 * @author 쌍용교육센터 E반 April
 * @since 2020-05-05 
 * @version 1.0
 * 
 *  Copyright (C) by April All right reserved.
 * </pre>
 */
package com.april.groupware.reserve.service.imple;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.april.groupware.cmn.DTO;
import com.april.groupware.cmn.SearchVO;
import com.april.groupware.reserve.service.ReservationVO;
import com.april.groupware.reserve.service.ReserveDao;

/**
 * @author home
 *
 */
@Repository
public class ReserveDaoImple implements ReserveDao {
	private final Logger LOG = LoggerFactory.getLogger(ReserveDaoImple.class); //LOG
	
	@Autowired
	private JdbcTemplate jdbcTemplete; //JdbcTemplate
	
	private RowMapper<ReservationVO> rowMapper = new RowMapper<ReservationVO>() {
		public ReservationVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			ReservationVO outData = new ReservationVO();
			
			outData.setRsvNo(rs.getString("rsv_no"));
			outData.setRsvDay(rs.getString("rsv_day"));
			outData.setRsvStartTime(rs.getString("rsv_st_time"));
			outData.setRsvEndTime(rs.getString("rsv_end_time"));
			outData.setMeetRoomNo(rs.getString("mt_rm_no"));
			outData.setRsvName(rs.getString("rsv_name"));
			outData.setRsvCn(rs.getString("rsv_cn"));
			outData.setRsvYN(rs.getString("rsv_yn"));
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
	
	@Override
	public int doInsert(DTO dto) {
		int flag = 0;
		ReservationVO inVO = (ReservationVO) dto;
		
		//Query(SQL) 수행
		StringBuilder sb = new StringBuilder();

		sb.append("INSERT INTO reservation ( \n");
		sb.append("    rsv_no,               \n");
		sb.append("    rsv_day,              \n");
		sb.append("    rsv_st_time,          \n");
		sb.append("    rsv_end_time,         \n");
		sb.append("    mt_rm_no,             \n");
		sb.append("    rsv_name,             \n");
		sb.append("    rsv_cn,               \n");
		sb.append("    rsv_yn,               \n");
		sb.append("    reg_id,               \n");
		sb.append("    reg_date              \n");
		sb.append(") VALUES (                \n");
		sb.append("    ?,                    \n");
		sb.append("    ?,                    \n");
		sb.append("    ?,                    \n");
		sb.append("    ?,                    \n");
		sb.append("    ?,                    \n");
		sb.append("    ?,                    \n");
		sb.append("    ?,                    \n");
		sb.append("    ?,                    \n");
		sb.append("    ?,                    \n");
		sb.append("    sysdate               \n");
		sb.append(")                         \n");
		
		LOG.debug("===============================");
		LOG.debug("=Query(SQL)= : \n"+sb.toString());
		LOG.debug("===============================");
		
		Object[] args = {inVO.getRsvNo(), 
				inVO.getRsvDay(), 
				inVO.getRsvStartTime(), 
				inVO.getRsvEndTime(), 
				inVO.getMeetRoomNo(),
				inVO.getRsvName(), 
				inVO.getRsvCn(), 
				inVO.getRsvYN(), 
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

	@Override
	public int doUpdate(DTO dto) {
		int flag = 0;
		ReservationVO inVO = (ReservationVO) dto;
		
		//Query(SQL) 수행
		StringBuilder sb = new StringBuilder();

		sb.append("UPDATE reservation    \n");
		sb.append("SET rsv_day = ?,      \n");
		sb.append("    rsv_st_time = ?,  \n");
		sb.append("    rsv_end_time = ?, \n");
		sb.append("    mt_rm_no = ?,     \n");
		sb.append("    rsv_name = ?,     \n");
		sb.append("    rsv_cn = ?,       \n");
		sb.append("    rsv_yn = ?,       \n");
		sb.append("    mod_id = ?,       \n");
		sb.append("    mod_date = sysdate \n");
		sb.append("WHERE reg_id = ?      \n");
		sb.append("AND	rsv_no = ?       \n");
		
		LOG.debug("===============================");
		LOG.debug("=Query(SQL)= : \n"+sb.toString());
		LOG.debug("===============================");
		
		//inVO.getUserId(), 
		Object[] args = {inVO.getRsvDay(), 
				inVO.getRsvStartTime(), 
				inVO.getRsvEndTime(),
				inVO.getMeetRoomNo(), 
				inVO.getRsvName(), 
				inVO.getRsvCn(), 
				inVO.getRsvYN(),
				inVO.getModId(), 
				inVO.getRegId(), 
				inVO.getRsvNo()};
		
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
		ReservationVO inVO = (ReservationVO) dto;
		
		//Query(SQL) 수행
		StringBuilder sb = new StringBuilder();

		sb.append("DELETE FROM reservation \n");
		sb.append("WHERE rsv_no = ?        \n");
		
		LOG.debug("===============================");
		LOG.debug("=Query(SQL)= : \n"+sb.toString());
		LOG.debug("===============================");
		
		//inVO.getUserId(), 
		Object[] args = {inVO.getRsvNo()};
		
		flag = this.jdbcTemplete.update(sb.toString(), args);
		
		LOG.debug("===============================");
		LOG.debug("=Param= : "+inVO.getRsvNo());
		LOG.debug("===============================");
		
		LOG.debug("===============================");
		LOG.debug("=flag= : "+flag);
		LOG.debug("===============================");
		
		return flag;
	}

	@Override
	public DTO doSelectOne(DTO dto) {
		ReservationVO inVO = (ReservationVO) dto;
		ReservationVO outVO = null;
		
		//Query(SQL) 수행
		StringBuilder sb = new StringBuilder();

		sb.append("SELECT rsv_no,    \n"); 
		sb.append("    rsv_day,      \n");
		sb.append("    rsv_st_time,  \n");
		sb.append("    rsv_end_time, \n");
		sb.append("    mt_rm_no,     \n");
		sb.append("    rsv_name,     \n");
		sb.append("    rsv_cn,       \n");
		sb.append("    rsv_yn,       \n");
		sb.append("    reg_id,       \n");
		sb.append("    mod_id,       \n");
		sb.append("    TO_CHAR(reg_date, 'YYYY/MM/DD HH24:MI:SS') AS reg_date, \n");
		sb.append("    TO_CHAR(mod_date, 'YYYY/MM/DD HH24:MI:SS') AS mod_date, \n");
		//rowMapper용---------------------
		sb.append("    1 rnum,       \n");
		sb.append("    1 total	     \n");
		//rowMapper용---------------------
		sb.append("FROM reservation  \n");
		sb.append("WHERE reg_id = ?  \n");
		
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
		//검색구분, 검색어
		SearchVO inVO = (SearchVO) dto;
		
		//ID 검색-10, 이름 검색-20, 예약번호 검색-30
		StringBuilder whereSb = new StringBuilder();
		
		//날짜 검색만 있는 경우
		if(inVO != null && (!inVO.getSearchStartDate().equals("") && !inVO.getSearchEndDate().equals("")) && inVO.getSearchDiv().equals("")) {
			whereSb.append("WHERE ? <= t1.rsv_day \n");
			whereSb.append("AND t1.rsv_day <= ? \n");
		//검색 조건만 있는 경우
		} else if(inVO != null && !inVO.getSearchDiv().equals("") && (inVO.getSearchStartDate().equals("") && inVO.getSearchEndDate().equals(""))) {
			if(inVO.getSearchDiv().equals("10")) {
				whereSb.append("WHERE UPPER(t1.reg_id) LIKE UPPER('%'||?||'%') \n");
//				whereSb.append("WHERE t1.reg_id LIKE '%'||?||'%' \n");
			} else if(inVO.getSearchDiv().equals("20")) {
				whereSb.append("WHERE t1.rsv_name LIKE '%'||?||'%' \n");
			} else if(inVO.getSearchDiv().equals("30")) {
				whereSb.append("WHERE t1.rsv_no = ? \n");
			}
		//날짜 검색과 검색 조건이 있는 경우
		} else if(inVO != null && !inVO.getSearchDiv().equals("") && !(inVO.getSearchStartDate().equals("") && inVO.getSearchEndDate().equals(""))) {
			//ID 검색-10, 이름 검색-20, 예약번호 검색-30
			if(inVO.getSearchDiv().equals("10")) {
				whereSb.append("WHERE ? <= t1.rsv_day \n");
				whereSb.append("AND t1.rsv_day <= ? \n");
				whereSb.append("AND UPPER(t1.reg_id) LIKE UPPER('%'||?||'%') \n");
//				whereSb.append("WHERE t1.reg_id LIKE '%'||?||'%' \n");
			} else if(inVO.getSearchDiv().equals("20")) {
				whereSb.append("WHERE ? <= t1.rsv_day \n");
				whereSb.append("AND t1.rsv_day <= ? \n");
				whereSb.append("AND t1.rsv_name LIKE '%'||?||'%' \n");
			} else if(inVO.getSearchDiv().equals("30")) {
				whereSb.append("WHERE ? <= t1.rsv_day \n");
				whereSb.append("AND t1.rsv_day <= ? \n");
				whereSb.append("AND t1.rsv_no = ? \n");
			}
		}

		//Query(SQL) 수행
		StringBuilder sb = new StringBuilder();

		sb.append("SELECT *														\n");
		sb.append("FROM(                                                        \n");
		sb.append("	SELECT b.*                                                  \n");
		sb.append("    FROM(                                                    \n");
		sb.append("        SELECT ROWNUM as rnum, a.*                           \n");
		sb.append("        FROM(                                                \n");
		sb.append("			SELECT t1.*                                         \n");
		sb.append("			FROM reservation t1                                 \n");
//		sb.append("			--검색조건                                            					\n");
		//검색--------------------------------------------------------------------------
		sb.append(whereSb.toString());
		//검색--------------------------------------------------------------------------
		sb.append("		ORDER BY t1.rsv_no DESC                                 \n");
		sb.append("		) a                                                     \n");
//		sb.append("		--WHERE rownum <= (&PAGE_SIZE*(&PAGE_NUM-1)+&PAGE_SIZE) \n");
		sb.append("		WHERE rownum <= (?*(?-1)+?)                             \n");
		sb.append("	) b                                                         \n");
//		sb.append("	--WHERE rnum >= (&PAGE_SIZE*(&PAGE_NUM-1)+1)                \n");
		sb.append("	WHERE rnum >= (?*(?-1)+1)                                   \n");
		sb.append(") CROSS JOIN (                                               \n");
		sb.append("	SELECT COUNT(*) TOTAL                                       \n");
		sb.append("    FROM reservation t1                                      \n");
//		sb.append("    --검색조건                                                						\n");
		//검색--------------------------------------------------------------------------
		sb.append(whereSb.toString());
		//검색--------------------------------------------------------------------------
		sb.append(")                                                            \n");
		
		//Param setting
		List<Object> listArgs = new ArrayList<Object>();
		
		//검색 조건(getSearchDiv)만 있는 경우
		if(inVO != null && !inVO.getSearchDiv().equals("") && (inVO.getSearchStartDate().equals("") && inVO.getSearchEndDate().equals(""))) {
			listArgs.add(inVO.getSearchWord());
			listArgs.add(inVO.getPageSize());
			listArgs.add(inVO.getPageNum());
			listArgs.add(inVO.getPageSize());
			listArgs.add(inVO.getPageSize());
			listArgs.add(inVO.getPageNum());
			listArgs.add(inVO.getSearchWord());
		//날짜 검색만 있는 경우
		} else if(inVO != null && (!inVO.getSearchStartDate().equals("") && !inVO.getSearchEndDate().equals("")) && inVO.getSearchDiv().equals("")) {
			listArgs.add(inVO.getSearchStartDate());
			listArgs.add(inVO.getSearchEndDate());
			listArgs.add(inVO.getPageSize());
			listArgs.add(inVO.getPageNum());
			listArgs.add(inVO.getPageSize());
			listArgs.add(inVO.getPageSize());
			listArgs.add(inVO.getPageNum());
			listArgs.add(inVO.getSearchStartDate());
			listArgs.add(inVO.getSearchEndDate());
		//날짜 검색과 검색 조건이 있는 경우
		} else if(inVO != null && !inVO.getSearchDiv().equals("") && !(inVO.getSearchStartDate().equals("") && inVO.getSearchEndDate().equals(""))) {
			listArgs.add(inVO.getSearchStartDate());
			listArgs.add(inVO.getSearchEndDate());
			listArgs.add(inVO.getSearchWord());
			listArgs.add(inVO.getPageSize());
			listArgs.add(inVO.getPageNum());
			listArgs.add(inVO.getPageSize());
			listArgs.add(inVO.getPageSize());
			listArgs.add(inVO.getPageNum());
			listArgs.add(inVO.getSearchStartDate());
			listArgs.add(inVO.getSearchEndDate());
			listArgs.add(inVO.getSearchWord());
		//날짜 검색, 검색 조건이 없는 경우
		} else {
			listArgs.add(inVO.getPageSize());
			listArgs.add(inVO.getPageNum());
			listArgs.add(inVO.getPageSize());
			listArgs.add(inVO.getPageSize());
			listArgs.add(inVO.getPageNum());
		}

		List<ReservationVO> retList = this.jdbcTemplete.query(sb.toString(), listArgs.toArray(), rowMapper);
		LOG.debug("Query : \n"+sb.toString());
		LOG.debug("Param : "+listArgs);
		return retList;
	}
	
}
