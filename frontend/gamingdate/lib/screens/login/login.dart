import 'package:flutter/material.dart';
import 'package:gamingdate/screens/login/loginController.dart';
import 'package:gamingdate/util/commonwidgets.dart';
import 'package:gamingdate/util/textprovider.dart';

class Login extends StatefulWidget {
  Login({Key key}) : super(key: key);
  @override
  _LoginPageState createState() => _LoginPageState();
}

class _LoginPageState extends State<Login> {
  TextProvider textProvider = TextProvider();
  CommonWidgets commonWidgets = CommonWidgets();
  final LoginController loginPageController = LoginController();
  final TextEditingController emailController = TextEditingController();
  final TextEditingController passwordController = TextEditingController();

  BuildContext _scaffoldContext;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: commonWidgets.buildAppBarNoBackButton(textProvider.textLogin),
      body: Padding(
        padding: const EdgeInsets.all(2.0),
        child: Align(
          alignment: Alignment.topCenter,
          child: SizedBox(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.center,
              children: <Widget>[
                commonWidgets.buildTextinputFieldContainer(
                  emailController,
                  textProvider.textEmail,
                  Icons.account_box,
                ),
                commonWidgets.buildTextinputFieldContainer(
                  passwordController,
                  textProvider.textPassword,
                  Icons.vpn_key,
                ),
                Builder(builder: (BuildContext context) {
                  _scaffoldContext = context;
                  return commonWidgets.buildRaisedButton(
                      textProvider.textLogin,
                      () => loginPageController.getCustomerIdByEmailAndPassword(
                          _scaffoldContext,
                          emailController.text,
                          passwordController.text,
                          context));
                }),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
