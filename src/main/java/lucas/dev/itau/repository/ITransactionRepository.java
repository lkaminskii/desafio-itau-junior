package lucas.dev.itau.repository;

import lucas.dev.itau.model.Transaction;

import java.util.List;

public interface ITransactionRepository {
    Transaction saveTransaction(Transaction transaction);
    List findAllTransactions();
    Transaction findTransactionById(Long id);
    Transaction updateTransaction(Transaction transaction);
    boolean deleteTransactionById(Long id);
}
