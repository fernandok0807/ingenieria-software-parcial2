package gt.edu.umg.ingenieria.sistemas.parcial2.factura.dao;

import gt.edu.umg.ingenieria.sistemas.core.parcial2.core.model.CabeceraFacturaEntity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CabeceraFacturaRepository extends CrudRepository<CabeceraFacturaEntity, Long> {
    
    public List<CabeceraFacturaEntity> findByNitOrderByDateDesc(String nit);
    
    public List<CabeceraFacturaEntity> findByNitOrderByDateAsc(String nit);
    
}
