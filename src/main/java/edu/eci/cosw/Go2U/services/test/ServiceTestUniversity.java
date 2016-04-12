/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.services.test;

import edu.eci.cosw.Go2U.model.test.Test;
import edu.eci.cosw.Go2U.model.test.Questions;
import edu.eci.cosw.Go2U.persistence.QuestionRepository;
import edu.eci.cosw.Go2U.persistence.TestRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cbonilla
 */
@Service
public class ServiceTestUniversity implements ServiceTestUniversityInterface{    
    Test prueba = new Test();
    
    @Autowired
    QuestionRepository test;
    
    public ServiceTestUniversity(){
    }

    @Override
    public void setIdUniversity(String university) {
//        prueba.setIdUniversity(university);
//        test.findTest(university);
        
    }
    
    @Override
    public List<Questions> getTest() {
        /*List<Test> h = test.findAll();
        System.out.println("\n\n\n\n\n\n\n entra "+h.size()+" ");
        if(h.size()>0){
            System.out.println("con"+h.size()+"\n\n\n\n\n\n\n\n");
            return h.get(0).getQuestions();
        }else{
            System.out.println("sin \n\n\n\n\n\n\n\n");
            return prueba.getQuestions();
        }
        /*String university = "eci";
        System.out.println("\n\n\n\n\n\n\n entra" + university + "\n\n\n\n\n\n\n\n");
        Test y = test.findTest(university);
        if(y!=null){
            List<Questions> h = y.getQuestions();
            System.out.println("con"+h.size()+"\n\n\n\n\n\n\n\n");
            return h;
        }else{
            System.out.println("sin \n\n\n\n\n\n\n\n");
            return prueba.getQuestions();
        }*/
//        System.out.println("\n\n\n\n\n\n\n entra ");
//        test.count();
        return prueba.getQuestions();
//        return test.findAll();
    }
    
    @Override
    public List<Questions> getTest(String university) {
        /*System.out.println("\n\n\n\n\n\n\n entra" + university + "\n\n\n\n\n\n\n\n");
        if(test.findAll().size()>0){
            List<Questions> h = test.findTest(university).getQuestions();
            System.out.println("con"+h.size()+"\n\n\n\n\n\n\n\n");
            return h;
        }else{
            System.out.println("sin \n\n\n\n\n\n\n\n");
            return prueba.getQuestions();
        }*/
        return prueba.getQuestions();
//        return test.findAll();
    }

    @Override
    public void addQuestions(Questions q) {
//        System.out.println("\n\n\njjj\n\n\n");
//        q.setIdQuestion(1+(int)test.count());
//        test.save(q);
        prueba.setQuestion(q);
    }
    
    @Override
    public void Save() {
//        test.save(prueba);
    }
}
