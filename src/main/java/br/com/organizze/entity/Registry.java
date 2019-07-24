package br.com.organizze.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.organizze.enums.RegistryType;
import br.com.organizze.util.LocalDateDeserializer;
import br.com.organizze.util.LocalDateSerializer;

@Entity
public class Registry {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate date;

	private BigDecimal amount;

	private RegistryType type;

	@NotNull
	private boolean recurrent;
	private int recurringDays;


	public Registry() {

	}

	public Registry(String name, LocalDate date, BigDecimal amount, RegistryType type) {
		this.name = name;
		this.date = date;
		this.amount = amount;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public RegistryType getType() {
		return type;
	}

	public void setType(RegistryType type) {
		this.type = type;
	}

	public boolean isRecurrent() {
		return recurrent;
	}

	public void setRecurrent(boolean recurrent) {
		this.recurrent = recurrent;
	}

	public int getRecurringDays() {
		return recurringDays;
	}

	public void setRecurringDays(int recurringDays) {
		this.recurringDays = recurringDays;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Registry registry = (Registry) o;
		return recurrent == registry.recurrent &&
				recurringDays == registry.recurringDays &&
				Objects.equals(id, registry.id) &&
				Objects.equals(name, registry.name) &&
				Objects.equals(date, registry.date) &&
				Objects.equals(amount, registry.amount) &&
				type == registry.type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, date, amount, type, recurrent, recurringDays);
	}

	@Override
	public String toString() {
		return  "id = " + id + "\n" +
				"name = " + name + "\n"+
				"date = " + date +  "\n"+
				"amount = " + amount +  "\n"+
				"type = " + type +  "\n"+
				"recurrent = " + recurrent +  "\n"+
				"recurringDays = " + recurringDays;
	}
}
