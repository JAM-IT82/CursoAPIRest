package com.apirest.productos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.apirest.productos.entity.*;

import com.apirest.productos.services.ProductoService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ProductoController {
	
	private final ProductoService prodServ;

	@GetMapping("/get-productos")
	ResponseEntity<?> getProductos () {
		return prodServ.getProductos();
	}
	
	@GetMapping ("/get-producto/{id}")
	ResponseEntity<Producto> getProductoById (@PathVariable Long id) {
		return prodServ.getProductoById(id);
	}
	
	@PostMapping ("/add-producto")
	ResponseEntity<Producto> addProducto (@RequestBody Producto oProducto) {
		return prodServ.addProducto(oProducto);
	}
	
	@PostMapping ("/update-producto")
	ResponseEntity<Producto> updateProducto (@RequestBody Producto oProducto) {
		return prodServ.updateProducto(oProducto);
	}
	@PostMapping("/remove-producto/{id}")
	ResponseEntity<Producto> removeProducto (@PathVariable Long id) {
		return prodServ.removeProductoById(id);
	}
}
