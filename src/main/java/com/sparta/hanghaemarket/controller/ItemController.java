package com.sparta.hanghaemarket.controller;

import com.sparta.hanghaemarket.dto.ItemRequestDto;
import com.sparta.hanghaemarket.dto.ItemResponseDto;
import com.sparta.hanghaemarket.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    //판매 게시글 작성
    @PostMapping("/post")
    public ItemResponseDto createItem(@RequestBody ItemRequestDto requestDto) {
        return itemService.createItem(requestDto);
    }

    //판매 게시글 전체 리스트 조회
    @GetMapping("/post")
    public List<ItemResponseDto> getItems() {
        return itemService.getItems();
    }

    //판매 게시글 수정
    @PutMapping("/post/{id}")
    public Long updateItem(@PathVariable Long id, @RequestBody ItemRequestDto requestDto) {
        return itemService.updateItem(id, requestDto);
    }

    //게시글 삭제
    @DeleteMapping("/post/{id}")
    public Long deleteItem(@PathVariable Long id) {
        return itemService.deleteItem(id);
    }
}