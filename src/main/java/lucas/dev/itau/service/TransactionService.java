package lucas.dev.itau.service;

import lucas.dev.itau.model.Transaction;
import org.springframework.stereotype.Component;
import lucas.dev.itau.repository.TransactionRepository;

import java.util.List;

@Component
public class TransactionService {
    
    private TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    public Transaction saveTransaction(Transaction transaction) throws RuntimeException{
        if (transaction.getValor() < 0){
            throw new RuntimeException("O valor da transação não pode ser menor que 0!");
        }
        return transactionRepository.saveTransaction(transaction);
    }

    public boolean deleteTransactionById(Long id){
        return transactionRepository.deleteTransactionById(id);
    }

}
