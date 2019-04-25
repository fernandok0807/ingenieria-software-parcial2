package gt.edu.umg.ingenieria.sistemas.parcial2.inventario.controller;

import gt.edu.umg.ingenieria.sistemas.core.parcial2.core.model.ProductoEntity;
import gt.edu.umg.ingenieria.sistemas.parcial2.inventario.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/buscarTodos")
    public List<ProductoEntity> buscarTodos() {
        return this.productoService.buscarTodos();
    }
    
    @PostMapping("/registrarProducto")
    public ProductoEntity nuevo(@RequestBody(required = true) ProductoEntity product) {
        return this.productoService.nuevo(product);
    }
    
    
    @PostMapping("/crear")
    public String setNews(@RequestBody(required = true) List<ProductoEntity> nuevo) {
        String respuesta = "";
        for (int i=0; i<nuevo.size();i++){
            respuesta = respuesta +" "+this.nuevo(nuevo.get(i)) +"\n";
        }
        return respuesta;
    }
    
    @PutMapping("/actualizarStock/{id}/{accion}/{cantidad}")
    public String actualizar(@PathVariable(required = true) long id,@PathVariable(required = true) String accion,@PathVariable(required = true) int cantidad) {
        ProductoEntity producto= this.productoService.actualizarStock(id, accion,cantidad);
        
        if(producto == null)
            return "No se pudo actualizar el producto";
        else
            return "Stock Actualizado ["+ producto.getName()+" "+producto.getStock()+"]";
        
        
    }
    
}
