package com.codeCubes.restAPI.repository;

import com.codeCubes.restAPI.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CloudVendorRepository extends JpaRepository<CloudVendor,String> {
}
