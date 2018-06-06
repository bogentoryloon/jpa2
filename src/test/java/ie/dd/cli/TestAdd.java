package ie.dd.cli;

import ie.dd.TestConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@DataJpaTest
public class TestAdd {
    @Autowired
    AddServer addServer;
    @Test
    public void testSpaces(){
        CliCommand.Result result = addServer.handleLine("add newserver which is jolly good");
        Assert.assertEquals(result.isHandled(),true);
        // TODO validate as full blown integration test
    }
}
