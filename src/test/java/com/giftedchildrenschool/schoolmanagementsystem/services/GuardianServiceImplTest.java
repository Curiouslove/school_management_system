package com.giftedchildrenschool.schoolmanagementsystem.services;

import com.giftedchildrenschool.schoolmanagementsystem.data.model.Guardian;
import com.giftedchildrenschool.schoolmanagementsystem.data.repository.GuardianRepository;
import com.giftedchildrenschool.schoolmanagementsystem.payload.request.GuardianRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class GuardianServiceImplTest {

    @Autowired
    GuardianServiceImpl guardianService;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void saveGuardian() {
//        given
        Guardian guardian = new Guardian();
        guardian.setFullName("okum love");
        guardian.setPhoneNUmber("09020000745");
        guardian.setEmail("collinslove624@yahoo.com");
        guardian.setPassword("1234");

        assertThat(guardian.getGuardianId()).isNull();

//        when
        guardianService.save(guardian);

//        assert
        assertThat(guardian.getGuardianId()).isNotNull();
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
        Long id = guardian.getGuardianId();
        guardianService.deleteGuardianById(id);
//
////        assert
        assertThat(guardian.getGuardianId()).isNull();

    }
}