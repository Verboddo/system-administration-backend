package com.smeekens.systemadministration.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Servers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String ipAddress;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String serverName;

    public Servers() {
    }

    public Servers(String ipAddress, String serverName) {
        this.ipAddress = ipAddress;
        this.serverName = serverName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String IPAddress) {
        this.ipAddress = IPAddress;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }
}
