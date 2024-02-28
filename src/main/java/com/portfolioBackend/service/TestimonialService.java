package com.portfolioBackend.service;


import com.portfolioBackend.Repo.TestimonialRepo;
import com.portfolioBackend.entity.Testimonial;
import com.portfolioBackend.util.ImageUtils;

import lombok.extern.slf4j.Slf4j;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class TestimonialService {

    @Autowired
    private TestimonialRepo testimonialRepo;

    public Testimonial saveFeedback(MultipartFile profile_img,Testimonial testimonial) throws IOException{

    	log.info("add testimonial request ...");
    	log.info("File information {}",profile_img.getOriginalFilename());
    	log.info("profile_img : {}", profile_img);
    	testimonial.setImageName(profile_img.getOriginalFilename());
    	testimonial.setType(profile_img.getContentType());
    	testimonial.setUpdated_at(new Date());
    	testimonial.setImageData(profile_img.getBytes());
    	return testimonialRepo.save(testimonial);
    	
    	
//    	uploadImage(profile_img,testimonial);
//    	return testimonial;
    }
    
    
//    public String uploadImage(MultipartFile file,Testimonial testimonial) throws IOException {
//    
//        if (testimonial.getImageName() != null) {
//        	log.info("file uploaded successfully : " + testimonial.getImageName());
//        }
//        return null;
//    }

//    public byte[] downloadImage(String fileName){
//        Optional<ImageData> dbImageData = testimonialRepo.findByName(fileName);
//        byte[] images=ImageUtils.decompressImage(dbImageData.get().getImageData());
//        return images;
//    }
    
    
    public byte[] downloadImage(Integer id) {
    	Optional<Testimonial> byId = testimonialRepo.findById(id);
    	byte[] images=ImageUtils.decompressImage(byId.get().getImageData());
    	return images;
    }
    
//    public List<Testimonial> getAll(){
//    	List<Testimonial> alltest = new ArrayList<>();
//    	List<Testimonial> all = testimonialRepo.findAll();
//    	for(Testimonial t:all ) {
//    		Optional<Testimonial> byId = testimonialRepo.findById(t.getId());
//        	byte[] images=ImageUtils.decompressImage(byId.get().getImageData());
//        	alltest.add(t);
//    	}
//    	return alltest;
//    }
    

    public List<Testimonial> getAllFeedback(){
        return testimonialRepo.findAll();
    }
}
