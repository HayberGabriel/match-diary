package hayber.matchdiary.dto.match;

import java.sql.Date;

import hayber.matchdiary.model.Match;
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
    private Long teamOne;
    private Long teamTwo;
    private Long supportedTeam;

    public MatchResponseDTO(Match match) {
        this(match.getId(), match.getDate(), match.getScoreTeamOne(),
            match.getScoreTeamTwo(), match.getTeamOne().getId(), match.getTeamTwo().getId(), match.getSupportedTeam().getId());
    }
}