package py.edu.ucom.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import py.edu.ucom.entities.Presupuesto;
import py.edu.ucom.repositories.PresupuestoRepository;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class PresupuestoService {

    @Inject
    PresupuestoRepository repository;

    @Transactional
    public List<Presupuesto> obtenerMayorPresupuesto() {
        Double maxMonto = repository.findMaxMonto();
        if (maxMonto != null) {
            return repository.findPresupuestosWithMaxMonto(maxMonto);
        }
        return List.of(); // Devuelve una lista vacía si no hay presupuestos
    }
}
