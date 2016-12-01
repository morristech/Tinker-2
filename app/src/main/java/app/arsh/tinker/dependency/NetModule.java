package app.arsh.tinker.dependency;

import app.arsh.tinker.model.entity.Country;
import app.arsh.tinker.model.repository.remoteservices.CountryService;
import dagger.Module;
import dagger.Provides;
import java.util.List;
import javax.inject.Singleton;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by arash on 12/1/16.
 */

@Module
public class NetModule {

  public static final String COUNTRY_SERVICE_BASE_URLL = "https://restcountries.eu/rest/v1/";

  @Provides
  @Singleton
  Retrofit provideRetrofit() {

    return new Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(COUNTRY_SERVICE_BASE_URLL)
        .build();
  }

  @Provides
  Call<List<Country>> prodiveCountryList(Retrofit retrofit) {
    return retrofit
        .create(CountryService.class)
        .countryList();
  }
}
