package ie.dd;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


@Configuration
@EnableAutoConfiguration
/* genius tip from stack overflow : https://stackoverflow.com/questions/29344313/prevent-application-commandlinerunner-classes-from-executing-during-junit-test */
@ComponentScan( excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,value=CommandLineRunner.class))
public class TestConfig {
// shell of a class purely to direct
}
