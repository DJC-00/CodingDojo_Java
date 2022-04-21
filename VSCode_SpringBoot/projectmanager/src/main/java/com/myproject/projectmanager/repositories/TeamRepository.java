package com.myproject.projectmanager.repositories;

import java.util.List;

import com.myproject.projectmanager.models.Team;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long>{

    List<Team> findAll();

    List<Team> findByUsersIdIs(Long id);

    List<Team> findByUsersIdIsNot(Long id);

    List<Team> findByUsersIdAndVenturesId(Long userId, Long ventureId);

    List<Team> findByVenturesIdIsNotIn(Long[] ventIds);

    List<Team> deleteByUsersIdAndVenturesId(Long userId, Long ventureId);
    
    @Query("SELECT t FROM Team t WHERE user_id = ?1")
    List<Team> findUserTeams(Long id);

    @Query("SELECT t FROM Team t WHERE user_id <> ?1")
    List<Team> findOtherTeams(Long id);
}