package py.edu.ucom.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import py.edu.ucom.entities.Presupuesto;
import py.edu.ucom.services.PresupuestoService;

import java.util.List;

@Path("/final/presupuestos-mensual")
public class PresupuestoResource {

    @Inject
    PresupuestoService presupuestoService;

    @GET
    @Path("/mayor-presupuesto")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Presupuesto> obtenerMayorPresupuesto() {
        return presupuestoService.obtenerMayorPresupuesto();
    }
}
