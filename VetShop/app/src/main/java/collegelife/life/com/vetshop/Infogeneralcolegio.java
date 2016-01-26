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

public class Infogeneralcolegio extends ActionBarActivity implements View.OnClickListener {

    ListViewAdapter adaptadores;
    ImageButton iBmapacolegio;
    CheckBox cBcontacto, cBpys;
    TextView tvcontacto, tvpys;

    String[] titulos = new String[]{
            "DOGGY - HOUSE",
            "INSIGNIA",
            "VILLA MASCOTAS",
            "LUCKY DOG HOTEL",
    };

    String[] subtitulos = new String[]{
            "Todos nuestros planes para los perros incluyen revisión clínica semanal, control de plagas, Colegio; Internado; Semi-internado; Guardería; Día de Spa; Transporte, etc.",
            "Colegio para perros, contamos con profesionales de alto nivel, todo lo que su mascota necesita",
            "Cuidado, hospedaje, servicios de Hotel y Guardería, mayor bienestar y salud física, emocional y juegos, socialización y entrenamiento",
            "Lucky Dogs Guarderia Canina El Mejor Cuidado para Tu Mascota de transporte canino cuenta con una cobertura en Bogotá"
    };

    int[] imagenes = {
            R.drawable.ic_doggyh,
            R.drawable.ic_insignia,
            R.drawable.ic_villam,
            R.drawable.ic_luckydog
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infogeneralcolegio);
        iBmapacolegio = (ImageButton)findViewById(R.id.iBmapacolegio);
        iBmapacolegio.setOnClickListener(this);

        ListView lista = (ListView)findViewById(R.id.lvcolegio);
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
                                Intent ir = new Intent(getApplicationContext(), DoggyH.class);
                                startActivity(ir);
                                Toast.makeText(getApplicationContext(), "Informacion DOGGY HOUSE", Toast.LENGTH_SHORT).show();
                            }
                        });
                        cBpys = (CheckBox) dialoglayout.findViewById(R.id.cBpys);
                        cBpys.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent ir = new Intent(getApplicationContext(), PySdoggy.class);
                                startActivity(ir);
                                Toast.makeText(getApplicationContext(), "Productos y Servicios DOGGY HOUSE", Toast.LENGTH_SHORT).show();
                            }
                        });
                        tvcontacto = (TextView) dialoglayout.findViewById(R.id.tvcontacto);
                        tvcontacto.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent ira = new Intent(getApplicationContext(), DoggyH.class);
                                startActivity(ira);
                                Toast.makeText(getApplicationContext(), "Informacion DOGGY HOUSE", Toast.LENGTH_SHORT).show();
                            }
                        });
                        tvpys = (TextView) dialoglayout.findViewById(R.id.tvpys);
                        tvpys.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent ira = new Intent(getApplicationContext(), PySdoggy.class);
                                startActivity(ira);
                                Toast.makeText(getApplicationContext(), "Productos y Servicios DOGGY HOUSE", Toast.LENGTH_SHORT).show();
                            }
                        });
                        AlertDialog.Builder builder = new AlertDialog.Builder(Infogeneralcolegio.this);
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
            case R.id.iBmapacolegio:
                Intent iraatencion = new Intent(getApplicationContext(),MapaColegios.class);
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