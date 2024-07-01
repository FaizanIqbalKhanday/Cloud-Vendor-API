package com.codeCubes.restAPI.repository;

import com.codeCubes.restAPI.model.CloudVendor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CloudVendorRepositoryTest {

    @Autowired
    private CloudVendorRepository cloudVendorRepository;
    private CloudVendor cloudVendor;

    @BeforeEach
    void setUp() {
        cloudVendor = new CloudVendor("1", "Amazon", "Kashmir", "9906662364");
        cloudVendorRepository.save(cloudVendor);
        // Check if the data is saved correctly
        assertThat(cloudVendorRepository.findAll()).hasSize(1);
    }

    @AfterEach
    void tearDown() {
        cloudVendor=null;
        cloudVendorRepository.deleteAll();
    }

    @Test
    void testFindByVendorName_Found() {
        List<CloudVendor> cloudVendorList = cloudVendorRepository.findByVendorName("Amazon");
        assertThat(cloudVendorList).isNotEmpty();  // This assertion will fail if the list is empty
            CloudVendor foundVendor = cloudVendorList.get(0);
            assertThat(foundVendor.getVendorId()).isEqualTo(cloudVendor.getVendorId());
            assertThat(foundVendor.getVendorAddress()).isEqualTo(cloudVendor.getVendorAddress());
        }
        @Test
    void testFindByVendorName_NotFound() {
        List<CloudVendor> cloudVendorList = cloudVendorRepository.findByVendorName("GCP");
        assertThat(cloudVendorList.isEmpty()).isTrue();  // This assertion will fail if the list is empty

    }
}