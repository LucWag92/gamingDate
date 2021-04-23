import 'package:flutter_test/flutter_test.dart';
import 'package:gamingDate/model/friendgroup.dart';
import 'package:gamingDate/model/game.dart';

void main() {
  test('Constructor and getter', () {
    final FriendGroup friendGroup = FriendGroup('id', 'friendGroupName',
        Game(null, null, null, null, null, null), List.empty());
    expect(friendGroup.friendGroupId, 'id');
    expect(friendGroup.friendGroupName, 'friendGroupName');
    expect(friendGroup.lastFavouriteGame, isNot(null));
    expect(friendGroup.members, isNot(null));
  });
}
