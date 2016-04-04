package edu.eci.cosw.Go2U;

import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Go2uApplication.class)
@WebAppConfiguration
public class Go2uApplicationTest {

	@Test
	public void contextLoads() {
            //fail("Información no encontrada");
	}

}
