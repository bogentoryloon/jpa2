package ie.dd.cli;



import org.springframework.stereotype.Component;

@Component
public class Quit extends CliCommand {

	public Quit() {
		super(100,"quit to exit program");
	}
	@Override
	public Result handleLine(String line) {
		if( "quit".equals(line) ){
			System.exit(0);
			return new Result(true);
		}
		return new Result(false);
	}


}
