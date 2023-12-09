package com.taptab.dark;

import android.app.Activity;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;
import android.media.MediaPlayer;
import android.content.SharedPreferences;
import android.view.View;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.DialogFragment;

public class PauseActivity extends Activity {

	private String activityFontName = "";

	private LinearLayout linear2;
	private TextView textview1;
	private TextView textview2;
	private TextView textview4;
	private TextView textview3;

	private Intent intent = new Intent();
	private MediaPlayer media;
	private SharedPreferences save;

	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.pause);
		initialize(_savedInstanceState);
		initializeLogic();
	}

	private void initialize(Bundle _savedInstanceState) {
		linear2 = findViewById(R.id.linear2);
		textview1 = findViewById(R.id.textview1);
		textview2 = findViewById(R.id.textview2);
		textview4 = findViewById(R.id.textview4);
		textview3 = findViewById(R.id.textview3);
		save = getSharedPreferences("save", Activity.MODE_PRIVATE);

		textview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});

		textview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), SettingsActivity.class);
				startActivity(intent);
				finish();
			}
		});

		textview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), Main12Activity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
				finish();
			}
		});
	}

	private void initializeLogic() {
		_changeActivityFont("pixel");
		if (save.getString("lang", "").equals("en")) {
			textview2.setText("Resume game");
			textview4.setText("Settings");
			textview3.setText("Exit to menu");
		}
	}

	public void _changeActivityFont(final String _fontname) {
		activityFontName = _fontname.trim();
		if (activityFontName.contains(".ttf")) {
			activityFontName = activityFontName.replace(".ttf", "");
		}
		overrideFonts(this, getWindow().getDecorView());
	}

	private void overrideFonts(final android.content.Context context, final View v) {
		try {
			Typeface activityTypeFace = Typeface.createFromAsset(getAssets(), "fonts/" + activityFontName + ".ttf");
			if ((v instanceof ViewGroup)) {
				ViewGroup activityFontGroup = (ViewGroup) v;
				for (int i = 0;
					 i < activityFontGroup.getChildCount();
					 i++) {
					View child = activityFontGroup.getChildAt(i);
					overrideFonts(context, child);
				}
			} else {
				if ((v instanceof TextView)) {
					((TextView) v).setTypeface(activityTypeFace);
				} else {
					if ((v instanceof EditText)) {
						((EditText) v).setTypeface(activityTypeFace);
					} else {
						if ((v instanceof Switch)) {
							((Switch) v).setTypeface(activityTypeFace);
						} else {
							if ((v instanceof CheckBox)) {
								((CheckBox) v).setTypeface(activityTypeFace);
							} else {
								if ((v instanceof Button)) {
									((Button) v).setTypeface(activityTypeFace);
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
		}
	}
}
