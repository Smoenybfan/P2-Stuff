package turtle;

import java.awt.Color;

public class ColorCommand extends SimpleCommand {

	private static final int[] EXPECTED_VARIABLES_COUNT = new int[]{1,3};
	private static final int ARG_HEX_INDEX = 0;
	private static final int ARG_RED_INDEX = 0;
	private static final int ARG_GREEN_INDEX = 1;
	private static final int ARG_BLUE_INDEX = 2;
	
	public ColorCommand(Token token) {
		super(EXPECTED_VARIABLES_COUNT, token);
	}

	@Override
	public void execute(Turtle turtle) {
		int color = 0;
		if (this.getArgCount() == 1){
			color = decodeHex(getArgument(ARG_HEX_INDEX));
		}
		else {
			color = decodeRGB(getInt(ARG_RED_INDEX), getInt(ARG_GREEN_INDEX), getInt(ARG_BLUE_INDEX));
		}
		
		turtle.setColor(new Color(color));
	}
	
	private static int decodeHex(String hex){
		long hexLong = 0;
		try {
			hexLong = Long.parseLong(hex, 16);
		} catch (NumberFormatException e){
			throw new ProgramSyntaxException("color command: unable to parse hex color");
		}
		
		if (hexLong < 0x000000 || hexLong > 0xFFFFFF)
			throw new ProgramSyntaxException("color command: hex color must be in interval [000000,ffffff]");
		return (int)hexLong;
	}
	
	private static int decodeRGB(int red,int green,int blue) {
		if (red < 0 || red > 255)
			throw new ProgramSyntaxException("color command: red component must be in [0,255]");
		if (green < 0 || green > 255)
			throw new ProgramSyntaxException("color command: green component must be in [0,255]");
		
		if (blue < 0 || blue > 255)
			throw new ProgramSyntaxException("color command: blue component must be in [0,255]");
		
		int rgb = red;
		rgb = (rgb << 8) + green;
		rgb = (rgb << 8) + blue;
		return rgb;
	}
}
