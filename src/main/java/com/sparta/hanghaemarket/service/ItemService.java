package com.sparta.hanghaemarket.service;

import com.sparta.hanghaemarket.dto.ItemRequestDto;
import com.sparta.hanghaemarket.dto.ItemResponseDto;
import com.sparta.hanghaemarket.entity.Item;
import com.sparta.hanghaemarket.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemResponseDto createItem(ItemRequestDto requestDto) {
        Item item = new Item(requestDto);
        Item saveItem = itemRepository.save(item);
        ItemResponseDto itemResponseDto = new ItemResponseDto(item);
        return itemResponseDto;
    }

    public List<ItemResponseDto> getItems() {
        return itemRepository.findAll().stream().map((ItemResponseDto::new)).toList();
    }

    @Transactional
    public Long updateItem(Long id, ItemRequestDto requestDto) {
        Item item = getItem(id);
        item.update(requestDto);
        return id;
    }

    public Long deleteItem(Long id) {
        Item item = getItem(id);
        itemRepository.delete(item);
        return id;
    }

    private Item getItem(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 없습니다."));
    }
}