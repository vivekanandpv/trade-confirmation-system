package com.sc.tradeconfirmationsystem.services;


import com.sc.tradeconfirmationsystem.viewmodels.TransactionViewModel;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public interface ITransactionService {
    List<TransactionViewModel> get(String marker);
    TransactionViewModel parse(String fileName) throws ParserConfigurationException, IOException, SAXException;
}
