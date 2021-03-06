/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.controller.universities;

import com.mysql.jdbc.Blob;
import edu.eci.cosw.Go2U.services.universities.ServiceUniversity;
import edu.eci.cosw.Go2U.model.universities.Carrer;
import edu.eci.cosw.Go2U.model.universities.University;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author miguelromero
 */
@RestController
@RequestMapping("/api/uni")
public class UnivController {

    @Autowired
    ServiceUniversity universities;
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addUniversity(@RequestBody University u) {
        universities.addUniversity(u);
    }

    @RequestMapping(value = "/upd/{id}", method = RequestMethod.POST)
    public void updateUniversity(@PathVariable String id, @RequestBody University u) {
        universities.updateUniversity(id, u);
    }

    @RequestMapping(value = "/{id}/add", method = RequestMethod.POST)
    public void addUniversityCarrers(@PathVariable String id, @RequestBody List<Carrer> carrers) {
        universities.setUniversityCarrer(id, carrers);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<University> getUniversities() {
        return universities.getUniversities(); //Obtiene lista de todos los clientes
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public University getUniversityById(@PathVariable String id) {
        return universities.getUniversityById(id);
    }

    //On test creation, its necesary to list the carrers available
    @RequestMapping(value = "/{id}/carrers", method = RequestMethod.GET)
    public List<Carrer> getUniversityCarrers(@PathVariable String id) {
        return universities.getUniversityCarrers(id);
    }

    @RequestMapping(value = "/{id}/logo", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<java.sql.Blob> getUniversityLogo(@PathVariable String id) {
        return ResponseEntity.ok().contentType(MediaType.parseMediaType("image/png"))
                .body(universities.getUniversityLogo(id));
    }
    
    @RequestMapping(value = "/carrers", method = RequestMethod.GET)
    public ArrayList<Carrer> getAllCarrers() {
        return universities.getAllCarrers();
    }
    
    @RequestMapping(value = "/snies/{id}", method = RequestMethod.GET)
    public String getUniversitySNIES(@PathVariable String id) {
        return universities.getUniversitySNIES(id);
    }
    
    @RequestMapping(value = "/check/{id}", method = RequestMethod.GET)
    public boolean existUniversity(@PathVariable String id) {
        return universities.existUniversity(id);
    }
}
