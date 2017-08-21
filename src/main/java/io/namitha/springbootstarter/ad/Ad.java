package io.namitha.springbootstarter.ad;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ad {
	
	@Id
	private String partner_id;
	private int duration;
	private String ad_content;
	private String date_created;	
	
	public Ad() {
		
	}
	public Ad(String partner_id, int duration, String ad_content) {
		super();
		this.partner_id = partner_id;
		this.duration = duration;
		this.ad_content = ad_content;
	}
	public String getPartner_id() {
		return partner_id;
	}

	public void setPartner_id(String partner_id) {
		this.partner_id = partner_id;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getAd_content() {
		return ad_content;
	}

	public void setAd_content(String ad_content) {
		this.ad_content = ad_content;
	}
	public String getDate_created() {
		return date_created;
	}
	public void setDate_created(String date) {
		this.date_created = date;
	}
}
