package com.phpn.services.item;

import com.phpn.dto.item.ItemResult;
import com.phpn.mappers.employee.EmployeeMapper;
import com.phpn.mappers.item.ItemMapper;
import com.phpn.repositories.ItemRepository;
import com.phpn.repositories.model.Item;
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

}
