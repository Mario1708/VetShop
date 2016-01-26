package collegelife.life.com.vetshop;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class imageneslaboratoriocontacto extends PagerAdapter {

    private int[] imagenescontacto = {R.drawable.ic_atencionmedica,R.drawable.ic_laboratorio,R.mipmap.ic_colegio,R.mipmap.ic_googlemap};
    private Context contacto;
    private LayoutInflater layoutInflater;

    public imageneslaboratoriocontacto(Context contacto)
    {
        this.contacto = contacto;
    }

    @Override
    public int getCount() {
        return imagenescontacto.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)contacto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.imageneslaboratorio,container,false);
        ImageView imageView = (ImageView) item_view.findViewById(R.id.iVpara_contactos);
        imageView.setImageResource(imagenescontacto[position]);
        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
