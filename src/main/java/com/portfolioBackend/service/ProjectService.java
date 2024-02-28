package com.portfolioBackend.service;

import com.portfolioBackend.Repo.ProjectRepo;
import com.portfolioBackend.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

    public List<Project> getAllProject(){
       return projectRepo.findAll();
    }

    public Project getById(Integer id){
        return projectRepo.findById(id).get();
    }

    public Project saveProject(Project project){
        return projectRepo.save(project);
    }
}
