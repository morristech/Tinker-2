package app.arsh.tinker.dependency;

import app.arsh.tinker.presenter.MainActivityPresenter;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by arash on 12/1/16.
 */

@Singleton
@Component(modules = {NetModule.class})
public interface NetComponent {
  void inject(MainActivityPresenter mainActivityPresenter);

}
