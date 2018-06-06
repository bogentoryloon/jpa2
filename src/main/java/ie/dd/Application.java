package ie.dd;

import java.util.logging.Logger;

import org.mvnsearch.spring.boot.shell.BootShim;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.shell.Bootstrap;
import org.springframework.shell.support.logging.HandlerUtils;

@Configuration
@EnableAutoConfiguration
@ComponentScan

public class Application {


    public static void run(Object source, String... args) {
        run(new Object[] { source }, args);
    }

    public static void run(Object[] sources, String[] args) {
        // ConfigurableApplicationContext ctx = new SpringApplication(sources).run(args);
        // jtc - can we hack this?
        ConfigurableApplicationContext ctx = new SpringApplication().createApplicationContext();
        try {
            new BootShim(args, ctx).run();
        } finally {
            HandlerUtils.flushAllHandlers(Logger.getLogger(""));
        }
    }
}
