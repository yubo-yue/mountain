package com.mountain.repository;

import com.mountain.domain.Account;

/**
 * Repository for domain object {@link Account} .
 * @author yubo
 *
 */
public interface AccountRepository {
	
	Account findByUsername(final String username);
	
	Account findById(final Long id);
	
	Account save(Account account);
	
}
