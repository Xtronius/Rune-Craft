package mod.xtronius.rc_mod.lib;

import java.util.HashMap;

public class PlayerSettings {
	
	private HashMap<String, Integer> playerIntSettings = new HashMap<String, Integer>();
	private HashMap<String, Float> playerFloatSettings = new HashMap<String, Float>();
	private HashMap<String, Double> playerDoubleSettings = new HashMap<String, Double>();
	private HashMap<String, Boolean> playerBooleanSettings = new HashMap<String, Boolean>();
	
	public void setPlayerSettingsValues(String name, String type, String value) {
		
		if(type.equalsIgnoreCase("integer") || type.equalsIgnoreCase("int") || type.equalsIgnoreCase("i")) {
			this.playerIntSettings.put(name, Integer.valueOf(value));
		}
		else if(type.equalsIgnoreCase("float") || type.equalsIgnoreCase("f")) {
			this.playerFloatSettings.put(name, Float.valueOf(value));
		}
		else if(type.equalsIgnoreCase("double") || type.equalsIgnoreCase("d")) {
			this.playerDoubleSettings.put(name, Double.valueOf(value));
		}
		else if(type.equalsIgnoreCase("boolean") || type.equalsIgnoreCase("b")) {
			this.playerBooleanSettings.put(name, Boolean.valueOf(value));
		}
	}
	
	public Object getPlayerSettingsValues(String name, String type) {
		
		if(type.equalsIgnoreCase("integer") || type.equalsIgnoreCase("int") || type.equalsIgnoreCase("i")) {
			return this.playerIntSettings.get(name);
		}
		else if(type.equalsIgnoreCase("float") || type.equalsIgnoreCase("f")) {
			return this.playerFloatSettings.get(name);
		}
		else if(type.equalsIgnoreCase("double") || type.equalsIgnoreCase("d")) {
			return this.playerDoubleSettings.get(name);
		}
		else if(type.equalsIgnoreCase("boolean") || type.equalsIgnoreCase("b")) {
			return this.playerBooleanSettings.get(name);
		}
		return null;
	}
}
