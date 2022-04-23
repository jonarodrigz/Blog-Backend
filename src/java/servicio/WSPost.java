/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import dao.PostDao;
import entidades.Post;
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
@Path("Posts")
public class WSPost {

    @Context
    private UriInfo context;
    private PostDao pdao;

    /**
     * Creates a new instance of WSPost
     */
    public WSPost() {
        this.pdao = new PostDao();
    }
 @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> getAll() {
        return pdao.getAll();
    }

     
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Boolean agregar(Post cat){
        return pdao.Insertar(cat);
        
    }
   
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean actualizar(Post cat) {
        return  pdao.Actualizar(cat);
    }
    
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean eliminar(@PathParam("id") Integer id) {
        return  pdao.Eliminar(id);
    }
}
