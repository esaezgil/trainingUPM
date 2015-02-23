package com.example.hangdroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HangdroidMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hangdroid_main);
	}
	
	public void startGameActivity(View v){
		Intent myIntent = new Intent(this, GameActivity.class);
		startActivity(myIntent);
	}
	
	public void startMultiplayer(View v){
		Intent multiplayerIntent = new Intent(this, MultiplayerActivity.class);
		startActivity(multiplayerIntent);
	}
	
	public void openScores(View v){
		Intent scoresIntent = new Intent(this, ScoresActivity.class);
		startActivity(scoresIntent);
	}
}
