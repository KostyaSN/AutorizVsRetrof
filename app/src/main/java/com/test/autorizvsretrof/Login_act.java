package com.test.autorizvsretrof;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.test.autorizvsretrof.Fragmants.Autorization;
import com.test.autorizvsretrof.Fragmants.Registration;

public class Login_act extends AppCompatActivity {

    android.support.v4.app.FragmentTransaction fragmentTransaction;

    Autorization autorizationFrag = new Autorization();
    Registration registrationFrag = new Registration();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_act);


        //задаем стартовым фрагментом авторизацию
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, autorizationFrag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();





    }
//кнопка перехода от авторизации к регистрации
    public void GoToRegistrButton (View view){
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, registrationFrag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

//кнопка перехода от регистрации к авторизации
    public void GoToAutorizButton (View view){
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, autorizationFrag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }



}


