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

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private String ID;
    static final String TAG = "amplifydisposablesnullexample:TestRunner";
    private String EMAIL = ID + "@test.com";
    private String LOGIN = ID;
    private String PASSWORD = "EXAMPLE12354";

    @Before
    public void before() {
        ID = UUID.randomUUID().toString();
        EMAIL = ID + "@test.com";
        LOGIN = ID;
        PASSWORD = "EXAMPLE12354";
        clear();
    }

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    public void init() {
        Log.d(TAG, "init started");
        if (!checkAuth()) {
            fail("auth failed");
        }
        CompletableFuture<HubEvent<?>> readyFuture = new CompletableFuture<>();
        Amplify.Hub.subscribe(HubChannel.DATASTORE,
                event -> DataStoreChannelEventName.READY.toString().equals(event.getName()),
                readyFuture::complete);

        Log.d(TAG, "begin start");
        Amplify.DataStore.start(
                () -> Log.d(TAG, "Amplify DataStore sync explicitly initiated."),
                error -> Log.e(TAG, "Amplify DataStore sync did not initiate.", error)
        );

        try {
            readyFuture.get();
            Log.d(TAG, "start finished");
        } catch (ExecutionException | InterruptedException e) {
            fail(e.getMessage());
        }
        Log.d(TAG, "init finished");
    }

    public void clear() {
        Log.d(TAG, "clear started");
        unbindSubscriptionHooks();
        signOut();
        clearDatastore();
    }

    public void signOut() {
        CompletableFuture<Void> signOutComplete = new CompletableFuture<>();
        Log.d(TAG, "begin signOut");
        Amplify.Auth.signOut(() -> signOutComplete.complete(null), e -> fail(e.getMessage()));
        signOutComplete.join();
        Log.d(TAG, "end signOut");
    }

    public void clearDatastore() {
        CompletableFuture<Void> clearComplete = new CompletableFuture<>();
        Log.d(TAG, "begin clear");
        Amplify.DataStore.clear(
                () -> clearComplete.complete(null),
                e -> fail(e.getMessage())
        );
        clearComplete.join();
        Log.d(TAG, "clear finished");
    }

//    @After
//    public void after() {
//        clear();
//    }

    public void test() {
        Log.i(TAG, "starting test");

        init();

        bindSubscriptionHooks();

        CompletableFuture<AmplifyBug> createFuture = new CompletableFuture<>();

        AmplifyBug createRecord = AmplifyBug.builder().updated(Boolean.FALSE).build();
        Amplify.DataStore.save(
                createRecord,
                success -> createFuture.complete(success.item()),
                createFuture::completeExceptionally
        );
        try {
            createFuture.get();
        } catch (ExecutionException | InterruptedException e) {
            Log.e(TAG, "failed to transact record", e);
            fail(e.getMessage());
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
        }
    }

    /**
     * Turn off events.
     */
    private void unbindSubscriptions() {
        subscriptions.forEach(this::unbindSubscription);
        subscriptions = new ArrayList<>();
    }

    ArrayList<Cancelable> subscriptions = new ArrayList<>();

    /**
     * Observes Profile model to see if basal rate has changed
     */
    private <T extends Model> Cancelable bindSubscription(Class<T> m) {
        CompletableFuture<Cancelable> hook = new CompletableFuture<>();
        Amplify.DataStore.observe(m,
                hook::complete,
                onChange -> {
                    if (!onChange.type().equals(DataStoreItemChange.Type.CREATE)) {
                        Log.i(TAG, m.getName() + " model created!");
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
        unbindSubscriptions();
    }

    /**
     * Enables Datastore subscriptions
     */
    private void bindSubscriptionHooks()
    {
        bindSubscription(AmplifyBug.class);
        bindSubscription(Model02.class);
        bindSubscription(Model03.class);
        bindSubscription(Model04.class);
        bindSubscription(Model05.class);
        bindSubscription(Model06.class);
        bindSubscription(Model07.class);
        bindSubscription(Model08.class);
        bindSubscription(Model09.class);
        bindSubscription(Model10.class);
        bindSubscription(Model11.class);
        bindSubscription(Model12.class);
        bindSubscription(Model13.class);
        bindSubscription(Model14.class);
        bindSubscription(Model15.class);
        bindSubscription(Model16.class);
        bindSubscription(Model17.class);
        bindSubscription(Model18.class);
        bindSubscription(Model19.class);
        bindSubscription(Model20.class);
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
