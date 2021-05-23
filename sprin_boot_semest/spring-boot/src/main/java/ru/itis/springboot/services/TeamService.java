package ru.itis.springboot.services;

import ru.itis.springboot.dto.TeamDto;
import ru.itis.springboot.models.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {
    Optional<Team> findTeamByContest(Long contest_id);
    Team save(TeamDto teamDto);
    void teamSaveUsers(Long team_id, Long user_id);
    List<Team> findAll();
    void teamSaveToContest(Long contest_id, Long team_id);

    List<Long> findAllByTeam(Long team_id);
}
