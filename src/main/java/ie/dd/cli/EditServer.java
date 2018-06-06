package ie.dd.cli;


import ie.dd.model.Server;
import ie.dd.services.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EditServer extends CliCommand {
	@Autowired
	ServerService serverService;
	private EditServer() {
		super(1,"edit <id> <name> <description> to alter server in application");
	}
	@Override
	public Result handleLine(String line) {
		String[] tokens = line.split(" ");
		Result result=new Result(false);
		if( "edit".equals(tokens[0]) ) {
			result.setHandled(true);
			if( tokens.length < 3) {
				result.setOutput(help);
			}else {
				Server server=new Server(tokens[2],tokens[3]);
				server.setId(Long.parseLong(tokens[1]));
				result.setHandled( serverService.editServer(server) );
				result.setOutput(server.toString());
			}
			return result;
		}
		return result;
	}


}
