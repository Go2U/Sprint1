/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.services.students;

import edu.eci.cosw.Go2U.model.result.Result;
import edu.eci.cosw.Go2U.model.student.Student;
import edu.eci.cosw.Go2U.persistence.ResultRepository;
import edu.eci.cosw.Go2U.persistence.StudentRepository;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cris
 */
@Service
public class ServiceStudent implements StudentServiceInterface{
    
    @Autowired
    StudentRepository student;

    
    @Override //Probado
    public void addStudent(Student s) {
        student.save(s);
    }

    @Override //Probado
    public void updateStudent(String un, Student s) {
        student.save(s);
    }

    @Override //Probado
    public List<Student> getStudents() {
        return student.findAll();
    }

    @Override //Probado
    public Student getStudentById(String id) {
        return student.getOne(id);
    }

    
}
