package collegelife.life.com.vetshop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Infogeneralatencionmedica extends ActionBarActivity implements View.OnClickListener {

    ListViewAdapter adaptadores;
    ImageButton iBmapaatencionmedica;
    CheckBox cBcontacto, cBpys;
    TextView tvcontacto, tvpys;

    String[] titulos = new String[]{
            "Salud Animal",
            "CAT-DOG",
            "Abanimal",
            "Animal Care Center",
    };

    String[] subtitulos = new String[]{
            "Clinica Veterinaria Salud Animal",
            "Clínica veterinaria,alimentos concentrados,droguería, baño, peluquería y grooming, Snack y postres, accesorios y diversión, todas las marcas de arenas para gatos.",
            "Imágenes Diagnosticas Radiología Digital Ecografía Convencional Doppler Color y Espectral Intervencionismo Ecografico Urgencias 24 Horas Servicio de Transporte",
            "Consulta Urgencia 24 Horas-Rayos X-Ecografía-Cirugía-Laboratorio-Hospitalización-Peluquería-Esterilización Gratis Estratos 1-2-3 Usaquén-Ambulancia"
    };

    int[] imagenes = {
            R.drawable.ic_saludanimal,
            R.drawable.ic_cat_dog,
            R.drawable.ic_abanimal,
            R.drawable.ic_seprovet
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infogeneralatencionmedica);

        iBmapaatencionmedica = (ImageButton)findViewById(R.id.iBmapaatencionmedica);
        iBmapaatencionmedica.setOnClickListener(this);

        ListView lista = (ListView)findViewById(R.id.lvatenciomedica);
        adaptadores = new ListViewAdapter(this,titulos, subtitulos, imagenes);
        lista.setAdapter(adaptadores);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position) {
                    case 0:
                        LayoutInflater inflater = getLayoutInflater();

                        View dialoglayout = inflater.inflate(R.layout.content_formulario_selecion, null);

                        cBcontacto = (CheckBox) dialoglayout.findViewById(R.id.cBcontacto);
                        cBcontacto.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent ir = new Intent(getApplicationContext(), SaludAnimal.class);
                                startActivity(ir);
                                Toast.makeText(getApplicationContext(), "Informacion Salud Animal", Toast.LENGTH_SHORT).show();
                            }
                        });

                        cBpys = (CheckBox) dialoglayout.findViewById(R.id.cBpys);
                        cBpys.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent ir = new Intent(getApplicationContext(), PySsanimal.class);
                                startActivity(ir);
                                Toast.makeText(getApplicationContext(), "Productos y Servicios Salud Animal", Toast.LENGTH_SHORT).show();
                            }
                        });
                        tvcontacto = (TextView) dialoglayout.findViewById(R.id.tvcontacto);
                        tvcontacto.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent ira = new Intent(getApplicationContext(), SaludAnimal.class);
                                startActivity(ira);
                                Toast.makeText(getApplicationContext(), "Informacion Salud Animal", Toast.LENGTH_SHORT).show();
                            }
                        });
                        tvpys = (TextView) dialoglayout.findViewById(R.id.tvpys);
                        tvpys.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent ira = new Intent(getApplicationContext(), PySsanimal.class);
                                startActivity(ira);
                                Toast.makeText(getApplicationContext(), "Productos y Servicios Salud Animal", Toast.LENGTH_SHORT).show();
                            }
                        });
                        AlertDialog.Builder builder = new AlertDialog.Builder(Infogeneralatencionmedica.this);
                        builder.setView(dialoglayout);
                        builder.show();

                        break;
                    case 1:
                        Intent ira = new Intent(getApplicationContext(), Menu_Inicial.class);
                        startActivity(ira);
                        break;
                    default:
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iBmapaatencionmedica:
                Intent iraatencion = new Intent(getApplicationContext(),MapaAtencionMedica.class);
                startActivity(iraatencion);
                break;
        }
    }

    public class ListViewAdapter extends BaseAdapter {
        // Declare Variables
        Context context;
        String[] titulos;
        String[] subtitulos;
        int[] imagenes;
        LayoutInflater inflater;

        public ListViewAdapter(Context context, String[] titulos, String[] subtitulos, int[] imagenes) {
            this.context = context;
            this.titulos = titulos;
            this.subtitulos = subtitulos;
            this.imagenes = imagenes;
        }

        @Override
        public int getCount() {
            return titulos.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            // Declare Variables
            TextView txtTitle;
            TextView txtSubtitule;
            ImageView imgImg;

            //http://developer.android.com/intl/es/reference/android/view/LayoutInflater.html
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View itemView = inflater.inflate(R.layout.list_laboratorios_row, parent, false);

            // Locate the TextViews in listview_item.xml
            txtTitle = (TextView) itemView.findViewById(R.id.tv_agro_title);
            txtSubtitule = (TextView) itemView.findViewById(R.id.tv_agro_conten);
            imgImg = (ImageView) itemView.findViewById(R.id.iv_laboratorio_image);
            
            // Capture position and set to the TextViews
            txtTitle.setText(titulos[position]);
            txtSubtitule.setText(subtitulos[position]);
            imgImg.setImageResource(imagenes[position]);

            return itemView;
        }
    }
}