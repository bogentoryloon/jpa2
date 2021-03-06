/**
 *
 */
package ie.dd;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import ie.dd.dao.ServerRepository;
import ie.dd.model.Server;

/**
 * @author jc001
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@DataJpaTest
public class TestIServerRepo {

    @Autowired
    ServerRepository serverRepository;

    @Test
    public void testBasics() {
        Server s = new Server("mr server", "not for long");
        s = this.serverRepository.save(s);
        Assert.assertNotEquals(s.getId(), 0);
        Optional<Server> reread = this.serverRepository.findById(s.getId());
        Assert.assertTrue(reread.isPresent());
        Server actual = reread.get();
        Assert.assertEquals(s.getName(), actual.getName());
        // trawl the db
        Iterable<Server> all = this.serverRepository.findAll();
        Assert.assertEquals(3, all.spliterator().getExactSizeIfKnown());
    }
}
