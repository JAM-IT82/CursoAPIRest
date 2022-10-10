package com.apirest.productos.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.apirest.productos.entity.*;


public interface ProductoService {

	ResponseEntity <List<Producto>> getProductos();
	ResponseEntity <Producto> getProductoById (Long id);
	ResponseEntity <Producto> removeProductoById (Long id);
	ResponseEntity <Producto> updateProducto (Producto oProducto);
	ResponseEntity <Producto> addProducto (Producto oProducto);
	
}
