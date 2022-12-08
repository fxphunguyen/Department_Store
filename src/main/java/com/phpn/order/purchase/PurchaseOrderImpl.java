package com.phpn.order.purchase;

import com.phpn.order.purchase.dto.CreatePurchaseOrderParam;
import com.phpn.order.purchase.dto.PurchaseOrderMapper;
import com.phpn.order.purchase.dto.PurchaseOrderResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseOrderImpl implements PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;

    @Override
    @Transactional
    public List<PurchaseOrderResult> findAll() {
        return purchaseOrderRepository.findAll()
                .stream()
                .map(purchaseOrderMapper :: toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public PurchaseOrderResult create(CreatePurchaseOrderParam createPurchaseOrder) {

        return null;
    }
}
