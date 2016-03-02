/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.Universities;

import java.io.InputStream;
import java.util.ArrayList;

/**
 *
 * @author miguelromero
 */
public interface UnivServiceInterface {
    public void addUniversity(University u);
    public void updateUniversity(String id,University u);
    public void addUniversityCarrer(String id, ArrayList<Carrer> c);
    public ArrayList<University> getUniversities();
    public University getUniversityById(String id);
    public ArrayList<Carrer> getUniversityCarrers(String id);
    public InputStream getUniversityLogo(String id);
}
