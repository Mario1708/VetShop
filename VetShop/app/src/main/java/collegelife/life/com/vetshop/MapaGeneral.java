package collegelife.life.com.vetshop;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaGeneral extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMyLocationChangeListener, GoogleMap.OnInfoWindowClickListener {

    private GoogleMap mMap, mubicacion, magrocamp,manimal,mpetcol,mseprovet,msaludanimal,mcatdog, mabanimal, manimalcare,
        mcaminohaouse, mvillamascotas, mpetlovers, mmiperroenlaruch, mceba, mvecol, mvibrac, manimals, mbosquesdelsilecio,
        mmascompaz, mcaminoalcielo, mfuneravet, mpetshome, mmirefugio, mciudaddemascotas, mpandgo, mdoggyh, minsignia, mvillam,
        mluckyd, mcanitaxi, mushiip, mzootaxi,maviomar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_mapa_general);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap; mubicacion = googleMap;magrocamp = googleMap;manimal = googleMap;mpetcol = googleMap;mseprovet = googleMap;
        msaludanimal = googleMap;mcatdog = googleMap;mabanimal = googleMap;manimalcare = googleMap;mcaminohaouse = googleMap;
        mvillamascotas = googleMap;mpetlovers = googleMap;mmiperroenlaruch = googleMap;mceba = googleMap;mvecol = googleMap;
        mvibrac = googleMap; manimals = googleMap;mbosquesdelsilecio = googleMap;mmascompaz = googleMap;mcaminoalcielo = googleMap;
        mfuneravet = googleMap;mpetshome = googleMap;mmirefugio = googleMap; mciudaddemascotas = googleMap;mpandgo = googleMap;
        mdoggyh = googleMap;minsignia = googleMap; mvillam = googleMap;mluckyd = googleMap;mcanitaxi = googleMap;mushiip = googleMap;
        mzootaxi = googleMap;maviomar = googleMap;

        LatLng Bogota = new LatLng(4.710902, -74.072799);
        mMap.addMarker(new MarkerOptions().position(Bogota).title("Capital Bogota").snippet("Es la ciudad capital"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Bogota, 10));
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mubicacion.setMyLocationEnabled(true);
        magrocamp.addMarker(new MarkerOptions().position(new LatLng(4.662715, -74.061804)).title("Vetagrocampo").snippet("Hipermercado Veterinario de Colombia"));
        manimal.addMarker(new MarkerOptions().position(new LatLng(4.768704, -74.034873)).title("Colegio San Carlos").snippet("Colegio de Educación superior San Carlos"));
        mpetcol.addMarker(new MarkerOptions().position(new LatLng(4.767729, -74.032257)).title("Panaderia").snippet("Panaderia cerca al apto"));
        mseprovet.addMarker(new MarkerOptions().position(new LatLng(4.769088, -74.031111)).title("Av 9").snippet("Avenida Novena"));
        msaludanimal.addMarker(new MarkerOptions().position(new LatLng(4.687177, -74.110130)).title("Salud Animal").snippet("Clinica Veterinaria Salud Animal"));
        mcatdog.addMarker(new MarkerOptions().position(new LatLng(4.731732, -74.044726)).title("CAT_DOG").snippet("Clínica veterinaria,alimentos concentrados"));
        mabanimal.addMarker(new MarkerOptions().position(new LatLng(4.615651, -74.128716)).title("Abanimal").snippet("Imágenes Diagnosticas Radiología Digital Ecografía"));
        manimalcare.addMarker(new MarkerOptions().position(new LatLng(4.764686, -74.036992)).title("Animal Care Center").snippet("Consulta Urgencia 24 Horas-Rayos X-Ecografía"));
        mcaminohaouse.addMarker(new MarkerOptions().position(new LatLng(4.762494, -74.112961)).title("CANINO HOUSE").snippet("Hotel- Guardería-Adiestramiento"));
        mvillamascotas.addMarker(new MarkerOptions().position(new LatLng(4.662328, -74.008338)).title("Villa Mascotas").snippet("Un lugar dedicado al cuidado y hospedaje de mascotas"));
        mpetlovers.addMarker(new MarkerOptions().position(new LatLng(4.900925, -74.042735)).title("PET LOVERS").snippet("Centro Canino - Colegio Canino"));
        mmiperroenlaruch.addMarker(new MarkerOptions().position(new LatLng(4.675593, -74.022924)).title("MiPerroenlaruch").snippet("La Ruch cuenta con bienestar, recreación, seguridad y cariño"));
        mceba.addMarker(new MarkerOptions().position(new LatLng(4.664907, -74.061886)).title("CEBA").snippet("Distribuido productos veterinarios"));
        mvecol.addMarker(new MarkerOptions().position(new LatLng(4.672921, -74.116430)).title("VECOL").snippet("Medicamentos y Productos para su mascota"));
        mvibrac.addMarker(new MarkerOptions().position(new LatLng(4.668778, -74.122267)).title("VIRBAC").snippet("Libertad de expresión, autonomía y responsabilidad"));
        manimals.addMarker(new MarkerOptions().position(new LatLng(4.661841, -74.062314)).title("ANIMALS").snippet("Servicio de grooming-peluqueria canina y felina"));
        mbosquesdelsilecio.addMarker(new MarkerOptions().position(new LatLng(4.724428, -74.036315)).title("BOSQUES DEL SILECIO").snippet("La exclusiva Casa Funeraria – Cementerio para Mascotas"));
        mmascompaz.addMarker(new MarkerOptions().position(new LatLng(4.662919, -74.073450)).title("MASCOMPAZ").snippet("Mascopaz te orienta, para que el cuerpo de tu mascota"));
        mcaminoalcielo.addMarker(new MarkerOptions().position(new LatLng(4.679915, -74.101188)).title("CAMINO AL CIELO").snippet("Me has dado un hogar donde cobijarme"));
        mfuneravet.addMarker(new MarkerOptions().position(new LatLng(4.667745, -74.077448)).title("FUNERAVET").snippet("Médicos veterinarios para brindar servicios funerarios"));
        mpetshome.addMarker(new MarkerOptions().position(new LatLng(4.848332, -74.053048)).title("PETS HOME").snippet("Pets Hotel in bogota, colombia,"));
        mmirefugio.addMarker(new MarkerOptions().position(new LatLng(4.847932, -74.064912)).title("MI REFUGIO CANINO").snippet("Belleza, Adiestramiento Canino, Jardín de Entretenimiento, Hotel 5 Estrellas"));
        mciudaddemascotas.addMarker(new MarkerOptions().position(new LatLng(4.681096, -74.039463)).title("CIUDAD DE MASCOTAS").snippet("Encuentra todo para tu gato los mejores juguetes."));
        mpandgo.addMarker(new MarkerOptions().position(new LatLng(4.754494, -74.132962)).title("PETS AND GO").snippet("Aquí encontraras los accesorios que tu mascota"));
        mdoggyh.addMarker(new MarkerOptions().position(new LatLng(4.929422, -74.012120)).title("DOGGY - HOUSE").snippet("Los Mejores planes para las mascotas "));
        minsignia.addMarker(new MarkerOptions().position(new LatLng(4.752332, -74.076763)).title("INSIGNIA").snippet("Colegio para perros."));
        mvillam.addMarker(new MarkerOptions().position(new LatLng(4.662382, -74.008327)).title("VILLA MASCOTAS").snippet("Cuidado, hospedaje, servicios de Hotel y Guardería"));
        mluckyd.addMarker(new MarkerOptions().position(new LatLng(4.931214, -74.039278)).title("LUCKY DOG HOTEL").snippet("El Mejor Cuidado para Tu Mascota"));
        mubicacion.setOnMyLocationChangeListener(this);
        mcanitaxi.addMarker(new MarkerOptions().position(new LatLng(4.670461, -74.128747)).title("CANITAXI").snippet("Transporte especializado para mascotas"));
        mushiip.addMarker(new MarkerOptions().position(new LatLng(4.746104, -74.042600)).title("USHIP").snippet("Traslado de mascotas de forma rápida y económica."));
        mzootaxi.addMarker(new MarkerOptions().position(new LatLng(4.866482, -74.098201)).title("ZOOTAXI").snippet("Trasladamos su mascota desde y hacia cualquier lugar"));
        maviomar.addMarker(new MarkerOptions().position(new LatLng(4.685419, -74.127304)).title("AVIOMAR").snippet("Sin importar cuál sea su mascota"));
        magrocamp.setOnInfoWindowClickListener(this);

    }

    @Override
    public void onMyLocationChange(Location loc) {
        LatLng myposicion = new LatLng(loc.getLatitude(),loc.getLongitude());
        mubicacion.animateCamera(CameraUpdateFactory.newLatLngZoom(myposicion, 14));
        mubicacion.setOnMyLocationChangeListener(null);
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        switch (marker.getTitle()){
            case "Vetagrocampo":
                Intent iragrocampo = new Intent(getApplicationContext(),Agrocampo.class);
                startActivity(iragrocampo);
                break;
            case "Colegio San Carlos":
                Intent iraanimal = new Intent(getApplicationContext(),Guarderia.class);
                startActivity(iraanimal);
                break;
            default:
        }
    }
}
