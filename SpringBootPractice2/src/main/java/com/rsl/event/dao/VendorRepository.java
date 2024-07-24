package com.rsl.event.dao;

import org.springframework.data.repository.CrudRepository;

import com.rsl.event.entity.Vendor;

public interface VendorRepository extends CrudRepository<Vendor, Integer>
{
	public Vendor findById(int id);
}


