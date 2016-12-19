package com.example.mysterygameapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.mysterygameapp.functions.EntityInfo;
import com.example.mysterygameapp.handlers.CameraHandler;
import com.example.mysterygameapp.handlers.InteractionHandler;
import com.example.mysterygameapp.handlers.MarkersHandler;
import com.example.mysterygameapp.handlers.SaveHandler;
import com.example.mysterygameapp.singletons.SingletonData;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class MapDemoActivity extends AppCompatActivity implements
		GoogleApiClient.ConnectionCallbacks,
		GoogleApiClient.OnConnectionFailedListener,
		LocationListener,
		GoogleMap.OnMarkerClickListener {

	private SupportMapFragment mapFragment;
	public GoogleMap map;
	private GoogleApiClient mGoogleApiClient;
	private LocationRequest mLocationRequest;
	private long UPDATE_INTERVAL = 60000;  /* 60 secs */
	private long FASTEST_INTERVAL = 5000; /* 5 secs */

	private final static int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;

	private static LatLng userLocation;
	private static Marker userMarker;

	public final static String MAP_DEMO_ACTIVITY = "MapDemoActivity";

	Toolbar toolbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_demo_activity);

		toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		mapFragment = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map));
		if (mapFragment != null) {
			mapFragment.getMapAsync(new OnMapReadyCallback() {
				@Override
				public void onMapReady(GoogleMap map) {
					loadMap(map);
				}
			});
		} else {
			Toast.makeText(this, "Error - Map Fragment was null!!", Toast.LENGTH_SHORT).show();
		}
	}

	//The request to connect the client finishes successfully. Now, you can request the current location or start periodic updates
	@Override
	public void onConnected(Bundle dataBundle) {
		// Display the connection status
		if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
			return;
		}
		Location location = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
		if (location != null) {
			Toast.makeText(this, "GPS location was found!", Toast.LENGTH_SHORT).show();
			LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

			MarkersHandler markersHandler = new MarkersHandler();

			//user first time in the game
			if (userMarker==null) {
				userLocation = latLng;
				userMarker = markersHandler.setUserOnMap(map, userLocation);
				markersHandler.setMarkersOnMap(map, 0, userMarker);

			} else {
				userMarker = markersHandler.updateUserMarker(map, userMarker, userLocation);
				markersHandler.setMarkersOnMap(map, SingletonData.getUser().getCount(), userMarker);
				markersHandler.displayNextEntity(SingletonData.getUser().getCount(), userMarker);
			}

			//userLocation = latLng;
			//userMarker = markersHandler.setUserOnMap(map, userLocation);

			//userMarker = markersHandler.updateUserMarker(map, userMarker, userLocation);
			//markersHandler.setMarkersOnMap(map);
			markersHandler.displayNextEntity(SingletonData.getUser().getCount(), userMarker);

			new CameraHandler().setCamera(map, userLocation);

			map.setOnMarkerClickListener(this);

		} else {
			Toast.makeText(this, "Current location was null, enable GPS on emulator!", Toast.LENGTH_SHORT).show();
		}

		//startLocationUpdates();

	}

	@Override
	public boolean onMarkerClick(Marker clickedMarker) {

		MarkersHandler markersHandler = new MarkersHandler();

		//the marker clicked will be the user's new position
		userLocation = new LatLng( clickedMarker.getPosition().latitude, clickedMarker.getPosition().longitude);
		//update userMarker -> update userMarker and set on map
		userMarker = markersHandler.updateUserMarker(map, userMarker, userLocation);

		String title = clickedMarker.getTitle(); //get marker's title

		//if the user is not clicking on the userMarker...
		if (!title.equals("user")){

			String markerType = EntityInfo.findEntityType(title);
			int markerId = EntityInfo.findEntityID(title); //find entity's id by the title

			Intent intent = new Intent(MapDemoActivity.this, InteractionHandler.class);
			intent.putExtra("markerId", markerId);
			intent.putExtra("markerType", markerType);
			startActivity(intent);
		}

		// Return false to indicate that we have not consumed the event and that we wish for the default behavior to occur
		return false;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch ( item.getItemId() ) {

			case R.id.action_profile:
				startActivity(new Intent(MapDemoActivity.this, UserProfile.class));
				break;

			case R.id.action_show_markers:
				MarkersHandler  markersShow = new MarkersHandler();
				markersShow.showAllMarkers();
				break;

			case R.id.action_hide_markers:
				MarkersHandler  markersHide = new MarkersHandler();
				markersHide.hideMarkers(SingletonData.getUser().getCount(), userMarker);
				break;

			case R.id.action_zoom_in:
				CameraHandler zoomIn = new CameraHandler();
				zoomIn.cameraZoomIn(map, userMarker.getPosition());
				break;

			case R.id.action_zoom_out:
				CameraHandler zoomOut = new CameraHandler();
				zoomOut.cameraZoomOut(map, userMarker.getPosition());
				break;

			case R.id.action_save:
				startActivity(new Intent(MapDemoActivity.this, SaveHandler.class));
				break;

			case R.id.action_logout:
				Intent logoutIntent = new Intent(Intent.ACTION_MAIN);
				logoutIntent.addCategory(Intent.CATEGORY_HOME);
				logoutIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(logoutIntent);
				break;

			default:
				break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

//================================================================================================//

	protected void loadMap(GoogleMap googleMap) {
		map = googleMap;
		if (map != null) {
			// Map is ready
			Toast.makeText(this, "Map Fragment was loaded properly!", Toast.LENGTH_SHORT).show();
			MapDemoActivityPermissionsDispatcher.getMyLocationWithCheck(this);
		} else {
			Toast.makeText(this, "Error - Map was null!!", Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		MapDemoActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
	}

	@SuppressWarnings("all")
	@NeedsPermission({Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION})
	void getMyLocation() {
		if (map != null) {
			// Now that map has loaded, let's get our location!
			map.setMyLocationEnabled(true);
			mGoogleApiClient = new GoogleApiClient.Builder(this)
					.addApi(LocationServices.API)
					.addConnectionCallbacks(this)
					.addOnConnectionFailedListener(this).build();
			connectClient();
		}
	}

	protected void connectClient() {
		// Connect the client.
		if (isGooglePlayServicesAvailable() && mGoogleApiClient != null) {
			mGoogleApiClient.connect();
		}
	}

	//Called when the Activity becomes visible.
	@Override
	protected void onStart() {
		super.onStart();
		connectClient();
	}

	//Called when the Activity is no longer visible.
	@Override
	protected void onStop() {
		// Disconnecting the client invalidates it.
		if (mGoogleApiClient != null) {
			mGoogleApiClient.disconnect();
		}
		super.onStop();
	}

	//Handle results returned to the FragmentActivity by Google Play services
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// Decide what to do based on the original request code
		switch (requestCode) {

			case CONNECTION_FAILURE_RESOLUTION_REQUEST:
			/*
			 * If the result code is Activity.RESULT_OK, try to connect again
			 */
				switch (resultCode) {
					case Activity.RESULT_OK:
						mGoogleApiClient.connect();
						break;
				}

		}
	}

	private boolean isGooglePlayServicesAvailable() {
		// Check that Google Play services is available
		int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
		// If Google Play services is available
		if (ConnectionResult.SUCCESS == resultCode) {
			// In debug mode, log the status
			Log.d("Location Updates", "Google Play services is available.");
			return true;
		} else {
			// Get the error dialog from Google Play services
			Dialog errorDialog = GooglePlayServicesUtil.getErrorDialog(resultCode, this, CONNECTION_FAILURE_RESOLUTION_REQUEST);

			// If Google Play services can provide an error dialog
			if (errorDialog != null) {
				// Create a new DialogFragment for the error dialog
			}

			return false;
		}
	}

	protected void startLocationUpdates() {
		mLocationRequest = new LocationRequest();
		mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
		mLocationRequest.setInterval(UPDATE_INTERVAL);
		mLocationRequest.setFastestInterval(FASTEST_INTERVAL);
		if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
			return;
		}
		LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
	}

	public void onLocationChanged(Location location) {
		// Report to the UI that the location was updated
		String msg = "Updated Location: " +
				Double.toString(location.getLatitude()) + "," + Double.toString(location.getLongitude());
		LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

		//update user's location
		//userLocation = latLng;

		//Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

	}

	//Called by Location Services if the connection to the location client drops because of an error.
	@Override
	public void onConnectionSuspended(int i) {
		if (i == CAUSE_SERVICE_DISCONNECTED) {
			Toast.makeText(this, "Disconnected. Please re-connect.", Toast.LENGTH_SHORT).show();
		} else if (i == CAUSE_NETWORK_LOST) {
			Toast.makeText(this, "Network lost. Please re-connect.", Toast.LENGTH_SHORT).show();
		}
	}

	//Called by Location Services if the attempt to Location Services fails.
	@Override
	public void onConnectionFailed(ConnectionResult connectionResult) {
		//Google Play services can resolve some errors it detects. If the error has a resolution,
		//try sending an Intent to start a Google Play services activity that can resolve error.
		if (connectionResult.hasResolution()) {
			try {
				// Start an Activity that tries to resolve the error
				connectionResult.startResolutionForResult(this, CONNECTION_FAILURE_RESOLUTION_REQUEST);
			} catch (IntentSender.SendIntentException e) {
				// Log the error
				e.printStackTrace();
			}
		} else {
			Toast.makeText(getApplicationContext(), "Sorry. Location services not available to you", Toast.LENGTH_LONG).show();
		}
	}


}