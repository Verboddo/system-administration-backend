package com.smeekens.systemadministration.controllers;

import com.smeekens.systemadministration.models.Servers;
import com.smeekens.systemadministration.services.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/servers")
public class ServerController {

    @Autowired
    private ServerService serverService;

    @PostMapping(value = "")
    public ResponseEntity<Object> createServer(@RequestBody Servers servers) {
        Long newServer = serverService.createServer(servers);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newServer).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("")
    public ResponseEntity<Object> getAllServers() {
        return ResponseEntity.ok().body(serverService.getAllServers());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateServer(@PathVariable("id") Long id, @RequestBody Servers servers) {
        serverService.updateServer(id, servers);
        return ResponseEntity.ok("Server updated");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteServer(@PathVariable("id") Long id) {
        serverService.deleteServer(id);
        return ResponseEntity.ok("Server deleted");
    }

}
