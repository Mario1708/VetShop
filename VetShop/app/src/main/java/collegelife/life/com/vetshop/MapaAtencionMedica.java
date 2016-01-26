package collegelife.life.com.vetshop;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaAtencionMedica extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMyLocationChangeListener, GoogleMap.OnInfoWindowClickListener {


    private GoogleMap mMap, mubicacion, msaludanimal, mcatdog, mabanimal,manimalcare;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_mapa_atencion_medica);
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
        msaludanimal = googleMap;
        mcatdog = googleMap;
        mabanimal = googleMap;
        manimalcare = googleMap;

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

        msaludanimal.addMarker(new MarkerOptions().position(new LatLng(4.687177, -74.110130)).title("Salud Animal").snippet("Clinica Veterinaria Salud Animal"));
        mcatdog.addMarker(new MarkerOptions().position(new LatLng(4.731732, -74.044726)).title("CAT_DOG").snippet("Clínica veterinaria,alimentos concentrados"));
        mabanimal.addMarker(new MarkerOptions().position(new LatLng(4.615651, -74.128716)).title("Abanimal").snippet("Imágenes Diagnosticas Radiología Digital Ecografía"));
        manimalcare.addMarker(new MarkerOptions().position(new LatLng(4.764686, -74.036992)).title("Animal Care Center").snippet("Consulta Urgencia 24 Horas-Rayos X-Ecografía"));
        mubicacion.setOnMyLocationChangeListener(this);

        msaludanimal.setOnInfoWindowClickListener(this);

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
            case "Salud Animal":
                Intent iragrocampo = new Intent(getApplicationContext(),SaludAnimal.class);
                startActivity(iragrocampo);
                break;
            case "CAT_DOG":
                Intent iraanimal = new Intent(getApplicationContext(),Guarderia.class);
                startActivity(iraanimal);
                break;
            default:
        }
    }
}
