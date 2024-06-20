package interfaces;

import magasin.Magasin;
import personne.Client;

public interface AbonnementService {

    // laison entre les object client et magasin
    void abonner(Client client, Magasin magasin);

}
