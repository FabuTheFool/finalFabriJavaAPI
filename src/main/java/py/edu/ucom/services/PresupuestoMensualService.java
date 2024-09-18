package py.edu.ucom.services;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import py.edu.ucom.config.GenericDao;
import py.edu.ucom.entities.PresupuestoMensual;
import py.edu.ucom.repositories.PresupuestoMensualRepository;

@ApplicationScoped
public class PresupuestoMensualService implements GenericDao<PresupuestoMensual, Integer> {

    private final PresupuestoMensualRepository repository;

    public PresupuestoMensualService(PresupuestoMensualRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PresupuestoMensual> listar() {
        return this.repository.findAll().list();
    }

    @Override
    public PresupuestoMensual obtener(Integer id) {
        return this.repository.findById(id);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        this.repository.deleteById(id);
    }

    @Override
    @Transactional
    public PresupuestoMensual modificar(PresupuestoMensual param) {

        return this.repository.getEntityManager().merge(param);
    }

    @Override
    @Transactional
    public PresupuestoMensual agregar(PresupuestoMensual param) {
        this.repository.persist(param);
        return null;
    }

}
