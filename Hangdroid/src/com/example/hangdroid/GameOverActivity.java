package com.example.hangdroid;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class GameOverActivity extends Activity {
	
	int points;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_over);
		Bundle extras = getIntent().getExtras();
		points = Integer.valueOf((String) extras.get("points"));		
		updatePoints();
		//saveScore();
	}

	public void saveScore(View v){
		SharedPreferences preferences = getSharedPreferences("MYPREFERENCES", MODE_PRIVATE);
		EditText editText = (EditText) findViewById(R.id.editTextName);
		//TextView textViewPoints = (TextView) findViewById(R.id.textViewPoints);
		//String points = textViewPoints.getText().toString();
		String name = editText.getText().toString();
		SharedPreferences.Editor editor = preferences.edit();
		String previousScores = preferences.getString("SCORES", "");
		editor.putString("SCORES", name + " " + String.valueOf(points) + "POINTS \n" + previousScores);
		editor.commit();
		finish();
	}

	private void updatePoints() {
		TextView textViewPoints = (TextView) findViewById(R.id.textViewPoints);
		textViewPoints.setText(String.valueOf(points));		
		//points = String.valueOf(points);
	}
}
