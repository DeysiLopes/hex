package com.deysi.hex.adapters.in.controller.response;

import lombok.Data;

@Data
public class CustomerResponse {
    private String name;
    private AddressResponse  address;
    private String cpf;
    private Boolean isValidCpf;

    public CustomerResponse(String name, AddressResponse address, String cpf, Boolean isValidCpf) {
        this.name = name;
        this.address = address;
        this.cpf = cpf;
        this.isValidCpf = isValidCpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressResponse getAddress() {
        return address;
    }

    public void setAddress(AddressResponse address) {
        this.address = address;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Boolean getValidCpf() {
        return isValidCpf;
    }

    public void setValidCpf(Boolean validCpf) {
        isValidCpf = validCpf;
    }
}
