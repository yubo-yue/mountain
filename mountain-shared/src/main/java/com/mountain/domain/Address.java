package com.mountain.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.NotEmpty;

@Embeddable
public class Address implements Serializable {

	@NotEmpty
	private String street;
	private String houseNumber;
	private String boxNumber;

	@NotEmpty
	private String city;
	private String postalCode;

	@NotEmpty
	private String country;

	public Address() {
		super();
	}

	public Address(Address source) {
		super();
		this.street = source.street;
		this.houseNumber = source.houseNumber;
		this.boxNumber = source.boxNumber;
		this.city = source.city;
		this.postalCode = source.postalCode;
		this.country = source.country;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getBoxNumber() {
		return boxNumber;
	}

	public void setBoxNumber(String boxNumber) {
		this.boxNumber = boxNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public int hashCode() {

		return new HashCodeBuilder().append(this.boxNumber).append(this.city)
				.append(this.country).append(this.houseNumber)
				.append(this.postalCode).append(this.street).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;

		return new EqualsBuilder().append(this.boxNumber, other.boxNumber)
				.append(this.city, other.city)
				.append(this.country, other.country)
				.append(this.houseNumber, other.houseNumber)
				.append(this.postalCode, other.postalCode)
				.append(this.street, other.street).isEquals();
	}

}
