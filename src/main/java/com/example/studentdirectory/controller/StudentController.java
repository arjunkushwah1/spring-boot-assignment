package com.example.studentdirectory.controller;
import java.util.*;
import com.example.studentdirectory.model.Student;
import com.example.studentdirectory.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController
{
    @Autowired
    private StudentService studentService;

    @GetMapping()
    public List<Student> getAll()
    {
        List<Student> listOfAllStudent = studentService.getAll();
        return listOfAllStudent;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable int id)
    {
        Student  st = studentService.getById(id);
        return ResponseEntity.ok(st);
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student st)
    {
       Student create = studentService.addStudent(st);
       return ResponseEntity.ok(create);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id,@RequestBody Student st)
    {
        Student updatedStudent  = studentService.updateStud(id,st);
        return ResponseEntity.ok(updatedStudent);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id)
    {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

}
