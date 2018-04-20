package com.londeroapps.appqrcode;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.ViewfinderView;

public class MainActivity extends AppCompatActivity {

    private Button scan_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Excluindo ActionBar
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        scan_btn = (Button) findViewById(R.id.scan_btn);
        final Activity activity = this;

        scan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null){
            if(result.getContents() == null){
                Toast.makeText(this, "Nenhum QRCode Detectado!", Toast.LENGTH_LONG).show();
            } else {
                try {
                    Dados dados = new Dados();
                    String qrcode = result.getContents();
                    Vidraria dado = dados.searchQRCode(qrcode);

                    Intent intent = new Intent(this, ActivityVidraria.class);
                    Bundle parametros = new Bundle();

                    parametros.putString("hash",dado.getCodHash());
                    parametros.putString("name",dado.getNameVidraria());
                    parametros.putString("desc",dado.getDescVidraria());

                    intent.putExtras(parametros);
                    startActivity(intent);
                } catch (Exception e){
                    Toast.makeText(this, R.string.material_nao_encontrado, Toast.LENGTH_LONG).show();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}
