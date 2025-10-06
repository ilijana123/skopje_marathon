package com.example.skopje_marathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.skopje_marathon.model.Contestant;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ContestantRepository extends JpaRepository<Contestant, Long> {
    List<Contestant> findByFirstNameContaining(String firstName);
    Contestant findByEmail(String email);
}
