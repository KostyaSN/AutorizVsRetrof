package com.test.autorizvsretrof;

import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by kostyasnetko on 25.03.16.
 */
public interface Link {

 @Headers({
        "application-id: B95D45A1-ED7C-36F7-FF03-7046ECB17100",
        "secret-key: A535F82B-B4AC-9EB4-FF9D-239AF4D93800"
})
  @POST("/v1/data/Users")
 Call<User> userInfo ();
}
