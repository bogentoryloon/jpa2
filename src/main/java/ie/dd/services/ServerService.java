package ie.dd.services;
import ie.dd.model.Server;


public interface ServerService {

	public Iterable<Server>  findAll();
	public long createServer(Server server);
	public boolean editServer(Server server);
	public boolean deleteServer(long id);
	public long countServers();
	public String itemiseServers();
}
