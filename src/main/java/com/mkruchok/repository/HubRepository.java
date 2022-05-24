package com.mkruchok.repository;

import com.mkruchok.entity.Hub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HubRepository extends JpaRepository<Hub, Integer> {

}
