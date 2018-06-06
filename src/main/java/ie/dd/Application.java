package ie.dd;

import java.io.DataInputStream;

import ie.dd.cli.CliCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
//import org.mvnsearch.spring.boot.shell.BootShim;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ie.dd.cli.CommandSet;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class Application implements CommandLineRunner{
    public static void main(String[] args) throws Exception {

        SpringApplication.run(Application.class, args);
		
    }

    @Autowired
    CommandSet vocab;
    //access command line arguments
  
    public void run(String... args) throws Exception {
	boolean running=true;
	System.out.println("enter help for commands");
    	while(running)
    	{    		
                DataInputStream in =  new DataInputStream(System.in);                
                String line = in.readLine();
                CliCommand.Result result=vocab.process(line);
                if( !result.isHandled()){
                	System.out.println(vocab.listCommands());
                }else {
                	System.out.println(result.getOutput());
                }
                
    	}
		
    }
}
