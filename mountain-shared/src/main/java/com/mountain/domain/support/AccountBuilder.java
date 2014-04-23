package com.mountain.domain.support;

import org.apache.commons.codec.digest.DigestUtils;

import com.mountain.domain.Account;
import com.mountain.domain.Address;
import com.mountain.domain.Permission;
import com.mountain.domain.Role;

public class AccountBuilder extends EntityBuilder<Account> {

	@Override
	void initProduct() {
		this.product = new Account();
	}

	public AccountBuilder credentials(String username, String password) {
		this.product.setUsername(username);
		this.product.setPassword(DigestUtils.sha256Hex(password + "{"
				+ username + "}"));
		return this;
	}

	public AccountBuilder address(String city, String postalCode,
			String street, String houseNumber, String boxNumber, String country) {
		Address address = new Address();
		address.setCity(city);
		address.setBoxNumber(boxNumber);
		address.setCountry(country);
		address.setHouseNumber(houseNumber);
		address.setPostalCode(postalCode);
		address.setStreet(street);
		this.product.setAddress(address);
		return this;
	}
	
	public AccountBuilder roleWithPermissions(Role role, Permission... permissions)
	{
		this.product.getRoles().add(role);
		for (Permission permission : permissions)
		{
			role.getPermissions().add(permission);
		}
		
		return this;
	}
	
	public AccountBuilder email(String email)
	{
		this.product.setEmailAddress(email);
		return this;
	}
	
	public AccountBuilder name(String firstName, String lastName)
	{
		this.product.setFirstName(firstName);
		this.product.setLastName(lastName);
		return this;
	}

	@Override
	Account assembleProduct() {
		return this.product;
	}

}
