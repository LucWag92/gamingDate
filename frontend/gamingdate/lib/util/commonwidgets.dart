import 'package:flutter/material.dart';
import 'package:gamingdate/util/styleconfig.dart';

class CommonWidgets {
  StyleConfig styleConfig = StyleConfig();
  /*
  AppBar (Top Bar)
  */

  AppBar buildAppBar(String title) {
    return AppBar(
      title: Text(title, style: StyleConfig().getHeadingStyle()),
      backgroundColor: styleConfig.mainColor,
    );
  }

  AppBar buildAppBarNoBackButton(String title) {
    return AppBar(
      automaticallyImplyLeading: false,
      title: Text(title, style: StyleConfig().getHeadingStyle()),
      backgroundColor: styleConfig.mainColor,
    );
  }

  Container buildTextinputFieldContainer(
      TextEditingController controller, String labelText, IconData icon) {
    return Container(
      padding: EdgeInsets.symmetric(horizontal: 10, vertical: 5),
      decoration: BoxDecoration(
          color: StyleConfig().mainColor,
          border: Border.all(color: StyleConfig().mainColor)),
      child: TextField(
        controller: controller,
        style: TextStyle(color: StyleConfig().textColor),
        decoration: InputDecoration(
            contentPadding: EdgeInsets.symmetric(horizontal: 10),
            labelText: labelText,
            labelStyle: TextStyle(color: StyleConfig().textColor),
            border: InputBorder.none),
        //icon: todo
      ),
    );
  }

  ElevatedButton buildRaisedButton(String text, Function onPressedFunction) {
    return ElevatedButton(
      onPressed: onPressedFunction,
      child: Text(text, style: styleConfig.getButtonTextStyle()),
    );
  }
}
