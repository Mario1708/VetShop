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

public class Mapaentertain extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMyLocationChangeListener, GoogleMap.OnInfoWindowClickListener {

    private GoogleMap mMap, mubicacion, mpetshome, mmirefugio, mciudaddemascotas, mpandgo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_mapaentertain);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mubicacion = googleMap;
        mpetshome = googleMap;
        mmirefugio = googleMap;
        mciudaddemascotas = googleMap;
        mpandgo = googleMap;

        LatLng Bogota = new LatLng(4.710902, -74.072799);
        mMap.addMarker(new MarkerOptions().position(Bogota).title("Capital Bogota").snippet("Es la ciudad capital"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Bogota, 10));
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mubicacion.setMyLocationEnabled(true);

        mpetshome.addMarker(new MarkerOptions().position(new LatLng(4.848332, -74.053048)).title("PETS HOME").snippet("Pets Hotel in bogota, colombia,"));
        mmirefugio.addMarker(new MarkerOptions().position(new LatLng(4.847932, -74.064912)).title("MI REFUGIO CANINO").snippet("Belleza, Adiestramiento Canino, Jardín de Entretenimiento, Hotel 5 Estrellas"));
        mciudaddemascotas.addMarker(new MarkerOptions().position(new LatLng(4.681096, -74.039463)).title("CIUDAD DE MASCOTAS").snippet("Encuentra todo para tu gato los mejores juguetes."));
        mpandgo.addMarker(new MarkerOptions().position(new LatLng(4.754494, -74.132962)).title("PETS AND GO").snippet("Aquí encontraras los accesorios que tu mascota"));
        mubicacion.setOnMyLocationChangeListener(this);

        mpetshome.setOnInfoWindowClickListener(this);

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
            case "PETS HOME":
                Intent irapets = new Intent(getApplicationContext(),PETSHOME.class);
                startActivity(irapets);
                break;
            case "VECOL":
                Intent iraanimal = new Intent(getApplicationContext(),Guarderia.class);
                startActivity(iraanimal);
                break;
            default:
        }
    }
}
