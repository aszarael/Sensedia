package com.beerhouse.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Beer")
public class Beer  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="ingredients")
	private String ingredients;
	
	@Column(name="alcoholContent")
	private String alcoholContent;
	
	@Column(name="price")
	private BigDecimal price;
	
	@Column(name="category")
	private String category;
}
