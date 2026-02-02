package fr.eni.encheres.Sheduler;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class StartUpRunner {

    Scheduler scheduler;

    public StartUpRunner(Scheduler scheduler) {
        this.scheduler = scheduler;
    }
    @PostConstruct
    public  void run(){
        scheduler.updateStatusEncheres();
    }
}
