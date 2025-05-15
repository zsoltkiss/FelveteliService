package hu.soter.jbe.felveteli;


// A FelveteliService dobhat ilyet, amennyiben az adott szakhoz szukseges kotelezo tantargy nem talahato a parameter listaban
public class KotelezoTargyHianyzikException extends RuntimeException {
    public KotelezoTargyHianyzikException(String message) {
        super(message);
    }
}
