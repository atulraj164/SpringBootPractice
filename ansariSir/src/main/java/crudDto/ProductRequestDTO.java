package crudDto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ProductRequestDTO {

	private int id;
	private String name;
	private String color;
	private double price;
	private int quantity;
	private LocalDate mfd;
	
}
