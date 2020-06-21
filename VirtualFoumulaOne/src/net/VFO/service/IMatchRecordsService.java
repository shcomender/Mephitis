package net.VFO.service;

import java.util.List;

import net.VFO.bean.MatchRecords;
import net.VFO.exceptions.MacthRecordsException;

public interface IMatchRecordsService {
	List<MatchRecords> queryByTname(String tname,String status) throws MacthRecordsException;

	boolean delet(String mid, String shortname) throws MacthRecordsException;

	
}
