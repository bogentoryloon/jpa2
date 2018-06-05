package ie.dd.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Server {

    
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SERVER_SEQ")
    @SequenceGenerator(sequenceName = "server_seq", initialValue = 1, allocationSize = 1, name = "SERVER_SEQ")
	public int id;
	public String name;
	public String description;

	public Server(){}



	public Server(String name,String description ){
		this.description = description;
		this.name = name;
	}	


    @Override
    public String toString() {
        return "Server{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + "\'}";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
