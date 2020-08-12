package com.prularSight.Conference.conferenceBoot.repositories;

import com.prularSight.Conference.conferenceBoot.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker,Long> {
}
