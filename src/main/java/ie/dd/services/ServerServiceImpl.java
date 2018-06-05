package ie.dd.services;

import java.util.List;

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
	public int createServer(Server server) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean editServer(Server server) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteServer(Server server) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int countServers() {
		// TODO Auto-generated method stub
		return 0;
	}

}
