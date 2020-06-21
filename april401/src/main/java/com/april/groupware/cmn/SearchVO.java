/**
 * 
 */
package com.april.groupware.cmn;

/**
 * @author SIST
 *
 */
public class SearchVO extends DTO {
	//검색어
	private String searchDiv;
	//검색구분
	private String searchWord;
	//페이지 크기
	private int pageSize;
	//페이지 번호
	private int pageNum;
	//날짜 검색 시작
	private String searchStartDate;
	//날짜 검색 끝
	private String searchEndDate;
	
	public SearchVO() {
		
	}
	
	public SearchVO(int pageSize, int pageNum) {
		super();
		this.pageSize = pageSize;
		this.pageNum = pageNum;
	}
	
	public SearchVO(int pageSize, int pageNum, String searchDiv, String searchWord) {
		super();
		this.pageSize = pageSize;
		this.pageNum = pageNum;
		this.searchDiv = searchDiv;
		this.searchWord = searchWord;
	}

	public SearchVO(String searchDiv, String searchWord, int pageSize, int pageNum, String searchStartDate,
			String searchEndDate) {
		super();
		this.searchDiv = searchDiv;
		this.searchWord = searchWord;
		this.pageSize = pageSize;
		this.pageNum = pageNum;
		this.searchStartDate = searchStartDate;
		this.searchEndDate = searchEndDate;
	}

	public String getSearchDiv() {
		return searchDiv;
	}

	public void setSearchDiv(String searchDiv) {
		this.searchDiv = searchDiv;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public String getSearchStartDate() {
		return searchStartDate;
	}

	public void setSearchStartDate(String searchStartDate) {
		this.searchStartDate = searchStartDate;
	}

	public String getSearchEndDate() {
		return searchEndDate;
	}

	public void setSearchEndDate(String searchEndDate) {
		this.searchEndDate = searchEndDate;
	}

	@Override
	public String toString() {
		return "SearchVO [searchDiv=" + searchDiv + ", searchWord=" + searchWord + ", pageSize=" + pageSize
				+ ", pageNum=" + pageNum + ", searchStartDate=" + searchStartDate + ", searchEndDate=" + searchEndDate
				+ ", toString()=" + super.toString() + "]";
	}
	
}
