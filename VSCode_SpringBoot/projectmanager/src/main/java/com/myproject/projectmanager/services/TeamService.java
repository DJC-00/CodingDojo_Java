package com.myproject.projectmanager.services;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.myproject.projectmanager.models.Team;
import com.myproject.projectmanager.repositories.TeamRepository;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Service;


@Service
public class TeamService {

	private final TeamRepository teamRepo;

	public TeamService(TeamRepository teamRepo) {
		this.teamRepo = teamRepo;
	}
	
	// Find all the Teams
	public List<Team> allTeams() {
		return teamRepo.findAll();
	}

	public List<Team> userTeams(Long id) {
		return teamRepo.findByUsersIdIs(id);
		// return teamRepo.findByuser_id(id);
	}

	public List<Team> otherTeams(Long id) {
		List<Team> userTeams = teamRepo.findByUsersIdIs(id);
		if (userTeams.size() == 0){
			return teamRepo.findAll();
		}
		Long[] tempVent;
		tempVent = new Long[userTeams.size()];
		for(int i = 0; i < tempVent.length; i++){
			Long teamVentureId = userTeams.get(i).getVentures().getId();
			tempVent[i] = teamVentureId;
		}
		return teamRepo.findByVenturesIdIsNotIn(tempVent);
		// return teamRepo.findOtherTeams(id);
	}
	
	// Create a Team
	public Team createTeam(Team team) {
        System.out.println("Createing Team");
		return teamRepo.save(team);
	}
	
	// Find One Team From Repo
	public Team findTeam(Long id) {
		
		Optional<Team> optTeam = teamRepo.findById(id);
		
		if(optTeam.isPresent()) {
			return optTeam.get();
			
		} else {
			
			return null;
		}
	}

	public Boolean teamCheck(Long userId, Long ventureId){
		List<Team> teamCheck =  teamRepo.findByUsersIdAndVenturesId( userId,  ventureId);
		Boolean bValue = teamCheck.size() == 0;
		return bValue;
	}

	@Transactional
	public void leaveTeam(Long userId, Long ventureId){
		teamRepo.deleteByUsersIdAndVenturesId(userId, ventureId);
	}

	public void deleteTeam(Long id) {
		teamRepo.deleteById(id);
	}
}
