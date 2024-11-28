package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Falta;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaltaRepository extends JpaRepository<Falta, Long> {
    List<Falta> findByAlumnoDni(String alumnoDni);
}
