package com.stevengoh.academic.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByEmail(String email);
    boolean existsStudentByEmail(String email);
    boolean existsStudentById(Long studentId);

//    @Modifying(clearAutomatically = true)
//    @Query("UPDATE Customer c SET c.profileImageId = ?1 WHERE c.id = ?2")
//    int updateProfileImageId(String profileImageId, Integer customerId);
}
