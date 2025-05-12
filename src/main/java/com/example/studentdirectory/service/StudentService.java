package com.example.studentdirectory.service;

import com.example.studentdirectory.dao.StudentRepositiory;
import com.example.studentdirectory.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService
{
    @Autowired
    StudentRepositiory studentRepositiory;
    /*
    //for without db
    private List<Student> stud=new ArrayList<>(Arrays.asList(
            new Student(23,"rahul","rahul@.com","cse",1),
            new Student(23,"jack","jack@.com","cse",2),
            new Student(22,"jenny","jenny@.com","ec",3)));
            */
    private int idcount=1;

    public List<Student> getAll(){
      return studentRepositiory.findAll();
    }
    public Student getById(int id)
    {
        return studentRepositiory.findById(id).orElse(null);
    }

    public Student addStudent(Student st)
    {
        System.out.println(" stundent added");
      return studentRepositiory.save(st);
    }
    public Student updateStud(int id,Student updateStud) {

        Student st = studentRepositiory.findById(id).orElseThrow( null);
        st.setAge(updateStud.getAge());
        st.setName(updateStud.getName());
        st.setCourse(updateStud.getCourse());
        st.setEmail(updateStud.getEmail());
        return studentRepositiory.save(st);
    }
    public void deleteStudent(int id) {
        Student st = studentRepositiory.findById(id).orElse(null);
        studentRepositiory.delete(st);
    }
}
