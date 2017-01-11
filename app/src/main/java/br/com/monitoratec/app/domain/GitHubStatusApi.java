package br.com.monitoratec.app.domain;

import com.google.gson.GsonBuilder;

import br.com.monitoratec.app.domain.entity.Status;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Interface da API GitHub Status.
 * <p>
 * Created by falvojr on 1/9/17.
 */
public interface GitHubStatusApi {

    String BASE_URL = "https://status.github.com/api/";

    Retrofit RETROFIT = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(
                    new GsonBuilder()
                            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
                            .create()))
            .baseUrl(BASE_URL)
            .build();

    @GET("last-message.json")
    Call<Status> lastMessage();
}
