package com.zilker.constant;

public class Constants {
	public static final String DB_URL = "jdbc:mysql://localhost/tournament";
	// Database credentials
	public static final String USER = "root";
	public static final String PASS = "Ztech@123";
	public static final String PATH = "com.mysql.jdbc.Driver";
	public static final String INS = "insert into matches (tourid,play1id,play2id,winner,loser,status,score) values(?,?,?,?,?,?,?)";
	public static final String RET = "select player_name,country,origpoints,newpoints,numbermatch,won,lost,draw"
			+ " from player order by newpoints desc";
	public static final String RETMATCH = "select tourid,play1id,play2id,winner,loser,status,score from matches";
	public static final String UPDATEPOINT = "update player set newpoints=newpoints+1000 where playerid=?";
	public static final String UPDATEMATCH = "update player set numbermatch=numbermatch+1 where playerid=?";
	public static final String UPDATEWIN = "update player set won=won+1 where playerid=?";
	public static final String UPDATELOSS = "update player set lost=lost+1 where playerid=?";
	public static final String RETSORT = "select player_name,country,origpoints,newpoints,numbermatch,won,lost,draw from player ";
	public static final String UPDATEPOINTSUS = "update player set newpoints=newpoints+500 where playerid=?";

	public static final String UPDATEDRAW = "update player set draw=draw+1 where playerid=?";
	public static final String FINDMATCH = "select tourid,play1id,play2id,winner,loser,status,score from matches where play1id=? or play2id=?";
	public static final String FINDRESULT = "select tourid,play1id,play2id,winner,loser,status,score from matches where (play1id=? and play2id=?) "
			+ "or (play1id=? and play2id=?)";
	public static final String FINDNAME = "select player_name from player where playerid=?";
	public static final String FINDPLAYER = "select playerid from player where player_name=?";
	public static final String FINDTOURNAMENT = "select tourname from tour where tourid=?";
	public static final String FINDTOURNAMENTID = "select tourid from tour where tourname=?";
	public static final String FINDPLAYERTOURNAMENT = "select tourid,play1id,play2id,winner,loser,status,score from matches where (play1id=? or play2id=?) and tourid=?";
	public static final String MOSTIMPROVEDPLAYER = "select * from player where "
			+ "(newpoints-origpoints)=(select max(newpoints-origpoints) from player);";
	public static final String ADMIN = "admin";
	public static final String PASSWORD = "1234";
	public static final String RETRIEVEUSER ="select * from userdetails";
	public static final String RETRIEVECOUNTRY ="select country from player where playerid=?";
}
