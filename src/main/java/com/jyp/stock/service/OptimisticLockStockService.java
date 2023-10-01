package com.jyp.stock.service;

import com.jyp.stock.domain.Stock;
import com.jyp.stock.repository.StockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("optimisticLockStockService")
public class OptimisticLockStockService implements StockService {

    private final StockRepository stockRepository;

    public OptimisticLockStockService(final StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    @Transactional
    public void decrease(final Long id, final Long quantity) {
        final Stock stock = stockRepository.findByIdWithOptimisticLock(id);

        stock.decrease(quantity);

        stockRepository.save(stock);
    }
}
