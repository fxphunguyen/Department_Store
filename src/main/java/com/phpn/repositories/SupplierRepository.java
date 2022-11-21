package com.phpn.repositories;

import org.jetbrains.annotations.NotNull;
import com.phpn.repositories.model.Supplier;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    @NotNull
    @Override
    List<Supplier> findAll();

    @NotNull
    @Override
    Optional<Supplier> findById(@NotNull Integer id);

}