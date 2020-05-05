package io.github.oliviercailloux.samples.chess;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Comparator;
import java.util.Objects;

import com.google.common.base.MoreObjects;

/**
 * A piece of the game of chess, with its <em>color</em> (<code>W</code> for
 * White and <code>B</code> for Black) and its <em>identifying letter</em>
 * (<code>P</code> for Pawn, <code>R</code> for Rook, <code>B</code> for Bishop,
 * <code>N</code> for kNight, <code>Q</code> for Queen, <code>K</code> for
 * King).
 * </p>
 * <p>
 * (A better design would use {@link Enum}s.)
 * </p>
 * <p>
 * This class must not be modified.
 * </p>
 *
 */
public class Piece {
	private final String color;
	private final String identifyingLetter;

	public static Comparator<Piece> getComparator() {
		return Comparator.comparing(Piece::getColor).thenComparing(Piece::getIdentifyingLetter);
	}

	public static Piece given(String color, String identifyingLetter) {
		return new Piece(color, identifyingLetter);
	}

	public static Piece pawn(String color) {
		return new Piece(color, "P");
	}

	public static Piece rook(String color) {
		return new Piece(color, "R");
	}

	public static Piece bishop(String color) {
		return new Piece(color, "B");
	}

	public static Piece knight(String color) {
		return new Piece(color, "N");
	}

	public static Piece queen(String color) {
		return new Piece(color, "Q");
	}

	public static Piece king(String color) {
		return new Piece(color, "K");
	}

	private Piece(String color, String identifyingLetter) {
		this.color = checkNotNull(color);
		checkArgument(color.equals("W") || color.equals("B"));

		this.identifyingLetter = checkNotNull(identifyingLetter);
		switch (identifyingLetter) {
		case "P":
		case "R":
		case "B":
		case "N":
		case "Q":
		case "K":
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Returns the color of this piece.
	 *
	 * @return one of "W" for a white piece or "B" for a black piece.
	 */
	public String getColor() {
		return color;
	}

	public boolean isWhite() {
		return color.equals("W");
	}

	public boolean isBlack() {
		return color.equals("B");
	}

	/**
	 * Returns the identifying letter of this piece.
	 *
	 * @return one of "P", "R", "B", "N", "Q", "K"
	 */
	public String getIdentifyingLetter() {
		return identifyingLetter;
	}

	/**
	 * Returns <code>true</code> iff the given object is also a {@link Piece} and
	 * has the same identifying color and letter as this one.
	 */
	@Override
	public boolean equals(Object o2) {
		if (!(o2 instanceof Piece)) {
			return false;
		}
		final Piece p2 = (Piece) o2;
		return color.equals(p2.color) && identifyingLetter.equals(p2.identifyingLetter);
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, identifyingLetter);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("Color", color).add("Identifying letter", identifyingLetter)
				.toString();
	}
}
