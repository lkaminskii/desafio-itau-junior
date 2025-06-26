package lucas.dev.itau.service;

import org.springframework.stereotype.Component;
import lucas.dev.itau.model.Statistic;
import lucas.dev.itau.repository.TransactionRepository;
import lucas.dev.itau.model.Transaction;
import java.time.OffsetDateTime;

@Component
public class StatisticService {
    
    private TransactionRepository transactionRepository;

    public StatisticService(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    public Statistic calculateStatistics() {
        OffsetDateTime now = OffsetDateTime.now();
        OffsetDateTime limit = now.minusSeconds(60);

        double sum = 0.0;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        int count = 0;

        for (Transaction t : transactionRepository.getTransactions()) {
            if (t.getDataHora().isAfter(limit)) {
                double valor = t.getValor();
                sum += valor;
                if (valor < min) min = valor;
                if (valor > max) max = valor;
                count++;
            }
        }

        double avg = count > 0 ? sum / count : 0.0;
        min = count > 0 ? min : 0.0;
        max = count > 0 ? max : 0.0;

        return new Statistic((double) count, sum, avg, min, max);
    }

}
