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

public class MapaMarket extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMyLocationChangeListener, GoogleMap.OnInfoWindowClickListener {

    private GoogleMap mMap, mubicacion, mceba, mvecol, mvibrac, manimals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_mapa_market);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    //* Manipula el mapa una vez disponible.//
    //  * Este devolución de llamada se activa cuando el mapa está listo para ser utilizado.//
    //  * Aquí es donde podemos añadir marcadores o líneas, añadir detectores o mover la cámara. En este caso,//
    //* Simplemente añadimos un marcador cerca de Sydney, Australia.//
    //* Si los servicios de Google Play no está instalado en el dispositivo, el usuario se le pedirá que instale//
    //* Dentro de la SupportMapFragment. Este método sólo se activará una vez que el usuario tiene//
    //* Instalado servicios de Google Play y regresó a la aplicación.//

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mubicacion = googleMap;
        mceba = googleMap;
        mvecol = googleMap;
        mvibrac = googleMap;
        manimals = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng Bogota = new LatLng(4.710902, -74.072799);
        mMap.addMarker(new MarkerOptions().position(Bogota).title("Capital Bogota").snippet("Es la ciudad capital"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Bogota, 10));
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Considere llamar//
            // ActivityCompat # requestPermissions//
            // Aquí para solicitar los permisos que faltan, y luego anulando//
            // Public void onRequestPermissionsResult (int requestCode, String [] permisos,//
            // Int [] grantResults)
            // Para manejar el caso donde el usuario concede el permiso. Consulte la documentación//
            // Para ActivityCompat # requestPermissions para más detalles.//
            return;
        }
        mubicacion.setMyLocationEnabled(true);

        mceba.addMarker(new MarkerOptions().position(new LatLng(4.664907, -74.061886)).title("CEBA").snippet("Distribuido productos veterinarios"));
        mvecol.addMarker(new MarkerOptions().position(new LatLng(4.672921, -74.116430)).title("VECOL").snippet("Medicamentos y Productos para su mascota"));
        mvibrac.addMarker(new MarkerOptions().position(new LatLng(4.668778, -74.122267)).title("VIRBAC").snippet("Libertad de expresión, autonomía y responsabilidad"));
        manimals.addMarker(new MarkerOptions().position(new LatLng(4.661841, -74.062314)).title("ANIMALS").snippet("Servicio de grooming-peluqueria canina y felina"));
        mubicacion.setOnMyLocationChangeListener(this);

        mceba.setOnInfoWindowClickListener(this);

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
            case "CEBA":
                Intent iragrocampo = new Intent(getApplicationContext(),Ceba.class);
                startActivity(iragrocampo);
                break;
            case "VECOL":
                Intent iraanimal = new Intent(getApplicationContext(),Guarderia.class);
                startActivity(iraanimal);
                break;
            default:
        }
    }
}
