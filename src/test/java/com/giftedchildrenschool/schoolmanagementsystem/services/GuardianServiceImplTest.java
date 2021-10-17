package com.giftedchildrenschool.schoolmanagementsystem.services;

import com.giftedchildrenschool.schoolmanagementsystem.data.model.Guardian;
import com.giftedchildrenschool.schoolmanagementsystem.data.repository.GuardianRepository;
import com.giftedchildrenschool.schoolmanagementsystem.exception.GuardianException;
import com.giftedchildrenschool.schoolmanagementsystem.payload.request.GuardianRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Slf4j
class GuardianServiceImplTest {

    @Autowired
    GuardianService guardianService;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void registerGuardian(){
        //       given
        GuardianRequest guardianRequest = new GuardianRequest();
        guardianRequest.setFullName("chibuzo gabriel");
        guardianRequest.setPhoneNUmber("09020000123");
        guardianRequest.setEmail("chiboy@yahoo.com");
        guardianRequest.setPassword("12345");

//        when
        Guardian guardian = guardianService.register(guardianRequest);

//        assert
        assertThat(guardian.getGuardianId()).isNotNull();
    }

    @Test
    void findGuardianById() {
//        given
        GuardianRequest guardianRequest = new GuardianRequest();
        guardianRequest.setFullName("uncle danny");
        guardianRequest.setPhoneNUmber("09020213456");
        guardianRequest.setEmail("uncledan@yahoo.com");
        guardianRequest.setPassword("1234556");

        Guardian guardian = guardianService.register(guardianRequest);

//        when
        Long testId = guardian.getGuardianId();

//        assert
        assertThat(guardian).isEqualTo(guardianService.findGuardianById(testId));
    }

    @Test
    void deleteGuardianById(){
//        given
        GuardianRequest guardianRequest = new GuardianRequest();
        guardianRequest.setFullName("uncle danny 2");
        guardianRequest.setPhoneNUmber("09020213457");
        guardianRequest.setEmail("uncledan2@yahoo.com");
        guardianRequest.setPassword("1234576");

        Guardian guardian = guardianService.register(guardianRequest);
        assertThat(guardian.getGuardianId()).isNotNull();

////        when
        guardianService.deleteGuardianById(guardian.getGuardianId());
//
////        assert
        try {
            assertThat(guardianService.findGuardianById(guardian.getGuardianId())).isNull();
        }catch (GuardianException ex){
            log.info("exception -> ", ex);
        }
    }
}

//  assertThat(productRepositoryImpl.findById(110L).orElse(null)).isNotNull();
//        productRepositoryImpl.deleteById(110L);
//        assertThat(productRepositoryImpl.findById(110L).orElse(null)).isNull();