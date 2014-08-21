package mod.xtronius.rc_mod.lib;

import java.util.HashMap;

public class LogInfo {

	
	public HashMap<Integer, Integer> logLvlReq = new HashMap<Integer, Integer>();
	public HashMap<Integer, Double> logExp = new HashMap<Integer, Double>();
	
	public LogInfo() {
		
		logLvlReq.put(0, 1);//Wood
		logLvlReq.put(1, 60);//Yew
		logLvlReq.put(2, 15);//Oak
		logLvlReq.put(3, 35);//Teak
		logLvlReq.put(4, 30);//Willow
		logLvlReq.put(5, 45);//Maple
		logLvlReq.put(6, 50);//Mahogany
		logLvlReq.put(7, 75);//Magic
		
		logExp.put(0, 40D);
		logExp.put(1, 202.5D);
		logExp.put(2, 60D);
		logExp.put(3, 105D);
		logExp.put(4, 67.5D);
		logExp.put(5, 135D);
		logExp.put(6, 157.5D);
		logExp.put(7, 250D);
	}
}
