/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import dao.CategoryDao;
import entidades.Category;
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


@Path("Categorias")
public class WSCategory {

    @Context
    private UriInfo context;
    private CategoryDao cdao;

    /**
     * Creates a new instance of WSCategory
     */
    public WSCategory() {
        this.cdao = new CategoryDao();
    }

    /**
     * Retrieves representation of an instance of servicio.WSCategory
     * @return an instance of java.util.List
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> getAll() {
        return cdao.getAll();
    }

     
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Boolean agregar(Category cat){
        return cdao.Insertar(cat);
        
    }
   
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean actualizar(Category cat) {
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
