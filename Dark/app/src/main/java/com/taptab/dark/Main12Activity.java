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
import java.util.ArrayList;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;
import android.content.SharedPreferences;
import java.util.Timer;
import java.util.TimerTask;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.view.View;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.DialogFragment;

public class Main12Activity extends Activity {

	private Timer _timer = new Timer();

	private boolean click = false;
	private double nm = 0;
	private String activityFontName = "";
	private String retitle = "";

	private ArrayList<String> reverse = new ArrayList<>();

	private LinearLayout linear3;
	private LinearLayout linear1;
	private TextView name;
	private LinearLayout linear2;
	private TextView version;
	private TextView play_btn;
	private TextView textview1;
	private TextView about_btn;

	private Intent win = new Intent();
	private SharedPreferences oauth;
	private SharedPreferences save;
	private TimerTask anim;
	private TimerTask musictime;
	private MediaPlayer media;
	private SoundPool sounds;

	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main12);
		initialize(_savedInstanceState);
		initializeLogic();
	}

	private void initialize(Bundle _savedInstanceState) {
		linear3 = findViewById(R.id.linear3);
		linear1 = findViewById(R.id.linear1);
		name = findViewById(R.id.name);
		linear2 = findViewById(R.id.linear2);
		version = findViewById(R.id.version);
		play_btn = findViewById(R.id.play_btn);
		textview1 = findViewById(R.id.textview1);
		about_btn = findViewById(R.id.about_btn);
		oauth = getSharedPreferences("oauth", Activity.MODE_PRIVATE);
		save = getSharedPreferences("save", Activity.MODE_PRIVATE);

		version.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {

			}
		});

		play_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				play_btn.setTextColor(0xFF4CAF50);
				win.putExtra("chap", save.getString("save", ""));
				if (save.getString("lang", "").equals("ru")) {
					win.putExtra("chapter", "Глава 1");
				} else {
					win.putExtra("chapter", "Chapter 1");
				}
				if (save.getString("lang", "").equals("ru")) {
					retitle = "Запутанность";
				} else {
					retitle = "Entanglement";
				}
				win.putExtra("retitle", retitle);
				win.putExtra("end", "gl");
				win.setClass(getApplicationContext(), ChapterActivity.class);
				startActivity(win);
				media.pause();
				media.reset();
				finish();
			}
		});

		textview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				win.setClass(getApplicationContext(), SettingsActivity.class);
				win.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
				startActivityForResult(win, 0);
				overridePendingTransition(0, 0);
			}
		});

		about_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				win.setClass(getApplicationContext(), AboutActivity.class);
				win.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
				startActivityForResult(win, 0);
				overridePendingTransition(0, 0);
			}
		});
	}

	private void initializeLogic() {
		if (!save.getString("save", "").equals("1")) {
			play_btn.setText("Продолжить");
		}
		_changeActivityFont("pixel");
		linear1.setVisibility(View.INVISIBLE);
		_in();
		anim = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						linear1.setVisibility(View.VISIBLE);
						_out();
					}
				});
			}
		};
		_timer.schedule(anim, (int) (5));
		if (save.getString("lang", "").equals("en")) {
			play_btn.setText("Play");
			textview1.setText("Settings");
			about_btn.setText("About authors");
		}

		musictime = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						sounds = new SoundPool((int) (3), AudioManager.STREAM_MUSIC, 0);
						media = MediaPlayer.create(getApplicationContext(), R.raw.game);
						media.start();
					}
				});
			}
		};
		_timer.schedule(musictime, (int) (45000));
	}

	@Override
	public void onBackPressed() {

	}

	@Override
	public void onStart() {
		super.onStart();
		if (save.getString("save", "").equals("1")) {
			play_btn.setText("Начать");
		} else {
			play_btn.setText("Продолжить");
		}
		if (save.getString("lang", "").equals("en")) {
			play_btn.setText("Play");
		}
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		if (media.isPlaying()) {
			media.pause();
			media.reset();
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


	public void _in() {
		final AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
		final AlphaAnimation fadeOut = new AlphaAnimation(1.0f, 0.0f);

		linear1.startAnimation(fadeIn);
		linear1.startAnimation(fadeOut);
		fadeIn.setDuration(1);
		fadeIn.setFillAfter(true);
		fadeOut.setDuration(1);
		fadeOut.setFillAfter(true);
		fadeOut.setStartOffset(10 + fadeIn.getStartOffset());
	}


	public void _out() {
		final AlphaAnimation fadeIn = new AlphaAnimation(1.0f, 0.0f);
		final AlphaAnimation fadeOut = new AlphaAnimation(0.0f, 1.0f);

		linear1.startAnimation(fadeIn);
		linear1.startAnimation(fadeOut);
		fadeIn.setDuration(1000);
		fadeIn.setFillAfter(true);
		fadeOut.setDuration(1000);
		fadeOut.setFillAfter(true);
		fadeOut.setStartOffset(10 + fadeIn.getStartOffset());
	}
}