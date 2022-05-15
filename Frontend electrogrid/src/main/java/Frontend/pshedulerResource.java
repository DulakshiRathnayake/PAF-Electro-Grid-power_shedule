package Frontend;
import java.util.List;
//import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("pshedulers")
public class pshedulerResource {

pshedulerRepository repo = new pshedulerRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<psheduler> getpsheduler()
	{
	
		
			return repo.getPshedulers();
		
	}
//retrieve data	
	@GET
	@Path("psheduler/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public psheduler getpsheduler(@PathParam("id")int id){
		return repo.getPsheduler(id);
	}
	
//create data
	@POST
	@Path("psheduler")
	@Consumes ({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public psheduler createpsheduler(psheduler p1) {
		System.out.println("created successfully");
		repo.create(p1);
		return p1;
	}
	
//update data
	@PUT
	@Path("psheduler")
	@Consumes ({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public psheduler updatepsheduler(psheduler p1) {
		System.out.println("update successfully");
		if(repo.getPsheduler(p1.getpLid()).getpLid()==0)
		{
			repo.create(p1);
		}
		else
		{
			repo.update(p1);
		}
		return p1;
	}
	
	//Delete data
	@DELETE
	@Path("psheduler/{id}")
	public psheduler killpsheduler(@PathParam("id")int id)
	{
		psheduler p = repo.getPsheduler(id);
		
		if(p.getpLid()!=0)
			repo.delete(id);
		
		return p;
	}
}
