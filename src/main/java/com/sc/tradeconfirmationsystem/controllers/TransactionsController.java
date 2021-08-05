package com.sc.tradeconfirmationsystem.controllers;

import com.sc.tradeconfirmationsystem.services.ITransactionService;
import com.sc.tradeconfirmationsystem.utils.StaticProvider;
import com.sc.tradeconfirmationsystem.viewmodels.TransactionViewModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/transactions")
public class TransactionsController {
    private final ITransactionService transactionService;

    public TransactionsController(ITransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @GetMapping("xml-maker")
    public ResponseEntity<List<TransactionViewModel>> getXmlMakerQueue() {
        return ResponseEntity.ok(transactionService.get(StaticProvider.XML_MAKER));
    }

    @GetMapping("xml-checker")
    public ResponseEntity<List<TransactionViewModel>> getXmlCheckerQueue() {
        return ResponseEntity.ok(transactionService.get(StaticProvider.XML_CHECKER));
    }

    @GetMapping("pdf-maker")
    public ResponseEntity<List<TransactionViewModel>> getPdfMakerQueue() {
        return ResponseEntity.ok(transactionService.get(StaticProvider.PDF_MAKER));
    }

    @GetMapping("pdf-checker")
    public ResponseEntity<List<TransactionViewModel>> getPdfCheckerQueue() {
        return ResponseEntity.ok(transactionService.get(StaticProvider.PDF_CHECKER));
    }

    @GetMapping("pdf-comparison-maker")
    public ResponseEntity<List<TransactionViewModel>> getPdfComparisonMakerQueue() {
        return ResponseEntity.ok(transactionService.get(StaticProvider.PDF_COMPARISON_MAKER));
    }

    @GetMapping("pdf-comparison-checker")
    public ResponseEntity<List<TransactionViewModel>> getPdfComparisonCheckerQueue() {
        return ResponseEntity.ok(transactionService.get(StaticProvider.PDF_COMPARISON_CHECKER));
    }
}