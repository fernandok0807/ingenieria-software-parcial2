package gt.edu.umg.ingenieria.sistemas.parcial2.inventario.service;

import gt.edu.umg.ingenieria.sistemas.core.parcial2.core.model.ProductoEntity;
import gt.edu.umg.ingenieria.sistemas.parcial2.inventario.dao.ProductoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    
    public List<ProductoEntity> buscarTodos() {
        return (List<ProductoEntity>) this.productoRepository.findAllByOrderByName();
    }
    
    public ProductoEntity nuevo(ProductoEntity producto) {
        return this.productoRepository.save(producto);
    }
    
    public ProductoEntity actualizarStock(Long id,String accion,int cantidad) {
        
        Optional<ProductoEntity> produ = this.productoRepository.findById(id);
        ProductoEntity prod = produ.get();
        
        if(accion.equals("incrementar")){
            
            prod.setStock(prod.getStock()+cantidad);
        }
        else if(accion.equals("decrementar")){
            prod.setStock(prod.getStock()-cantidad);
        }
        else{
            
        }
        
        return this.productoRepository.save(prod);
                
    }
    
}
