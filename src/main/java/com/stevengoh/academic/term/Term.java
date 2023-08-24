package com.stevengoh.academic.term;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Term {
    @Id
    @SequenceGenerator(name = "term_seq", sequenceName = "term_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "term_seq")
    private Long id;
    private String termCode;
    private Boolean isActive;
    private LocalDateTime createdDate = LocalDateTime.now();
    private LocalDateTime updatedDate;

    public Term(String termCode, Boolean isActive, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.termCode = termCode;
        this.isActive = isActive;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Term(String termCode, Boolean isActive) {
        this.termCode = termCode;
        this.isActive = isActive;
    }

    public Term(String termCode) {
        this.termCode = termCode;
    }
}
