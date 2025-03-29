package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.HealthRecord;
import com.example.demo.service.HealthRecordService;

@RestController
@RequestMapping("/healthrecords")
public class HealthRecordController {

    @Autowired
    private HealthRecordService healthRecordService;

    @GetMapping("/get")
    public List<HealthRecord> getAllHealthRecords() {
        return healthRecordService.getAllHealthRecords();
    }

    @GetMapping("/get/{id}")
    public HealthRecord getHealthRecordById(@PathVariable Long id) {
        return healthRecordService.getHealthRecordById(id);
    }

    @PostMapping("/post")
    public HealthRecord saveHealthRecord(@RequestBody HealthRecord healthRecord) {
        return healthRecordService.saveHealthRecord(healthRecord);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteHealthRecord(@PathVariable Long id) {
        healthRecordService.deleteHealthRecord(id);
    }
}
