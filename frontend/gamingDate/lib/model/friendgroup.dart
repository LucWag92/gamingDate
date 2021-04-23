import 'package:gamingDate/model/game.dart';
import 'package:gamingDate/model/profile.dart';

class FriendGroup {
  String _friendGroupId;
  String _friendGroupName;
  Game _lastFavouriteGame;
  List<Profile> _members;

  FriendGroup(this._friendGroupId, this._friendGroupName, this._lastFavouriteGame, this._members);

  String get friendGroupId => _friendGroupId;

  List<Profile> get members => _members;

  Game get lastFavouriteGame => _lastFavouriteGame;

  String get friendGroupName => _friendGroupName;
}