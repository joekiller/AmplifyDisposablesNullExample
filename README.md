After you `amplfiy push` the first time with the auth make sure you `amplify pull` to get updated
auth tokens in `src/main/res/raw/awsconfiguration.json`

 ./gradlew clean connectedDebugAndroidTest

Infrastructure was generated with CLI:

    npm install -g @aws-amplify/cli@5.3.0

Reported in 1.23.0: https://github.com/aws-amplify/amplify-android/issues/1444

Fixed via https://github.com/aws-amplify/amplify-android/pull/1570

Released in v.1.29.1 https://github.com/aws-amplify/amplify-android/releases/tag/release_v1.29.1
