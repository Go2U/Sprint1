package edu.eci.cosw.Go2U;

import edu.eci.cosw.Go2U.model.universities.Carrer;
import edu.eci.cosw.Go2U.model.universities.University;
import edu.eci.cosw.Go2U.persistence.UniversityRepository;
import edu.eci.cosw.Go2U.services.universities.UnivServiceInterface;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Go2uApplication.class)
@WebAppConfiguration
@ActiveProfiles("test")
public class Go2uApplicationTest {

	@Autowired
        UnivServiceInterface unService;
        
        @Autowired
        UniversityRepository unRepository;
        
        
        @Test
	public void deberiaExistirUniversidad() {
            University u= new University("eci","Escuela Colombiana de Ingenieria Julio Garavito","eci@escuelaing.edu.co",1);            
            unRepository.save(u);
            
            University un1=unRepository.getOne("eci");
            University un2=unService.getUniversityById("eci");
            assertEquals(un1.getName(),un2.getName());
	}
        
        @Test
	public void deberiaDevolverListaDeUniversidades() {            
            University u1= new University("eci","Escuela Colombiana de Ingenieria Julio Garavito","eci@escuelaing.edu.co",1);  
            University u2= new University("tadeo","Jorge Tadeo Lozano","tadeo@utadeo.edu.co",1);
            University u3= new University("nacional","Universidad Nacional de Colombia ","nacional@unacional.edu.co",1);
            University u4= new University("andes","Universidad de los Andes","andes@uandes.edu.co",1);
            University u5= new University("udca","Universidad de ciencias aplicadas y ambientales","udca@udca.edu.co",1);
            unRepository.save(u1);
            unRepository.save(u2);
            unRepository.save(u3);
            unRepository.save(u4);
            unRepository.save(u5);
            
            List<University> universities=unService.getUniversities();
            assertEquals(universities.size(),5);
	}
                 
        @Test
	public void deberiaDevolverUnaUniversidadPorID() {            
            University u= new University("eci","Escuela Colombiana de Ingenieria Julio Garavito","eci@escuelaing.edu.co",1);
            unRepository.save(u);
                        
            University u1=unService.getUniversityById("eci");
            assertEquals(u1.getName(),"Escuela Colombiana de Ingenieria Julio Garavito");
	}
        
//        @Test
//	public void deberiaDevolverListaDeCarreras() {
//            University u= new University("eci","Escuela Colombiana de Ingenieria Julio Garavito","eci@escuelaing.edu.co",1);            
//            u.setCarrer(new Carrer(1, "Ingenieria de sistemas", "sistemas"));
//            u.setCarrer(new Carrer(2, "Ingenieria electronica", "electronica"));
//            u.setCarrer(new Carrer(3, "Ingenieria civil", "civil"));
//            u.setCarrer(new Carrer(4, "Ingenieria mecanica", "mecanica"));            
//            
//            unRepository.save(u);                        
//            List<Carrer>  list1=unService.getUniversityCarrers("eci");
//            assertEquals(list1.size(),4);
//	}
        
//        @Test
//	public void deberiaAgregarUnaCarrera() {
//            University u= new University("eci","Escuela Colombiana de Ingenieria Julio Garavito","eci@escuelaing.edu.co",1);            
//            unRepository.save(u);            
//            
//            Carrer c1=new Carrer(1, "Ingenieria de sistemas", "sistemas");            
//            ArrayList<Carrer> listCarrers= new ArrayList<>();
//            listCarrers.add(c1);
//            
//            unService.setUniversityCarrer("eci", listCarrers);
//            assertEquals(unService.getUniversityCarrers("eci").size(),1);
//	}
        
        

}
