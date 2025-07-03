package assignment03A;

public class Piece implements Cloneable {
	public static final Piece NONE = new Piece(SquareColor.NONE, "--", " ");
	private SquareColor color; 
	private String name; 
	private String code; 
	public Piece(SquareColor colorIn, 
			String nameIn, String codeIn) {
		color = colorIn;
		name = nameIn;
		code = codeIn;
	}
	public SquareColor getColor() {
		return color;
	}
	public String getName() {
		return name;
	}
	public String getCode() {
		return code;
	}
	@Override
	public String toString() {
		return color + name;
	}
	@Override
	protected Piece clone() {		
		try {
			return (Piece)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}			
	}
}
