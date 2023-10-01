package com.jyp.stock.service;

import com.jyp.stock.domain.Stock;
import com.jyp.stock.repository.StockRepository;
import org.springframework.stereotype.Service;

@Service("synchronizedStockService")
public class SynchronizedStockService implements StockService {

    private final StockRepository stockRepository;

    public SynchronizedStockService(final StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

//    @Transactional
    @Override
    public synchronized void decrease(Long id, Long quantity) {
        final Stock stock = stockRepository.findById(id).orElseThrow();
        stock.decrease(quantity);

        stockRepository.saveAndFlush(stock);
    }
}
