package com.londeroapps.appqrcode;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityVidraria extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vidraria);

        // Excluindo ActionBar
        getSupportActionBar().hide();
        setContentView(R.layout.activity_vidraria);

        Bundle parametros = getIntent().getExtras();

        String imageHash = "@drawable/"+parametros.getString("hash");
        int imageResource = getResources().getIdentifier(imageHash, null, getPackageName());
        Drawable res = ContextCompat.getDrawable(getApplicationContext(), imageResource);
        ImageView imageView = (ImageView)findViewById(R.id.imgVidraria);
        imageView.setImageDrawable(res);

        TextView titleVidraria = (TextView) findViewById(R.id.titleVidraria);
        titleVidraria.setText(parametros.getString("name"));
    }

    public void voltarMain(View v){
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
