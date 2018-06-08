package ie.dd.cli;

/*
	rather hamfisted attempt to replicate at least some of the principles of the rather
	wonderful spring shell framework, which unfortunately doesn't seen to get on with
	boot.
	I spent far too long trying to force them into a shotgun marriage, but ran out of
	time.
 */
public interface CommandSet {
	CliCommand.Result process(String line);
	String listCommands();
}
