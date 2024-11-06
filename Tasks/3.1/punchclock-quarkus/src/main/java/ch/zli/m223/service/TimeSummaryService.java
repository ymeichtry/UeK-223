package ch.zli.m223.service;

import ch.zli.m223.model.Entry;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TimeSummaryService {

    public Map<LocalDate, Duration> calculateSummaryPerDay(List<Entry> entries) {
        return entries.stream()
            .collect(Collectors.groupingBy(
                entry -> entry.getCheckIn().toLocalDate(),
                Collectors.reducing(
                    Duration.ZERO,
                    entry -> Duration.between(entry.getCheckIn(), entry.getCheckOut()),
                    Duration::plus
                )
            ));
    }
}
