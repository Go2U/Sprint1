/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.services.universities;

import com.mysql.jdbc.Blob;
import edu.eci.cosw.Go2U.model.universities.Carrer;
import edu.eci.cosw.Go2U.model.universities.University;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author miguelromero
 */
public interface UnivServiceInterface {
    public void addUniversity(University u);
    public void updateUniversity(String id,University u);
    public void setUniversityCarrer(String id, ArrayList<Carrer> c);
    public List<University> getUniversities();
    public University getUniversityById(String id);
    public List<Carrer> getUniversityCarrers(String id);
    public java.sql.Blob getUniversityLogo(String id);
}
