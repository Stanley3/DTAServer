package com.dta.bean;

import java.io.Serializable;

import javax.ws.rs.FormParam;

import com.dta.vo.PageParam;

//@XmlRootElement
public class NewsInfo extends PageParam  implements Serializable{
	private static final long serialVersionUID = 1L;
	@FormParam("news_info_id")
	private Integer news_info_id;
	@FormParam("sender")
	private Integer sender;
	@FormParam("send_time")
	private String send_time;
	@FormParam("content")
	private String content;
	@FormParam("receiver_type")
	private Integer receiver_type;
	@FormParam("attribude")
	private Integer attribude;
	public void setNews_info_id(Integer news_info_id){
		this.news_info_id = news_info_id;
	}
	public Integer getNews_info_id() {
		return news_info_id;
	}
	public void setSender(Integer sender){
		this.sender = sender;
	}
	public Integer getSender() {
		return sender;
	}
	public void setSend_time(String send_time){
		this.send_time = send_time;
	}
	public String getSend_time() {
		return send_time;
	}
	public void setContent(String content){
		this.content = content;
	}
	public String getContent() {
		return content;
	}
	public void setReceiver_type(Integer receiver_type){
		this.receiver_type = receiver_type;
	}
	public Integer getReceiver_type() {
		return receiver_type;
	}
	public void setAttribude(Integer attribude){
		this.attribude = attribude;
	}
	public Integer getAttribude() {
		return attribude;
	}
}
