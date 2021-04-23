import 'package:flutter_test/flutter_test.dart';
import 'package:gaming_date/model/onlinestatus.dart';
import 'package:gaming_date/model/profile.dart';

void main() {
  test('Constructor and getter', () {
    final Profile profile = Profile('id', OnlineStatus(null, null),
        'profileName', '_profileImageUrl', List.empty(), List.empty());
    expect(profile.profileId, 'id');
    expect(profile.onlineStatus, isNot(null));
    expect(profile.profileName, 'profileName');
    expect(profile.profileImageUrl, '_profileImageUrl');
    expect(profile.gameDates, isNot(null));
    expect(profile.friendList, isNot(null));
  });
}
