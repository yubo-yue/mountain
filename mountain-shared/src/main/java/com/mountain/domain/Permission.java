package com.mountain.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "permission" }) })
public class Permission implements Serializable {

	private static final long serialVersionUID = 6789734157499919517L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String permission;

	public Permission() {
	}

	public Permission(String permission) {
		this.permission = permission;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.id).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Permission other = (Permission) obj;
		return new EqualsBuilder().append(this.id, other.id).isEquals();
	}

}
