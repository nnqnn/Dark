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
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;
import android.content.Intent;
import android.net.Uri;
import android.media.SoundPool;
import android.media.MediaPlayer;
import android.content.SharedPreferences;
import android.view.View;
import android.graphics.Typeface;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.DialogFragment;

public class Main1Activity extends Activity {
	
	private Timer _timer = new Timer();
	
	private double nums = 0;
	private String text1 = "";
	private double logs_chat = 0;
	private double shapeww = 0;
	private double click = 0;
	private double num = 0;
	private boolean animb = false;
	private boolean ifcheck1 = false;
	private double logs_chat2 = 0;
	private double xiv = 0;
	private double yiv = 0;
	private boolean animbivot = false;
	private double SoundID = 0;
	private String chapter_count = "";
	private double speed_text = 0;
	private String json1 = "";
	private double i = 0;
	private boolean check = false;
	private boolean btnclck = false;
	private boolean time_check = false;
	private boolean btncheck = false;
	private boolean chk_lestnitsa = false;
	
	private ArrayList<String> logs = new ArrayList<>();
	private ArrayList<String> l1 = new ArrayList<>();
	private ArrayList<String> list_texts = new ArrayList<>();
	
	private LinearLayout linear7;
	private LinearLayout linear4;
	private LinearLayout linear1;
	private ImageView imageview4;
	private LinearLayout act;
	private LinearLayout linear9;
	private LinearLayout linear5;
	private TextView act1;
	private TextView act2;
	private ImageView imageview3;
	private LinearLayout linear6;
	private ImageView plus;
	private ImageView minus;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private TextView textview2;
	private TextView textview1;
	
	private TimerTask anim;
	private Intent win = new Intent();
	private TimerTask check1;
	private TimerTask check2;
	private SoundPool sounds;
	private MediaPlayer media;
	private SharedPreferences settings;
	private TimerTask anim2;
	private TimerTask anim_btn;
	private TimerTask btn;
	private TimerTask didi;
	private TimerTask ttcheck;
	private TimerTask anim22;
	private SharedPreferences save;
	private TimerTask ant;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main1);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear7 = findViewById(R.id.linear7);
		linear4 = findViewById(R.id.linear4);
		linear1 = findViewById(R.id.linear1);
		imageview4 = findViewById(R.id.imageview4);
		act = findViewById(R.id.act);
		linear9 = findViewById(R.id.linear9);
		linear5 = findViewById(R.id.linear5);
		act1 = findViewById(R.id.act1);
		act2 = findViewById(R.id.act2);
		imageview3 = findViewById(R.id.imageview3);
		linear6 = findViewById(R.id.linear6);
		plus = findViewById(R.id.plus);
		minus = findViewById(R.id.minus);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		textview2 = findViewById(R.id.textview2);
		textview1 = findViewById(R.id.textview1);
		settings = getSharedPreferences("set", Activity.MODE_PRIVATE);
		save = getSharedPreferences("save", Activity.MODE_PRIVATE);
		
		linear1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		act1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!btncheck) {
					act1.setEnabled(false);
					act1.setTextColor(0xFF4CAF50);
					act2.setEnabled(false);
					btn = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									if (chapter_count.equals("1") && (logs_chat == 27)) {
										_lestnitsa();
									}
									else {
										if (chapter_count.equals("1") && (logs_chat == 11)) {
											logs_chat = logs_chat + 5;
										}
										if (chapter_count.equals("2") && (logs_chat == 6)) {
											logs_chat = logs_chat + 4;
										}
										_gotext(list_texts.get((int)(logs_chat)));
									}
									act1.setTextColor(0xFFFFFFFF);
									act1.setVisibility(View.INVISIBLE);
									act2.setVisibility(View.INVISIBLE);
									act1.setEnabled(true);
									act2.setEnabled(true);
									btncheck = false;
									btnclck = false;
								}
							});
						}
					};
					_timer.schedule(btn, (int)(1000));
				}
				btncheck = true;
			}
		});
		
		act2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!btncheck) {
					act1.setEnabled(false);
					act2.setTextColor(0xFF4CAF50);
					act2.setEnabled(false);
					btn = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									if ((logs_chat == 4) && chapter_count.equals("1")) {
										logs_chat++;
									}
									_gotext(list_texts.get((int)(logs_chat)));
									act2.setTextColor(0xFFFFFFFF);
									act1.setVisibility(View.INVISIBLE);
									act2.setVisibility(View.INVISIBLE);
									act1.setEnabled(true);
									act2.setEnabled(true);
									btncheck = false;
									btnclck = false;
								}
							});
						}
					};
					_timer.schedule(btn, (int)(1000));
				}
				btncheck = true;
			}
		});
		
		linear6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		plus.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if ((imageview4.getScaleX() < 2.5d) && (imageview4.getScaleY() < 2.5d)) {
					imageview4.setScaleY((float)(imageview4.getScaleY() + 0.1d));
					imageview4.setScaleX((float)(imageview4.getScaleX() + 0.1d));
				}
			}
		});
		
		minus.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if ((imageview4.getScaleX() > 1.0d) && (imageview4.getScaleY() > 1.0d)) {
					imageview4.setScaleY((float)(imageview4.getScaleY() - 0.1d));
					imageview4.setScaleX((float)(imageview4.getScaleX() - 0.1d));
				}
			}
		});
		
		linear2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!chk_lestnitsa) {
					if (!time_check) {
						if (check) {
							if (!btnclck) {
								_gotext(list_texts.get((int)(logs_chat)));
							}
						}
						else {
							nums = text1.length() + 1;
						}
						time_check = true;
						ttcheck = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										time_check = false;
									}
								});
							}
						};
						_timer.schedule(ttcheck, (int)(200));
					}
				}
			}
		});
	}
	
	private void initializeLogic() {
		chapter_count = getIntent().getStringExtra("chapter");
		speed_text = Double.parseDouble(settings.getString("speed", ""));
		if (getIntent().getStringExtra("chapter").equals("1")) {
			_in();
			imageview3.setVisibility(View.INVISIBLE);
			imageview4.setVisibility(View.INVISIBLE);
			sounds = new SoundPool((int)(3), AudioManager.STREAM_MUSIC, 0);
			media = MediaPlayer.create(getApplicationContext(), R.raw.door_to_nightmare_sergey_eybog);
			media.start();
		}
		if (getIntent().getStringExtra("chapter").equals("2")) {
			media = MediaPlayer.create(getApplicationContext(), R.raw.your_bright_side);
			media.start();
		}
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/pixel.ttf"), 0);
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/pixel.ttf"), 0);
		act1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/pixel.ttf"), 0);
		act1.setVisibility(View.INVISIBLE);
		act2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/pixel.ttf"), 0);
		act2.setVisibility(View.INVISIBLE);
		xiv = imageview4.getX();
		yiv = imageview4.getY();
		_makeObjectMoveable(imageview4);
		ifcheck1 = false;
		animbivot = false;
		i = 0;
		logs_chat = 0;
		_jsons();
		didi = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						imageview4.setVisibility(View.VISIBLE);
						_gotext(list_texts.get((int)(logs_chat)));
					}
				});
			}
		};
		_timer.schedule(didi, (int)(1000));
	}
	
	@Override
	public void onBackPressed() {
		win.setClass(getApplicationContext(), PauseActivity.class);
		win.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION); startActivityForResult(win, 0); overridePendingTransition(0,0);
		if (media.isPlaying()) {
			media.pause();
		}
	}
	
	@Override
	public void onResume() {
		super.onResume();
		try {
			media.start();
		} catch (Exception e) {}
	}
	
	@Override
	public void onStop() {
		super.onStop();
		try {
			if (media.isPlaying()) {
				media.pause();
			}
		} catch (Exception e) {}
	}
	public void _Image_ZoomIn_Onclick(final ImageView _img) {
		
		float x=_img.getScaleX(), y=_img.getScaleY(),yenix=x+1,yeniy=y+1; _img.setScaleX(yenix);_img.setScaleY(yeniy);
	}
	
	
	public void _Zoomable_Imageview() {
	}
	public static interface Animation {
		public boolean update(GestureImageView view, long time);
	}
	public static class Animator extends Thread {
		private GestureImageView view;
		private Animation animation;
		private boolean running = false;
		private boolean active = false;
		private long lastTime = -1L;
		
		public Animator(GestureImageView view, String threadName) {
			super(threadName);
			this.view = view;
		}
		
		@Override
		public void run() {
			running = true;
			while(running) {
				while(active && animation != null) {	
					long time = System.currentTimeMillis();
					active = animation.update(view, time - lastTime);				view.redraw();
					lastTime = time;
					while(active) {
						try {
							if(view.waitForDraw(32)) {
								break;
							}
						} catch (InterruptedException ignore) {
							active = false;
						} } }
				synchronized(this) {	
					if(running) {
						try {
							wait();
						} catch (InterruptedException ignore) {}
					} } } }
		
		public synchronized void finish() {
			running = false;
			active = false;
			notifyAll();
		}
		
		public void play(Animation transformer) {
			if(active) {
				cancel();
			}
			this.animation = transformer;
			activate();
		}
		
		public synchronized void activate() {
			lastTime = System.currentTimeMillis();
			active = true;
			notifyAll();
		}
		
		public void cancel() {
			active = false;
		}
	}
	public static class FlingAnimation implements Animation {		private float velocityX;
		private float velocityY;
		private float factor = 0.95f;
		private float threshold = 10;
		private FlingAnimationListener listener;
		
		@Override
		public boolean update(GestureImageView view, long time) {	
			float seconds = (float) time / 1000.0f;
			float dx = velocityX * seconds;
			float dy = velocityY * seconds;	
			velocityX *= factor;
			velocityY *= factor;
			boolean active = (Math.abs(velocityX) > threshold && Math.abs(velocityY) > threshold);
			if(listener != null) {	
				listener.onMove(dx, dy);
				if(!active) {
					listener.onComplete();
				} }
			return active;
		}
		
		public void setVelocityX(float velocityX) {		this.velocityX = velocityX;
		}
		
		public void setVelocityY(float velocityY) {
			this.velocityY = velocityY;
		}
		
		public void setFactor(float factor) {
			this.factor = factor;
		}
		
		public void setListener(FlingAnimationListener listener) {
			this.listener = listener;
		}
	}
	public static interface FlingAnimationListener {
		public void onMove(float x, float y);
		public void onComplete();
	}
	public static class FlingListener extends android.view.GestureDetector.SimpleOnGestureListener {
		private float velocityX;
		private float velocityY;
		
		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
			this.velocityX = velocityX;
			this.velocityY = velocityY;
			return true;
		}
		
		public float getVelocityX() {
			return velocityX;
		}
		
		public float getVelocityY() {
			return velocityY;
		}
	}
	public static class GestureImageView extends ImageView {
		public static final String GLOBAL_NS = "http://schemas.android.com/apk/res/android";
		public static final String LOCAL_NS = "http://schemas.polites.com/android";
		private final java.util.concurrent.Semaphore drawLock = new java.util.concurrent.Semaphore(0);
		private Animator animator;
		private android.graphics.drawable.Drawable drawable;
		private float x = 0, y = 0;
		private boolean layout = false;
		private float scaleAdjust = 1.0f;
		private float startingScale = -1.0f;
		private float scale = 1.0f;
		private float maxScale = 5.0f;
		private float minScale = 0.75f;
		private float fitScaleHorizontal = 1.0f;
		private float fitScaleVertical = 1.0f;
		private float rotation = 0.0f;
		private float centerX;
		private float centerY;
		private Float startX, startY;
		private int hWidth;
		private int hHeight;
		private int resId = -1;
		private boolean recycle = false;
		private boolean strict = false;
		private int displayHeight;
		private int displayWidth;
		private int alpha = 255;
		private ColorFilter colorFilter;
		private int deviceOrientation = -1;
		private int imageOrientation;
		private GestureImageViewListener gestureImageViewListener;
		private GestureImageViewTouchListener gestureImageViewTouchListener;
		private OnTouchListener customOnTouchListener;
		private OnClickListener onClickListener;
		
		public GestureImageView(Context context, AttributeSet attrs, int defStyle) {
			this(context, attrs);
		}
		
		public GestureImageView(Context context, AttributeSet attrs) {
			super(context, attrs);
			String scaleType = attrs.getAttributeValue(GLOBAL_NS, "scaleType");
			if(scaleType == null || scaleType.trim().length() == 0) {
				setScaleType(ScaleType.CENTER_INSIDE);
			}
			String strStartX = attrs.getAttributeValue(LOCAL_NS, "start-x");
			String strStartY = attrs.getAttributeValue(LOCAL_NS, "start-y");
			if(strStartX != null && strStartX.trim().length() > 0) {
				startX = Float.parseFloat(strStartX);
			}
			if(strStartY != null && strStartY.trim().length() > 0) {
				startY = Float.parseFloat(strStartY);
			}
			setStartingScale(attrs.getAttributeFloatValue(LOCAL_NS, "start-scale", startingScale));
			setMinScale(attrs.getAttributeFloatValue(LOCAL_NS, "min-scale", minScale));
			setMaxScale(attrs.getAttributeFloatValue(LOCAL_NS, "max-scale", maxScale));
			setStrict(attrs.getAttributeBooleanValue(LOCAL_NS, "strict", strict));
			setRecycle(attrs.getAttributeBooleanValue(LOCAL_NS, "recycle", recycle));
			initImage();
		}
		
		public GestureImageView(Context context) {
			super(context);
			setScaleType(ScaleType.CENTER_INSIDE);
			initImage();
		}
		
		@Override
		protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
			if(drawable != null) {
				int orientation = getResources().getConfiguration().orientation;
				if(orientation == android.content.res.Configuration.ORIENTATION_LANDSCAPE) {
					displayHeight = MeasureSpec.getSize(heightMeasureSpec);
					if(getLayoutParams().width == android.view.ViewGroup.LayoutParams.WRAP_CONTENT) {
						float ratio = (float) getImageWidth() / (float) getImageHeight();
						displayWidth = Math.round( (float) displayHeight * ratio) ;
					} else {
						displayWidth = MeasureSpec.getSize(widthMeasureSpec);
					} } else {
					displayWidth = MeasureSpec.getSize(widthMeasureSpec);
					if(getLayoutParams().height == android.view.ViewGroup.LayoutParams.WRAP_CONTENT) {
						float ratio = (float) getImageHeight() / (float) getImageWidth();
						displayHeight = Math.round( (float) displayWidth * ratio) ;
					} else {
						displayHeight = MeasureSpec.getSize(heightMeasureSpec);
					} }
			} else {
				displayHeight = MeasureSpec.getSize(heightMeasureSpec);
				displayWidth = MeasureSpec.getSize(widthMeasureSpec);
			}
			setMeasuredDimension(displayWidth, displayHeight);
		}
		
		@Override
		protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
			super.onLayout(changed, left, top, right, bottom);
			if(changed || !layout) {
				setupCanvas(displayWidth, displayHeight, getResources().getConfiguration().orientation);
			} }
		
		protected void setupCanvas(int measuredWidth, int measuredHeight, int orientation) {
			if(deviceOrientation != orientation) {
				layout = false;
				deviceOrientation = orientation;
			}
			if(drawable != null && !layout) {
				int imageWidth = getImageWidth();
				int imageHeight = getImageHeight();
				hWidth = Math.round(((float)imageWidth / 2.0f));
				hHeight = Math.round(((float)imageHeight / 2.0f));
				measuredWidth -= (getPaddingLeft() + getPaddingRight());
				measuredHeight -= (getPaddingTop() + getPaddingBottom());
				computeCropScale(imageWidth, imageHeight, measuredWidth, measuredHeight);
				if(startingScale <= 0.0f) {
					computeStartingScale(imageWidth, imageHeight, measuredWidth, measuredHeight);
				}
				scaleAdjust = startingScale;
				this.centerX = (float) measuredWidth / 2.0f;
				this.centerY = (float) measuredHeight / 2.0f;
				if(startX == null) {
					x = centerX;
				} else {
					x = startX;
				}
				if(startY == null) {
					y = centerY;
				} else {
					y = startY;
				}
				gestureImageViewTouchListener = new GestureImageViewTouchListener(this, measuredWidth, measuredHeight);
				if(isLandscape()) {
					gestureImageViewTouchListener.setMinScale(minScale * fitScaleHorizontal);
				} else {
					gestureImageViewTouchListener.setMinScale(minScale * fitScaleVertical);
				}
				gestureImageViewTouchListener.setMaxScale(maxScale * startingScale);
				gestureImageViewTouchListener.setFitScaleHorizontal(fitScaleHorizontal);
				gestureImageViewTouchListener.setFitScaleVertical(fitScaleVertical);
				gestureImageViewTouchListener.setCanvasWidth(measuredWidth);
				gestureImageViewTouchListener.setCanvasHeight(measuredHeight);
				gestureImageViewTouchListener.setOnClickListener(onClickListener);
				drawable.setBounds(-hWidth,-hHeight,hWidth,hHeight);
				super.setOnTouchListener(new OnTouchListener() {
					@Override
					public boolean onTouch(View v, MotionEvent event) {
						if(customOnTouchListener != null) {
							customOnTouchListener.onTouch(v, event);
						}
						return gestureImageViewTouchListener.onTouch(v, event);
					}
				});
				layout = true;
			}
		}
		
		protected void computeCropScale(int imageWidth, int imageHeight, int measuredWidth, int measuredHeight) {
			fitScaleHorizontal = (float) measuredWidth / (float) imageWidth;
			fitScaleVertical = (float) measuredHeight / (float) imageHeight;
		}
		
		protected void computeStartingScale(int imageWidth, int imageHeight, int measuredWidth, int measuredHeight) {
			switch(getScaleType()) {
				case CENTER: 
				startingScale = 1.0f;
				break;
				case CENTER_CROP: 
				startingScale = Math.max((float) measuredHeight / (float) imageHeight, (float) measuredWidth/ (float) imageWidth);
				break;
				case CENTER_INSIDE: 
				float wRatio = (float) imageWidth / (float) measuredWidth;
				float hRatio = (float) imageHeight / (float) measuredHeight;
				if(wRatio > hRatio) {
					startingScale = fitScaleHorizontal;
				} else {
					startingScale = fitScaleVertical;
				}
				break;
			} }
		
		protected boolean isRecycled() {
			if(drawable != null && drawable instanceof android.graphics.drawable.BitmapDrawable) {
				Bitmap bitmap = ((android.graphics.drawable.BitmapDrawable)drawable).getBitmap();
				if(bitmap != null) {
					return bitmap.isRecycled();
				} }
			return false;
		}
		
		protected void recycle() {
			if(recycle && drawable != null && drawable instanceof android.graphics.drawable.BitmapDrawable) {
				Bitmap bitmap = ((android.graphics.drawable.BitmapDrawable)drawable).getBitmap();
				if(bitmap != null) {
					bitmap.recycle();
				} } }
		
		@Override
		protected void onDraw(Canvas canvas) {
			if(layout) {
				if(drawable != null && !isRecycled()) {
					canvas.save();
					float adjustedScale = scale * scaleAdjust;
					canvas.translate(x, y);
					if(rotation != 0.0f) {
						canvas.rotate(rotation);
					}
					if(adjustedScale != 1.0f) {
						canvas.scale(adjustedScale, adjustedScale);
					}
					drawable.draw(canvas);
					canvas.restore();
				}
				if(drawLock.availablePermits() <= 0) {
					drawLock.release();
				} } }
		
		public boolean waitForDraw(long timeout) throws InterruptedException {
			return drawLock.tryAcquire(timeout, java.util.concurrent.TimeUnit.MILLISECONDS);
		}
		
		@Override
		protected void onAttachedToWindow() {
			animator = new Animator(this, "GestureImageViewAnimator");
			animator.start();
			if(resId >= 0 && drawable == null) {
				setImageResource(resId);
			}
			super.onAttachedToWindow();
		}
		
		public void animationStart(Animation animation) {
			if(animator != null) {
				animator.play(animation);
			} }
		
		public void animationStop() {
			if(animator != null) {
				animator.cancel();
			} }
		
		@Override protected void onDetachedFromWindow() {
			if(animator != null) {
				animator.finish();
			}
			if(recycle && drawable != null && !isRecycled()) {
				recycle();
				drawable = null;
			}
			super.onDetachedFromWindow();
		}
		
		protected void initImage() {
			if(this.drawable != null) {
				this.drawable.setAlpha(alpha);
				this.drawable.setFilterBitmap(true);
				if(colorFilter != null) {
					this.drawable.setColorFilter(colorFilter);
				} }
			if(!layout) {
				requestLayout();
				redraw();
			} }
		
		public void setImageBitmap(Bitmap image) {
			this.drawable = new android.graphics.drawable.BitmapDrawable(getResources(), image);
			initImage();
		}
		
		@Override
		public void setImageDrawable(android.graphics.drawable.Drawable drawable) {
			this.drawable = drawable;
			initImage();
		}
		
		public void setImageResource(int id) {
			if(this.drawable != null) {
				this.recycle();
			}
			if(id >= 0) {
				this.resId = id;
				setImageDrawable(getContext().getResources().getDrawable(id));
			} }
		
		public int getScaledWidth() {
			return Math.round(getImageWidth() * getScale());
		}
		
		public int getScaledHeight() {
			return Math.round(getImageHeight() * getScale());
		}
		
		public int getImageWidth() {
			if(drawable != null) {
				return drawable.getIntrinsicWidth();
			}
			return 0;
		}
		
		public int getImageHeight() {
			if(drawable != null) {
				return drawable.getIntrinsicHeight();
			}
			return 0;
		}
		
		public void moveBy(float x, float y) {
			this.x += x;
			this.y += y;
		}
		
		public void setPosition(float x, float y) {
			this.x = x;
			this.y = y;
		}
		
		public void redraw() {
			postInvalidate();
		}
		
		public void setMinScale(float min) {
			this.minScale = min;
			if(gestureImageViewTouchListener != null) {
				gestureImageViewTouchListener.setMinScale(min * fitScaleHorizontal);
			} }
		
		public void setMaxScale(float max) {
			this.maxScale = max;
			if(gestureImageViewTouchListener != null) {
				gestureImageViewTouchListener.setMaxScale(max * startingScale);
			} }
		
		public void setScale(float scale) {
			scaleAdjust = scale;
		}
		
		public float getScale() {
			return scaleAdjust;
		}
		
		public float getImageX() {
			return x;
		}
		
		public float getImageY() {
			return y;
		}
		
		public boolean isStrict() {
			return strict;
		}
		
		public void setStrict(boolean strict) {
			this.strict = strict;
		}
		
		public boolean isRecycle() {
			return recycle;
		}
		
		public void setRecycle(boolean recycle) {
			this.recycle = recycle;
		}
		
		public void reset() {
			x = centerX;
			y = centerY;
			scaleAdjust = startingScale;
			if (gestureImageViewTouchListener != null) {
				gestureImageViewTouchListener.reset();
			}
			redraw();
		}
		
		public void setRotation(float rotation) {
			this.rotation = rotation;
		}
		
		public void setGestureImageViewListener(GestureImageViewListener pinchImageViewListener) {
			this.gestureImageViewListener = pinchImageViewListener;
		}
		
		public GestureImageViewListener getGestureImageViewListener() {
			return gestureImageViewListener;
		}
		
		@Override
		public android.graphics.drawable.Drawable getDrawable() {
			return drawable;
		}
		
		@Override
		public void setAlpha(int alpha) {
			this.alpha = alpha;
			if(drawable != null) {
				drawable.setAlpha(alpha);
			} }
		
		@Override public void setColorFilter(ColorFilter cf) {
			this.colorFilter = cf;
			if(drawable != null) {
				drawable.setColorFilter(cf);
			} }
		
		@Override
		public void setImageURI(Uri mUri) {
			if ("content".equals(mUri.getScheme())) {
				try {
					String[] orientationColumn = {android.provider.MediaStore.Images.Media.ORIENTATION};
					android.database.Cursor cur = getContext().getContentResolver().query(mUri, orientationColumn, null, null, null);
					if (cur != null && cur.moveToFirst()) {
						imageOrientation = cur.getInt(cur.getColumnIndex(orientationColumn[0]));
					}
					java.io.InputStream in = null;
					try {
						in = getContext().getContentResolver().openInputStream(mUri);
						Bitmap bmp = BitmapFactory.decodeStream(in);
						if(imageOrientation != 0) {
							Matrix m = new Matrix();
							m.postRotate(imageOrientation);
							Bitmap rotated = Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth(), bmp.getHeight(), m, true);
							bmp.recycle();
							setImageDrawable(new android.graphics.drawable.BitmapDrawable(getResources(), rotated));
						} else {
							setImageDrawable(new android.graphics.drawable.BitmapDrawable(getResources(), bmp));
						} } finally {
						if(in != null) {
							in.close();
						}
						if(cur != null) {
							cur.close();
						} } } catch (Exception e) {}
			} else {
				setImageDrawable(android.graphics.drawable.Drawable.createFromPath(mUri.toString()));
			}
			if (drawable == null) {
				mUri = null;
			} }
		
		@Override
		public Matrix getImageMatrix() {
			if(strict) {
				throw new UnsupportedOperationException("Not supported");
			}
			return super.getImageMatrix();
		}
		
		@Override
		public void setScaleType(ScaleType scaleType) {
			if(scaleType == ScaleType.CENTER || scaleType == ScaleType.CENTER_CROP || scaleType == ScaleType.CENTER_INSIDE) {
				super.setScaleType(scaleType);
			} else if(strict) {
				throw new UnsupportedOperationException("Not supported");
			} }
		
		@Override
		public void invalidateDrawable(android.graphics.drawable.Drawable dr) {
			if(strict) {
				throw new UnsupportedOperationException("Not supported");
			}
			super.invalidateDrawable(dr);
		}
		
		@Override
		public int[] onCreateDrawableState(int extraSpace) {
			if(strict) {
				throw new UnsupportedOperationException("Not supported");
			}
			return super.onCreateDrawableState(extraSpace);
		}
		
		@Override
		public void setAdjustViewBounds(boolean adjustViewBounds) {
			if(strict) {
				throw new UnsupportedOperationException("Not supported");
			}
			super.setAdjustViewBounds(adjustViewBounds);
		}
		
		@Override
		public void setImageLevel(int level) {
			if(strict) {
				throw new UnsupportedOperationException("Not supported");
			}
			super.setImageLevel(level);
		}
		
		@Override
		public void setImageMatrix(Matrix matrix) {
			if(strict) {
				throw new UnsupportedOperationException("Not supported");
			} }
		
		@Override
		public void setImageState(int[] state, boolean merge) {
			if(strict) {
				throw new UnsupportedOperationException("Not supported");
			} }
		
		@Override
		public void setSelected(boolean selected) {
			if(strict) {
				throw new UnsupportedOperationException("Not supported");
			}
			super.setSelected(selected);
		}
		
		@Override
		public void setOnTouchListener(OnTouchListener l) {
			this.customOnTouchListener = l;
		}
		
		public float getCenterX() {
			return centerX;
		}
		
		public float getCenterY() {
			return centerY;
		}
		
		public boolean isLandscape() {
			return getImageWidth() >= getImageHeight();
		}
		
		public boolean isPortrait() {
			return getImageWidth() <= getImageHeight();
		}
		
		public void setStartingScale(float startingScale) {
			this.startingScale = startingScale;
		}
		
		public void setStartingPosition(float x, float y) {
			this.startX = x;
			this.startY = y;
		}
		
		@Override
		public void setOnClickListener(OnClickListener l) {
			this.onClickListener = l;
			if(gestureImageViewTouchListener != null) {
				gestureImageViewTouchListener.setOnClickListener(l);
			} }
		
		public boolean isOrientationAligned() {
			if(deviceOrientation == android.content.res.Configuration.ORIENTATION_LANDSCAPE) {
				return isLandscape();
			} else if(deviceOrientation == android.content.res.Configuration.ORIENTATION_PORTRAIT) {
				return isPortrait();
			}
			return true;
		}
		
		public int getDeviceOrientation() {
			return deviceOrientation;
		}}
	public static interface GestureImageViewListener {
		public void onTouch(float x, float y);
		public void onScale(float scale);
		public void onPosition(float x, float y);
	}
	public static class GestureImageViewTouchListener implements OnTouchListener {
		private GestureImageView image;
		private OnClickListener onClickListener;
		private final PointF current = new PointF();
		private final PointF last = new PointF();
		private final PointF next = new PointF();
		private final PointF midpoint = new PointF();
		private final VectorF scaleVector = new VectorF();
		private final VectorF pinchVector = new VectorF();
		private boolean touched = false;
		private boolean inZoom = false;
		private float initialDistance;
		private float lastScale = 1.0f;
		private float currentScale = 1.0f;
		private float boundaryLeft = 0;
		private float boundaryTop = 0;
		private float boundaryRight = 0;
		private float boundaryBottom = 0;
		private float maxScale = 5.0f;
		private float minScale = 0.25f;
		private float fitScaleHorizontal = 1.0f;
		private float fitScaleVertical = 1.0f;
		private int canvasWidth = 0;
		private int canvasHeight = 0;
		private float centerX = 0;
		private float centerY = 0;
		private float startingScale = 0;
		private boolean canDragX = false;
		private boolean canDragY = false;
		private boolean multiTouch = false;
		private int displayWidth;
		private int displayHeight;
		private int imageWidth;
		private int imageHeight;
		private FlingListener flingListener;
		private FlingAnimation flingAnimation;
		private ZoomAnimation zoomAnimation;
		private MoveAnimation moveAnimation;
		private GestureDetector tapDetector;
		private GestureDetector flingDetector;
		private GestureImageViewListener imageListener;
		
		public GestureImageViewTouchListener(final GestureImageView image, int displayWidth, int displayHeight) {
			super();
			this.image = image;
			this.displayWidth = displayWidth;
			this.displayHeight = displayHeight;
			this.centerX = (float) displayWidth / 2.0f;
			this.centerY = (float) displayHeight / 2.0f;
			this.imageWidth = image.getImageWidth();
			this.imageHeight = image.getImageHeight();
			startingScale = image.getScale();
			currentScale = startingScale;
			lastScale = startingScale;
			boundaryRight = displayWidth;
			boundaryBottom = displayHeight;
			boundaryLeft = 0;
			boundaryTop = 0;
			next.x = image.getImageX();
			next.y = image.getImageY();
			flingListener = new FlingListener();
			flingAnimation = new FlingAnimation();
			zoomAnimation = new ZoomAnimation();
			moveAnimation = new MoveAnimation();
			flingAnimation.setListener(new FlingAnimationListener() {
				@Override
				public void onMove(float x, float y) {
					handleDrag(current.x + x, current.y + y);
				}
				@Override
				public void onComplete() {}
			});
			zoomAnimation.setZoom(2.0f);
			zoomAnimation.setZoomAnimationListener(new ZoomAnimationListener() {
				@Override
				public void onZoom(float scale, float x, float y) {
					if(scale <= maxScale && scale >= minScale) {
						handleScale(scale, x, y);
					}
				}
				@Override
				public void onComplete() {
					inZoom = false;
					handleUp();
				}
			});
			moveAnimation.setMoveAnimationListener(new MoveAnimationListener() {
				@Override
				public void onMove(float x, float y) {
					image.setPosition(x, y);
					image.redraw();
				}
			});
			tapDetector = new GestureDetector(image.getContext(), new android.view.GestureDetector.SimpleOnGestureListener() {
				@Override
				public boolean onDoubleTap(MotionEvent e) {
					startZoom(e);
					return true;
				}
				@Override
				public boolean onSingleTapConfirmed(MotionEvent e) {
					if(!inZoom) {
						if(onClickListener != null) {
							onClickListener.onClick(image);
							return true;
						}
					}
					return false;
				}
			});
			flingDetector = new GestureDetector(image.getContext(), flingListener);
			imageListener = image.getGestureImageViewListener();
			calculateBoundaries();
		}
		
		private void startFling() {
			flingAnimation.setVelocityX(flingListener.getVelocityX());
			flingAnimation.setVelocityY(flingListener.getVelocityY());
			image.animationStart(flingAnimation);
		}
		
		private void startZoom(MotionEvent e) {
			inZoom = true;
			zoomAnimation.reset();
			float zoomTo;
			if(image.isLandscape()) {
				if(image.getDeviceOrientation() == android.content.res.Configuration.ORIENTATION_PORTRAIT) {
					int scaledHeight = image.getScaledHeight();
					if(scaledHeight < canvasHeight) {
						zoomTo = fitScaleVertical / currentScale;
						zoomAnimation.setTouchX(e.getX());
						zoomAnimation.setTouchY(image.getCenterY());
					} else {
						zoomTo = fitScaleHorizontal / currentScale;
						zoomAnimation.setTouchX(image.getCenterX());
						zoomAnimation.setTouchY(image.getCenterY());
					}
				} else {
					int scaledWidth = image.getScaledWidth();
					if(scaledWidth == canvasWidth) {
						zoomTo = currentScale*4.0f;
						zoomAnimation.setTouchX(e.getX());
						zoomAnimation.setTouchY(e.getY());
					} else if(scaledWidth < canvasWidth) {
						zoomTo = fitScaleHorizontal / currentScale;
						zoomAnimation.setTouchX(image.getCenterX());
						zoomAnimation.setTouchY(e.getY());
					} else {
						zoomTo = fitScaleHorizontal / currentScale;
						zoomAnimation.setTouchX(image.getCenterX());
						zoomAnimation.setTouchY(image.getCenterY());
					}
				}
			} else {
				if(image.getDeviceOrientation() == android.content.res.Configuration.ORIENTATION_PORTRAIT) {
					int scaledHeight = image.getScaledHeight();
					if(scaledHeight == canvasHeight) {
						zoomTo = currentScale*4.0f;
						zoomAnimation.setTouchX(e.getX());
						zoomAnimation.setTouchY(e.getY());
					} else if(scaledHeight < canvasHeight) {
						zoomTo = fitScaleVertical / currentScale;
						zoomAnimation.setTouchX(e.getX());
						zoomAnimation.setTouchY(image.getCenterY());
					} else {
						zoomTo = fitScaleVertical / currentScale;
						zoomAnimation.setTouchX(image.getCenterX());
						zoomAnimation.setTouchY(image.getCenterY());
					}
				} else {
					int scaledWidth = image.getScaledWidth();
					if(scaledWidth < canvasWidth) {
						zoomTo = fitScaleHorizontal / currentScale;
						zoomAnimation.setTouchX(image.getCenterX());
						zoomAnimation.setTouchY(e.getY());
					} else {
						zoomTo = fitScaleVertical / currentScale;
						zoomAnimation.setTouchX(image.getCenterX());
						zoomAnimation.setTouchY(image.getCenterY());
					}
				}
			}
			zoomAnimation.setZoom(zoomTo);
			image.animationStart(zoomAnimation);
		}
		
		private void stopAnimations() {
			image.animationStop();
		}
		
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			if(!inZoom) {
				if(!tapDetector.onTouchEvent(event)) {
					if(event.getPointerCount() == 1 && flingDetector.onTouchEvent(event)) {
						startFling();
					}
					if(event.getAction() == MotionEvent.ACTION_UP) {
						handleUp();
					} else if(event.getAction() == MotionEvent.ACTION_DOWN) {
						stopAnimations();
						last.x = event.getX();
						last.y = event.getY();
						if(imageListener != null) {
							imageListener.onTouch(last.x, last.y);
						}
						touched = true;
					} else if(event.getAction() == MotionEvent.ACTION_MOVE) {
						if(event.getPointerCount() > 1) {
							multiTouch = true;
							if(initialDistance > 0) {
								pinchVector.set(event);
								pinchVector.calculateLength();
								float distance = pinchVector.length;
								if(initialDistance != distance) {
									float newScale = (distance / initialDistance) * lastScale;
									if(newScale <= maxScale) {
										scaleVector.length *= newScale;
										scaleVector.calculateEndPoint();
										scaleVector.length /= newScale;
										float newX = scaleVector.end.x;
										float newY = scaleVector.end.y;
										handleScale(newScale, newX, newY);
									} } } else {
								initialDistance = MathUtils.distance(event);
								MathUtils.midpoint(event, midpoint);
								scaleVector.setStart(midpoint);
								scaleVector.setEnd(next);
								scaleVector.calculateLength();
								scaleVector.calculateAngle();
								scaleVector.length /= lastScale;
							}
						} else {
							if(!touched) {
								touched = true;
								last.x = event.getX();
								last.y = event.getY();
								next.x = image.getImageX();
								next.y = image.getImageY();
							} else if(!multiTouch) {
								if(handleDrag(event.getX(), event.getY())) {
									image.redraw();
								} } } } } }
			return true;
		}
		
		protected void handleUp() {
			multiTouch = false;
			initialDistance = 0;
			lastScale = currentScale;
			if(!canDragX) {
				next.x = centerX;
			}
			if(!canDragY) {
				next.y = centerY;
			}
			boundCoordinates();
			if(!canDragX && !canDragY) {
				if(image.isLandscape()) {
					currentScale = fitScaleHorizontal;
					lastScale = fitScaleHorizontal;
				} else {
					currentScale = fitScaleVertical;
					lastScale = fitScaleVertical;
				} }
			image.setScale(currentScale);
			image.setPosition(next.x, next.y);
			if(imageListener != null) {
				imageListener.onScale(currentScale);
				imageListener.onPosition(next.x, next.y);
			}
			image.redraw();
		}
		
		protected void handleScale(float scale, float x, float y) {
			currentScale = scale;
			if(currentScale > maxScale) {
				currentScale = maxScale;
			} else if (currentScale < minScale) {
				currentScale = minScale;
			} else {
				next.x = x;
				next.y = y;
			}
			calculateBoundaries();
			image.setScale(currentScale);
			image.setPosition(next.x, next.y);
			if(imageListener != null) {
				imageListener.onScale(currentScale);
				imageListener.onPosition(next.x, next.y);
			}
			image.redraw();
		}
		
		protected boolean handleDrag(float x, float y) {
			current.x = x;
			current.y = y;
			float diffX = (current.x - last.x);
			float diffY = (current.y - last.y);
			if(diffX != 0 || diffY != 0) {
				if(canDragX) next.x += diffX;
				if(canDragY) next.y += diffY;
				boundCoordinates();
				last.x = current.x;
				last.y = current.y;
				if(canDragX || canDragY) {
					image.setPosition(next.x, next.y);
					if(imageListener != null) {
						imageListener.onPosition(next.x, next.y);
					}
					return true;
				} }
			return false;
		}
		
		public void reset() {
			currentScale = startingScale;
			next.x = centerX;
			next.y = centerY;
			calculateBoundaries();
			image.setScale(currentScale);
			image.setPosition(next.x, next.y);
			image.redraw();
		}
		
		public float getMaxScale() {
			return maxScale;
		}
		
		public void setMaxScale(float maxScale) {
			this.maxScale = maxScale;
		}
		
		public float getMinScale() {
			return minScale;
		}
		
		public void setMinScale(float minScale) {
			this.minScale = minScale;
		}
		
		public void setOnClickListener(OnClickListener onClickListener) {
			this.onClickListener = onClickListener;
		}
		
		protected void setCanvasWidth(int canvasWidth) {
			this.canvasWidth = canvasWidth;
		}
		
		protected void setCanvasHeight(int canvasHeight) {
			this.canvasHeight = canvasHeight;
		}
		
		protected void setFitScaleHorizontal(float fitScale) {
			this.fitScaleHorizontal = fitScale;
		}
		
		protected void setFitScaleVertical(float fitScaleVertical) {
			this.fitScaleVertical = fitScaleVertical;
		}
		
		protected void boundCoordinates() {
			if(next.x < boundaryLeft) {
				next.x = boundaryLeft;
			} else if(next.x > boundaryRight) {
				next.x = boundaryRight;
			}
			if(next.y < boundaryTop) {
				next.y = boundaryTop;
			} else if(next.y > boundaryBottom) {
				next.y = boundaryBottom;
			} }
		
		protected void calculateBoundaries() {
			int effectiveWidth = Math.round( (float) imageWidth * currentScale );
			int effectiveHeight = Math.round( (float) imageHeight * currentScale );
			canDragX = effectiveWidth > displayWidth;
			canDragY = effectiveHeight > displayHeight;
			if(canDragX) {
				float diff = (float)(effectiveWidth - displayWidth) / 2.0f;
				boundaryLeft = centerX - diff;
				boundaryRight = centerX + diff;
			}
			if(canDragY) {
				float diff = (float)(effectiveHeight - displayHeight) / 2.0f;
				boundaryTop = centerY - diff;
				boundaryBottom = centerY + diff;
			} } }
	public static class MathUtils {
		
		public static float distance(MotionEvent event) {
			float x = event.getX(0) - event.getX(1);
			float y = event.getY(0) - event.getY(1);
			return (float)Math.sqrt(x * x + y * y);
		}
		
		public static float distance(PointF p1, PointF p2) {
			float x = p1.x - p2.x;
			float y = p1.y - p2.y;
			return (float)Math.sqrt(x * x + y * y);
		}
		
		public static float distance(float x1, float y1, float x2, float y2) {
			float x = x1 - x2;
			float y = y1 - y2;
			return (float)Math.sqrt(x * x + y * y);
		}
		
		public static void midpoint(MotionEvent event, PointF point) {
			float x1 = event.getX(0);
			float y1 = event.getY(0);
			float x2 = event.getX(1);
			float y2 = event.getY(1);
			midpoint(x1, y1, x2, y2, point);
		}
		
		public static void midpoint(float x1, float y1, float x2, float y2, PointF point) {
			point.x = (x1 + x2) / 2.0f;
			point.y = (y1 + y2) / 2.0f;
		}
		
		public void rotate(PointF p1, PointF p2, float angle) {
			float px = p1.x;
			float py = p1.y;
			float ox = p2.x;
			float oy = p2.y;
			p1.x = ((float)Math.cos(angle) * (px-ox) - (float)Math.sin(angle) * (py-oy) + ox);
			p1.y = ((float)Math.sin(angle) * (px-ox) + (float)Math.cos(angle) * (py-oy) + oy);
		}
		
		public static float angle(PointF p1, PointF p2) {
			return angle(p1.x, p1.y, p2.x, p2.y);
		}
		
		public static float angle(float x1, float y1, float x2, float y2) {
			return (float) Math.atan2(y2 - y1, x2 - x1);
		}
	}
	public static class MoveAnimation implements Animation {
		private boolean firstFrame = true;
		private float startX;
		private float startY;
		private float targetX;
		private float targetY;
		private long animationTimeMS = 100;
		private long totalTime = 0;
		private MoveAnimationListener moveAnimationListener;
		
		@Override
		public boolean update(GestureImageView view, long time) {	
			totalTime += time;
			if(firstFrame) {
				firstFrame = false;
				startX = view.getImageX();
				startY = view.getImageY();
			}
			if(totalTime < animationTimeMS) {
				float ratio = (float) totalTime / animationTimeMS;
				float newX = ((targetX - startX) * ratio) + startX;
				float newY = ((targetY - startY) * ratio) + startY;
				if(moveAnimationListener != null) {
					moveAnimationListener.onMove(newX, newY);
				} return true; }		else {
				if(moveAnimationListener != null) {
					moveAnimationListener.onMove(targetX, targetY);
				} } return false;
		}
		
		public void reset() {
			firstFrame = true;
			totalTime = 0;
		}
		
		public float getTargetX() {
			return targetX;
		}
		
		public void setTargetX(float targetX) {
			this.targetX = targetX;
		}
		
		public float getTargetY() {
			return targetY;
		}
		
		public void setTargetY(float targetY) {
			this.targetY = targetY;
		}
		
		public long getAnimationTimeMS() {
			return animationTimeMS;
		}
		
		public void setAnimationTimeMS(long animationTimeMS) {
			this.animationTimeMS = animationTimeMS;
		}
		
		public void setMoveAnimationListener(MoveAnimationListener moveAnimationListener) {
			this.moveAnimationListener = moveAnimationListener;
		}
	}
	public static interface MoveAnimationListener {
		public void onMove(float x, float y);
	}
	public static class VectorF {	
		public float angle;
		public float length;
		public final PointF start = new PointF();
		public final PointF end = new PointF();
		
		public void calculateEndPoint() {
			end.x = (float)Math.cos(angle) * length + start.x;
			end.y = (float)Math.sin(angle) * length + start.y;
		}
		
		public void setStart(PointF p) {
			this.start.x = p.x;	
			this.start.y = p.y;	
		}
		
		public void setEnd(PointF p) {
			this.end.x = p.x;
			this.end.y = p.y;
		}
		
		public void set(MotionEvent event) {
			this.start.x = event.getX(0);
			this.start.y = event.getY(0);
			this.end.x = event.getX(1);
			this.end.y = event.getY(1);
		}
		
		public float calculateLength() {
			length = MathUtils.distance(start, end);
			return length;	
		}
		
		public float calculateAngle() {
			angle = MathUtils.angle(start, end);
			return angle;
		}
	}
	public static class ZoomAnimation implements Animation {
		private boolean firstFrame = true;
		private float touchX;
		private float touchY;
		private float zoom;
		private float startX;
		private float startY;
		private float startScale;	
		private float xDiff;
		private float yDiff;
		private float scaleDiff;
		private long animationLengthMS = 200;
		private long totalTime = 0;
		private ZoomAnimationListener zoomAnimationListener;
		
		@Override
		public boolean update(GestureImageView view, long time) {	
			if(firstFrame) {
				firstFrame = false;
				startX = view.getImageX();
				startY = view.getImageY();
				startScale = view.getScale();
				scaleDiff = (zoom * startScale) - startScale;						if(scaleDiff > 0) {
					VectorF vector = new VectorF();
					vector.setStart(new PointF(touchX, touchY));				vector.setEnd(new PointF(startX, startY));											vector.calculateAngle();
					float length = vector.calculateLength();
					vector.length = length*zoom;
					vector.calculateEndPoint();
					xDiff = vector.end.x - startX;
					yDiff = vector.end.y - startY;
				} else {
					xDiff = view.getCenterX() - startX;
					yDiff = view.getCenterY() - startY;
				} }
			totalTime += time;
			float ratio = (float) totalTime / (float) animationLengthMS;
			if(ratio < 1) {
				if(ratio > 0) {
					float newScale = (ratio * scaleDiff) + startScale;				float newX = (ratio * xDiff) + startX;	
					float newY = (ratio * yDiff) + startY;								if(zoomAnimationListener != null) {					zoomAnimationListener.onZoom(newScale, newX, newY);
					} } return true; }	 else {
				float newScale = scaleDiff + startScale;
				float newX = xDiff + startX;
				float newY = yDiff + startY; 			if(zoomAnimationListener != null) {				zoomAnimationListener.onZoom(newScale, newX, newY);
					zoomAnimationListener.onComplete();
				}
				return false;
			}}
		
		public void reset() {
			firstFrame = true;
			totalTime = 0;
		}
		
		public float getZoom() {
			return zoom;
		}
		
		public void setZoom(float zoom) {
			this.zoom = zoom;
		}
		
		public float getTouchX() {
			return touchX;
		}
		
		public void setTouchX(float touchX) {
			this.touchX = touchX;
		}
		
		public float getTouchY() {
			return touchY;
		}
		
		public void setTouchY(float touchY) {
			this.touchY = touchY;
		}
		
		public long getAnimationLengthMS() {	
			return animationLengthMS;
		}
		
		public void setAnimationLengthMS(long animationLengthMS) {
			this.animationLengthMS = animationLengthMS;
		}
		
		public ZoomAnimationListener getZoomAnimationListener() {
			return zoomAnimationListener;
		}
		
		public void setZoomAnimationListener(ZoomAnimationListener zoomAnimationListener) {		this.zoomAnimationListener = zoomAnimationListener;
		}
	}
	public static interface ZoomAnimationListener {
		public void onZoom(float scale, float x, float y);
		public void onComplete();
	}
	
	
	public void _makeObjectMoveable(final View _object) {
		if (!animbivot) {
			_object.setOnTouchListener(new OnTouchListener() {
				
				PointF DownPT = new PointF();
				
				PointF StartPT = new PointF();
				
				@Override public boolean onTouch(View v, MotionEvent event) {
					
					int eid = event.getAction();
					
					switch (eid) {
						
						case MotionEvent.ACTION_MOVE:PointF mv = new PointF(event.getX() - DownPT.x, event.getY() - DownPT.y);
						
						if(!animbivot){
							_object.setX((int)(StartPT.x+mv.x));
							
							_object.setY((int)(StartPT.y+mv.y));
							
							StartPT = new PointF(_object.getX(), _object.getY());
						}
						break;
						
						case MotionEvent.ACTION_DOWN : DownPT.x = event.getX();
						
						DownPT.y = event.getY();
						
						StartPT = new PointF(_object.getX(), _object.getY());
						
						break;
						
						case MotionEvent.ACTION_UP : break;
						
						default : break;
						
					}
					
					return true;
					
				}
				
			});
			
			
		}
	}
	
	
	public void _out() {
		final AlphaAnimation fadeInn = new AlphaAnimation(1.0f,0.0f);
		final AlphaAnimation fadeOutn = new AlphaAnimation(0.0f,1.0f);
		
		linear5.startAnimation(fadeInn);
		linear5.startAnimation(fadeOutn);
		fadeInn.setDuration(1000);
		fadeInn.setFillAfter(true);
		fadeOutn.setDuration(1000);
		fadeOutn.setFillAfter(true);
		fadeOutn.setStartOffset(10+fadeInn.getStartOffset());
		final AlphaAnimation fadeIn = new AlphaAnimation(1.0f,0.0f);
		final AlphaAnimation fadeOut = new AlphaAnimation(0.0f,1.0f);
		
		imageview4.startAnimation(fadeIn);
		imageview4.startAnimation(fadeOut);
		fadeIn.setDuration(1000);
		fadeIn.setFillAfter(true);
		fadeOut.setDuration(1000);
		fadeOut.setFillAfter(true);
		fadeOut.setStartOffset(10+fadeIn.getStartOffset());
	}
	
	
	public void _in() {
		final AlphaAnimation fadeInn = new AlphaAnimation(0.0f,1.0f);
		final AlphaAnimation fadeOutn = new AlphaAnimation(1.0f,0.0f);
		
		linear5.startAnimation(fadeInn);
		linear5.startAnimation(fadeOutn);
		fadeInn.setDuration(1);
		fadeInn.setFillAfter(true);
		fadeOutn.setDuration(1);
		fadeOutn.setFillAfter(true);
		fadeOutn.setStartOffset(10+fadeInn.getStartOffset());
		final AlphaAnimation fadeIn = new AlphaAnimation(0.0f,1.0f);
		final AlphaAnimation fadeOut = new AlphaAnimation(1.0f,0.0f);
		
		imageview4.startAnimation(fadeIn);
		imageview4.startAnimation(fadeOut);
		fadeIn.setDuration(1);
		fadeIn.setFillAfter(true);
		fadeOut.setDuration(1);
		fadeOut.setFillAfter(true);
		fadeOut.setStartOffset(10+fadeIn.getStartOffset());
	}
	
	
	public void _jsons() {
		if (chapter_count.equals("1")) {
			if (save.getString("lang", "").equals("ru")) {
				list_texts.add("Сразу, как я начал хоть что-то ощущать, навалилась тишина..");
				list_texts.add("Глаза пока что не решался открыть, но было нехорошее ощущение, что увижу я далеко не переулок у станции метро..");
				list_texts.add("Все что помню, только вышел с «Гагаринской» и почувствовал странный металлический привкус во рту");
				list_texts.add("Даже сквозь закрытые веки виднелось тлеюще-красное освещение в комнате.");
				list_texts.add("Впрочем, глаза открылись сами, вероятно затекли мышцы и дернулись");
				list_texts.add("Темно-красная пелена разошлась, открыв вид на пустой коридор");
				list_texts.add("Попади я сюда в более мирных условиях, даже назвал бы его красивым");
				list_texts.add("Разумеется, при себе у меня только пара тряпок которые с натяжкой можно назвать одеждой.");
				list_texts.add("Стоило бы осмотреться..");
				list_texts.add("...");
				list_texts.add("Единственное хоть сколько-то нужное сейчас это ключ");
				list_texts.add("На вид, если я его возьму, ничего плохого не случится");
				list_texts.add("Но всё же... надо быть максимально осторожным здесь");
				list_texts.add("И всё же, надо проявлять осторожность в таких ситуациях");
				list_texts.add("Но ведь помимо ключа в этом коридоре ничего нету...");
				list_texts.add("Не хотелось бы застрять тут на целую вечность и умереть от голода, в конце концов.");
				list_texts.add("В комнате три двери, к какой-то то из них ключ точно подойдёт");
				list_texts.add("...");
				list_texts.add("Поддалась только самая дальняя");
				list_texts.add("За дверью была комната с лестницей на второй этаж в похожей стиллистике");
				list_texts.add("Есть старый телевизор. Без пульта. На 2 этаж подняться никак, дверь закрыта. Пойду посмотрю другую комнату");
				list_texts.add("...");
				list_texts.add("Это простая кухня, а ещё здесь есть много шкафчиков..");
				list_texts.add("Я нашел ключ! Вероятно, он от следующей комнаты.");
				list_texts.add("Это кладовая.");
				list_texts.add("...");
				list_texts.add("Я здесь не один? Я слышал как кто-то открыл дверь на второй этаж.. Как бы мне не хотелось, но надо проверить!");
				list_texts.add("Точь в точь такой же коридор, странно...");
			}
			else {
				list_texts.add("As soon as I began to feel something, silence fell");
				list_texts.add("I didn’t dare to open my eyes yet, but I had a bad feeling that I would see far from the lane near the metro station ..");
				list_texts.add("All I remember is that I just left the Gagarinskaya and felt a strange metallic taste in my mouth.");
				list_texts.add("Even through his closed eyes, he could see the smoldering red lighting in the room.");
				list_texts.add("However, the eyes opened on their own, probably the muscles were numb and twitched.");
				list_texts.add("The dark red veil parted, revealing a view of an empty corridor");
				list_texts.add("If I got here in more peaceful conditions, I would even call it beautiful");
				list_texts.add("Of course, I only have a couple of rags with me, which can hardly be called clothes.");
				list_texts.add("Worth a look..");
				list_texts.add("...");
				list_texts.add("The only thing that stands out is the key");
				list_texts.add("In appearance, if I take it, nothing bad will happen");
				list_texts.add("But still... I have to be as careful as possible here.");
				list_texts.add("However, caution must be exercised in such situations.");
				list_texts.add("But besides the key, there is nothing in this corridor...");
				list_texts.add("I wouldn't want to be stuck here for all eternity and starve to death in the end.");
				list_texts.add("There are only three doors in the room, it remains only to select the key to these doors.");
				list_texts.add("...");
				list_texts.add("Only the furthest succumbed");
				list_texts.add("Behind the door was a room with a staircase to the second floor in a very similar style.");
				list_texts.add("There is an old TV, without a remote control, there is no way to go up to the 2nd floor, the door to the 2nd floor is closed. I'll go see another room");
				list_texts.add("...");
				list_texts.add("This is a simple kitchen, and there are a lot of cabinets..");
				list_texts.add("I found the key! It's probably from the next room.");
				list_texts.add("This is a storeroom.");
				list_texts.add("...");
				list_texts.add("Am I not alone here? I heard someone open the door to the second floor .. As much as I would not like, but I need to check!");
				list_texts.add("Exactly the same corridor, strange...");
			}
		}
		if (chapter_count.equals("2")) {
			if (save.getString("lang", "").equals("ru")) {
				list_texts.add("Дует ветер *");
				list_texts.add("Прохладно... Где-то, видимо, есть окно");
				list_texts.add("...");
				list_texts.add("Похоже, что нет..");
				list_texts.add("Почему так сильно пахнет тухлятиной!?");
				list_texts.add("Вероятно, этот запах идет из комнат");
				list_texts.add("Осторожность - главный фактор долгой жизни...");
				list_texts.add("... Но уж точно не в этот момент");
				list_texts.add("Мне нужно разгадывать эту головоломку... как я сюда попал?... кому это нужно было?...");
				list_texts.add("Я не могу сидеть без дела в любом случае.");
				list_texts.add("...");
				list_texts.add("ЧТО ЗДЕСЬ ПРОИСХОДИТ!?");
				list_texts.add("Такое чувство, что...");
				list_texts.add("...Это всё сделано специально...");
				list_texts.add("Скорее всего кто-то хочет надо мной посмеяться... ");
				list_texts.add("Но почему именно я?..");
				list_texts.add("Есть огромное количество людей, которые подходят под этот «прикол»");
				list_texts.add("Наверное я значущая фигура на шахматной доске");
				list_texts.add("Помнил бы, что я употреблял в последние дни на свободе...");
				list_texts.add("Тогда бы всё наладилось, и я бы понял в чём причина");
				list_texts.add("Ладно, чем быстрее я уйду отсюда, тем быстрее я всё узнаю!!");
				list_texts.add("...");
				list_texts.add("Мне кажется, или в конце комнаты висит записка?...");
				list_texts.add("Вижу лист с надписью \"Рыба гниёт с головы\"... странно");
				list_texts.add("Как бы мне не хотелось, но стоит осмотреть черепа");
				list_texts.add("...");
				list_texts.add("Ого! Я нашёл ключ прямо внутри черепа... и кому это нужно было?..");
				list_texts.add("А если есть ключ, значит есть дверь для которую он открывает!");
				list_texts.add("Хм, а следующая дверь-то уже открыта..");
				list_texts.add("Ого! Да это же лифт! Шансы выбраться отсюда возрастают на тысячу процентов");
				list_texts.add("Или же нет.. похоже лифт не работает или в здании отключено электричество...");
				list_texts.add("В любом случае, нельзя терять времени!");
				list_texts.add("...");
				list_texts.add("Неужели это... Свобода?..");
				list_texts.add("Надеюсь у меня не галлюцинации и я и вправду вижу ночной город и луну");
				list_texts.add("Стоп... Что-то тут не так..");
				list_texts.add("..Это рисунок на стене?");
				list_texts.add("Меня развели как дурака!");
				list_texts.add("Надеюсь после моих мук и страданий я смогу найти ход на третий этаж");
				list_texts.add("Можно попробовать раскрыть шахту лифта");
				list_texts.add("Ага, нажал на кнопку вызова лифта и он открылся! Значит моя теория про временное отключения электричества была правдой");
				list_texts.add("И это значит, что за мной кто-то следит...");
				list_texts.add("Как я и предполагал, в лифте есть кнопка на третий этаж");
				list_texts.add("Ну, поехали!");
			}
			else {
				list_texts.add("The wind blows *");
				list_texts.add("It's cool... apparently there's an open window somewhere");
				list_texts.add("...");
				list_texts.add("Strange, I didn't find any window");
				list_texts.add("Why does it smell so strongly of rotten meat!?");
				list_texts.add("This smell is probably coming from the rooms.");
				list_texts.add("Caution is the main factor of long life...");
				list_texts.add("... But certainly not at this moment");
				list_texts.add("I need to solve this puzzle... how did I get here?... who needed this?...");
				list_texts.add("I can't sit around doing nothing anyway.");
				list_texts.add("...");
				list_texts.add("WHAT'S GOING ON HERE!?");
				list_texts.add("It feels like...");
				list_texts.add("It's all made on purpose...");
				list_texts.add("Someone probably wants to make fun of me... ");
				list_texts.add("But why me?");
				list_texts.add("There are a huge number of people who fit this \"joke\"");
				list_texts.add("I guess I'm a significant piece on the chessboard");
				list_texts.add("I would remember what I used in the last days at large ...");
				list_texts.add("Then everything would be fine, and I would understand the reason");
				list_texts.add("Okay, the sooner I get out of here, the sooner I'll find out!!");
				list_texts.add("...");
				list_texts.add("Is it just me or is there a note at the end of the room?");
				list_texts.add("I found a piece of paper that said \"The fish rots from the head\"... strange");
				list_texts.add("As much as I would not like, but it is worth examining the skulls");
				list_texts.add("...");
				list_texts.add("Wow! I found the key right inside the skull... and who needed it...?");
				list_texts.add("If there is a key, then there is a door for this key.");
				list_texts.add("Hmm, that door was open...");
				list_texts.add("Wow! Yes, it's an elevator! And this means that in this building there is also a third floor!");
				list_texts.add("Hmm, looks like the elevator isn't working, or the building's electricity is out...");
				list_texts.add("In any case, there is no time to waste!");
				list_texts.add("...");
				list_texts.add("Is this... Freedom?");
				list_texts.add("I hope I'm not hallucinating and I really see the night city and the moon");
				list_texts.add("Stop...Something's wrong here..");
				list_texts.add("It's a flat wall! It's a mirage!!!");
				list_texts.add("I was scammed like a fool!");
				list_texts.add("I hope after my torment and suffering I can find a way to the third floor");
				list_texts.add("You can try to open the elevator shaft");
				list_texts.add("Wow, I pressed the elevator call button and it opened! So my blackout theory was true.");
				list_texts.add("And that means someone is following me...");
				list_texts.add("As I expected, there is a button in the elevator to the third floor.");
				list_texts.add("Let's go!");
			}
		}
	}
	
	
	public void _ends() {
		if (media.isPlaying()) {
			media.pause();
			media.reset();
		}
		if (chapter_count.equals("1")) {
			save.edit().putString("save", "2").commit();
			win.putExtra("chapter", "2");
			win.setClass(getApplicationContext(), Main1Activity.class);
			win.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION); startActivityForResult(win, 0); overridePendingTransition(0,0);
			finish();
		}
		if (chapter_count.equals("2")) {
			save.edit().putString("save", "1").commit();
			win.putExtra("chap", "3");
			win.putExtra("end", "true");
			if (save.getString("lang", "").equals("ru")) {
				win.putExtra("chapter", "Глава пройдена!");
				win.putExtra("retitle", "Следующая глава находится в разработке.");
			}
			else {
				win.putExtra("chapter", "Chapter completed!");
				win.putExtra("retitle", "The next chapter is in development.");
			}
			win.setClass(getApplicationContext(), ChapterActivity.class);
			startActivity(win);
			finish();
		}
	}
	
	
	public void _thentimer() {
		if (chapter_count.equals("1")) {
			if (logs_chat == 3) {
				btnclck = true;
				didi = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								act1.setVisibility(View.VISIBLE);
								act2.setVisibility(View.VISIBLE);
								if (save.getString("lang", "").equals("ru")) {
									act2.setText("Открыть глаза");
									act1.setText("Ничего не делать ");
								}
								else {
									act2.setText("Open eyes");
									act1.setText("To do nothing ");
								}
							}
						});
					}
				};
				_timer.schedule(didi, (int)(1000));
			}
			if (logs_chat == 10) {
				btnclck = true;
				didi = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								act1.setVisibility(View.VISIBLE);
								act2.setVisibility(View.VISIBLE);
								if (save.getString("lang", "").equals("ru")) {
									act1.setText("Взять ключ");
									act2.setText("Не трогать ключ");
								}
								else {
									act1.setText("Take the key");
									act2.setText("Don't touch the key");
								}
							}
						});
					}
				};
				_timer.schedule(didi, (int)(1000));
			}
		}
		if (chapter_count.equals("2")) {
			if (logs_chat == 5) {
				btnclck = true;
				didi = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								act1.setVisibility(View.VISIBLE);
								act2.setVisibility(View.VISIBLE);
								if (save.getString("lang", "").equals("ru")) {
									act1.setText("Открыть первую комнату");
									act2.setText("Не открывать");
								}
								else {
									act1.setText("Open the first room");
									act2.setText("Don't open");
								}
							}
						});
					}
				};
				_timer.schedule(didi, (int)(1000));
			}
		}
	}
	
	
	public void _tothetimer() {
		if (chapter_count.equals("1")) {
			if (logs_chat == 5) {
				_out();
			}
			if (logs_chat == 16) {
				imageview3.setVisibility(View.VISIBLE);
			}
			if (logs_chat == 19) {
				imageview4.setImageResource(R.drawable.room2);
			}
			if (logs_chat == 22) {
				imageview4.setImageResource(R.drawable.room3);
			}
			if (logs_chat == 24) {
				imageview4.setImageResource(R.drawable.room4);
			}
			if (logs_chat == 25) {
				linear3.setVisibility(View.INVISIBLE);
				SoundID = sounds.load(getApplicationContext(), R.raw.opendoor, 1);
				SoundID = sounds.play((int)(SoundID), 1.0f, 1.0f, 1, (int)(0), 1.0f);
			}
			if (logs_chat == 26) {
				linear3.setVisibility(View.VISIBLE);
			}
			if (logs_chat == 27) {
				_lestnitsa();
			}
		}
		if (chapter_count.equals("2")) {
			_music();
			if (logs_chat == 0) {
				linear3.setVisibility(View.INVISIBLE);
			}
			if (logs_chat == 1) {
				linear3.setVisibility(View.VISIBLE);
			}
			if (logs_chat == 10) {
				imageview4.setImageResource(R.drawable.act2_room1);
			}
			if (logs_chat == 29) {
				imageview4.setImageResource(R.drawable.act2_room2);
			}
			if (logs_chat == 32) {
				imageview4.setImageResource(R.drawable.act2_room3);
			}
		}
	}
	
	
	public void _lestnitsa() {
		imageview4.setTranslationY((float)(0));
		chk_lestnitsa = true;
		textview1.setText("");
		anim22 = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						imageview4.setX((float)xiv);
						imageview4.setY((float)yiv);
						anim22 = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										imageview4.setTranslationY((float)(imageview4.getTranslationY() + 30));
										if (1000 < imageview4.getTranslationY()) {
											imageview4.setTranslationY((float)(-2000));
											animb = true;
											imageview4.setImageResource(R.drawable.room1);
										}
										if ((imageview4.getTranslationY() > 0) && animb) {
											anim22.cancel();
											anim22 = new TimerTask() {
												@Override
												public void run() {
													runOnUiThread(new Runnable() {
														@Override
														public void run() {
															imageview4.setTranslationY((float)(imageview4.getTranslationY() + 30));
															if (imageview4.getTranslationY() > 100) {
																anim22.cancel();
																chk_lestnitsa = false;
																if (false) {
																	_gotext(list_texts.get((int)(logs_chat)));
																}
															}
														}
													});
												}
											};
											_timer.scheduleAtFixedRate(anim22, (int)(0), (int)(20));
										}
									}
								});
							}
						};
						_timer.scheduleAtFixedRate(anim22, (int)(0), (int)(20));
					}
				});
			}
		};
		_timer.schedule(anim22, (int)(100));
	}
	
	
	public void _music() {
		if (logs_chat == 0) {
			if (media.isPlaying()) {
				media.pause();
				media.reset();
			}
			media = MediaPlayer.create(getApplicationContext(), R.raw.your_bright_side);
			media.start();
		}
		if (logs_chat == 11) {
			if (media.isPlaying()) {
				media.pause();
				media.reset();
			}
			media = MediaPlayer.create(getApplicationContext(), R.raw.no_tresspassing);
			media.start();
		}
		if (logs_chat == 21) {
			if (media.isPlaying()) {
				media.pause();
				media.reset();
			}
			media = MediaPlayer.create(getApplicationContext(), R.raw.afterword);
			media.start();
		}
	}
	
	
	public void _gotext(final String _text) {
		check = false;
		text1 = _text;
		nums = 0;
		_tothetimer();
		anim = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (nums > text1.length()) {
							check = true;
							anim.cancel();
							_thentimer();
							logs_chat++;
							textview1.setText(text1);
							if (list_texts.size() == logs_chat) {
								chk_lestnitsa = true;
								ant = new TimerTask() {
									@Override
									public void run() {
										runOnUiThread(new Runnable() {
											@Override
											public void run() {
												_ends();
											}
										});
									}
								};
								_timer.schedule(ant, (int)(1000));
							}
						}
						else {
							if (!chk_lestnitsa) {
								textview1.setText(text1.substring((int)(0), (int)(nums)));
								nums++;
							}
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(anim, (int)(0), (int)(speed_text));
	}
}
