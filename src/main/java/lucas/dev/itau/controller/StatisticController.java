package lucas.dev.itau.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lucas.dev.itau.model.Statistic;
import lucas.dev.itau.service.StatisticService;

@RestController
@RequestMapping("/statistics")
public class StatisticController {

    private StatisticService statisticService;

    public StatisticController(StatisticService statisticService){
        this.statisticService = statisticService;
    }

    @GetMapping
    public Statistic calculateStatistics() {
        return statisticService.calculateStatistics();
    }
    
}
