package com.example.amplifydisposablesnullexample;

import static org.junit.Assert.fail;

import android.util.Log;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.amplifyframework.auth.AuthSession;
import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.auth.result.AuthSignInResult;
import com.amplifyframework.auth.result.AuthSignUpResult;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.async.Cancelable;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.datastore.DataStoreChannelEventName;
import com.amplifyframework.datastore.DataStoreItemChange;
import com.amplifyframework.datastore.generated.model.AmplifyBug;
import com.amplifyframework.datastore.generated.model.Model02;
import com.amplifyframework.datastore.generated.model.Model03;
import com.amplifyframework.datastore.generated.model.Model04;
import com.amplifyframework.datastore.generated.model.Model05;
import com.amplifyframework.datastore.generated.model.Model06;
import com.amplifyframework.datastore.generated.model.Model07;
import com.amplifyframework.datastore.generated.model.Model08;
import com.amplifyframework.datastore.generated.model.Model09;
import com.amplifyframework.datastore.generated.model.Model10;
import com.amplifyframework.datastore.generated.model.Model11;
import com.amplifyframework.datastore.generated.model.Model12;
import com.amplifyframework.datastore.generated.model.Model13;
import com.amplifyframework.datastore.generated.model.Model14;
import com.amplifyframework.datastore.generated.model.Model15;
import com.amplifyframework.datastore.generated.model.Model16;
import com.amplifyframework.datastore.generated.model.Model17;
import com.amplifyframework.datastore.generated.model.Model18;
import com.amplifyframework.datastore.generated.model.Model19;
import com.amplifyframework.datastore.generated.model.Model20;
import com.amplifyframework.hub.HubChannel;
import com.amplifyframework.hub.HubEvent;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private String ID;
    private String TAG = "amplify:bug";
    private String EMAIL = ID + "@test.com";
    private String LOGIN = ID;
    private String PASSWORD = "EXAMPLE12354";

    @Before
    public void before() {
        ID = UUID.randomUUID().toString();
        TAG = "amplify:bug";
        EMAIL = ID + "@test.com";
        LOGIN = ID;
        PASSWORD = "EXAMPLE12354";
        clear();
    }

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    public void init() {
        if (!checkAuth()) {
            fail("auth failed");
        };
        CompletableFuture<HubEvent<?>> readyFuture = new CompletableFuture<>();
        Amplify.Hub.subscribe(HubChannel.DATASTORE,
                event -> DataStoreChannelEventName.SYNC_QUERIES_READY.toString().equals(event.getName()),
                readyFuture::complete);

        Amplify.DataStore.start(
                () -> Log.d("main", "Amplify DataStore sync explicitly initiated."),
                error -> Log.e("main", "Amplify DataStore sync did not initiate.", error)
        );

        try {
            readyFuture.get();
        } catch (ExecutionException | InterruptedException e) {
            fail(e.getMessage());
        }
    }

    public void clear() {
        unbindSubscriptionHooks();
        CompletableFuture<Void> signOutComplete = new CompletableFuture<>();
        CompletableFuture<Void> clearComplete = new CompletableFuture<>();
        Amplify.Auth.signOut(() -> signOutComplete.complete(null), e -> fail(e.getMessage()));
        Amplify.DataStore.clear(
                () -> {
                    Log.d("main", "Amplify DataStore clear explicitly initiated.");
                    clearComplete.complete(null);
                },
                e -> fail(e.getMessage())
        );
        signOutComplete.join();
        clearComplete.join();
    }

    public void test() {
        Log.i(TAG, "starting test");

        init();

        bindSubscriptionHooks();

        CompletableFuture<AmplifyBug> createFuture = new CompletableFuture<>();
        CompletableFuture<AmplifyBug> updateFuture = new CompletableFuture<>();

        AmplifyBug createRecord = AmplifyBug.builder().updated(Boolean.FALSE).build();
        Amplify.DataStore.save(
                createRecord,
                success -> createFuture.complete(success.item()),
                createFuture::completeExceptionally
        );
        try {
            AmplifyBug createRecordReturned = createFuture.get();

            AmplifyBug updateRecord = createRecordReturned.copyOfBuilder().updated(Boolean.TRUE).build();
            Amplify.DataStore.save(
                    updateRecord,
                    success -> updateFuture.complete(success.item()),
                    updateFuture::completeExceptionally
            );
            updateFuture.get();
        } catch (ExecutionException | InterruptedException e) {
            Log.e(TAG, "failed to transact record", e);
            fail(e.getMessage());
        }


        try {
            Thread.sleep(5000); // sleep for 5 seconds to accumulate logs
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.i(TAG, "finishing test");
    }

    @Test
    public void test01() {
        test();
    }

    @Test
    public void test02() {
        test();
    }

    @Test
    public void test03() {
        test();
    }

    @Test
    public void test04() {
        test();
    }

    @Test
    public void test05() {
        test();
    }

    @Test
    public void test06() {
        test();
    }

    @Test
    public void test07() {
        test();
    }

    @Test
    public void test08() {
        test();
    }

    @Test
    public void test09() {
        test();
    }

    @Test
    public void test10() {
        test();
    }

    @Test
    public void test11() {
        test();
    }

    @Test
    public void test12() {
        test();
    }

    @Test
    public void test13() {
        test();
    }

    @Test
    public void test14() {
        test();
    }

    @Test
    public void test15() {
        test();
    }

    @Test
    public void test16() {
        test();
    }

    @Test
    public void test17() {
        test();
    }

    @Test
    public void test18() {
        test();
    }

    @Test
    public void test19() {
        test();
    }

    @Test
    public void test20() {
        test();

    }
    /**
     * Turn off events.
     */
    private void unbindSubscription(Cancelable c) {
        if (null != c) {
            c.cancel();
            c = null;
        }
    }

    Cancelable m1 = null;
    Cancelable m2 = null;
    Cancelable m3 = null;
    Cancelable m4 = null;
    Cancelable m5 = null;
    Cancelable m6 = null;
    Cancelable m7 = null;
    Cancelable m8 = null;
    Cancelable m9 = null;
    Cancelable m10 = null;
    Cancelable m11 = null;
    Cancelable m12 = null;
    Cancelable m13 = null;
    Cancelable m14 = null;
    Cancelable m15 = null;
    Cancelable m16 = null;
    Cancelable m17 = null;
    Cancelable m18 = null;
    Cancelable m19 = null;
    Cancelable m20 = null;

    /**
     * Observes Profile model to see if basal rate has changed
     */
    private <T extends Model> Cancelable bindSubscription(Class<T> m) {
        CompletableFuture<Cancelable> hook = new CompletableFuture<>();
        Amplify.DataStore.observe(m,
                hook::complete,
                onChange -> {
                    if (!onChange.type().equals(DataStoreItemChange.Type.CREATE)) {
                        Log.i(TAG, "Bump");
                    }
                },
                hook::completeExceptionally,
                () -> Log.i(TAG, "Subscription Completed")
        );
        try
        {
            return hook.get();
        }
        catch (ExecutionException | InterruptedException e)
        {
            Log.e(TAG, "Could not bind subscription", e);
        }
        return null;
    }

    /**
     * Disables Datastore Subscriptions
     */
    private void unbindSubscriptionHooks()
    {
        unbindSubscription(m1);
        unbindSubscription(m2);
        unbindSubscription(m3);
        unbindSubscription(m4);
        unbindSubscription(m5);
        unbindSubscription(m6);
        unbindSubscription(m7);
        unbindSubscription(m8);
        unbindSubscription(m9);
        unbindSubscription(m10);
        unbindSubscription(m11);
        unbindSubscription(m12);
        unbindSubscription(m13);
        unbindSubscription(m14);
        unbindSubscription(m15);
        unbindSubscription(m16);
        unbindSubscription(m17);
        unbindSubscription(m18);
        unbindSubscription(m19);
        unbindSubscription(m20);
    }

    /**
     * Enables Datastore subscriptions
     */
    private void bindSubscriptionHooks()
    {
        m1 = bindSubscription(AmplifyBug.class);
        m2 = bindSubscription(Model02.class);
        m3 = bindSubscription(Model03.class);
        m4 = bindSubscription(Model04.class);
        m5 = bindSubscription(Model05.class);
        m6 = bindSubscription(Model06.class);
        m7 = bindSubscription(Model07.class);
        m8 = bindSubscription(Model08.class);
        m9 = bindSubscription(Model09.class);
        m10 = bindSubscription(Model10.class);
        m11 = bindSubscription(Model11.class);
        m12 = bindSubscription(Model12.class);
        m13 = bindSubscription(Model13.class);
        m14 = bindSubscription(Model14.class);
        m15 = bindSubscription(Model15.class);
        m16 = bindSubscription(Model16.class);
        m17 = bindSubscription(Model17.class);
        m18 = bindSubscription(Model18.class);
        m19 = bindSubscription(Model19.class);
        m20 = bindSubscription(Model20.class);
    }

    private boolean checkAuth() {
        if (null == LOGIN || null == PASSWORD || null == EMAIL) {
            Log.i(TAG, "no credentials to Auth");
        }
        try {
            AuthSession session = getSession();
            if(session.isSignedIn()) {
                Log.i(TAG, "isSignedIn");
                return true;
            }
        }
        catch (ExecutionException | InterruptedException e) {
            Log.e(TAG, "authSession exception", e);
        }

        try {
            AuthSignInResult signInResult = signIn(LOGIN, PASSWORD);
            if(signInResult.isSignInComplete()) {
                Log.i(TAG, "SignInComplete");
            } else {
                Log.w(TAG, "Unexpected SignIn nextStep: " + signInResult.getNextStep());
            }
            return true;
        } catch (ExecutionException | InterruptedException e) {
            Throwable t = e.getCause();
            // if the excetion isn't use not found then we are done otherwise, we can continue to try to signUp
            if (null != t && !"User not found in the system.".equals(t.getMessage())) {
                Log.e(TAG, "signIn exception", e);
            }
        }
        try {
            AuthSignUpResult signUpResult = signUp(LOGIN, PASSWORD, EMAIL);
            if (signUpResult.isSignUpComplete()) {
                // call to get a session now
                return this.checkAuth();
            } else {
                Log.w(TAG, "Unexpected signUp nextStep: " + signUpResult.getNextStep());
            }
        } catch (ExecutionException | InterruptedException e) {
            Log.e(TAG, "Failed signUp", e);
        }
        return false;
    }


    private static AuthSession getSession() throws ExecutionException, InterruptedException
    {
        CompletableFuture<AuthSession> qsession = new CompletableFuture<>();
        Amplify.Auth.fetchAuthSession(qsession::complete, qsession::completeExceptionally);
        return qsession.get();
    }

    private static AuthSignInResult signIn(String login, String password) throws ExecutionException, InterruptedException
    {
        CompletableFuture<AuthSignInResult> qresult = new CompletableFuture<>();
        Amplify.Auth.signIn(login, password, qresult::complete, qresult::completeExceptionally);
        return qresult.get();
    }

    private static AuthSignUpResult signUp(String login, String password, String email) throws ExecutionException, InterruptedException
    {
        AuthSignUpOptions options = AuthSignUpOptions.builder().userAttribute(AuthUserAttributeKey.email(), email).build();
        CompletableFuture<AuthSignUpResult> qresult = new CompletableFuture<>();
        Amplify.Auth.signUp(login, password, options, qresult::complete, qresult::completeExceptionally);
        return qresult.get();
    }
}
