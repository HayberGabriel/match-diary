package hayber.matchdiary.service;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import hayber.matchdiary.dto.reports.ReportsResponseDTO;
import hayber.matchdiary.model.Match;
import hayber.matchdiary.model.Team;
import hayber.matchdiary.repository.MatchRespository;
import hayber.matchdiary.repository.TeamRepository;

@Service 
public class ReportsService {
    
    private final MatchRespository matchRespository;

    private final TeamRepository teamRepository;

    ReportsService(MatchRespository matchRespository, TeamRepository teamRepository) {
        this.matchRespository = matchRespository;
        this.teamRepository = teamRepository;
    }

    public ReportsResponseDTO getAllReports(){
        Integer matchesQuantity = getMatchesQuantity();
        Integer winsQuantity = getWinsQuantity();
        Integer winPercentage = getWinPercentage();
        Team mostWatchedTeam = getMostWatchedTeam();
        Integer daysWithoutWatching = getDaysWithoutWatching();
        return new ReportsResponseDTO(matchesQuantity, winsQuantity, winPercentage, mostWatchedTeam, daysWithoutWatching);
    }

    private Integer getMatchesQuantity(){
        return Math.toIntExact(matchRespository.count());
    }

    public Integer getWinsQuantity(){
        int winsQuantity = 0;

        List<Match> matches = matchRespository.findAll();

        for(Match match : matches){
            Team supportedTeam = match.getSupportedTeam();

            Integer scoreTeamOne = match.getScoreTeamOne();
            Integer scoreTeamTwo = match.getScoreTeamTwo();


            Long winnerTeamId = 0L;
            if(scoreTeamOne > scoreTeamTwo){
                winnerTeamId = match.getTeamOne().getId();
            } else if(scoreTeamTwo > scoreTeamOne){
                winnerTeamId = match.getTeamTwo().getId();
            }

            if(winnerTeamId.equals(supportedTeam.getId())){
                winsQuantity+=1;
            }
        }
        return winsQuantity;

    }

    public int getWinPercentage() {

        double winPercentage = 0;
        double wonPoints = 0;
        double totalPoints = 0;

        List<Match> matches = matchRespository.findAll();

        for(Match match : matches) {
            Integer scoreTeamOne = match.getScoreTeamOne();
            Integer scoreTeamTwo = match.getScoreTeamTwo();

            Long teamWinnerId = 0L;

            if(scoreTeamOne > scoreTeamTwo) {
                teamWinnerId = match.getTeamOne().getId();
            } else if(scoreTeamOne < scoreTeamTwo) {
                teamWinnerId = match.getTeamTwo().getId();
            } else {
                wonPoints += 1;
            }

            if(Objects.equals(match.getSupportedTeam().getId(), teamWinnerId)) {
                wonPoints += 3;
            }

            totalPoints += 3;
        }

        if(totalPoints == 0){
            return 0;
        }
     
        winPercentage = (wonPoints / totalPoints) * 100;
        return (int) winPercentage;
    }

    public Team getMostWatchedTeam() {
        return teamRepository.findMostWatchedTeam();
    }

    public Integer getDaysWithoutWatching() {
        return matchRespository.getDaysWithoutWatching();
    }

}
