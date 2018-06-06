package ie.dd.cli;


import ie.dd.model.Server;
import ie.dd.services.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteServer extends CliCommand {
	@Autowired
	ServerService serverService;
	private DeleteServer() {
		super(1,"delete <id> remove server in application");
	}
	@Override
	public Result handleLine(String line) {
		String[] tokens = line.split(" ");
		Result result=new Result(false);
		if( "delete".equals(tokens[0]) ) {
			result.setHandled(true);
			if( tokens.length < 2) {
				result.setOutput(help);
			}else {
				result.setHandled( serverService.deleteServer(Long.parseLong(tokens[1]) ));
			}
			return result;
		}
		return result;
	}


}
