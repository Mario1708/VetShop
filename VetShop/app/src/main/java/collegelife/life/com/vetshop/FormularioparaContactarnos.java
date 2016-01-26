package collegelife.life.com.vetshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormularioparaContactarnos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulariopara_contactarnos);

        Button btnSendMail = (Button) findViewById(R.id.btnEnviarMail);
        btnSendMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //final EditText etDe = (EditText) getView().findViewById(R.id.et_EmailDe);
                final EditText etAsunto = (EditText) findViewById(R.id.et_EmailAsunto);
                final EditText etMensaje = (EditText) findViewById(R.id.et_EmailMensaje);

                //String to = etDe.getText().toString();
                String subject = etAsunto.getText().toString();
                String message = etMensaje.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, "marioyanez@lifes.com.co");
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                // need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Seleciona un cliente de correo"));
            }
        });

    }
}