package app.arsh.tinker.view;

import android.app.Application;
import app.arsh.tinker.dependency.DaggerNetComponent;
import app.arsh.tinker.dependency.NetComponent;
import app.arsh.tinker.dependency.NetModule;

/**
 * Created by arash on 12/1/16.
 */

public class TinkerApp extends Application {

  private NetComponent netComponent;

  @Override public void onCreate() {
    super.onCreate();

    netComponent = DaggerNetComponent
        .builder()
        .netModule(new NetModule())
        .build();

  }

  public NetComponent getNetComponent() {
    return netComponent;
  }

}
