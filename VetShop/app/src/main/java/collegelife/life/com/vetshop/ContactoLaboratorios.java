package collegelife.life.com.vetshop;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class ContactoLaboratorios extends AppCompatActivity implements View.OnClickListener {
    ViewPager viewPager;
    imageneslaboratoriocontacto adapter;
    ImageButton iBmapalabor, iBllamar;
    Intent callIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_contacto_laboratorios);
        viewPager = (ViewPager) findViewById(R.id.imagencontacto);
        adapter = new imageneslaboratoriocontacto(this);
        viewPager.setAdapter(adapter);

        iBllamar = (ImageButton) findViewById(R.id.iBllamar);
        iBllamar.setOnClickListener(this);

        iBmapalabor = (ImageButton) findViewById(R.id.iBmapalabor);
        iBmapalabor.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iBmapalabor:
                Intent ir = new Intent(getApplicationContext(), MapaAtencionMedica.class);
                startActivity(ir);
                break;
            case R.id.iBllamar:
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:3137257275"));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(intent);
                break;
            default:
        }
    }


}