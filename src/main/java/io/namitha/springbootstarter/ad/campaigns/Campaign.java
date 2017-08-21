package io.namitha.springbootstarter.ad.campaigns;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.namitha.springbootstarter.ad.Ad;


@Entity
public class Campaign {
	
	@Id
	private String Campaign_id;
	private int duration;
	private String Campaign_content;
	private String Campaign_created;	
	@ManyToOne
	private Ad ad;
	
	public Campaign() {
		
	}
	public Campaign(String Campaign_id, int duration, String Campaign_content,String partnerId) {
		super();
		this.Campaign_id = Campaign_id;
		this.duration = duration;
		this.Campaign_content = Campaign_content;
		this.ad = new Ad(partnerId,0,"");
	}
	public Ad getAd() {
		return ad;
	}
	public void setAd(Ad ad) {
		this.ad = ad;
	}
	public void setCampaign_id(String campaign_id) {
		Campaign_id = campaign_id;
	}
	public String getCampaign_id() {
		return Campaign_id;
	}
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getCampaign_content() {
		return Campaign_content;
	}

	public void setCampaign_content(String Campaign_content) {
		this.Campaign_content = Campaign_content;
	}
	public String getCampaign_created() {
		return Campaign_created;
	}
	public void setCampaign_created(String date) {
		this.Campaign_created = date;
	}
}
