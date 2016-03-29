package com.test.autorizvsretrof.Fragmants;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.test.autorizvsretrof.MainActivity;
import com.test.autorizvsretrof.R;
/*
Авторизация
 */
public class Autorization extends android.support.v4.app.Fragment{

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.autorization, container, false);


        Button EnterButt = (Button) view.findViewById(R.id.button);
        EnterButt.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {

                boolean isNetworkOnlineNow = isNetworkOnline(getActivity());
                if(isNetworkOnlineNow)//проверяем соединение с интернетом
                {
                    startActivity(new Intent(getActivity(), MainActivity.class));
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
