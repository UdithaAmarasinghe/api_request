package dagger.test.dagger.dagger.component;

import javax.inject.Singleton;

import dagger.Component;
import dagger.test.dagger.dagger.module.AppModule;
import dagger.test.dagger.dagger.module.ContextModule;
import dagger.test.dagger.dagger.module.NetModule;
import dagger.test.dagger.view.activites.BaseActivity;

/**
 * Created by Admin on 4/29/2018.
 */

@Singleton
@Component(modules = {AppModule.class, ContextModule.class, NetModule.class})
public interface NetComponent {
    void inject(BaseActivity activity);
}
