package WebServices;



import java.util.List;


import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


import service.gestiontroc;
import service.gestiontrocRemote;
import troc.article;
import troc.utilisateur;


@Path("user")
public class gestionUtilisateur {
	
		@EJB
		private gestiontroc gestion;
		utilisateur user= new utilisateur();
		@GET
		@Produces({MediaType.APPLICATION_JSON})
		@Path ("{email}")
		
		public utilisateur getUserById(@PathParam("email")String email)
		{
		return gestion.getByEmail(email);
			
		}
		@GET
		@Produces({MediaType.APPLICATION_JSON})
		
		public List<utilisateur> getutilisateurList(){
			return gestion.findAllutilis();
		}
		@DELETE
		@Produces(MediaType.APPLICATION_JSON)
		public void deletearticle1(utilisateur user)
		{
			gestion.deleteutilisateur(user);


		}
		@DELETE
		@Produces(MediaType.APPLICATION_JSON)
		@Path ("{email}")
		public void deletearticle11(@PathParam("email")String email)
		{
			utilisateur a=gestion.getByEmail(email);
			gestion.deleteutilisateur(a);


		}
		@POST 
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON )
		public Response addutilisateur(utilisateur user){
			gestion.addUser(user);
		 return Response.status(Status.ACCEPTED).entity("user a été ajouté avec sucssé !!").build();
		}
		@PUT
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		@Path ("{email}")
		public void updateutilisateur(@PathParam("email")String email)
		{
			utilisateur a=gestion.getByEmail(email);
		 gestion.updateutilisateur(a);
		 
		
		}

		@GET
		@Produces (MediaType.APPLICATION_JSON)
		@Path ("{id}")
		public utilisateur getannoncesById(@PathParam("id")int id)
		{
		return gestion.findUserfById(id);
			//return  Response.status(Status.ACCEPTED).entity("msg").build();
		}
		@POST
		@Path("/login/{email}/{password}")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response logins(@PathParam("email") String email , @PathParam("password") String password) {
			utilisateur e=gestion.login(email, password);
		    
			if (e!=null)
		    {
		    	return Response.status(Response.Status.OK).entity(e).build();
		    	
		    }
		    else {
		    	return Response.status(Response.Status.NOT_FOUND).entity("fail").build();
		    }
	}
		@GET
		@Path("/loginp/{email}")
		
		@Produces(MediaType.APPLICATION_JSON)
		public Response loginss(@PathParam("email") String email ) {
			utilisateur e=gestion.getByEmail(email);
			
		    
			if (e!=null)
		    {
		    	return Response.status(Response.Status.OK).entity(e).build();
		    	
		    }
		    else {
		    	return Response.status(Response.Status.NOT_FOUND).entity("fail").build();
		    }
	}
		
		@GET
		@Path("/loginl")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response login(@FormParam("email") String email , @FormParam("password") String password) {
			utilisateur e=gestion.login(email, password);
		    
			if (e!=null)
		    {
		    	return Response.status(Response.Status.OK).entity("success").build();
		    	
		    }
		    else {
		    	return Response.status(Response.Status.NOT_FOUND).entity("fail").build();
		    }
	}
		
		

		 
}