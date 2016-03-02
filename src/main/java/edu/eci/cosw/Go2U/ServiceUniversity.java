 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U;

import edu.eci.cosw.Go2U.Universities.University;
import edu.eci.cosw.Go2U.Universities.Carrer;
import edu.eci.cosw.Go2U.Universities.UnivServiceInterface;
import java.io.InputStream;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author miguelromero
 */
@Service
public class ServiceUniversity implements UnivServiceInterface{
public static ArrayList<University> Universities = new ArrayList<University>() {{ add(new University("eci","eci")); add(new University("ros","ros"));}};
    
    @Override
    public void addUniversity(University u) {
        Universities.add(u);
    }

    @Override
    public ArrayList<University> getUniversities() {
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
    public ArrayList<Carrer> getUniversityCarrers(String id) {
        ArrayList<Carrer> ans = null;
        for (University u: Universities) {
            if (u.getId().compareTo(id)==0){
                ans = u.getCarrers();
            }
        }
        return ans;
    }

    @Override
    public InputStream getUniversityLogo(String id) {
        InputStream ans = null;
        for (University u: Universities) {
            if (u.getId().compareTo(id)==0){
                ans = u.getLogo();
            }
        }
        return ans;
    }

    @Override
    public void addUniversityCarrer(String id, ArrayList<Carrer> c) {
        for (University u: Universities) {
            if (u.getId().compareTo(id)==0){
                u.addCarrers(c);
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
