package com.promin_ism.rest_service.repository;

import com.promin_ism.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Long> {
}
