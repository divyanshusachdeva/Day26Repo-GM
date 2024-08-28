package com.graymatter.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Author {

	private String name;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

	private int authorId;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
	private List<Book> bookList = new ArrayList<Book>();
	
	
	public Book addBook (Book book) {
		
		bookList.add(book);
		book.setAuthor(this);
		return book;
	}
	
	public void removeBook (Book book) {
		
		bookList.remove(book);
		book.setAuthor(null);
	}

	public Author(String name) {
		super();
		this.name = name;
	}


	
}
