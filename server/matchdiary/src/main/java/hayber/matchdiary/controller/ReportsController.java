package hayber.matchdiary.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hayber.matchdiary.dto.reports.ReportsResponseDTO;
import hayber.matchdiary.service.ReportsService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/reports")
public class ReportsController {

    private final ReportsService reportsService;

    ReportsController(ReportsService reportsService){
        this.reportsService = reportsService;
    }

    @GetMapping
    private ReportsResponseDTO getReports(){
        return reportsService.getAllReports();
    }
    

}
