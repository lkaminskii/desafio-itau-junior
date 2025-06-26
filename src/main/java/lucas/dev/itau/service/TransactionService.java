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

    public Transaction saveTransaction(Transaction transaction){
        return transactionRepository.saveTransaction(transaction);
    }

    public List findAllTransactions(){
        return transactionRepository.findAllTransactions();
    }

    public Transaction findTransactionById(Long id){
        return transactionRepository.findTransactionById(id);
    }

    public Transaction updateTransaction(Transaction transaction){
        return transactionRepository.updateTransaction(transaction);
    }

    public boolean deleteTransactionById(Long id){
        return transactionRepository.deleteTransactionById(id);
    }

}
