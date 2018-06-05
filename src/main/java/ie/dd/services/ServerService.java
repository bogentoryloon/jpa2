package ie.dd.services;
import ie.dd.model.Server;


public interface ServerService {

	public Iterable<Server>  findAll();
	public int createServer(Server server);
	public boolean editServer(Server server);
	public boolean deleteServer(Server server);
	public int countServers();
}
