/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.services.students;

import edu.eci.cosw.Go2U.model.student.Student;
import edu.eci.cosw.Go2U.persistence.StudentRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cris
 */
@Service
public class ServiceStudent implements StudentServiceInterface{
    public static ArrayList<Student> Students = new ArrayList<>(); //Esto toca borrarlo y usar el repositorio
    
    @Autowired
    StudentRepository student;
    
    @Override
    public void addStudent(Student s) {
        Students.add(s); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateStudent(String un, Student s) {
        for (Student Student1: Students) {
            if (Student1.getUsername().compareTo(un)==0){
                Student1.setName(s.getName());
                Student1.setLastName(s.getLastName());
                Student1.setGender(s.getGender());
                Student1.setAddress(s.getAddress());
                Student1.setCellPhone(s.getCellPhone());
            }
        }
    }

    @Override
    public ArrayList<Student> getStudents() {
        return Students;
    }

    @Override
    public Student getStudentById(String id) {
        Student r = null;
        for (Student Student1 : Students) {
            if (Student1.getUsername().compareTo(id)==0){
                r = Student1;               
            }
        }
        return r;
    }
    
}
