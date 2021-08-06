package com.sc.tradeconfirmationsystem.services;

import com.sc.tradeconfirmationsystem.models.Staff;
import com.sc.tradeconfirmationsystem.models.Transaction;
import com.sc.tradeconfirmationsystem.utils.StaticProvider;
import com.sc.tradeconfirmationsystem.viewmodels.TransactionViewModel;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService implements ITransactionService {
    @Override
    public List<TransactionViewModel> get(String marker) {
        switch (marker) {
            case StaticProvider.XML_MAKER:
                return getXmlMakerQueue();
            case StaticProvider.XML_CHECKER:
                return getXmlCheckerQueue();
            case StaticProvider.PDF_MAKER:
                return getPdfMakerQueue();
            case StaticProvider.PDF_CHECKER:
                return getPdfCheckerQueue();
            case StaticProvider.PDF_COMPARISON_MAKER:
                return getPdfComparisonMakerQueue();
            case StaticProvider.PDF_COMPARISON_CHECKER:
                return getPdfComparisonCheckerQueue();
            default:
                return null;
        }
    }

    @Override
    public TransactionViewModel parse(String fileName) throws ParserConfigurationException, IOException, SAXException {
        String filePath = getXmlFilePath(fileName);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        dbf.setNamespaceAware(true);
        DocumentBuilder db = dbf.newDocumentBuilder();

        Document doc = db.parse(new File(filePath));
        doc.getDocumentElement().normalize();

        NodeList uniqueItemIdList = doc.getElementsByTagName("UniqueItemId");
        NodeList tradeRefList = doc.getElementsByTagName("tradeRef");
        NodeList tiPrefixList = doc.getElementsByTagName("tiPrefix");
        NodeList uniqueIdentifierList = doc.getElementsByTagName("uniqueIdentifier");
        NodeList confirmationClientNameList = doc.getElementsByTagName("confirmationClientName");
        NodeList bookingEntityNameList = doc.getElementsByTagName("bookingEntityName");

        Element confCallCurrencyAmountElement = (Element) doc.getElementsByTagNameNS("http://www.fpml.org/FpML-5/confirmation", "callCurrencyAmount").item(0);
        NodeList callCurrencyList = confCallCurrencyAmountElement.getElementsByTagNameNS("http://www.fpml.org/FpML-5/confirmation", "currency");
        NodeList callCurrencyAmount = confCallCurrencyAmountElement.getElementsByTagNameNS("http://www.fpml.org/FpML-5/confirmation", "amount");

        Element confPutCurrencyAmountElement = (Element) doc.getElementsByTagNameNS("http://www.fpml.org/FpML-5/confirmation", "putCurrencyAmount").item(0);
        NodeList putCurrencyList = confPutCurrencyAmountElement.getElementsByTagNameNS("http://www.fpml.org/FpML-5/confirmation", "currency");
        NodeList putCurrencyAmount = confPutCurrencyAmountElement.getElementsByTagNameNS("http://www.fpml.org/FpML-5/confirmation", "amount");

        Element europeanExerciseElement = (Element) doc.getElementsByTagNameNS("http://www.fpml.org/FpML-5/confirmation", "europeanExercise").item(0);
        NodeList valueDateList = europeanExerciseElement.getElementsByTagNameNS("http://www.fpml.org/FpML-5/confirmation", "valueDate");
        NodeList expiryDateList = europeanExerciseElement.getElementsByTagNameNS("http://www.fpml.org/FpML-5/confirmation", "expiryDate");


        TransactionViewModel viewModel = new TransactionViewModel();
        viewModel.setTxnRefNo(getValue(uniqueItemIdList) + "/" + getValue(tradeRefList));
        viewModel.setUniqueId(getValue(tiPrefixList) + " " + getValue(uniqueIdentifierList));
        viewModel.setClientName(getValue(confirmationClientNameList));
        viewModel.setBookingName(getValue(bookingEntityNameList));
        viewModel.setCallCurrency(getValue(callCurrencyList));
        viewModel.setCallCurrencyAmt(Double.parseDouble(getValue(callCurrencyAmount)));
        viewModel.setPutCurrency(getValue(putCurrencyList));
        viewModel.setPutCurrencyAmt(Double.parseDouble(getValue(putCurrencyAmount)));
        viewModel.setSettlementDate(LocalDate.parse(getValue(valueDateList), DateTimeFormatter.ISO_LOCAL_DATE));
        viewModel.setValuationDate(LocalDate.parse(getValue(expiryDateList), DateTimeFormatter.ISO_LOCAL_DATE));

        return viewModel;
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

    private String getXmlFilePath(String fileName) {
        return "./" + StaticProvider.XML_UPLOAD_DIRECTORY_PATH + "/" + fileName;
    }

    private String getValue(NodeList nodeList) {
        return nodeList.item(0).getTextContent();
    }
}
