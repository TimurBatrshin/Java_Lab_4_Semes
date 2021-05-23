package ru.itis.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.springboot.models.Contests;
import ru.itis.springboot.repositories.ContestRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContestServiceImpl implements ContestService {

    @Autowired
    private ContestRepository contestRepository;

    @Override
    public List<Contests> findAll() {
        return contestRepository.findAll();
    }

    @Override
    public Optional<Contests> findById(Long id) {
        return contestRepository.findById(id);
    }
}
