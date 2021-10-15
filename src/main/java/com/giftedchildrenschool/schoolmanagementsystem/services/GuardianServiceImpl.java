package com.giftedchildrenschool.schoolmanagementsystem.services;

import com.giftedchildrenschool.schoolmanagementsystem.data.model.Guardian;
import com.giftedchildrenschool.schoolmanagementsystem.data.repository.GuardianRepository;
import com.giftedchildrenschool.schoolmanagementsystem.payload.request.GuardianRequest;
import org.springframework.stereotype.Service;

@Service
public class GuardianServiceImpl implements GuardianService{

    private final GuardianRepository guardianRepository;

    public GuardianServiceImpl(GuardianRepository guardianRepository) {
        this.guardianRepository = guardianRepository;
    }


    @Override
    public Guardian save(Guardian guardian) {
     return guardianRepository.save(guardian);
    }

    @Override
    public Guardian register(GuardianRequest guardianRequest) {
        Guardian guardian =  new Guardian();
        guardian.setFullName(guardianRequest.getFullName());
        guardian.setPhoneNUmber(guardianRequest.getPhoneNUmber());
        guardian.setEmail(guardianRequest.getEmail());
        guardian.setPassword(guardianRequest.getPassword());
        save(guardian);
        return guardian;
    }
}
