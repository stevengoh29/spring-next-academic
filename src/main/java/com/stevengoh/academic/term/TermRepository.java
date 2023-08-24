package com.stevengoh.academic.term;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TermRepository extends JpaRepository<Term, Long> {
    Optional<Term> findByTermCode(String termCode);

    boolean existsByTermCode(String termCode);
}
