package com.willian.thomaz.desafioanalisedados.service;

import com.willian.thomaz.desafioanalisedados.entity.Client;

import java.util.List;

public class ClientService {

    public Client createClient(List<String> list) {
        return new Client(Long.valueOf(list.get(0)),
                Long.valueOf(list.get(1)),
                list.get(2), list.get(3));
    }

    public Integer getClientsize(List<Client> clients) {
        return clients.size();
    }
}
