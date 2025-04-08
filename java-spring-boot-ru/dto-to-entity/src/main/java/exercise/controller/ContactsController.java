package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import exercise.model.Contact;
import exercise.repository.ContactRepository;
import exercise.dto.ContactDTO;
import exercise.dto.ContactCreateDTO;

@RestController
@RequestMapping("/contacts")
public class ContactsController {

    @Autowired
    private ContactRepository contactRepository;

    private ContactDTO toDto(Contact contact) {
        var contactDTO = new ContactDTO();

        contactDTO.setId(contact.getId());
        contactDTO.setFirstName(contact.getFirstName());
        contactDTO.setLastName(contact.getLastName());
        contactDTO.setCreatedAt(contact.getCreatedAt());
        contactDTO.setPhone(contact.getPhone());
        contactDTO.setUpdatedAt(contact.getUpdatedAt());

        return contactDTO;
    }

    private Contact toEntity(ContactCreateDTO contactCreateDTO) {
        Contact contact = new Contact();

        contact.setFirstName(contactCreateDTO.getFirstName());
        contact.setLastName(contactCreateDTO.getLastName());
        contact.setPhone(contactCreateDTO.getPhone());

        return contact;
    }

    // BEGIN
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContactDTO create(@RequestBody ContactCreateDTO contactCreateDTO) {
        var entity = toEntity(contactCreateDTO);
        contactRepository.save(entity);
        var contactDTO = toDto(entity);

        return contactDTO;
    }
    // END
}
