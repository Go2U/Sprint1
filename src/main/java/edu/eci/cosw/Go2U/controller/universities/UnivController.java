/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.controller.universities;

import edu.eci.cosw.Go2U.services.universities.ServiceUniversity;
import edu.eci.cosw.Go2U.model.universities.Carrer;
import edu.eci.cosw.Go2U.model.universities.University;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author miguelromero
 */
@RestController
@RequestMapping("/api/uni")
public class UnivController {
    @Autowired
    ServiceUniversity universities;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void addUniversity(@RequestBody University u) {
        universities.addUniversity(u);
    }
    
    @RequestMapping(value = "/upd/{id}",method = RequestMethod.POST)
    public void updateUniversity(@PathVariable String id, @RequestBody University u) {
        universities.updateUniversity(id,u);
    }
    
    @RequestMapping(value = "/{id}/add",method = RequestMethod.POST)
    public void addUniversityCarrers(@PathVariable String id, @RequestBody ArrayList<Carrer> c) {
        universities.addUniversityCarrer(id, c);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public List<University> getUniversities() {
        return universities.getUniversities(); //Obtiene lista de todos los clientes
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public University getUniversityById(@PathVariable String id) {
        //System.out.println("entro");
        return universities.getUniversityById(id);
    }
    
    //On test creation, its necesary to list the carrers available
    @RequestMapping(value = "/{id}/carrers", method = RequestMethod.GET)
    public List<Carrer> getUniversityCarrers(@PathVariable String id){
        return universities.getUniversityCarrers(id);
    }
    
//    @RequestMapping(value = "/{id}/logo", method = RequestMethod.GET)
//    public ResponseEntity<InputStreamResource> getUniversityLogo(@PathVariable String id) {
//        return ResponseEntity.ok().contentType(MediaType.parseMediaType("image/jpg")).body(new InputStreamResource(universities.getUniversityLogo(id)));
//    }
}
