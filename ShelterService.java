package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Shelter;
import com.example.demo.repository.ShelterRepository;

@Service
public class ShelterService {

    @Autowired
    private ShelterRepository shelterRepository;

    public Shelter saveShelter(Shelter shelter) {
        return shelterRepository.save(shelter);
    }

    public List<Shelter> getAllShelters() {
        return shelterRepository.findAll();
    }

    public Optional<Shelter> getShelterById(Long id) {
        return shelterRepository.findById(id);
    }

    public Shelter updateShelter(Long id, Shelter shelterDetails) {
        Optional<Shelter> existingShelter = shelterRepository.findById(id);
        if (existingShelter.isPresent()) {
            Shelter shelter = existingShelter.get();
            shelter.setName(shelterDetails.getName());
            shelter.setLocation(shelterDetails.getLocation());
            return shelterRepository.save(shelter);
        } else {
            throw new RuntimeException("Shelter not found with id " + id);
        }
    }

    public void deleteShelter(Long id) {
        shelterRepository.deleteById(id);
    }
}
