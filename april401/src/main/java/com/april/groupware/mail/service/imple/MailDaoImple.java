package com.april.groupware.mail.service.imple;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.april.groupware.cmn.DTO;
import com.april.groupware.cmn.SearchVO;
import com.april.groupware.mail.service.MailDao;
import com.april.groupware.mail.service.MailVO;

@Repository
public class MailDaoImple implements MailDao {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	private final String NAMESPACE= "com.april.groupware.mail";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	//JDBCTemplate
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	RowMapper<MailVO> rowMapper = new RowMapper<MailVO>() {
		public MailVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MailVO outData = new MailVO();
			outData.setMailId(rs.getString("mail_id"));
			outData.setCategory(rs.getString("category"));
			outData.setSender(rs.getString("sender"));
			outData.setSenderId(rs.getString("sender_id"));
			outData.setSenDate(rs.getString("sen_date"));
			outData.setTitle(rs.getString("title"));
			outData.setFileId(rs.getString("file_id"));
			outData.setContents(rs.getString("contents"));
			outData.setRecipient(rs.getString("recipient"));
			outData.setRecipientId(rs.getString("recipient_id"));
			outData.setRecDate(rs.getString("rec_date"));
			outData.setDisableYn(rs.getString("disable_yn"));
			outData.setRead(rs.getString("read"));
			return outData;
		}
	};
	
	public MailDaoImple() {}
	
	/**
	 * Method Name: doInsert
	 * 작성일: 2020. 5. 12.
	 * 작성자: MINJI
	 * 설명: email 테이블에 Insert
	 * @throws java.lang.Exception
	 */
	@Override
	public int doInsert(DTO dto) {
		MailVO inVO = (MailVO) dto;
		
		LOG.debug("=====MailDaoImple [doInsert] Start======");
		LOG.debug("** Param(inVO) :\n"+inVO.toString());
		
		// namespace+id = com.sist.ehr.board.doInsert 
		String statement = NAMESPACE+".doInsertMail";
		LOG.debug("** statement : "+statement);
		
		int  flag = this.sqlSessionTemplate.insert(statement, inVO);
		LOG.debug("** flag: "+flag);
		
		LOG.debug("=====MailDaoImple [doInsert] End======");
		return flag;
	}
	
	@Override
	public int doUpdate(DTO dto) {
		return 0;
	}
	
	@Override
	public int doUpdateDisable(DTO dto) {
		
		MailVO inVO = (MailVO) dto;
		
		LOG.debug("=====MailDaoImple [doUpdateDisable] Start======");
		
		LOG.debug("** inVO : "+inVO);
		
		// namespace+id = com.sist.ehr.board.doInsert 
		String statement = NAMESPACE+".doUpdateDisable";
		LOG.debug("** statement : "+statement);
		
		inVO.setDisableYn("Y");
		
		int  flag = this.sqlSessionTemplate.update(statement, inVO);
		LOG.debug("** flag : "+flag);
		
		LOG.debug("=====MailDaoImple [doUpdateDisable] End======");
		
		return flag;
		
//----------mybatis 쓰기 전
//		int flag = 0;
//		MailVO inVO = (MailVO) dto;
//		StringBuilder sb=new StringBuilder();
//		sb.append(" UPDATE email	         \n");
//		sb.append(" SET disable_yn = ?		   \n");
//		sb.append(" WHERE                    \n");
//		sb.append("     mail_id = ?             \n");
//		
//		LOG.debug("==============================");
//		LOG.debug("=Query=\n"+sb.toString());
//		LOG.debug("=Param= "+inVO.toString());
//		
//		inVO.setDisableYn("Y");
//		
//		Object[] args= {inVO.getDisableYn()
//						,inVO.getMailId()};
//		flag = this.jdbcTemplate.update(sb.toString(), args);
//		LOG.debug("=flag= "+flag);
//		LOG.debug("==============================");
//		return flag;
	}

	@Override
	public int doUpdateRead(DTO dto) {
		
		MailVO inVO = (MailVO) dto;
		
		LOG.debug("=====MailDaoImple [doUpdateRead] Start======");
		
		LOG.debug("** inVO : "+inVO);
		
		// namespace+id = com.sist.ehr.board.doInsert 
		String statement = NAMESPACE+".doUpdateRead";
		LOG.debug("** statement : "+statement);
		
		inVO.setRead("9");
		
		int  flag = this.sqlSessionTemplate.update(statement, inVO);
		LOG.debug("** flag : "+flag);
		
		LOG.debug("=====MailDaoImple [doUpdateRead] End======");
		
		return flag;
		
	}

	@Override
	public DTO doSelectOne(DTO dto) {
		MailVO inVO = (MailVO) dto;
		
		LOG.debug("=====MailDaoImple [doInsert] Start======");
		LOG.debug("** inVO : "+inVO);
		
		// namespace+id = com.sist.ehr.board.doInsert 
		String statement = NAMESPACE+".doSelectOne";
		LOG.debug("** statement : "+statement);
		
		MailVO outVO = this.sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("** outVO : "+outVO);
		
		LOG.debug("=====MailDaoImple [doSelectOne] End======");
		
		return outVO;
		
//		MailVO inVO = (MailVO) dto;
//		MailVO outVO = null;
//		
//		StringBuilder  sb=new StringBuilder();
//		sb.append("SELECT mail_id as mailId,									\n");
//		sb.append(" 	  category,									\n");
//		sb.append("	      title,                                         \n");
//		sb.append("	      DECODE(TO_CHAR(rec_date, 'YYYY/MM/DD'),TO_CHAR(SYSDATE, 'YYYY/MM/DD'),TO_CHAR(rec_date,'HH24:MI:SS'),TO_CHAR(rec_date,'YYYY/MM/DD HH24:MI:SS')) as recDate,\n");
//		sb.append("	      sender,                                        \n");
//		sb.append("	      sender_id as senderID,                                     \n");
//		sb.append("	      recipient,                                      \n");
//		sb.append("	      recipient_id as recipientId,                                   \n");
//		sb.append("	      file_id as fileId,                                       \n");
//		sb.append("	      contents,	                                    \n");
//		sb.append("	      disable_yn as	disableYn                                    \n");
//		sb.append("FROM email 							                  \n");
//		sb.append("WHERE mail_id = ?                                 \n");
//		
//		///Query수행
//		LOG.debug("=====MailDaoImple [doSelectOne] Start======");
//		LOG.debug("** Query : "+sb.toString());
//		LOG.debug("** Param : "+inVO.getMailId());
//		
//		Object []args = {inVO.getMailId()};
//		outVO = this.jdbcTemplate.queryForObject(sb.toString()
//				,args
//				,rowMapper); 
//		LOG.debug("** outVO : "+outVO);
//		LOG.debug("=====MailDaoImple [doSelectOne] End======");
//		
//		return outVO;
	}
	
	/**
	 * Method Name: doSelectUserId
	 * 작성일: 2020. 5. 14.
	 * 작성자: MINJI
	 * 설명: ORGANIZATION 테이블에서 Id 조회
	 * @throws java.lang.Exception
	 */
	@Override
	public DTO doSelectUserId(DTO dto) {
		
		LOG.debug("=====MailDaoImple [doSelectUserId] Start======");
		
		MailVO inVO = (MailVO) dto;
		LOG.debug("** Param(inVO) :\n"+inVO.toString());		
		
		// namespace+id = com.sist.ehr.board.doInsert 
		String statement = NAMESPACE+".doSelectUserId";
		LOG.debug("** statement : "+statement);
		
		MailVO outVO = this.sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("** outVO: "+outVO);
		inVO.setRecipientId(outVO.getRecipientId());
		LOG.debug("** inVO(recipientId 변경 후): "+inVO);
		
		LOG.debug("=====MailDaoImple [doSelectUserId] End======");
		return inVO;
		
//------------------Mybatis 사용 안한거--------------------------------------		
//		LOG.debug("=====MailDaoImple [doSelectUserId] Start======");
//		
//		MailVO inVO = (MailVO) dto;
//		MailVO outVO = null;
//		
//		StringBuilder  sb=new StringBuilder();
//		sb.append("SELECT ID			\n");
//		sb.append("FROM ORGANIZATION    \n");
//		sb.append("WHERE NAME = ?       \n");
//		
//		LOG.debug("** Query :\n"+sb.toString());
//		LOG.debug("** Param :\n"+inVO.toString());
//		
//		Object[] arg = {inVO.getRecipient()};
//		outVO = this.jdbcTemplate.queryForObject(sb.toString()
//				,arg
//				,rowMapper); 
//		
//		LOG.debug("=====MailDaoImple [doSelectUserId] End======");
//		return outVO;
//------------------Mybatis 사용 안한거--------------------------------------
	}

	@Override
	public int doDelete(DTO dto) {
		return 0;
	}

	@Override
	public List<?> doRetrieve(DTO dto) {
		SearchVO inVO = (SearchVO) dto;
		
		LOG.debug("=====MailDaoImple [doRetrieve] Start======");
		
		LOG.debug("** inVO : "+inVO);
		
		// namespace+id = com.sist.ehr.board.doInsert 
		String statement = NAMESPACE+".doRetrieve";
		LOG.debug("** statement : "+statement);
		
		List<MailVO> outList = this.sqlSessionTemplate.selectList(statement, inVO);
		LOG.debug("** outList : "+outList);
		
		LOG.debug("=====MailDaoImple [doRetrieve] End======");
		
		return outList;
		
//		SearchVO  inVO= (SearchVO) dto;
//		//검색구분
//		  //ID : 10
//		  //이름: 20
//		//검색어
//		//StringBuilder whereSb=new StringBuilder();
//		
////		if(null !=inVO && !"".equals(inVO.getSearchDiv())) {
////			if(inVO.getSearchDiv().equals("10")) {
////				whereSb.append("AND recipient_id like '%' || ? ||'%'   \n"); //?에 들어갈꺼 searchWord
////			}else if(inVO.getSearchDiv().equals("20")) {
////				whereSb.append("AND name like '%' || ? ||'%'   \n");
////			}
////		}
//		
//		
//		StringBuilder sb=new StringBuilder();
//		sb.append("SELECT T1.*,T2.*                                              \n");
//		sb.append("FROM(                                                         \n");
//		sb.append("    SELECT  B.mail_id,                                           \n");
//		sb.append("            B.category,                                           \n");
//		sb.append("            B.sender,                                         \n");
//		sb.append("            B.sender_id,                                        \n");
//		sb.append("            B.title,                                          \n");
//		sb.append("            B.file_id,                                      \n");
//		sb.append("            DECODE(TO_CHAR(rec_date, 'YYYY/MM/DD'),TO_CHAR(SYSDATE, 'YYYY/MM/DD'),TO_CHAR(rec_date,'HH24:MI:SS'),TO_CHAR(rec_date,'YYYY/MM/DD HH24:MI:SS')) rec_date,\n");
//		sb.append("            B.disable_yn,                                           \n");
//		sb.append("            B.read,                                           \n");
//		sb.append("            rnum                                              \n");		
//		sb.append("    FROM(                                                     \n");
//		sb.append("        SELECT ROWNUM rnum,                                   \n");
//		sb.append("               A.*                                            \n");
//		sb.append("        FROM (                                                \n");
//		sb.append("            SELECT *                                          \n");
//		sb.append("            FROM email                                    \n");
//		sb.append("            WHERE rec_date  > '1900/01/01'                      \n");
//
//		sb.append("            --검색조건                                                                               \n");
//		//--검색----------------------------------------------------------------------
//		//sb.append(whereSb.toString());
//		sb.append("AND recipient_id like '%' || ? ||'%'   \n");
//		//--검색----------------------------------------------------------------------	
//		sb.append("            ORDER BY TO_CHAR(rec_date,'YYYYMMDD HH24:MI:SS')  DESC                             \n");
//		sb.append("        )A --10                                               \n");
//		//sb.append("        WHERE ROWNUM <= (&PAGE_SIZE*(&PAGE_NUM-1)+&PAGE_SIZE) \n");
//		sb.append("        WHERE ROWNUM <= (?*(?-1)+?) \n");
//		sb.append("    )B --1                                                    \n");
//		//sb.append("    WHERE B.RNUM >= (&PAGE_SIZE*(&PAGE_NUM-1)+1)              \n");
//		sb.append("    WHERE B.RNUM >= (?*(?-1)+1)              \n");
//		sb.append("    )T1 CROSS JOIN                                            \n");
//		sb.append("    (                                                         \n");
//		sb.append("    SELECT count(*) total_cnt                                 \n");
//		sb.append("    FROM email                                            \n");
//		sb.append("    WHERE rec_date  > '1900/01/01'                              \n");
//		sb.append("    --검색조건                                                   \n");
//		//--검색----------------------------------------------------------------------
//		//sb.append(whereSb.toString());
//		sb.append("AND recipient_id like '%' || ? ||'%'   \n");
//		//--검색----------------------------------------------------------------------
//		sb.append("    )T2  														\n");
//
//		//param 
//		List<Object> listArg = new ArrayList<Object>();
//		
//		
//		//param set
//		listArg.add(inVO.getSearchWord());
//		listArg.add(inVO.getPageSize());
//		listArg.add(inVO.getPageNum());
//		listArg.add(inVO.getPageSize());
//		listArg.add(inVO.getPageSize());
//		listArg.add(inVO.getPageNum());				
//		listArg.add(inVO.getSearchWord());
//		
////		if(null !=inVO && !"".equals(inVO.getSearchDiv())) {
////			listArg.add(inVO.getSearchWord());
////			listArg.add(inVO.getPageSize());
////			listArg.add(inVO.getPageNum());
////			listArg.add(inVO.getPageSize());
////			listArg.add(inVO.getPageSize());
////			listArg.add(inVO.getPageNum());				
////			listArg.add(inVO.getSearchWord());
////			
////		}else {
////			listArg.add(inVO.getPageSize());
////			listArg.add(inVO.getPageNum());
////			listArg.add(inVO.getPageSize());
////			listArg.add(inVO.getPageSize());
////			listArg.add(inVO.getPageNum());			
////		}
//		List<MailVO> retList = this.jdbcTemplate.query(sb.toString(), listArg.toArray(), rowMapper);
//		LOG.debug("query \n"+sb.toString());
//		LOG.debug("param:"+listArg);
//		return retList;
	}
	
	@Override
	public List<?> doRetrieveSent(DTO dto) {
		SearchVO inVO = (SearchVO) dto;
		
		LOG.debug("=====MailDaoImple [doRetrieveSent] Start======");
		
		LOG.debug("** inVO : "+inVO);
		
		// namespace+id = com.sist.ehr.board.doInsert 
		String statement = NAMESPACE+".doRetrieveSent";
		LOG.debug("** statement : "+statement);
		
		List<MailVO> outList = this.sqlSessionTemplate.selectList(statement, inVO);
		LOG.debug("** outList : "+outList);
		
		LOG.debug("=====MailDaoImple [doRetrieveSent] End======");
		
		return outList;
	}

	@Override
	public List<?> getAll(DTO dto) {
		SearchVO inVO = (SearchVO) dto;
		
		LOG.debug("=====MailDaoImple [getAll] Start======");
		
		LOG.debug("** inVO : "+inVO);
		
		// namespace+id = com.sist.ehr.board.doInsert 
		String statement = NAMESPACE+".doGetAll";
		LOG.debug("** statement : "+statement);
		
		List<MailVO> outList = this.sqlSessionTemplate.selectList(statement, inVO);
		LOG.debug("** outList : "+outList);
		
		LOG.debug("=====MailDaoImple [getAll] End======");
		
		return outList;
	}

	@Override
	public List<?> doRetrieveTrash(DTO dto) {
		SearchVO inVO = (SearchVO) dto;
		
		LOG.debug("=====MailDaoImple [doRetrieveTrash] Start======");
		
		LOG.debug("** inVO : "+inVO);
		
		// namespace+id = com.sist.ehr.board.doInsert 
		String statement = NAMESPACE+".doRetrieveTrash";
		LOG.debug("** statement : "+statement);
		
		List<MailVO> outList = this.sqlSessionTemplate.selectList(statement, inVO);
		LOG.debug("** outList : "+outList);
		
		LOG.debug("=====MailDaoImple [doRetrieveTrash] End======");
		
		return outList;
	}

	@Override
	public DTO doSelectImage(DTO dto) {
		MailVO inVO = (MailVO) dto;
		
		LOG.debug("=====MailDaoImple [doSelectImage] Start======");
		LOG.debug("** inVO : "+inVO);
		
		// namespace+id = com.sist.ehr.board.doInsert 
		String statement = NAMESPACE+".doSelectImage";
		LOG.debug("** statement : "+statement);
		
		MailVO outVO = this.sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("** outVO : "+outVO);
		
		LOG.debug("=====MailDaoImple [doSelectImage] End======");
		
		return outVO;
	}

	@Override
	public int getAllCount(DTO dto) {
		SearchVO inVO = (SearchVO) dto;
		
		LOG.debug("=====MailDaoImple [getAllCount] Start======");
		
		LOG.debug("** inVO : "+inVO);
		
		// namespace+id = com.sist.ehr.board.doInsert 
		String statement = NAMESPACE+".doGetAllCount";
		LOG.debug("** statement : "+statement);
		
		int  flag = this.sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("** flag : "+flag);
		
		LOG.debug("=====MailDaoImple [getAllCount] End======");
		
		return flag;
	}


}
