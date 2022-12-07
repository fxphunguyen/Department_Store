package com.phpn.repositories;

import com.phpn.repositories.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {

    Optional<Application> findAllByAppKey(String appKey);
}