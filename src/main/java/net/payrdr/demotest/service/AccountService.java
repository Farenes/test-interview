package net.payrdr.demotest.service;

import net.payrdr.demotest.entity.Account;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AccountService {

    Map<Long, Account> accountCache = new HashMap<>();

    public Account get(Long id) {
        return accountCache.getOrDefault(id, null);
    }

}
