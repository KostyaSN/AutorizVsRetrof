package com.test.autorizvsretrof;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by kostyasnetko on 25.03.16.
 */
public interface Link {
 @Headers({
        "application-id: B95D45A1-ED7C-36F7-FF03-7046ECB17100",
        "secret-key: 1624FBDA-39AE-FB03-FF8F-D03F7E507A00"
})
  @GET("v1/data/UserReg")
 Call<UserBase> userInfo ();
}
