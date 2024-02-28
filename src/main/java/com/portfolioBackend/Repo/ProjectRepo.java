package com.portfolioBackend.Repo;

import com.portfolioBackend.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project,Integer> {

}
