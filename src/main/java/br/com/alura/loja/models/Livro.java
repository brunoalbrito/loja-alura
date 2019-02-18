package br.com.alura.loja.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.ext.ParamConverter.Lazy;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@DynamicUpdate
@EqualsAndHashCode
@SequenceGenerator(name = "seq_livro", sequenceName = "pk_livro", allocationSize = 1)
public class Livro {
	
	@Id
	@GeneratedValue(generator = "seq_livro", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@NotBlank
	@EqualsAndHashCode.Exclude
	private String titulo;
	
	@Lob
	@NotBlank
	@Length(min=10)
	@EqualsAndHashCode.Exclude
	private String descricao;
	
	@DecimalMin("20")
	@EqualsAndHashCode.Exclude
	private Integer numeroPaginas;
	
	@EqualsAndHashCode.Exclude
	@Temporal(TemporalType.DATE)
	private Calendar dataPublicacao;
	
	@DecimalMin("20")
	@EqualsAndHashCode.Exclude
	private BigDecimal preco;
	
	@EqualsAndHashCode.Exclude
	private String capaPath;
	
	@NotNull
	@ManyToMany(fetch = FetchType.EAGER)
	@Size(min=1)
	@EqualsAndHashCode.Exclude
	private List<Autor> autores = new ArrayList<>();
	
}
