package com.smeekens.systemadministration.services;

import com.smeekens.systemadministration.exceptions.ServerAlreadyExistsException;
import com.smeekens.systemadministration.exceptions.ServerNotFoundException;
import com.smeekens.systemadministration.models.Servers;
import com.smeekens.systemadministration.repository.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ServerService {

    @Autowired
    private ServerRepository serverRepository;

    public Long createServer(Servers servers) {
        Servers newServer = serverRepository.save(servers);
        return newServer.getId();
    }

    public Collection<Servers> getAllServers() {
        return serverRepository.findAll();
    }

    public void updateServer(Long id, Servers newServer) {

        Optional<Servers> serversOptional = serverRepository.findById(id);

        if (serversOptional.isPresent()) {
            Servers servers = serverRepository.findById(id).get();
            servers.setServerName(newServer.getServerName());
            servers.setIpAddress(newServer.getIpAddress());
            serverRepository.save(servers);
        } else {
            throw new ServerNotFoundException();
        }
    }

    public void deleteServer(Long id) {
        if (serverRepository.existsById(id)) {
            serverRepository.deleteById(id);
        } else {
            throw new ServerNotFoundException();
        }
    }

}
