package gt.edu.umg.ingenieria.sistemas.parcial2.factura.controller;

import gt.edu.umg.ingenieria.sistemas.core.parcial2.core.model.CabeceraFacturaEntity;
import gt.edu.umg.ingenieria.sistemas.core.parcial2.core.model.DetalleFacturaEntity;
import gt.edu.umg.ingenieria.sistemas.parcial2.factura.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/detalleFactura")
public class DetalleFacturaController {
    
    @Autowired
    private FacturaService facturaService;
    

    @PostMapping("/crearDetalleFactura/{id}")
    public DetalleFacturaEntity nuevo(@RequestBody(required = true) DetalleFacturaEntity product, @PathVariable(required = true) Long id) {
        
        product.setHeader(id);
        return this.facturaService.nuevoDet(product);
    }
    
}
