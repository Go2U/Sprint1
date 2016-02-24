/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U;

import edu2.eci.cosw.stubs.fakeclientslibrary.CliendLoadException;
import java.util.Set;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import edu2.eci.cosw.stubs.fakeclientslibrary.ClientServicesStub;
import edu2.eci.cosw.stubs.fakeclientslibrary.Client;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author miguelromero
 */
@RestController
public class ClientsController {

    ClientServicesStub clients=new ClientServicesStub();

    @RequestMapping(value = "/clients",method = RequestMethod.GET)
    public Set<Client> getClients() {
        return clients.getAllClients(); //Obtiene lista de todos los clientes
    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.GET)
    public Client getClientById(@PathVariable int id) throws CliendLoadException {
        return clients.getClientById(id);
    }

    @RequestMapping(value = "/clients/{id}/picture", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> getPicture(@PathVariable int id) throws CliendLoadException {
        ResponseEntity<InputStreamResource> re;
        try{
            re = ResponseEntity.ok().contentType(MediaType.parseMediaType("image/jpg")).body(new InputStreamResource(clients.getClientPicture(id)));
        }catch (CliendLoadException c){
            //c.getStackTrace();
            re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return re;
    }
}
