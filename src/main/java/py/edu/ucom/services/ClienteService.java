package py.edu.ucom.services;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.client.Client;
import py.edu.ucom.config.GenericDao;
import py.edu.ucom.entities.Cliente;
import py.edu.ucom.entities.PresupuestoMensual;
import py.edu.ucom.repositories.ClienteRepository;
import py.edu.ucom.repositories.PresupuestoMensualRepository;

@ApplicationScoped
public class ClienteService implements GenericDao<Cliente, Integer> {

    private final ClienteRepository repository;
    private final PresupuestoMensualRepository pmRepository;

    public ClienteService(
            ClienteRepository repository,
            PresupuestoMensualRepository pmRepository) {
        this.repository = repository;
        this.pmRepository = pmRepository;
    }

    @Override
    public List<Cliente> listar() {
        return this.repository.findAll().list();
    }

    @Override
    public Cliente obtener(Integer id) {
        return this.repository.findById(id);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        this.repository.deleteById(id);
    }

    @Override
    @Transactional
    public Cliente modificar(Cliente param) {

        return this.repository.getEntityManager().merge(param);
    }

    @Override
    @Transactional
    public Cliente agregar(Cliente param) {
        this.repository.persist(param);
        return null;
    }

    public List<PresupuestoMensual> listadoPresupuestosPorCliente(Integer clienteId) {
        Cliente cliente = this.repository.findById(clienteId);
        List<PresupuestoMensual> prespuestos = new ArrayList<>();
        if (cliente != null) {
            prespuestos = this.pmRepository.findByClienteId(clienteId);
        }
        return prespuestos;
    }
}
