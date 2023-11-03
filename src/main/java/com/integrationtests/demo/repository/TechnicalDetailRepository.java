package com.integrationtests.demo.repository;

import com.integrationtests.demo.model.TechnicalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnicalDetailRepository extends JpaRepository<TechnicalDetails, Long> {

    List<TechnicalDetails> findByProductId(long id);
}
