package ie.dd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.dd.dao.ServerRepository;
import ie.dd.model.Server;
@Service
public class ServerServiceImpl implements ServerService {

	@Autowired
	ServerRepository serverRepository;
	
	@Override
	public Iterable<Server> findAll() {

		return serverRepository.findAll();
	}

	@Override
	public long createServer(Server server) {
		server.setId(0);
		serverRepository.save(server);
		return server.getId();
	}

	public String itemiseServers(){
		Iterable<Server> servers= serverRepository.findAll();
		if( servers != null){
			StringBuffer slist=new StringBuffer();
			for(Server server:servers) {
				slist.append(server+"\n");
			}
			return slist.toString();
		}else{
			return "no servers";
			}
	}
	@Override
	public boolean editServer(Server server) {
		return serverRepository.save(server)!=null;
	}

	@Override
	public boolean deleteServer(long id) {
		serverRepository.deleteById(id);
		return true;
	}

	@Override
	public long countServers() {
		return serverRepository.count();
	}

}
