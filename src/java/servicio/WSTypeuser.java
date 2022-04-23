
package servicio;

import dao.TypeUserDao;
import entidades.Typeuser;
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


@Path("TipoUsuarios")
public class WSTypeuser {

    @Context
    private UriInfo context;
    private TypeUserDao tudao;

    /**
     * Creates a new instance of WSTypeuser
     */
    public WSTypeuser() {
        this.tudao = new TypeUserDao();
    }

    /**
     * Retrieves representation of an instance of servicio.WSTypeuser
     * @return an instance of java.util.List
     */
     
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Typeuser> getAll() {
        return tudao.getAll();
    }

     
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Boolean agregar(Typeuser cat){
        return tudao.Insertar(cat);
        
    }
   
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean actualizar(Typeuser cat) {
        return  tudao.Actualizar(cat);
    }
    
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean eliminar(@PathParam("id") Integer id) {
        return  tudao.Eliminar(id);
    }
}
