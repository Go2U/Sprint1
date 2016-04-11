/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.controller.students;

import edu.eci.cosw.Go2U.model.student.Student;
import edu.eci.cosw.Go2U.services.students.ServiceStudent;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Cris
 */

@RestController
@RequestMapping("/api/stu")
public class StuController {
    
    @Autowired
    ServiceStudent students;
    
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void addStudent(@RequestBody Student s) {
        students.addStudent(s); 
    }
    
    @RequestMapping(value = "/upds/{id}",method = RequestMethod.POST)
    public void updateStudent(String id, Student s) {
        students.updateStudent(id, s);
    }
    
    @RequestMapping(method = RequestMethod.GET)    
    public List<Student> getStudents() {
        return students.getStudents();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student getStudentById(String id) {
        return students.getStudentById(id);
    }
    
}
