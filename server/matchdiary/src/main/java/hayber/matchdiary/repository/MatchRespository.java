package hayber.matchdiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hayber.matchdiary.model.Match;
import hayber.matchdiary.model.Team;

public interface MatchRespository extends JpaRepository<Match, Long> {

     /*@Query("SELECT t " +
            "FROM Team t " +
            "WHERE t.id IN (SELECT m.teamOne.id FROM match m UNION ALL SELECT m.teamTwo.id FROM Match m)" +
            "GROUP BY t.id " +
            "ORDER BY COUNT(t.id) DESC " +
            "LIMIT 1")
    Team getMostWatchedTeam();*/
}
