/*
 * Java bean class for entity table requerente 
 * Created on 6 jul 2016 ( Date ISO 2016-07-06 - Time 16:42:21 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package br.edu.ifms.requerimentos.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Requerente {
	
	@Id
	@Column(name="requerente_id")
	@GeneratedValue
	private Integer id; // Primary KeY
	private String cpf;
	private String rg;
	@Column(name="nomerequerente")
	private String nome;
	private String fonefixo;
	private String fonecel;
	private String email;
	@JoinColumn(name="estudante_fk")
	@OneToOne
	private Estudante estudante;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getNomerequerente() {
		return nome;
	}
	public void setNomerequerente(String nomerequerente) {
		this.nome = nomerequerente;
	}
	public String getFonefixo() {
		return fonefixo;
	}
	public void setFonefixo(String fonefixo) {
		this.fonefixo = fonefixo;
	}
	public String getFonecel() {
		return fonecel;
	}
	public void setFonecel(String fonecel) {
		this.fonecel = fonecel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Estudante getEstudane() {
		return estudante;
	}
	public void setEstudane(Estudante estudane) {
		this.estudante = estudane;
	}

}