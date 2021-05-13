import 'package:flutter/material.dart';
import 'package:gamingdate/screens/login/login.dart';
import 'package:gamingdate/screens/login/loginservice.dart';

class LoginController {
  LoginService loginService = LoginService();

  Future getCustomerIdByEmailAndPassword(BuildContext scaffoldcontext,
      String email, String password, BuildContext context) async {
    debugPrint("Trying login for: " + email + " - " + password);

    if (email == null || password == null) {
      Scaffold.of(scaffoldcontext).showSnackBar(SnackBar(
        content: Text('Email or Password cant be empty'),
      ));
      return 'error';
    }
    await loginService
        .getCustomerIdByEmailAndPassword(email, password)
        .then((value) {
      if (value != 0) {
        debugPrint("Successful login for: " + email + " - " + password);
        Navigator.push(
          context,
          new MaterialPageRoute(builder: (ctxt) => new Login()),
        );
      } else {
        debugPrint("Error when trying to login for: " +
            email +
            " - " +
            password +
            ": error");
        //todo error
      }
    });
  }
}
