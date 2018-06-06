/**
 *
 */
package ie.dd;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import ie.dd.dao.ServerRepository;
import ie.dd.model.Server;

/**
 * @author jc001
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
@DataJpaTest
public class TestServerRepo {

    @Autowired
    ServerRepository serverRepository;

    @Test
    public void test() {
        Server s = new Server("mr server", "not for long");
        s = this.serverRepository.save(s);
        Assert.assertNotEquals(s.id, 0);
    }

}
