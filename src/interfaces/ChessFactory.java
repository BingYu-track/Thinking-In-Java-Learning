package interfaces;

public class ChessFactory implements GameFactory {

    public Game getGame() {
        return new Chess();
    }
}
