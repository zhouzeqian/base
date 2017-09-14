package com.kxll.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kxll.entity.Address;
@Repository
public interface AddressDao extends JpaRepository<Address, Integer> {

	@Modifying
	@Query("update Address a set a.updateTime = now() , a.name=:name where a.id=:id")
	public void update(@Param(value = "id") Integer id,@Param(value = "name") String name);
}
