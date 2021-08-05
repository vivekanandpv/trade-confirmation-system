package com.sc.tradeconfirmationsystem.services;

import com.sc.tradeconfirmationsystem.utils.StaticProvider;
import com.sc.tradeconfirmationsystem.viewmodels.TransactionViewModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService implements ITransactionService {
    @Override
    public List<TransactionViewModel> get(String marker) {
        switch (marker) {
            case StaticProvider.XML_MAKER: return getXmlMakerQueue();
            case StaticProvider.XML_CHECKER: return getXmlCheckerQueue();
            case StaticProvider.PDF_MAKER: return getPdfMakerQueue();
            case StaticProvider.PDF_CHECKER: return getPdfCheckerQueue();
            case StaticProvider.PDF_COMPARISON_MAKER: return getPdfComparisonMakerQueue();
            case StaticProvider.PDF_COMPARISON_CHECKER: return getPdfComparisonCheckerQueue();
            default: return null;
        }
    }

    private List<TransactionViewModel> getXmlMakerQueue() {
        List<TransactionViewModel> list = new ArrayList<>();
        list.add(new TransactionViewModel());
        list.add(new TransactionViewModel());
        list.add(new TransactionViewModel());
        return list;
    }

    private List<TransactionViewModel> getXmlCheckerQueue() {
        List<TransactionViewModel> list = new ArrayList<>();
        list.add(new TransactionViewModel());
        list.add(new TransactionViewModel());
        list.add(new TransactionViewModel());
        return list;
    }

    private List<TransactionViewModel> getPdfMakerQueue() {
        List<TransactionViewModel> list = new ArrayList<>();
        list.add(new TransactionViewModel());
        list.add(new TransactionViewModel());
        list.add(new TransactionViewModel());
        return list;
    }

    private List<TransactionViewModel> getPdfCheckerQueue() {
        List<TransactionViewModel> list = new ArrayList<>();
        list.add(new TransactionViewModel());
        list.add(new TransactionViewModel());
        list.add(new TransactionViewModel());
        return list;
    }

    private List<TransactionViewModel> getPdfComparisonMakerQueue() {
        List<TransactionViewModel> list = new ArrayList<>();
        list.add(new TransactionViewModel());
        list.add(new TransactionViewModel());
        list.add(new TransactionViewModel());
        return list;
    }

    private List<TransactionViewModel> getPdfComparisonCheckerQueue() {
        List<TransactionViewModel> list = new ArrayList<>();
        list.add(new TransactionViewModel());
        list.add(new TransactionViewModel());
        list.add(new TransactionViewModel());
        return list;
    }
}
