package com.la_cite.surfrider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.la_cite.surfrider.Feedback;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer>{
    public List<Feedback> findAllByCreatorEquals(String creator);
}
