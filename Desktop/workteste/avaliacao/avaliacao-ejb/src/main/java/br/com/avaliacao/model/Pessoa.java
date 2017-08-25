package br.com.avaliacao.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


/**
 * Clase PO / mapeamento da tabela pessoa
 * 
 * @author francisco.alves
 *
 */
@Entity(name="pessoa")
public class Pessoa implements Serializable {
	
	private static final long serialVersionUID = -8445304740109741899L;

	@Id
	@Column(name="pessoa_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long pessoaId;
	
	@Column(name="tipo_pessoa",length=1,nullable=false)
	private String tipoPessoa;
	
	@Column(name="nome_razao",length=225,nullable=false)
	private String nomeRazao;
	
	@Column(name="dt_nasc_fundacao",nullable=false)
	private Date dtNascFundacao;
	
	@OneToOne
	@JoinColumn(name="endereco_id")
	private Endereco endereco;
	

	public Long getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Long pessoaId) {
		this.pessoaId = pessoaId;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getNomeRazao() {
		return nomeRazao;
	}

	public void setNomeRazao(String nomeRazao) {
		this.nomeRazao = nomeRazao;
	}

	public Date getDtNascFundacao() {
		return dtNascFundacao;
	}

	public void setDtNascFundacao(Date dtNascFundacao) {
		this.dtNascFundacao = dtNascFundacao;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEnderecoPO(Endereco endereco) {
		this.endereco = endereco;
	}

	
	
	
	
	

}