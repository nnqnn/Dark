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
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;
import android.content.SharedPreferences;
import android.view.View;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.DialogFragment;

public class AboutActivity extends Activity {

	private String activityFontName = "";

	private LinearLayout linear1;
	private ImageView imageview1;
	private TextView name;
	private TextView textview1;
	private TextView textview6;
	private LinearLayout linear3;
	private TextView textview5;
	private TextView textview7;

	private Intent win = new Intent();
	private SharedPreferences save;

	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.about);
		initialize(_savedInstanceState);
		initializeLogic();
	}

	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		imageview1 = findViewById(R.id.imageview1);
		name = findViewById(R.id.name);
		textview1 = findViewById(R.id.textview1);
		textview6 = findViewById(R.id.textview6);
		linear3 = findViewById(R.id.linear3);
		textview5 = findViewById(R.id.textview5);
		textview7 = findViewById(R.id.textview7);
		save = getSharedPreferences("save", Activity.MODE_PRIVATE);

		textview7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				win.setAction(Intent.ACTION_VIEW);
				win.setData(Uri.parse("https://t.me/dark_pixgame"));
				startActivity(win);
			}
		});
	}

	private void initializeLogic() {
		name.setTextColor(0xFFFF7043);
		_changeActivityFont("pixel");
		if (save.getString("lang", "").equals("en")) {
			name.setText("Our team");
			textview1.setText("Development:\nKamil Kalimullin\n\nDesign / Editing text:\nBogdan Oleinikov\n\nPublisher:\nMaxim Corpusov");
			textview6.setText("Game news:");
			textview5.setText("Made with love. Dark.\n10.0");
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