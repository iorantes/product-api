package com.test.products.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.products.model.entity.User;

public interface UserRepository extends AbstractBaseRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.userNick=:userNick")
	public User findByUserNick(@Param(value = "userNick") String userNick);
	
	@Query("SELECT u FROM User u WHERE u.userMail=:userMail")
	public User findByMail(@Param(value = "userMail") String userMail);

	@Query("SELECT u FROM User u WHERE u.userActive=1")
	public Page<User> findAll(Pageable pageable);

}
