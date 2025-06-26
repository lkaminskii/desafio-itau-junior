package lucas.dev.itau.repository;

import lucas.dev.itau.model.Transaction;

import java.util.List;

public interface ITransactionRepository {
    Transaction saveTransaction(Transaction transaction);
    boolean deleteTransactionById(Long id);
}
