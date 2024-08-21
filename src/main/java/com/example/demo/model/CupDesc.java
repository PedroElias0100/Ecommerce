package com.example.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "cup_desc")
@SequenceGenerator(name = "seq_cup_desc", sequenceName = "seq_cup_desc", initialValue = 1, allocationSize = 1)
public class CupDesc implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cup_desc")
	private long id;
	
	private String codDesc;
	
	private BigDecimal valorReal;
	
	private BigDecimal valorPorcentDesc;
	@Temporal(TemporalType.DATE)
	private Date dataValidadeCupom;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCodDesc() {
		return codDesc;
	}
	public void setCodDesc(String codDesc) {
		this.codDesc = codDesc;
	}
	public BigDecimal getValorReal() {
		return valorReal;
	}
	public void setValorReal(BigDecimal valorReal) {
		this.valorReal = valorReal;
	}
	public BigDecimal getValorPorcentDesc() {
		return valorPorcentDesc;
	}
	public void setValorPorcentDesc(BigDecimal valorPorcentDesc) {
		this.valorPorcentDesc = valorPorcentDesc;
	}
	public Date getDataValidadeCupom() {
		return dataValidadeCupom;
	}
	public void setDataValidadeCupom(Date dataValidadeCupom) {
		this.dataValidadeCupom = dataValidadeCupom;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CupDesc other = (CupDesc) obj;
		return id == other.id;
	}
	

}
