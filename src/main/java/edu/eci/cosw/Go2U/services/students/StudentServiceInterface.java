/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.services.students;


import edu.eci.cosw.Go2U.model.student.Student;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Cris
 */
public interface StudentServiceInterface {
    public void addStudent(Student s);
    public void updateStudent(String id, Student s);
    public List<Student> getStudents();
    public Student getStudentById(String id); 

}
