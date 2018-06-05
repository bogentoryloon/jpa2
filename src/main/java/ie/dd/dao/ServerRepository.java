package ie.dd.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ie.dd.model.Server;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public interface ServerRepository extends CrudRepository<Server, Integer> {


}
