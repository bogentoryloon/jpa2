package ie.dd.cli;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServerMgrCommands implements CommandSet {

	   private List<CliCommand> commands;

	    @Autowired
	    public void setCommands(List<CliCommand> commands){
	        this.commands = commands;
	    }
	@Override
	public CliCommand.Result process(String line) {
		for( CliCommand command : commands) {
			CliCommand.Result result = command.handleLine(line);
			if(result.isHandled()) {
				return result;
			}
		}
		return new CliCommand.Result(false);
	}
	@Override
	public String listCommands() {
		StringBuffer retval = new StringBuffer("Available Commands:");
		for( CliCommand command : commands) {
			retval.append("\n"+command.help());
		}
		retval.append("\n");
		return retval.toString();
	}	
	
}
