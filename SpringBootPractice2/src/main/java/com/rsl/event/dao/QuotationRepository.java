package com.rsl.event.dao;

import org.springframework.data.repository.CrudRepository;

import com.rsl.event.entity.Quotation;

public interface QuotationRepository extends CrudRepository<Quotation, Integer>
{
	public Quotation findById(int id);
}