package com.example.android.sunshine.app.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.example.android.sunshine.app.sync.SunshineSyncAdapter;


public class TodayWidgetProvider extends AppWidgetProvider {

  @Override
  public void onAppWidgetOptionsChanged(Context context,
                                        AppWidgetManager appWidgetManager,
                                        int appWidgetId, Bundle newOptions) {
    startTodayWidgetIntentService(context);
  }


  @Override
  public void onReceive(@NonNull Context context, @NonNull Intent intent) {
    super.onReceive(context, intent);
    if (SunshineSyncAdapter.ACTION_DATA_UPDATED.equals(intent.getAction())) {
      startTodayWidgetIntentService(context);
    }
  }

  public void onUpdate(Context context, AppWidgetManager appWidgetManager,
                       int[] appWidgetIds) {

    startTodayWidgetIntentService(context);
  }

  private void startTodayWidgetIntentService(Context context) {
    context.startService(new Intent(context, TodayWidgetIntentService.class));

  }

}
