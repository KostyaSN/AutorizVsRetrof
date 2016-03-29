package com.test.autorizvsretrof.Fragmants;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.test.autorizvsretrof.R;
/*
Регистрация
 */
public class Registration extends android.support.v4.app.Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.registration, container, false);

        final EditText editTextEm1 = (EditText) view.findViewById(R.id.editText4);
        final EditText editTextEm2 = (EditText) view.findViewById(R.id.editText5);




        Button buttonReg =(Button) view.findViewById(R.id.button3);
        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isNetworkOnline = isNetworkOnline(getActivity());

                if (isNetworkOnline) //проверяем соединение с интернетом
                {
                    if (editTextEm1.equals(editTextEm2)) {


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
