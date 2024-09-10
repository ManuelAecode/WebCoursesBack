package com.aecode.webcoursesback.dtos;

import java.util.Set;

public class CourseDTO {
    private int courseId;
    private String title;
    private String description;
    private String instructor;
    private String image;
    private Set<ModuleDTO> modules;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<ModuleDTO> getModules() {
        return modules;
    }

    public void setModules(Set<ModuleDTO> modules) {
        this.modules = modules;
    }
}
