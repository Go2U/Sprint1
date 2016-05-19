 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.services.universities;

import edu.eci.cosw.Go2U.model.universities.Carrer;
import edu.eci.cosw.Go2U.model.universities.University;
import edu.eci.cosw.Go2U.persistence.CarrerRepository;
import edu.eci.cosw.Go2U.persistence.UniversityRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author miguelromero
 */
@Service
public class ServiceUniversity implements UnivServiceInterface{    
    
    @Autowired
    UniversityRepository university;
    @Autowired
    CarrerRepository carrer;
    
    
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

    @Override //Probado
    public List<Carrer> getUniversityCarrers(String id) {
        return university.getOne(id).getCarrers();
    }

    @Override
    public java.sql.Blob getUniversityLogo(String id) {
        return university.findLogoById(id);
    }

    @Override //Probado
    public void setUniversityCarrer(String id, List<Carrer> carrers) {        
        University u= university.getOne(id);
        List<Carrer> carrersTemp=u.getCarrers();
        for(Carrer c: carrers) {
            if(!u.existCarrer(c)){
                List<University> uAux=c.getUniversities();
                uAux.add(u);
                c.setUniversities(uAux);
                carrer.save(c);
                carrersTemp.add(c);
            }
        }
        u.setCarrers(carrersTemp);
        university.save(u);
    }

    @Override //Probado
    public void updateUniversity(String id, University u) {
        university.save(u);
    }
    
    @Override
    public ArrayList<Carrer> getAllCarrers(){
        return carrer.getAllCarrers();
    }
    
    @Override
    public String getUniversitySNIES(String id){
        Map<String, String> vars = new HashMap<String, String>();
        vars.put("nit", id);
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://estudiantes.is.escuelaing.edu.co/~3069593/simulacion.php?nit={nit}", String.class, vars);
        return result;
    }
    
    @Override
    public boolean existUniversity(String id){
        return university.exists(id);
    }
    
}
