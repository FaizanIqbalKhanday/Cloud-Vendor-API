package com.codeCubes.restAPI.service.imp;

import com.codeCubes.restAPI.exception.CloudVendorNotFoundException;
import com.codeCubes.restAPI.model.CloudVendor;
import com.codeCubes.restAPI.repository.CloudVendorRepository;
import com.codeCubes.restAPI.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CloudVendorServiceImpl implements CloudVendorService {
    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    CloudVendorRepository cloudVendorRepository;
    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String deleteCloudVendor(String vendorId) {
        cloudVendorRepository.deleteById(vendorId);
        return "Success";
    }

    @Override
    public CloudVendor geCloudVendor(String vendorId) {
        if(cloudVendorRepository.findById(vendorId).isEmpty())
            throw new CloudVendorNotFoundException("Requested cloud vendor does not exist");
        return cloudVendorRepository.findById(vendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        return cloudVendorRepository.findAll();
    }
}
