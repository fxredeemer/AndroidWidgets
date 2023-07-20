package com.example.simplewatch

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews
import java.text.SimpleDateFormat
import java.util.Date

class WatchWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd kk:mm")
    val currentDate = dateFormat.format(Date())

    val views = RemoteViews(context.packageName, R.layout.watch_widget)
    views.setTextViewText(R.id.appwidget_text, currentDate)

    appWidgetManager.updateAppWidget(appWidgetId, views)
}