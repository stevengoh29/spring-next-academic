package com.stevengoh.academic.term;

import com.stevengoh.academic.utils.CustomResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TermService {

    private final TermDAO termDAO;

    public List<Term> getAllTerms () {
        List<Term> termList = termDAO.selectAllTerms();

        if(termList.isEmpty()) throw new IllegalStateException("Term list not found");

        return termList;
    }

    public Term getTermById (Long termId) {
        Optional<Term> term = termDAO.selectTermById(termId);

        if(term.isEmpty()) throw new IllegalStateException("Term is not found");

        return term.get();
    }

    public Term getTermByTermCode (String termCode) {
        Optional<Term> term = termDAO.selectTermByTermCode(termCode);

        if(term.isEmpty()) throw new IllegalStateException("Term is not found");

        return term.get();
    }

    public String insertTerm (TermRequest termRequest) {
        boolean termIsExist = termDAO.existsTermByTermCode(termRequest.getTermCode());

        if(termIsExist) throw new IllegalStateException("Term is already existed.");

        Term termToInsert = new Term(termRequest.getTermCode(), termRequest.getIsActive());

        termDAO.insertTerm(termToInsert);

        return "Term inserted";
    }

    public String updateTerm (Long termId, TermRequest termRequest) {
        Optional<Term> termOptional = termDAO.selectTermById(termId);

        if(termOptional.isEmpty()) throw new IllegalStateException("Term does not exist.");

        Term term = termOptional.get();

        term.setTermCode(termRequest.getTermCode());
        term.setIsActive(termRequest.getIsActive());
        term.setUpdatedDate(LocalDateTime.now());

        termDAO.updateTerm(term);

        return "Update Successfully";
    }

    public String deleteTermById (Long termId) {
        Optional<Term> term = termDAO.selectTermById(termId);

        if(term.isEmpty()) throw new IllegalStateException("Term is not found");

        termDAO.deleteTermById(termId);

        return  "Delete successfully";
    }
}
