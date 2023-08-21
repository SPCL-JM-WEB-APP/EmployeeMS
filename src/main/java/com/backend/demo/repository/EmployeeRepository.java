package com.backend.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.demo.model.*;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
//JPA REPO require 2 parameter 1.Entity name 2.type of the parameter
}
