package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.dto.ScheduleDTO;
import com.udacity.jdnd.course3.critter.entity.Customer;
import com.udacity.jdnd.course3.critter.entity.Pet;
import com.udacity.jdnd.course3.critter.entity.Schedule;
import com.udacity.jdnd.course3.critter.repository.CustomerRepository;
import com.udacity.jdnd.course3.critter.repository.EmployeeRepository;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import com.udacity.jdnd.course3.critter.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {
    private ScheduleRepository scheduleRepository;
    private PetRepository petRepository;
    private EmployeeRepository employeeRepository;
    private CustomerRepository customerRepository;

    public ScheduleService(ScheduleRepository scheduleRepository, PetRepository petRepository, EmployeeRepository employeeRepository, CustomerRepository customerRepository) {
        this.scheduleRepository = scheduleRepository;
        this.petRepository = petRepository;
        this.employeeRepository = employeeRepository;
        this.customerRepository = customerRepository;
    }

    public ScheduleDTO createSchedule(ScheduleDTO scheduleDTO) {
        Schedule schedule = new Schedule();
        schedule.setDate(scheduleDTO.getDate());
        schedule.setActivities(scheduleDTO.getActivities());
        schedule.setPets(petRepository.findAllById(scheduleDTO.getPetIds()));
        schedule.setEmployees(employeeRepository.findAllById(scheduleDTO.getEmployeeIds()));
        Schedule save = scheduleRepository.save(schedule);
        return new ScheduleDTO(save);
    }

    public List<ScheduleDTO> getAllSchedules() {
        List<Schedule> all = scheduleRepository.findAll();

        return convertToDTOList(all);
    }

    public List<ScheduleDTO> getScheduleForPet(long petId) {
        List<Schedule> scheduleByPetsId = scheduleRepository.findScheduleByPetsId(petId);

        return convertToDTOList(scheduleByPetsId);
    }

    public List<ScheduleDTO> getScheduleForEmployee(long employeeId) {
        List<Schedule> scheduleByEmployeesId = scheduleRepository.findScheduleByEmployeesId(employeeId);

        return convertToDTOList(scheduleByEmployeesId);
    }

    public List<ScheduleDTO> getScheduleForCustomer(long customerId) {
        Customer customer = customerRepository.getOne(customerId);
        List<Pet> pets = customer.getPets();

        List<ScheduleDTO> scheduleDTOS = new ArrayList<>();
        pets.stream().forEach((pet) -> {
            List<Schedule> scheduleByPetsId = scheduleRepository.findScheduleByPetsId(pet.getId());
            scheduleByPetsId.stream().forEach((schedule) -> {
                scheduleDTOS.add(new ScheduleDTO(schedule));
            });
        });

        return scheduleDTOS;
    }

    List<ScheduleDTO> convertToDTOList(List<Schedule> listSchedule) {
        List<ScheduleDTO> scheduleDTOS = new ArrayList<>();
        listSchedule.stream().forEach((schedule) -> {
            scheduleDTOS.add(new ScheduleDTO(schedule));
        });
        return scheduleDTOS;
    }
}
