package hayber.matchdiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hayber.matchdiary.model.Match;

@Repository 
public interface MatchRespository extends JpaRepository<Match, Long>{
    
}
