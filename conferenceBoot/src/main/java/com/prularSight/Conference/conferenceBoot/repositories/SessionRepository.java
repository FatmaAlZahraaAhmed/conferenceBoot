package com.prularSight.Conference.conferenceBoot.repositories;

import com.prularSight.Conference.conferenceBoot.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository  extends JpaRepository<Session, Long> {

}
