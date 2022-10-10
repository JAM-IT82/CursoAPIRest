package com.apirest.productos.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntradaProductoDTO {

	private String name;
	private float price;
	private Long categoryId;
}
