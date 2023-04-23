package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.ClientDao;
import pl.coderslab.model.Client;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientDao clientDao;

    public void insert(Client client) {
        clientDao.insert(client);
    }

    public void update (Client client) {
        clientDao.update(client);
    }

    public void delete (Client client) {
        clientDao.delete(client);
    }

    public Client getClient(Integer id) {
        return clientDao.findObject(id);
    }

    public List<Client> getClientList() {
        return clientDao.clientList();
    }
}
