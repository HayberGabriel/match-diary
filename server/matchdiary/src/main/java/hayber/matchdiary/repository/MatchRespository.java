package hayber.matchdiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hayber.matchdiary.model.Match;

public interface MatchRespository extends JpaRepository<Match, Long> {
    @Query(value = "SELECT CAST(EXTRACT(EPOCH FROM AGE(CURRENT_DATE, MAX(date))) / (60*60*24) AS INTEGER) FROM match", nativeQuery = true)
    Integer getDaysWithoutWatching();
}
