package ru.itis.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.springboot.dto.TeamDto;
import ru.itis.springboot.models.Contests;
import ru.itis.springboot.models.Team;
import ru.itis.springboot.models.User;
import ru.itis.springboot.repositories.ContestRepository;
import ru.itis.springboot.repositories.TeamRepository;
import ru.itis.springboot.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    @Autowired
    private ContestRepository contestRepository;

    @Override
    public Optional<Team> findTeamByContest(Long contest_id) {
        return teamRepository.findAllByTeam(contest_id);
    }

    @Override
    public Team save(TeamDto teamDto) {
        Team team = Team.builder()
                .name(teamDto.getName())
                .photoUrl(teamDto.getPhotoUrl())
                .build();
        teamRepository.save(team);
        return team;
    }

    @Autowired
    UserRepository userRepository;

    @Override
    public void teamSaveUsers(Long team_id, Long user_id) {
        Optional<User> user = userRepository.findById(user_id);
        Optional<Team> team = teamRepository.findById(team_id);
        List<User> users = team.get().getUsers();
        users.add(user.get());
        team.get().setUsers(users);
        teamRepository.save(team.get());
//        teamRepository.saveTeam(team_id, user_id);
    }



    @Override
    public void teamSaveToContest(Long contest_id, Long team_id) {
        Optional<Contests> contests = contestRepository.findById(contest_id);
        Optional<Team> team = teamRepository.findById(team_id);
        List<Team> teams = contests.get().getTeams();
        teams.add(team.get());
        contests.get().setTeams(teams);
        contestRepository.save(contests.get());
//        teamRepository.saveTeamToContest(contest_id, team_id);


    }

    @Override
    public List<Long> findAllByTeam(Long team_id) {

        return teamRepository.selectTeam(team_id);
    }
}
