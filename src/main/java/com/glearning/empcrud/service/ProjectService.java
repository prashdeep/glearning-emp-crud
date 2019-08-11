package com.glearning.empcrud.service;


import com.glearning.empcrud.model.Employee;
import com.glearning.empcrud.model.Project;

import java.util.List;
import java.util.Set;

public interface ProjectService {

    public void registerProject(Project project);

    List<Project> listAllProjects();

    Set<Employee> listAllEmployeesByProjectId(long projectId);
}
