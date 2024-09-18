package py.edu.ucom.repositories;

import jakarta.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import py.edu.ucom.entities.Presupuesto;

import java.util.List;

@ApplicationScoped
public class PresupuestoRepository implements PanacheRepository<Presupuesto> {
    
    public List<Presupuesto> findByMontoBetween(Double rangoInicial, Double rangoFinal) {
        return find("montoPresupuestado BETWEEN ?1 AND ?2", rangoInicial, rangoFinal).list();
    }
}
