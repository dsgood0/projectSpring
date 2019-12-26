package com.khrd.domain;

public class PageMaker {

	private int totalCount; // �Խù� ��ü ����
	private int startPage; // ���� ���̴� ������ ���۹�ȣ
	private int endPage; // ���� ���̴� ������ �� ��ȣ
	private boolean prev; // ���� 10�� ���翩��
	private boolean next; // ���� 10�� ���翩��
	private int displayPageNum = 10; // ���̴� ������ ������ ����

	private Criteria cri;

	private void calcData() {
		// �Խñ� : 150��
		// ���� ���� ������ ��ȣ : 15
		// 15 / 10 = 1.5 => 2 * 10 = 20
		// ���� �������� �� ��ȣ�� ���Ѵ�. start ��ȣ�� ���ϱ� ���� �ʿ�
		endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);

		// 20 - 10 + 1 = 11
		// ���� �������� ���� ��ȣ�� ���Ѵ�,
		startPage = (endPage - displayPageNum) + 1;

		// 15
		// cri.getPerPageNum() : �� �������� ������ �Խñ� ����
		// ��ü �Խñ��� 153�̰� ���� �������� 15�϶�, ������ ��ȣ(endPage)�� 16���� ��Ÿ���� �Ѵ�.
		// Math.ceil( 153/10 ) = 16
		int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));
		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}

		// ���� ������ ����(<<)
		if (startPage == 1) {
			prev = false;
		} else {
			prev = true;
		}

		// ���� ������ ���� (>>)
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
