package com.github.mssql.controller;

import com.github.mssql.common.exception.ResourceNotFoundException;
import com.github.mssql.model.BsdDetectionitem;
import com.github.mssql.repository.BsdDetectionItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @description: w
 * @author: KL
 * @create: 2019-07-27
 */
@RestController
public class BsdDetectionItemController {

    @Autowired
    private BsdDetectionItemRepository bsdDetectionItemRepository;

    @GetMapping("/bsdDetectionItem")
    public Page<BsdDetectionitem> getAllBsdDetectionItem()
            throws ResourceNotFoundException {
        return bsdDetectionItemRepository.findAll(new PageRequest(1, 20));
    }

    @PostMapping("/bsdDetectionItem")
    public BsdDetectionitem saveBsdDetectionItem(@RequestBody BsdDetectionitem bsdDetectionitem)
            throws ResourceNotFoundException {
        return bsdDetectionItemRepository.save(bsdDetectionitem);
    }
}
