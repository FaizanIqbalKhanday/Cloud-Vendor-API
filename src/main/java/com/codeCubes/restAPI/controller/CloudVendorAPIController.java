package com.codeCubes.restAPI.controller;

import com.codeCubes.restAPI.model.CloudVendor;
import com.codeCubes.restAPI.response.ResponseHandler;
import com.codeCubes.restAPI.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorAPIController {
    CloudVendorService cloudVendorService;
    public CloudVendorAPIController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }


    @GetMapping("/{vendorId}")
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        return ResponseHandler.responseBuilder("Requested vendor details are given here", HttpStatus.OK,cloudVendorService.geCloudVendor(vendorId));

    }
    @GetMapping()
    public List<CloudVendor> getAllCloudVendorDetails(){
        return cloudVendorService.getAllCloudVendors();
    }
    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){

        cloudVendorService.createCloudVendor(cloudVendor);
        return "cloud vendor created";
    }


    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){

        cloudVendorService.updateCloudVendor(cloudVendor);
        return "cloud vendor updated Successfully";
    }
    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorID){

        cloudVendorService.deleteCloudVendor(vendorID);
        return "cloud vendor deleted Successfully";
    }
}
