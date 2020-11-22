package edu.sjsu.cmpe275.lab2.dao;
import edu.sjsu.cmpe275.lab2.exception.PlayerNotFoundException;
import edu.sjsu.cmpe275.lab2.model.Opponent;

public interface OpponentDao {

	public String deleteOpponent(Long id1, Long id2) ;

	public String addOpponent(Long id1, Long id2) ;

}
