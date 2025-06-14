package com.github.debacodex.helper;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.provider.Settings;

import androidx.core.app.NotificationCompat;

import com.github.debacodex.R;

public class NotificationHelper {
	
	public static final String NOTIFICATION_CHANNEL_ID = "10001";
	private final Context mContext;
	private NotificationManager mNotificationManager;
	private NotificationCompat.Builder mBuilder;
	
	public NotificationHelper(Context context) {
		mContext = context;
	}
	
	/**
	* Create and push the notification
	*/
	public void createNotification(String title, String message) {
		
		mBuilder = new NotificationCompat.Builder(mContext);
		mBuilder.setSmallIcon(R.mipmap.ic_launcher);
		mBuilder.setContentTitle(title)
		.setGroup("GROUP_KEY_EMAILS")
		.setContentText(message)
		.setAutoCancel(false)
		.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);
		
		mNotificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
		
		if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
			int importance = NotificationManager.IMPORTANCE_HIGH;
			NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "NOTIFICATION_CHANNEL_NAME", importance);
			notificationChannel.enableLights(true);
			notificationChannel.enableVibration(true);
			notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
			assert mNotificationManager != null;
			mBuilder.setChannelId(NOTIFICATION_CHANNEL_ID);
			mNotificationManager.createNotificationChannel(notificationChannel);
		}
		assert mNotificationManager != null;
		mNotificationManager.notify(0 /* Request Code */, mBuilder.build());
	}
}