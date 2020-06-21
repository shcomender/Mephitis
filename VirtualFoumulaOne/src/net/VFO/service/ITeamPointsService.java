package net.VFO.service;

import java.util.List;

import net.VFO.bean.TeamPoints;
import net.VFO.bean.TeamPointsPageBean;
import net.VFO.exceptions.TeamPointsException;

public interface ITeamPointsService{

	TeamPointsPageBean queryall(Integer page,Integer size) throws TeamPointsException;
}
