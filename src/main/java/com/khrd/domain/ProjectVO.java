package com.khrd.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ProjectVO {
	private int no;
	private String title;
	private String content;
	@DateTimeFormat(pattern = "yyyy-MM-dd") // simpledateformat 대신에 사용
	private Date startdate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date enddate;
	private int state;

	public ProjectVO() {
		
	}

	public ProjectVO(int no, String title, String content, Date startdate, Date enddate, int state) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.startdate = startdate;
		this.enddate = enddate;
		this.state = state;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "ProjectVO [no=" + no + ", title=" + title + ", content=" + content + ", startdate=" + startdate
				+ ", enddate=" + enddate + ", state=" + state + "]";
	}

}
