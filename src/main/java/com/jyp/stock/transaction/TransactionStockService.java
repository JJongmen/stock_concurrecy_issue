package com.jyp.stock.transaction;

import com.jyp.stock.service.SynchronizedStockService;

public class TransactionStockService {

    private SynchronizedStockService synchronizedStockService;

    public TransactionStockService(final SynchronizedStockService synchronizedStockService) {
        this.synchronizedStockService = synchronizedStockService;
    }

    public void decrease(Long id, Long quantity) {
        startTransaction();

        synchronizedStockService.decrease(id, quantity);

        endTransaction();
    }

    private void startTransaction() {
        System.out.println("Transaction Start");
    }

    private void endTransaction() {
        System.out.println("Commit");
    }
}
