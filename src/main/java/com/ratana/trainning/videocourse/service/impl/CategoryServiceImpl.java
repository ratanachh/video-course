package com.ratana.trainning.videocourse.service.impl;

import com.ratana.trainning.videocourse.exception.ApiException;
import com.ratana.trainning.videocourse.model.Category;
import com.ratana.trainning.videocourse.repository.CategoryRepository;
import com.ratana.trainning.videocourse.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Category not found for id=%d.".formatted(id)));
    }
}
