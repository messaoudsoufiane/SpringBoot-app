package ma.ac.usmba.springApp.controllers;

import jakarta.validation.Valid;
import ma.ac.usmba.springApp.dto.ClientRequestDto;
import ma.ac.usmba.springApp.dto.ClientResponseDto;
import ma.ac.usmba.springApp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("")
    public ResponseEntity<List<ClientResponseDto>>getClient() {
        return new ResponseEntity<>(clientService.findAll() , HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ClientResponseDto> save(@Valid @RequestBody() ClientRequestDto clientRequestDto) {
         ClientResponseDto clientResponseDto= clientService.save(clientRequestDto);
         return new ResponseEntity<>(clientResponseDto , HttpStatus.CREATED);

    }
    @GetMapping("/id/{id}")
    public ResponseEntity<ClientResponseDto> findById(@PathVariable("id") Integer id) {
        ClientResponseDto clientResponseDto= clientService.findById(id);
        return ResponseEntity.ok(clientResponseDto);
    }
    @GetMapping("nome/{nome}")
    public ResponseEntity<ClientResponseDto> findByNom(@PathVariable("nome") String nome) {
        ClientResponseDto clientResponseDto= clientService.findByNom(nome);
        return ResponseEntity.ok(clientResponseDto);
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> delete(@PathVariable() Integer id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/id/{id}")
    public ResponseEntity<ClientResponseDto> update(@Valid @RequestBody() ClientRequestDto ClientRequestDto,@PathVariable() Integer id) {
        ClientResponseDto clientResponseDto=  clientService.update(ClientRequestDto, id);
        return ResponseEntity.accepted().body(clientResponseDto);
    }

}

