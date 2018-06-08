package ie.dd.services;

import static org.junit.jupiter.api.Assertions.*;

import ie.dd.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import ie.dd.Application;
import ie.dd.model.Server;



@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@DataJpaTest
public class TestIServerService {


    @Autowired 
    ServerService serverService;
	@Test
	public void testBasics() {
		Server server = new Server("newone","aint it good");
		
		assertNotNull(serverService);
		serverService.createServer(server);
		assertFalse(server.getId() ==0);
		
	}

}
