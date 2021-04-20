class AccountData {
  int _accountDataId;
  String _email;
  String _password;

  AccountData(this._accountDataId, this._email, this._password);

  int get accountDataId => _accountDataId;

  String get email => _email;

  String get password => _password;
}
