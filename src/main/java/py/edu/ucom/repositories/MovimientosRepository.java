package py.edu.ucom.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import py.edu.ucom.entities.Movimientos;

@ApplicationScoped
public class MovimientosRepository implements PanacheRepositoryBase<Movimientos, Integer> {

}
