package hayber.matchdiary.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hayber.matchdiary.dto.team.TeamRequestDTO;
import hayber.matchdiary.dto.team.TeamResponseDTO;
import hayber.matchdiary.model.Team;
import hayber.matchdiary.service.TeamService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController 
@RequestMapping ("/api/team")
public class TeamController {

    private final TeamService teamService;

    TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/all")
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamResponseDTO> getTeamById(@PathVariable ("id") Long id) {
        return ResponseEntity.ok(teamService.getTeamById(id));
    }
    
    @PostMapping()
    public ResponseEntity<Team> addTeam(@RequestBody TeamRequestDTO teamRequestDTO) {
        return ResponseEntity.ok(teamService.registerTeam(teamRequestDTO));
    }

    @PutMapping()
    public ResponseEntity<Team> updateTeam(@RequestBody TeamRequestDTO teamRequestDTO) {
        return ResponseEntity.ok(teamService.updateTeam(teamRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeam(@PathVariable ("id") Long id){
        teamService.deleteTeam(id);
        return ResponseEntity.ok("Time deletado com sucesso!");
    }
    

    
}