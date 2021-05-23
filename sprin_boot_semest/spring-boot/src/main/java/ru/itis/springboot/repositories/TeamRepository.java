package ru.itis.springboot.repositories;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.SQLInsert;
import org.hibernate.sql.Insert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import ru.itis.springboot.models.Team;
import ru.itis.springboot.models.User;

import java.util.List;
import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {

    @Query(
            nativeQuery = true,
            value = "insert into team_users values (:team_id, :user_id)"
    )
    Team saveTeam(Long team_id, Long user_id);


    @Query(
            nativeQuery = true,
            value = "insert into team_contests values ( :team_id,:contest_id)"
    )
    void saveTeamToContest(Long contest_id, Long team_id);


    @Query(
            nativeQuery = true,
            value = "select user_id from team_users where team_id = :teamId"
    )
    List<Long> selectTeam(Long teamId);



    @Query(
            nativeQuery = true,
            value = "select * from team_contests join team t on t.id = team_contests.contests_id where contests_id = 19"
    )
    Optional<Team> findAllByTeam(Long contest_id);



}
