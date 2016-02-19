package gem.androidtraining3.enterprisenetwork.api;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import gem.androidtraining3.enterprisenetwork.model.ResponseUserInfo;
import gem.androidtraining3.enterprisenetwork.model.UserInfo;
import gem.androidtraining3.enterprisenetwork.util.Util;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by huylv on 19/02/2016.
 */
public class RestClient {
    static UserAPI userAPI;

    public static UserAPI getClient() {
        if (userAPI == null) {

            OkHttpClient okClient = new OkHttpClient.Builder().readTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Response response = chain.proceed(chain.request());
                    return response;
                }
            }).build();

            Retrofit client = new Retrofit.Builder()
                    .baseUrl(Util.ServerURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            userAPI = client.create(UserAPI.class);
        }
        return userAPI;
    }

    public interface UserAPI {
        @Headers("Content-Type:application/json")
        @POST("/login")
        Call<ResponseUserInfo> login(@Body UserInfo user);


//        @GET("/logout")
//        Call<ResponseUserInfo> logout(@Header(Constant.STRING_ACCESS_TOKEN) String access_token);

    }
}
