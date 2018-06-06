package ie.dd.cli;


import ie.dd.services.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CountServers extends CliCommand {
	@Autowired
	ServerService serverService;
	private CountServers() {
		super(1,"how many servers do we have");
	}
	@Override
	public Result handleLine(String line) {
		if( "count".equals(line )) {
			return new Result(true,String.format("There are %d servers",serverService.countServers()));
		}
		return new Result(false);
	}


}
