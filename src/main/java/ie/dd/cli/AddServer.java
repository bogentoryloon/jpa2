package ie.dd.cli;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ie.dd.model.Server;
import ie.dd.services.ServerService;

@Component
public class AddServer extends CliCommand {
	@Autowired
	ServerService serverService;
	public AddServer() {
		super(1,"add <name> <description> to enter server into application");
	}
	@Override
	public Result handleLine(String line) {
		String[] tokens = line.split(" ");
		Result result=new Result(false);
		if( "add".equals(tokens[0]) ) {
			result.setHandled(true);
			if( tokens.length < 3) {
				result.setOutput(help);
			}else {
				Server server=new Server(tokens[1],flatten(tokens,2));
				long id = serverService.createServer(server);
				result.setOutput("Server id="+id);
			}
			return result;
		}
		return result;
	}


}
