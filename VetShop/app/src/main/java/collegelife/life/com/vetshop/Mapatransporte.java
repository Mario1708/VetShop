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

public class Mapatransporte extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMyLocationChangeListener, GoogleMap.OnInfoWindowClickListener {

    private GoogleMap mMap, mubicacion, mcanitaxi, mushiip, mzootaxi, maviomar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_mapatransporte);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mubicacion = googleMap;
        mcanitaxi = googleMap;
        mushiip = googleMap;
        mzootaxi = googleMap;
        maviomar = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng Bogota = new LatLng(4.710902, -74.072799);
        mMap.addMarker(new MarkerOptions().position(Bogota).title("Capital Bogota").snippet("Es la ciudad capital"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Bogota, 10));
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        mubicacion.setMyLocationEnabled(true);

        mcanitaxi.addMarker(new MarkerOptions().position(new LatLng(4.670461, -74.128747)).title("CANITAXI").snippet("Transporte especializado para mascotas"));
        mushiip.addMarker(new MarkerOptions().position(new LatLng(4.746104, -74.042600)).title("USHIP").snippet("Traslado de mascotas de forma rápida y económica."));
        mzootaxi.addMarker(new MarkerOptions().position(new LatLng(4.866482, -74.098201)).title("ZOOTAXI").snippet("Trasladamos su mascota desde y hacia cualquier lugar"));
        maviomar.addMarker(new MarkerOptions().position(new LatLng(4.685419, -74.127304)).title("AVIOMAR").snippet("Sin importar cuál sea su mascota"));
        mubicacion.setOnMyLocationChangeListener(this);

        mcanitaxi.setOnInfoWindowClickListener(this);
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
            case "CANITAXI":
                Intent iragrocampo = new Intent(getApplicationContext(),CaniTaxi.class);
                startActivity(iragrocampo);
                break;
            case "USHIP":
                Intent iraanimal = new Intent(getApplicationContext(),Guarderia.class);
                startActivity(iraanimal);
                break;
            default:
        }
    }
}
