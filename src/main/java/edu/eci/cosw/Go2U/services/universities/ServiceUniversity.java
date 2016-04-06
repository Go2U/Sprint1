 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.services.universities;

import edu.eci.cosw.Go2U.model.universities.Carrer;
import edu.eci.cosw.Go2U.model.universities.University;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;

/**
 *
 * @author miguelromero
 */
@Service
public class ServiceUniversity implements UnivServiceInterface{
    public static ArrayList<Carrer> carrers = new ArrayList<Carrer>() {{add(new Carrer(1000,"c1","d1")); add(new Carrer(1001,"c2","d2"));}};
    public static List<University> Universities = new ArrayList<University>() {{ add(new University("eci","eci", carrers)); add(new University("ros","ros", carrers));}};
    
    @Override
    public void addUniversity(University u) {
        Universities.add(u);
    }

    @Override
    public List<University> getUniversities() {
        return Universities;
    }
    
    @Override
    public University getUniversityById(String id) {
        University ans=null;
        for (University u: Universities) {
            if (u.getId().compareTo(id)==0){
                ans = u;
            }
        }
        return ans;
    }

    @Override
    public List<Carrer> getUniversityCarrers(String id) {
        ArrayList<Carrer> ans = null;
        for (University u: Universities) {
            if (u.getId().compareTo(id)==0){
                ans = (ArrayList<Carrer>) u.getCarrers();
            }
        }
        return ans;
    }

//    @Override
//    public InputStream getUniversityLogo(String id) {
//        InputStream ans = null;
//        for (University u: Universities) {
//            if (u.getId().compareTo(id)==0){
//                ans = u.getLogo();
//            }
//        }
//        return ans;
//    }

    @Override
    public void addUniversityCarrer(String id, ArrayList<Carrer> c) {
        for (University u: Universities) {
            if (u.getId().compareTo(id)==0){
                u.setCarrers(c);
            }
        }
    }

    @Override
    public void updateUniversity(String id, University u) {
        for (University un: Universities) {
            if (un.getId().compareTo(id)==0){
                un.setAddress(u.getAddress());
                un.setCity(u.getCity());
                un.setDescp(u.getDescp());
                un.setEmail(u.getEmail());
                un.setName(u.getName());
                un.setNumber(u.getNumber());
                un.setPass(u.getPass());
                un.setUrl(u.getUrl());
            }
        }
    }
    
}
