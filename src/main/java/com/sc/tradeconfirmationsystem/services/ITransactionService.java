package com.sc.tradeconfirmationsystem.services;


import com.sc.tradeconfirmationsystem.viewmodels.TransactionViewModel;

import java.util.List;

public interface ITransactionService {
    List<TransactionViewModel> get(String marker);
}
