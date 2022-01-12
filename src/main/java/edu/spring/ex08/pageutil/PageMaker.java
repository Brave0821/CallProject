package edu.spring.ex08.pageutil;

// 페이지 번호들의 링크를 만들기 위한 유틸리티 클래스
public class PageMaker {
	private PageCriteria criteria; // criteria 기준이란 뜻
	private int totalCount; // 전체 게시글 개수
	private int numsOfPageLinks; // 페이지 번호 링크의 개수
	private int startPageNo; // 시작 페이지 링크 번호
	private int endPageNo; // 끝 페이지 링크 번호
	private boolean hasPrev; // 화면에 보이는 시작 페이지 번호보다 작은 숫자의 페이지가 "있는 지 or 없는 지"
	private boolean hasNext; // 화면에 보이는 끝 페이지 번호보다 큰 숫자의 페이지가 있는 지
	
	public PageMaker() {
		this.numsOfPageLinks = 3; // 아래 1~10페이지 번호 링크 수. 3개씩 보여줌!
	}
	
	public PageCriteria getCriteria() {
		return criteria;
	}
	
	public void setCriteria(PageCriteria criteria) {
		this.criteria = criteria;
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	public int getNumsOfPageLinks() {
		return numsOfPageLinks;
	}
	
	public int getStartPageNo() {
		return startPageNo;
	}
	
	public int getEndPageNo() {
		return endPageNo;
	}
	
	public boolean isHasPrev() {
		return hasPrev;
	}
	
	public boolean isHasNext() {
		return hasNext;
	}
	
	// startPageNo, endPageNo, hasPrev, hasNext 값을 계산 및 세팅
	public void setPageData() {
		int totalLinkNo = (int) Math.ceil((double) totalCount / criteria.getNumsPerPage());
											// 총 페이지 / 현 페이지 갯수 = 아래 페이지 링크 갯수 (반올림 필수)
		int temp = (int) Math.ceil((double) criteria.getPage() / numsOfPageLinks) * numsOfPageLinks;
											//  현재 페이지 / 페이지 번호 링크 수 = 
		if (temp > totalLinkNo) {
			endPageNo = totalLinkNo;
		} else {
			endPageNo = temp;
		}
		
		startPageNo = ((endPageNo - 1) / numsOfPageLinks) * numsOfPageLinks + 1;
		
		if (startPageNo == 1) {
			hasPrev = false;
		} else {
			hasPrev = true;
		}
		
		if (endPageNo * criteria.getNumsPerPage() >= totalCount) {
			hasNext = false;
		} else {
			hasNext = true;
		}
		// Math.ceil (올림)
		// Math.floor (버림)
		
	}
	
} // end PageMaker
