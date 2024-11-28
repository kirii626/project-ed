package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.MesaExamen;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MesaExamenRepository extends JpaRepository<MesaExamen, Long> {
    @Query("SELECT me.id FROM MesaExamen me JOIN me.alumnos a WHERE a.dni = :alumnoDni")
    List<Long> findIdsByAlumnoDni(@Param("alumnoDni") String alumnoDni);
}
