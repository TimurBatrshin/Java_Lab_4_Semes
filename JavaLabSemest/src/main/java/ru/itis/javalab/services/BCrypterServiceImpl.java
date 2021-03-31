package ru.itis.javalab.services;

import org.springframework.stereotype.Service;

@Service
public class BCrypterServiceImpl implements BCrypterService {
    @Override
    public boolean checkPassword(String pass, String dbPass) {
           if (pass.equals(dbPass)) {
                return true;
            } else return false;
        }
    }
