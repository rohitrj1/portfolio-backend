package com.portfolioBackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer project_id;
    private String project_title;
    private String img_url;
    private String video_url;
    private String github_repo;
    private boolean is_source_code_avbl;
    private String description;
    private String short_description;
    



}
