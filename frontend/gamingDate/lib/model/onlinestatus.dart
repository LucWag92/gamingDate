import 'package:gamingDate/model/onlineStatusEnum.dart';

class OnlineStatus {
  String _onlineStatusId;
  OnlineStatusEnum _onlineStatus;

  OnlineStatus(this._onlineStatusId, this._onlineStatus);

  OnlineStatusEnum get onlineStatus => _onlineStatus;

  String get onlineStatusId => _onlineStatusId;
}
