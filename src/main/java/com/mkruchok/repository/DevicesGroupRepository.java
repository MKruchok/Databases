package com.mkruchok.repository;

import com.mkruchok.entity.DevicesGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevicesGroupRepository extends JpaRepository<DevicesGroup, Integer> {

}
