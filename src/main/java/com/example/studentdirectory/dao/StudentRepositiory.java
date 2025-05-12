package com.example.studentdirectory.dao;

import com.example.studentdirectory.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositiory extends JpaRepository<Student, Integer>
{

}
