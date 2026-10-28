package hayber.matchdiary.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hayber.matchdiary.model.Team;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController 
@RequestMapping ("/api/match")
public class MatchController {

    @GetMapping("/all")
    public String getAllMatches() {
        return "Teste";
    }

    @GetMapping("{id}")
    public String getMatchById(@RequestParam("id") Long id) {
        return "";
    }
    
    @PostMapping()
    public String addMatch(@RequestBody Team team) {
        return "";
    }

    @PutMapping
    public String updateMatch(@RequestBody Team team) {        
        return "";
    }

    @DeleteMapping("{id}")
    public String deleteMatch(@RequestParam("id") Long id){
        return "";
    }
    

    
}