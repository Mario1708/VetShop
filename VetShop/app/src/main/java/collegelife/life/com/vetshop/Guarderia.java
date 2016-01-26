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

public class Guarderia extends ActionBarActivity implements View.OnClickListener {

    ListViewAdapter adaptadores;
    ImageButton iBmapaguarderia;
    CheckBox cBcontacto, cBpys;
    TextView tvcontacto, tvpys;

    String[] titulos = new String[]{
            "CANINO HOUSE",
            "Villa Mascotas",
            "PET LOVERS",
            "MiPerroenlaruch",
    };

    String[] subtitulos = new String[]{
            "Camino Haouse, Hotel- Guardería-Adiestramiento",
            "VILLA MASCOTAS, es un lugar dedicado al cuidado y hospedaje de mascotas.",
            "Centro Canino PET LOVERS - Colegio Canino",
            "En La Ruch su perro contará con bienestar, recreación, seguridad y cariño, bajo el cuidado de expertos."
    };

    int[] imagenes = {
            R.drawable.ic_caninohaouse,
            R.drawable.ic_villamascota,
            R.drawable.ic_petlovers,
            R.drawable.ic_miperroenlaruch
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_guarderia);

        iBmapaguarderia = (ImageButton)findViewById(R.id.iBmapaguarderia);
        iBmapaguarderia.setOnClickListener(this);

        ListView lista = (ListView)findViewById(R.id.lvguarderia);
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
                                Intent ir = new Intent(getApplicationContext(), CaninoHouse.class);
                                startActivity(ir);
                                Toast.makeText(getApplicationContext(), "Informacion Canino House", Toast.LENGTH_SHORT).show();
                            }
                        });
                        cBpys = (CheckBox) dialoglayout.findViewById(R.id.cBpys);
                        cBpys.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent ir = new Intent(getApplicationContext(), PySCaminoH.class);
                                startActivity(ir);
                                Toast.makeText(getApplicationContext(), "Productos y Servicios Canino House", Toast.LENGTH_SHORT).show();
                            }
                        });
                        tvcontacto = (TextView) dialoglayout.findViewById(R.id.tvcontacto);
                        tvcontacto.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent ira = new Intent(getApplicationContext(), CaninoHouse.class);
                                startActivity(ira);
                                Toast.makeText(getApplicationContext(), "Informacion Canino House", Toast.LENGTH_SHORT).show();
                            }
                        });
                        tvpys = (TextView) dialoglayout.findViewById(R.id.tvpys);
                        tvpys.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent ira = new Intent(getApplicationContext(), PySCaminoH.class);
                                startActivity(ira);
                                Toast.makeText(getApplicationContext(), "Productos y Servicios Canino House", Toast.LENGTH_SHORT).show();
                            }
                        });
                        AlertDialog.Builder builder = new AlertDialog.Builder(Guarderia.this);
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
            case R.id.iBmapaguarderia:
                Intent iraatencion = new Intent(getApplicationContext(),Mapaguarderia.class);
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