package com.portfolioBackend.Repo;

import com.portfolioBackend.entity.Testimonial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestimonialRepo extends JpaRepository<Testimonial,Integer> {
}
