package com.meta12.yuni01.repository;

import com.meta12.yuni01.entity.Address;
import com.meta12.yuni01.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
