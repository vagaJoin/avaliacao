package br.com.avaliacao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



/**
 * Clase PO / mapeamento da tabela endereco
 * 
 * @author francisco.alves
 *
 */
@Entity(name="endereco")
public class Endereco implements Serializable {
	
	private static final long serialVersionUID = 3870728551403037579L;

	@Id
	@Column(name="endereco_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEndereco;
	
	@Column(name="municipio",length=255,nullable=false)
	private String municipio;
	
	@Column(name="uf",length=255,nullable=false)
	private String uf;
	
	
	public Long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	



	

}