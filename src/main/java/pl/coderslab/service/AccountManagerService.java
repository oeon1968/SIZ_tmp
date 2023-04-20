package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.AccountManagerDao;
import pl.coderslab.model.AccountManager;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountManagerService {
    private final AccountManagerDao am;
    public void insert (AccountManager accountManager) {
        am.insert(accountManager);
    }

    public void update (AccountManager accountManager) {
        am.update(accountManager);
    }

    public void delete(AccountManager accountManager) {
        am.delete(accountManager);
    }

    public List<AccountManager> getAccountManagerList() {
        return am.accountManagerList();
    }

    public AccountManager getAccountManager(int id) {
        return am.findObject(id);
    }
}
