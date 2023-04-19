package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.ClientTypeDao;
import pl.coderslab.model.Client;
import pl.coderslab.model.ClientType;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientTypeService {
    private final ClientTypeDao ct;

    public void insert (ClientType clientType) {
        ct.insert(clientType);
    }

    public void update (ClientType clientType) {
        ct.delete(clientType);
    }

    public void delete (ClientType clientType) {
        ct.delete(clientType);
    }

    public List<ClientType> getClientTypeList() {
        return  ct.ClientTypeList();
    }
}
