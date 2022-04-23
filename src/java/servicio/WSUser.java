/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import dao.UserDao;
import entidades.User;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Usuario
 */
@Path("Usuarios")
public class WSUser {

    @Context
    private UriInfo context;
    private UserDao udao;

    /**
     * Creates a new instance of WSUser
     */
    public WSUser() {
        this.udao = new UserDao();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAll() {
        return udao.getAll();
    }

     
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Boolean agregar(User cat){
        return udao.Insertar(cat);
        
    }
   
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean actualizar(User cat) {
        return  udao.Actualizar(cat);
    }
    
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean eliminar(@PathParam("id") Integer id) {
        return  udao.Eliminar(id);
    }
}
