package com.giftedchildrenschool.schoolmanagementsystem.controller;

import com.giftedchildrenschool.schoolmanagementsystem.data.model.Guardian;
import com.giftedchildrenschool.schoolmanagementsystem.payload.request.GuardianRequest;
import com.giftedchildrenschool.schoolmanagementsystem.services.GuardianService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/guardian")
public class GuardianController {
    GuardianService guardianService;

    public GuardianController(GuardianService guardianService){
        this.guardianService = guardianService;
    }

    @PostMapping("/register/")
    public ResponseEntity<?> registerGuardian(@RequestBody GuardianRequest guardianRequest){
        Guardian guardian =  guardianService.register(guardianRequest);
        return new ResponseEntity<>(guardian, HttpStatus.OK);
    }

    @GetMapping("/getGuardianById/{id}")
    public ResponseEntity<?> findGuardian(@PathVariable Long id){
        Guardian guardian = guardianService.findGuardianById(id);
        return new ResponseEntity<>(guardian, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteGuardian(@PathVariable Long id){
        guardianService.deleteGuardianById(id);
        String response = "Guardian deleted";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
