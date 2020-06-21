/**
 *<pre>
 * com.hr.cmn
 * Class Name : StringUtil.java
 * Description : 
 * Modification Information
 * 
 *   수정일      수정자              수정내용
 *  ---------   ---------   -------------------------------
 *  2020-02-24           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2020-02-24 
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.april.groupware.cmn;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.april.groupware.code.service.CodeVO;

/**
 * 모든 메소드는 static method
 * @author sist
 *
 */
public class StringUtil {
	private final static Logger LOG = LoggerFactory.getLogger(StringUtil.class);
	
	
	public static Map<String, String> requestToMap(HttpServletRequest request) {
		Map paramMap = new HashMap();
		Map paramHashMap = request.getParameterMap();

		Iterator it = paramHashMap.keySet().iterator();

		while(it.hasNext()){
			String key = it.next().toString();                          // 키 값 등록
	        String [] parameters = request.getParameterValues(key);
	        if(parameters.length>1){
	        	paramMap.put(key,parameters);
	        }else{                                                      // 아니면 그냥 저장.
	            paramMap.put(key,request.getParameter(key));

	        }
		}

		return paramMap;

	}
	
	/**
	 * UUID
	 *Method Name:getUUID
	 *작성일: 2020. 3. 11.
	 *작성자: sist
	 *설명:
	 *@return
	 */
	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		String retUUID = uuid.toString().replace("-", "");
		LOG.debug("retUUID : "+retUUID);
		
		return retUUID;
	}
	
	/**
	 * 
	 *Method Name:getDate
	 *작성일: 2020. 3. 11.
	 *작성자: sist
	 *설명:
	 *@param format
	 *@return
	 */
	
	public static String getDate(String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		
		return formatter.format(new Date());
	}
	
	/**
	 * 
	 *Method Name:renderPaging
	 *작성일: 2020. 2. 27.
	 *작성자: sist
	 *설명: 총 게시글 수, 현재 게시글 페이지 번호, 한 페이지 사이즈(10), 하단 목록 페이징 수(10), link url, javascript 이름
	 *@param maxNum
	 *@param currPageNo
	 *@param rowPerPage
	 *@param btmCount
	 *@return
	 */
	public static String renderPaging(int maxNum_i, int currPageNoIn_i, int rowsPerPage_i, int bottomCount_i, String url_i, String scriptName_i) {
		//<< < 1 2 3 4 5 6 7 8 9 10 > >>
		int maxNum = 0; // 총 게시글 수
		int currPageNo = 1; // 현재 페이지 번호 : page_num
		int rowPerPage = 10; // 한 페이지 사이즈 : page_size
		int bottomCount = 10; // 바닥에 보여질 페이지 수: 10
		
		maxNum = maxNum_i;
		currPageNo = currPageNoIn_i;
		rowPerPage = rowsPerPage_i;
		bottomCount = bottomCount_i;
			
		String url = url_i; // 호출 URL
		String scriptName = scriptName_i; // 호출 자바스크립트
			
		int maxPageNo = ((maxNum-1) / rowPerPage)+1;
		int startPageNo = ((currPageNo-1) / bottomCount) * bottomCount+1;
		int endPageNo = ((currPageNo-1) / bottomCount+1) * bottomCount;
		int nowBlockNo = ((currPageNo-1) / bottomCount)+1;
		int maxBlockNo = ((maxNum-1) / bottomCount)+1;
			
		int inx = 0;
		StringBuilder html = new StringBuilder();
		if (currPageNo > maxPageNo) {
			return "";
		}
			
		html.append("<table border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">   \n");
		html.append("<tr>                       \n");
		html.append("<td align=\"center\">                                                                    \n");
		html.append("<ul class=\"pagination pagination-sm\">                                                  \n");
		
		// <<
		if (nowBlockNo > 1 && nowBlockNo <= maxBlockNo) {
			html.append("<li class=\"active\"> <a href=\"javascript:" + scriptName + "( '" + url+ "', 1 );\">  \n");
			html.append("&laquo;   \n");
			html.append("</a></li> \n");
		}
		
		// <
		if (startPageNo > bottomCount) {
			html.append("<li class=\"active\"> <a href=\"javascript:" + scriptName + "( '" + url + "'," + (startPageNo - 1)+ ");\"> \n");
			html.append("<        \n");
			html.append("</a></li>     \n");
		}
		
		
		// 1 2 3 ... 10 (숫자보여주기)
		for (inx = startPageNo; inx <= maxPageNo && inx <= endPageNo; inx++) {
			if (inx == currPageNo) {// 현재 page
				html.append("<li  class=\"disabled\" 	>");
				html.append("<a  href=\"javascript:#\"  > ");
				html.append(inx);
				html.append("</a> \n");
				html.append("</li>");
			} else {
				html.append("<li  class=\"active\">");
				html.append("<a  href=\"javascript:" + scriptName + "('" + url + "'," + inx + ");\"  > ");
				html.append(inx);
				html.append("</a> \n");
				html.append("</li>");
			}
		}
		
		// >
		if (maxPageNo >= inx) {
			html.append("<li class=\"active\"><a href=\"javascript:" + scriptName + "('" + url + "',"+ ((nowBlockNo * bottomCount) + 1) + ");\"> \n");
			html.append(">                       \n");
			html.append("</a></li>              \n");
		}
		
		// >>
		if (maxPageNo >= inx) {
			html.append("<li class=\"active\"><a href=\"javascript:" + scriptName + "('" + url + "'," + maxPageNo+ ");\">      \n");
			html.append("&raquo;     \n");
			html.append("</a></li>    \n");
		}
		
		html.append("</td>   \n");
		html.append("</tr>   \n");
		html.append("</table>   \n");
		
		return html.toString();
	}
	
	/**
	 * list,selectBoxName,selectNm,allYN
	 *Method Name:makeSelectBox
	 *작성일: 2020. 5. 19.
	 *작성자: 양은영
	 *설명:
	 *@return
	 */
	public static String makeSelectBox(List<CodeVO> list
			                           ,String selectBoxNm
			                           ,String selectNm
			                           ,boolean allYn
			                           ) {
		StringBuilder  sb=new StringBuilder();
		sb.append("<select  class=\"form-control input-sm\" name='"+selectBoxNm+"' id='"+selectBoxNm+"' >\n");
		
		//전체
		if(allYn==true) {
			sb.append("<option value=''>전체</option>\n");
		}
		
		//for
		if(null !=list) {
			for(CodeVO vo :list) {
				sb.append("\t\t<option value='"+vo.getCodeId()+"'  ");
				if(selectNm.equals(vo.getCodeId())) {
					sb.append("selected");
				}
				
				sb.append(">");
				sb.append(vo.getCodeNm());
				sb.append("</option>\n");
			}
		}
		sb.append("</select> \n");
		
		LOG.debug("===========================");
		LOG.debug(sb.toString());
		LOG.debug("===========================");
		return sb.toString();
	}
	
	/**
	 * 
	 *Method Name:makeSelectBox
	 *작성일: 2020. 2. 27.
	 *작성자: sist
	 *설명:
	 *@return
	 */
//	public static String makeSelectBox(List<CodeVO> list, String selectBoxName, String selectNm, boolean allYN) {
//		StringBuilder sb = new StringBuilder();
//		//<select name="search_div" id="search_div">
//			//<option value="" >전체</option>
//			//<option value="10" <%if(searchDiv.equals("10"))out.print("selected"); %> >제목</option>
//			//<option value="20" <%if(searchDiv.equals("20"))out.print("selected"); %> >내용</option>
//			//<option value="30" <%if(searchDiv.equals("30"))out.print("selected"); %> >등록자</option>
//		//</select>
//		sb.append("\n<select class=\"form-control input-sm\" name='"+selectBoxName+"' id='"+selectBoxName+"'>\n");
//		//전체
//		if(allYN == true) {
//			sb.append("<option value='' >전체</option>\n");
//		}
//		//10, 20, 30
//		if(list != null) {
//			for(CodeVO vo : list) {
//				sb.append("<option value='"+vo.getDtlId()+"'  ");
//				if(selectNm.equals(vo.getDtlId())) {
//					sb.append("selected='selected'");
//				}
//				sb.append(">"+vo.getDtlNm()+"</option>\n");
//			}
//		}
//		sb.append("</select>\n");
//		
//		LOG.debug("=sb.toString()="+sb.toString());
//		
//    	return sb.toString();	
//	}
	
	/**
	 * 
	 *Method Name:nvl
	 *작성일: 2020. 2. 24.
	 *작성자: sist
	 *설명: null to ""
	 *@param val String
	 *@return String
	 */
	public static String nvl(String val) {
		return nvl(val, "");
	}
	
	/**
	 * 
	 *Method Name:nvl
	 *작성일: 2020. 2. 24.
	 *작성자: sist
	 *설명: request param null to ""
	 *@param val 원본 String
	 *@param rep 치환 String
	 *@return String
	 */
	public static String nvl(String val, String rep) {
		if(null==val || "".equals(val)) {
			val = rep;
		}
		
		return val;
	}
	
	 public static String orgRenderPaging(int maxNum, int currPageNo, int rowPerPage, int bottomCount,
			   String url, String scriptName) {

			   /**
			    * 총글수: 21
			    * 현재페이지: 1
			    * 한페이지에 보여질 행수: 10
			    * 바닥에 보여질 페이지 수: 10
			    * << < 1 2 3 4 5 6 7 8 9 10 > >>
			    */


			   int maxPageNo = ((maxNum - 1) / rowPerPage) + 1;//3
			   int startPageNo = ((currPageNo - 1) / bottomCount) * bottomCount + 1;//1
			   int endPageNo = ((currPageNo - 1) / bottomCount + 1) * bottomCount;//10
			   
			   int nowBlockNo = ((currPageNo - 1) / bottomCount) + 1;//1
			   int maxBlockNo = ((maxNum - 1) / bottomCount) + 1;//3

			   int inx = 0;
			   StringBuilder html = new StringBuilder();
			   if (currPageNo > maxPageNo) {
			    return "";
			   }

			   html.append("<table border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">   \n");
			   html.append("<tr>                       \n");
			   html.append("<td align=\"center\">                                                                    \n");
			   html.append("<ul class=\"pagination pagination-sm\">                                                  \n");
			   
			   // <<
			   if (nowBlockNo > 1 && nowBlockNo <= maxBlockNo) {
			    html.append("<li class=\"active\"> <a href=\"javascript:" + scriptName + "( '" + url+ "', 1 );\">  \n");
			    html.append("&laquo;   \n");
			    html.append("</a></li> \n");
			   }

			   // <
			   if (startPageNo > bottomCount) {
			    html.append("<li class=\"active\"> <a href=\"javascript:" + scriptName + "( '" + url + "'," + (startPageNo - 1)+ ");\"> \n");
			    html.append("<        \n");
			    html.append("</a></li>     \n");
			   }


			   // 1 2 3 ... 10 (숫자보여주기)
			   for (inx = startPageNo; inx <= maxPageNo && inx <= endPageNo; inx++) {
					if (inx == currPageNo) {// 현재 page
						html.append("<li  class=\"paginate_button page-item previous disabled\"> &nbsp;&nbsp;");
						html.append("<a  href=\"javascript:#\"  >  &nbsp;&nbsp;");
						html.append(inx);
						html.append("</a> \n");
						html.append("</li>");
					} else {
						html.append("<li  class=\"active\"> &nbsp;&nbsp;");
						html.append("<a  href=\"javascript:" + scriptName + "('" + url + "'," + inx + ");\"  > &nbsp;&nbsp;");
						html.append(inx);
						html.append("</a> \n");
						html.append("</li>");
					}
			   }
			   
			   // >
			   if (maxPageNo >= inx) {
			    html.append("<li class=\"active\"><a href=\"javascript:" + scriptName + "('" + url + "',"+ ((nowBlockNo * bottomCount) + 1) + ");\"> \n");
			    html.append(">                       \n");
			    html.append("</a></li>              \n");
			   }

			   // >>
			   if (maxPageNo >= inx) {
			    html.append("<li class=\"active\"><a href=\"javascript:" + scriptName + "('" + url + "'," + maxPageNo+ ");\">      \n");
			    html.append("&raquo;     \n");
			    html.append("</a></li>    \n");
			   }

			   html.append("</td>   \n");
			   html.append("</tr>   \n");
			   html.append("</table>   \n");

			   return html.toString();
			  }

}
