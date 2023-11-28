package com.veltopia.library.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "user_table")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String lastName;
	private Date birthDate;
	
	@ManyToMany(mappedBy = "users")
	private List<Book> books;

	public User() {
	}
}
