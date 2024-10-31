package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.MesaExamen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesaExamenRepository extends JpaRepository<MesaExamen, Long> {}
