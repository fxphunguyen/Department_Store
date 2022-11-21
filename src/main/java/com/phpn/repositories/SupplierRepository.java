package com.phpn.repositories;

import com.phpn.repositories.model.Supplier;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    @Override
    List<Supplier> findAll();

    @Override
    Optional<Supplier> findById(Integer id);

}