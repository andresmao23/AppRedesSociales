package com.amcaicedo.sena.appredessociales;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class SocialNetworkActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etMensaje;
    FloatingActionButton fabRedesSociales;
    ImageView imgFacebook, imgTwitter, imgGooglePlus, imgInstagram, imgLinkedIn;
    LinearLayout lytRedes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_network);

        lytRedes = (LinearLayout) findViewById(R.id.lytRedes);

        etMensaje = (EditText) findViewById(R.id.etMensaje);

        fabRedesSociales = (FloatingActionButton) findViewById(R.id.fabRedesSociales);
        fabRedesSociales.setOnClickListener(this);

        imgFacebook = (ImageView) findViewById(R.id.imgFacebook);
        imgTwitter = (ImageView) findViewById(R.id.imgTwitter);
        imgGooglePlus = (ImageView) findViewById(R.id.imgGooglePlus);
        imgInstagram = (ImageView) findViewById(R.id.imgInstagram);
        imgLinkedIn = (ImageView) findViewById(R.id.imgLinkedIn);

        imgFacebook.setOnClickListener(this);
        imgTwitter.setOnClickListener(this);
        imgGooglePlus.setOnClickListener(this);
        imgInstagram.setOnClickListener(this);
        imgLinkedIn.setOnClickListener(this);

    }

    //fuente: https://danielme.com/tip-android-12-animar-mostrarocultar-layout-con-desplazamientos/
    private void animar(boolean mostrar) {
        AnimationSet set = new AnimationSet(true);
        Animation animation = null;
        if (mostrar) {
            //desde la esquina inferior derecha a la superior izquierda
            animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        }else  {
            //desde la esquina superior izquierda a la esquina inferior derecha
            animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.0f);
        }
        //duración en milisegundos
        animation.setDuration(500);
        set.addAnimation(animation);
        LayoutAnimationController controller = new LayoutAnimationController(set, 0.25f);

        lytRedes.setLayoutAnimation(controller);
        lytRedes.startAnimation(animation);
    }

    @Override
    public void onClick(View v) {

        /*Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, etMensaje.getText().toString());
        sendIntent.setType("text/plain");*/

        switch (v.getId()){
            case R.id.fabRedesSociales:
                if (lytRedes.getVisibility() == View.INVISIBLE) {
                    animar(true);
                    lytRedes.setVisibility(View.VISIBLE);
                }else{
                    animar(false);
                    lytRedes.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.imgFacebook:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Hola mundo");
                sendIntent.setType("text/plain");
                sendIntent.setPackage("com.facebook.orca");
                startActivity(sendIntent);
                //Toast.makeText(this, "Tocaste facebook", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imgTwitter:
                //sendIntent.setPackage("com.twitter.android");
                break;
            case R.id.imgGooglePlus:
                //sendIntent.setPackage("com.google.android.apps.plus");
                break;
            case R.id.imgInstagram:
                //sendIntent.setPackage("com.instagram.android");
                break;
            case R.id.imgLinkedIn:
                //sendIntent.setPackage("com.linkedin.android");
                break;
        }

    }
}
