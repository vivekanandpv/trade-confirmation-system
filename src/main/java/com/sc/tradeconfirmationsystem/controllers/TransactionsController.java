package com.sc.tradeconfirmationsystem.controllers;

import com.sc.tradeconfirmationsystem.services.ITransactionService;
import com.sc.tradeconfirmationsystem.utils.StaticProvider;
import com.sc.tradeconfirmationsystem.viewmodels.TransactionViewModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("api/v1/transactions")
public class TransactionsController {
    private final ITransactionService transactionService;

    public TransactionsController(ITransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @GetMapping(StaticProvider.PATH_XML_MAKER)
    public ResponseEntity<List<TransactionViewModel>> getXmlMakerQueue() {
        return ResponseEntity.ok(transactionService.get(StaticProvider.XML_MAKER));
    }

    @GetMapping(StaticProvider.PATH_XML_CHECKER)
    public ResponseEntity<List<TransactionViewModel>> getXmlCheckerQueue() {
        return ResponseEntity.ok(transactionService.get(StaticProvider.XML_CHECKER));
    }

    @GetMapping(StaticProvider.PATH_PDF_MAKER)
    public ResponseEntity<List<TransactionViewModel>> getPdfMakerQueue() {
        return ResponseEntity.ok(transactionService.get(StaticProvider.PDF_MAKER));
    }

    @GetMapping(StaticProvider.PATH_PDF_CHECKER)
    public ResponseEntity<List<TransactionViewModel>> getPdfCheckerQueue() {
        return ResponseEntity.ok(transactionService.get(StaticProvider.PDF_CHECKER));
    }

    @GetMapping(StaticProvider.PATH_PDF_COMPARISON_MAKER)
    public ResponseEntity<List<TransactionViewModel>> getPdfComparisonMakerQueue() {
        return ResponseEntity.ok(transactionService.get(StaticProvider.PDF_COMPARISON_MAKER));
    }

    @GetMapping(StaticProvider.PATH_PDF_COMPARISON_CHECKER)
    public ResponseEntity<List<TransactionViewModel>> getPdfComparisonCheckerQueue() {
        return ResponseEntity.ok(transactionService.get(StaticProvider.PDF_COMPARISON_CHECKER));
    }

    @PostMapping(StaticProvider.PATH_XML_UPLOAD)
    public ResponseEntity<?> uploadXml(@RequestParam(StaticProvider.FILE_UPLOAD_PARAM_MARKER) MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        try {
            byte[] fileBytes = file.getBytes();

            Path filePath = Paths.get(
                    StaticProvider.XML_UPLOAD_DIRECTORY_PATH,
                    file.getOriginalFilename()
            );

            Files.write(filePath, fileBytes);

            return ResponseEntity.ok().build();
        } catch (IOException ex) {
            System.out.println("Cannot write: " + ex.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
