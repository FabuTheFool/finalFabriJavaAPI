package py.edu.ucom.repositories;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import py.edu.ucom.entities.PresupuestoMensual;

@ApplicationScoped
public class PresupuestoMensualRepository implements PanacheRepositoryBase<PresupuestoMensual, Integer> {

    public List<PresupuestoMensual> findByClienteId(Integer clienteId) {
        return find("idCliente.idCliente", clienteId).list(); // Usamos el atributo idCliente para buscar
    }
}
