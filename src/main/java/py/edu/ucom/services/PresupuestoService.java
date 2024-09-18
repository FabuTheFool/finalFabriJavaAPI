package py.edu.ucom.services;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import py.edu.ucom.entities.Presupuesto;
import py.edu.ucom.repositories.PresupuestoRepository;

@ApplicationScoped
public class PresupuestoService {

    private final PresupuestoRepository repository;

    public PresupuestoService(PresupuestoRepository repository) {
        this.repository = repository;
    }

    public List<Presupuesto> listar() {
        return this.repository.listAll();
    }

    public Presupuesto obtener(Long id) {
        return this.repository.findById(id);
    }

    @Transactional
    public void eliminar(Long id) {
        this.repository.deleteById(id);
    }

    @Transactional
    public Presupuesto modificar(Presupuesto param) {
        return this.repository.getEntityManager().merge(param);
    }

    @Transactional
    public Presupuesto agregar(Presupuesto param) {
        this.repository.persist(param);
        return param;
    }

    public List<Presupuesto> obtenerPorRangoDeMonto(Double rangoInicial, Double rangoFinal) {
        return this.repository.findByMontoBetween(rangoInicial, rangoFinal);
    }
}
