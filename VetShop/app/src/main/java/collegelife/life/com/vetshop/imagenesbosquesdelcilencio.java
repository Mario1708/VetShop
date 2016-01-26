package collegelife.life.com.vetshop;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class imagenesbosquesdelcilencio extends PagerAdapter {

    private int[] imagenesbosques = {R.drawable.ic_abanimal,R.drawable.ic_seprovet,R.drawable.ic_miperroenlaruch,R.mipmap.ic_googlemap};
    private Context contacto;
    private LayoutInflater layoutInflater;

    public imagenesbosquesdelcilencio(Context contacto)
    {
        this.contacto = contacto;
    }

    @Override
    public int getCount() {
        return imagenesbosques.length;
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
        imageView.setImageResource(imagenesbosques[position]);
        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
