/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.services.test;

import edu.eci.cosw.Go2U.model.test.AnswerCarrer;
import edu.eci.cosw.Go2U.model.test.Answers;
import edu.eci.cosw.Go2U.model.test.Test;
import edu.eci.cosw.Go2U.model.test.Questions;
import edu.eci.cosw.Go2U.model.test.idAnswerCarrer;
import edu.eci.cosw.Go2U.persistence.AnswerCarrerRepository;
import edu.eci.cosw.Go2U.persistence.TestRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cbonilla
 */
@Service
public class ServiceTestUniversity implements ServiceTestUniversityInterface{    

    @Autowired
    TestRepository test;
    
    @Autowired
    AnswerCarrerRepository ACR;
    
    public ServiceTestUniversity(){
    }

    @Override
    public void setIdUniversity(String university) {        
    }
    
    @Override
    public List<Questions> getTest(String university) {
        Test prueba1 = test.findTest(university);
        if(prueba1==null){
            prueba1 = new Test();
            prueba1.setIdUniversity(university);
        }
        return prueba1.getQuestions();
    }

    @Override
    public void addQuestions(String u, Questions q) {
        Test t = test.findTest(u);
        Questions qt = q.cloneQ();
        for(Answers h:q.getAnswer()){
            h.setAcademicProgramC(null);
        }
        if(t==null){
            t = new Test(u);
        }
        t.setQuestion(q);
        test.save(t);
        t = test.findTest(u);
        int lon = t.getQuestions().size()-1;
        Questions qt1 = t.getQuestions().get(lon);
        
        for(int i=0;i<qt1.getAnswer().size();i++){
            int k = qt1.getAnswer().get(i).getIdAnswer();
            Answers a =new Answers();
            List<AnswerCarrer> academicProgramC = qt.getAnswer().get(i).getAcademicProgramC();
            for(int j=0;j<academicProgramC.size();j++){
                AnswerCarrer ansC = new AnswerCarrer();
                idAnswerCarrer id =new idAnswerCarrer();
                id.setIdAnswer(k);
                id.setIdCarrer(academicProgramC.get(j).getId().getIdCarrer());
                ansC.setId(id);
                ansC.setValSum(academicProgramC.get(j).getValSum());
                ACR.save(ansC);
            }
        }
    }
}
