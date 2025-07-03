package assignment03B;

import java.util.Map;
import static java.util.Map.entry;

public class Piece {
	public static Map<Character, Character> unicode = Map.ofEntries(entry(' ', ' '),
			entry('P', '\u2659'), entry('R', '\u2656'), entry('N', '\u2658'),
			entry('B', '\u2657'), entry('Q', '\u2655'), entry('K', '\u2654'));
}
