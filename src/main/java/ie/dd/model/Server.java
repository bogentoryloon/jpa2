package ie.dd.model;

import javax.crypto.SealedObject;
import javax.persistence.*;

@Entity
public class Server {

    
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SERVER_SEQ")
    @SequenceGenerator(sequenceName = "server_seq", initialValue = 1, allocationSize = 1, name = "SERVER_SEQ")
    private long id;
	private String name;
	private String description;

    // needed by JPA
    public Server(){
    }
	public Server(String name,String description ){
		this.setDescription(description);
		this.setName(name);
	}	


    @Override
    public String toString() {
        return "Server(" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + "\')";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
