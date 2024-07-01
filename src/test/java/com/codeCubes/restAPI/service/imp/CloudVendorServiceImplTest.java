package com.codeCubes.restAPI.service.imp;

import com.codeCubes.restAPI.model.CloudVendor;
import com.codeCubes.restAPI.repository.CloudVendorRepository;
import com.codeCubes.restAPI.service.CloudVendorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;


class CloudVendorServiceImplTest {
    @Mock
    private CloudVendorRepository cloudVendorRepository;
    private CloudVendorService cloudVendorService;
    AutoCloseable autoCloseable;
    CloudVendor cloudVendor;

    @BeforeEach
    void setUp() {
        autoCloseable= MockitoAnnotations.openMocks(this);
        cloudVendorService=new CloudVendorServiceImpl(cloudVendorRepository);
        cloudVendor=new CloudVendor("1","Amazon","Kashmir","9906662364");

    }

    @AfterEach
    void tearDown()  throws Exception{
        autoCloseable.close();
    }

    @Test
    void TestCreateCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);
        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
        assertThat(cloudVendorService.createCloudVendor(cloudVendor)).isEqualTo
                ("Success");
    }

    @Test
    void TestUpdateCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);
        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
        assertThat(cloudVendorService.updateCloudVendor(cloudVendor)).isEqualTo
                ("Success");
    }

    @Test
    void TestDeleteCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class,Mockito.CALLS_REAL_METHODS);
        doNothing().when(cloudVendorRepository).deleteById(any());
        assertThat(cloudVendorService.deleteCloudVendor("1")).isEqualTo("Success");
    }

    @Test
    void TestGetCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);
        when(cloudVendorRepository.findById("1")).thenReturn(Optional.ofNullable(cloudVendor));
        assertThat(cloudVendorService.geCloudVendor
                ("1").getVendorName()).isEqualTo(cloudVendor.getVendorName());

    }


    @Test
    void TestGetAllCloudVendors() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);
        when(cloudVendorRepository.findAll()).thenReturn(
                new ArrayList<CloudVendor>(Collections.singleton(cloudVendor))
        );
        assertThat(cloudVendorService.getAllCloudVendors().get(0).getVendorPhoneNumber()).isEqualTo
                (cloudVendor.getVendorPhoneNumber());

    }
}