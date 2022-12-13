package com.phpn.product.item;

import com.phpn.employee.dto.EmployeeMapper;
import com.phpn.product.ProductMapper;
import com.phpn.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.fx.qh.sapo.entities.product.Item;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private ProductMapper productMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ItemResult> findAll() {
        return itemRepository.findAll()
                .stream()
                .map(item -> {
                    ItemResult result = itemMapper.toDTO(item);
                    result.setEmployee(employeeMapper.toDTO(item.getEmployee()));
                    return result;
                })
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public int getTotalInventoryQuantityByProductId(Integer productId) {
        return itemRepository.getTotalInventoryQuantityByProductId(productId).orElse(0);
    }

    @Override
    @Transactional(readOnly = true)
    public int getAvailableInventoryQuantityByProductId(Integer productId) {
        return itemRepository.getAvailableInventoryQuantityByProductId(productId).orElse(0);
    }

    @Override
    public ItemResult create(CreateItemParam createItemParam) {
        return itemMapper.toDTO(itemRepository.save(itemMapper.toModel(createItemParam)));
    }

    @Override
    public ItemResult findAllByProductId(Integer productId) {
//        Chưa xong cần sửa
        return itemMapper.toDTO(itemRepository.findAllByProductId(productId));
    }

}
