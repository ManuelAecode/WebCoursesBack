package com.aecode.webcoursesback.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "classes")
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int classId;

    @ManyToOne
    @JoinColumn(name = "module_id", nullable = false)
    private Module module;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false, length = 255)
    private String videoUrl;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column( length = 255)
    private String document;

    @Column(nullable = false)
    private int durationMinutes;

    @Column(nullable = false)
    private int orderNumber;

    @Column()
    private LocalDateTime createdAt;

    @Column()
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "aclass", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ClassQuestion> classquestions = new HashSet<>();

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public Class() {
    }

    public Class(int classId, Module module, String title, String videoUrl, String description, String document, int durationMinutes, int orderNumber, LocalDateTime createdAt, LocalDateTime updatedAt, Set<ClassQuestion> classquestions) {
        this.classId = classId;
        this.module = module;
        this.title = title;
        this.videoUrl = videoUrl;
        this.description = description;
        this.document = document;
        this.durationMinutes = durationMinutes;
        this.orderNumber = orderNumber;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.classquestions = classquestions;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Set<ClassQuestion> getClassquestions() {
        return classquestions;
    }

    public void setClassquestions(Set<ClassQuestion> classquestions) {
        this.classquestions = classquestions;
    }
}
