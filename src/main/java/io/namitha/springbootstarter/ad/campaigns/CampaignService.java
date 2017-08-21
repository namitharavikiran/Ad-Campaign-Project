package io.namitha.springbootstarter.ad.campaigns;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampaignService {
	
	@Autowired
	private CampaignRepository campaignRepository;
	
	public List<Campaign> getAllCampaigns()
	{
		List<Campaign> campaigns = new ArrayList<Campaign>();
		campaignRepository.findAll()
		.forEach(campaigns::add);
		return campaigns;
	}
	
	public Campaign getCampaign(String id)
	{
		Campaign campaign= campaignRepository.findOne(id);
		return campaign;
	}
	
	public void addCampaign(Campaign campaign)
	{
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date currentDate = new Date();
		campaign.setCampaign_created(dateFormat.format(currentDate));
		campaignRepository.save(campaign);
	}
	public void updateCampaign(Campaign campaign,String id)
	{
		campaignRepository.save(campaign);
	}
	
	public void deleteCampaign(String id)
	{
		campaignRepository.delete(id);
	}
}
