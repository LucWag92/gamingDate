import 'package:flutter/material.dart';

class StyleConfig {
  final Color textColor = Colors.black;
  final Color mainColor = Colors.green[200];
  final double headingFontSize = 20.0;
  final double buttonFontSize = 10.0;
  final double normalFontSize = 10.0;

  TextStyle getHeadingStyle() {
    return TextStyle(
        fontSize: headingFontSize,
        color: textColor,
        fontWeight: FontWeight.bold);
  }

  TextStyle getButtonTextStyle() {
    return TextStyle(fontSize: buttonFontSize, color: textColor);
  }
}
