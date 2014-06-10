import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.hippoecm.frontend.Main;

public class MySpringBasedApplication extends Main {

    @Override
    protected void init() {
        super.init();
        getComponentInstantiationListeners().add(new SpringComponentInjector(this));
    }
}
