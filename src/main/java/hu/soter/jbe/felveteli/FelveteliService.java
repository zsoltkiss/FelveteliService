package hu.soter.jbe.felveteli;

import java.util.List;
import java.util.Map;

public interface FelveteliService {

    // Visszaadja egy adott szakra torteno felvetelihez szukseges tantargyak listajat
    public List<String> getTantargyak(String szak);

    // Visszaadja, hogy az intezmeny sajat belso szamitasai alapjan az adott szakra a megadott eredmenyekkel felvetelt nyert-e a jelentkezo
    public boolean jelentkezesSzakra(String szak, Map<String, Integer> eredmenyek) throws KotelezoTargyHianyzikException;
}
