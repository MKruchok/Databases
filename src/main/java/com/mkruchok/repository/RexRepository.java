package com.mkruchok.repository;

import com.mkruchok.entity.Rex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RexRepository extends JpaRepository<Rex, Integer> {

}
