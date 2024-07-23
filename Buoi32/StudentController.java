package com.test.restfulapi.controller;

import com.test.restfulapi.request.StudentRequest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

  public List<StudentRequest> students = new ArrayList<>();


  @PostMapping("/add")
  public ResponseEntity<?> addStudent(@RequestParam String name, @RequestParam int age) {
    StudentRequest studentRequest = new StudentRequest();
    studentRequest.setName(name);
    studentRequest.setAge(age);
    students.add(studentRequest);

    return ResponseEntity.ok(studentRequest);

  }

  @PostMapping("/add/{name}/{age}")
  public ResponseEntity<?> addStudents(@PathVariable String name, @PathVariable int age) {
    StudentRequest studentRequest = new StudentRequest();
    studentRequest.setName(name);
    studentRequest.setAge(age);
    students.add(studentRequest);

    return ResponseEntity.ok(studentRequest);

  }

  @PostMapping("/addBody")
  public ResponseEntity<?> addStudent(@RequestBody StudentRequest studentRequest) {
    students.add(studentRequest);
    return ResponseEntity.ok(studentRequest);
  }

}
