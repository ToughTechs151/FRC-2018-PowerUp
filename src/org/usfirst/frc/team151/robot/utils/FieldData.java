package org.usfirst.frc.team151.robot.utils;

import edu.wpi.first.wpilibj.DriverStation;

public abstract class FieldData {
	public static String gameData = "";

	public static enum FieldThings {
		SWITCH (0), SCALE (1);
		private final int index;
		FieldThings (int index) {
			this.index = index;	
		}
		private int index() {
			return index;
		}
	}

	public static enum Direction {
		LEFT ('L'), RIGHT ('R');
		private final char direction;
		Direction (char direction) {
			this.direction = direction;	
		}
		private char direction() {
			return direction;
		}
	}

	public static boolean isDataValid() {
		if (gameData.equals("")) {
			gameData = DriverStation.getInstance().getGameSpecificMessage();
			System.out.println(gameData);
		}
		return true; // stub
	}

	/*
	 * Returns a boolean depending on whether the specified field object is in the  
	 * direction given
	 * 
	 * To call this method in another class, import this class and call:
	 * FieldData.checkFieldPosition(FieldThings.SCALE/SWITCH, Direction.LEFT/RIGHT) 
	 */
	public static boolean checkFieldPosition(FieldThings ft, Direction d) {
		isDataValid();
		return gameData.charAt(ft.index()) == d.direction();
	}

}
