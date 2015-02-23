package com.example.hangdroid;

//import samsung.ejemplos.divisas_y_euros.R;
//import samsung.ejemplos.divisas_y_euros.utilidades.AdaptadorListaDivisas;
import java.util.ArrayList;

import android.app.ListActivity;
import android.content.SharedPreferences;
import android.os.Bundle;

public class ScoresActivity extends ListActivity {
	
	
	//private String [][] scores;
	private String [][] scores;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scores);
		configureAdapter();
	}	
	
	private void configureAdapter(){
		
		SharedPreferences preferences = getSharedPreferences("MYPREFERENCES", MODE_PRIVATE);
		String savedScores = preferences.getString("SCORES", "NO SCORES");
		
		//REGEX: http://stackoverflow.com/questions/225337/how-do-i-split-a-string-with-any-whitespace-chars-as-delimiters
		String[] scores = savedScores.split("\\s+");
//		scores = new String[1][2];		
//		scores[0][0] = "hola";
//		scores[0][1] = "2";
		ArrayList<String[]> scoreList = new ArrayList<String[]>();
		//String[] scoreLine = new String[2]; TODO: if placed here, does not work... WHY?!
		for (int i = 0; i < scores.length-2; i+=2){
			String[] scoreLine = new String[2]; 
			scoreLine[i%2] = scores[i];
			scoreLine[i%2+1] = scores[i+1];
			scoreList.add(scoreLine);
		}
        String[][] listaAUX = scoreList.toArray(new String[scoreList.size()][2]);
		ScoreListAdapter adapter = new ScoreListAdapter(
				this,
				R.layout.score_item,
				R.id.textViewNamee,
				listaAUX);	
		//getListView().setTextFilterEnabled(true);
		setListAdapter(adapter);
	}
}
