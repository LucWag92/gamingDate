class AccountData {
  String _accountDataId;
  String _email;
  String _password;

  AccountData(this._accountDataId, this._email, this._password);

  String get accountDataId => _accountDataId;

  String get email => _email;

  String get password => _password;
}
