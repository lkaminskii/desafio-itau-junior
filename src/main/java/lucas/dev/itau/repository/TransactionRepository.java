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
    public List findAllTransactions() {
        return transactions;
    }

    @Override
    public Transaction findTransactionById(Long id) {
        return transactions.stream()
                .filter(transaction -> transaction.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Transaction updateTransaction(Transaction transaction) {
        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).getId().equals(transaction.getId())) {
                transactions.set(i, transaction);
                return transaction;
            }
        }
        throw new RuntimeException("Transaction not found");
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
