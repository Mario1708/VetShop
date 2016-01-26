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

public class BosquedelSilecio extends AppCompatActivity implements View.OnClickListener {

    ViewPager viewPager;
    imagenesbosquesdelcilencio adapter;
    ImageButton iBproducto;
    ImageButton iBllamar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bosquedel_silecio);

        viewPager = (ViewPager) findViewById(R.id.imagenbosque);
        adapter = new imagenesbosquesdelcilencio(this);
        viewPager.setAdapter(adapter);

        iBllamar = (ImageButton) findViewById(R.id.iBllamar);
        iBllamar.setOnClickListener(this);

        iBproducto = (ImageButton)findViewById(R.id.iBproducto);
        iBproducto.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iBllamar:
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:3203268519"));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(intent);
                break;
            case R.id.iBproducto:
                Intent iraproducto = new Intent(getApplicationContext(), PySbosquesilen.class);
                startActivity(iraproducto);
                break;

            default:
        }
    }
}
