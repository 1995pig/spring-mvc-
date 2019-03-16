package cn.mldn.goods.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Subitem implements Serializable {
	private Long iid;
	private Long sid;
	private String title;
	public Long getIid() {
		return iid;
	}
	public void setIid(Long iid) {
		this.iid = iid;
	}
	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Subitem [iid=" + iid + ", sid=" + sid + ", title=" + title + "]";
	}
	
}
