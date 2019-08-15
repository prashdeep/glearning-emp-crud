package com.glearning.empcrud.repository;

import com.glearning.empcrud.model.Employee;
import com.glearning.empcrud.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProjectRepository  extends  JpaRepository<Project,Long>{
}
