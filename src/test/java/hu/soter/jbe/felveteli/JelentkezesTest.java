package hu.soter.jbe.felveteli;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

// TODO: itt valamilyen mockito annotacio kell
public class JelentkezesTest {

    public static final String SZAK1 = "Programozas";
    public static final String SZAK2 = "Kohó mérnök";

    public static String MATEMATIKA = "matematika";
    public static String FIZIKA = "fizika";
    public static String KEMIA = "kémia";
    public static String FOLDRAJZ = "földrajz";
    public static String INFORMATIKA = "informatika";
    public static String ANGOL = "angol";

    public static final List<String> SZAK1_TANTARGYAK = List.of(MATEMATIKA, FIZIKA, INFORMATIKA, ANGOL);
    public static final List<String> SZAK2_TANTARGYAK = List.of(MATEMATIKA, FIZIKA, KEMIA, FOLDRAJZ);

    // TODO: legyen mockolva!!!
    FelveteliService felveteliService;

    private Jelentkezes sut;

    @BeforeEach
    void setUp() {
        sut = new Jelentkezes(felveteliService);
    }

    public static Map<String, Integer> createSzak1Success() {
        Map<String, Integer> joBizonyitvany = new HashMap<>();
        joBizonyitvany.put(MATEMATIKA, 5);
        joBizonyitvany.put(FIZIKA, 4);
        joBizonyitvany.put(INFORMATIKA, 5);
        joBizonyitvany.put(ANGOL, 4);

        return joBizonyitvany;
    }

    public static Map<String, Integer> createSzak1Failure() {
        Map<String, Integer> gyengeBizonyitvany = new HashMap<>();
        gyengeBizonyitvany.put(MATEMATIKA, 4);
        gyengeBizonyitvany.put(FIZIKA, 3);
        gyengeBizonyitvany.put(INFORMATIKA, 3);
        gyengeBizonyitvany.put(ANGOL, 4);

        return gyengeBizonyitvany;
    }

    // TODO: kellenek meg ezek is a fentihez hasonloan: createSzak2Success, createSzak2Failure

    @Test
    public void testSzak1TantargyListaHianyos() {
        // TODO: Mockito.when()
        assertEquals(false, sut.kovetelmenyEllenorzes(SZAK1)) ;
    }

    @Test
    public void testSzak2TantargyListaHianyos() {
        // TODO: Mockito.when()
        assertEquals(false, sut.kovetelmenyEllenorzes(SZAK2)) ;
    }

    @Test
    public void testSzak1FelveteltNyer() {
        sut.setFeleviEredmenyek(createSzak1Success());
        // TODO: Mockito.when() ami a calculate() metodust hivja, es azt adja vissza amit a calculate() kiszamol
        assertEquals(true, sut.jelentkezes(SZAK1));
    }


    @Test
    public void testSzak1NemNyerFelvetelt() {
        sut.setFeleviEredmenyek(createSzak1Failure());
        // TODO: Mockito.when() ami a calculate() metodust hivja, es azt adja vissza amit a calculate() kiszamol
        assertEquals(false, sut.jelentkezes(SZAK1)) ;
    }

    @Test
    public void testSzak2FelveteltNyer() {
        // TODO: sut.setFeleveiEredmenyek()
        // TODO: Mockito.when()
        assertEquals(true, sut.jelentkezes(SZAK2)) ;
    }


    @Test
    public void testSzak2NemNyerFelvetelt() {
        // TODO: sut.setFeleveiEredmenyek()
        // TODO: Mockito.when()
        assertEquals(false, sut.jelentkezes(SZAK2)) ;
    }

    private boolean calculate(Map<String, Integer> eredmenyek, double avgMin) {
        int total = 0;
        for (Integer e : eredmenyek.values()) {
            total += e;
        }

        double avg = (double) total / eredmenyek.size();
        System.out.println("::calculate >> avg: " + avg);
        return avg >= avgMin;
    }
}
