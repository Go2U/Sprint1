 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.services.universities;

import com.mysql.jdbc.Blob;
import edu.eci.cosw.Go2U.model.universities.Carrer;
import edu.eci.cosw.Go2U.model.universities.University;
import edu.eci.cosw.Go2U.persistence.UniversityRepository;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author miguelromero
 */
@Service
public class ServiceUniversity implements UnivServiceInterface{    
    
    @Autowired
    UniversityRepository university;
    
    
    @Override //Probado
    public void addUniversity(University u) {
        university.save(u);
    }

    @Override //Probado
    public List<University> getUniversities() {
        return university.findAll();
    }
    
    @Override //Probado
    public University getUniversityById(String id) {
        return university.findOne(id);
    }

    @Override //En proceso
    public List<Carrer> getUniversityCarrers(String id) {
        return university.getOne(id).getCarrers();
    }

    @Override
    public java.sql.Blob getUniversityLogo(String id) {
        return university.findLogoById(id);
    }

    @Override //En proceso
    public void setUniversityCarrer(String id, List<Carrer> carrers) {
//        University u= university.getOne(id);
        List<Carrer> carrersTemp=university.getOne(id).getCarrers();
        System.out.println("$$$$$$$$$$$$$$$$$$$/ "+carrersTemp.size());
        for(Carrer c: carrers) {
            if(!university.getOne(id).existCarrer(c)){
                c.setUniversities(university.getOne(id));
                carrersTemp.add(c);
            }
        }
        System.out.println("$$$$$$$$$$$$$$$$$$$// "+carrersTemp.size());        
        
        university.getOne(id).setCarrers(carrersTemp);
        
        System.out.println("$$$$$$$$$$$$$$$$$$$ "+university.getOne(id).getCarrers().size());
    }

    @Override //Probado
    public void updateUniversity(String id, University u) {
        university.save(u);
    }
    
}
