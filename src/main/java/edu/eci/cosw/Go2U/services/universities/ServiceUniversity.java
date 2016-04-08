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
    public static ArrayList<Carrer> carrers = new ArrayList<Carrer>() {{add(new Carrer(1000,"c1","d1")); add(new Carrer(1001,"c2","d2"));}};
    public static List<University> Universities = new ArrayList<University>() {{ add(new University("eci","eci", carrers)); add(new University("ros","ros", carrers));}};
    
    @Autowired
    UniversityRepository university;
    
    @Override
    public void addUniversity(University u) {
        university.save(u);
    }

    @Override
    public List<University> getUniversities() {
        return university.findAll();
    }
    
    @Override
    public University getUniversityById(String id) {
        return university.findOne(id);
    }

    @Override
    public List<Carrer> getUniversityCarrers(String id) {
//        ArrayList<Carrer> ans = null;
//        for (University u: Universities) {
//            if (u.getId().compareTo(id)==0){
//                ans = (ArrayList<Carrer>) u.getCarrers();
//            }
//        }
//        return ans;
        return university.findOne(id).getCarrers();
    }

    @Override
    public java.sql.Blob getUniversityLogo(String id) {
//        Blob ans = null;
//        for (University u: Universities) {
//            if (u.getId().compareTo(id)==0){
//                ans = u.getLogo();
//            }
//        }
//        return ans;
        return university.findLogoById(id);
    }

    @Override
    public void setUniversityCarrer(String id, ArrayList<Carrer> carrers) {
        University u= university.getOne(id);
        for (Carrer c: carrers) {
            u.setCarrer(c);
        }
        university.save(u);
    }

    @Override
    public void updateUniversity(String id, University u) {
//        for (University un: Universities) {
//            if (un.getId().compareTo(id)==0){
//                un.setAddress(u.getAddress());
//                un.setCity(u.getCity());
//                un.setDescp(u.getDescp());
//                un.setEmail(u.getEmail());
//                un.setName(u.getName());
//                un.setNumber(u.getNumber());
//                un.setPass(u.getPass());
//                un.setUrl(u.getUrl());
//            }
//        }
        university.save(u);
    }
    
}
