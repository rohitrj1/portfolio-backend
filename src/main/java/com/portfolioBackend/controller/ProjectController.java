package com.portfolioBackend.controller;

import com.portfolioBackend.entity.Project;
import com.portfolioBackend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@CrossOrigin("*")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects(){

        return new ResponseEntity<>(projectService.getAllProject(),HttpStatus.OK) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getBuId(@PathVariable Integer id){
        return new ResponseEntity<>(projectService.getById(id),HttpStatus.OK) ;
    }

    @PostMapping("/saveProject")
    public ResponseEntity<Project> saveProject(@RequestBody Project project){
        Project project1 = projectService.saveProject(project);
        return new ResponseEntity<>(project1, HttpStatus.CREATED);

    }
}
