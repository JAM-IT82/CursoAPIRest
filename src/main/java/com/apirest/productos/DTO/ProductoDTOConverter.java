package com.apirest.productos.DTO;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.apirest.productos.entity.Producto;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductoDTOConverter {

	private final ModelMapper oModelMapper;
	
	public EntradaProductoDTO convertToEntradaDTO (Producto oProduco) {
		return oModelMapper.map(oProduco, EntradaProductoDTO.class);
	}
	
	public SalidaProductoDTO convertToSalidaDTO (Producto oProducto) {
		return oModelMapper.map(oProducto, SalidaProductoDTO.class);
	}
}
