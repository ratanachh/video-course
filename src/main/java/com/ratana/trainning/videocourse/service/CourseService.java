package com.ratana.trainning.videocourse.service;

import com.ratana.trainning.videocourse.model.Category;
import com.ratana.trainning.videocourse.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();
    Course findById(Long id);
}
