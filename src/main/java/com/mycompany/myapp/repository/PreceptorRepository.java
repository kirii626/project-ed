package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Preceptor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreceptorRepository extends JpaRepository<Preceptor, Long> {}
