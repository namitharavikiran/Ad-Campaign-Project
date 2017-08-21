package io.namitha.springbootstarter.ad.campaigns;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.namitha.springbootstarter.ad.Ad;




@RestController
public class CampaignController {
	
	@Autowired
	private CampaignService campaignService;
	
	@RequestMapping("/ad/{id}/campaigns")
	public List<Campaign> getAllCampaigns()
	{
		return campaignService.getAllCampaigns();
	}
	@RequestMapping("/ad/{adId}/campaigns/{id}")
	public Campaign getCampaign(@PathVariable String id)
	{
		return campaignService.getCampaign(id);
	}
	@RequestMapping(method=RequestMethod.POST,value="/ad/{adId}/campaigns")
	public void addCampaign(@RequestBody Campaign campaign,@PathVariable String adId)
	{
		campaign.setAd(new Ad(adId,0,""));
		campaignService.addCampaign(campaign);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/ad/{adId}/campaigns/{id}")
	public void updateCampaign(@RequestBody Campaign campaign,@PathVariable String id,@PathVariable String adId)
	{
		campaign.setAd(new Ad(adId,0,""));
		campaignService.updateCampaign(campaign,id);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/ad/{adId}/campaigns/{id}")
	public void deleteCampaign(@PathVariable String id)
	{
		campaignService.deleteCampaign(id);
	}
}
