package ie.dd.cli;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ie.dd.services.ServerService;

@Component
public class ListServers extends CliCommand {
	@Autowired
	ServerService serverService;
	private ListServers() {
		super(1,"list, to itemise all servers");
	}
	@Override
	public Result handleLine(String line) {
		if( "list".equals(line )) {
			return new Result(true,serverService.itemiseServers());
		}
		return new Result(false);
	}


}
