package ma.ac.usmba.springApp.service;

import ma.ac.usmba.springApp.dto.ClientRequestDto;
import ma.ac.usmba.springApp.dto.ClientResponseDto;
import ma.ac.usmba.springApp.models.ClientEntity;

import java.util.List;

public interface ClientService {

    ClientResponseDto  save(ClientRequestDto ClientRequestDto) ;
    ClientResponseDto findById(Integer id);
    ClientResponseDto findByNom(String nome);
    Void delete(Integer id);
    ClientResponseDto update(ClientRequestDto ClientRequestDto , Integer id);
    List<ClientResponseDto> findAll();



}
