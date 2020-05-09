package com.april.groupware.chat.service.imple;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.april.groupware.cmn.DTO;
import com.april.groupware.cmn.SearchVO;
import com.april.groupware.chat.service.UserDao;
import com.april.groupware.chat.service.UserVO;

@Repository
public class UserDaoImple implements UserDao {

	//Logger
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
		
		
	RowMapper<UserVO> rowMapper = new RowMapper<UserVO>() {

		public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserVO outData=new UserVO();
			outData.setId(rs.getString("id"));
			outData.setName(rs.getString("name"));
			outData.setDept_Nm(rs.getString("dept_Nm"));
			outData.setPosition(rs.getString("position"));
			
			//-----------------------------------------
			//-2020/04/09 등업 요건 추가
			//-----------------------------------------			
//			outData.setNum(rs.getInt("rnum"));
//			outData.setTotalCnt(rs.getInt("total_cnt"));
			return outData;
		}

	};
	
	
	
	//JDBCTemplate
	@Autowired
	private JdbcTemplate jdbcTemplate;
		
	public UserDaoImple() {}
	
	
	public List<?> doRetrieve(DTO dto) {
		SearchVO  inVO= (SearchVO) dto;
		//검색구분
		  //ID : 10
		  //이름: 20
		//검색어
		StringBuilder whereSb=new StringBuilder();
		
		if(null !=inVO && !"".equals(inVO.getSearchDiv())) {
			if(inVO.getSearchDiv().equals("10")) {
				whereSb.append("WHERE dept_nm = '영업'			 		 	 \n");
			}else if (inVO.getSearchDiv().equals("20")) {
				whereSb.append("WHERE dept_nm = '개발'			 		 	 \n");
			}
		}
		
		StringBuilder sb=new StringBuilder();
		sb.append("SELECT T1.*                                              	 \n");
		sb.append("FROM(                                                         \n");
		sb.append("    SELECT  B.id,                                             \n");
		sb.append("            B.name,                                       	 \n");
		sb.append("            B.position,                                       \n");
		sb.append("            B.dept_nm,                                        \n");
		sb.append("            rnum                                              \n");
		sb.append("    FROM(                                                     \n");
		sb.append("        SELECT ROWNUM rnum, A.*                               \n");
		sb.append("        FROM (                                                \n");
		sb.append("            SELECT *                                          \n");
		sb.append("            FROM organization                                 \n");
		sb.append("            --검색조건                                           					 \n");
		//--검색----------------------------------------------------------------------
		sb.append(whereSb.toString());
		//--검색----------------------------------------------------------------------				
		sb.append("        )A                                                   	\n");
		//sb.append("        WHERE ROWNUM <= (&PAGE_SIZE*(&PAGE_NUM-1)+&PAGE_SIZE)  \n");
		sb.append("        WHERE ROWNUM <= (?*(?-1)+?) 							    \n");
		sb.append("    )B                                                       	\n");
		//sb.append("    WHERE B.RNUM >= (&PAGE_SIZE*(&PAGE_NUM-1)+1)               \n");
		sb.append("    WHERE B.RNUM >= (?*(?-1)+1)	             				    \n");
		sb.append("    )T1                                            				\n");


		//param 
		List<Object> listArg = new ArrayList<Object>();
		
		
		//param set
		if(null !=inVO && !"".equals(inVO.getSearchDiv())) {
			//listArg.add(inVO.getSearchWord());
			listArg.add(inVO.getPageSize());
			listArg.add(inVO.getPageNum());
			listArg.add(inVO.getPageSize());
			listArg.add(inVO.getPageSize());
			listArg.add(inVO.getPageNum());				
			//listArg.add(inVO.getSearchWord());
			
		}else {
			listArg.add(inVO.getPageSize());
			listArg.add(inVO.getPageNum());
			listArg.add(inVO.getPageSize());
			listArg.add(inVO.getPageSize());
			listArg.add(inVO.getPageNum());			
		}
		
		List<UserVO> retList = this.jdbcTemplate.query(sb.toString(), listArg.toArray(), rowMapper);
		LOG.debug("query \n"+sb.toString());
		LOG.debug("param:"+listArg);
		return retList;
		}


		
		public DTO doSelectOne(DTO dto) {
			UserVO outVO = null;        //return UserVO
			UserVO inVO  = (UserVO) dto;//Param UserVO
			StringBuilder  sb=new StringBuilder();
			sb.append(" SELECT                  \n");
			sb.append("     id,                 \n");
			sb.append("     dept_nm,            \n");
			sb.append("     name,           	\n");
			sb.append("     position            \n"); 		
			sb.append(" FROM                    \n");
			sb.append("     organization        \n");
			sb.append(" WHERE id = ?      		\n");
			
			//Query수행
			LOG.debug("==============================");
			LOG.debug("=Query=\n"+sb.toString());
			LOG.debug("=Param=\n"+inVO.getId());
			
			Object []args = {inVO.getId()};
			outVO = this.jdbcTemplate.queryForObject(sb.toString()
					,args
					,rowMapper); 
			LOG.debug("=outVO=\n"+outVO);
			LOG.debug("==============================");
			
			
			
			
			return outVO;
		}


		


		@Override
		public List<?> getAll(DTO dto) {
			// TODO Auto-generated method stub
			return null;
		}


		//테스트용
		public int doInsert(DTO dto) {
			int flag = 0;
			UserVO inVO = (UserVO) dto;
			
			StringBuilder  sb=new StringBuilder();
			sb.append(" INSERT INTO organization ( \n");
			sb.append("     id,                 \n");
			sb.append("     dept_nm,            \n");
			sb.append("     name,           	\n");
			sb.append("     position            \n");
			sb.append(" ) VALUES (              \n");
			sb.append("     ?,                  \n");
			sb.append("     ?,                  \n");
			sb.append("     ?,                  \n");
			sb.append("     ?                   \n");
			sb.append("     )                   \n");
	
			//Query수행
			LOG.debug("==============================");
			LOG.debug("=Query=\n"+sb.toString());
			LOG.debug("=Param=\n"+inVO.toString());
			Object[] args= {inVO.getId()
						   ,inVO.getName()
					       ,inVO.getDept_Nm()
					       ,inVO.getPosition()
			};
			flag = this.jdbcTemplate.update(sb.toString(), args);
			
			
			LOG.debug("==============================");
			
			return flag;
		}

	}

