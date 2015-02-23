package com.example.hangdroid;

import java.util.Locale;
import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends Activity {

	private String wordToGuess = "horse";
	private static int MAX_ATTEMPTS = 5;
	private static int ATTEMPTS = 0;
	private static int POINTS = 0;
	static Random rand = new Random();
	Bundle bundle;
	// http://stackoverflow.com/questions/3615587/localization-android
	public Locale localLanguage = new Locale("es", "ES");

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		// http://stackoverflow.com/questions/5265913/how-to-use-putextra-and-getextra-for-string-data
		Intent multiplayerIntent = getIntent();
		bundle = multiplayerIntent.getExtras();
		if (bundle == null) {
			wordToGuess = nextRandomWord();
		} else {
			wordToGuess = bundle.getString("wordToGuess").toUpperCase(
					localLanguage);
			Log.d("MYLOG", "the received word to be guessed is: " + wordToGuess);
		}
		initiateHintLetters(wordToGuess);
	}

	private void initiateHintLetters(String wordToGuess2) {
		// http://www.mysamplecode.com/2011/10/android-programmatically-generate.html
		LinearLayout layoutLetters = (LinearLayout) findViewById(R.id.layoutPoints);
		if (layoutLetters.getChildCount() == 0) {
			for (int i = 0; i < wordToGuess2.length(); i++) {
				TextView textView = (TextView) getLayoutInflater().inflate(R.layout.hintview, null);
				layoutLetters.addView(textView);
				// OLD VERSION:
				/*TextView textView = new TextView(this);
				// http://startandroid.ru/en/lessons/complete-list/220-lesson-16-creating-layout-programmatically-layoutparams.html
				LinearLayout.LayoutParams marginParams = new LinearLayout.LayoutParams(
						LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
				marginParams.rightMargin = 10;
				textView.setTextSize(40);
				textView.setText("-");
				layoutLetters.addView(textView, marginParams);*/
			}
		} else {
			// delete all the children from the view and build it again..
			// http://stackoverflow.com/questions/21201840/remove-child-from-layout
			for (int i = 0; i < layoutLetters.getChildCount(); i++) {
				TextView textview = (TextView) layoutLetters.getChildAt(i);
				layoutLetters.removeView(textview);
			}
			initiateHintLetters(wordToGuess2);
		}
	}

	public void getInputLetter(View v) {

		if (!checkWinner() && (MAX_ATTEMPTS - ATTEMPTS >= 0)) {
			EditText introducedLetter = (EditText) findViewById(R.id.editTextName);
			String inputLetter = introducedLetter.getText().toString();

			Log.d("MYLOG", "The letter is " + inputLetter);
			if (inputLetter.length() > 0) {
				checkLetter(inputLetter.toUpperCase(localLanguage));
			} else {
				Toast.makeText(this, "Please introduce at least a letter",
						Toast.LENGTH_SHORT).show();
			}
			introducedLetter.setText(""); // I want a blank space again to input
											// the next letter
		} else if (checkWinner()) { // this point should not be reached...
			Toast.makeText(this,
					"There is already a winner, please start a new game",
					Toast.LENGTH_SHORT).show();
		} else if (!checkWinner() && (MAX_ATTEMPTS - ATTEMPTS < 0)) {
			Toast.makeText(this, "Game over", Toast.LENGTH_SHORT).show();
		}
	}

	public void checkLetter(String inputLetter) {

		if (wordToGuess.contains(inputLetter)) {
			int wordLength = wordToGuess.length();
			for (int i = 0; i < wordLength; i++) {
				if (wordToGuess.charAt(i) == inputLetter.charAt(0)) {
					updateLayoutLetters(i, inputLetter.charAt(0));
				}
			}
			if (checkWinner()) {
				Toast.makeText(this, "You won, try the next word...",
						Toast.LENGTH_SHORT).show();
				SharedPreferences preferences = getSharedPreferences("GAMEPOINTS", Context.MODE_PRIVATE);
				String savedScores = preferences.getString("POINTS", "0");
				SharedPreferences.Editor editor = preferences.edit();
				// TODO: lo que tenia mas...				
				editor.putString("POINTS", String.valueOf(1 + Integer.valueOf(savedScores)));
				editor.commit();
				//++POINTS;
				if (bundle == null) {				
					// refresh the screen for the user to guess a
					// new word
					restartGame(); // Clear the previous word/view and start
									// the game again.
				} else {
					ATTEMPTS = 0; //reset the number of attempts for the next player
					finish();
					// OLD VERSION
					//Intent newMultiplayerIntent = new Intent(this, MultiplayerActivity.class);
					//startActivity(newMultiplayerIntent);
				}
			}
		} else {
			updateMissedLetters(inputLetter.charAt(0));
			updateHangman(++ATTEMPTS);
		}
	}

	private void restartGame() {
		TextView missedLetters = (TextView) findViewById(R.id.missedLetters);
		missedLetters.setText("");
		ATTEMPTS = 0;
		updateHangman(ATTEMPTS);
		wordToGuess = nextRandomWord();
		MAX_ATTEMPTS = 5;
		initiateHintLetters(nextRandomWord());
		EditText introducedLetter = (EditText) findViewById(R.id.editTextName);
		introducedLetter.setText("");

	}

	private String nextRandomWord() {
		String wordList = "AAHS AALS ABAC ABAS ABBA ABBE ABBS ABED ABET ABID ABLE ABLY ABOS ABRI ABUT ABYE ABYS ACAI ACCA ACED ACER ACES ACHE ACHY ACID ACME ACNE ACRE ACTA ACTS ACYL ADAW ADDS ADDY ADIT ADOS ADRY ADZE AEON AERO AERY AESC AFAR AFFY AFRO AGAR AGAS AGED AGEE AGEN AGER AGES AGHA AGIN AGIO AGLU AGLY AGMA AGOG AGON AGUE AHED AHEM AHIS AHOY AIAS AIDE AIDS AIGA AILS AIMS AINE AINS AIRN AIRS AIRT AIRY AITS AITU AJAR AJEE AKED AKEE AKES AKIN ALAE ALAN ALAP ALAR ALAS ALAY ALBA ALBE ALBS ALCO ALEC ALEE ALEF ALES ALEW ALFA ALFS ALGA ALIF ALIT ALKO ALKY ALLS ALLY ALMA ALME ALMS ALOD ALOE ALOW ALPS ALSO ALTO ALTS ALUM AMAH AMAS AMBO AMEN AMIA AMID AMIE AMIN AMIR AMIS AMLA AMMO AMOK AMPS AMUS AMYL ANAL ANAN ANAS ANCE ANDS ANES ANEW ANGA ANIL ANIS ANKH ANNA ANNO ANNS ANOA ANON ANOW ANSA ANTA ANTE ANTI ANTS ANUS APAY APED APER APES APEX APOD APOS APPS APSE APSO APTS AQUA ARAK ARAR ARBA ARBS ARCH ARCO ARCS ARDS AREA ARED AREG ARES ARET AREW ARFS ARIA ARID ARIL ARIS ARKS ARLE ARMS ARMY ARNA AROW ARPA ARSE ARSY ARTI ARTS ARTY ARUM ARVO ARYL ASAR ASCI ASEA ASHY ASKS ASPS ATAP ATES ATMA ATOC ATOK ATOM ATOP ATUA AUFS AUKS AULA AULD AUNE AUNT AURA AUTO AVAL AVAS AVEL AVER AVES AVID AVOS AVOW AWAY AWDL AWED AWEE AWES AWLS AWNS AWNY AWOL AWRY AXAL AXED AXEL AXES AXIL AXIS AXLE AXON AYAH AYES AYIN AYRE AYUS AZAN AZON AZYM BAAL BAAS BABA BABE BABU BABY BACH BACK BACS BADE BADS BAEL BAFF BAFT BAGH BAGS BAHT BAIL BAIT BAJU BAKE BALD BALE BALK BALL BALM BALS BALU BAMS BANC BAND BANE BANG BANI BANK BANS BANT BAPS BAPU BARB BARD BARE BARF BARK BARM BARN BARP BARS BASE BASH BASK BASS BAST BATE BATH BATS BATT BAUD BAUK BAUR BAWD BAWL BAWN BAWR BAYE BAYS BAYT BEAD BEAK BEAM BEAN BEAR BEAT BEAU BECK BEDE BEDS BEDU BEEF BEEN BEEP BEER BEES BEET BEGO BEGS BEIN BELL BELS BELT BEMA BEND BENE BENI BENJ BENS BENT BERE BERG BERK BERM BEST BETA BETE BETH BETS BEVY BEYS BHAT BHEL BHUT BIAS BIBB BIBS BICE BIDE BIDI BIDS BIEN BIER BIFF BIGA BIGG BIGS BIKE BILE BILK BILL BIMA BIND BINE BING BINK BINS BINT BIOG BIOS BIRD BIRK BIRL BIRO BIRR BISE BISH BISK BIST BITE BITO BITS BITT BIZE BLAB BLAD BLAE BLAG BLAH BLAM BLAT BLAW BLAY BLEB BLED BLEE BLET BLEW BLEY BLIN BLIP BLOB BLOC BLOG BLOT BLOW BLUB BLUE BLUR BOAB BOAK BOAR BOAS BOAT BOBA BOBS BOCK BODE BODS BODY BOEP BOET BOFF BOGS BOGY BOHO BOHS BOIL BOIS BOKE BOKO BOKS BOLA BOLD BOLE BOLL BOLO BOLT BOMA BOMB BONA BOND BONE BONG BONK BONY BOOB BOOH BOOK BOOL BOOM BOON BOOR BOOS BOOT BOPS BORA BORD BORE BORK BORM BORN BORS BORT BOSH BOSK BOSS BOTA BOTH BOTS BOTT BOUK BOUN BOUT BOWL BOWR BOWS BOXY BOYF BOYG BOYO BOYS BOZO BRAD BRAE BRAG BRAK BRAN BRAS BRAT BRAW BRAY BRED BREE BREI BREN BRER BREW BREY BRIE BRIG BRIK BRIM BRIN BRIO BRIS BRIT BROD BROG BROO BROS BROW BRRR BRUS BRUT BRUX BUAT BUBA BUBO BUBS BUBU BUCK BUDA BUDI BUDO BUDS BUFF BUFO BUGS BUHL BUHR BUIK BUKE BULB BULK BULL BUMF BUMP BUMS BUNA BUND BUNG BUNK BUNN BUNS BUNT BUOY BURA BURB BURD BURG BURK BURL BURN BURP BURR BURS ";
		String[] arrayWordList = wordList.split(" ");
		return arrayWordList[randInt(0, arrayWordList.length)];
	}

	public static int randInt(int min, int max) { // http://stackoverflow.com/questions/363681/generating-random-integers-in-a-range-with-java
		// Random rand = new Random(); // nextInt is normally exclusive of the
		// top value, so add 1 to make it inclusive
		// int randomNum = rand.nextInt((max - min) + 1) + min;
		int randomNum = rand.nextInt((max - min)) + min;
		return randomNum;
	}

	private boolean checkWinner() {
		// TODO: check that the content is equal to the word to be guessed
		LinearLayout layoutLetters = (LinearLayout) findViewById(R.id.layoutPoints);
		String guessed = "";
		for (int i = 0; i < layoutLetters.getChildCount(); i++) {
			TextView textView = (TextView) layoutLetters.getChildAt(i);
			guessed += textView.getText().toString();
		}
		return guessed.equals(wordToGuess);
	}

	private void updateHangman(int attemps) {
		ImageView hangman = (ImageView) findViewById(R.id.imageHangman);
		if (MAX_ATTEMPTS - attemps >= 0) {
			String picName = "hangdroid_"
					+ String.valueOf(attemps);
			// http://stackoverflow.com/questions/3476430/how-to-get-a-resource-id-with-a-known-resource-name
			int imageId = this.getResources().getIdentifier(picName,
					"drawable", this.getPackageName());
			hangman.setImageResource(imageId);
		} else {
			// hangman.setImageResource(R.drawable.game_over);
			Intent gameOverIntent = new Intent(this, GameOverActivity.class);
			// http://stackoverflow.com/questions/5265913/how-to-use-putextra-and-getextra-for-string-data
			SharedPreferences preferences = getSharedPreferences("GAMEPOINTS", Context.MODE_PRIVATE);
			String savedScores = preferences.getString("POINTS", "zero");

			gameOverIntent.putExtra("points", savedScores);
			Toast.makeText(this, "Game over", Toast.LENGTH_SHORT).show();
			ATTEMPTS = 0;
			POINTS = 0;
			SharedPreferences.Editor editor = preferences.edit();
			editor.putString("POINTS", "0");
			editor.commit();
			startActivity(gameOverIntent);
			finish(); // although it's called after the intent, it gets executed anyway
		}

	}

	private void updateMissedLetters(char charAt) {
		TextView missedLetters = (TextView) findViewById(R.id.missedLetters);
		missedLetters.setText(missedLetters.getText().toString()
				+ String.valueOf(charAt));

	}

	private void updateLayoutLetters(int index, char charAt) {
		LinearLayout layoutLetters = (LinearLayout) findViewById(R.id.layoutPoints);
		TextView textView = (TextView) layoutLetters.getChildAt(index);
		textView.setText(Character.toString(charAt));
	}

}
