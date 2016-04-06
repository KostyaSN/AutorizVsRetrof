package com.test.autorizvsretrof.Fragmants;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.test.autorizvsretrof.R;

public class PassRes extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.passres, container, false);


        Button button = (Button) view.findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //отправяем запрос на сервер и ждем пока человек получит электронное письмо по восстановлению пароля


                //здесь запрос





            }
        });










        return view;
    }
}
