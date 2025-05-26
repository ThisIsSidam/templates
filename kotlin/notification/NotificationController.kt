
package app.tool.box.core.services

import AlertChannel
import android.Manifest
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

object NotificationController {

    @RequiresApi(Build.VERSION_CODES.O)
    fun createNotificationChannel(context: Context) {
        val notificationManager: NotificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        for (alertChannel in AlertChannel.entries){
            notificationManager.createNotificationChannel(alertChannel.toChannel())
        }
    }

    fun showNotification(context: Context, alertChannel: AlertChannel, title: String, subtitle: String) {
        val builder = NotificationCompat.Builder(context, alertChannel.id)
            .setSmallIcon(android.R.drawable.star_on)
            .setContentTitle(title)
            .setContentText(subtitle)
            .setPriority(NotificationCompat.PRIORITY_MAX)

        with(NotificationManagerCompat.from(context)) {
            if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return
            }
            notify(1, builder.build())
        }
    }
}
