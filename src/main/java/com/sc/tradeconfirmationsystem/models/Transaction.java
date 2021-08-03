package com.sc.tradeconfirmationsystem.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.ZonedDateTime;

@Entity
public class Transaction {
    @Id
    private String txnRefNo;
    private String uniqueId;
    private String clientName;
    private String bookingName;
    private String callCurrency;
    private double callCurrencyAmt;
    private String putCurrency;
    private double putCurrencyAmt;
    private LocalDate settlementDate;
    private LocalDate valuationDate;
    private ZonedDateTime uploadTime;
    private int status;
    private String xmlFile;
    private String outboundPdfFile;
    private String inboundPdfFile;

    public String getTxnRefNo() {
        return txnRefNo;
    }

    public void setTxnRefNo(String txnRefNo) {
        this.txnRefNo = txnRefNo;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getBookingName() {
        return bookingName;
    }

    public void setBookingName(String bookingName) {
        this.bookingName = bookingName;
    }

    public String getCallCurrency() {
        return callCurrency;
    }

    public void setCallCurrency(String callCurrency) {
        this.callCurrency = callCurrency;
    }

    public double getCallCurrencyAmt() {
        return callCurrencyAmt;
    }

    public void setCallCurrencyAmt(double callCurrencyAmt) {
        this.callCurrencyAmt = callCurrencyAmt;
    }

    public String getPutCurrency() {
        return putCurrency;
    }

    public void setPutCurrency(String putCurrency) {
        this.putCurrency = putCurrency;
    }

    public double getPutCurrencyAmt() {
        return putCurrencyAmt;
    }

    public void setPutCurrencyAmt(double putCurrencyAmt) {
        this.putCurrencyAmt = putCurrencyAmt;
    }

    public LocalDate getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(LocalDate settlementDate) {
        this.settlementDate = settlementDate;
    }

    public LocalDate getValuationDate() {
        return valuationDate;
    }

    public void setValuationDate(LocalDate valuationDate) {
        this.valuationDate = valuationDate;
    }

    public ZonedDateTime getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(ZonedDateTime uploadTime) {
        this.uploadTime = uploadTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getXmlFile() {
        return xmlFile;
    }

    public void setXmlFile(String xmlFile) {
        this.xmlFile = xmlFile;
    }

    public String getOutboundPdfFile() {
        return outboundPdfFile;
    }

    public void setOutboundPdfFile(String outboundPdfFile) {
        this.outboundPdfFile = outboundPdfFile;
    }

    public String getInboundPdfFile() {
        return inboundPdfFile;
    }

    public void setInboundPdfFile(String inboundPdfFile) {
        this.inboundPdfFile = inboundPdfFile;
    }
}
