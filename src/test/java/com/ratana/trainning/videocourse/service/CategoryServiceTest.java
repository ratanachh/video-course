package com.ratana.trainning.videocourse.service;

import com.ratana.trainning.videocourse.exception.ApiException;
import com.ratana.trainning.videocourse.model.Category;
import com.ratana.trainning.videocourse.repository.CategoryRepository;
import com.ratana.trainning.videocourse.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;
    private CategoryService categoryService;

    @BeforeEach
    public void setUp() {
        categoryService = new CategoryServiceImpl(categoryRepository);
        Category category = Category.builder()
                .id(1)
                .name("Programming")
                .build();
        when(categoryRepository.findById(1)).thenReturn(Optional.of(category));
    }

    @Test
    public void testFindById_should_be_success() {
        Category categoryReturn = categoryService.findById(1);
        assertNotNull(categoryReturn);
        assertEquals("Programming", categoryReturn.getName());
    }

    @Test
    public void testFindById_should_be_failed() {
        assertThatThrownBy(() -> categoryService.findById(12))
                .isInstanceOf(ApiException.class)
                .hasMessageStartingWith("Category not found for id=12");
    }


    @Test
    public void testFindAll_should_be_listAll() {
        //given
        List<Category> categoryList = List.of(
                new Category(1, "Programming"),
                new Category(2, "Mathematics")
        );
        //when
        when(categoryRepository.findAll()).thenReturn(categoryList);
        List<Category> categoriesReturn = categoryService.findAll();

        //then
        assertEquals(2, categoriesReturn.size());
        assertEquals("Programming", categoriesReturn.get(0).getName());
        assertEquals("Mathematics", categoriesReturn.get(1).getName());
    }
}
