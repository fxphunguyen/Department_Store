package com.phpn.payment;

import com.phpn.dto.purchase_order.PurchaseOrderCreate;
import com.phpn.dto.purchase_order.PurchaseOrderResult;
import com.phpn.order.PurchaseOrderMapper;
import com.phpn.order.PurchaseOrderRepository;
import vn.fx.qh.sapo.entities.PurchaseOrder;
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
    public PurchaseOrder create(PurchaseOrderCreate purchaseOrderCreate) {

        return null;
    }
}
