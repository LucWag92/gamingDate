import 'package:gamingDate/model/accountdata.dart';
import 'package:gamingDate/model/profile.dart';

class User {
  int _userId;
  AccountData _accountData;
  Profile _profile;

  User(this._userId, this._accountData, this._profile);

  int get userId => _userId;
  Profile get profile => _profile;
  AccountData get accountData => _accountData;

}
