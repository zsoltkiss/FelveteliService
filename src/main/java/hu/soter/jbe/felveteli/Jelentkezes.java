package hu.soter.jbe.felveteli;

import java.util.*;

public class Jelentkezes {

    private final FelveteliService felveteliService;
    private Map<String, Integer> feleviEredmenyek;

    public Jelentkezes(FelveteliService service) {
        this.felveteliService = service;
        this.feleviEredmenyek = new HashMap<>();
    }

    public Map<String, Integer> getFeleviEredmenyek() {
        return feleviEredmenyek;
    }

    public void setFeleviEredmenyek(Map<String, Integer> feleviEredmenyek) {
        this.feleviEredmenyek = feleviEredmenyek;
    }

    public boolean kovetelmenyEllenorzes(String szak) {
        Set<String> kotelezoTantargyak = new HashSet(felveteliService.getTantargyak(szak));
        Set<String> sajatTantargyak = feleviEredmenyek.keySet();

        return (sajatTantargyak.containsAll(kotelezoTantargyak));
    }

    public boolean jelentkezes(String szak) {
        if (kovetelmenyEllenorzes(szak)) {
            return felveteliService.jelentkezesSzakra(szak, feleviEredmenyek);
        } else {
            return false;
        }
    }



    public static void main(String[] args) {}
}
