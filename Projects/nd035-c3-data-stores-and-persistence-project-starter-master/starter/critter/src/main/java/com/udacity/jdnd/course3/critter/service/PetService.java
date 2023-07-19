package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.dto.PetDTO;
import com.udacity.jdnd.course3.critter.entity.Customer;
import com.udacity.jdnd.course3.critter.entity.Pet;
import com.udacity.jdnd.course3.critter.repository.CustomerRepository;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetService {
    private PetRepository petRepository;
    private CustomerRepository customerRepository;

    public PetService(PetRepository petRepository, CustomerRepository customerRepository) {
        this.petRepository = petRepository;
        this.customerRepository = customerRepository;
    }

    public PetDTO savePet(PetDTO petDTO) {
        Pet pet = new Pet(petDTO);

        //set pet for customer
        Customer owner = customerRepository.getOne(petDTO.getOwnerId());
        owner.getPets().add(pet);
        pet.setCustomer(owner);

        Pet save = petRepository.save(pet);
        return new PetDTO(save);
    }

    public PetDTO getPet(long petId) {
        Pet pet = petRepository.getOne(petId);
        return new PetDTO(pet);
    }

    public List<PetDTO> getPets() {
        List<Pet> all = petRepository.findAll();

        return convertToDTOList(all);
    }

    public List<PetDTO> getPetsByOwner(long ownerId) {
        List<Pet> petByCustomerId = petRepository.findPetByCustomerId(ownerId);

        return convertToDTOList(petByCustomerId);
    }


    List<PetDTO> convertToDTOList(List<Pet> listPet) {
        List<PetDTO> petDTOS = new ArrayList<>();
        listPet.stream().forEach((pet) -> {
            petDTOS.add(new PetDTO(pet));
        });
        return petDTOS;
    }
}
