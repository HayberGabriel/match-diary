package hayber.matchdiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hayber.matchdiary.model.Match;

public interface MatchRespository extends JpaRepository<Match, Long>{ 
}
