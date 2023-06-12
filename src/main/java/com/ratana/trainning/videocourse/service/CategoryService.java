package com.ratana.trainning.videocourse.service;

import com.ratana.trainning.videocourse.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(Integer id);
}
