package py.edu.ucom.controllers;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import py.edu.ucom.entities.Categoria;
import py.edu.ucom.models.responses.Respuesta;
import py.edu.ucom.services.CategoriaService;

@Path("api/categoria")
public class CategoriaController {
    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @GET
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta<Categoria> obtenerPorId(
            @PathParam("id") Integer id) {
        Respuesta<Categoria> respuesta = new Respuesta();

        try {
            respuesta.setCode(Response.Status.OK.getStatusCode());
            respuesta.setMessage("Se obtuvo exitosamente.");
            respuesta.setData(service.obtener(id));
        } catch (Exception e) {

            respuesta.setCode(Response.Status.CONFLICT.getStatusCode());
            respuesta.setMessage("No se obtuvo  la entidad con id :" + id);
            respuesta.setData(null);
        }

        return respuesta;
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta<List<Categoria>> listar() {
        Respuesta<List<Categoria>> respuesta = new Respuesta();

        try {
            respuesta.setCode(Response.Status.OK.getStatusCode());
            respuesta.setMessage("Se obtuvo exitosamente el listado.");
            respuesta.setData(service.listar());
        } catch (Exception e) {

            respuesta.setCode(Response.Status.CONFLICT.getStatusCode());
            respuesta.setMessage("No se obtuvo el listado.");
            respuesta.setData(null);
        }

        return respuesta;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta<Categoria> agregar(Categoria param) {
        Respuesta<Categoria> respuesta = new Respuesta();

        try {
            this.service.agregar(param);
            respuesta.setCode(Response.Status.OK.getStatusCode());
            respuesta.setMessage("Se agrego exitosamente.");
            respuesta.setData(param);
        } catch (Exception e) {
            e.printStackTrace();
            respuesta.setCode(Response.Status.CONFLICT.getStatusCode());
            respuesta.setMessage("No se pudo agregar la entidad.");
            respuesta.setData(null);
        }

        return respuesta;
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta<Categoria> modificar(Categoria param, @PathParam("id") Integer Id) {
        Respuesta<Categoria> respuesta = new Respuesta();

        try {
            this.service.modificar(param);
            respuesta.setCode(Response.Status.OK.getStatusCode());
            respuesta.setMessage("Se agrego exitosamente.");
            respuesta.setData(param);
        } catch (Exception e) {
            e.printStackTrace();
            respuesta.setCode(Response.Status.CONFLICT.getStatusCode());
            respuesta.setMessage("No se pudo agregar la entidad.");
            respuesta.setData(null);
        }

        return respuesta;
    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta<Object> eliminar(@PathParam("id") Integer id) {
        Respuesta<Object> respuesta = new Respuesta();

        try {
            this.service.eliminar(id);
            respuesta.setCode(Response.Status.OK.getStatusCode());
            respuesta.setMessage("Se elimino exitosamente.");
            respuesta.setData(null);
        } catch (Exception e) {
            e.printStackTrace();
            respuesta.setCode(Response.Status.CONFLICT.getStatusCode());
            respuesta.setMessage("No se pudo eliminar la entidad.");
            respuesta.setData(null);
        }

        return respuesta;
    }

}
