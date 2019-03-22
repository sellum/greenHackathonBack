package com.hackathon.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.entity.Category;
import com.hackathon.entity.Company;
import com.hackathon.entity.Project;
import com.hackathon.repository.CategoryRepository;
import com.hackathon.repository.CompanyRepository;
import com.hackathon.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping
    public String sayHello() {
        return "Hello and Welcome to the GCNS Member application.";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/projects")
    @ResponseBody
    public List<Project> getAllProjects() {

        return projectRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/companies")
    @ResponseBody
    public List<Company> getAllCompanies() {

        return companyRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/categories")
    @ResponseBody
    public List<Category> getAllCategories() {

        return categoryRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/projects")
    @ResponseBody
    public Project saveProject(@RequestBody String json) throws Exception{

        Map<String, String> map = getasMap(json);

        long companyId = Long.valueOf(map.get("company_id"));
        Optional<Company> company = companyRepository.findById(companyId);
        if (!company.isPresent()) {
            throw new IllegalArgumentException("Company id is not recognized.");
        }

        String title = map.get("title");
        String status = map.get("status");
        String description = map.get("description");
        String moreInfo = map.get("moreInfo");

        Project project = new Project(title, status, description, moreInfo, company.get());
        projectRepository.save(project);
        return project;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/categories")
    @ResponseBody
    public Category saveCategory(@RequestBody Category category) {

        // TODO: how to check for existing name ?
        categoryRepository.save(category);
        return category;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/companies")
    @ResponseBody
    public Company saveCompany(@RequestBody String json) throws Exception {

        Map<String, String> map = getasMap(json);
        String name = map.get("name");
        String contactInfo = map.get("contact_info");
        long categoryId = Long.valueOf(map.get("category_id"));

        Optional<Category> category = categoryRepository.findById(categoryId);
        if (!category.isPresent()) {
            throw new IllegalArgumentException("category id is not recognized.");
        }

        Company company = new Company(name, contactInfo, category.get());
        companyRepository.save(company);
        return company;
    }

    private Map<String, String> getasMap(String json) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        Map<String, String> map;
        // convert JSON string to Map
        map = mapper.readValue(json, new TypeReference<Map<String, String>>(){});
        return map;

    }
}
