package com.khrd.domain;

public class PageMaker {

	private int totalCount; // 게시물 전체 갯수
	private int startPage; // 현재 보이는 페이지 시작번호
	private int endPage; // 현재 보이는 페이지 끝 번호
	private boolean prev; // 이전 10개 존재여부
	private boolean next; // 이후 10개 존재여부
	private int displayPageNum = 10; // 보이는 페이지 숫자의 갯수

	private Criteria cri;

	private void calcData() {
		// 게시글 : 150개
		// 현재 선택 페이지 번호 : 15
		// 15 / 10 = 1.5 => 2 * 10 = 20
		// 현재 페이지의 끝 번호를 구한다. start 번호를 구하기 위해 필요
		endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);

		// 20 - 10 + 1 = 11
		// 현재 페이지의 시작 번호를 구한다,
		startPage = (endPage - displayPageNum) + 1;

		// 15
		// cri.getPerPageNum() : 한 페이지에 보여질 게시글 갯수
		// 전체 게시글이 153이고 선택 페이지가 15일때, 마지막 번호(endPage)는 16으로 나타내야 한다.
		// Math.ceil( 153/10 ) = 16
		int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));
		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}

		// 이전 페이지 여부(<<)
		if (startPage == 1) {
			prev = false;
		} else {
			prev = true;
		}

		// 이전 페이지 여부 (>>)
		if (endPage * cri.getPerPageNum() >= totalCount) {
			next = false;
		} else {
			next = true;
		}
	}

	public PageMaker() {

	}

	public PageMaker(int totalCount, int startPage, int endPage, boolean prev, boolean next, int displayPageNum,
			Criteria cri) {
		super();
		this.totalCount = totalCount;
		this.startPage = startPage;
		this.endPage = endPage;
		this.prev = prev;
		this.next = next;
		this.displayPageNum = displayPageNum;
		this.cri = cri;
	}

	

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		calcData();
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", cri=" + cri + "]";
	}

}
