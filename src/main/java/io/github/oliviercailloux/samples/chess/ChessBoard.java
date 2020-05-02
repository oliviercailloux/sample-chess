package io.github.oliviercailloux.samples.chess;

import java.util.List;
import java.util.Optional;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

/**
 * <p>
 * A chess board that represents the 64 squares of a (real) chess board, each
 * one containing a chess {@link Piece} or nothing.
 * </p>
 * <p>
 * This class accepts only legal boards: a board is legal if, and only if, it
 * contains exactly one white King and one black King. It rejects all
 * <code>null</code> arguments (and all arguments that are not legal according
 * to the respective contracts).
 * </p>
 * <p>
 * Uses
 * <a href="https://en.wikipedia.org/wiki/Algebraic_notation_(chess)">Algebraic
 * notation</a>: the bottom left square is referred to as "a1", the bottom right
 * square is "h1", the top left square is "a8"…
 * </p>
 * <p>
 * Hint for implementors: it seems wise to store a
 * <code>Map&lt;String, Piece></code> internally.
 * </p>
 * <p>
 * Initially (for simplicity), a board has just two pieces: a White King on
 * square e1 and a Black King on square e8.
 * </p>
 */
public interface ChessBoard {
	/**
	 * Note for implementors: it is very important to implement this method
	 * correctly. Otherwise, most of the other methods will not work!
	 *
	 * @param inputBoard a list of 64 entries, one for each square on a chess board,
	 *                   indicating, for each square, whether there is a
	 *                   {@link Piece} on that square, and if so, which piece. Each
	 *                   entry in this list consists of the empty string if there is
	 *                   no piece at the corresponding square, or two capital
	 *                   letters, corresponding to the color of a piece followed by
	 *                   its identification letter. The first entry in this list
	 *                   corresponds to the square "a1", the second one to "b1", …,
	 *                   the eighth one to "h1", the ninth one to "a2", and so on
	 *                   until "h8".
	 * @return <code>true</code> iff this board has changed as a result of this
	 *         call.
	 */
	public boolean setBoardByString(List<String> inputBoard);

	/**
	 * TODO
	 */
	public boolean setBoardByPieces(List<Optional<Piece>> inputBoard);

	/**
	 * Returns a map that has positions as keys and two letters representing pieces
	 * as values. A position key is in the map if, and only if, there is a piece at
	 * that position. A value is a two letter string, the first of which is a color,
	 * the second of which is an identification letter of a piece.
	 *
	 * @see Piece
	 */
	public ImmutableMap<String, String> getStringPiecesByPosition();

	/**
	 * Returns a map that has positions as keys and pieces as values. A position key
	 * is in the map if, and only if, there is a piece at that position.
	 */
	public ImmutableMap<String, Piece> getPiecesByPosition();

	/**
	 * Returns an optional containing the piece at the given position, or an empty
	 * optional if there is no piece at the given position in this board.
	 *
	 * @param position any position from <code>"a1"</code> to <code>"h8"</code>
	 */
	public Optional<Piece> getPieceByPosition(String position);

	/**
	 * Returns the set of pieces on this board of the given color. (Note that this
	 * method does not permit to distinguish, for example, the white player having
	 * two rooks or having only one.)
	 *
	 * @param color the string "B" or "W"
	 */
	public ImmutableSet<Piece> getPieces(String color);

	/**
	 * Returns the list of pieces on this board of the given color, ordered
	 * alphabetically by their identifying letter.
	 *
	 * @param color the string "B" or "W"
	 */
	public ImmutableList<Piece> getOrderedPieces(String color);

	/**
	 * <p>
	 * Changes this board so that the given piece moves to its new position. If
	 * another piece is at the new position, that other piece disappears from the
	 * board as a result.
	 * </p>
	 * <p>
	 * This class does not check that this is a legal move by the rules of the game,
	 * but this class does check, as usual, that the positions are syntactically
	 * valid (for example, it rejects the string "aaabbb" as one of the arguments)
	 * and that there is indeed a piece at the old position.
	 * </p>
	 * <p>
	 * Note for implementors: this method will count for only a few points,
	 * implement it only if you have enough time. But make sure your code compiles
	 * even if you do not implement it!
	 * </p>
	 *
	 * @param oldPosition the position the piece moves from, any position from
	 *                    <code>"a1"</code> to <code>"h8"</code> containing a piece
	 * @param newPosition the new position that piece is going to, any position from
	 *                    <code>"a1"</code> to <code>"h8"</code>
	 */
	public void movePiece(String oldPosition, String newPosition);
}
