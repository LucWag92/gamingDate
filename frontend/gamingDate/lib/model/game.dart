class Game {
  int _gameId;
  String _gameName;
  String _gameLogoUrl;
  DateTime _startTime;
  DateTime _endTime;
  int _rating;

  Game(this._gameId, this._gameName, this._gameLogoUrl, this._startTime,
      this._endTime, this._rating);

  int get gameId => _gameId;

  String get gameName => _gameName;

  int get rating => _rating;

  DateTime get endTime => _endTime;

  DateTime get startTime => _startTime;

  String get gameLogoUrl => _gameLogoUrl;
}
