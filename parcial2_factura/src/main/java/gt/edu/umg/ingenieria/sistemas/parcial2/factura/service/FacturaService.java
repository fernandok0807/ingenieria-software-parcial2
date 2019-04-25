package gt.edu.umg.ingenieria.sistemas.parcial2.factura.service;

import gt.edu.umg.ingenieria.sistemas.core.parcial2.core.model.CabeceraFacturaEntity;
import gt.edu.umg.ingenieria.sistemas.core.parcial2.core.model.DetalleFacturaEntity;
import gt.edu.umg.ingenieria.sistemas.core.parcial2.core.model.ProductoEntity;
import gt.edu.umg.ingenieria.sistemas.parcial2.factura.dao.CabeceraFacturaRepository;
import gt.edu.umg.ingenieria.sistemas.parcial2.factura.dao.DetalleFacturaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaService {

    @Autowired
    private CabeceraFacturaRepository cabeceraFacturaRepository;
    
    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;
    
    public List<CabeceraFacturaEntity> buscarTodasCabecerasFactura() {
        return (List<CabeceraFacturaEntity>) this.cabeceraFacturaRepository.findAll();
    }
    
    public List<DetalleFacturaEntity> buscarTodosDetallesFactura() {
        return (List<DetalleFacturaEntity>) this.detalleFacturaRepository.findAll();
    }
    
    public List<DetalleFacturaEntity> buscarTodosDetallesFactura(Long idCabeceraFactura) {
        return this.detalleFacturaRepository.findByHeader(idCabeceraFactura);
    }
    
    public CabeceraFacturaEntity nuevo(CabeceraFacturaEntity fact) {
        int guion = fact.getNit().indexOf("-");
        List<CabeceraFacturaEntity> respuesta = new ArrayList<CabeceraFacturaEntity>();
        if(guion>0){
            fact.setNit(fact.getNit().replace("-", "").trim());
            
        }
        
        
        return this.cabeceraFacturaRepository.save(fact);
    }
    
    public DetalleFacturaEntity nuevoDet(DetalleFacturaEntity fact) {
        return this.detalleFacturaRepository.save(fact);
    }
    
    public List<CabeceraFacturaEntity> buscarCNit(String nit, String orden) {
        int guion = nit.indexOf("-");
        List<CabeceraFacturaEntity> respuesta = new ArrayList<CabeceraFacturaEntity>();
        if(guion>0){
            nit = nit.replace("-", "");
        }
        
        if(orden.equals("asc")){
            respuesta= this.cabeceraFacturaRepository.findByNitOrderByDateAsc(nit);
        }
        else{
            if(orden.equals("desc")){
                respuesta= this.cabeceraFacturaRepository.findByNitOrderByDateDesc(nit);
            }
        }
        
        return respuesta;
    }
    
    
}
