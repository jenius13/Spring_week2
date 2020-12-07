package com.sparta.week2.service;

import com.sparta.week2.domain.Course;
import com.sparta.week2.domain.CourseRepository;
import com.sparta.week2.domain.CourseRequestDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CourseService {
    //final
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository){
        this.courseRepository=courseRepository;

    }
    @Transactional
    public Long update(Long id, CourseRequestDto requestDto){
        Course course1 = courseRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("Invalid ID")
        );

        course1.update(requestDto);
        return course1.getId();

    }

}
