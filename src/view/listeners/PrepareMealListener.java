package view.listeners;

import model.Receipt;

public interface PrepareMealListener {
    void preparationReview(Receipt receipt);
    void prepare(Receipt receiptToPrepare);
}
