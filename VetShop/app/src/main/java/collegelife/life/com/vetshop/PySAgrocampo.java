package collegelife.life.com.vetshop;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class PySAgrocampo extends ActionBarActivity {

    ListViewAdapter adaptadores;

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
        setContentView(R.layout.activity_py_sagrocampo);
        ListView lista = (ListView)findViewById(R.id.lvpys);
        adaptadores = new ListViewAdapter(this,titulos, subtitulos, imagenes);
        lista.setAdapter(adaptadores);
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
