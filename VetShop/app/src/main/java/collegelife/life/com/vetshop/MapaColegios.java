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

public class MapaColegios extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMyLocationChangeListener, GoogleMap.OnInfoWindowClickListener {

    private GoogleMap mMap, mubicacion, mdoggyh, minsignia, mvillam, mluckyd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_mapa_colegios);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mubicacion = googleMap;
        mdoggyh = googleMap;
        minsignia = googleMap;
        mvillam = googleMap;
        mluckyd = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng Bogota = new LatLng(4.710902, -74.072799);
        mMap.addMarker(new MarkerOptions().position(Bogota).title("Capital Bogota").snippet("Es la ciudad capital"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Bogota, 10));
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        mubicacion.setMyLocationEnabled(true);

        mdoggyh.addMarker(new MarkerOptions().position(new LatLng(4.929422, -74.012120)).title("DOGGY - HOUSE").snippet("Los Mejores planes para las mascotas "));
        minsignia.addMarker(new MarkerOptions().position(new LatLng(4.752332, -74.076763)).title("INSIGNIA").snippet("Colegio para perros."));
        mvillam.addMarker(new MarkerOptions().position(new LatLng(4.662382, -74.008327)).title("VILLA MASCOTAS").snippet("Cuidado, hospedaje, servicios de Hotel y Guardería"));
        mluckyd.addMarker(new MarkerOptions().position(new LatLng(4.931214, -74.039278)).title("LUCKY DOG HOTEL").snippet("El Mejor Cuidado para Tu Mascota"));
        mubicacion.setOnMyLocationChangeListener(this);

        mdoggyh.setOnInfoWindowClickListener(this);

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
            case "DOGGY - HOUSE":
                Intent iragrocampo = new Intent(getApplicationContext(),DoggyH.class);
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
