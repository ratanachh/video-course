package com.ratana.trainning.videocourse.service;

import com.ratana.trainning.videocourse.exception.ApiException;
import com.ratana.trainning.videocourse.model.Category;
import com.ratana.trainning.videocourse.model.Course;
import com.ratana.trainning.videocourse.repository.CourseRepository;
import com.ratana.trainning.videocourse.service.impl.CourseServiceImpl;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CourseServiceTest {

    @Mock
    private CourseRepository courseRepository;
    private CourseService courseService;

    @BeforeEach
    public void setUp() {
        courseService = new CourseServiceImpl(courseRepository);
        Course course = Course.builder()
                .id(1L)
                .name("Java Basic")
                .build();
        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));
    }

    @Test
    public void testFindById_should_be_success() {
        Course courseReturn = courseService.findById(1L);
        assertNotNull(courseReturn);
        assertEquals("Java Basic", courseReturn.getName());
    }

    @Test
    public void testFindById_should_be_failed() {
        assertThatThrownBy(() -> courseService.findById(12L))
                .isInstanceOf(ApiException.class)
                .hasMessageStartingWith("Course not found for id=12");
    }


    @Test
    public void testFindAll_should_be_listAll() {
        //given
        Category category1 = Category.builder().id(1).name("Programming").build();
        Category category2 = Category.builder().id(2).name("Math").build();
        List<Course> courseList = List.of(
                new Course(1L, "Java Basic", category1),
                new Course(2L, "Math 12 BacII Basic", category2),
                new Course(3L, "Math 12 BacII Advance", category2)
        );
        //when
        when(courseRepository.findAll()).thenReturn(courseList);
        List<Course> coursesReturn = courseService.findAll();

        //then
        assertEquals(3, coursesReturn.size());
        assertEquals("Java Basic", coursesReturn.get(0).getName());
        assertNotNull(coursesReturn.get(0).getCategory());
        assertEquals("Programming", coursesReturn.get(0).getCategory().getName());

        assertEquals("Math 12 BacII Basic", coursesReturn.get(1).getName());
        assertNotNull(coursesReturn.get(1).getCategory());
        assertEquals("Math", coursesReturn.get(1).getCategory().getName());

        assertEquals("Math 12 BacII Advance", coursesReturn.get(2).getName());
        assertNotNull(coursesReturn.get(2).getCategory());
        assertEquals("Math", coursesReturn.get(2).getCategory().getName());
    }
}
