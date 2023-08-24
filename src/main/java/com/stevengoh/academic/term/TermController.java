package com.stevengoh.academic.term;

import com.stevengoh.academic.student.StudentDTO;
import com.stevengoh.academic.utils.CustomResponse;
import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/term")
@AllArgsConstructor
public class TermController {

    private final TermService termService;
    private final CustomResponse<?> customResponse;


    @GetMapping
    public ResponseEntity<?> getTerms (@RequestParam(name = "termId", required = false) Long termId, @RequestParam(name = "termCode", required = false) String termCode) {
        if(termId == null && StringUtils.isBlank(termCode)) {
            List<Term> termList = termService.getAllTerms();
            return ResponseEntity.ok(customResponse.setCustomResponse(200, "Term Data fetched", termList));
        }

        if(termId != null) {
            Term term = termService.getTermById(termId);
            return ResponseEntity.ok(customResponse.setCustomResponse(200, "Term By Id fetched", term));
        }

        if(StringUtils.isNotBlank(termCode)) {
            Term term = termService.getTermByTermCode(termCode);
            return ResponseEntity.ok(customResponse.setCustomResponse(200, "Term By termCode fetched", term));
        }

        return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity<?> registerTerm (@RequestBody TermRequest termRequest) {
        String message = termService.insertTerm(termRequest);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("{termId}")
    public ResponseEntity<?> updateTerm (@PathVariable("termId") Long termId, @RequestBody TermRequest termRequest) {
        String message = termService.updateTerm(termId, termRequest);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("{termId}")
    public ResponseEntity<?> deleteTermById (@PathVariable("termId") Long termId) {
        String message = termService.deleteTermById(termId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
