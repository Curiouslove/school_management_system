package com.giftedchildrenschool.schoolmanagementsystem.services;

import com.giftedchildrenschool.schoolmanagementsystem.data.model.Guardian;
import com.giftedchildrenschool.schoolmanagementsystem.payload.request.GuardianRequest;

public interface GuardianService {
    Guardian register(GuardianRequest guardianRequest);
    Guardian findGuardianById(Long id);
    void deleteGuardianById(Long id);
}
