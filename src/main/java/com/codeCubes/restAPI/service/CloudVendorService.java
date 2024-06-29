package com.codeCubes.restAPI.service;

import com.codeCubes.restAPI.model.CloudVendor;

import java.util.List;

public interface CloudVendorService {
    public String createCloudVendor(CloudVendor cloudVendor);
    public String updateCloudVendor(CloudVendor cloudVendor);
    public String deleteCloudVendor(String vendorId);
    public CloudVendor geCloudVendor(String vendorId);
    public List<CloudVendor> getAllCloudVendors();

}
