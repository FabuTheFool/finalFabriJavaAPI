package py.edu.ucom.services;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import py.edu.ucom.config.GenericDao;
import py.edu.ucom.entities.Categoria;
import py.edu.ucom.repositories.CategoriaRepository;

@ApplicationScoped
public class CategoriaService implements GenericDao<Categoria, Integer> {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Categoria> listar() {
        return this.repository.findAll().list();
    }

    @Override
    public Categoria obtener(Integer id) {
        return this.repository.findById(id);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        this.repository.deleteById(id);
    }

    @Override
    @Transactional
    public Categoria modificar(Categoria param) {

        return this.repository.getEntityManager().merge(param);
    }

    @Override
    @Transactional
    public Categoria agregar(Categoria param) {
        this.repository.persist(param);
        return null;
    }

}
