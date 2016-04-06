package com.test.autorizvsretrof.Fragmants;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.test.autorizvsretrof.Link;
import com.test.autorizvsretrof.R;
import com.test.autorizvsretrof.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
Регистрация
 */

public class Registration extends android.support.v4.app.Fragment {
    public static final String URL ="https://api.backendless.com/";


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.registration, container, false);

        final EditText editTextPas1 = (EditText) view.findViewById(R.id.editText4);
        final EditText editTextPas2 = (EditText) view.findViewById(R.id.editText5);
        final EditText editTextName = (EditText) view.findViewById(R.id.editText5);
        final EditText editTextEm = (EditText) view.findViewById(R.id.editText5);



        Button buttonReg =(Button) view.findViewById(R.id.button3);
        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String Pass1  = editTextPas1.getText().toString();
               String Pass2 =  editTextPas2.getText().toString();
               String Email = editTextEm.getText().toString();
               String Name = editTextName.getText().toString();

                Log.d("registration",Pass1+" "+Email+" "+Name);

                boolean isNetworkOnline = isNetworkOnline(getActivity());

                if (isNetworkOnline) //проверяем соединение с интернетом
                {
                    if (Pass1.equals(Pass2)) {

                        User user=new User();
                        user.setName(Name);
                        user.setPassword(Pass1);
                        user.setEmail(Email);


                        Retrofit retrofit = new Retrofit.Builder()
                                .addConverterFactory(GsonConverterFactory.create())
                                .baseUrl(URL)
                                .build();

                        Link registrL = retrofit.create(Link.class);
                        Call<User> call = registrL.userInfo();
                        call.enqueue(new Callback<User>() {
                            @Override
                            public void onResponse(Call<User> call, Response<User> response) {

                            }

                            @Override
                            public void onFailure(Call<User> call, Throwable t) {

                            }
                        });


                    } else {
                        //при не совпадении данных введенных пользователем в полях для пароля выводим сообщение об этом
                        Toast.makeText(getContext(), "Введенные пароли не совпадают", Toast.LENGTH_SHORT).show();
                    }

                }else {

                    Toast.makeText(getContext(),"Проверьте соединение с интернетом",Toast.LENGTH_SHORT).show();
                }
            }
        });






        return view;
    }

    //проверяем соединение с интернетом
    public boolean isNetworkOnline(Context context) {
        boolean status = false;
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getNetworkInfo(0);
            if (netInfo != null && netInfo.getState() == NetworkInfo.State.CONNECTED) {
                status = true;
            } else {
                netInfo = cm.getNetworkInfo(1);
                if (netInfo != null && netInfo.getState() == NetworkInfo.State.CONNECTED)
                    status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return status;

    }



}
