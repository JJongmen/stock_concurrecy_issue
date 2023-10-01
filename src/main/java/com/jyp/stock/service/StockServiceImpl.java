package com.jyp.stock.service;

import com.jyp.stock.domain.Stock;
import com.jyp.stock.repository.StockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("stockServiceImpl")
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    public StockServiceImpl(final StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void decrease(final Long id, final Long quantity) {
        final Stock stock = stockRepository.findById(id).orElseThrow();
        stock.decrease(quantity);

        stockRepository.saveAndFlush(stock);
    }
}
