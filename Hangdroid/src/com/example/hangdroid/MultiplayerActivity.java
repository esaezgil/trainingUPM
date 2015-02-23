package com.example.hangdroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MultiplayerActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_multiplayer);
	}
	
	public void launchGame(View v){
		EditText editText = (EditText) findViewById(R.id.editText1);
		String wordToGuess = editText.getText().toString();
		editText.setText(""); // clear the text for the next word
		Intent multiplayerIntent = new Intent(this, GameActivity.class);
		multiplayerIntent.putExtra("wordToGuess", wordToGuess);
		startActivity(multiplayerIntent);
	}
}
