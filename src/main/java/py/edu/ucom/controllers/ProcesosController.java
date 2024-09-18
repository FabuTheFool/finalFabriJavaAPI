package py.edu.ucom.controllers;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import py.edu.ucom.entities.Movimientos;
import py.edu.ucom.entities.PresupuestoMensual;
import py.edu.ucom.models.responses.Respuesta;
import py.edu.ucom.services.ClienteService;
import py.edu.ucom.services.MovimientosService;

@Path("api/procesos")
public class ProcesosController {
    private final ClienteService service;
    private final MovimientosService mService;

    public ProcesosController(ClienteService service, MovimientosService mService) {
        this.service = service;
        this.mService = mService;
    }

    @GET
    @Path("presupuestos/{clienteId}")
    public Respuesta<List<PresupuestoMensual>> obtenerPresupuestos(@PathParam("clienteId") Integer id) {
        Respuesta<List<PresupuestoMensual>> respuesta = new Respuesta();

        try {
            respuesta.setCode(Response.Status.OK.getStatusCode());
            respuesta.setMessage("Se obtuvo exitosamente el listado.");
            respuesta.setData(service.listadoPresupuestosPorCliente(id));
        } catch (Exception e) {

            respuesta.setCode(Response.Status.CONFLICT.getStatusCode());
            respuesta.setMessage("No se obtuvo el listado.");
            respuesta.setData(null);
        }

        return respuesta;
    }

    @POST
    @Path("agregar-mov")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta<Movimientos> agregarMovimiento(Movimientos param) {
        Respuesta<Movimientos> respuesta = new Respuesta();

        try {
            this.mService.agregar(param);
            respuesta.setCode(Response.Status.OK.getStatusCode());
            respuesta.setMessage("Se agrego exitosamente el movimiento.");
            respuesta.setData(param);
        } catch (Exception e) {
            e.printStackTrace();
            respuesta.setCode(Response.Status.CONFLICT.getStatusCode());
            respuesta.setMessage("No se pudo agregar la entidad.");
            respuesta.setData(null);
        }

        return respuesta;
    }

}
