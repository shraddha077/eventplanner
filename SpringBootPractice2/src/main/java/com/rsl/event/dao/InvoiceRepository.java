package com.rsl.event.dao;

import org.springframework.data.repository.CrudRepository;

import com.rsl.event.entity.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, Integer>
{
	public Invoice findById(int id);
}
