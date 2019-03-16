package cn.mldn.goods.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Goods implements Serializable {
	private Long gid;
	private Long iid;
	private Long sid;
	private String title;
	private Double price;
	private String photo;
	private Integer delflag;
	public Long getGid() {
		return gid;
	}
	public void setGid(Long gid) {
		this.gid = gid;
	}
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Integer getDelflag() {
		return delflag;
	}
	public void setDelflag(Integer delflag) {
		this.delflag = delflag;
	}
	@Override
	public String toString() {
		return "Goods [gid=" + gid + ", iid=" + iid + ", sid=" + sid + ", title=" + title + ", price=" + price
				+ ", photo=" + photo + ", delflag=" + delflag + "]";
	}
	
	 
}
