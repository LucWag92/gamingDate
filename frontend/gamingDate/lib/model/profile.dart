import 'package:gaming_date/model/game.dart';
import 'package:gaming_date/model/onlinestatus.dart';

class Profile {
  String _profileId;
  OnlineStatus _onlineStatus;
  String _profileName;
  String _profileImageUrl;
  List<Game> _gameDates;
  List<Profile> _friendList;

  Profile(this._profileId, this._onlineStatus, this._profileName,
      this._profileImageUrl, this._gameDates, this._friendList);

  String get profileId => _profileId;

  OnlineStatus get onlineStatus => _onlineStatus;

  String get profileName => _profileName;

  String get profileImageUrl => _profileImageUrl;

  List<Game> get gameDates => _gameDates;

  List<Profile> get friendList => _friendList;
}
