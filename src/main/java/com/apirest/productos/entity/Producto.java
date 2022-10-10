package com.apirest.productos.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table (name = "PRODUCTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	private Long id; 
	private String name;
	private float price;
	
	@ManyToOne
	@JoinColumn (name = "category_id")
	private Categoria category;
}
