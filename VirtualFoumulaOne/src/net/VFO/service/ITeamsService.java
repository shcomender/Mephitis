package net.VFO.service;

import net.VFO.bean.Teams;
import net.VFO.exceptions.TeamsException;

public interface ITeamsService {
	Teams query(String teamname) throws TeamsException;
	boolean modify(Teams team) throws TeamsException;
}
