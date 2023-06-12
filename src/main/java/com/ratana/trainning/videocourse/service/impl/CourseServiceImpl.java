package com.ratana.trainning.videocourse.service.impl;

import com.ratana.trainning.videocourse.exception.ApiException;
import com.ratana.trainning.videocourse.model.Category;
import com.ratana.trainning.videocourse.model.Course;
import com.ratana.trainning.videocourse.repository.CategoryRepository;
import com.ratana.trainning.videocourse.repository.CourseRepository;
import com.ratana.trainning.videocourse.service.CategoryService;
import com.ratana.trainning.videocourse.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Course not found for id=%d.".formatted(id)));
    }
}
