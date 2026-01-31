/**
 * Ajoute un 0 devant les nombres < 10
 * Exemple : 5 -> "05"
 */
function pad(n) {
    return String(n).padStart(2, '0');
}

/**
 * Transforme un temps restant en texte lisible
 * Exemple : "01h 12m 05s"
 */
function formatNumber(ms) {

    // Conversion millisecondes -> secondes
    let totalSeconds = Math.floor(ms / 1000);

    // Calcul jours / heures / minutes / secondes
    let days = Math.floor(totalSeconds / 86400);
    let hours = Math.floor((totalSeconds % 86400) / 3600);
    let minutes = Math.floor((totalSeconds % 3600) / 60);
    let seconds = Math.floor(totalSeconds % 60);

    // Si terminé
    if (ms <= 0) {
        return "Terminé";
    }

    // Affichage avec jours si nécessaire
    if (days > 0) {
        return days + "j " + pad(hours) + "h " + pad(minutes) + "m " + pad(seconds) + "s";
    }

    return pad(hours) + "h " + pad(minutes) + "m " + pad(seconds) + "s";
}

/**
 * Lance un compte à rebours pour un élément HTML
 */
function startCountdown(valDataEnd) {

    // Date de fin récupérée depuis data-end
    let dateEnd = valDataEnd.dataset.end;

    // Conversion en objet Date
    let end = new Date(dateEnd);

    function tick() {

        // Heure actuelle
        let now = new Date();

        // Temps restant
        let diff = end - now;

        // Mise à jour affichage
        valDataEnd.textContent = formatNumber(diff);

        // Stop quand terminé
        if (diff <= 0) {
            clearInterval(timer);
        }
    }

    // Premier affichage immédiat
    tick();

    // Mise à jour chaque seconde
    let timer = setInterval(tick, 1000);
}

/**
 * Au chargement de la page,
 * on applique le timer à tous les éléments countdown
 */
document.addEventListener("DOMContentLoaded", function () {

    // On récupère tous les compteurs
    let elements = document.querySelectorAll(".countdown");

    // On lance le compteur pour chacun
    for (let i = 0; i < elements.length; i++) {
        startCountdown(elements[i]);
    }
});
