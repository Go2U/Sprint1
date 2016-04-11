package edu.eci.cosw.Go2U;

import edu.eci.cosw.Go2U.model.student.Student;
import edu.eci.cosw.Go2U.model.universities.Carrer;
import edu.eci.cosw.Go2U.model.universities.University;
import edu.eci.cosw.Go2U.persistence.StudentRepository;
import edu.eci.cosw.Go2U.persistence.UniversityRepository;
import edu.eci.cosw.Go2U.persistence.UserRepository;
import edu.eci.cosw.Go2U.services.students.StudentServiceInterface;
import edu.eci.cosw.Go2U.services.universities.UnivServiceInterface;
import edu.eci.cosw.Go2U.services.user.UserServiceInterface;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
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

    @Autowired
    StudentServiceInterface stService;
    @Autowired
    StudentRepository stRepository;

    @Autowired
    UserServiceInterface userService;
    @Autowired
    UserRepository userRepository;

    /**
     * *********University Test**********
     */
    @Test
    public void deberiaRegistrarUniversidad() {
        University u = new University("eci", "Escuela Colombiana de Ingenieria Julio Garavito", "eci@escuelaing.edu.co");
        unService.addUniversity(u);

        University un1 = unRepository.getOne("eci");
        University un2 = unService.getUniversityById("eci");
        assertEquals(un1.getName(), un2.getName());
    }

    @Test
    public void deberiaDevolverListaDeUniversidades() {
        University u1 = new University("eci", "Escuela Colombiana de Ingenieria Julio Garavito", "eci@escuelaing.edu.co");
        University u2 = new University("tadeo", "Jorge Tadeo Lozano", "tadeo@utadeo.edu.co");
        University u3 = new University("nacional", "Universidad Nacional de Colombia ", "nacional@unacional.edu.co");
        University u4 = new University("andes", "Universidad de los Andes", "andes@uandes.edu.co");
        University u5 = new University("udca", "Universidad de ciencias aplicadas y ambientales", "udca@udca.edu.co");
        unRepository.save(u1);
        unRepository.save(u2);
        unRepository.save(u3);
        unRepository.save(u4);
        unRepository.save(u5);

        List<University> universities = unService.getUniversities();
        assertEquals(universities.size(), 5);
    }

    @Test
    public void deberiaDevolverUnaUniversidadPorID() {
        University u = new University("eci", "Escuela Colombiana de Ingenieria Julio Garavito", "eci@escuelaing.edu.co");
        unRepository.save(u);

        University u1 = unService.getUniversityById("eci");
        assertEquals(u1.getName(), "Escuela Colombiana de Ingenieria Julio Garavito");
    }

//        @Test
//	public void deberiaDevolverListaDeCarreras() {
//            University u= new University("eci","Escuela Colombiana de Ingenieria Julio Garavito","eci@escuelaing.edu.co");            
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
//            University u= new University("eci","Escuela Colombiana de Ingenieria Julio Garavito","eci@escuelaing.edu.co");            
//            unRepository.save(u);            
////            System.out.println("############## "+unRepository.getOne("eci").getName());
//            Carrer c1=new Carrer(1, "Ingenieria de sistemas", "sistemas",u);            
//            List<Carrer> listCarrers= new ArrayList<>();
//            listCarrers.add(c1);
//            System.out.println("############## "+listCarrers.size());
//            
//            unService.setUniversityCarrer("eci", listCarrers);
//            assertEquals(unService.getUniversityCarrers("eci").size(),1);
//	}
    @Test
    public void deberiaActualizarDatosDeUnaUniversidad() {
        University u1 = new University("eci", "Escuela Colombiana de Ingenieria Julio Garavito", "eci@escuelaing.edu.co");
        unRepository.save(u1);
        University u2 = new University("eci", "Universidad Julio Garavito", "ueci@universidading.edu.co");

        unService.updateUniversity("eci", u2);

        String name1 = "Escuela Colombiana de Ingenieria Julio Garavito";
        String name2 = unService.getUniversityById("eci").getName();
        String mail1 = "eci@escuelaing.edu.co";
        String mail2 = unService.getUniversityById("eci").getEmail();
        assertNotEquals(name1, name2);
        assertNotEquals(mail1, mail2);
    }

    /**
     * *********Student Test**********
     */
    @Test
    public void deberiaRegistrarEstudiante() {
        Student e = new Student("henrymonroy7", "Henry", "Monroy");
        stService.addStudent(e);

        Student e1 = stRepository.getOne("henrymonroy7");
        Student e2 = stService.getStudentById("henrymonroy7");
        assertEquals(e1.getName(), e2.getName());
    }

    @Test
    public void deberiaActualizarDatosDeUnEstudiante() {
        Student st1 = new Student("henrymonroy7", "Henry", "Monroy");
        stService.addStudent(st1);
        Student st2 = new Student("henrymonroy7", "Moe", "Szyslak");

        stService.updateStudent("henrymonroy7", st2);

        String name1 = "Henry";
        String name2 = stService.getStudentById("henrymonroy7").getName();
        String lastName1 = "Monroy";
        String lastName2 = stService.getStudentById("henrymonroy7").getLastName();
        assertNotEquals(name1, name2);
        assertNotEquals(lastName1, lastName2);
    }

    @Test
    public void deberiaDevolverListaDeEstudiantes() {
        Student st1 = new Student("henrymonroy7", "Henry", "Monroy");
        Student st2 = new Student("cmedina", "cristian", "Medina");
        Student st3 = new Student("cbonilla", "cesar", "Bonilla");
        Student st4 = new Student("miguelromero", "Miguel", "Romero");
        Student st5 = new Student("mdavid", "Millos David", "Garcia");
        stService.addStudent(st1);
        stService.addStudent(st2);
        stService.addStudent(st3);
        stService.addStudent(st4);
        stService.addStudent(st5);

        List<Student> students = stService.getStudents();
        assertEquals(students.size(), 5);
    }

    @Test
    public void deberiaDevolverUnEstudiantePorID() {
        Student st1 = new Student("henrymonroy7", "Henry", "Monroy");
        Student st2 = new Student("cmedina", "cristian", "Medina");
        Student st3 = new Student("cbonilla", "cesar", "Bonilla");
        Student st4 = new Student("miguelromero", "Miguel", "Romero");
        Student st5 = new Student("mdavid", "Millos David", "Garcia");
        stService.addStudent(st1);
        stService.addStudent(st2);
        stService.addStudent(st3);
        stService.addStudent(st4);
        stService.addStudent(st5);

        Student student = stService.getStudentById("mdavid");
        assertEquals(student.getName(), "Millos David");
        student = stService.getStudentById("henrymonroy7");
        assertEquals(student.getName(), "Henry");
        student = stService.getStudentById("cmedina");
        assertEquals(student.getName(), "cristian");
    }
    
    /**
     * *********Test Test**********
     */

}
