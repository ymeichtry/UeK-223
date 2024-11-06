package ch.zli.m223.service;

import ch.zli.m223.model.Entry;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class EntryService {

    @Inject
    EntityManager entityManager;

    @Inject
    TimeSummaryService timeSummaryService;

    @Transactional
    public Entry createEntry(Entry entry) {
        return entityManager.merge(entry);
    }

    @Transactional
    public void deleteEntry(Long id) {
        var entity = entityManager.find(Entry.class, id);
        entityManager.remove(entity);
    }

    @Transactional
    public Entry updateEntry(Long id, Entry entry) {
        entry.setId(id);
        return entityManager.merge(entry);
    }

    public List<Entry> findAll() {
        var query = entityManager.createQuery("FROM Entry", Entry.class);
        return query.getResultList();
    }

    public Map<String, String> getTimeSummaries() {
        List<Entry> entries = findAll();
        Map<LocalDate, Duration> dailySummaries = timeSummaryService.calculateSummaryPerDay(entries);

        // Formatiere die Ergebnisse als Map<String, String> für die JSON-Ausgabe
        Map<String, String> timeSummaries = new HashMap<>();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        dailySummaries.forEach((date, duration) ->
            timeSummaries.put(date.format(dateFormatter), formatDuration(duration))
        );

        return timeSummaries;
    }

    private String formatDuration(Duration duration) {
        long hours = duration.toHours();
        long minutes = duration.minusHours(hours).toMinutes();
        long seconds = duration.minusHours(hours).minusMinutes(minutes).getSeconds();
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
