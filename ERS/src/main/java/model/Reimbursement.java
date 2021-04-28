package model;

import java.sql.Blob;
import java.sql.Timestamp;

public class Reimbursement {
    private int reimbId;
    private double amount;
    private Timestamp submitted;
    private Timestamp resolved;
    private String description;
    private Blob receipt;
    private int author;
    private int resolver;
    private int statusId;
    private int typeId;


    public int getReimbId() {
        return reimbId;
    }

    public void setReimbId(int reimbId) {
        this.reimbId = reimbId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Timestamp getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Timestamp submitted) {
        this.submitted = submitted;
    }

    public Timestamp getResolved() {
        return resolved;
    }

    public void setResolved(Timestamp resolved) {
        this.resolved = resolved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Blob getReceipt() {
        return receipt;
    }

    public void setReceipt(Blob receipt) {
        this.receipt = receipt;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public int getResolver() {
        return resolver;
    }

    public void setResolver(int resolver) {
        this.resolver = resolver;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public Reimbursement(){};

    public Reimbursement(double amount, String description, int author, int typeId) {
        this.amount = amount;
        this.description = description;
        this.author = author;
        this.typeId = typeId;
    }

    public Reimbursement(double amount, Timestamp submitted, String description, int author, int typeId) {
        this.amount = amount;
        this.submitted = submitted;
        this.description = description;
        this.author = author;
        this.typeId = typeId;
    }

    public Reimbursement(double amount, Timestamp submitted, String description, int author, int resolver, int statusId, int typeId) {
        this.amount = amount;
        this.submitted = submitted;
        this.description = description;
        this.author = author;
        this.resolver = resolver;
        this.statusId = statusId;
        this.typeId = typeId;
    }

    public Reimbursement(int reimbId, double amount, Timestamp submitted, Timestamp resolved, String description, Blob receipt, int author, int resolver, int statusId, int typeId) {
        this.reimbId = reimbId;
        this.amount = amount;
        this.submitted = submitted;
        this.resolved = resolved;
        this.description = description;
        this.receipt = receipt;
        this.author = author;
        this.resolver = resolver;
        this.statusId = statusId;
        this.typeId = typeId;
    }


    @Override
    public String toString() {
        return "Reimbursement{" +
                "reimbId=" + reimbId +
                ", amount=" + amount +
                ", submitted=" + submitted +
                ", resolved=" + resolved +
                ", description='" + description + '\'' +
                ", receipt=" + receipt +
                ", author=" + author +
                ", resolver=" + resolver +
                ", statusId=" + statusId +
                ", typeId=" + typeId +
                '}';
    }
}
