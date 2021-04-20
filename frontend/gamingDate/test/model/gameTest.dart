import 'package:flutter_test/flutter_test.dart';
import 'package:gamingDate/model/game.dart';

void main() {
  test('Constructor and getter', () {
    final Game game = Game(0, 'gameName', 'gameLogoUrl', DateTime(1989, 11, 9),
        DateTime(1989, 12, 9), 0);
    expect(game.gameId, 0);
    expect(game.gameName, 'gameName');
    expect(game.gameLogoUrl, 'gameLogoUrl');
    expect(game.startTime, DateTime(1989, 11, 9));
    expect(game.endTime, DateTime(1989, 12, 9));
    expect(game.rating, 0);
  });
}
