package com.example.simplecrm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InteractionService {

    @Autowired 
    private InteractionRepository interactionRepository;
    
 // Create
 public Interaction createInteraction(Interaction interaction) {
    Interaction newInteraction = interactionRepository.save(interaction);
    // return customerRepository.createCustomer(customer);
    return newInteraction;
  }

  // Get One
  public Interaction getInteraction(int id) {
    // Customer foundCustomer = customerRepository.getCustomer(findIndexById(id));
    return new Interaction();
  }

   // Get All
   public ArrayList<Interaction> getAllInteractions() {
    List<Interaction> allInteractions = interactionRepository.findAll();
    return (ArrayList<Interaction>) allInteractions;
  }

  // Update
  public Interaction updateInteraction(int id, Interaction interaction) {
    Interaction interactionToUpdate = interactionRepository.findById(id).get();

    // Update the interaction retrieved from DB
    interactionToUpdate.setRemarks(interaction.getRemarks());
    interactionToUpdate.setInteractionDate(interaction.getInteractionDate());
    // Save and return the data
    return interactionRepository.save(interactionToUpdate);
    // Customer updatedCustomer = customerRepository.updateCustomer(findIndexById(id), customer);
  }

  // Delete
  public void deleteInteraction(int id) {
    interactionRepository.deleteById(id);
  }

  // Technically this is part of the business logic and should in be service
  // Because the controller mainly just handles HTTP request and response

}
