package com.phpn.services.item;

import com.phpn.dto.item.ItemResult;
import com.phpn.dto.product.ProductResult;
import com.phpn.mappers.employee.EmployeeMapper;
import com.phpn.mappers.item.ItemMapper;
import com.phpn.mappers.product.ProductMapper;
import com.phpn.repositories.ItemRepository;
import com.phpn.repositories.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    @Transactional
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

//    @Override
//    public List<ItemResult> findAllByProductIdAndAvailableAndQuantity() {
//        return itemRepository.findAllByProductIdAndAvailableAndQuantity()
//                .stream()
//                .map(itemMapper :: toDTO)
//                .collect(Collectors.toList());
//    }


}
