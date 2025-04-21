package ma.ac.usmba.springApp.service;

import ma.ac.usmba.springApp.dao.ClientDao;
import ma.ac.usmba.springApp.dto.ClientRequestDto;
import ma.ac.usmba.springApp.dto.ClientResponseDto;
import ma.ac.usmba.springApp.exception.EntityNotFoundException;
import ma.ac.usmba.springApp.models.ClientEntity;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("impl1")
public class ClientServiceImpl implements ClientService{
    private ClientDao clientDao;
    private ModelMapper modelMapper;


    public ClientServiceImpl(ClientDao clientDao, ModelMapper modelMapper) {
        this.clientDao = clientDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public ClientResponseDto save(ClientRequestDto clientRequestDto) {
        ClientEntity clientEntity = modelMapper.map(clientRequestDto, ClientEntity.class);
        ClientEntity saved = clientDao.save(clientEntity);
        return modelMapper.map(saved, ClientResponseDto.class);
    }

    @Override
    public ClientResponseDto findById(Integer id) {
        ClientEntity clientEntity = clientDao.findById(id).orElseThrow( ()
        -> new EntityNotFoundException("Client not found"));
        return modelMapper.map(clientEntity, ClientResponseDto.class);
    }

    @Override
    public ClientResponseDto findByNom(String nome) {
        ClientEntity clientEntity = clientDao.findByNome(nome);
        return modelMapper.map(clientEntity, ClientResponseDto.class);
    }

    @Override
    public Void delete(Integer id) {

        ClientEntity clientEntity = clientDao.findById(id).get();
        clientDao.deleteById(clientEntity.getId());

        return null;
    }

    @Override
    public ClientResponseDto update(ClientRequestDto ClientRequestDto, Integer id) {
        Optional<ClientEntity> clientEntityOptional = clientDao.findById(id);
        if (clientEntityOptional.isPresent()) {
            ClientEntity clientEntity = modelMapper.map(ClientRequestDto, ClientEntity.class);
            ClientEntity updated = clientDao.save(clientEntity);
            return modelMapper.map(updated, ClientResponseDto.class);
        } else {

            throw  new EntityNotFoundException("client not Found");
        }

    }
    @Override
    public List<ClientResponseDto> findAll() {
        return clientDao.findAll()
                .stream().map(el->modelMapper.map(el ,ClientResponseDto.class)).collect(Collectors.toList());
    }

}
