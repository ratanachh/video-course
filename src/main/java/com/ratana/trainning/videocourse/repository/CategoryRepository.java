package com.ratana.trainning.videocourse.repository;

import com.ratana.trainning.videocourse.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Integer, Category> {
}
