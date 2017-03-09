package egen.jerseyimp;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import egen.dao.Reservationdao;
import egen.exception.AppException;
import egen.model.Authentication;
import egen.model.Reservation;

import java.util.List;

@Path("/Reservation")
public class RestaurantController {

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse getAll(){
		
		AppResponse resp=new AppResponse();
		try {
			Reservationdao dao= new Reservationdao();
			List<Reservation> reserve = dao.getAll();
			resp.setPayload(reserve);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.setStatus(AppResponse.ERROR);
			resp.setMessage(e.getMessage());
		}
		
		return resp;
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse addReservation(Reservation res){
		AppResponse resp=new AppResponse();
		try {
			Reservationdao dao= new Reservationdao();
		    res = dao.addPerson(res);
		    System.out.println(res);
		    resp.setMessage("Employee added");
			resp.setPayload(res);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.setStatus(AppResponse.ERROR);
			resp.setMessage(e.getMessage());
		}
		
		return resp;
	}
	
	@POST
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse deleteCustomer(@PathParam("id") int custId){
		
		AppResponse resp=new AppResponse();
		try {
			Reservationdao dao= new Reservationdao();
		    dao.deletePerson(custId);
		    List<Reservation> reserve = dao.getAll();
			resp.setPayload(reserve);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.setStatus(AppResponse.ERROR);
			resp.setMessage(e.getMessage());
		}
		
		return resp;
	}
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse login(Authentication auth, @Context HttpServletRequest request){
		AppResponse resp=new AppResponse();
		
			Reservationdao dao= new Reservationdao();
			boolean isAuthenticated=dao.authenticate(auth);
			
			HttpSession session=request.getSession(true);
			session.setAttribute("USER", auth);
			if(isAuthenticated)
			{
				resp.setMessage("Login Successful");	
			}
			else{
		    resp.setMessage("Login Invalid");
		   // resp.setStatus(AppResponse.ERROR);
			}
		
		
		return resp;
	}
	
	
}
