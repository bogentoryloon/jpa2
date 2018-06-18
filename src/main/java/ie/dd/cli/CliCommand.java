package ie.dd.cli;
/*
	rather hamfisted attempt to replicate at least some of the principles of the rather
	wonderful spring shell framework, which unfortunately doesn't seen to get on with
	boot.
	I spent far too long trying to force them into a shotgun marriage, but ran out of
	time.
 */
public abstract class CliCommand implements Comparable<CliCommand>{
	int rank;
	String help;
	protected  CliCommand(int rank,String help) {
		this.rank=rank;
		this.help=help;
	}	
	public int compareTo(CliCommand o) {
		return rank - o.rank;
	}
	abstract public Result handleLine(String line);
	public String help() {
		return help==null?"unavailable":help;
	}


	protected String flatten( String arr[],int from){
		StringBuffer s=new StringBuffer();
		for( int i=from;i<arr.length;++i){
			s.append(arr[i]);
			if( i<(arr.length-1)){
				s.append(" ");
			}
		}
		return s.toString();
	}


	static public class Result{
		private boolean handled;
		private String output;
		public Result(boolean handled) {
			this.setHandled(handled);
		}
		public Result(boolean handled,String output) {
			this.setHandled(handled);
			this.setOutput(output);
		}

		public boolean isHandled() {
			return handled;
		}

		public void setHandled(boolean handled) {
			this.handled = handled;
		}

		public String getOutput() {
			return output;
		}

		public void setOutput(String output) {
			this.output = output;
		}
	}
	
}
