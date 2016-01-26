package collegelife.life.com.vetshop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.app.PendingIntent;
import android.app.NotificationManager;


public class Menu_Inicial extends AppCompatActivity implements View.OnClickListener{
    ImageButton iBlaboratorio, iBmapageneral, iBcontactoweb, iBmedicina, iBguarderia, iBmarket, iBfuneraria, iBentretenimiento,
            iBcolegio, iBTransporte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_menu__inicial);

        iBlaboratorio = (ImageButton) findViewById(R.id.iBlaboratorio);
        iBlaboratorio.setOnClickListener(this);

        iBmapageneral =  (ImageButton)findViewById(R.id.iBmapageneral);
        iBmapageneral.setOnClickListener(this);

        iBmedicina = (ImageButton)findViewById(R.id.iBmedicina);
        iBmedicina.setOnClickListener(this);

        iBguarderia = (ImageButton)findViewById(R.id.iBguarderia);
        iBguarderia.setOnClickListener(this);

        iBmarket = (ImageButton)findViewById(R.id.iBmarket);
        iBmarket.setOnClickListener(this);

        iBfuneraria = (ImageButton)findViewById(R.id.iBfuneraria);
        iBfuneraria.setOnClickListener(this);

        iBentretenimiento = (ImageButton)findViewById(R.id.iBentretenimiento);
        iBentretenimiento.setOnClickListener(this);

        iBcolegio = (ImageButton)findViewById(R.id.iBcolegio);
        iBcolegio.setOnClickListener(this);

        iBTransporte = (ImageButton)findViewById(R.id.iBTransporte);
        iBTransporte.setOnClickListener(this);

        iBcontactoweb = (ImageButton) findViewById(R.id.iBcontactoweb);
        iBcontactoweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu_Inicial.this, FormularioparaContactarnos.class);
                startActivity(i);
            }
        });

        iBcontactoweb = (ImageButton) findViewById(R.id.iBcontactoweb);
        iBcontactoweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();

                View dialoglayout = inflater.inflate(R.layout.activity_formulariopara_contactarnos, null);

                final EditText etAsunto = (EditText) dialoglayout.findViewById(R.id.et_EmailAsunto);
                final EditText etMensaje = (EditText) dialoglayout.findViewById(R.id.et_EmailMensaje);

                Button btnEnviarMail = (Button) dialoglayout.findViewById(R.id.btnEnviarMail);
                btnEnviarMail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String subject = etAsunto.getText().toString();
                        String message = etMensaje.getText().toString();

                        Intent email = new Intent(Intent.ACTION_SEND);
                        email.putExtra(Intent.EXTRA_EMAIL, new String[] { "marioyanez@lifes.com.co"});
                        email.putExtra(Intent.EXTRA_SUBJECT, subject);
                        email.putExtra(Intent.EXTRA_TEXT, " mensaje " + message);

                        // need this to prompts email client only
                        email.setType("message/rfc822");
                        startActivity(Intent.createChooser(email, "Seleciona un cliente de correo"));

                    }
                });

                AlertDialog.Builder builder = new AlertDialog.Builder(Menu_Inicial.this);
                builder.setView(dialoglayout);
                builder.show();
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iBlaboratorio:
                startActivity(new Intent(this,InformaciongeneraldeLaboratorios.class));
                Toast.makeText(this, "Informacion Laboratorios", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iBmapageneral:
                Intent mapageneral = new Intent(getApplicationContext(),MapaGeneral.class);
                startActivity(mapageneral);
                break;
            case R.id.iBmedicina:
                Intent atenciomedica = new Intent(getApplicationContext(),Infogeneralatencionmedica.class);
                startActivity(atenciomedica);
                Toast.makeText(this, "Informacion Atención Medica", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iBguarderia:
                Intent guarderia = new Intent(getApplicationContext(),Guarderia.class);
                startActivity(guarderia);
                Toast.makeText(this, "Informacion Guarderia", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iBmarket:
                Intent market = new Intent(getApplicationContext(),Infogeneralmarket.class);
                startActivity(market);
                Toast.makeText(this, "Informacion Market", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iBfuneraria:
                Intent funeraria = new Intent(getApplicationContext(),Infogeneralfuneraria.class);
                startActivity(funeraria);
                Toast.makeText(this, "Informacion Funeraria", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iBentretenimiento:
                Intent entretenimiento = new Intent(getApplicationContext(),Infogeneralentretenimiento.class);
                startActivity(entretenimiento);
                Toast.makeText(this, "Informacion Entretenimiento", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iBcolegio:
                Intent colegio = new Intent(getApplicationContext(),Infogeneralcolegio.class);
                startActivity(colegio);
                Toast.makeText(this, "Informacion Colegios", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iBTransporte:
                Intent transporte = new Intent(getApplicationContext(),Infogeneraltransporte.class);
                startActivity(transporte);
                Toast.makeText(this, "Informacion Transporte", Toast.LENGTH_SHORT).show();
                break;

            default:
        }
    }

    public void notificaciones(View v) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_vetshop);
        builder.setContentTitle("Tienes Información Nueva para Tú Mascota");
        builder.setContentText("Ingresa a VetShop para conocer los nuevos productos y promociones");
        Intent iranoti = new Intent(this,NotificacionesInicio.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(NotificacionesInicio.class);
        stackBuilder.addNextIntent(iranoti);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManager notificar = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificar.notify(0,builder.build());
    }
}