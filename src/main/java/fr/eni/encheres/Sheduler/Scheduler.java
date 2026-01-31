package fr.eni.encheres.Sheduler;

import fr.eni.encheres.entity.dto.ArticleLog;
import fr.eni.encheres.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Scheduler {

    /**
     * Logger dédié au scheduler de mise à jour des statuts.
     */
    private static final Logger logger =
            LoggerFactory.getLogger(Scheduler.class);


    ArticleService articleService;


    public Scheduler(ArticleService articleService) {
        this.articleService = articleService;
    }

    /**
     * Journalise les changements de statut des articles.
     *
     * @param label      libellé du traitement (ex : "CR → EC")
     * @param transition transition de statut appliquée (ex : "CR->EC")
     * @param articles   liste des articles ayant changé de statut
     */
    private void logChanges(String label, String transition, List<ArticleLog> articles) {
        if (articles.isEmpty()) {
            return;
        }

        logger.info("{} : {} article(s)", label, articles.size());
        articles.forEach(a -> logger.info(
                "Article id={} name='{}' {} begin={} end={}",
                a.getId(),
                a.getName(),
                transition,
                a.getBeginningDate(),
                a.getEndingDate()
        ));
    }

    /**
     * Vérifie périodiquement les enchères et met à jour automatiquement
     * le statut des articles en fonction des dates :
     * <ul>
     *   <li>CR → EC lorsque la date de début est atteinte</li>
     *   <li>EC → VD lorsque la date de fin est dépassée</li>
     * </ul>
     * <p>
     * Cette méthode est exécutée automatiquement par Spring
     * selon l'expression cron définie.
     * </p>
     */
    // Cron Spring : seconde minute heure jour mois jourSemaine
    @Scheduled(cron = "*/10 * * * * *")
    public void updateStatusEncheres() {

        List<ArticleLog> crToEc = articleService.updateCRtoECWithLogs();
        logChanges("CR → EC", "CR->EC", crToEc);

        List<ArticleLog> ecToVd = articleService.updateECtoVDWithLogs();
        logChanges("EC → VD", "EC->VD", ecToVd);
    }
}
