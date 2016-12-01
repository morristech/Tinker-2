package app.arsh.tinker.presenter;

import android.app.Application;
import android.util.Log;
import app.arsh.tinker.model.entity.Country;
import app.arsh.tinker.view.TinkerApp;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by arash on 12/1/16.
 */

public class MainActivityPresenter {

  @Inject Call<List<Country>> countryList;

  public MainActivityPresenter(Application application) {
    ((TinkerApp) application).getNetComponent().inject(this);

    makeAPICall();
  }

  private void makeAPICall() {
    countryList.enqueue(new Callback<List<Country>>() {
      @Override public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
        Log.v("Tinker_", response.body().toString());
      }

      @Override public void onFailure(Call<List<Country>> call, Throwable t) {
        Log.v("Tinker_", t.getLocalizedMessage());
      }
    });
  }
}
