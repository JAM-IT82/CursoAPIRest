package com.apirest.productos.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.apirest.productos.DTO.ProductoDTOConverter;
import com.apirest.productos.DTO.SalidaProductoDTO;
import com.apirest.productos.entity.Producto;
import com.apirest.productos.repository.ProductoRepository;
import com.apirest.productos.services.ProductoService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductoServiceImpl implements ProductoService{
	
	public final ProductoRepository oProdRepository;
	public final ProductoDTOConverter oProdConvert;
	
	

	@Override
	public ResponseEntity<Producto> getProductoById(Long id) {
		// TODO Auto-generated method stub
		
		Optional<Producto> oProducto = oProdRepository.findById(id);
		if (oProducto.isPresent()) {
			return ResponseEntity.ok().body(oProducto.get());
		}
		else {
			return ResponseEntity.notFound().build();
		
		}
				
	}
	
	@Override
	public ResponseEntity<Producto> removeProductoById(Long id) {
		
		Optional <Producto> oProducto = oProdRepository.findById(id);
		
		if (oProducto.isPresent()) {
			oProdRepository.deleteById(id);
			return ResponseEntity.ok().body(oProducto.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
		
		
	}
	
	@Override
	/*public ResponseEntity<List<Producto>> getProductos() {*/
	public ResponseEntity<?> getProductos (){
		
		List <Producto> lProductos = oProdRepository.findAll();
		if (lProductos.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		else {
			//return ResponseEntity.ok().body(lProductos);
			List <SalidaProductoDTO> dtoList = 
					lProductos.stream()
					.map(oProdConvert::convertToSalidaDTO).collect(Collectors.toList());
			return ResponseEntity.ok().body(dtoList);
		}
	}
	
	@Override
	public ResponseEntity<Producto> updateProducto(Producto oProducto) {
		if (oProducto!=null) {
			Optional<Producto> oProductoExist = oProdRepository.findById(oProducto.getId());
			if (oProductoExist.isPresent()) {
				oProducto = oProdRepository.save(oProducto);
				return ResponseEntity.ok().body(oProducto);
			}
			else return ResponseEntity.notFound().build();
		}
		return ResponseEntity.badRequest().build();
		
	}

	@Override
	public ResponseEntity<Producto> addProducto(Producto oProducto) {
		if (oProducto!=null) {
			oProdRepository.save(oProducto);
			return ResponseEntity.ok().body(oProducto);
		}
		return ResponseEntity.notFound().build();
		
		
	}
	
}
