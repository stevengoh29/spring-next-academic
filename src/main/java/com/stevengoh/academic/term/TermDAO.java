package com.stevengoh.academic.term;

import com.stevengoh.academic.term.Term;

import java.util.List;
import java.util.Optional;

public interface TermDAO {
    List<Term> selectAllTerms();
    Optional<Term> selectTermById(Long termId);
    Optional<Term> selectTermByTermCode(String email);
    boolean existsTermByTermCode(String termCode);
    boolean existsTermById(Long termId);
    void insertTerm(Term term);
    void deleteTermById(Long termId);
    void updateTerm(Term update);
}
