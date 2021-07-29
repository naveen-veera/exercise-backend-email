package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import exception.ResourceNotFoundException;
import model.EmailModel;
import repository.EmailRepository;

@CrossOrigin(origins = "*")
@RestController
public class EmailController {
	
	@Autowired
	private EmailRepository emailRepo;
	
	
	//Server Started
	@GetMapping("/")
	public String home(){
		return "Email app server Started";
	}
	
	//Get all Booking
	@GetMapping("/allemails")
	public List<EmailModel> getAllEmails(){
		return emailRepo.findAll();
	}
	
	//Get all Booking
	@GetMapping("/email/{id}")
	public Optional<EmailModel> getEmailById(@PathVariable(value = "id") int id)throws ResourceNotFoundException{
		emailRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Email not found for this id :: " + id));
		return emailRepo.findById(id);
	}
	
	//Sending mail
	@PostMapping("/sendmail")
	public EmailModel sendMail(@RequestBody EmailModel mail) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		mail.setDate(formatter.format(new Date()));
		return emailRepo.save(mail);
	}
	
	//Delete email
	@DeleteMapping("/deletemail/{id}")
	public String removeBooking(@PathVariable(value = "id") int id) throws  ResourceNotFoundException{
		emailRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Email not found for this id :: " + id));
		emailRepo.deleteById(id);
		return "Email deleted";
	}

}
