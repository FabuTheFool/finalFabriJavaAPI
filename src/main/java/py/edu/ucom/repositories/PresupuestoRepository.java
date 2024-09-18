package py.edu.ucom.repositories;

import jakarta.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import py.edu.ucom.entities.Presupuesto;

import java.util.List;

@ApplicationScoped
public class PresupuestoRepository implements PanacheRepository<Presupuesto> {

    public Double findMaxMonto() {
        // Asegúrate de que el tipo de retorno sea Double
        return getEntityManager()
            .createQuery("SELECT MAX(p.monto) FROM Presupuesto p", Double.class)
            .getSingleResult();
    }

    public List<Presupuesto> findPresupuestosWithMaxMonto(Double maxMonto) {
        return find("SELECT p FROM Presupuesto p WHERE p.monto = ?1", maxMonto).list();
    }
}
