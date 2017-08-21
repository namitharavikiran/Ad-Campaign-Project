package io.namitha.springbootstarter.ad;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.namitha.springbootstarter.ad.model.CustomException;

@Service
public class AdService {
	
	@Autowired
	private AdRepository adRepository;
	
	public List<Ad> getAllAds()
	{
		List<Ad> ads = new ArrayList<Ad>();
		adRepository.findAll()
		.forEach(ads::add);
		return ads;
	}
	
	public Ad getAd(String id) throws ParseException,CustomException
	{
		Ad ad= adRepository.findOne(id);
		String startDateString = ad.getDate_created();
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss"); 
		Date startDate;
		startDate = df.parse(startDateString);
		   if(startDate.getTime()+ad.getDuration() < new Date().getTime())
		   {
			 throw new CustomException();
		   }		
		return ad;
		}
	
	public void addAd(Ad ad)
	{
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date currentDate = new Date();
      	ad.setDate_created(dateFormat.format(currentDate));
		adRepository.save(ad);
	}
	public void updateAd(Ad ad,String id)
	{
		adRepository.save(ad);
	}
	
	public void deleteAd(String id)
	{
		adRepository.delete(id);
	}
}
