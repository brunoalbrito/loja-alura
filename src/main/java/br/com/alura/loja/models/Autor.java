package br.com.alura.loja.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SequenceGenerator(name = "seq_autor", sequenceName = "pk_autor", allocationSize = 1)
public class Autor {
	
	@Id
	@GeneratedValue(generator = "seq_autor", strategy = GenerationType.SEQUENCE)
	private Integer id;

	private String nome;
	
	public Autor(Integer id) {
		this.id = id;
	}
}
