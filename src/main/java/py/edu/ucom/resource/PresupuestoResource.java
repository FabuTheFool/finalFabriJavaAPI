package py.edu.ucom.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import py.edu.ucom.entities.Presupuesto;
import py.edu.ucom.services.PresupuestoService;

import java.util.List;

@Path("/final/presupuestos2")
public class PresupuestoResource {

    @Inject
    PresupuestoService presupuestoService;

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public Long countPresupuestos() {
        return (long) presupuestoService.listar().size();
    }

    @GET
    @Path("/rango/{rangoInicial}/{rangoFinal}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Presupuesto> obtenerPorRangoDeMonto(@PathParam("rangoInicial") Double rangoInicial, 
                                                     @PathParam("rangoFinal") Double rangoFinal) {
        return presupuestoService.obtenerPorRangoDeMonto(rangoInicial, rangoFinal);
    }
}
