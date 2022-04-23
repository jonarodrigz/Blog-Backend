/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import dao.CommentDao;
import entidades.Comment;
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
@Path("Comentarios")
public class WSComment {

    @Context
    private UriInfo context;
    private CommentDao cdao;

    /**
     * Creates a new instance of WSComment
     */
    public WSComment() {
        this.cdao = new CommentDao();
    }

     @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comment> getAll() {
        return cdao.getAll();
    }

     
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Boolean agregar(Comment cat){
        return cdao.Insertar(cat);
        
    }
   
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean actualizar(Comment cat) {
        return  cdao.Actualizar(cat);
    }
    
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean eliminar(@PathParam("id") Integer id) {
        return  cdao.Eliminar(id);
    }
}
