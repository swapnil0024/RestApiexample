package com.example.RestApiexample.Repository;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {	
    @Positive
	private int bookId;
	
	@NotBlank(message = "Book name is required")
	private String bookName;
	
	@NotBlank(message = "Author name is required")
	private String author;
	
	@Positive(message = "Price must be positive")
	private int price;
	
	private boolean available;
	
	
	

	
}
