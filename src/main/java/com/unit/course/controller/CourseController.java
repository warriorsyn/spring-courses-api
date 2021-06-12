package com.unit.course.controller;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.unit.course.dto.CourseDto;
import com.unit.course.model.Course;
import com.unit.course.repository.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/curso")
public class CourseController {

    @Autowired
    private CourseRepository _courseRepository;

    @GetMapping
    public List<CourseDto> index() {
        List<Course> courses = this._courseRepository.findAll();

        List<CourseDto> courseDto = new ArrayList<CourseDto>();

        for (int i = 0; i < courses.size(); i++) {
            courseDto.add(new CourseDto(courses.get(i)));
        }

        return courseDto;
    }

    @GetMapping("{id}")
    public ResponseEntity<CourseDto> show(@PathVariable Long id) {
        Optional<Course> course = _courseRepository.findById(id);

        if (!course.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<CourseDto>(new CourseDto(course.get()), HttpStatus.OK);
    }

    @PostMapping
    public CourseDto store(@RequestBody CourseDto request) {
        Course course = _courseRepository.save(request.toEntity());

        return new CourseDto(course);
    }

    @PutMapping("{id}")
    public CourseDto update(@RequestBody CourseDto request, @PathVariable Long id) {
        Course course = _courseRepository.findById(id).map(item -> {
            item.setNome(request.getNome());
            item.setDescricao(request.getDescricao());
            item.setEmenta(request.getEmenta());
            item.setDataCadastro(request.getDataCadastro());
            item.setDataInicio(request.getDataInicio());
            item.setValor(request.getValor());
            return _courseRepository.save(item);
        }).orElseGet(() -> {
            request.setid(id);
            return _courseRepository.save(request.toEntity());
        });

        return new CourseDto(course);
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable Long id) {
        _courseRepository.deleteById(id);
    }
}
