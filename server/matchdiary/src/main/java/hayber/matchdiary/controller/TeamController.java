package hayber.matchdiary.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hayber.matchdiary.dto.team.TeamResponseDTO;
import hayber.matchdiary.model.Team;
import hayber.matchdiary.service.TeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController 
@RequestMapping ("/api/team")
public class TeamController {

    @Autowired 
    private TeamService teamService;

    @GetMapping("/all")
    public String getAllTeams() {
        return "Teste";
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamResponseDTO> getTeamById(@PathVariable ("id") Long id) {
        return ResponseEntity.ok(teamService.getTeamById(id));
    }
    
    @PostMapping()
    public String addTeam(@RequestBody Team team) {
        return "";
    }

    @PutMapping("path/{id}")
    public String updateTeam(@RequestBody Team team) {        
        return "";
    }

    @DeleteMapping("id")
    public String deleteTeam(@RequestParam("id") Long id){
        return "";
    }
    

    
}