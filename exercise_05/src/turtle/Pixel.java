package turtle;

import java.awt.Color;

public class Pixel {
	private Color color;
	private boolean isMarked = false;
	
	public Pixel(){
		this.color = new Color(0xff0000);
	}
		
	public void mark(Color color){
		this.isMarked = true;
		this.color = color;
	}
	
	public boolean isMarked(){
		return this.isMarked;
	}
	
	public Color getColor(){
		return color;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + (isMarked ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pixel other = (Pixel) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (isMarked != other.isMarked)
			return false;
		return true;
	}
}
