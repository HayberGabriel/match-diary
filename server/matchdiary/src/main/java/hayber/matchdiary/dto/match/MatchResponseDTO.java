package hayber.matchdiary.dto.match;

import java.sql.Date;

import hayber.matchdiary.model.Match;
import hayber.matchdiary.model.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MatchResponseDTO {

    private Long id;
    private Date date;
    private Integer scoreTeamOne;
    private Integer scoreTeamTwo;
    private Team teamOne;
    private Team teamTwo;
    private Team supportedTeam;

    public MatchResponseDTO(Match match) {
        this(match.getId(), match.getDate(), match.getScoreTeamOne(),
            match.getScoreTeamTwo(), match.getTeamOne(), match.getTeamTwo(), match.getSupportedTeam());
    }
}