package com.zxjdev.smile.presentation.application.util.ui;

import android.content.Context;
import android.widget.Toast;

/**
 * Shows error messages to user
 */
public class ErrorMessagePrinter {

  private Context context;

  public ErrorMessagePrinter(Context context) {
    this.context = context;
  }

  public void print(String message) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
  }
}
