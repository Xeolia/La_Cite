package com.la_cite.surfrider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.la_cite.surfrider.Frequentation;
import java.util.List;

public interface FrequentationRepository extends JpaRepository<Frequentation, Integer>{
    public List<Frequentation> findAllByCreatorEquals(String Username);
}
