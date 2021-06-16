package com.project.lp1.service;

import com.project.lp1.exception.BadRequestException;
import com.project.lp1.model.ItemOrder;
import com.project.lp1.repository.ItemOrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
public class ItemOrderService {

    private final ItemOrderRepository itemOrderRepository;

    public ItemOrderService(ItemOrderRepository itemOrderRepository) {
        this.itemOrderRepository = itemOrderRepository;
    }

    public ItemOrder insert(@Validated ItemOrder itemOrder) {
        return itemOrderRepository.save(itemOrder);
    }

    public List<ItemOrder> findAll() {
        return itemOrderRepository.findAll();
    }

    public Optional<ItemOrder> findById(Long itemId) {
        return Optional.ofNullable(itemOrderRepository.findById(itemId)
                .orElseThrow(() -> new BadRequestException("Item Order Not Found!")));
    }
}
