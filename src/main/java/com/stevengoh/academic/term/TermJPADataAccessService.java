package com.stevengoh.academic.term;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("termJPA")
@AllArgsConstructor
public class TermJPADataAccessService implements TermDAO {

    private final TermRepository termRepository;
    @Override
    public List<Term> selectAllTerms() {
        return termRepository.findAll();
    }

    @Override
    public Optional<Term> selectTermById(Long termId) {
        return termRepository.findById(termId);
    }

    @Override
    public Optional<Term> selectTermByTermCode(String termCode) {
        return termRepository.findByTermCode(termCode);
    }

    @Override
    public boolean existsTermByTermCode(String termCode) {
        return termRepository.existsByTermCode(termCode);
    }

    @Override
    public boolean existsTermById(Long termId) {
        return termRepository.existsById(termId);
    }

    @Override
    public void insertTerm(Term term) {
        termRepository.save(term);
    }

    @Override
    public void deleteTermById(Long termId) {
        termRepository.deleteById(termId);
    }

    @Override
    public void updateTerm(Term update) {
        termRepository.save(update);
    }
}
