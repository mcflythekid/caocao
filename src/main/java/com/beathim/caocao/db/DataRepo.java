package com.beathim.caocao.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataRepo extends JpaRepository<Data, String> {
    List<Data> findAllByStatus(Integer status);
    List<Data> findAllByStatusLessThan(Integer status);
}
