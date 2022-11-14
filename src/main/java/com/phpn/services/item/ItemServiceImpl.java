package com.phpn.services.item;

import com.phpn.dto.item.ItemResult;
import com.phpn.mappers.item.ItemMapper;
import com.phpn.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public List<ItemResult> findAll() {
        return itemRepository.findAll()
                .stream()
                .map(item -> itemMapper.toDTO(item))
                .collect(Collectors.toList());
    }

}
