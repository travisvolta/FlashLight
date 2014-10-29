package com.example.flashlight;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
	int lengthOfDotInMiliseconds = 100;
	Camera cam;
	Parameters p, s;
	Thread Thread = new Thread();
	String stringFromEditText;
	String wholeStringIn0and1 = "";
	String thisLetterIn0and1 = "";
	ToggleButton tb;
	SeekBar sb;
	Button button2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		button2 = (Button)findViewById(R.id.button2);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		cam = Camera.open();
		sb = (SeekBar)findViewById(R.id.seekBar1);
	}

	@Override
	protected void onPause() {
		cam.release();
		super.onPause();
	}

	public void switchOn(View v) {
		p = cam.getParameters();
		p.setFlashMode(Parameters.FLASH_MODE_TORCH);
		cam.setParameters(p);
		cam.startPreview();
		try {
			Thread.sleep(lengthOfDotInMiliseconds);
		} catch (InterruptedException e) {
			Toast.makeText(this, "got interrupted off", Toast.LENGTH_SHORT)
					.show();
		}
	}

	public void switchOff(View v) {
		s = cam.getParameters();
		s.setFlashMode(Parameters.FLASH_MODE_OFF);
		cam.setParameters(s);
		try {
			Thread.sleep(lengthOfDotInMiliseconds);
		} catch (InterruptedException e) {
			Toast.makeText(this, "got interrupted off", Toast.LENGTH_SHORT)
					.show();
		}

	}

	public void onToggleClicked(View v) {
		boolean on = (tb.isChecked());
		if (on) {
			switchOn(v);
		} else {
			switchOff(v);
		}
	}



	public void stringFromEditTextToBlinkConverter(View v) {
		// define our EditText element
		EditText et = (EditText) findViewById(R.id.editText1);
		Log.v("myLog", "define our EditText element");
		// set value from editText to String
		String stringFromEditText = et.getText().toString().toUpperCase();
		Log.v("myLog", "set value from editText to String");
		Log.v("myLog", stringFromEditText);
		// convert stringFromEditText to 0 and 1
		convertStringTo1and0string(stringFromEditText);

		for (int i = 0; i < wholeStringIn0and1.length(); i++) {
			Log.v("myLog", "for to blink");
			char currentSymbol = wholeStringIn0and1.charAt(i);
			Log.v("myLog", "value of currentSymbol is "+currentSymbol);
			if (currentSymbol == '1') {
				switchOn(v);
			} else {
				switchOff(v);
			}
		}
	et.setText("");
	wholeStringIn0and1="";
	}

	private void convertStringTo1and0string(String stringFromEditText) {
		for (int i = 0; i < stringFromEditText.length(); i++) {
			char currentChar = stringFromEditText.charAt(i);
			Log.v("myLog", currentChar+" is current char");
			Log.v("myLog", stringFromEditText.length()+"");
			Log.v("myLog", i+" iteration action");
			switch (currentChar) {
			case 'A':
				thisLetterIn0and1 = "10111000";
				break;
			case 'B':
				thisLetterIn0and1 = "10101000";
				break;
			case 'C':
				thisLetterIn0and1 = "11101011101000";
				break;
			case 'D':
				thisLetterIn0and1 = "1110101000";
				break;
			case 'E':
				thisLetterIn0and1 = "1000";
				break;
			case 'F':
				thisLetterIn0and1 = "101011101000";
				break;
			case 'G':
				thisLetterIn0and1 = "111011101000";
				break;
			case 'H':
				thisLetterIn0and1 = "1010101000";
				break;
			case 'I':
				thisLetterIn0and1 = "101000";
				break;
			case 'J':
				thisLetterIn0and1 = "1011101110111000";
				break;
			case 'K':
				thisLetterIn0and1 = "111010111000";
				break;
			case 'L':
				thisLetterIn0and1 = "101110101000";
				break;
			case 'M':
				thisLetterIn0and1 = "1110111000";
				break;
			case 'N':
				thisLetterIn0and1 = "11101000";
				break;
			case 'O':
				thisLetterIn0and1 = "11101110111000";
				break;
			case 'P':
				thisLetterIn0and1 = "10111011101000";
				break;
			case 'Q':
				thisLetterIn0and1 = "1110111010111000";
				break;
			case 'R':
				thisLetterIn0and1 = "1011101000";
				break;
			case 'S':
				thisLetterIn0and1 = "10101000";
				break;
			case 'T':
				thisLetterIn0and1 = "111000";
				break;
			case 'U':
				thisLetterIn0and1 = "1010111000";
				break;
			case 'V':
				thisLetterIn0and1 = "101010111000";
				break;
			case 'W':
				thisLetterIn0and1 = "101110111000";
				break;
			case 'X':
				thisLetterIn0and1 = "11101010111000";
				break;
			case 'Y':
				thisLetterIn0and1 = "1110101110111000";
				break;
			case 'Z':
				thisLetterIn0and1 = "11101110101000";
				break;
			case '1':
				thisLetterIn0and1 = "10111011101110111000";
				break;
			case '2':
				thisLetterIn0and1 = "101011101110111000";
				break;
			case '3':
				thisLetterIn0and1 = "1010101110111000";
				break;
			case '4':
				thisLetterIn0and1 = "101010111000";
				break;
			case '5':
				thisLetterIn0and1 = "101010101000";
				break;
			case '6':
				thisLetterIn0and1 = "11101010101000";
				break;
			case '7':
				thisLetterIn0and1 = "1110111010101000";
				break;
			case '8':
				thisLetterIn0and1 = "111011101110101000";
				break;
			case '9':
				thisLetterIn0and1 = "11101110111011101000";
				break;
			case '0':
				thisLetterIn0and1 = "1110111011101110111000";
				break;
			case ' ':
				thisLetterIn0and1 = "000000";
				break;
			}
			wholeStringIn0and1 += thisLetterIn0and1;
			Log.v("myLog", thisLetterIn0and1+" this letter in 1 and 0");
			Log.v("myLog", wholeStringIn0and1+"whole string in 0 and 1");
			
		}
	}
	
}