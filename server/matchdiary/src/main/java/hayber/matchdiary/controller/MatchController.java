package hayber.matchdiary.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hayber.matchdiary.dto.match.MatchRequestDTO;
import hayber.matchdiary.dto.match.MatchResponseDTO;
import hayber.matchdiary.model.Match;
import hayber.matchdiary.service.MatchService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController 
@RequestMapping ("/api/match")
public class MatchController {

    private final MatchService matchService;

    MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/all")
    public List<Match> getAllMatches() {
        return matchService.getAllMatches();
    }

    @GetMapping("{id}")
    public ResponseEntity<MatchResponseDTO> getMatchById(@PathVariable ("id") Long id) {
        return ResponseEntity.ok(matchService.getMatchById(id));
    }
    
    @PostMapping()
    public ResponseEntity<Match> addMatch(@RequestBody MatchRequestDTO matchRequestDTO) {
        return ResponseEntity.ok(matchService.registerMatch(matchRequestDTO));
    }

    @PutMapping
    public ResponseEntity<Match> updateMatch(@RequestBody MatchRequestDTO matchRequestDTO) {        
        return ResponseEntity.ok(matchService.updateMatch(matchRequestDTO));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMatch(@PathVariable ("id") Long id){
        matchService.deleteMatch(id);
        return ResponseEntity.ok("Partida deletada com sucesso!");
    }
    

    
}