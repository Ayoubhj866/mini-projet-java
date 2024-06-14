package injector;

import abonnement.AbonnementServiceImpl;
import interfaces.AbonnementService;
import interfaces.Injector;

public class InjectorImpl implements Injector {

    @Override
    public AbonnementService getAbonnementService() {
        return new AbonnementServiceImpl();
    }

}
