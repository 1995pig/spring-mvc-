package cn.mldn.goods.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Item implements Serializable {
	private Long iid;
	private String title;
	public Long getIid() {
		return iid;
	}
	public void setIid(Long iid) {
		this.iid = iid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Item [iid=" + iid + ", title=" + title + "]";
	}
	
}
