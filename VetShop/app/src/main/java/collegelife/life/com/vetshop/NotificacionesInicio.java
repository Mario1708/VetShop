package collegelife.life.com.vetshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class NotificacionesInicio extends AppCompatActivity implements View.OnClickListener {

    Button Bcerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaciones_inicio);

        Bcerrar = (Button)findViewById(R.id.Bcerrar);
        Bcerrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Bcerrar:
                Intent ira = new Intent(getApplicationContext(),Menu_Inicial.class);
                startActivity(ira);
                break;
            default:
        }
    }
}
