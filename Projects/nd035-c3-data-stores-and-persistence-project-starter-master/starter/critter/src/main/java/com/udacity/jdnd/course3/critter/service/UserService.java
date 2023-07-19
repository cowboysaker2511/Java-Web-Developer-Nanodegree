package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.dto.CustomerDTO;
import com.udacity.jdnd.course3.critter.dto.EmployeeDTO;
import com.udacity.jdnd.course3.critter.dto.EmployeeRequestDTO;
import com.udacity.jdnd.course3.critter.entity.Customer;
import com.udacity.jdnd.course3.critter.entity.Employee;
import com.udacity.jdnd.course3.critter.repository.CustomerRepository;
import com.udacity.jdnd.course3.critter.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.*;

@Service
public class UserService {
    private CustomerRepository customerRepository;
    private EmployeeRepository employeeRepository;

    public UserService(CustomerRepository customerRepository, EmployeeRepository employeeRepository) {
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
    }

    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(customerDTO);
        Customer save = customerRepository.save(customer);
        return new CustomerDTO(save);
    }

    public List<CustomerDTO> getAllCustomers() {
        List<Customer> all = customerRepository.findAll();

        List<CustomerDTO> customerDTOS = new ArrayList<>();
        all.stream().forEach((customer) -> {
            CustomerDTO e = new CustomerDTO(customer);
            customerDTOS.add(e);
        });
        System.out.println(customerDTOS);
        return customerDTOS;
    }

    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO);
        Employee save = employeeRepository.save(employee);
        return new EmployeeDTO(save);
    }

    public EmployeeDTO getEmployee(long employeeId) {
        Employee employee = employeeRepository.getOne(employeeId);
        return new EmployeeDTO(employee);
    }

    public void setAvailability(Set<DayOfWeek> daysAvailable, long employeeId) {
        Employee employee = employeeRepository.getOne(employeeId);
        employee.setDaysAvailable(daysAvailable);
        employeeRepository.save(employee);
    }

    public List<EmployeeDTO> findEmployeesForService(EmployeeRequestDTO employeeDTO) {
        List<Employee> employeeList = employeeRepository.findDistinctByDaysAvailableInAndSkillsIn(
                new HashSet<>(Arrays.asList(employeeDTO.getDate().getDayOfWeek())),
                employeeDTO.getSkills());

        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        employeeList.stream().forEach((employee -> {
            employeeDTOS.add(new EmployeeDTO(employee));
        }));
        return employeeDTOS;
    }

    public CustomerDTO getOwnerByPet(long petId) {
        Customer byPetId = customerRepository.findByPetsId(petId);
        return new CustomerDTO(byPetId);
    }
}
