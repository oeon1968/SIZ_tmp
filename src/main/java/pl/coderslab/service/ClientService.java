package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.AccountManagerDao;
import pl.coderslab.dao.ClientDao;
import pl.coderslab.dao.ClientTypeDao;
import pl.coderslab.model.AccountManager;
import pl.coderslab.model.Client;
import pl.coderslab.model.ClientType;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientDao clientDao;
    private final AccountManagerDao accountManagerDao;
    private final ClientTypeDao clientTypeDao;

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

    //pobieranie danych powiązanych
    //------------CLIENT TYPES
    public List<ClientType> clientTypeList() {
        return clientTypeDao.clientTypeList();
    }
    public ClientType clientType(Integer id) {
        return clientTypeDao.findObject(id);
    }
    //-----------ACCOUNT MANAGERS
    public List<AccountManager> accountManagerList() {
        return accountManagerDao.accountManagerList();
    }

    public AccountManager accountManager(Integer id) {
        return accountManagerDao.findObject(id);
    }
}
