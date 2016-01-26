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

public class Mapafunerarias extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMyLocationChangeListener, GoogleMap.OnInfoWindowClickListener  {

    private GoogleMap mMap, mubicacion, mbosquesdelsilecio, mmascompaz, mcaminoalcielo, mfuneravet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_mapafunerarias);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mubicacion = googleMap;
        mbosquesdelsilecio = googleMap;
        mmascompaz = googleMap;
        mcaminoalcielo = googleMap;
        mfuneravet = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng Bogota = new LatLng(4.710902, -74.072799);
        mMap.addMarker(new MarkerOptions().position(Bogota).title("Capital Bogota").snippet("Es la ciudad capital"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Bogota, 10));
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mubicacion.setMyLocationEnabled(true);

        mbosquesdelsilecio.addMarker(new MarkerOptions().position(new LatLng(4.724428, -74.036315)).title("BOSQUES DEL SILECIO").snippet("La exclusiva Casa Funeraria – Cementerio para Mascotas"));
        mmascompaz.addMarker(new MarkerOptions().position(new LatLng(4.662919, -74.073450)).title("MASCOMPAZ").snippet("Mascopaz te orienta, para que el cuerpo de tu mascota"));
        mcaminoalcielo.addMarker(new MarkerOptions().position(new LatLng(4.679915, -74.101188)).title("CAMINO AL CIELO").snippet("Me has dado un hogar donde cobijarme"));
        mfuneravet.addMarker(new MarkerOptions().position(new LatLng(4.667745, -74.077448)).title("FUNERAVET").snippet("Médicos veterinarios para brindar servicios funerarios"));
        mubicacion.setOnMyLocationChangeListener(this);

        mbosquesdelsilecio.setOnInfoWindowClickListener(this);

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
            case "BOSQUES DEL SILECIO":
                Intent iragrocampo = new Intent(getApplicationContext(),BosquedelSilecio.class);
                startActivity(iragrocampo);
                break;
            case "MASCOMPAZ":
                Intent iraanimal = new Intent(getApplicationContext(),Guarderia.class);
                startActivity(iraanimal);
                break;
            default:
        }
    }
}
