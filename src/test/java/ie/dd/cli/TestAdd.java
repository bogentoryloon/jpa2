package ie.dd.cli;

import ie.dd.TestConfig;
import org.junit.Assert;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@DataJpaTest
public class TestAdd {
    Log log =  LogFactory.getLog(TestAdd.class);
    @Autowired
    AddServer addServer;
    @Autowired
    ListServers list;
    @Test
    public void testSpaces(){
        CliCommand.Result result = addServer.handleLine("add newserver which is jolly good");
        Assert.assertEquals(result.isHandled(),true);
        result=list.handleLine("list");
        Assert.assertEquals(result.isHandled(),true);
        log.info(result.getOutput());
        Assert.assertTrue(result.getOutput().contains("name='newserver',description='which is jolly good'"));
    }
}
