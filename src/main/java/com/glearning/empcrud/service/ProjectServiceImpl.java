package com.glearning.empcrud.service;

import com.glearning.empcrud.model.Employee;
import com.glearning.empcrud.model.Project;
import com.glearning.empcrud.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void registerProject(Project project) {

    }

    @Override
    public List<Project> listAllProjects() {
        return null;
    }

    @Override
    public Set<Employee> listAllEmployeesByProjectId(long projectId)
    {
        return null;
    }
}
