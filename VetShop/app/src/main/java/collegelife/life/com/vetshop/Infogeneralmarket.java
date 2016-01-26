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

public class Infogeneralmarket extends ActionBarActivity implements View.OnClickListener {

    ListViewAdapter adaptadores;
    ImageButton iBmapamarket;
    CheckBox cBcontacto, cBpys;
    TextView tvcontacto, tvpys;


    String[] titulos = new String[]{
            "CEBA",
            "VECOL",
            "VIRBAC",
            "ANIMALS",
    };

    String[] subtitulos = new String[]{
            "Distribuido productos veterinarios (medicamentos veterinarios, vacunas, concentrados, alimentos, semillas, instrumentos agropecuarios)",
            "Lejos está el año de 1950 cuando las autoridades y  la gran mayoría de los colombianos desconocían que la fiebre aftosa estaba empezando a minar los incipientes rebaños bovinos del país",
            "En Virbac, creemos que la libertad de expresión, autonomía y responsabilidad son esenciales para el desarrollo personal de cada individuo y para nuestro éxito",
            "ANIMAL´S cuenta con el servicio de grooming-peluqueria canina y felina siempre enfocado a realzar la belleza de la mascota, guiándonos por los estándares mundiales de cada una de las razas"
    };

    int[] imagenes = {
            R.drawable.ic_ceba,
            R.drawable.ic_vecol,
            R.drawable.ic_virbac,
            R.drawable.ic_animals
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_infogeneralmarket);
        iBmapamarket = (ImageButton)findViewById(R.id.iBmapamarket);
        iBmapamarket.setOnClickListener(this);

        ListView lista = (ListView)findViewById(R.id.lvmarket);
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
                                Intent ir = new Intent(getApplicationContext(), Ceba.class);
                                startActivity(ir);
                                Toast.makeText(getApplicationContext(), "Informacion Ceba", Toast.LENGTH_SHORT).show();
                            }
                        });
                        cBpys = (CheckBox) dialoglayout.findViewById(R.id.cBpys);
                        cBpys.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent ir = new Intent(getApplicationContext(), PySCeba.class);
                                startActivity(ir);
                                Toast.makeText(getApplicationContext(), "Productos y Servicios Ceba", Toast.LENGTH_SHORT).show();
                            }
                        });
                        tvcontacto = (TextView) dialoglayout.findViewById(R.id.tvcontacto);
                        tvcontacto.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent ira = new Intent(getApplicationContext(), Ceba.class);
                                startActivity(ira);
                                Toast.makeText(getApplicationContext(), "Informacion Ceba", Toast.LENGTH_SHORT).show();
                            }
                        });
                        tvpys = (TextView) dialoglayout.findViewById(R.id.tvpys);
                        tvpys.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent ira = new Intent(getApplicationContext(), PySCeba.class);
                                startActivity(ira);
                                Toast.makeText(getApplicationContext(), "Productos y Servicios Ceba", Toast.LENGTH_SHORT).show();
                            }
                        });
                        AlertDialog.Builder builder = new AlertDialog.Builder(Infogeneralmarket.this);
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
            case R.id.iBmapamarket:
                Intent iraatencion = new Intent(getApplicationContext(),MapaMarket.class);
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