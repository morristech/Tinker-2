package app.arsh.tinker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

  @Inject Retrofit retrofit;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ((TinkerApp) getApplication()).getNetComponent().inject(this);

    retrofit.create(CountryService.class).countryList().enqueue(new Callback<List<Country>>() {
      @Override public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
        Log.v("Tinker_", response.body().toString());
      }

      @Override public void onFailure(Call<List<Country>> call, Throwable t) {
        Log.v("Tinker_", t.getLocalizedMessage());
      }
    });
  }
}
