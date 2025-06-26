package lucas.dev.itau.repository;

import lucas.dev.itau.model.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class TransactionRepository implements ITransactionRepository{

    private List<Transaction> transactions = new ArrayList<>();

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        transactions.add(transaction);
        return transaction;
    }

    @Override
    public boolean deleteTransactionById(Long id) {
        Optional<Transaction> transaction = transactions.stream()
            .filter(e -> e.getId().equals(id))
            .findFirst();

        if (transaction.isPresent()) {
            transactions.remove(transaction.get());
            return true; 
        }
        return false; 
    }
}
