package app.arsh.tinker.model.repository.remoteservices;

import app.arsh.tinker.model.entity.Country;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by arash on 12/1/16.
 */

public interface CountryService {

  @GET("all") Call<List<Country>> countryList();
}
