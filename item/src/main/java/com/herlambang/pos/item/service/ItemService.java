package com.herlambang.pos.item.service;

import com.herlambang.pos.item.entity.Item;
import com.herlambang.pos.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final FileUploadService fileUploadService;

    public Item createItem(Item item, MultipartFile barangFile) {
        String filePath = fileUploadService.saveUploadedFile(barangFile);
        item.setBarang(filePath);
        return itemRepository.save(item);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Optional<Item> getItemById(UUID id) {
        return itemRepository.findById(id);
    }

    public Item updateItem(UUID id, Item updatedItem, MultipartFile barangFile) {
        if (itemRepository.existsById(id)) {
            if(barangFile != null) {
                String filePath = fileUploadService.saveUploadedFile(barangFile);
                updatedItem.setBarang(filePath);
            }
            updatedItem.setId(id);
            return itemRepository.save(updatedItem);
        }
        return null;
    }

    public void deleteItem(UUID id) {
        itemRepository.deleteById(id);
    }

}
