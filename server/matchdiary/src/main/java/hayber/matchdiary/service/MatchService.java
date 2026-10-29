package hayber.matchdiary.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import hayber.matchdiary.dto.match.MatchRequestDTO;
import hayber.matchdiary.dto.match.MatchResponseDTO;
import hayber.matchdiary.model.Match;
import hayber.matchdiary.model.Team;
import hayber.matchdiary.repository.MatchRespository;
import hayber.matchdiary.repository.TeamRepository;

@Service
public class MatchService {

    private final TeamRepository teamRepository;

    private final MatchRespository matchRespository;

    MatchService(MatchRespository matchRespository, TeamRepository teamRepository) {
        this.matchRespository = matchRespository;
        this.teamRepository = teamRepository;
    }

    public List<Match> getAllMatches() {
        return matchRespository.findAll();
    }

    public MatchResponseDTO getMatchById(final Long id) {
        if (id <= 0) {
            return new MatchResponseDTO();
        }

        Optional<Match> response = matchRespository.findById(id);

        return response.map(MatchResponseDTO::new).orElseGet(MatchResponseDTO::new);
    }

    public Match registerMatch(final MatchRequestDTO matchRequestDTO) {                                         
        if (matchRequestDTO.getScoreTeamOne().toString().isEmpty() ||
                matchRequestDTO.getScoreTeamTwo().toString().isEmpty() ||
                matchRequestDTO.getSupportedTeamId().toString().isEmpty() ||
                matchRequestDTO.getTeamOneId().toString().isEmpty() ||
                matchRequestDTO.getTeamTwoId().toString().isEmpty()) {
            return null;
        }

        if(matchRequestDTO.getTeamOneId().equals(matchRequestDTO.getTeamTwoId())){
            return null;
        }

        Team teamOne = teamRepository.findById(matchRequestDTO.getTeamOneId())
                .orElseThrow(() -> new IllegalArgumentException("Time 1 não encontrado"));
        Team teamTwo = teamRepository.findById(matchRequestDTO.getTeamTwoId())
                .orElseThrow(() -> new IllegalArgumentException("Time 2 não encontrado"));
        Team supportedTeam = teamRepository.findById(matchRequestDTO.getSupportedTeamId())
                .orElseThrow(() -> new IllegalArgumentException("Time de torcida não encontrado"));

        Match match = new Match(matchRequestDTO, teamOne, teamTwo, supportedTeam);
        return matchRespository.save(match);
    }

    public Match updateMatch(final MatchRequestDTO matchRequestDTO) {
         if (matchRequestDTO.getScoreTeamOne().toString().isEmpty() ||
                matchRequestDTO.getScoreTeamTwo().toString().isEmpty() ||
                matchRequestDTO.getSupportedTeamId().toString().isEmpty() ||
                matchRequestDTO.getTeamOneId().toString().isEmpty() ||
                matchRequestDTO.getTeamTwoId().toString().isEmpty()) {
            return null;
        }

        if(matchRequestDTO.getTeamOneId().equals(matchRequestDTO.getTeamTwoId())){
            return null;
        }

        Team teamOne = teamRepository.findById(matchRequestDTO.getTeamOneId())
                .orElseThrow(() -> new IllegalArgumentException("Time 1 não encontrado"));
        Team teamTwo = teamRepository.findById(matchRequestDTO.getTeamTwoId())
                .orElseThrow(() -> new IllegalArgumentException("Time 2 não encontrado"));
        Team supportedTeam = teamRepository.findById(matchRequestDTO.getSupportedTeamId())
                .orElseThrow(() -> new IllegalArgumentException("Time de torcida não encontrado"));

        Match match = new Match(matchRequestDTO, teamOne, teamTwo, supportedTeam);
        return matchRespository.save(match);
    }

    public void deleteMatch(final Long id) {
        matchRespository.deleteById(id);
    }
}
