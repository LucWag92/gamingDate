class TextProvider {
  static Map<String, String> _texts = {
    'login': 'Login',
    'email': 'E-Mail',
    'password': 'Password'
  };

  String get textLogin {
    return _texts['login'];
  }

  String get textEmail {
    return _texts['email'];
  }

  String get textPassword {
    return _texts['password'];
  }
}
