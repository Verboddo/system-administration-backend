package com.smeekens.systemadministration.repository;

import com.smeekens.systemadministration.models.Servers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServerRepository extends JpaRepository<Servers, Long> {
}
