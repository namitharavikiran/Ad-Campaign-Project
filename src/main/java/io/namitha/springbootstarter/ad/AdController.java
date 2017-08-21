package io.namitha.springbootstarter.ad;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.namitha.springbootstarter.ad.model.CustomException;

@RestController
public class AdController {
	
	@Autowired
	private AdService adService;
	
	@RequestMapping("/ad")
	public List<Ad> getAllAds()
	{
		return adService.getAllAds();
	}
	@RequestMapping("/ad/{id}")
	public Ad getAd(@PathVariable String id)throws ParseException,CustomException
	{
		return adService.getAd(id);
	}
	@RequestMapping(method=RequestMethod.POST,value="/ad")
	public void addAd(@RequestBody Ad ad)
	{
		adService.addAd(ad);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/ad/{id}")
	public void updateAd(@RequestBody Ad ad,@PathVariable String id)
	{
		adService.updateAd(ad,id);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/ad/{id}")
	public void deleteAd(@PathVariable String id)
	{
		adService.deleteAd(id);
	}
}
