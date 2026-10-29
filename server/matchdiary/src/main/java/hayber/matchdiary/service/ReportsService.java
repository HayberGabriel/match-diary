package hayber.matchdiary.service;


import java.util.List;

import org.springframework.stereotype.Service;

import hayber.matchdiary.dto.reports.ReportsResponseDTO;
import hayber.matchdiary.model.Match;
import hayber.matchdiary.model.Team;
import hayber.matchdiary.repository.MatchRespository;

@Service 
public class ReportsService {
    

    private final MatchRespository matchRespository;

    ReportsService(MatchRespository matchRespository) {
        this.matchRespository = matchRespository;
    }

    public ReportsResponseDTO getAllReports(){
        Integer matchesQuantity = getMatchesQuantity();
        Integer winsQuantity = getWinsQuantity();
        return new ReportsResponseDTO(matchesQuantity, winsQuantity);
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

}
