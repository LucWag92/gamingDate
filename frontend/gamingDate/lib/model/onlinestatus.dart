import 'package:gamingDate/model/onlineStatusEnum.dart';

class OnlineStatus {
  int _onlineStatusId;
  OnlineStatusEnum _onlineStatus;

  OnlineStatus(this._onlineStatusId, this._onlineStatus);

  OnlineStatusEnum get onlineStatus => _onlineStatus;

  int get onlineStatusId => _onlineStatusId;
}
