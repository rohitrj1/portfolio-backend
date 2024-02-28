package com.portfolioBackend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.portfolioBackend.entity.Testimonial;
import com.portfolioBackend.service.TestimonialService;


import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/testimonial")
@CrossOrigin("*")
@Slf4j
public class TestimonialController {

    @Autowired
    private TestimonialService testimonialService;
    

//    @CrossOrigin
//    @PostMapping
//    public ResponseEntity<?> saveFeedbcak(
//            @RequestParam("profile_img")MultipartFile profile_img,
//            @RequestParam("name") String name,
//            @RequestParam("email") String email,
//            @RequestParam("designation") String designation,
//            @RequestParam("feedback") String feedback
//            ){
//    	
//    	log.info("add testimonial request ...");
//    	log.info("File information {}",profile_img.getOriginalFilename());
//    	log.info("profile_img : {}", profile_img);
//    	log.info(null);
//    	
//    	return ResponseEntity.ok("done");
//    	
////        return ResponseEntity.ok(testimonialService.saveFeedback(profile_img));
//    }
    
    @CrossOrigin
    @PostMapping
    public ResponseEntity<?> saveFeedbcak( @RequestParam("profile_img")MultipartFile file,@ModelAttribute Testimonial testimonial) throws IOException{
    		log.info(" testimonial :{}",testimonial);
    		log.info("file :{}",file);
    		log.info("File information {}",file.getOriginalFilename());
    	return ResponseEntity.ok(testimonialService.saveFeedback(file,testimonial));
    }

    @GetMapping
    public ResponseEntity<List<Testimonial>> getAllFeedback(){
        return new ResponseEntity<>(testimonialService.getAllFeedback(),HttpStatus.OK);
    }
    
//    @GetMapping
//    public ResponseEntity<List<Testimonial>> getAllFeedback(){
//        return new ResponseEntity<>(testimonialService.getAll(),HttpStatus.OK);
//    }
    
    @GetMapping("/{id}/image")
    public ResponseEntity<?> getImageTestimonial(@PathVariable Integer id){
    	byte[] imageData=testimonialService.downloadImage(id);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(imageData);

    }
}
